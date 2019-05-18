package com.user.wechat.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghuachang
 * @date 2019-05-11
 */
@Data
public class OrderDetailDTO implements Serializable {

    private static final long serialVersionUID = -2147328340772078648L;
    private String productName;
    private String productPrice;
    private Integer productCount;

}
