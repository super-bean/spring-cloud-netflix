package com.learn.biz;

import com.learn.api.R;
import com.learn.controller.dto.AuthLoginDto;
import com.learn.exception.BizException;

public interface Login {

    R doLogin(AuthLoginDto authLoginDto) throws BizException;
}
