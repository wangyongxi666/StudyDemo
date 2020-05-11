package com.rabbitmq;

import com.rabbitmq.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName RabbitMqTest
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 20:34
 * @Version 1.0.0
*/
public class RabbitMqTest {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Test
  public void test01(){

  }


}
