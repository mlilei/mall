package com.sy.mall;

/**
 * Created by 李磊
 * on 2017/4/30.
 */
public class MallException extends RuntimeException {

    public static final MallException SUCCESS = new MallException("200", "成功");

    /**
     * 前缀为：3，参数类错误
     */
    public static final MallException PARAMS_INVALID = new MallException("300", "请求参数错误");
    public static final MallException VERIFICATION_CODE_ERROR = new MallException("301", "验证码错误");

    /**
     * 前缀为：4，业务异常
     */
    public static final MallException USERNAME_EXISTS = new MallException("400", "用户名已存在");
    public static final MallException LOGIN_ERROR = new MallException("401", "登录失败");

    /**
     * 前缀为：5，第三方异常
     */

    /**
     * 前缀为：9，系统异常
     */
    public static final MallException ERROR = new MallException("999", "系统异常");


    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MallException() {
    }

    public MallException(String message) {
        super(message);
        this.message = message;
    }

    public MallException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
