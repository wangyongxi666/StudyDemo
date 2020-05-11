package com.juc.demo;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @ClassName MyThreadPoolExecutor
 * @Description 手写线程池
 * @Author YongXi.Wang
 * @Date  2020年05月04日 11:25
 * @Version 1.0.0
*/
public class MyThreadPoolExecutor {

  public static void main(String[] args) {

    ExecutorService executor = new ThreadPoolExecutor(2,
            5,
            1L,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    try {

      for(int i=1; i<=10; i++){
        executor.execute(() -> {
          System.out.println("窗口 " + Thread.currentThread().getName() + " 正在服务");
        });
      }


    }catch (Exception e){
      e.printStackTrace();
    }

  }

}
