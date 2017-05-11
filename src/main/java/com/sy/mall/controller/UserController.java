package com.sy.mall.controller;

import com.google.code.kaptcha.Constants;
import com.sy.mall.ResponseResult;
import com.sy.mall.biz.UserBiz;
import com.sy.mall.common.enums.ResultEnum;
import com.sy.mall.common.util.ShiroUtils;
import com.sy.mall.pojo.dto.LoginInfoDTO;
import com.sy.mall.pojo.dto.RegisterInfoDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import static com.sy.mall.common.util.CheckParamUtil.checkLoginParams;
import static com.sy.mall.common.util.CheckParamUtil.checkRegisterParams;

/**
 * Created by lilei on 2017/5/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserBiz userBiz;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult login(LoginInfoDTO loginInfo) {
        try {
            checkLoginParams(loginInfo);
        } catch (RuntimeException e) {
            return new ResponseResult(ResultEnum.LOGIN_ERROR, e.getMessage());
        }

        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!loginInfo.getCaptcha().equals(kaptcha)) {
            return new ResponseResult(ResultEnum.VERIFICATION_CODE_ERROR);
        }

        Subject subject = ShiroUtils.getSubject();
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

    /**
     * 注册
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseResult register(RegisterInfoDTO registerInfo) {
        try {
            checkRegisterParams(registerInfo);
        } catch (RuntimeException e) {
            return new ResponseResult(ResultEnum.REGISTER_ERROR, e.getMessage());
        }
        ResponseResult result = userBiz.register(registerInfo);
        return null;
    }


}
