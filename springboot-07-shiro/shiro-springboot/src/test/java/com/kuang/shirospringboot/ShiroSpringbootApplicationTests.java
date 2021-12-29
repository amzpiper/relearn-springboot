package com.kuang.shirospringboot;

import com.kuang.shirospringboot.mapper.UserMapper;
import com.kuang.shirospringboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.queryUserByName("root");
        System.out.println(user.toString());
    }

}
