package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class GoodsServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsServiceProviderApplication.class, args);
    }

}
