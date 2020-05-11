package com.rabbitmq.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RaController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 20:46
 * @Version 1.0.0
*/
@RestController
public class RaController {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @RequestMapping(value = "/test",method = RequestMethod.GET)
  public String test(){

    rabbitTemplate.convertAndSend(RabbitmqConfig.QUEUE_EXCEPTION,"你好啊");

    return "成功";
  }

  @RequestMapping(value = "/exceptionTest",method = RequestMethod.GET)
  public String testException(){

    rabbitTemplate.convertAndSend(RabbitmqConfig.QUEUE_EXCEPTION,1);

    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    rabbitTemplate.convertAndSend(RabbitmqConfig.QUEUE_EXCEPTION,2);

    return "成功";
  }

  //test

  @RequestMapping(value = "testParam",method = RequestMethod.POST)
  public String testParam(@RequestParam String name,@RequestParam Integer age){
    return name + "," + age;
  }

  @RequestMapping(value = "testQuery",method = RequestMethod.GET)
  public String testQuery(String name,Integer age){
    return name + "," + age;
  }



}
