package com.user.wechat.service.enums;

/**
 * @author zhanghuachang
 * @date 2019-04-23
 */
public enum  ExceptionEnums {

    MEMBER_NOT_EXIT(6010, "会员不存在"),
    MEMBER_CARD_NOT_EXIT(6010, "会员卡不存在"),
    MEMBER_IS_EXIT(6020, "会员已绑定"),
    LACK_OF_BALANCE(6030, "会员卡余额不足"),
    PRODUCT_NOT_EXIT(6010, "商品不存在"),
    ;

    private Integer code;
    private String message;

    ExceptionEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
