package com.boot.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @ClassName MyUserDetailService
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月25日 21:42
 * @Version 1.0.0
*/
public interface MyUserDetailService extends UserDetailsService {

  @Override
  UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
