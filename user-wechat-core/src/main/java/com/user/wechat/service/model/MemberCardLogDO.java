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
 * @date 2019-05-01
 */
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@Table(name = "t_member_card_log")
public class MemberCardLogDO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "member_card_id")
    private String memberCardId;
    @Column(name = "member_id")
    private String memberId;
    @Column(name = "add_balance")
    private BigDecimal addBalance;
    @Column(name = "operator")
    private String operator;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;

}
