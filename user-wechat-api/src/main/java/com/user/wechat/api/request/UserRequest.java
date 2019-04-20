package com.user.wechat.api.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
@Data
public class UserRequest implements Serializable {

    private static final long serialVersionUID = -2851718576298221497L;

    private String userName;
    private String password;

}
