package com.boot.security.model;

import lombok.Data;

/**
 * @ClassName User
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月26日 16:20
 * @Version 1.0.0
*/
@Data
public class User {
  /**
   * 用户id
   */
  private String id;

  /**
   *
   */
  private String username;

  /**
   *
   */
  private String password;

  /**
   * 用户姓名
   */
  private String fullname;

  /**
   * 手机号
   */
  private String mobile;

}
