package com.user.wechat.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhanghuachang
 * @date 2019-04-29
 */
@Data
public class MemberCardDTO implements Serializable {

    private static final long serialVersionUID = 7184281356967705171L;

    private String memberCardId;
    private String memberId;
    private BigDecimal memberBalance;
    private Double memberIntegral;
    private String createTime;
    private String updateTime;

}
