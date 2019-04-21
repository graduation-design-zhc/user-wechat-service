package com.user.wechat.service.repository;

import com.user.wechat.service.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhanghuachang
 * @date 2019-04-12
 */
public interface UserRepository extends JpaRepository<UserDO, String> {

    /**
     * 根据用户名和密码查找用户
     * @param userName
     * @param password
     * @return
     */
    UserDO findUserDOByUserNameAndPassword(String userName, String password);

}
