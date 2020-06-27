package com.boot.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月19日 20:23
 * @Version 1.0.0
*/
@Controller
public class LoginController {

//  @Autowired
//  private UserService userService;

//  @PostMapping("/login")
//  public String login(Authentication authentication, HttpSession session){
//    User user = userService.localUserLogin(authentication);
//    if(user == null){
//      return "登陆失败";
//    }
//    session.setAttribute(User.USER_KEY,user);
//    return "登陆成功";
//  }

  @GetMapping("/logout")
  public String logout(HttpSession session){
    session.invalidate();
    return "退出成功";
  }

//  @GetMapping("/r/r1")
//  public String r1(HttpSession session){
//    String fullname = null;
//
//    Object attribute = session.getAttribute(User.USER_KEY);
//
//    if(attribute == null){
//      fullname = "匿名";
//    }else{
//      User user = (User) attribute;
//      fullname = user.getUsername();
//    }
//
//    return fullname + "访问了r1";
//  }

  @GetMapping("login-success")
  @ResponseBody
  public String login_success(){
      return "恭喜您，登陆成功";
  }

  @GetMapping("/r/r1")
  @ResponseBody
  @PreAuthorize("hasAuthority('p1')")
  public String r1(HttpSession session){
      return getUsername() +  ":我是r1方法，要有p1角色的人才能访问到我";
  }

  @GetMapping("/r/r2")
  @ResponseBody
//  @PreAuthorize(value="isAuthenticated()")
  public String r2(){
//    return getUsername() +  ":我是r2方法，要有p2角色的人才能访问到我";
    return getUsername() +  ":我是r2方法，认证通过之后就能访问我";
  }

  @GetMapping("/r/r3")
  @ResponseBody
  @PreAuthorize("isAnonymous()")
  public String r3(){
    return getUsername() +  ":我是r3方法，我希望我能被匿名访问";
  }

  @RequestMapping("/login-view")
  public String logon(){
    return "login";
  }

  //获取用户名
  private String getUsername(){
    String username = null;
    //当前认证通过的用户身份
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if(principal == null){
      username = "匿名";
    }else{
      if(principal instanceof UserDetails){
        UserDetails user = (UserDetails) principal;
        username = user.getUsername();
      }else {
        username = principal.toString();
      }
    }

    return username;
  }

}
