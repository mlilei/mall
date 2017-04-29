package com.sy.mall.dao;

import com.sy.mall.BaseTest;
import com.sy.mall.common.enums.UserStatusEnum;
import com.sy.mall.common.util.JsonUtil;
import com.sy.mall.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lilei on 2017/3/27.
 */
@Slf4j
public class UserDaoTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoTest.class);

    @Resource
    private UserDao userDao;

    @Test
    public void selectByUsername() {
        User user = userDao.selectByUsername("lei.li");
        LOGGER.info(JsonUtil.toJson(user));
    }
    @Test
    public void test(){
        User user = new User();
        user.setStatus(UserStatusEnum.NOT_ACTIVE);
        List<User> users = userDao.select(user);
        LOGGER.info(JsonUtil.toJson(users));
    }
}
