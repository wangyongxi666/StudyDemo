package com.itheima.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.itheima.security.User;

/**
 * @ClassName SpringSecurityUserService
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年01月26日 13:31
 * @Version 1.0.0
*/
public class SpringSecurityUserService implements UserDetailsService{

  //模拟数据库中的用户数据
  public static Map<String,User> map = new HashMap<>();

  static {
    User user1 = new User();
    user1.setUsername("admin");
    user1.setPassword("admin");

    User user2 = new User();
    user2.setUsername("xiaoming");
    user2.setPassword("1234");

    map.put(user1.getUsername(),user1);
    map.put(user2.getUsername(),user2);
  }

  @Override
  public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {

    //根据username查询 对象数据
    User user = map.get(username);
    //判断是否能查询出数据
    if(user == null){
      return null;
    }else{
      //封装参数
      List list = new ArrayList();
      list.add(new SimpleGrantedAuthority("permission_A"));//赋予权限
      list.add(new SimpleGrantedAuthority("permission_B"));
      list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));//赋予角色
      //把数据返回给框架 框架自动处理
      org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(username,"{noop}"+user.getPassword(),list);
      return securityUser;
    }
  }

}
