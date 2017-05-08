package com.sy.mall.controller;

import com.sy.mall.ResponseResult;
import com.sy.mall.Service.UserService;
import com.sy.mall.common.enums.ResultEnum;
import com.sy.mall.pojo.dto.LoginInfoDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lilei on 2017/5/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @RequiresGuest
    public ResponseResult login(LoginInfoDTO loginInfo) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginInfo.getPrincipal(), loginInfo.getCredentials());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录失败:{}", loginInfo, e);
            return new ResponseResult(ResultEnum.LOGIN_ERROR, e.getMessage());
        }
        return ResponseResult.createSuccessResult();
    }

    /**
     * 退出
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:../login";
    }


}
