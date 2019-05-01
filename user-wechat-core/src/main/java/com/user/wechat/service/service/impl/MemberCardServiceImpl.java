package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.MemberCardDTO;
import com.user.wechat.api.request.MemberBalanceRequest;
import com.user.wechat.service.convert.MemberCardConvert;
import com.user.wechat.service.enums.ExceptionEnums;
import com.user.wechat.service.exception.BaseException;
import com.user.wechat.service.model.MemberCardDO;
import com.user.wechat.service.model.MemberCardLogDO;
import com.user.wechat.service.repository.MemberCardLogRepository;
import com.user.wechat.service.repository.MemberCardRepository;
import com.user.wechat.service.service.MemberCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanghuachang
 * @date 2019-04-29
 */
@Service
@Slf4j
public class MemberCardServiceImpl implements MemberCardService {

    @Resource
    private MemberCardRepository memberCardRepository;
    @Resource
    private MemberCardLogRepository memberCardLogRepository;

    @Override
    public List<MemberCardDTO> findAllByMemberIds(List<String> memberIds) {
        return memberCardRepository.findAllByMemberIdIsIn(memberIds)
                .stream()
                .map(MemberCardConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean addBalance(MemberBalanceRequest memberBalanceRequest) {
        if (memberCardRepository.addBalance(memberBalanceRequest.getMemberId(), memberBalanceRequest.getMemberBalance()) > 0) {
            //充值成功，插入充值记录
            MemberCardDO memberCardDO = memberCardRepository.findByMemberId(memberBalanceRequest.getMemberId());
            MemberCardLogDO memberCardLogDO = new MemberCardLogDO();
            memberCardLogDO.setMemberId(memberCardDO.getMemberId());
            memberCardLogDO.setMemberCardId(memberCardDO.getMemberCardId());
            memberCardLogDO.setOperator("admin");
            memberCardLogDO.setAddBalance(memberBalanceRequest.getMemberBalance());
            MemberCardLogDO save = memberCardLogRepository.save(memberCardLogDO);
            if (!ObjectUtils.isEmpty(save)) {
                log.info("【充值成功】memberId={}, balance:={}", memberBalanceRequest.getMemberId(), memberBalanceRequest.getMemberBalance());
            }
            return true;
        }
        return false;
    }

    @Override
    public MemberCardDTO findCardByMemberId(String memberId) {
        MemberCardDO memberCardDO = memberCardRepository.findByMemberId(memberId);
        if (ObjectUtils.isEmpty(memberCardDO)) {
            throw new BaseException(ExceptionEnums.MEMBER_CARD_NOT_EXIT);
        }
        return MemberCardConvert.convert(memberCardDO);
    }
}
