package com.user.wechat.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-05-13
 */
@Data
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = -7799941031343116488L;
    private String orderId;
    private String memberId;
    private Integer payType;
    private BigDecimal orderPrice;
    private Double orderIntegral;
    private String createTime;
    List<OrderDetailDTO> orderDetailDTOList;

}
