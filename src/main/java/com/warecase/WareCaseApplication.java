package com.warecase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.warecase.mapper")
public class WareCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WareCaseApplication.class, args);
    }

}
