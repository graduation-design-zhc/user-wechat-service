package com.user.wechat.service.service;

import com.user.wechat.api.dto.MemberDTO;
import com.user.wechat.api.request.MemberRequest;

import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
public interface MemberService {

    List<MemberDTO> findAll();

    Boolean deleteMemberByMemberId(String memberId);

    MemberDTO save(MemberRequest memberRequest);

    MemberDTO updateMember(MemberRequest memberRequest);

    MemberDTO findMemberByOpenId(String openId);

    MemberDTO findMemberByMemberId(String memberId);

    List<MemberDTO> findAllByMemberIds(List<String> memberIds);

    MemberDTO findMemberByPhone(String phone);

}
