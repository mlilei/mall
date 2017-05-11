package com.sy.mall.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by 李磊
 * on 17-3-22.
 */
public enum GenderEnum {
    UNKNOW(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女");

    GenderEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    private static final Map<Integer, GenderEnum> map = Maps.newHashMap();

    static {
        for (GenderEnum genderEnum : values()) {
            map.put(genderEnum.getCode(), genderEnum);
        }
    }

    public int code() {
        return code;
    }

    public static GenderEnum codeOf(int code) {
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
