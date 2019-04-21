package com.user.wechat.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
@Data
public class MemberDTO implements Serializable {

    private static final long serialVersionUID = -5666322459926440640L;
    private String memberId;
    private String openId;
    private String avatar;
    private Integer gender;
    private String phone;
    private String nickName;
    private String birthday;
    private String createTime;
    private String updateTime;

}
