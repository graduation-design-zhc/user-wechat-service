package com.user.wechat.service.repository;

import com.user.wechat.service.model.MemberDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
public interface MemberRepository extends JpaRepository<MemberDO, String> {
}
