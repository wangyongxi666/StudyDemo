package com.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @ClassName MyWebSocket
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月01日 21:28
 * @Version 1.0.0
*/
@ServerEndpoint("/websocket/{uid}")
public class MyWebSocket {

  @OnOpen
  public void onOpen(Session session,@PathParam("uid") String uid) throws IOException {
    System.out.println(uid + "连接上了" + session);

    //返回信息
    session.getBasicRemote().sendText("欢迎连接");
  }

  @OnClose
  public void onClose(Session session){
    System.out.println("关闭了" + session);
  }

  @OnMessage
  public void onMessage(String message, Session session) throws IOException {
    System.out.println("接收到消息：" + message);
    session.getBasicRemote().sendText("消息已收到.");
  }
  @OnError
  public void onError(Session session, Throwable error) {
    System.out.println("发生错误");
    error.printStackTrace();
  }

}
