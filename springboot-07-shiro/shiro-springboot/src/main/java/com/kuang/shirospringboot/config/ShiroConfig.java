package com.kuang.shirospringboot.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
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

    /**
     * 第一步：创建realm对象，需要自定义创建realm对象，需要自定义
     * Bean的名字就是方法名
     */
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }

    /**
     * 第二步：DefaultWebSecurityManager
     * @Qualifier("userRealm")将UserRealm的bean绑定上参数中的userRealm
     */
    @Bean()
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 他是一个中间商，管理realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 第三步：ShiroFilterFactoryBean
     */
    @Bean()
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // 需要配置安全管理器和过滤器
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        return factoryBean;
    }

}
