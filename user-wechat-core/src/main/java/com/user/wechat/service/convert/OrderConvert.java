package com.user.wechat.service.convert;

import com.user.wechat.api.dto.OrderDTO;
import com.user.wechat.api.dto.OrderDetailDTO;
import com.user.wechat.api.dto.OrderLogDTO;
import com.user.wechat.service.model.OrderDO;
import com.user.wechat.service.model.OrderDetailDO;

import java.text.SimpleDateFormat;

/**
 * @author zhanghuachang
 * @date 2019-05-19
 */
public class OrderConvert {

    public static OrderDTO convert(OrderDO orderDO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setMemberId(orderDO.getMemberId());
        orderDTO.setOrderId(orderDO.getOrderId());
        orderDTO.setOrderIntegral(orderDO.getOrderIntegral());
        orderDTO.setOrderPrice(orderDO.getOrderPrice());
        orderDTO.setPayType(orderDO.getPayType());
        orderDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderDO.getCreateTime()));
        return orderDTO;
    }

    public static OrderDetailDTO convert(OrderDetailDO orderDetailDO) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setProductPrice(orderDetailDO.getProductPrice().toString());
        orderDetailDTO.setProductCount(orderDetailDO.getProductCount());
        orderDetailDTO.setProductName(orderDetailDO.getProductName());
        return orderDetailDTO;
    }

}
