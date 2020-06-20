package com.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RestProController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月14日 11:41
 * @Version 1.0.0
*/
@RestController
public class RestProController {

  @GetMapping(value = "/service")
  public String service(){
    System.out.println("service 被访问");
    return "service 被调用了";
  }

}
