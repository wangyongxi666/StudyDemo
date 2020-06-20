package com.security.session.config;

import com.security.session.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @ClassName InterceptorConfig
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date 2020年06月19日 20:39
 * @Version 1.0.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

  @Autowired
  private LoginInterceptor loginInterceptor;

//  @Override
//  protected void addInterceptors(InterceptorRegistry registry) {
//    registry.addInterceptor(loginInterceptor)
//            //添加需要验证登录用户操作权限的请求
//            .addPathPatterns("/r/**")
//            //这里add为“/**”,下面的exclude才起作用，且不管controller层是否有匹配客户端请求，拦截器都起作用拦截
//            //.addPathPatterns("/hello")
//            //如果add为具体的匹配如“/hello”，下面的exclude不起作用,且controller层不匹配客户端请求时拦截器不起作用
//
//            //排除不需要验证登录用户操作权限的请求
////            .excludePathPatterns("/login")
////            .excludePathPatterns("/logout")
////            .excludePathPatterns("/static/login.html", "/login.html");
////            .excludePathPatterns("classpath:/static/login.html", "classpath:/login.html");
//            .excludePathPatterns("/*.html", "/static/*.html","/static/**","/static/login.html","/favicon.ico");
//    super.addInterceptors(registry);//最后将register往这里塞进去就可以了
//  }
//
//  @Override
//  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//    super.addResourceHandlers(registry);
//  }
//
//  //解决中文乱码问题
//  @Bean
//  public HttpMessageConverter<String> responseBodyConverter() {
//    StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//    return converter;
//  }
//
//  @Override
//  protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//    super.configureMessageConverters(converters);
//    converters.add(responseBodyConverter());
//  }


  @Override
  public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
            //添加需要验证登录用户操作权限的请求
            .addPathPatterns("/r/**")
            //这里add为“/**”,下面的exclude才起作用，且不管controller层是否有匹配客户端请求，拦截器都起作用拦截
            //.addPathPatterns("/hello")
            //如果add为具体的匹配如“/hello”，下面的exclude不起作用,且controller层不匹配客户端请求时拦截器不起作用

            //排除不需要验证登录用户操作权限的请求
//            .excludePathPatterns("/login")
//            .excludePathPatterns("/logout")
//            .excludePathPatterns("/static/login.html", "/login.html");
//            .excludePathPatterns("classpath:/static/login.html", "classpath:/login.html");
            .excludePathPatterns("/*.html", "/static/*.html","/static/**","/static/login.html","/favicon.ico");
  }

}
