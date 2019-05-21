package com.user.wechat.service.repository;

import com.user.wechat.api.request.OrderRequest;
import com.user.wechat.service.MainApplication;
import com.user.wechat.service.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zhanghuachang
 * @date 2019-04-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Resource
    private MemberRepository memberRepository;

    @Resource
    private MemberCardRepository memberCardRepository;

    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Resource
    private ProductRepository productRepository;

    @Resource
    private OrderRepository orderRepository;

    @Test
    public void findUserDOByUserNameAndPassword() {
        UserDO userDO = userRepository.findUserDOByUserNameAndPassword("admin", "admin");
        assert userDO != null;
    }

    @Test
    public void findMember() {
        List<MemberDO> list = memberRepository.findAll();
        assert list.size() > 0;
    }

    @Test
    public void deleteMember() {
        int i = memberRepository.deleteByMemberId("254201fc27cd4a04b6bbae18643c027d");
        System.out.println(i);
    }

    @Test
    public void findAllMemberCreateTime() {
        List<MemberDO> list = memberRepository.findAllByOrderByCreateTimeDesc();
        assert  list.size() > 0;
    }

    @Test
    public void findByOpenId() {
        MemberDO memberDO = memberRepository.findByOpenId("adfniuebfKJFHDFB");
        assert memberDO != null;
    }

    @Test
    public void saveMemberCard() {
        MemberCardDO memberCardDO = new MemberCardDO();
        memberCardDO.setMemberCardId(UUID.randomUUID().toString().replace("-", ""));
        memberCardDO.setMemberId("9e5c9e6b347e4f4c81a37c714cdd807e");
        memberCardDO.setMemberBalance(new BigDecimal(0.0));
        memberCardDO.setMemberIntegral(0.0);
        MemberCardDO save = memberCardRepository.save(memberCardDO);
        assert save != null;
    }

    @Test
    public void findCardByIds() {
        List<String> memberIds = new ArrayList<>();
        memberIds.add("9e5c9e6b347e4f4c81a37c714cdd807e");
        List<MemberCardDO> memberCardDOS = memberCardRepository.findAllByMemberIdIsIn(memberIds);
        System.out.println(memberCardDOS);

    }

    @Test
    public void addBalance() {
        int i = memberCardRepository.addBalance("9e5c9e6b347e4f4c81a37c714cdd807e", new BigDecimal(1));
        System.out.println(i);
    }

    @Test
    public void getProductCategoryList() {
        List<ProductCategoryDO> productCategoryDOList = productCategoryRepository.findAll();
        assert productCategoryDOList != null;
    }

    @Test
    public void getProductByCategoryType() {
        List<ProductDO> productDOList = productRepository.findAllByCategoryType(10001);
        System.out.println(productDOList);
    }

    @Test
    public void insertOrder() {
        OrderDO orderDO = new OrderDO();
        orderDO.setOrderId("57b6cb43a73d43dea41f61f8517ec2cf");
        orderDO.setMemberId("c4528a9fc1304adca9f290c60b1fbb52");
        orderDO.setBuyerName("Z");
        orderDO.setOperator("admin");
        orderDO.setPayType(0);
        orderDO.setBuyerPhone("13277426684");
        orderDO.setBuyerOpenId("owCls1AVyvUTHqHB7eCBH2-F1y1w");
        orderDO.setOrderPrice(new BigDecimal(0));
        orderDO.setOrderIntegral(0.0);
        OrderDO save = orderRepository.save(orderDO);
        System.out.println(save);
    }

    @Test
    public void getOrderLogList() {
        List<OrderDO> orderDOS = orderRepository.findOrderDOSByBuyerPhoneOrderByCreateTimeDesc("13277426684");
        System.out.println(orderDOS);
    }

}