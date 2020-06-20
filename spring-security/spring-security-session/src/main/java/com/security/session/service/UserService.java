package com.security.session.service;

import com.security.session.pojo.Authentication;
import com.security.session.pojo.User;

/**
 * @ClassName UserService
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月20日 1:22
 * @Version 1.0.0
*/
public interface UserService {
  User localUserLogin(Authentication authentication);
}
