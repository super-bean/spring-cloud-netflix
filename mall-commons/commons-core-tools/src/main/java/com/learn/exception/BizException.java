package com.learn.exception;

public class BizException extends BaseException{

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
        this.msg=message;
    }

    public BizException(String code, String msg) {
        super();
        this.msg=msg;
        this.code=code;
    }
}
