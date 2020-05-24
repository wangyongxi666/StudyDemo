package com.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JdkProxyDemo1
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月14日 18:53
 * @Version 1.0.0
*/
public class JdkProxyDemo1 {

  public static void main(String[] args) {
    Person man = new SpuerMan();

    ProxyPerson proxyPerson = new ProxyPerson(man);
    Person person = (Person) proxyPerson.proxyMethod();
    String eat = person.eat();
    System.out.println(eat);
  }

}

//代理类
class ProxyPerson{

  public Object object;

  public ProxyPerson(Object object){
    this.object = object;
  }

  public Object proxyMethod(){
    Object proxy = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
      @Override
      public Object invoke(Object obj, Method method, Object[] args) throws Throwable {

        System.out.println("超人吃饭也要洗手");
        //如果需要获取方法的返回值，需要把返回对象返回，否则，则会报错
        Object invoke = method.invoke(object, args);
        System.out.println("超人吃饱了");
        return invoke;
      }
    });

    return proxy;
  }

}

//接口
interface Person{
  public String eat();
}

//实现类
class SpuerMan implements Person{
  @Override
  public String eat() {
    System.out.println("超人要吃很多东西的");

    return "吃饱了";
  }
}
