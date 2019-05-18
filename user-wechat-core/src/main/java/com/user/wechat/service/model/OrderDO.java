package com.user.wechat.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhanghuachang
 * @date 2019-05-09
 */
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@Table(name = "t_order")
public class OrderDO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "member_id")
    private String memberId;
    @Column(name = "buyer_name")
    private String buyerName;
    @Column(name = "buyer_phone")
    private String buyerPhone;
    @Column(name = "buyer_openid")
    private String buyerOpenId;
    @Column(name = "pay_type")
    private Integer payType;
    @Column(name = "order_price")
    private BigDecimal orderPrice;
    @Column(name = "order_integral")
    private Double orderIntegral;
    @Column(name = "operator")
    private String operator;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
}
