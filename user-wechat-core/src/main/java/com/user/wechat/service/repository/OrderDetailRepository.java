package com.user.wechat.service.repository;

import com.user.wechat.service.model.OrderDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-05-11
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetailDO, String> {

    List<OrderDetailDO> findAllByOrderId(String orderId);

}
