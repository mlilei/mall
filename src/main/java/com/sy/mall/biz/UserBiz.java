package com.sy.mall.biz;

import com.sy.mall.MallException;
import com.sy.mall.ResponseResult;
import com.sy.mall.Service.UserService;
import com.sy.mall.common.enums.GenderEnum;
import com.sy.mall.pojo.User;
import com.sy.mall.pojo.dto.RegisterInfoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by 李磊
 * on 2017/5/1.
 */
@Component
public class UserBiz {
    @Resource
    private UserService userService;

    public ResponseResult register(RegisterInfoDTO registerInfo) {
        //检查用户名
        if (null != userService.getUserByUsername(registerInfo.getUsername())) {
            throw new MallException("用户名已存在");
        }

        User user = new User();
        BeanUtils.copyProperties(registerInfo, user);
        user.setCreateTime(new Date());
        user.setGender(GenderEnum.UNKNOW);
        userService.save(user);
        return ResponseResult.createSuccessResult();
    }
}
