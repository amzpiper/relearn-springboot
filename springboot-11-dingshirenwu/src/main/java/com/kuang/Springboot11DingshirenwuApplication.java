package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// 开启定时任务
@EnableScheduling
@SpringBootApplication
public class Springboot11DingshirenwuApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot11DingshirenwuApplication.class, args);
    }

}
