package com.user.wechat.service.controller;

import com.user.wechat.api.response.Response;
import com.user.wechat.service.service.MemberCardLogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhanghuachang
 * @date 2019-05-01
 */
@RestController
public class MemberCardLogController {

    @Resource
    private MemberCardLogService memberCardLogService;


    @PostMapping("member/getAllCardLog")
    public Response getAllCardLog() {
        return Response.success(memberCardLogService.findAll());
    }

}
