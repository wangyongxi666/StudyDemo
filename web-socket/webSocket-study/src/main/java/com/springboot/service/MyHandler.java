package com.springboot.service;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

/**
 * @ClassName MyHandler
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月02日 0:05
 * @Version 1.0.0
*/
public class MyHandler extends TextWebSocketHandler {

  /**
   * 建立连接时执行
  **/
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    Object uid = session.getAttributes().get("uid");
    session.sendMessage(new TextMessage("欢迎连接到ws服务:"+uid));
  }

  /**
   * 与客户端进行数据交换
  **/
  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message)
          throws IOException {
    System.out.println("获取到消息 >> " + message.getPayload());

    //向客户端发送消息
    session.sendMessage(new TextMessage("消息已收到"));

    //如果收到的消息是10 则向客户端发送10条消息
    if(message.getPayload().equals("10")){
      for (int i = 0; i < 10; i++) {
        session.sendMessage(new TextMessage("消息 -> " + i));
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 关闭方法
  **/
  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
          throws Exception {
    System.out.println("断开连接！");
  }

}
