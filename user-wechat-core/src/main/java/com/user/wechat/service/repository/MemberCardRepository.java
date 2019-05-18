package com.user.wechat.service.repository;

import com.user.wechat.service.model.MemberCardDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-04-29
 */
public interface MemberCardRepository extends JpaRepository<MemberCardDO, String> {

    List<MemberCardDO> findAllByMemberIdIsIn(List<String> memberIds);

    MemberCardDO findByMemberId(String memberId);

    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "update MemberCardDO set member_balance = member_balance + ?2 where member_id = ?1")
    int addBalance(String memberId, BigDecimal memberBalance);

    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "update MemberCardDO set member_balance = member_balance - ?2, member_integral = member_integral + ?3 where member_id = ?1")
    int updateBalanceAndIntegral(String memberId, BigDecimal memberBalance, Double integral);

}
