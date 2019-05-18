package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.ProductCategoryDTO;
import com.user.wechat.service.convert.ProductCategoryConvert;
import com.user.wechat.service.repository.ProductCategoryRepository;
import com.user.wechat.service.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanghuachang
 * @date 2019-05-14
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategoryDTO> getAllCategoryList() {
        return productCategoryRepository.findAll()
                .stream()
                .map(ProductCategoryConvert::convert)
                .collect(Collectors.toList());
    }
}
