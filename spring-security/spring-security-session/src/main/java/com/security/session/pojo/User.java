package com.security.session.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

/**
 * @ClassName User
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月19日 20:18
 * @Version 1.0.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

  private String username;
  private String password;
  private Integer age;
  private Set<String> roles;
  private Set<String> pession;

  public final static String USER_KEY = "user_login_key";

}
