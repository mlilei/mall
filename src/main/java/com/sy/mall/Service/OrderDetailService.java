package com.sy.mall.Service;

import com.sy.mall.mapper.CartMapper;
import com.sy.mall.mapper.OrderDetailMapper;
import com.sy.mall.pojo.Cart;
import com.sy.mall.pojo.OrderDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李磊
 * on 17-4-29.
 */
@Service
public class OrderDetailService extends BaseService<OrderDetail> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailService.class);

    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private CartMapper cartMapper;

    @Resource
    public void setMapper(OrderDetailMapper orderDetailMapper) {
        super.setMapper(orderDetailMapper);
    }


    public BigDecimal batchSave(String orderNumber, List<Integer> cartIdList) {
        BigDecimal amount = new BigDecimal(0);
        for (Integer cartId : cartIdList) {
            Cart cart = cartMapper.selectByPrimaryKey(new Long(cartId));
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setWaresId(cart.getWaresId());
            orderDetail.setWaresNum(cart.getWaresNum());
            orderDetail.setWaresPrice(cart.getWaresPrice().divide(BigDecimal.valueOf(cart.getWaresNum())));
            orderDetail.setWaresColor(cart.getColor());
            orderDetail.setWaresMemory(cart.getMemory());
            orderDetail.setOrderNumber(orderNumber);
            orderDetailMapper.insertSelective(orderDetail);

            amount = amount.add(cart.getWaresPrice());
        }
        return amount;
    }
}
