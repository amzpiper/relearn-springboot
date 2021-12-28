package com.kuang.shirospringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guoyh
 * 第三步：ShiroFilterFactoryBean
 * 第二步：DefaultWebSecurityManager
 * 第一步：创建realm对象，需要自定义
 * 配置需要倒着配，先创建realm对象，再接管，再接到前端
 */
@Configuration
public class ShiroConfig {

    //创建realm对象，需要自定义
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }


}
