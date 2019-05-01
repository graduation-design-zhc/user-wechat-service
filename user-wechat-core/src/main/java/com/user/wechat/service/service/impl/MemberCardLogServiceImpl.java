package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.MemberCardLogDTO;
import com.user.wechat.service.convert.MemberCardLogConvert;
import com.user.wechat.service.repository.MemberCardLogRepository;
import com.user.wechat.service.service.MemberCardLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public List<MemberCardLogDTO> findAll() {
        return memberCardLogRepository.findAllByOrderByCreateTimeDesc()
                .stream()
                .map(MemberCardLogConvert::convert)
                .collect(Collectors.toList());
    }
}
