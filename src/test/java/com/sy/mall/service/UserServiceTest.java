package com.sy.mall.service;

import com.sy.mall.BaseTest;
import com.sy.mall.Service.UserService;
import com.sy.mall.mapper.UserMapperTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by 李磊
 * on 17-4-29.
 */
public class UserServiceTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);
    @Resource
    private UserService userService;

    @Test
    public void selectPageTest() {
/*        PageInfo<User> pageInfo = userService.selectPage(1, 20);
        LOGGER.info(JsonUtil.toJson(pageInfo));
        pageInfo = userService.selectPage(2, 20);
        LOGGER.info(JsonUtil.toJson(pageInfo));*/
    }
}
