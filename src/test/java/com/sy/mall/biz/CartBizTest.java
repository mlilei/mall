package com.sy.mall.biz;

import com.sy.mall.BaseTest;
import com.sy.mall.ResponseResult;
import com.sy.mall.common.util.JsonUtil;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by lilei on 2017/5/25.
 */
public class CartBizTest extends BaseTest {
    @Resource
    private CartBiz cartBiz;

    @Test
    public void test() {
        ResponseResult result = cartBiz.queryCart(1, 2);
        System.out.println(JsonUtil.toJson(result));
    }
}
