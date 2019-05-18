package com.user.wechat.service.controller;

import com.user.wechat.api.response.Response;
import com.user.wechat.service.service.ProductCategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhanghuachang
 * @date 2019-05-14
 */
@RestController
public class ProductCategoryController {

    @Resource
    private ProductCategoryService productCategoryService;

    @PostMapping("category/getList")
    public Response getCategoryList() {
        return Response.success(productCategoryService.getAllCategoryList());
    }

}
