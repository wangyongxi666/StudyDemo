package com.pojo;

import lombok.*;

/**
 * @ClassName User
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月26日 21:59
 * @Version 1.0.0
*/
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

  private String name;
  private int age;
  private int sale;

}
