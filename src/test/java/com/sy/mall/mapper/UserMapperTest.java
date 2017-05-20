package com.sy.mall.mapper;

import com.sy.mall.BaseTest;
import com.sy.mall.common.util.JsonUtil;
import com.sy.mall.pojo.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 李磊
 * on 2017/3/27.
 */
public class UserMapperTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);

    @Resource
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("chenhao");
        List<User> users = userMapper.select(user);
        LOGGER.info(JsonUtil.toJson(users));
    }

    @Test
    public void test2() {
        User user = new User();
        user.setUserId(1L);
        System.out.println(userMapper.selectByPrimaryKey(1L));
    }
    @Test
    public void save(){
    }
}
