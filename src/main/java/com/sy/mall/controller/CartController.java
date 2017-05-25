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
@RequiresAuthentication
public class CartController {
    @Resource
    private CartBiz cartBiz;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseResult get(int pageNum, int pageSize) {
        return cartBiz.queryCart(pageNum, pageSize);
    }

    @RequestMapping(value = "/addWares", method = RequestMethod.POST)
    public ResponseResult addWares(Long waresId, String color, String memory) {

        return cartBiz.addWares(waresId, color, memory);
    }

    @RequestMapping(value = "/addOne", method = RequestMethod.POST)
    public ResponseResult addOne() {

        return null;
    }

    @RequestMapping(value = "/removeWares", method = RequestMethod.POST)
    public ResponseResult removeWares() {

        return null;
    }

    @RequestMapping(value = "/removeOne", method = RequestMethod.POST)
    public ResponseResult removeOne() {

        return null;
    }
}
