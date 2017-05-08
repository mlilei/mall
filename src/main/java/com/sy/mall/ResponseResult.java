package com.sy.mall;

import com.sy.mall.common.enums.ResultEnum;

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

    public ResponseResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public ResponseResult(ResultEnum resultEnum, String message) {
        this.code = resultEnum.getCode();
        this.message = message;
    }

    public static ResponseResult createSuccessResult() {
        return createSuccessResult(null);
    }

    public static <T> ResponseResult createSuccessResult(T data) {
        ResponseResult responseResult = new ResponseResult(ResultEnum.SUCCESS);
        responseResult.setData(data);
        return responseResult;
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
