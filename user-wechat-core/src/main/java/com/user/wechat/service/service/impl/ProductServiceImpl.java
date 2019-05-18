package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.ProductDTO;
import com.user.wechat.service.convert.ProductConvert;
import com.user.wechat.service.enums.ExceptionEnums;
import com.user.wechat.service.exception.BaseException;
import com.user.wechat.service.model.ProductDO;
import com.user.wechat.service.repository.ProductRepository;
import com.user.wechat.service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanghuachang
 * @date 2019-05-14
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getListByCategoryType(Integer categoryType) {
        return productRepository.findAllByCategoryType(categoryType)
                .stream()
                .map(ProductConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findByProductId(String productId) {
        ProductDO productDO = productRepository.findProductDOByProductId(productId);
        if (ObjectUtils.isEmpty(productDO)) {
            throw new BaseException(ExceptionEnums.PRODUCT_NOT_EXIT);
        }
        return ProductConvert.convert(productDO);
    }
}
