package com.sy.mall.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by 李磊
 * on 2017/5/15.
 */
public enum OrderStatusEnum {
    BE_PERFECTED(0, "待完善"),
    UNPAID(1, "未支付"),
    PAID(2, "已支付");

    OrderStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    private static final Map<Integer, OrderStatusEnum> map = Maps.newHashMap();

    static {
        for (OrderStatusEnum orderStatusEnum : values()) {
            map.put(orderStatusEnum.getCode(), orderStatusEnum);
        }
    }

    public int code() {
        return code;
    }

    public static OrderStatusEnum codeOf(int code) {
        return map.get(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
