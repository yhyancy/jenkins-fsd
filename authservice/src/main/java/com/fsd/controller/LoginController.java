package com.fsd.controller;

import com.fsd.data.entity.Login.LoginEntity;
import com.fsd.data.entity.Login.LoginReturn;
import com.fsd.data.entity.UserInfoDB;
import com.fsd.data.mapper.UserInfoMapper;
import com.fsd.tools.TokenTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*") //允许跨域
public class LoginController {
    private final UserInfoMapper userInfoMapper;

    @Autowired
    private LoginController(UserInfoMapper userInfoMapper){
        this.userInfoMapper=userInfoMapper;
    }

    @PostMapping("/login")
    public LoginReturn authUnamePwd(@RequestBody(required = true) LoginEntity authUser){
        System.out.println(authUser);
     //1. 校验authUser是否为空
        if(authUser==null){
            return new LoginReturn(0,"","","");
        }
    //2. 根据authUser名字取数据库查询authUser信息
        UserInfoDB authUserInfoDB= userInfoMapper.selectUserByName(authUser.getUserName());
     //2-1 判断数据库是否存在authUser信息
        // isAuth:0 -----> 用户不存在
        if(authUserInfoDB==null){
            return new LoginReturn(0,"","","");
        }
        //isAuth:-1-------> 密码错误
        if(!authUserInfoDB.getPassword().equals(authUser.getPassWord())){
            return new LoginReturn(-1,"","","");
        }
        //isAuth:1  ------> active user
        else {
            //生成 jwt token
            String token= TokenTool.getToken(authUserInfoDB);
            return new LoginReturn(1,token,authUserInfoDB.getUser_name(),authUserInfoDB.getUser_type());
        }
    }
}
