package com.kuang.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 郭宇航
 * @date 2022/1/3
 * @apiNote
 */
@Service
public class AsyncSerive {

    // 告诉spring这是一个异步方法
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理");
    }
}
