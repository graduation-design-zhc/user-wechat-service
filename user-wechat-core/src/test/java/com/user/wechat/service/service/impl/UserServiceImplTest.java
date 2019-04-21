package com.user.wechat.service.service.impl;

import com.user.wechat.api.dto.UserDTO;
import com.user.wechat.api.request.UserRequest;
import com.user.wechat.service.MainApplication;
import com.user.wechat.service.model.UserDO;
import com.user.wechat.service.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAll() {
        List<UserDTO> userDTOS = userService.findAll();
        assert userDTOS != null;

    }

    @Test
    public void getUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("admin");
        userRequest.setPassword("admin");
        UserDTO userDTO = userService.getUserByNameAndPwd(userRequest);
        System.out.println(userDTO);
    }
}