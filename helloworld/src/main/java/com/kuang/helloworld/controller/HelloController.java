package com.kuang.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郭宇航
 * @date 2021/10/11
 * @apiNote
 */
@RestController
public class HelloController {

    //接口：http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello() {
        // 调用业务
        return "Hello,World";
    }

}
