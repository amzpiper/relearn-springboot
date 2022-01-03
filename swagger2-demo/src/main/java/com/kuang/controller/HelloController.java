package com.kuang.controller;

import com.kuang.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoyh
 */
@RestController
public class HelloController {

    @ApiOperation("HelloController控制类-/hello接口注释")
    @GetMapping("/hello")
    public String hello(@ApiParam("用户id")String id) {
        return "hello";
    }

    @ApiOperation("HelloController控制类-/user接口注释")
    //只要我们在接口中返回实体类，就会被swagger扫描到
    @PostMapping("/user")
    public User user(User user) {
        return new User();
    }
}
