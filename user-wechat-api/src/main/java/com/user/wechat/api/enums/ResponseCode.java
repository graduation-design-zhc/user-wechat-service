package com.user.wechat.api.enums;

import lombok.Getter;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
@Getter
public enum ResponseCode implements CodeEnum {

    SUCCESS(6000, "请求成功"),
    FAIL(6001, "登录失败，用户名或密码错误"),
    ;

    private Integer code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
