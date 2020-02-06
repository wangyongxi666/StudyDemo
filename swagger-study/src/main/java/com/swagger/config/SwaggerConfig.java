package com.swagger.config;

import com.swagger.model.Shop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @ClassName SwaggerConfig
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date 2019年10月15日 9:16
 * @Version 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
//    }

    @Bean
    public Docket docketUser() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("用户接口")
                .select()
                .paths(PathSelectors.ant("/swagger/**"))
                .build();
    }

    @Bean
    public Docket docketShop() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("商户接口")
                .select()
                .paths(PathSelectors.ant("/shop/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact con = new Contact("老王", "www.laowang.com", "103@qq.com");
        return new ApiInfo("Swagger学习文档",
                "这个是我自己做的", "v1.0",
                "http://localhost:8080/",
                con,
                "",
                "",
                new ArrayList<>()
                );
    }
}
