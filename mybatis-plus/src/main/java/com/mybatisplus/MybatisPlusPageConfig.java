package com.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisPlusPageConfig
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月21日 17:52
 * @Version 1.0.0
*/
@Configuration
@MapperScan("com.mybatisplus.mapper")
public class MybatisPlusPageConfig {

//    @Bean
//    public PaginationInterceptor getPaginationInterceptor(){
//        return new PaginationInterceptor();
//    }
}
