package com.learn.controller;

import com.learn.api.R;
import com.learn.biz.AbstractLogin;
import com.learn.biz.Login;
import com.learn.controller.dto.AuthLoginDto;
import com.learn.exception.BizException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public R loginAuth(@RequestBody @Validated AuthLoginDto authLoginDto, BindingResult bindingResult){
        authLoginDto.validData(bindingResult);
        //登录逻辑?
        Login login= AbstractLogin.loginMap.get(authLoginDto.getLoginType());
        if(login==null){
            throw new BizException("暂不支持该种登录类型");
        }
        return login.doLogin(authLoginDto);
    }
}
