package com.sy.mall.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lilei on 17-3-22.
 */
public enum GenderEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    private int code;
    private String message;

    private static final Map<Integer, GenderEnum> map = new HashMap();

    static {
        for (GenderEnum genderEnum : values()) {
            map.put(genderEnum.getCode(), genderEnum);
        }
    }

    GenderEnum(int code, String message) {
        this.code = code;
        this.message = message;
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
