package com.juc.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName BlockQueceDemo1
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月03日 19:34
 * @Version 1.0.0
*/
public class BlockQueceDemo1 {


  public static void main(String[] args) throws Exception{


    Share share = new Share();

    new Thread(() -> {

      for (int i = 0; i < 5; i ++){
        share.opt();
      }


    },"AA").start();

    new Thread(() -> {

      for (int i = 0; i < 5; i ++){
        share.give();
      }


    },"BB").start();

  }

}

class Share{

  //false 不能进行操作 true 能进行操作
  private boolean flag = false;

  //操作方法
  public synchronized void opt() {

    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    while (flag) {

      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("操作者进行操作了");
    flag = true;
    this.notify();

  }

  //提供方法
  public synchronized void give(){

    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    while (!flag){

      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("提供者进行了资源提供");
    flag = false;
    this.notify();

  }



}
