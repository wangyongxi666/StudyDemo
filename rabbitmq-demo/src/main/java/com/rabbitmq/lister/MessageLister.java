package com.rabbitmq.lister;

import com.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName MessageLister5
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 20:55
 * @Version 1.0.0
*/
//@Component
public class MessageLister {

  @RabbitListener(queues = RabbitmqConfig.QUEUE_EXCEPTION,containerFactory = "customContainerFactory")
  public void getMessage(String message){

//    System.out.println(1 / 0);
//    System.out.println("我拿到消息啦" + message);

    int i = Integer.parseInt(message);

    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if(i == 1){
      int j = i / 0;
      System.out.println("我准备报错了");

    }else if (i == 2){
      System.out.println("我处理完正常消息了");
    }

  }

}
