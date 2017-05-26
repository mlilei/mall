package com.sy.mall.pojo.dto;

import java.math.BigDecimal;

/**
 * Created by lilei on 2017/5/26.
 */
public class WaresExhibitionDTO {
    private Long waresId;
    private String waresName;
    private String imageUrl;
    private String memory;
    private String color;
    private BigDecimal price;
    private Integer waresNum;

    public Long getWaresId() {
        return waresId;
    }

    public void setWaresId(Long waresId) {
        this.waresId = waresId;
    }

    public String getWaresName() {
        return waresName;
    }

    public void setWaresName(String waresName) {
        this.waresName = waresName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getWaresNum() {
        return waresNum;
    }

    public void setWaresNum(Integer waresNum) {
        this.waresNum = waresNum;
    }

    @Override
    public String toString() {
        return "WaresExhibitionDTO{" +
                "waresId=" + waresId +
                ", waresName='" + waresName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", memory='" + memory + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", waresNum=" + waresNum +
                '}';
    }
}
