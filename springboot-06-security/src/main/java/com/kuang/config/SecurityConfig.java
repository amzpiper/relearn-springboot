package com.kuang.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author guoyh
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 授权功能开发
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //实例：首页所有人可以访问，但是功能页只有对应有权限的人才能访问
        http.authorizeRequests()
                //所有人可以访问/
                .antMatchers("/").permitAll()
                //vip1可以访问/level1
                .antMatchers("/level1/**").hasRole("vip1")
                //vip2可以访问/level2
                .antMatchers("/level2/**").hasRole("vip2")
                //vip3可以访问/level3
                .antMatchers("/level3/**").hasRole("vip3");

        //实例：开启登录功能，没有权限默认跳转登录页面,自动会进入/login
        http.formLogin();

        //实例：开启/logout注销功能，and then redirect to "/login?success".
        //清空cookie和session
        http.logout().deleteCookies("remove").invalidateHttpSession(true)
                //注销后回到首页
                .logoutSuccessUrl("/");
        //关闭防攻击
        http.csrf().disable();

        //记住我功能
        http.rememberMe();
    }

    /**
     * 认证功能开发
     * 可以使用内存或数据库jdbc
     * 无密码编码no PasswordEncoder报错
     * 在sprng-security5.0中增加了加密方式,必须加密
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 这些数据正常应该从数据库中读。
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("vip1", "vip2", "vip3");
    }
}
