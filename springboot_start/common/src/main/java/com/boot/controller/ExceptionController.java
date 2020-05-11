package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ExceptionController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月05日 11:27
 * @Version 1.0.0
*/

@RestController
@RequestMapping("/exception")
public class ExceptionController {

  @RequestMapping("/test1")
  @ResponseBody
  public void ExceptionTest1(){

    try {
      System.out.println(1 / 0);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("try--catch 后面执行的语句");

  }
  @RequestMapping("/test2")
  @ResponseBody
  public void ExceptionTest2(){

    System.out.println(1 / 0);

    System.out.println("try--catch 后面执行的语句");

  }

}
