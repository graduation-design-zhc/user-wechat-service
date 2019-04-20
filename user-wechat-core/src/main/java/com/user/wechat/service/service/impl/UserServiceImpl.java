package com.user.wechat.service.service.impl;

import com.user.wechat.service.model.UserDO;
import com.user.wechat.service.repository.UserRepository;
import com.user.wechat.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDO> findAll() {
        return userRepository.findAll();
    }
}
