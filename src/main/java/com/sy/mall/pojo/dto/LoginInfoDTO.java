package com.sy.mall.pojo.dto;

import java.io.Serializable;

/**
 * Created by 李磊
 * on 2017/5/3.
 */
public class LoginInfoDTO implements Serializable{
    private String principal;
    private String credentials;
    private String captcha;

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "principal='" + principal + '\'' +
                ", credentials='" + credentials + '\'' +
                ", captcha='" + captcha + '\'' +
                '}';
    }
}
