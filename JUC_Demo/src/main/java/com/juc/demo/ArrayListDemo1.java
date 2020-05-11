package com.juc.demo;

import java.util.List;
import java.util.ArrayList;

/**
 * @ClassName ArrayListDemo1
 * @Description ArrayList  并发不安全
 * @Author YongXi.Wang
 * @Date  2020年05月02日 20:31
 * @Version 1.0.0
*/
public class ArrayListDemo1 {

  public static void main(String[] args) {

    List list = new ArrayList();

    for(int i = 0; i < 50; i++){
      new Thread(() -> {

        list.add(123);
        System.out.println(list);

      },String.valueOf(i)).start();
    }
  }

}
