package com.user.wechat.service.repository;

import com.user.wechat.service.model.MemberDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-04-21
 */
public interface MemberRepository extends JpaRepository<MemberDO, String> {

    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "delete from MemberDO where member_id = ?1")
    int deleteByMemberId(String memberId);

    List<MemberDO> findAllByOrderByCreateTimeDesc();

    MemberDO findByMemberId(String memberId);

    MemberDO findByOpenId(String openId);

    List<MemberDO> findAllByMemberIdIsIn(List<String> memberIds);

    MemberDO findByPhone(String phone);

}
