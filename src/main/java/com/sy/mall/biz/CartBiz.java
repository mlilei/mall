package com.sy.mall.biz;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.sy.mall.ResponseResult;
import com.sy.mall.Service.CartService;
import com.sy.mall.Service.WaresService;
import com.sy.mall.common.util.ShiroUtils;
import com.sy.mall.pojo.User;
import com.sy.mall.pojo.Wares;
import com.sy.mall.pojo.dto.CartDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by lilei on 2017/5/25.
 */
@Component
public class CartBiz {
    @Resource
    private CartService cartService;
    @Resource
    private WaresService waresService;

    public ResponseResult queryCart(Integer pageNum, Integer pageSize) {
        Preconditions.checkNotNull(pageNum);
        User u = (User) ShiroUtils.getSubject().getPrincipal();
        PageInfo<CartDTO> pageInfo = cartService.queryCart(u.getUserId(), pageNum, pageSize);
        ResponseResult result = ResponseResult.createSuccessResult();
        result.setData(pageInfo);
        return result;
    }


    public ResponseResult addWares(Integer waresId, String color, String memory) {
        User u = (User) ShiroUtils.getSubject().getPrincipal();
        Wares wares = waresService.getWares(waresId);
        cartService.addWares(u.getUserId(), wares, color, memory);
        return ResponseResult.createSuccessResult();
    }

    public ResponseResult addOne(Integer cartId) {
        User u = (User) ShiroUtils.getSubject().getPrincipal();
        cartService.addOne(u, cartId);
        return ResponseResult.createSuccessResult();
    }

    public ResponseResult removeWares(Integer cartId) {
        User u = (User) ShiroUtils.getSubject().getPrincipal();
        cartService.removeWares(u, cartId);
        return ResponseResult.createSuccessResult();
    }

    public ResponseResult removeOne(Integer cartId) {
        User u = (User) ShiroUtils.getSubject().getPrincipal();
        cartService.removeOne(u, cartId);
        return ResponseResult.createSuccessResult();
    }
}
