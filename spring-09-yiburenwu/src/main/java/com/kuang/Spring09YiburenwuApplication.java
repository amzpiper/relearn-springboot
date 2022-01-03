package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

//开启异步处理
@EnableAsync
@SpringBootApplication
public class Spring09YiburenwuApplication {
    public static void main(String[] args) {
        SpringApplication.run(Spring09YiburenwuApplication.class, args);
    }
}
