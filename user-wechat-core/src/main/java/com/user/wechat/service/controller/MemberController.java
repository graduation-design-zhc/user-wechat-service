package com.user.wechat.service.controller;

import com.user.wechat.api.request.MemberRequest;
import com.user.wechat.api.response.Response;
import com.user.wechat.service.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
@RestController
public class MemberController {

    @Resource
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
    public Response saveMember(@RequestBody MemberRequest memberRequest) {
        return Response.success(memberService.save(memberRequest));
    }

    @PostMapping("member/update")
    public Response updateMember(@RequestBody MemberRequest memberRequest) {
        return Response.success(memberService.updateMember(memberRequest));
    }

    @PostMapping("member/getMemberByOpenId")
    public Response getMemberByOpenId(@RequestParam("openId") String openId) {
        return Response.success(memberService.findMemberByOpenId(openId));
    }
    
    @PostMapping("member/getMemberByMemberId")
    public Response getMemberByMemberId(@RequestParam("memberId") String memberId) {
        return Response.success(memberService.findMemberByMemberId(memberId));
    }

    @PostMapping("member/getMemberByMemberIds")
    public Response getMemberByMemberIds(@RequestParam("memberIds") List<String> memberIds) {
        return Response.success(memberService.findAllByMemberIds(memberIds));
    }

    @PostMapping("member/getMemberByPhone")
    public Response getMemberByPhone(@RequestParam("phone") String phone) {
        return Response.success(memberService.findMemberByPhone(phone));
    }

}
