package com.sy.mall.pojo;

import java.util.Date;

/**
 * Created by acm on 2017/5/15.
 */
public class WaresType {
    private Integer waresTypeId;
    private String typeName;
    private Date createTime;
    private Date updateTime;

    public Integer getWaresTypeId() {
        return waresTypeId;
    }

    public void setWaresTypeId(Integer waresTypeId) {
        this.waresTypeId = waresTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        return "WaresType{" +
                "waresTypeId=" + waresTypeId +
                ", typeName='" + typeName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
