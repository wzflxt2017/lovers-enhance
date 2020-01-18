package com.lovers.common;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.lovers.common.mapper")
@EnableDubbo
@SpringBootApplication
@EnableCaching
public class LoversServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoversServiceApplication.class, args);
    }

}
