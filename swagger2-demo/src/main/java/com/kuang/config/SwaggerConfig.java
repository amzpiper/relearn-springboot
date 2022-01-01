package com.kuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(defaultApiInfo())
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
