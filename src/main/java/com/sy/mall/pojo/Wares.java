package com.sy.mall.pojo;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by acm on 2017/5/15.
 */
public class Wares {
    @Id
    private Long waresId;
    private String waresName;
    private String imageUrl;
    private String waresType;
    private BigDecimal price;
    private String memory;
    private String color;
    private String detail;
    private Integer score;
    private Integer commentNumber;
    private Date createTime;
    private Date updateTime;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

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

    public String getWaresType() {
        return waresType;
    }

    public void setWaresType(String waresType) {
        this.waresType = waresType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
                ", memory='" + memory + '\'' +
                ", color='" + color + '\'' +
                ", detail='" + detail + '\'' +
                ", score=" + score +
                ", commentNumber=" + commentNumber +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}