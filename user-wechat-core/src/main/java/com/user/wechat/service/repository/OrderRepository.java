package com.user.wechat.service.repository;

import com.user.wechat.service.model.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhanghuachang
 * @date 2019-05-09
 */
public interface OrderRepository extends JpaRepository<OrderDO, String> {
}
