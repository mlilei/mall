package com.sy.mall.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.mall.mapper.CartMapper;
import com.sy.mall.mapper.WaresMapper;
import com.sy.mall.pojo.Cart;
import com.sy.mall.pojo.Wares;
import com.sy.mall.pojo.dto.CartDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李磊
 * on 17-4-29.
 */
@Service
public class CartService extends BaseService<Cart> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

    @Resource
    private CartMapper cartMapper;
    @Resource
    private WaresMapper waresMapper;

    @Resource
    public void setMapper(CartMapper cartMapper) {
        super.setMapper(cartMapper);
    }


    public PageInfo<CartDTO> queryCart(Long userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Cart> cartList = cartMapper.listCart(userId);
        List<CartDTO> cartDTOList = new ArrayList<>();
        for (Cart cart : cartList) {
            CartDTO cartDTO = new CartDTO();
            Wares wares = waresMapper.selectByPrimaryKey(cart.getWaresId());

            BeanUtils.copyProperties(wares, cartDTO);
            BeanUtils.copyProperties(cart, cartDTO);

            cartDTOList.add(cartDTO);
        }
        PageInfo<CartDTO> pageInfo = new PageInfo<>(cartDTOList);


        return pageInfo;
    }
}
