package com.sy.mall.mapper;

import com.sy.mall.pojo.Cart;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 李磊
 * on 2017/3/27.
 */
public interface CartMapper extends Mapper<Cart> {

    List<Cart> listCart(Long userId);
}
