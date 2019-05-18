package com.user.wechat.api.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-05-09
 */
@Data
public class OrderRequest implements Serializable {

    private static final long serialVersionUID = 1299618736016708795L;
    private String buyerPhone;
    private Integer payType;
    private List<OrderDetailRequest> orderDetailRequests;

}
