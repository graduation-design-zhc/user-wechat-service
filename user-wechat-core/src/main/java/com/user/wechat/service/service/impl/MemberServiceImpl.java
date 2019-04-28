package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.MemberDTO;
import com.user.wechat.api.request.MemberRequest;
import com.user.wechat.service.convert.MemberConvert;
import com.user.wechat.service.enums.ExceptionEnums;
import com.user.wechat.service.exception.BaseException;
import com.user.wechat.service.model.MemberDO;
import com.user.wechat.service.repository.MemberRepository;
import com.user.wechat.service.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberRepository memberRepository;

    @Override
    public List<MemberDTO> findAll() {
        return memberRepository.findAllByOrderByCreateTimeDesc()
                .stream()
                .map(MemberConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteMemberByMemberId(String memberId) {
        return memberRepository.deleteByMemberId(memberId) > 0;
    }

    @Override
    public MemberDTO save(MemberRequest memberRequest) {
        if (!StringUtils.isEmpty(memberRequest.getOpenId())) {
            MemberDO memberDO = memberRepository.findByOpenId(memberRequest.getOpenId());
            if (ObjectUtils.isEmpty(memberDO)) {
                MemberDO save = new MemberDO();
                //新会员
                BeanUtils.copyProperties(memberRequest, save);
                save.setMemberId(UUID.randomUUID().toString().replace("-", ""));
                save.setPhone("");
                try {
                    if (!StringUtils.isEmpty(memberRequest.getBirthday())) {
                        save.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(memberRequest.getBirthday()));
                    } else {
                        save.setBirthday(new Date());
                    }
                } catch (ParseException e) {
                    log.error("生日转换异常");
                }
                MemberDO memberDO1 = memberRepository.save(save);
                if (!ObjectUtils.isEmpty(memberDO1)) {
                    return MemberConvert.convert(memberDO1);
                }
            } else {
                //如果存在，就更新对应信息
                memberDO.setAvatar(memberRequest.getAvatar());
                memberDO.setGender(memberRequest.getGender());
                memberDO.setNickname(memberRequest.getNickname());
                return MemberConvert.convert(memberRepository.save(memberDO));
            }
        }
        return null;
    }

    @Override
    public MemberDTO updateMember(MemberRequest memberRequest) {
        MemberDO memberDO = memberRepository.findByMemberId(memberRequest.getMemberId());
        if (ObjectUtils.isEmpty(memberDO)) {
            throw new BaseException(ExceptionEnums.MEMBER_NOT_EXIT);
        }
        MemberDO convert = MemberConvert.convert(memberRequest, memberDO);
        MemberDO save = memberRepository.save(convert);
        if (!ObjectUtils.isEmpty(save)) {
            return MemberConvert.convert(save);
        }
        return null;
    }

    @Override
    public MemberDTO findMemberByOpenId(String openId) {
        MemberDO memberDO = memberRepository.findByOpenId(openId);
        if (ObjectUtils.isEmpty(memberDO)) {
            throw new BaseException(ExceptionEnums.MEMBER_NOT_EXIT);
        }
        return MemberConvert.convert(memberDO);
    }
}
