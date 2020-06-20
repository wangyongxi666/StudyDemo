package com.security.session.controller;

import com.security.session.pojo.Authentication;
import com.security.session.pojo.User;
import com.security.session.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月19日 20:23
 * @Version 1.0.0
*/
@RestController
public class LoginController {

  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public String login(Authentication authentication, HttpSession session){
    User user = userService.localUserLogin(authentication);
    if(user == null){
      return "登陆失败";
    }
    session.setAttribute(User.USER_KEY,user);
    return "登陆成功";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session){
    session.invalidate();
    return "退出成功";
  }

  @GetMapping("/r/r1")
  public String r1(HttpSession session){
    String fullname = null;

    Object attribute = session.getAttribute(User.USER_KEY);

    if(attribute == null){
      fullname = "匿名";
    }else{
      User user = (User) attribute;
      fullname = user.getUsername();
    }

    return fullname + "访问了r1";
  }

  @GetMapping("/r/r2")
  public String r2(){
    return "我是r2方法，要有r2角色的人才能访问到我";
  }



}
