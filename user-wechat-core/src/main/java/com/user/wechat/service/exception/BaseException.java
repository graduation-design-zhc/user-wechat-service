package com.user.wechat.service.exception;

import com.user.wechat.service.enums.ExceptionEnums;

/**
 * @author zhanghuachang
 * @date 2019-04-23
 */
public class BaseException extends RuntimeException{

    public Integer code;

    public BaseException(ExceptionEnums exceptionEnums) {
        super(exceptionEnums.getMessage());
        this.code = exceptionEnums.getCode();
    }

}
