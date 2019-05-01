package com.user.wechat.service.convert;

import com.user.wechat.api.dto.MemberCardDTO;
import com.user.wechat.service.model.MemberCardDO;

import java.text.SimpleDateFormat;

/**
 * @author zhanghuachang
 * @date 2019-04-29
 */
public class MemberCardConvert {


    public static MemberCardDTO convert(MemberCardDO memberCardDO) {
        MemberCardDTO memberCardDTO = new MemberCardDTO();
        memberCardDTO.setMemberId(memberCardDO.getMemberId());
        memberCardDTO.setMemberCardId(memberCardDO.getMemberCardId());
        memberCardDTO.setMemberBalance(memberCardDO.getMemberBalance());
        memberCardDTO.setMemberIntegral(memberCardDO.getMemberIntegral());
        memberCardDTO.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(memberCardDO.getUpdateTime()));
        memberCardDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(memberCardDO.getCreateTime()));
        return memberCardDTO;
    }

}
