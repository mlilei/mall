package com.sy.mall;

import java.io.Serializable;

/**
 * Created by 李磊
 * on 2017/4/30.
 */
public class ResponseResult<T> implements Serializable {
    private String code;
    private String message;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseResult createResult(String code, String message) {
        return new ResponseResult(code, message);
    }

    public static ResponseResult createResult(MallException e) {
        return new ResponseResult(e.getCode(), e.getMessage());
    }

    public static ResponseResult createSuccessResult() {
        return createResult(MallException.SUCCESS);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
