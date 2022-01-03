package com.kuang.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 郭宇航
 * @date 2022/1/3
 * @apiNote
 */
@Service
public class ScheduledService {

    /**
     * 在特点时间执行方法
     * 秒 分钟 小时 日 月 星期
     * 1   *   *  *  *  ?
     */
    @Scheduled(cron = "0/2 * * * * ? ")
    public void hello() {
        System.out.println("执行了,"+new Date().toString());
    }
}
