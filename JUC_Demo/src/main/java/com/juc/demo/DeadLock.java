package com.juc.demo;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DeadLock
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月04日 16:59
 * @Version 1.0.0
*/
public class DeadLock {

  public static void main(String[] args) {
    Object obj1 = new Object();
    Object obj2 = new Object();

    new Thread(() -> {

      synchronized (obj1){
        System.out.println("我是线程 " + Thread.currentThread().getName() + "我拿到了obj1");
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        synchronized (obj2){
          System.out.println("我是线程 " + Thread.currentThread().getName() + " 我拿到了obj2");
        }
      }

    },"AA").start();


    new Thread(() -> {

      synchronized (obj2){
        System.out.println("我是线程 " + Thread.currentThread().getName() + "我拿到了obj2");
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        synchronized (obj1){
          System.out.println("我是线程 " + Thread.currentThread().getName() + " 我拿到了obj1");
        }
      }

    },"BB").start();


  }


}
