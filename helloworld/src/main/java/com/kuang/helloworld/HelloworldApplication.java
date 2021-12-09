package com.kuang.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 本身就是Spring的一个组件
 */
@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) {
        //将HelloworldApplication启动
        SpringApplication.run(HelloworldApplication.class, args);
    }

}
