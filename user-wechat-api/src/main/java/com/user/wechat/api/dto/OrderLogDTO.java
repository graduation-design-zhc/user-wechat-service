package com.user.wechat.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-05-09
 */
@Data
public class OrderLogDTO implements Serializable {

    private static final long serialVersionUID = -6818449577670868567L;
    private String nickname;
    private String orderId;
    private List<OrderDetailDTO> orderDetailDTOList;
    private String orderDescribe;
    private String buyerPhone;
    private Integer payType;
    private String orderPrice;
    private String orderIntegral;
    private String operator;
    private String createTime;

}
