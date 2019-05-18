package com.user.wechat.service.convert;

import com.user.wechat.api.dto.ProductCategoryDTO;
import com.user.wechat.service.model.ProductCategoryDO;

/**
 * @author zhanghuachang
 * @date 2019-05-14
 */
public class ProductCategoryConvert {

    public static ProductCategoryDTO convert(ProductCategoryDO productCategoryDO) {
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setCategoryId(productCategoryDO.getCategoryId());
        productCategoryDTO.setCategoryName(productCategoryDO.getCategoryName());
        productCategoryDTO.setCategoryType(productCategoryDO.getCategoryType());
        return  productCategoryDTO;
    }

}
