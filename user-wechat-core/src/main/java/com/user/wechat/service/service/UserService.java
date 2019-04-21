package com.user.wechat.service.service;

import com.user.wechat.api.dto.UserDTO;
import com.user.wechat.api.request.UserRequest;

import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
public interface UserService {

    List<UserDTO> findAll();

    UserDTO getUserByNameAndPwd(UserRequest userRequest);

}
