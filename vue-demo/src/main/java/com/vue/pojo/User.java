package com.vue.pojo;
/**
 * @ClassName User
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月25日 9:55
 * @Version 1.0.0
*/
public class User {

  private int id;

  private String name;

  public User() {
  }

  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
