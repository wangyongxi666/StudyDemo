package com.study.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibDemo1
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月14日 20:34
 * @Version 1.0.0
*/
public class CglibDemo1 {

  public static void main(String[] args) {

    Car car = new Car();

    Car car2 = (Car) Enhancer.create(car.getClass(), new MethodInterceptor() {
      @Override
      public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("我买了一辆车");

        Object invoke = method.invoke(car, args);

        System.out.println("他是蓝绿色");

        return invoke;
      }
    });

    car2.show();

  }

}

class Car{
  public void show(){
    System.out.println("这是一个蓝色的车");
  }
}
