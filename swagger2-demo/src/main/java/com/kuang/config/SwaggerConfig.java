package com.kuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 3.0版本可以不加@EnableOpenApi注解
 * @author guoyh
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        // 实例：只希望在生产环境中使用,获取项目环境中的配置数值
        // 设置
        Profiles profiles = Profiles.of("dev");
        //Profiles profiles = Profiles.of("dev");
        // 通过environment.acceptsProfiles(profiles)，判断现在是否处在当前配置的环境当中。
        boolean flags = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(defaultApiInfo())
                // 是否启动swagger，如果是false，则不能在浏览器中访问,判断现在是否处在当前配置的环境当中。
                .enable(flags)
                .groupName("郭宇航")
                .select()
                // basePackage:基于包位置扫描
                // any:扫描全部
                // none:不扫描
                // withClassAnnotation:扫描类上的注解
                // withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.kuang.controller"))
                // path:过滤接口路径
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket docket2(Environment environment) {
        return new Docket(DocumentationType.OAS_30)
                .groupName("郭宇航2");
    }

    private ApiInfo defaultApiInfo() {
        return new ApiInfo(
                "名称",
                "描述",
                "1.0",
                "team的url",
                new Contact("作者名称", "作者名称url", "1131717341@qq.com"),
                "License 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
