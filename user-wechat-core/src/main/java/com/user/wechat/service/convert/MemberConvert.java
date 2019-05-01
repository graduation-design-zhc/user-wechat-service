package com.user.wechat.service.convert;

import com.user.wechat.api.dto.MemberDTO;
import com.user.wechat.api.request.MemberRequest;
import com.user.wechat.service.model.MemberDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
@Slf4j
public class MemberConvert {

    public static MemberDTO convert(MemberDO memberDO) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberId(memberDO.getMemberId());
        memberDTO.setOpenId(memberDO.getOpenId());
        memberDTO.setGender(memberDO.getGender());
        memberDTO.setAvatar(memberDO.getAvatar());
        if (!StringUtils.isEmpty(memberDO.getPhone())) {
            memberDTO.setPhone(memberDO.getPhone());
        }
        memberDTO.setNickname(memberDO.getNickname());
        memberDTO.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(memberDO.getBirthday()));
        if (!ObjectUtils.isEmpty(memberDO.getCreateTime())) {
            memberDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(memberDO.getCreateTime()));
        }
        memberDTO.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(memberDO.getUpdateTime()));
        return memberDTO;
    }

    public static MemberDO convert(MemberRequest memberRequest, MemberDO memberDO) {
        if (!StringUtils.isEmpty(memberRequest.getNickname())) {
            memberDO.setNickname(memberRequest.getNickname());
        }
        if (!StringUtils.isEmpty(memberRequest.getAvatar())) {
            memberDO.setAvatar(memberRequest.getAvatar());
        }
        if (!StringUtils.isEmpty(memberRequest.getGender())) {
            memberDO.setGender(memberRequest.getGender());
        }
        if (!StringUtils.isEmpty(memberRequest.getPhone())) {
            memberDO.setPhone(memberRequest.getPhone());
        }
        if (!StringUtils.isEmpty(memberRequest.getBirthday())) {
            try {
                memberDO.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(memberRequest.getBirthday()));
            } catch (ParseException e) {
                log.error("生日转换异常");
            }
        }
        return memberDO;
    }

}
