package com.user.wechat.api.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhanghuachang
 * @date 2019-04-29
 */
@Data
public class MemberBalanceRequest implements Serializable {

    private static final long serialVersionUID = 4532951008489706952L;

    private String memberId;
    private BigDecimal memberBalance;
}
