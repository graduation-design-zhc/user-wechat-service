package com.user.wechat.service.convert;

import com.user.wechat.api.dto.MemberCardLogDTO;
import com.user.wechat.service.model.MemberCardLogDO;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;

/**
 * @author zhanghuachang
 * @date 2019-05-01
 */
public class MemberCardLogConvert {

    public static MemberCardLogDTO convert(MemberCardLogDO memberCardLogDO) {
        MemberCardLogDTO memberCardLogDTO = new MemberCardLogDTO();
        BeanUtils.copyProperties(memberCardLogDO, memberCardLogDTO);
        memberCardLogDTO.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(memberCardLogDO.getUpdateTime()));
        memberCardLogDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(memberCardLogDO.getCreateTime()));
        return memberCardLogDTO;
    }

}
