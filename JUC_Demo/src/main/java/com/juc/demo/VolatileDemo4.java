package com.juc.demo;

/**
 * @ClassName VolatileDemo3
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date 2020年05月01日 22:00
 * @Version 1.0.0
 */
public class VolatileDemo4 {

  public static void main(String[] args) throws Exception {
    Data3 data = new Data3();

    for (int i = 0; i < 1000; i++) {

      new Thread(() -> {

        System.out.println(Thread.currentThread().getName());
        data.change();

      }, "线程" + i).start();
    }

  }


}


class Data3 {

  public int num = 0;

  public boolean flag = false;

  public void change() {


    num = 1;

    int a = 10;

    int b = 6;

    int c = 124;

    int t = 12 + 12;

    System.out.println(num);

  }


}