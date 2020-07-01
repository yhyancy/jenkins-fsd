package com.fsd.controller;

import com.fsd.data.entity.Signup.SignupEntity;
import com.fsd.data.entity.Signup.SignupReturn;
import com.fsd.data.entity.UserInfoDB;
import com.fsd.data.mapper.UserInfoMapper;
import com.fsd.tools.MailMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*") //允许跨域
@RequestMapping(value = "signup", method = RequestMethod.POST)
public class SignupController {
    private final UserInfoMapper userInfoMapper;
    private final MailMan mailMan;
    @Value("${fsd.frontend.hostname}")
    private String feHostname;
    @Autowired
    private SignupController(UserInfoMapper userInfoMapper, MailMan mailMan){
        this.userInfoMapper=userInfoMapper;
        this.mailMan=mailMan;
    }

    @PostMapping("")
    public SignupReturn Signup(@RequestBody(required = true) SignupEntity signupEntity){
        //1. 判断signupEntity是否为空
        if(signupEntity== null){
            return new SignupReturn("FAILED");
        }
        // 2.不为空-> 生成Verify code
        int veriCode= ValidateGenerator();
        //3.格式化前端传来的参数
        UserInfoDB userInfoDB = formatUserInfo(signupEntity,veriCode);
        //4. 插入数据库
        userInfoMapper.addUser(userInfoDB);
        //5. 给用户邮箱发link,用于确认激活账号
        String mailSendtoAddress=userInfoDB.getEmail();
        String subject = "Please confirm your code:";
        String text= feHostname + "/email-confirm"+ "?uname=" + userInfoDB.getUser_name() + "&code=" + veriCode;
        mailMan.sender(mailSendtoAddress,subject,text);
        //6. 返回给前台
        return  new SignupReturn("OK");
    }

    @GetMapping("validate")
    public SignupReturn validateSignup(@RequestParam(required = true) String uname, @RequestParam(required = true) String code){
        if(uname.length()>10){
            return new SignupReturn("NOT ALLOWED");
        }
        UserInfoDB userInfoDB = userInfoMapper.selectUserByName(uname);
        if(code.equals(userInfoDB.getVeri_code())){
            userInfoMapper.updateValidate(uname);
            return new SignupReturn("OK");
        }
        return new SignupReturn("FAILED");
    }

    // utils
    private int ValidateGenerator(){
        return (int)((Math.random()*9+1)*1000);
    }

    private UserInfoDB formatUserInfo(SignupEntity signupEntity, int veriCode){
        return new UserInfoDB(signupEntity.getUsername(),signupEntity.getPasswordsGroup().getPassword(),signupEntity.getUsertype(),signupEntity.getEmail(),signupEntity.getMobile(),"N",Integer.toString(veriCode));
    }
}
