package com.sy.mall.Service;

import com.sy.mall.mapper.UserMapper;
import com.sy.mall.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 李磊
 * on 17-4-29.
 */
@Service
public class UserService extends BaseService<User> {

    @Resource
    private UserMapper userMapper;

    @Resource
    public void setMapper(UserMapper userMapper) {
        super.setMapper(userMapper);
    }

    /**
     * 通过用户名,手机号,邮箱查询用户
     */
    public User getUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        List<User> userList = userMapper.select(user);
        return userList == null ? null : userList.get(0);
    }

}
