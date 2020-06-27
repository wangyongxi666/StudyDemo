package com.boot.security;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringSecurityBootApplicationTests {

  @Test
  void contextLoads() {

    String hashpw = BCrypt.hashpw("333", BCrypt.gensalt());
    String hashpw2 = BCrypt.hashpw("444", BCrypt.gensalt());
    System.out.println(hashpw);
    System.out.println(hashpw2);

  }

}
