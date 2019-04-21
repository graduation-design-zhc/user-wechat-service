package com.user.wechat.service.convert;

import com.user.wechat.api.dto.UserDTO;
import com.user.wechat.service.model.UserDO;

import java.text.SimpleDateFormat;

/**
 * @author zhanghuachang
 * @date 2019-04-20
 */
public class UserDTOConvert {

    public static UserDTO convert(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUid(userDO.getUid());
        userDTO.setUserName(userDO.getUserName());
        userDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(userDO.getCreateTime()));
        userDTO.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(userDO.getUpdateTime()));
        return userDTO;
    }

}
