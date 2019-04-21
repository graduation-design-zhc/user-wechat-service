package com.user.wechat.service.controller;

import com.user.wechat.api.response.Response;
import com.user.wechat.service.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/list")
    public Response getMemberList() {
        return Response.success(memberService.findAll());
    }

}
