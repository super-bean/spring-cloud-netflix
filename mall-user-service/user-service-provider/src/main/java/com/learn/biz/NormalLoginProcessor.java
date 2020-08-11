package com.learn.biz;

import com.learn.controller.dto.AuthLoginDto;
import com.learn.controller.enums.LoginTypeEnum;
import com.learn.exception.BizException;
import com.learn.exception.ValidException;
import com.learn.mapper.entitys.TbMember;
import com.learn.mapper.entitys.TbMemberExample;
import com.learn.mapper.persistence.TbMemberMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.List;

@Service
public class NormalLoginProcessor extends AbstractLogin{

    @Autowired
    TbMemberMapper tbMemberMapper;

    @Override
    public int getLoginType() {
        return LoginTypeEnum.NORMAL.getCode();
    }

    @Override
    public void validate(AuthLoginDto authLoginDto) {
        if(StringUtils.isBlank(authLoginDto.getUsername())||StringUtils.isBlank(authLoginDto.getPassword())){
            throw new ValidException("帐号或者密码不能为空");
        }
    }

    @Override
    public TbMember doProcessor(AuthLoginDto authLoginDto) {
        System.out.println("begin NormalLoginProcessor.doProcessor:"+authLoginDto);
        TbMemberExample tbMemberExample=new TbMemberExample();
        tbMemberExample.createCriteria().andStateEqualTo(1).andUsernameEqualTo(authLoginDto.getUsername());
        List<TbMember> members=tbMemberMapper.selectByExample(tbMemberExample);
        if(members==null||members.size()==0){
            throw new BizException("用户名或者密码错误");
        }
        if(!DigestUtils.md5DigestAsHex(authLoginDto.getPassword().getBytes()).equals(members.get(0).getPassword())){
            throw new BizException("用户名或者密码错误");
        }
        return members.get(0);
    }
}
