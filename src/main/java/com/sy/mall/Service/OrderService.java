package com.sy.mall.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Ordering;
import com.sy.mall.MallException;
import com.sy.mall.common.enums.OrderStatusEnum;
import com.sy.mall.mapper.OrderDetailMapper;
import com.sy.mall.mapper.OrderMapper;
import com.sy.mall.pojo.Order;
import com.sy.mall.pojo.OrderDetail;
import com.sy.mall.pojo.User;
import com.sy.mall.pojo.dto.OrderExhibitionDTO;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by 李磊
 * on 17-4-29.
 */
@Service
public class OrderService extends BaseService<Order> {
    private static final String SOURCE_WEB = "0";
    private static final String MMDD = "MMdd";

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderDetailService orderDetailService;
    @Resource
    private OrderDetailMapper orderDetailMapper;

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
        return dateTime.toString(MMDD) + "-" +
                SOURCE_WEB + time.substring(time.length() - 3) + "-" +
                userId.substring(userId.length() - 4);

    }

    @Transactional
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

    public PageInfo query(User user, Integer pageNum, Integer pageSize) {
        Order order = new Order();
        order.setUserId(user.getUserId());
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.select(order);
        PageInfo pageInfo = new PageInfo<>(orderList);

        Ordering<Order> orderOrdering = Ordering.natural().reverse().onResultOf(Order::getCreateTime);
        Collections.sort(orderList, orderOrdering);

        List<OrderExhibitionDTO> data = new ArrayList<>();
        for (Order var : orderList) {
            OrderExhibitionDTO var1 = new OrderExhibitionDTO();
            BeanUtils.copyProperties(var, var1);
            orderDetailService.queryOrderDetail(var.getOrderNum(), var1);
            data.add(var1);
        }
        pageInfo.setList(data);
        return pageInfo;
    }

    @Transactional
    public int delete(User user, String orderNumber) {
        Order order = new Order();
        order.setOrderNum(orderNumber);
        order = orderMapper.selectOne(order);
        if (order.getStatus().equals(OrderStatusEnum.PAID)) {
            throw new MallException("订单已完成");
        }
        if (!order.getUserId().equals(user.getUserId())) {
            throw new MallException("要删除的订单不属于该用户");
        }
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNumber(orderNumber);
        orderDetailMapper.delete(orderDetail);
        return orderMapper.delete(order);
    }
}
