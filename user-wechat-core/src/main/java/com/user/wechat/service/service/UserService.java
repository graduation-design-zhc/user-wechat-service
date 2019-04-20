package com.user.wechat.service.service;

import com.user.wechat.service.model.UserDO;

import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
public interface UserService {

    List<UserDO> findAll();

}
