package com.sy.mall.dao;

import com.alibaba.druid.support.json.JSONUtils;
import com.sy.mall.BaseTest;
import com.sy.mall.common.util.JsonUtil;
import com.sy.mall.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by lilei on 2017/3/27.
 */
@Slf4j
public class UserDaoTest extends BaseTest {
    @Resource
    private UserDao userDao;
    @Test
    public void selectByUsername(){
        User user = userDao.selectByUsername("lilei");
        log.info(JsonUtil.toJson(user));
    }
}
