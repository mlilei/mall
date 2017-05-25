package com.sy.mall.pojo.dto;

import java.math.BigDecimal;

/**
 * Created by lilei on 2017/5/25.
 */
public class CartDTO {
    private Long id;
    private String imageUrl;
    private String waresName;
    private String color;
    private String memory;
    //单价
    private BigDecimal price;
    //单价*数量
    private BigDecimal waresPrice;
    private Integer waresNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWaresName() {
        return waresName;
    }

    public void setWaresName(String waresName) {
        this.waresName = waresName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWaresPrice() {
        return waresPrice;
    }

    public void setWaresPrice(BigDecimal waresPrice) {
        this.waresPrice = waresPrice;
    }

    public Integer getWaresNum() {
        return waresNum;
    }

    public void setWaresNum(Integer waresNum) {
        this.waresNum = waresNum;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", waresName='" + waresName + '\'' +
                ", color='" + color + '\'' +
                ", memory='" + memory + '\'' +
                ", price=" + price +
                ", waresPrice=" + waresPrice +
                ", waresNum=" + waresNum +
                '}';
    }
}
