package com.user.wechat.service.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
@Data
@Entity
@DynamicUpdate
@Table(name = "t_member")
public class MemberDO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "member_id")
    private String memberId;
    @Column(name = "open_id")
    private String openId;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "gender")
    private int gender;
    @Column(name = "phone")
    private String phone;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;

}
