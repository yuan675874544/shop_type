package com.fh.api.type.shop_type;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.fh.api.type.shop_type.dao")
@SpringBootApplication
public class ShopTypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopTypeApplication.class, args);
    }

}
