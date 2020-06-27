package com.boot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月23日 22:56
 * @Version 1.0.0
*/
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/").setViewName("redirect:/login-view");
//    registry.addViewController("/login-view").setViewName("login");
    registry.addViewController("/").setViewName("login");
  }

//  @Override
//  public void addInterceptors(InterceptorRegistry registry) {
//    registry .excludePathPatterns("/*.html", "/static/*.html","/static/**","/static/login.html","/favicon.ico");
//  }


  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
  }
}
