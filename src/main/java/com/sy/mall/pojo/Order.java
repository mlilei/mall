package com.sy.mall.pojo;

import com.sy.mall.common.enums.OrderStatusEnum;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by acm on 2017/5/15.
 */
public class Order {
    private BigInteger orderId;
    private Integer orderNum;
    private BigInteger userId;
    private OrderStatusEnum status;
    private String address;
    private String addressee;
    private String phone;
    private BigDecimal amount;
    private Date createTime;
    private Date updateTime;

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
        return "Order{" +
                "orderId=" + orderId +
                ", orderNum=" + orderNum +
                ", userId=" + userId +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", addressee='" + addressee + '\'' +
                ", phone='" + phone + '\'' +
                ", amount=" + amount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
