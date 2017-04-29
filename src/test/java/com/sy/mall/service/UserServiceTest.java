package com.sy.mall.service;

import com.github.pagehelper.PageInfo;
import com.sy.mall.BaseTest;
import com.sy.mall.Service.UserService;
import com.sy.mall.common.util.JsonUtil;
import com.sy.mall.dao.UserDaoTest;
import com.sy.mall.model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by lilei on 17-4-29.
 */
public class UserServiceTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoTest.class);
    @Resource
    private UserService userService;

    @Test
    public void SaveTest() {
        PageInfo<User> pageInfo = userService.selectPage(1, 1);
        LOGGER.info(JsonUtil.toJson(pageInfo));
    }
}
