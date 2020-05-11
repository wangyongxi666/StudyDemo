package com.juc.demo;

/**
 * @ClassName VolatileDemo2
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date 2020年05月01日 21:59
 * @Version 1.0.0
 */
public class VolatileDemo2 {

  public static void main(String[] args) {
    Data data = new Data();

    new Thread(() -> {

      System.out.println(Thread.currentThread().getName() + "我进来了");

      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      data.changeNum();

    }, "线程A").start();

    new Thread(() -> {

      System.out.println(Thread.currentThread().getName() + "我进来了");
      while (data.num != 10) {
        System.out.println("我拿到的值是 ：" + data.num);
      }

      System.out.println("我终于拿到了 : " + data.num);

    }, "线程B").start();

  }
}



class Data {

  public volatile int num = 0;


  public void changeNum() {

    this.num = 10;

  }

}