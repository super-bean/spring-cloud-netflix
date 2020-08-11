package com.learn.biz;

import com.learn.controller.dto.AuthLoginDto;
import com.learn.controller.enums.LoginTypeEnum;
import com.learn.mapper.entitys.TbMember;
import org.springframework.stereotype.Service;


@Service
public class PhonePwdLoginProcessor extends AbstractLogin{
    @Override
    public int getLoginType() {
        return LoginTypeEnum.PHONE_PWD.getCode();
    }

    @Override
    public void validate(AuthLoginDto authLoginDto) {

    }

    @Override
    public TbMember doProcessor(AuthLoginDto authLoginDto) {
        return null;
    }
}
