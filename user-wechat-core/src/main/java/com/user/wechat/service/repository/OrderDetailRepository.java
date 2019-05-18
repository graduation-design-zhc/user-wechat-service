package com.user.wechat.service.repository;

import com.user.wechat.service.model.OrderDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhanghuachang
 * @date 2019-05-11
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetailDO, String> {
}
