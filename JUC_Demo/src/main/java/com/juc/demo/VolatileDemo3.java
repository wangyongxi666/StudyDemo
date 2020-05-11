package com.juc.demo;
/**
 * @ClassName VolatileDemo3
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 22:00
 * @Version 1.0.0
*/
public class VolatileDemo3 {

  public static void main(String[] args) throws Exception{
    Data2 data = new Data2();

    for(int i = 0; i < 10000; i++){

      new Thread(() -> {

        data.addNum();

      }, String.valueOf(i)).start();

    }

    if(Thread.activeCount() > 2){
      Thread.sleep(10);
    }


    System.out.println("main : " + data.num);



  }



}


class Data2{

  public volatile int num = 0;


  public synchronized void addNum(){

    this.num ++;

  }

}