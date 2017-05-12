package com.sy.mall.Service;

import com.sy.mall.mapper.UserMapper;
import com.sy.mall.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 李磊
 * on 17-4-29.
 */
@Service
public class UserService extends BaseService<User> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private static final String DEFAULT_DATE = "1971-01-01 00:00:00";

    @Resource
    private UserMapper userMapper;

    @Resource
    public void setMapper(UserMapper userMapper) {
        super.setMapper(userMapper);
    }

    public int saveSelective(User user) {
        return userMapper.insertSelective(user);
    }

    public int updateByPrimaryKeySelective(User user) {
        return mapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 通过用户名,手机号,邮箱查询用户
     */
    public User getUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        List<User> userList = userMapper.select(user);
        return userList.size() == 0 ? null : userList.get(0);
    }

    public User show(User user) {
        user.setUserId(null);
        user.setPassword(null);
        user.setStatus(null);
        user.setCreateTime(null);
        user.setUpdateTime(null);
        return user;
    }
}
