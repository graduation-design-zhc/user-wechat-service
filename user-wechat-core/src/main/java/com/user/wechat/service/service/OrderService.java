package com.user.wechat.service.service;

import com.user.wechat.api.dto.OrderDTO;
import com.user.wechat.api.request.OrderRequest;

/**
 * @author zhanghuachang
 * @date 2019-05-11
 */
public interface OrderService {

    OrderDTO memberOrder(OrderRequest orderRequest);

}
