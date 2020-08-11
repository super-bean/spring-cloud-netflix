package com.learn.feign;

import com.learn.api.R;
import com.learn.clients.IUserAuthFeignClient;
import com.learn.exception.ValidException;
import com.learn.utils.JwtGeneratorUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthFeignClient implements IUserAuthFeignClient {

    @Override
    public R<String> validToken(String token) {
        if(StringUtils.isBlank(token)){
            throw new ValidException("token为空");
        }
        try {
            Claims claims = JwtGeneratorUtil.parseToken(token);
            return new R.Builder().setData(claims.get("uid").toString()).buildOk();
        }catch (ExpiredJwtException e){
            return new R.Builder().buildCustomize("token已过期");
        }catch (SignatureException e){
            return new R.Builder().buildCustomize("签名校验失败");
        }
    }
}
