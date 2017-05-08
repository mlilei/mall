package com.sy.mall.Service;

import com.sy.mall.mapper.UserMapper;
import com.sy.mall.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 李磊
 * on 17-4-29.
 */
@Service
public class UserService extends BaseService<User> {

    @Resource
    private UserMapper userMapper;

    @Resource(name = "userMapper")
    public void setMapper(UserMapper userMapper) {
        super.setMapper(userMapper);
    }

    /**
     * 通过用户名,手机号,邮箱查询用户
     */
    public User getUser(String principal) {

        return null;
    }

}
