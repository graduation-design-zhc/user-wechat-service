package com.user.wechat.service.convert;

import com.user.wechat.api.dto.ProductDTO;
import com.user.wechat.service.model.ProductDO;

import java.text.SimpleDateFormat;

/**
 * @author zhanghuachang
 * @date 2019-05-14
 */
public class ProductConvert {

    public static ProductDTO convert(ProductDO productDO) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productDO.getProductId());
        productDTO.setProductName(productDO.getProductName());
        productDTO.setProductPrice(productDO.getProductPrice());
        productDTO.setProductStock(productDO.getProductStock());
        productDTO.setCategoryType(productDO.getCategoryType());
        productDTO.setProductStatus(productDO.getProductStatus());
        productDTO.setProductImg(productDO.getProductImg());
        productDTO.setProductDescription(productDO.getProductDescription());
        productDTO.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(productDO.getUpdateTime()));
        productDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(productDO.getCreateTime()));
        return productDTO;
    }

}
