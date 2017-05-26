package com.sy.mall.biz;

import com.github.pagehelper.PageInfo;
import com.sy.mall.ResponseResult;
import com.sy.mall.Service.OrderService;
import com.sy.mall.common.util.ShiroUtils;
import com.sy.mall.pojo.User;
import com.sy.mall.pojo.dto.OrderExhibitionDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lilei on 2017/5/25.
 */
@Component
public class OrderBiz {
    @Resource
    private OrderService orderService;

    public ResponseResult create(List<Integer> cartIdList) {
        //User user = new User();
        //user.setUserId(5L);
        User user = (User) ShiroUtils.getSubject().getPrincipal();
        String orderNumber = OrderService.createOrderNumber(user);
        orderService.create(orderNumber, user, cartIdList);
        ResponseResult result = ResponseResult.createSuccessResult();
        result.setData(orderNumber);
        return result;
    }

    public ResponseResult perfected(String orderNumber, String address, String addressee, String phone) {
        User user = (User) ShiroUtils.getSubject().getPrincipal();
        orderService.perfected(user, orderNumber, address, addressee, phone);
        ResponseResult result = ResponseResult.createSuccessResult();
        result.setData(orderNumber);
        return result;
    }

    public ResponseResult payment(String orderNumber) {
        orderService.payment(orderNumber);
        return ResponseResult.createSuccessResult();
    }

    public ResponseResult query(Integer pageNum, Integer pageSize) {
        //User user = new User();
        //user.setUserId(5L);
        User user = (User) ShiroUtils.getSubject().getPrincipal();
        PageInfo pageInfo = orderService.query(user, pageNum, pageSize);
        ResponseResult result = ResponseResult.createSuccessResult();
        result.setData(pageInfo);
        return result;
    }

    public ResponseResult delete(String orderNumber) {
        //User user = new User();
        //user.setUserId(5L);
        User user = (User) ShiroUtils.getSubject().getPrincipal();
        orderService.delete(user, orderNumber);
        return ResponseResult.createSuccessResult();
    }

    public ResponseResult queryOne(String orderNum) {
        User user = (User) ShiroUtils.getSubject().getPrincipal();
        //User user = new User();
        //user.setUserId(5L);
        OrderExhibitionDTO orderExhibitionDTO = orderService.queryOne(user, orderNum);
        ResponseResult result = ResponseResult.createSuccessResult();
        result.setData(orderExhibitionDTO);
        return result;
    }
}
