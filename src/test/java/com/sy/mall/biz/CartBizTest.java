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

    @Test
    public void testadd() {
        ResponseResult responseResult = cartBiz.addWares(3, "亮黑色", "32GB");
        System.out.println(JsonUtil.toJson(responseResult));
    }

    @Test
    public void addOne() {
        ResponseResult responseResult = cartBiz.addOne(4);
        System.out.println(JsonUtil.toJson(responseResult));
    }

    @Test
    public void removeWares() {
        ResponseResult responseResult = cartBiz.removeWares(4);
        System.out.println(JsonUtil.toJson(responseResult));
    }

    @Test
    public void removeOne() {
        ResponseResult responseResult = cartBiz.removeOne(1);
        System.out.println(JsonUtil.toJson(responseResult));
    }
}
