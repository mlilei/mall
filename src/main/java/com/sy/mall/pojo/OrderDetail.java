package com.sy.mall.pojo;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by acm on 2017/5/15.
 */
public class OrderDetail {
    @Id
    private Long orderDetailId;
    private Long waresId;
    private Integer waresNum;
    private BigDecimal waresPrice;
    private String waresColor;
    private String waresMemory;
    private String orderNumber;
    private Date createTime;
    private Date updateTime;

    public String getWaresColor() {
        return waresColor;
    }

    public void setWaresColor(String waresColor) {
        this.waresColor = waresColor;
    }

    public String getWaresMemory() {
        return waresMemory;
    }

    public void setWaresMemory(String waresMemory) {
        this.waresMemory = waresMemory;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getWaresId() {
        return waresId;
    }

    public void setWaresId(Long waresId) {
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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
                ", waresColor='" + waresColor + '\'' +
                ", waresMemory='" + waresMemory + '\'' +
                ", orderNumber=" + orderNumber +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
