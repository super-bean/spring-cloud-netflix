package com.learn.clients;

import com.learn.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
public interface IUserAuthFeignClient {

    @GetMapping(value = "/token",consumes = MediaType.APPLICATION_JSON_VALUE)
    R<String> validToken(@RequestParam("token") String token);
}
