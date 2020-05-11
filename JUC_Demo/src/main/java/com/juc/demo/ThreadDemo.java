package com.juc.demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadDemo
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月05日 12:12
 * @Version 1.0.0
*/
public class ThreadDemo{

  public static void main(String[] args) throws Throwable {
    User user = new User();

//    FutureTask futureTask = new FutureTask(user);
//
//    Thread t1 = new Thread(futureTask,"线程一");
//    Thread t2 = new Thread(futureTask,"线程二");
//    t1.start();
//    t2.start();

//    String message = (String) futureTask.get();

//    System.out.println(message);

    //垃圾回收
    user = null;

    System.gc();

//    for(int i = 0; i<5000000; i++){
//      new User();
//    }


  }

}

class User implements Callable{

  private int num = 1000;


  /**
   * Computes a result, or throws an exception if unable to do so.
   *
   * @return computed result
   * @throws Exception if unable to compute a result
   */
  @Override
  public String call() throws Exception {
    for (; num > 0; num --){
      System.out.println(Thread.currentThread().getName()+"买了第"+num+"章票");
    }

    return "卖完了";
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("垃圾呗回收了");
  }
}

class Age extends Thread{

}
