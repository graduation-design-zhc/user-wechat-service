package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.MemberDTO;
import com.user.wechat.service.convert.MemberDTOConvert;
import com.user.wechat.service.repository.MemberRepository;
import com.user.wechat.service.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberRepository memberRepository;

    @Override
    public List<MemberDTO> findAll() {
        return memberRepository.findAll().stream().map(MemberDTOConvert::convert).collect(Collectors.toList());
    }
}
