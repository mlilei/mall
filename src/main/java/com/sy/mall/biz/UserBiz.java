package com.sy.mall.biz;

import com.google.code.kaptcha.Constants;
import com.sy.mall.MallException;
import com.sy.mall.ResponseResult;
import com.sy.mall.Service.UserService;
import com.sy.mall.common.enums.GenderEnum;
import com.sy.mall.common.util.BCrypt;
import com.sy.mall.common.util.CheckParamUtil;
import com.sy.mall.common.util.ShiroUtils;
import com.sy.mall.mapper.UserMapper;
import com.sy.mall.pojo.User;
import com.sy.mall.pojo.dto.LoginInfoDTO;
import com.sy.mall.pojo.dto.RegisterInfoDTO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.sy.mall.common.util.CheckParamUtil.checkLoginParams;
import static com.sy.mall.common.util.CheckParamUtil.checkRegisterParams;

/**
 * Created by 李磊
 * on 2017/5/1.
 */
@Component
public class UserBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBiz.class);
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    public ResponseResult register(RegisterInfoDTO registerInfo) {
        checkRegisterParams(registerInfo);
        //检查用户名
        if (null != userService.getUserByUsername(registerInfo.getUsername())) {
            throw MallException.USERNAME_EXISTS;
        }

        //验证码
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!registerInfo.getCaptcha().equals(kaptcha)) {
            throw MallException.VERIFICATION_CODE_ERROR;
        }

        User user = new User();
        BeanUtils.copyProperties(registerInfo, user);
        user.setCreateTime(new Date());
        user.setGender(GenderEnum.UNKNOW);
        user.setIntroduction("这个人很懒,什么都没留下!");
        user.setPortrait(userService.getRandomPortrait());
        //密码加密
        String salt = BCrypt.gensalt();
        user.setPassword(BCrypt.hashpw(user.getPassword(), salt));

        userMapper.insertSelective(user);
        return ResponseResult.createSuccessResult();
    }

    public ResponseResult login(LoginInfoDTO loginInfo) {
        checkLoginParams(loginInfo);
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!loginInfo.getCaptcha().equals(kaptcha)) {
            throw MallException.VERIFICATION_CODE_ERROR;
        }
        Subject subject = ShiroUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginInfo.getPrincipal(), loginInfo.getCredentials());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录失败:{}", loginInfo, e);
            throw new MallException(MallException.LOGIN_ERROR.getCode(), e.getMessage());
        }
        return ResponseResult.createSuccessResult();
    }

    public ResponseResult getUser() {
        User u = (User) ShiroUtils.getSubject().getPrincipal();
        User user = new User();
        user.setUserId(u.getUserId());
        List<User> userList = userMapper.select(user);
        user = userService.show(userList.get(0));
        ResponseResult successResult = ResponseResult.createSuccessResult();
        successResult.setData(user);
        return successResult;
    }

    public ResponseResult putUser(User user) {
        CheckParamUtil.checkPutUserParams(user);
        User u = (User) ShiroUtils.getSubject().getPrincipal();

        //username字段不允许修改
        if (!u.getUsername().equals(user.getUsername())) {
            throw MallException.PARAMS_INVALID;
        }

        user.setUserId(u.getUserId());
        user.setPassword(null);
        user.setStatus(null);
        user.setCreateTime(null);
        user.setUpdateTime(null);

        userMapper.updateByPrimaryKeySelective(user);
        return ResponseResult.createSuccessResult();
    }
}
