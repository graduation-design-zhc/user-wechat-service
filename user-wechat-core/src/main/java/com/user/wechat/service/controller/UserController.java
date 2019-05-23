package com.user.wechat.service.controller;

import com.user.wechat.api.dto.UserDTO;
import com.user.wechat.api.enums.ResponseCode;
import com.user.wechat.api.request.UserRequest;
import com.user.wechat.api.response.Response;
import com.user.wechat.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/list")
    public Response getAllUser() {
        return Response.success(userService.findAll());
    }

    @PostMapping("/user/login")
    public Response getUserLogin(@RequestBody UserRequest userRequest) {
        UserDTO userDTO = userService.getUserByNameAndPwd(userRequest);
        if (ObjectUtils.isEmpty(userDTO)) {
            log.error("登录失败,用户名或密码错误!");
            return Response.fail(ResponseCode.FAIL);
        }
        return Response.success(userDTO);
    }

}
