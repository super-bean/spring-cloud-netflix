package com.learn.exception;


import com.learn.api.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e, HttpServletRequest request){
        String msg="系统繁忙："+e.getMessage();
        if(e instanceof ValidException||e instanceof BizException){
            msg=e.getMessage();
        }
        return new R.Builder().buildCustomize(msg);
    }
}
