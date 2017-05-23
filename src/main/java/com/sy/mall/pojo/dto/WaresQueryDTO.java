package com.sy.mall.pojo.dto;

import com.sy.mall.common.enums.WaresOrderEnum;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lilei on 2017/5/23.
 */
public class WaresQueryDTO implements Serializable {
    private Integer waresId;
    private String waresName;
    private String waresType;
    private BigDecimal priceLow;
    private BigDecimal priceHige;
    private Integer score;
    private WaresOrderEnum waresOrderEnum;
    private Integer desc;

    public Integer getWaresId() {
        return waresId;
    }

    public void setWaresId(Integer waresId) {
        this.waresId = waresId;
    }

    public Integer getDesc() {
        return desc;
    }

    public void setDesc(Integer desc) {
        this.desc = desc;
    }

    public String getWaresName() {
        return waresName;
    }

    public void setWaresName(String waresName) {
        this.waresName = waresName;
    }

    public String getWaresType() {
        return waresType;
    }

    public void setWaresType(String waresType) {
        this.waresType = waresType;
    }

    public BigDecimal getPriceLow() {
        return priceLow;
    }

    public void setPriceLow(BigDecimal priceLow) {
        this.priceLow = priceLow;
    }

    public BigDecimal getPriceHige() {
        return priceHige;
    }

    public void setPriceHige(BigDecimal priceHige) {
        this.priceHige = priceHige;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public WaresOrderEnum getWaresOrderEnum() {
        return waresOrderEnum;
    }

    public void setWaresOrderEnum(WaresOrderEnum waresOrderEnum) {
        this.waresOrderEnum = waresOrderEnum;
    }

    @Override
    public String toString() {
        return "WaresQueryDTO{" +
                "waresId=" + waresId +
                ", waresName='" + waresName + '\'' +
                ", waresType='" + waresType + '\'' +
                ", priceLow=" + priceLow +
                ", priceHige=" + priceHige +
                ", score=" + score +
                ", waresOrderEnum=" + waresOrderEnum +
                ", desc=" + desc +
                '}';
    }
}
