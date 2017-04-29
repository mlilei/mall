package com.sy.mall.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by 李磊
 * on 17-4-29.
 */
public enum UserStatusEnum {
    NORMAL(0, "正常"),
    NOT_ACTIVE(1, "未激活"),
    DISABLE(2, "禁用");

    UserStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    private static final Map<Integer, UserStatusEnum> map = Maps.newHashMap();

    static {
        for (UserStatusEnum userStatusEnum : values()) {
            map.put(userStatusEnum.getCode(), userStatusEnum);
        }
    }

    public int code() {
        return code;
    }

    public static UserStatusEnum codeOf(int code) {
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
