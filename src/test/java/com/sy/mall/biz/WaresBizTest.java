package com.sy.mall.biz;

import com.sy.mall.BaseTest;
import com.sy.mall.ResponseResult;
import com.sy.mall.common.util.JsonUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 李磊
 * on 2017/5/12.
 */
public class WaresBizTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WaresBizTest.class);

    @Resource
    private WaresBiz waresBiz;

    @Test
    public void register() throws InvocationTargetException, IllegalAccessException {
        ResponseResult wares = waresBiz.getWares(1);
        System.out.println(JsonUtil.toJson(wares));
    }


}
