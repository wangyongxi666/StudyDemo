package com.boot.security.service.impl;

import com.boot.security.dao.UserDao;
import com.boot.security.model.User;
import com.boot.security.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MyUserDetailServiceImpl
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月25日 21:43
 * @Version 1.0.0
*/
@Service
public class MyUserDetailServiceImpl implements MyUserDetailService {

  @Autowired
  UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//    //模拟查询数据库
//    UserDetails authorities = User.withUsername("zhangsan").password("$2a$10$8p4BJJCeFHzzQE0YNBxqGebuHLeHGbafOjbNygFTWqKvdbVCw0ZFq").authorities("p1").build();

    //真正查询数据库
    User user = userDao.getUserByUsername(username);
    if(user == null){
      //如果查询不到用户 返回null，由provider来抛出异常
      return null;
    }

    List<String> list = userDao.findPermissionsByUserId(user.getId());

    UserDetails authorities =
            org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername()).password(user.getPassword()).authorities(list.toArray(new String[list.size()])).build();

    return authorities;
  }
}
