package com.kuang.controller;

import com.kuang.service.AsyncSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郭宇航
 * @date 2022/1/3
 * @apiNote
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncSerive asyncSerive;

    @GetMapping("/hello")
    public String hello() {
        // 停止3s，再处理，影响用户体验
        asyncSerive.hello();
        return "ok";
    }
}
