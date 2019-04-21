package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.UserDTO;
import com.user.wechat.api.request.UserRequest;
import com.user.wechat.service.convert.UserDTOConvert;
import com.user.wechat.service.model.UserDO;
import com.user.wechat.service.repository.UserRepository;
import com.user.wechat.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTOConvert::convert).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByNameAndPwd(UserRequest userRequest) {
        UserDO userDO = userRepository.findUserDOByUserNameAndPassword(userRequest.getUserName(), userRequest.getPassword());
        if (ObjectUtils.isEmpty(userDO)) {
            return null;
        }
        return UserDTOConvert.convert(userDO);
    }
}
