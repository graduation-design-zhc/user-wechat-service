package com.user.wechat.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -955110175820713836L;

    private String uid;
    private String userName;
    private String createTime;
    private String updateTime;

}
