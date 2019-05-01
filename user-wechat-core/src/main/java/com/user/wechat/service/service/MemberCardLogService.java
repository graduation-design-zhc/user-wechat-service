package com.user.wechat.service.service;

import com.user.wechat.api.dto.MemberCardLogDTO;

import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-05-01
 */
public interface MemberCardLogService {


    List<MemberCardLogDTO> findAll();

}
