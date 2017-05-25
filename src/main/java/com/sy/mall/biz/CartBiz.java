package com.sy.mall.biz;

import com.github.pagehelper.PageInfo;
import com.sy.mall.ResponseResult;
import com.sy.mall.Service.CartService;
import com.sy.mall.common.util.ShiroUtils;
import com.sy.mall.pojo.User;
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

    public ResponseResult queryCart(int pageNum, int pageSize) {
        User u = (User) ShiroUtils.getSubject().getPrincipal();
        PageInfo<CartDTO> pageInfo = cartService.queryCart(u.getUserId(), pageNum, pageSize);
        ResponseResult result = ResponseResult.createSuccessResult();
        result.setData(pageInfo);
        return result;
    }


    public ResponseResult addWares(Long waresId, String color, String memory) {


        return null;
    }
}
