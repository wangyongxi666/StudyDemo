package com.act;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * @ClassName ActApplication
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月30日 11:25
 * @Version 1.0.0
*/
@SpringBootApplication
public class ActApplication {

  public static void main(String[] args) {
    SpringApplication.run(ActApplication.class,args);
  }

  // 通过fastjson替换默认的jackson转化json数据
  // 在过滤器中过滤了identityLinks属性
  @Bean
  public HttpMessageConverters fastJsonHttpMessageConverters() {
//    FastJsonHttpMessageConverter fjc = new FastJsonHttpMessageConverter();
//    FastJsonConfig config = new FastJsonConfig();
//    config.setSerializerFeatures(SerializerFeature.PrettyFormat);
//    SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
//    filter.getExcludes().add("identityLinks");
//    config.setSerializeFilters(filter);
//    fjc.setFastJsonConfig(config);
//    HttpMessageConverter<?> converter = fjc;
//    return new HttpMessageConverters(converter);
    return null;
  }
}
