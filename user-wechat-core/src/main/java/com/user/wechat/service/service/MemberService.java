package com.user.wechat.service.service;

import com.user.wechat.api.dto.MemberDTO;

import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
public interface MemberService {

    List<MemberDTO> findAll();

    Boolean deleteMemberByMemberId(String memberId);

    MemberDTO save(MemberDTO memberDTO);

}
