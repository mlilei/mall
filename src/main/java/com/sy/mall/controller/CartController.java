package com.sy.mall.controller;

import com.sy.mall.ResponseResult;
import com.sy.mall.biz.CartBiz;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lilei on 2017/5/25.
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartBiz cartBiz;

    @RequiresAuthentication
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseResult get(Integer pageNum, Integer pageSize) {
        if (pageSize == null) {
            pageSize = 20;
        }
        return cartBiz.queryCart(pageNum, pageSize);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/addWares", method = RequestMethod.POST)
    public ResponseResult addWares(Integer waresId, String color, String memory) {
        return cartBiz.addWares(waresId, color, memory);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/addOne", method = RequestMethod.POST)
    public ResponseResult addOne(Integer cartId) {
        return cartBiz.addOne(cartId);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/removeWares", method = RequestMethod.POST)
    public ResponseResult removeWares(Integer cartId) {
        return cartBiz.removeWares(cartId);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/removeOne", method = RequestMethod.POST)
    public ResponseResult removeOne(Integer cartId) {
        return cartBiz.removeOne(cartId);
    }
}
