package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.MemberDTO;
import com.user.wechat.service.convert.MemberDTOConvert;
import com.user.wechat.service.model.MemberDO;
import com.user.wechat.service.repository.MemberRepository;
import com.user.wechat.service.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        return memberRepository.findAll().stream().map(MemberDTOConvert::convert).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteMemberByMemberId(String memberId) {
        return memberRepository.deleteByMemberId(memberId) > 0;
    }

    @Override
    public MemberDTO save(MemberDTO memberDTO) {
        MemberDO memberDO = new MemberDO();
        BeanUtils.copyProperties(memberDTO, memberDO);
        memberDO.setMemberId(UUID.randomUUID().toString().replace("-", ""));
        try {
            memberDO.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(memberDTO.getBirthday()));
        } catch (ParseException e) {
            log.error("生日转换异常");
        }
        MemberDO save = memberRepository.save(memberDO);
        if (!ObjectUtils.isEmpty(save)) {
            MemberDTOConvert.convert(save);
        }
        return null;
    }
}
