package com.learn.biz;


import com.learn.controller.dto.AuthLoginDto;
import com.learn.controller.enums.LoginTypeEnum;
import com.learn.mapper.entitys.TbMember;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class PhoneCodeLoginProcessor extends AbstractLogin{
    @Override
    public int getLoginType() {
        return LoginTypeEnum.PHONE_CODE.getCode();
    }
    @Override
    public void validate(AuthLoginDto authLoginDto) {
        if(StringUtils.isBlank(authLoginDto.getPhone())){
            //TODO
        }
    }

    @Override
    public TbMember doProcessor(AuthLoginDto authLoginDto) {
        return null;
    }
}
