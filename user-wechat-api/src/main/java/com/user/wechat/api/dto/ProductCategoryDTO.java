package com.user.wechat.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghuachang
 * @date 2019-05-14
 */
@Data
public class ProductCategoryDTO implements Serializable {

    private static final long serialVersionUID = -7103768411607574200L;
    private String categoryId;
    private String categoryName;
    private Integer categoryType;

}
