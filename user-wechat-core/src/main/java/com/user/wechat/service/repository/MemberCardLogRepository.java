package com.user.wechat.service.repository;

import com.user.wechat.service.model.MemberCardLogDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-05-01
 */
public interface MemberCardLogRepository extends JpaRepository<MemberCardLogDO, String> {

    List<MemberCardLogDO> findAllByOrderByCreateTimeDesc();

}
