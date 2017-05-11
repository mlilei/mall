package com.sy.mall.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by 李磊
 * on 2017/4/30.
 */
public enum ResultEnum {
    SUCCESS("000", "成功"),

    ERROR("100", "失败"),
    LOGIN_ERROR("110", "登录失败"),
    VERIFICATION_CODE_ERROR("111", "验证码错误"),
    REGISTER_ERROR("120", "注册失败");

    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private static final Map<String, ResultEnum> map = Maps.newHashMap();

    static {
        for (ResultEnum resultEnum : values()) {
            map.put(resultEnum.getCode(), resultEnum);
        }
    }

    public String code() {
        return code;
    }

    public static ResultEnum codeOf(String code) {
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
