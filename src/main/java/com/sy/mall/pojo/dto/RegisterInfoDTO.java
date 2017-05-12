package com.sy.mall.pojo.dto;

/**
 * Created by 李磊
 * on 2017/5/11.
 */
public class RegisterInfoDTO {
    private String username;
    private String password;
    private String confirm;
    private String email;
    private String captcha;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public String toString() {
        return "RegisterInfoDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", captcha='" + captcha + '\'' +
                '}';
    }
}
