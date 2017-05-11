package com.sy.mall.common.util;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.sy.mall.pojo.dto.LoginInfoDTO;
import com.sy.mall.pojo.dto.RegisterInfoDTO;

import java.util.regex.Pattern;

/**
 * Created by 李磊
 * on 2017/5/1.
 */
public class CheckParamUtil {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[\\w-\\.]+@([\\w-]+\\.)+[a-z]{2,3}");


    public static void checkLoginParams(LoginInfoDTO loginInfoDTO) {
        Preconditions.checkNotNull(loginInfoDTO, "登录参数不能为空");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(loginInfoDTO.getPrincipal()), "身份信息不能为空");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(loginInfoDTO.getCredentials()), "密码不能为空");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(loginInfoDTO.getCaptcha()), "验证码不能为空");
    }

    public static void checkRegisterParams(RegisterInfoDTO registerInfo) {
        Preconditions.checkNotNull(registerInfo);
        Preconditions.checkArgument(null != registerInfo.getUsername(), "用户名不能为空");
        Preconditions.checkArgument(null != registerInfo.getPassword(), "密码不能为空");
        Preconditions.checkArgument(null != registerInfo.getConfirm(), "确认密码不能为空");
        Preconditions.checkArgument(null != registerInfo.getEmail(), "邮箱不能为空");

        Preconditions.checkArgument(registerInfo.getUsername().length() >= 6, "用户名长度应大于6位");
        Preconditions.checkArgument(registerInfo.getUsername().length() <= 20, "用户名长度应小于20位");
        Preconditions.checkArgument(registerInfo.getPassword().length() >= 6, "密码长度应大于6位");

        Preconditions.checkArgument(registerInfo.getPassword().equals(registerInfo.getConfirm()), "两次密码不一致");
        Preconditions.checkArgument(EMAIL_PATTERN.matcher(registerInfo.getEmail()).matches(), "邮箱格式错误");
    }

}
