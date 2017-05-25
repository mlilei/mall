package com.sy.mall.pojo;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lilei on 2017/5/25.
 */
public class Cart {
    @Id
    private Long id;
    private Long waresId;
    private Integer waresNum;
    private BigDecimal waresPrice;
    private Long userId;
    private String memory;
    private String color;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        return "Cart{" +
                "id=" + id +
                ", waresId=" + waresId +
                ", waresNum=" + waresNum +
                ", waresPrice=" + waresPrice +
                ", userId=" + userId +
                ", memory='" + memory + '\'' +
                ", color='" + color + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
