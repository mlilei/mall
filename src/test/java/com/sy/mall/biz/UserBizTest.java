package com.sy.mall.biz;

import com.sy.mall.BaseTest;
import com.sy.mall.ResponseResult;
import com.sy.mall.pojo.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by 李磊
 * on 2017/5/12.
 */
public class UserBizTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBizTest.class);

    @Resource
    private UserBiz userBiz;

    @Test
    public void register(){
        //RegisterInfoDTO registerInfo = new RegisterInfoDTO();
        //registerInfo.setUsername("shiyuu");
        //registerInfo.setPassword("161522");
        //registerInfo.setConfirm("161522");
        //registerInfo.setEmail("1003458499@qq.com");
        //ResponseResult result = userBiz.register(registerInfo);
        //System.out.println(JsonUtil.toJson(result));
    }

    @Test
    public void putUser() {
        User user = new User();
        ResponseResult result = userBiz.putUser(user);
        System.out.println(result);
    }

}
