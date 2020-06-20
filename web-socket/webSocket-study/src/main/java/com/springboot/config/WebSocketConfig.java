package com.springboot.config;

import com.springboot.interceptor.MyHandshakeInterceptor;
import com.springboot.service.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

//  @Autowired
//  private MyHandler myHandler;

  @Autowired
  private MyHandshakeInterceptor myHandshakeInterceptor;

  /**
   * 注册路径 与接受域
  **/
  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    //设置路径与跨域请求
    registry.addHandler(myHandler(), "/ws")
            .setAllowedOrigins("*")
            .addInterceptors(myHandshakeInterceptor) //设置拦截器
    ;
  }

  @Bean
  public WebSocketHandler myHandler() {
    return new MyHandler();
  }
}
