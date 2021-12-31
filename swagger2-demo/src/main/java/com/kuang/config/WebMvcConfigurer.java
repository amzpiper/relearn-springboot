package com.kuang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Spring MVC扩展配置
 * 如果配置了@EnableWebMvc，@EnableWebMvc导入的类继承了webmvcconfigurationsupport，
 * 自动配置的webmvcautoconfiguratoin就会失效
 * @author guoyh
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
     * addResourceLocations指的是文件放置的目录
     * addResoureHandler指的是对外暴露的访问路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/").addResourceLocations("classpath:/public/").addResourceLocations("classpath:/resource/");
        registry.addResourceHandler("/swagger-ui/**").addResourceLocations(new String[]{"classpath:/META-INF/resources/webjars/springfox-swagger-ui/"}).resourceChain(false);
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    /**
     * 重写addViewControllers,并不会覆盖WebMvcAutoConfiguration中的addViewControllers
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/swagger-ui/").setViewName("forward:" + "/swagger-ui/index.html");
    }
}
