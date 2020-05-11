package com.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitmqConfig
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 20:37
 * @Version 1.0.0
*/
@Configuration
public class RabbitmqConfig {

  public final static String QUEUE_EXCEPTION = "TEST_RABBITMQ_EXCEPTION";


  @Bean
  public Queue QUEUE_EXCEPTION(){
    return new Queue(QUEUE_EXCEPTION);
  }

  @Bean(name = "customContainerFactory")
  public SimpleRabbitListenerContainerFactory containerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConcurrentConsumers(10);
    factory.setMaxConcurrentConsumers(10);
    configurer.configure(factory, connectionFactory);
    return factory;
  }
}
