package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;



@SpringBootApplication
public class UserServiceProviderApplication {

    public static void main(String[] args) {

        SpringApplication springApplication=new SpringApplication(UserServiceProviderApplication.class);
        Map<String,Object> map=new HashMap<>();
        map.put("key","value");
        springApplication.setDefaultProperties(map);
        springApplication.run(args);
    }

}
