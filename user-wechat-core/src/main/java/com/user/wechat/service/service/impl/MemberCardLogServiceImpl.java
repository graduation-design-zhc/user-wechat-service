package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.MemberCardLogDTO;
import com.user.wechat.service.convert.MemberCardLogConvert;
import com.user.wechat.service.model.MemberCardLogDO;
import com.user.wechat.service.model.MemberDO;
import com.user.wechat.service.repository.MemberCardLogRepository;
import com.user.wechat.service.repository.MemberRepository;
import com.user.wechat.service.service.MemberCardLogService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanghuachang
 * @date 2019-05-01
 */
@Service
public class MemberCardLogServiceImpl implements MemberCardLogService {

    @Resource
    private MemberCardLogRepository memberCardLogRepository;
    @Resource
    private MemberRepository memberRepository;

    @Override
    public List<MemberCardLogDTO> findAll() {
        return memberCardLogRepository.findAllByOrderByCreateTimeDesc()
                .stream()
                .map(MemberCardLogConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<MemberCardLogDTO> getLogByPhone(String phone) {
        MemberDO memberDO = memberRepository.findByPhone(phone);
        if (ObjectUtils.isEmpty(memberDO)) {
            return Collections.emptyList();
        }
        return memberCardLogRepository.findAllByMemberIdOrderByCreateTime(memberDO.getMemberId())
                .stream()
                .map(MemberCardLogConvert::convert)
                .collect(Collectors.toList());
    }
}
