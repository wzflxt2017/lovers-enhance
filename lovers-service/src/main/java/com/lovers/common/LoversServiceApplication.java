package com.lovers.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lovers.common.mapper")
@SpringBootApplication
public class LoversServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoversServiceApplication.class, args);
    }

}
