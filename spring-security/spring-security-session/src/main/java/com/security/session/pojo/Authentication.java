package com.security.session.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @ClassName Authentication
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月19日 20:32
 * @Version 1.0.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Authentication {

  private String username;
  private String password;

}
