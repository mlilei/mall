package com.sy.mall.biz;

import com.sy.mall.BaseTest;
import com.sy.mall.ResponseResult;
import com.sy.mall.common.util.JsonUtil;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilei on 2017/5/26.
 */
public class OrderBizTest extends BaseTest {
    @Resource
    private OrderBiz orderBiz;

    @Test
    public void create() {
        List<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(27);
        list.add(28);
        ResponseResult result = orderBiz.create(list);
        System.out.println(JsonUtil.toJson(result));
    }

    @Test
    public void perfected() {
        ResponseResult result = orderBiz.perfected("0526-0969-0005", "长春工业大学", "李磊", "12345678910");
        System.out.println(result);
    }

    @Test
    public void payment() {
        ResponseResult payment = orderBiz.payment("0526-0969-0005");
        System.out.println(payment);
    }

    @Test
    public void query() {
        ResponseResult query = orderBiz.query(1, 5);
        System.out.println(JsonUtil.toJson(query));
    }

    @Test
    public void delete() {
        ResponseResult r = orderBiz.delete("0526-0215-0005");
        System.out.println(JsonUtil.toJson(r));
    }
}
