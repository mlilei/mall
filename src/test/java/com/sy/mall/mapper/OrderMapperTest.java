package com.sy.mall.mapper;

import com.sy.mall.BaseTest;
import com.sy.mall.pojo.Order;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by 李磊
 * on 2017/3/27.
 */
public class OrderMapperTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMapperTest.class);

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void test() {
        Order order = new Order();
        order.setOrderNum("0526-2222-2222");
        int i = orderMapper.insertSelective(order);
        System.out.println(i);
    }
}
