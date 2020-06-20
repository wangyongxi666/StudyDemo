package com.security.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName com.security.session.StringSecuritySessionApplication
 * @Description session 方式进行权限校验
 * @Author YongXi.Wang
 * @Date  2020年06月19日 20:12
 * @Version 1.0.0
*/
@SpringBootApplication
public class StringSecuritySessionApplication {

  public static void main(String[] args) {
    SpringApplication.run(StringSecuritySessionApplication.class,args);
  }

}
