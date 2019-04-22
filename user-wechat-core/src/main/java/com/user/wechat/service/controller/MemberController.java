package com.user.wechat.service.controller;

import com.user.wechat.api.dto.MemberDTO;
import com.user.wechat.api.response.Response;
import com.user.wechat.service.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/member/delete")
    public Response deleteMember(@RequestParam("memberId") String memberId) {
        return Response.success(memberService.deleteMemberByMemberId(memberId));
    }

    @PostMapping("/member/save")
    public Response saveMember(@RequestBody MemberDTO memberDTO) {
        return Response.success(memberService.save(memberDTO));
    }

}
