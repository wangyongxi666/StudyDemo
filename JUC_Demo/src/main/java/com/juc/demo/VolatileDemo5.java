package com.juc.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName VolatileDemo5
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月09日 19:30
 * @Version 1.0.0
*/
public class VolatileDemo5 {

  public int num = 12;

  public static void main(String[] args) {

    VolatileDemo5 volatileDemo5 = new VolatileDemo5();

    volatileDemo5.test01();
    HashMap map = new HashMap();
    new ArrayList<>(10);

  }

  public void test01(){

    new Thread(()->{

      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      num--;
      System.out.println(Thread.currentThread().getName() + ":" + num);

    },"AA").start();


    new Thread(()->{
      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + ":" + num);

    },"BB").start();

  }

}
