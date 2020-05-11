package com.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName RabbitmqApplication
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 20:33
 * @Version 1.0.0
*/
@SpringBootApplication()
@ComponentScan(basePackages = {"com.rabbitmq"})
public class RabbitmqApplication {

  public static void main(String[] args) {
    SpringApplication.run(RabbitmqApplication.class,args);
  }

}
