package com.user.wechat.service.enums;

/**
 * 支付类型
 * @author zhanghuachang
 * @date 2019-05-11
 */
public enum PayEnums {

    MEMBER_CARD_PAY(0, "会员卡支付"),
    CASH_PAY(1, "现金支付"),
    ;

    private int payType;
    private String message;

    PayEnums(int payType, String message) {
        this.payType = payType;
        this.message = message;
    }

    public int getPayType() {
        return payType;
    }

    public String getMessage() {
        return message;
    }

}
