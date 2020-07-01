package com.fsd.data.entity.Login;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class LoginReturn {
    private int isAuth;
    private String token;
    private String uName;
    private String uType;

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public String getToken() {
        return token;
    }

    public String getuName() {
        return uName;
    }

    public String getuType() {
        return uType;
    }

    @Override
    public String toString() {
        return "LoginReturn{" +
                "isAuth=" + isAuth +
                ", token='" + token + '\'' +
                ", uName='" + uName + '\'' +
                ", uType='" + uType + '\'' +
                '}';
    }
}
