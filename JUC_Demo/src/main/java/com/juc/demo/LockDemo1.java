package com.juc.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockDemo1
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date 2020年05月03日 23:54
 * @Version 1.0.0
 */
public class LockDemo1 {

  //定义操作者，1为打印5次，2为打印10次，3为打印15次
  private int number = 1;
  private Lock lock = new ReentrantLock();
  private Condition condition1 = lock.newCondition();
  private Condition condition2 = lock.newCondition();
  private Condition condition3 = lock.newCondition();


  public void print5() {

    lock.lock();

    try {
      //判断
      while (number != 1) {
        condition1.await();
      }
      System.out.println("打印了5次");
      number = 2;
      condition2.signalAll();

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }

  }

  public void print10() {

    lock.lock();

    try {
      //判断
      while (number != 2) {
        condition2.await();
      }

      System.out.println("打印了10次");
      number = 3;
      condition3.signalAll();

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {

      lock.unlock();

    }

  }

  public void print15() {

    lock.lock();

    try {
      //判断
      while (number != 3) {
        condition3.await();
      }


      System.out.println("打印了15次");
      System.out.println("-----------------------");
      number = 1;
      condition1.signalAll();

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {

      lock.unlock();

    }

  }

  public static void main(String[] args) {

    LockDemo1 sharePrint = new LockDemo1();

    new Thread(() -> {
      for (int i = 1; i <= 5; i++) {
        sharePrint.print5();
      }
    }, "AA").start();


    new Thread(() -> {
      for (int i = 1; i <= 5; i++) {
        sharePrint.print10();
      }
    }, "BB").start();


    new Thread(() -> {
      for (int i = 1; i <= 5; i++) {
        sharePrint.print15();
      }
    }, "CC").start();

//      new Thread(() -> {
//
//        sharePrint.print5();
//
//      }, "AA").start();
//
//
//      new Thread(() -> {
//
//        sharePrint.print10();
//
//      }, "BB").start();
//
//      new Thread(() -> {
//
//        sharePrint.print15();
//
//      }, "CC").start();


  }
}
