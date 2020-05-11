package com.juc.demo;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.beans.binding.When;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolDemo
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月07日 11:45
 * @Version 1.0.0
*/
public class ThreadPoolDemo {

  public static void main(String[] args) {

    // new Thread

//    ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
//
//    long start = System.currentTimeMillis();
//
//    for (int i = 1; i <= 10000; i++){
////      new Thread(() -> {
//
//        threadPoolDemo.test01();
//
////      },String.valueOf(i)).start();
//    }
//
////    while (Thread.activeCount() > 2){
////
////    }
//
//    long end = System.currentTimeMillis();
//
//    System.out.println(end - start);


    //ThreadPoolExecutor

    ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

    ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
            15,
            100,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    long start = System.currentTimeMillis();

    for (int i = 1; i <= 10000; i++){

      executor.execute(() -> {
        threadPoolDemo.test01();
      });
    }

    executor.shutdown();

    long end = System.currentTimeMillis();

    System.out.println(end - start);

  }

  public void test01(){

    String num = Thread.currentThread().getName();

    System.out.println("我是第" +num+ "个被调用");

  }



}
