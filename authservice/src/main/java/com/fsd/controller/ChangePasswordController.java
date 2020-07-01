package com.fsd.controller;

import com.fsd.data.entity.Changepw.ChangepwEntity;
import com.fsd.data.entity.Changepw.ChangepwReturn;
import com.fsd.data.entity.UserInfoDB;
import com.fsd.data.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ChangePasswordController {
    private UserInfoMapper userInfoMapper;

    @Autowired
    private ChangePasswordController(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @PostMapping("/changepwd")
    private ChangepwReturn changepw(@RequestBody(required = true) ChangepwEntity changepwEntity) {
        //1. 判断changepwEntity是否为空
        if (changepwEntity == null) {
            return new ChangepwReturn("User is null.");
        }
        UserInfoDB userInfoDB = userInfoMapper.selectUserByName(changepwEntity.getUsername());
        //2.判断用户是否存在
        if (userInfoDB == null) {
            return new ChangepwReturn("User not exist");
        }
        //3. 判断旧密码是否正确或者用户是否active
        if (!changepwEntity.getOldpassword().equals(userInfoDB.getPassword()) || !userInfoDB.getConfirmed().equals("Y")) {
            return new ChangepwReturn("Old password is incorrect.");
        }
        //4.修改密码
        userInfoDB.setPassword(changepwEntity.getPasswordsgroup().getPassword());
        userInfoMapper.updatePassword(userInfoDB);

        return new ChangepwReturn("OK");
    }

}
