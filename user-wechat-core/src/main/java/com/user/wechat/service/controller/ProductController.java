package com.user.wechat.service.controller;

import com.user.wechat.api.response.Response;
import com.user.wechat.service.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhanghuachang
 * @date 2019-05-14
 */
@RestController
public class ProductController {

    @Resource
    private ProductService productService;


    @PostMapping("product/getByCategoryType")
    public Response getListByCategoryType(@RequestParam("categoryType") Integer categoryType) {
        return Response.success(productService.getListByCategoryType(categoryType));
    }

    @PostMapping("product/getByProductId")
    public Response getProductByProductId(@RequestParam("productId") String productId) {
        return Response.success(productService.findByProductId(productId));
    }

}
