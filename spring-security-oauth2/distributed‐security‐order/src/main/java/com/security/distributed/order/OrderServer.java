package com.security.distributed.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName OrderServer
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月27日 23:58
 * @Version 1.0.0
*/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServer {
  public static void main(String[] args) {
    SpringApplication.run(OrderServer.class, args);
  }
}
