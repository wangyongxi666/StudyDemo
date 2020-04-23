package com.juc.demo;
/**
 * @ClassName VolatileDemo
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月17日 11:03
 * @Version 1.0.0
 */
public class VolatileDemo {

  public static void main(String[] args) throws Exception{

    Demo demo = new Demo();

    Thread thread = new Thread(demo);

    thread.start();

    Thread.sleep(1000);

    demo.flag = false;
    System.out.println("修改后" + demo.flag);
  }

  static class Demo implements Runnable{

    //解决方法
    public volatile boolean flag = true;

    @Override
    public void run() {

      System.out.println("线程开始");

      //创建死循环
      System.out.println("线程中" + flag);
      while (flag){
      }

      System.out.println("线程结束");
    }
  }
}
