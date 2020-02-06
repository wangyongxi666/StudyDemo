package com.itheima.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年01月26日 19:05
 * @Version 1.0.0
*/
@RestController
@RequestMapping("/user")
public class UserController {

  @RequestMapping("/add")
  @PreAuthorize("hasAuthority('add')")
  public String add(){

    System.out.println("调用了add方法。。。。。。。。。。");
    return "success";
  }

  @RequestMapping("/delete")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public String delete(){

    System.out.println("调用了delete方法。。。。。。。。。。");
    return "success";
  }
}
