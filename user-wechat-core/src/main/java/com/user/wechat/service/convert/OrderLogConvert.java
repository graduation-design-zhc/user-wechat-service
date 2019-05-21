package com.user.wechat.service.convert;

import com.user.wechat.api.dto.OrderLogDTO;
import com.user.wechat.service.model.OrderDO;

import java.text.SimpleDateFormat;

/**
 * @author zhanghuachang
 * @date 2019-05-20
 */
public class OrderLogConvert {

    public static OrderLogDTO convert(OrderDO orderDO) {
        OrderLogDTO orderLogDTO = new OrderLogDTO();
        orderLogDTO.setOrderId(orderDO.getOrderId());
        orderLogDTO.setNickname(orderDO.getBuyerName());
        orderLogDTO.setBuyerPhone(orderDO.getBuyerPhone());
        orderLogDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderDO.getCreateTime()));
        orderLogDTO.setOperator(orderDO.getOperator());
        orderLogDTO.setOrderIntegral(orderDO.getOrderIntegral().toString());
        orderLogDTO.setOrderPrice(orderDO.getOrderPrice().toString());
        orderLogDTO.setPayType(orderDO.getPayType());
        return orderLogDTO;
    }

}
