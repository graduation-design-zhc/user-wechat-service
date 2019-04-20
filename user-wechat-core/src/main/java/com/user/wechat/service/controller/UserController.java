package com.user.wechat.service.controller;

import com.user.wechat.api.response.Response;
import com.user.wechat.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public Response getAllUser() {
        return Response.success(userService.findAll());
    }

}
