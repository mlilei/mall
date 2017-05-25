package com.sy.mall.Service;

import com.sun.xml.internal.bind.v2.TODO;
import com.sy.mall.MallException;
import com.sy.mall.common.enums.OrderStatusEnum;
import com.sy.mall.mapper.OrderDetailMapper;
import com.sy.mall.mapper.OrderMapper;
import com.sy.mall.pojo.Order;
import com.sy.mall.pojo.User;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by 李磊
 * on 17-4-29.
 */
@Service
public class OrderService extends BaseService<Order> {
    private static final String SOURCE_WEB = "0";

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderDetailService orderDetailService;

    @Resource
    public void setMapper(OrderMapper orderMapper) {
        super.setMapper(orderMapper);
    }


    /**
     * 生成订单号
     * MMdd+订单来源+三位随机数+userId后四位
     */
    public static String createOrderNumber(User user) {
        DateTime dateTime = new DateTime();
        String time = String.valueOf(System.currentTimeMillis());
        String userId = "0000" + String.valueOf(user.getUserId());
        return "" + dateTime.getMonthOfYear() + dateTime.dayOfMonth() + "-" +
                SOURCE_WEB + time.substring(time.length() - 3) + "-" +
                userId.substring(userId.length() - 4);

    }

    public int create(String orderNumber, User user, List<Integer> cartIdList) {
        Order order = new Order();
        order.setOrderNum(orderNumber);
        order.setUserId(user.getUserId());
        order.setStatus(OrderStatusEnum.BE_PERFECTED);
        order.setCreateTime(new Date());
        BigDecimal amount = orderDetailService.batchSave(orderNumber, cartIdList);
        order.setAmount(amount);
        return orderMapper.insertSelective(order);
    }

    public int perfected(User user, String orderNumber, String address, String addressee, String phone) {
        Order order = new Order();
        order.setOrderNum(orderNumber);
        order = orderMapper.selectOne(order);
        if (!user.getUserId().equals(order.getUserId())) {
            LOGGER.error("要完善的订单不属于当前用户:{}{}", order, user);
            throw MallException.ERROR;
        }
        order.setAddress(address);
        order.setAddressee(addressee);
        order.setPhone(phone);
        order.setStatus(OrderStatusEnum.UNPAID);
        return orderMapper.updateByPrimaryKey(order);
    }

    public int payment(String orderNumber) {
        Order order = new Order();
        order.setOrderNum(orderNumber);
        order = orderMapper.selectOne(order);
        order.setStatus(OrderStatusEnum.PAID);
        return orderMapper.updateByPrimaryKey(order);
    }

    // TODO: 2017/5/26  
    public void query(User user) {
        Order order = new Order();
        order.setUserId(user.getUserId());
        List<Order> select = orderMapper.select(order);

    }
}
