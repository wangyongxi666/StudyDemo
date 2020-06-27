package com.boot.security.config;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @ClassName WebSecurityConfig
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月23日 22:59
 * @Version 1.0.0
*/
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  //模拟用户
//  @Bean
//  public UserDetailsService getuserDetailsService(){
//    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//    manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
//    manager.createUser(User.withUsername("lisi").password("345").authorities("p2").build());
//    return manager;
//  }

  //密码编码器
  @Bean
  public PasswordEncoder passwordEncoder(){
//    return NoOpPasswordEncoder.getInstance();
    return new BCryptPasswordEncoder();
  }

  //安全拦截器
  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    super.configure(http);
    http.
            csrf().disable()
            //如果有需要 则生成session
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .authorizeRequests()
//            .antMatchers("/r/r1").hasAnyAuthority("p1")
//            .antMatchers("/r/r2").hasAnyAuthority("p2")
            //所有/r/**请求必须认证通过
            .antMatchers("/r/**").authenticated()
            //其他都可以访问
            .anyRequest().permitAll()
            .and()
            //允许表单登陆
            .formLogin()
            //登陆页面
            .loginPage("/static/login.html")
            //登陆地址url
            .loginProcessingUrl("/login")
            //自定义登陆成功的页面地址
            .defaultSuccessUrl("/login-success")
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login-view");
  }
}
