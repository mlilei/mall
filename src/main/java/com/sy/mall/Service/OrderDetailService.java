package com.sy.mall.Service;

import com.sy.mall.mapper.CartMapper;
import com.sy.mall.mapper.OrderDetailMapper;
import com.sy.mall.mapper.WaresMapper;
import com.sy.mall.pojo.Cart;
import com.sy.mall.pojo.OrderDetail;
import com.sy.mall.pojo.Wares;
import com.sy.mall.pojo.dto.OrderExhibitionDTO;
import com.sy.mall.pojo.dto.WaresExhibitionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    private WaresMapper waresMapper;

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

    public void queryOrderDetail(String orderNum, OrderExhibitionDTO var) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNumber(orderNum);
        List<OrderDetail> orderDetailList = orderDetailMapper.select(orderDetail);
        for (OrderDetail detail : orderDetailList) {
            WaresExhibitionDTO waresExhibitionDTO = new WaresExhibitionDTO();
            BeanUtils.copyProperties(detail, waresExhibitionDTO);
            Wares wares = waresMapper.selectByPrimaryKey(detail.getWaresId());
            //BeanUtils.copyProperties(wares, waresExhibitionDTO);
            waresExhibitionDTO.setWaresName(wares.getWaresName());
            waresExhibitionDTO.setImageUrl(wares.getImageUrl());
            waresExhibitionDTO.setColor(detail.getWaresColor());
            waresExhibitionDTO.setMemory(detail.getWaresMemory());
            var.getWaresList().add(waresExhibitionDTO);
        }
    }
}
