package com.sy.mall;

/**
 * Created by 李磊
 * on 2017/4/30.
 */
public class MallException extends RuntimeException {
    public MallException() {
    }

    public MallException(String message) {
        super(message);
    }

    public MallException(String message, Throwable cause) {
        super(message, cause);
    }

    public MallException(Throwable cause) {
        super(cause);
    }
}
