package com.sy.mall.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by 李磊
 * on 17-3-22.
 */
public enum WaresOrderEnum {
    CREATE_TIME("create_time", "新品"),
    COMMENT_NUMBER("comment_number", "热评"),
    SCORE("score", "好评"),
    PRICE("price", "价格");

    WaresOrderEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    private static final Map<String, WaresOrderEnum> map = Maps.newHashMap();

    static {
        for (WaresOrderEnum waresOrderEnum : values()) {
            map.put(waresOrderEnum.getCode(), waresOrderEnum);
            map.put(waresOrderEnum.getMessage(), waresOrderEnum);
        }
    }

    public String code() {
        return code;
    }

    public static WaresOrderEnum codeOf(String code) {
        return map.get(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
