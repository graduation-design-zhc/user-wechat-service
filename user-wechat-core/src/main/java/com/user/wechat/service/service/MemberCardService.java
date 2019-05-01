package com.user.wechat.service.service;

import com.user.wechat.api.dto.MemberCardDTO;
import com.user.wechat.api.request.MemberBalanceRequest;

import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-04-29
 */
public interface MemberCardService {


    List<MemberCardDTO> findAllByMemberIds(List<String> memberIds);

    Boolean addBalance(MemberBalanceRequest memberBalanceRequest);

    MemberCardDTO findCardByMemberId(String memberId);

}
