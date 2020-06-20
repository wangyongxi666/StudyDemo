package com.vue.controller;

import com.vue.pojo.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName VueController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月25日 9:53
 * @Version 1.0.0
*/
@RestController
@CrossOrigin("*")
public class VueController {

  @GetMapping("/vue/get")
  public List getList(){
    List<User> list = new ArrayList<>();
    list.add(new User(1,"老铁"));
    list.add(new User(3,"老王"));
    list.add(new User(5,"老刘"));

    return list;
  }


}
