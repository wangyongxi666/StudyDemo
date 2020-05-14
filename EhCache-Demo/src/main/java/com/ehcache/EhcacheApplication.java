package com.ehcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @ClassName EhcacheApplication
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月13日 13:19
 * @Version 1.0.0
*/
@SpringBootApplication(scanBasePackages={"com.ehcache.*"})
@MapperScan("com.ehcache.mapper")
@EnableCaching
public class EhcacheApplication {

  public static void main(String[] args) {

    SpringApplication.run(EhcacheApplication.class,args);

  }


}
