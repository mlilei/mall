package com.sy.mall.pojo;

import java.math.BigInteger;

/**
 * Created by lilei on 2017/5/23.
 */
public class WaresParameter {
    private Integer id;
    private BigInteger waresId;
    private String ParameterType;
    private String ParameterName;
    private String ParameterValue;
    private String ParameterDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getWaresId() {
        return waresId;
    }

    public void setWaresId(BigInteger waresId) {
        this.waresId = waresId;
    }

    public String getParameterType() {
        return ParameterType;
    }

    public void setParameterType(String parameterType) {
        ParameterType = parameterType;
    }

    public String getParameterName() {
        return ParameterName;
    }

    public void setParameterName(String parameterName) {
        ParameterName = parameterName;
    }

    public String getParameterValue() {
        return ParameterValue;
    }

    public void setParameterValue(String parameterValue) {
        ParameterValue = parameterValue;
    }

    public String getParameterDescribe() {
        return ParameterDescribe;
    }

    public void setParameterDescribe(String parameterDescribe) {
        ParameterDescribe = parameterDescribe;
    }

    @Override
    public String toString() {
        return "WaresParameter{" +
                "id=" + id +
                ", waresId=" + waresId +
                ", ParameterType='" + ParameterType + '\'' +
                ", ParameterName='" + ParameterName + '\'' +
                ", ParameterValue='" + ParameterValue + '\'' +
                ", ParameterDescribe='" + ParameterDescribe + '\'' +
                '}';
    }
}
