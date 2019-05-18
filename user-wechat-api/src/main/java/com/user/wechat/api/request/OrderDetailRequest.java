package com.user.wechat.api.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghuachang
 * @date 2019-05-11
 */
@Data
public class OrderDetailRequest implements Serializable {

    private static final long serialVersionUID = -5150304395280543751L;
    private String productId;
    private String productName;
    private Integer productCount;

}
