package com.sy.mall.pojo.dto;

import com.sy.mall.common.enums.OrderStatusEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lilei on 2017/5/26.
 */
public class OrderExhibitionDTO {
    private String orderNum;
    private BigDecimal amount;
    private OrderStatusEnum status;
    private String address;
    private String addressee;
    private String phone;
    private Date createTime;

    private List<WaresExhibitionDTO> waresList = new ArrayList<>();


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<WaresExhibitionDTO> getWaresList() {
        return waresList;
    }

    public void setWaresList(List<WaresExhibitionDTO> waresList) {
        this.waresList = waresList;
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

    @Override
    public String toString() {
        return "OrderExhibitionDTO{" +
                "orderNum='" + orderNum + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", addressee='" + addressee + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", waresList=" + waresList +
                '}';
    }
}
