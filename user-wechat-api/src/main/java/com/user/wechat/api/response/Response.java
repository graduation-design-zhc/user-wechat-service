package com.user.wechat.api.response;


import com.user.wechat.api.enums.ResponseCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
@Getter
@Setter
@ToString
public class Response<T> implements Serializable {


    private static final long serialVersionUID = 871375248137067070L;
    private int code;
    private String message;
    private Boolean success;
    private T data;

    public Boolean isSuccess() {
        return this.success;
    }

    public static <T> Response success(T data) {
        return generateResponse(true, ResponseCode.SUCCESS, data);
    }

    public static <T> Response fail(ResponseCode code) {
        return generateResponse(false, code, null);
    }

    private static <T> Response generateResponse(boolean success, ResponseCode code, T data) {
        Response<T> response = new Response<T>();
        response.code = code.getCode();
        response.message = code.getMessage();
        response.success = success;
        response.data = data;
        return response;
    }

}
