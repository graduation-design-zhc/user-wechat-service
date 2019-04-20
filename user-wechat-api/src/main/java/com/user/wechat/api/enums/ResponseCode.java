package com.user.wechat.api.enums;

import lombok.Getter;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
@Getter
public enum ResponseCode implements CodeEnum {

    SUCCESS(6000, "成功"),
    FAIL(6001, "失败")
    ;

    private Integer code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
