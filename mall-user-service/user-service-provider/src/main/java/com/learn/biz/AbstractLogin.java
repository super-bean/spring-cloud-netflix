package com.learn.biz;

import com.learn.api.R;
import com.learn.controller.dto.AuthLoginDto;
import com.learn.exception.BizException;
import com.learn.mapper.entitys.TbMember;
import com.learn.utils.JwtGeneratorUtil;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public abstract class AbstractLogin implements Login{

    public static ConcurrentHashMap<Integer,AbstractLogin> loginMap=new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        loginMap.put(getLoginType(),this);
    }

    @Override
    public R doLogin(AuthLoginDto authLoginDto) throws BizException {
        validate(authLoginDto); //第一步完成验证
        TbMember member=doProcessor(authLoginDto);
        Map<String,Object> payLoad=new HashMap<>();
        payLoad.put("uid",member.getId());
        payLoad.put("exp", DateTime.now().plusHours(1).toDate().getTime()/1000);
        String token= JwtGeneratorUtil.generatorToken(payLoad);
        return new R.Builder().setData(token).buildOk();
    }

    /**
     * 在子类中去声明自己的登录类型
     * @return
     */
    public abstract int getLoginType();

    /**
     * 通过子类去完成验证
     * @param authLoginDto
     */
    public abstract void validate(AuthLoginDto authLoginDto);

    /**
     * 登录校验
     * @param authLoginDto
     */
    public abstract TbMember doProcessor(AuthLoginDto authLoginDto);

}
