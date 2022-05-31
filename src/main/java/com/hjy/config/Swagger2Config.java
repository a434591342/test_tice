package com.hjy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 * User: Haojunyu
 * Date: 2021/3/28
 * Time: 21:31
 * Description: swagger2配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hjy.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //============================================================================================
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("西邮体测系统接口文档")
                .description("西邮体测系统接口文档")
                .contact(new Contact("hjy","http:localhost:8081/doc.html","43459142@qq.com"))
                .version("1.0")
                .build();
    }
}