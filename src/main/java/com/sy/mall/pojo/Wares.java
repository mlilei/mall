package com.sy.mall.pojo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by acm on 2017/5/15.
 */
public class Wares {
    private BigInteger waresId;
    private String waresName;
    private String imageUrl;
    private Integer waresType;
    private BigDecimal price;
    private String color;
    private String size;
    private String resolution;
    private String memory;
    private String cpu;
    private Date createTime;
    private Date updateTime;

    public BigInteger getWaresId() {
        return waresId;
    }

    public void setWaresId(BigInteger waresId) {
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

    public Integer getWaresType() {
        return waresType;
    }

    public void setWaresType(Integer waresType) {
        this.waresType = waresType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
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
        return "Wares{" +
                "waresId=" + waresId +
                ", waresName='" + waresName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", waresType=" + waresType +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", resolution='" + resolution + '\'' +
                ", memory='" + memory + '\'' +
                ", cpu='" + cpu + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
