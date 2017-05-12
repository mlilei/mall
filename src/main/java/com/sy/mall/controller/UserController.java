package com.sy.mall.controller;

import com.sy.mall.ResponseResult;
import com.sy.mall.biz.UserBiz;
import com.sy.mall.pojo.dto.LoginInfoDTO;
import com.sy.mall.pojo.dto.RegisterInfoDTO;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 李磊
 * on 2017/5/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserBiz userBiz;

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult login(LoginInfoDTO loginInfo) {
        return userBiz.login(loginInfo);
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:../login";
    }

    /**
     * 注册
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseResult register(RegisterInfoDTO registerInfo) {
        return userBiz.register(registerInfo);
    }
}
