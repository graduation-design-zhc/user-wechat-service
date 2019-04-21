package com.user.wechat.service.convert;

import com.user.wechat.api.dto.MemberDTO;
import com.user.wechat.service.model.MemberDO;

import java.text.SimpleDateFormat;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
public class MemberDTOConvert {

    public static MemberDTO convert(MemberDO memberDO) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberId(memberDO.getMemberId());
        memberDTO.setOpenId(memberDO.getOpenId());
        memberDTO.setGender(memberDO.getGender());
        memberDTO.setAvatar(memberDO.getAvatar());
        memberDTO.setPhone(memberDO.getPhone());
        memberDTO.setNickName(memberDTO.getNickName());
        memberDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(memberDO.getCreateTime()));
        memberDTO.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(memberDO.getUpdateTime()));
        return memberDTO;
    }

}
