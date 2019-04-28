package com.user.wechat.api.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghuachang
 * @date 2019-04-23
 */
@Data
public class MemberRequest implements Serializable {

    private static final long serialVersionUID = 8888708477963306518L;
    private String memberId;
    private String openId;
    private String avatar;
    private Integer gender;
    private String phone;
    private String nickname;
    private String birthday;

}
