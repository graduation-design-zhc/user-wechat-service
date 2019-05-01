package com.user.wechat.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhanghuachang
 * @date 2019-05-01
 */
@Data
public class MemberCardLogDTO implements Serializable {
    private static final long serialVersionUID = 39988295240874371L;

    private String memberCardId;
    private String memberId;
    private BigDecimal addBalance;
    private String operator;
    private String createTime;
    private String updateTime;
}
