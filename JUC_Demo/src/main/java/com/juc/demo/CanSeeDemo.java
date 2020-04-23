package com.juc.demo;

import sun.awt.DefaultMouseInfoPeer;

import javax.swing.text.StyledEditorKit;

/**
 * @ClassName CanSeeDemo
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月17日 11:03
 * @Version 1.0.0
*/
public class CanSeeDemo {

  public static void main(String[] args) throws Exception{

    Demo demo = new Demo();

    Thread thread = new Thread(demo);

    thread.start();

    Thread.sleep(1000);

    demo.flag = false;
  }

  static class Demo implements Runnable{

    public static boolean flag = true;

    @Override
    public void run() {

      System.out.println("线程开始");

      //创建死循环
      while (flag){

        //解决方法 加上锁synchronized
//        线程解锁前（退出同步代码块时）：必须把自己工作内存中共享变量的最新值刷新到主内存中
//        线程加锁时（进入同步代码块时）：将清空本地内存中共享变量的值，从而使用共
//        享变量时需要从主内存中重新读取最新的值（加锁与解锁是同一把锁）

//        synchronized (this) {
//
//        }

      }

      System.out.println("线程结束");
    }
  }

}
