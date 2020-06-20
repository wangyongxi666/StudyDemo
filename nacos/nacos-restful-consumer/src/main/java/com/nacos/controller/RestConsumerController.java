package com.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestConsumerController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date 2020年06月14日 12:07
 * @Version 1.0.0
 */
@RestController
public class RestConsumerController {

  @Value("${provider.address}")
  private String providerAddress;

  @GetMapping(value = "/service")
  public String service() {
    RestTemplate restTemplate = new RestTemplate(); //调用服务
    String providerResult = restTemplate.getForObject("http://" + providerAddress + "/service", String.class);
    return "consumer invoke | " + providerResult;
  }
}
