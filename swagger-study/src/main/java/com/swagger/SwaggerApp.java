package com.swagger;
/**
 * @ClassName SwaggerApp
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月15日 9:26
 * @Version 1.0.0
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerApp
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月15日 9:17
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableSwagger2
public class SwaggerApp {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApp.class);
    }
}
