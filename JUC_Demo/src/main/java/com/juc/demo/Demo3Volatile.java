package com.juc.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo3Volatile {

  //1. 线程1读取count的值为5
//2. 线程2读取count的值为5
//3. 线程2加1操作
//4. 线程2最新count的值为6
//5. 线程2写入值到主内存的最新值为6
//这个时候，线程1的count为5，线程2的count为6
//如果切换到线程1执行，那么线程1得到的结果是6，写入到主内存的值还是6
//现在的情况是对count进行了两次加1操作，但是主内存实际上只是加1一次

  public static void main(String[] args) throws InterruptedException {
    VolatileDemo demo = new VolatileDemo();

    for (int i = 0; i < 5; i++) {
      Thread t = new Thread(demo);
      t.start();
    }

    Thread.sleep(1000);
    System.out.println(demo.count);
  }

  static class VolatileDemo implements Runnable {
//    public volatile int count;

    public volatile AtomicInteger count = new AtomicInteger(0);

    public void run() {
      addCount();
    }

    public void addCount() {
      for (int i = 0; i < 10000; i++) {
//        count++;
        count.incrementAndGet();
      }
    }
  }
}