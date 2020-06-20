package com.security.session.service.impl;

import com.security.session.pojo.Authentication;
import com.security.session.pojo.User;
import com.security.session.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName UserServiceImpl
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月20日 1:22
 * @Version 1.0.0
*/
@Service
public class UserServiceImpl implements UserService {

  @Override
  public User localUserLogin(Authentication authentication){

    if(authentication == null || StringUtils.isEmpty(authentication.getUsername()) || StringUtils.isEmpty(authentication.getPassword()) ){
      throw new RuntimeException("账号或密码为空");
    }

    //获取数据（真实项目中从数据库中查询数据）
    Map<String, User> userMap = getUserMap();

    User user = userMap.get(authentication.getUsername());
    if(user == null){
      throw new RuntimeException("查询不到该账户");
    }

    if (!user.getPassword().equals(authentication.getPassword())) {
      throw new RuntimeException("账号或密码不正确");
    }

    return user;
  }

  //模拟数据库中查出的数据
  public Map<String,User> getUserMap(){
    Map<String,User> userMap = new HashMap<>();

    Set<String> rolesR1 = new HashSet<String>();
    rolesR1.add("r1");
    Set<String> rolesR2 = new HashSet<String>();
    rolesR2.add("r2");
    userMap.put("zhangsan",new User("zhangsan","111",16,rolesR1,null));
    userMap.put("lisi",new User("lisi","222",18,rolesR2,null));
    return userMap;
  }

}
