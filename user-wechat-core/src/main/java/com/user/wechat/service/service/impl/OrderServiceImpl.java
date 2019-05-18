package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.OrderDTO;
import com.user.wechat.api.dto.OrderDetailDTO;
import com.user.wechat.api.request.OrderDetailRequest;
import com.user.wechat.api.request.OrderRequest;
import com.user.wechat.service.enums.ExceptionEnums;
import com.user.wechat.service.enums.PayEnums;
import com.user.wechat.service.exception.BaseException;
import com.user.wechat.service.model.*;
import com.user.wechat.service.repository.*;
import com.user.wechat.service.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhanghuachang
 * @date 2019-05-11
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepository orderRepository;
    @Resource
    private OrderDetailRepository orderDetailRepository;
    @Resource
    private MemberRepository memberRepository;
    @Resource
    private ProductRepository productRepository;
    @Resource
    private MemberCardRepository memberCardRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public OrderDTO memberOrder(OrderRequest orderRequest) {
        //1 订单入库 并支付 支付方式，会员卡支付 扣卡余额并增加积分，现金支付，只增加积分
        OrderDO orderDO = buildOrder(orderRequest);
        // 2 订单详情入库
        buildOrderDetail(orderDO.getOrderId(), orderRequest);
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderDO, orderDTO);
        orderDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderDO.getCreateTime()));
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        orderRequest.getOrderDetailRequests().forEach(e -> {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setProductName(e.getProductName());
            orderDetailDTO.setProductCount(e.getProductCount());
            orderDetailDTOList.add(orderDetailDTO);
        });
        orderDTO.setOrderDetailDTOList(orderDetailDTOList);
        return orderDTO;
    }

    private void buildOrderDetail(String orderId, OrderRequest orderRequest) {
        List<String> productIdList = orderRequest.getOrderDetailRequests()
                .stream()
                .map(OrderDetailRequest :: getProductId)
                .collect(Collectors.toList());
        Map<String, OrderDetailRequest> map = orderRequest.getOrderDetailRequests()
                .stream()
                .collect(Collectors.toMap(OrderDetailRequest::getProductId, Function.identity()));
        List<ProductDO> productDOS = productRepository.findAllByProductIdIsIn(productIdList);
        List<OrderDetailDO> orderDetailDOList = productDOS
                .stream()
                .map(i -> convert(i, map, orderId))
                .collect(Collectors.toList());
        orderDetailRepository.saveAll(orderDetailDOList);
    }

    private OrderDetailDO convert(ProductDO productDO, Map<String, OrderDetailRequest> map, String orderId) {
        OrderDetailDO orderDetailDO = new OrderDetailDO();
        orderDetailDO.setOrderId(orderId);
        orderDetailDO.setProductId(productDO.getProductId());
        orderDetailDO.setProductName(productDO.getProductName());
        orderDetailDO.setProductPrice(productDO.getProductPrice());
        orderDetailDO.setProductCount(map.get(productDO.getProductId()).getProductCount());
        return orderDetailDO;
    }

    private OrderDO buildOrder(OrderRequest orderRequest) {
        MemberDO memberDO = memberRepository.findByPhone(orderRequest.getBuyerPhone());
        if (ObjectUtils.isEmpty(memberDO)) {
            throw new BaseException(ExceptionEnums.MEMBER_NOT_EXIT);
        }
        OrderDO orderDO = new OrderDO();
        String orderId = UUID.randomUUID().toString().replace("-", "");
        orderDO.setOrderId(orderId);
        orderDO.setMemberId(memberDO.getMemberId());
        orderDO.setBuyerName(memberDO.getNickname());
        orderDO.setBuyerOpenId(memberDO.getOpenId());
        orderDO.setBuyerPhone(memberDO.getPhone());
        //计算金额、积分
        AtomicReference<Double> price = new AtomicReference<>(0.0);
        orderRequest.getOrderDetailRequests().forEach(e  -> {
            ProductDO productDO = productRepository.findProductDOByProductId(e.getProductId());
            price.updateAndGet(v -> v + Double.valueOf(e.getProductCount()) * productDO.getProductPrice().doubleValue());
        });
        orderDO.setOrderPrice(new BigDecimal(price.get()));
        //增加的积分与消费金额一致
        orderDO.setOrderIntegral(price.get());
        orderDO.setPayType(orderRequest.getPayType());
        orderDO.setOperator("admin");
        orderDO.setCreateTime(new Date());
        orderDO.setUpdateTime(new Date());
        //入库前  若用户采用会员卡支付，则判断余额是否足够
        if (orderRequest.getPayType() == PayEnums.MEMBER_CARD_PAY.getPayType()) {
            MemberCardDO memberCardDO = memberCardRepository.findByMemberId(orderDO.getMemberId());
            if (memberCardDO.getMemberBalance().compareTo(orderDO.getOrderPrice()) < 0) {
                throw new BaseException(ExceptionEnums.LACK_OF_BALANCE);
            } else {
                // 余额充足
                int i = memberCardRepository.updateBalanceAndIntegral(orderDO.getMemberId(), orderDO.getOrderPrice(), orderDO.getOrderIntegral());
                if (i > 0) {
                    log.info("【会员卡扣款成功！】memberId={}, price={}, integral={}", orderDO.getMemberId(), orderDO.getOrderPrice(), orderDO.getOrderIntegral());
                }
            }
        } else  {
            int i = memberCardRepository.updateBalanceAndIntegral(orderDO.getMemberId(), new BigDecimal(0), orderDO.getOrderIntegral());
            if (i > 0) {
                log.info("【现金支付成功！】memberId={}, price={}, integral={}", orderDO.getMemberId(), orderDO.getOrderPrice(), orderDO.getOrderIntegral());
            }
        }
        return orderRepository.save(orderDO);
    }
}
