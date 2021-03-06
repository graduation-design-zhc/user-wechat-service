package com.user.wechat.service.controller;

import com.user.wechat.api.request.OrderRequest;
import com.user.wechat.api.response.Response;
import com.user.wechat.service.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhanghuachang
 * @date 2019-05-11
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("member/order")
    public Response memberOrder(@RequestBody OrderRequest orderRequest) {
        return Response.success(orderService.memberOrder(orderRequest));
    }

    @PostMapping("member/getOrderLog")
    public Response orderLogList() {
        return Response.success(orderService.orderLogList());
    }

    @PostMapping("member/getOrderLogByPhone")
    public Response getOrderLogByPhone(@RequestParam("phone") String phone) {
        return Response.success(orderService.getOrderLogListByPhone(phone));
    }

}
