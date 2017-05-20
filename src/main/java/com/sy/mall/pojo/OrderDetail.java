package com.sy.mall.pojo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by acm on 2017/5/15.
 */
public class OrderDetail {
    private BigInteger orderDetailId;
    private BigInteger waresId;
    private Integer waresNum;
    private BigDecimal waresPrice;
    private BigInteger orderId;
    private Date createTime;
    private Date updateTime;

    public BigInteger getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(BigInteger orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public BigInteger getWaresId() {
        return waresId;
    }

    public void setWaresId(BigInteger waresId) {
        this.waresId = waresId;
    }

    public Integer getWaresNum() {
        return waresNum;
    }

    public void setWaresNum(Integer waresNum) {
        this.waresNum = waresNum;
    }

    public BigDecimal getWaresPrice() {
        return waresPrice;
    }

    public void setWaresPrice(BigDecimal waresPrice) {
        this.waresPrice = waresPrice;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", waresId=" + waresId +
                ", waresNum=" + waresNum +
                ", waresPrice=" + waresPrice +
                ", orderId=" + orderId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
