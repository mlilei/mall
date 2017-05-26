package com.sy.mall.controller;

import com.sy.mall.ResponseResult;
import com.sy.mall.biz.OrderBiz;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lilei on 2017/5/25.
 */
@Controller
@ResponseBody
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderBiz orderBiz;


    @RequiresAuthentication
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseResult query(@RequestParam Integer pageNum, Integer pageSize) {
        if (pageSize == null) {
            pageSize = 20;
        }
        return orderBiz.query(pageNum, pageSize);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseResult create(List<Integer> cartIdList) {
        return orderBiz.create(cartIdList);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/perfected", method = RequestMethod.POST)
    public ResponseResult perfected(String orderNumber, String address, String addressee, String phone) {
        return orderBiz.perfected(orderNumber, address, addressee, phone);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public ResponseResult payment(String orderNumber) {
        return orderBiz.payment(orderNumber);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseResult delete(String orderNumber) {
        return orderBiz.delete(orderNumber);
    }


}
