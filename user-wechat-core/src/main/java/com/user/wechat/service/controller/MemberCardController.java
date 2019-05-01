package com.user.wechat.service.controller;

import com.user.wechat.api.request.MemberBalanceRequest;
import com.user.wechat.api.response.Response;
import com.user.wechat.service.service.MemberCardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-04-29
 */
@RestController
public class MemberCardController {


    @Resource
    private MemberCardService memberCardService;

    @PostMapping("/member/cards")
    public Response getCardsByMemberIds(@RequestParam("memberIds") List<String> memberIds) {
        return Response.success(memberCardService.findAllByMemberIds(memberIds));
    }

    @PostMapping("/member/getCardByMemberId")
    public Response getCardByMemberId(@RequestParam("memberId") String memberId) {
        return Response.success(memberCardService.findCardByMemberId(memberId));
    }

    @PostMapping("member/addBalance")
    public Response addMemberBalance(@RequestBody MemberBalanceRequest memberBalanceRequest) {
        return Response.success(memberCardService.addBalance(memberBalanceRequest));
    }

}
