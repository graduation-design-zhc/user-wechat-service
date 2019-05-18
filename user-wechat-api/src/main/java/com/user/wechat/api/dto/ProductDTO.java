package com.user.wechat.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhanghuachang
 * @date 2019-05-14
 */
@Data
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -4845226736160188392L;
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private String productStock;
    private String productDescription;
    private String productImg;
    private Integer productStatus;
    private Integer categoryType;
    private String createTime;
    private String updateTime;
}


