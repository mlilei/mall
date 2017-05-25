package com.sy.mall.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.mall.MallException;
import com.sy.mall.mapper.CartMapper;
import com.sy.mall.mapper.WaresMapper;
import com.sy.mall.pojo.Cart;
import com.sy.mall.pojo.User;
import com.sy.mall.pojo.Wares;
import com.sy.mall.pojo.dto.CartDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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

    public int addWares(Long userId, Wares wares, String color, String memory) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setWaresId(wares.getWaresId());
        cart.setColor(color);
        cart.setMemory(memory);
        Cart cartA = cartMapper.selectOne(cart);
        if (cartA == null) {
            cart.setWaresNum(1);
            cart.setWaresPrice(wares.getPrice());
            cart.setCreateTime(new Date());
            return cartMapper.insert(cart);
        } else {
            cartA.setWaresNum(cartA.getWaresNum() + 1);
            cartA.setWaresPrice(wares.getPrice().add(cartA.getWaresPrice()));
            return cartMapper.updateByPrimaryKey(cartA);
        }
    }

    public int addOne(User user, Integer cartId) {
        Cart cart = cartMapper.selectByPrimaryKey(new Long(cartId));
        if (!cart.getUserId().equals(user.getUserId())) {
            LOGGER.error("增加的商品不属于该用户：{}", user);
            throw MallException.ERROR;
        }
        Wares wares = waresMapper.selectByPrimaryKey(cart.getWaresId());
        cart.setWaresNum(cart.getWaresNum() + 1);
        cart.setWaresPrice(cart.getWaresPrice().add(wares.getPrice()));
        return cartMapper.updateByPrimaryKey(cart);
    }

    public int removeWares(User user, Integer cartId) {
        Cart cart = cartMapper.selectByPrimaryKey(new Long(cartId));
        if (user.getUserId().equals(cart.getUserId())) {
            return cartMapper.delete(cart);
        }
        throw MallException.ERROR;
    }

    public int removeOne(User user, Integer cartId) {
        Cart cart = cartMapper.selectByPrimaryKey(new Long(cartId));
        if (!cart.getUserId().equals(user.getUserId())) {
            LOGGER.error("增加的商品不属于该用户：{}", user);
            throw MallException.ERROR;
        }
        if (cart.getWaresNum() < 1) {
            LOGGER.error("购物车内不存在该商品:{}", cart);
            throw MallException.ERROR;
        }
        Wares wares = waresMapper.selectByPrimaryKey(cart.getWaresId());
        cart.setWaresNum(cart.getWaresNum() - 1);
        cart.setWaresPrice(cart.getWaresPrice().subtract(wares.getPrice()));
        if (0 == cart.getWaresNum()) {
            return cartMapper.deleteByPrimaryKey(new Long(cartId));
        } else {
            return cartMapper.updateByPrimaryKey(cart);
        }
    }
}
