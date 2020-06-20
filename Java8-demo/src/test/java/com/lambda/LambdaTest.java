package com.lambda;

import com.pojo.Eat;
import com.pojo.Opt;
import com.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.swing.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName LambdaTest
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月26日 21:45
 * @Version 1.0.0
*/
public class LambdaTest {

  /**
   * 函数式编程 (匿名内部类) (一参一行语句有返回)
  **/
  @Test
  public void test01(){
    Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
    TreeSet treeSet = new TreeSet(com);

    System.out.println(com.compare(2, 1));

  }
  public interface Converter<T1, T2> {
    void convert(int i);
  }

  /**
   *  按条件过滤集合
  **/
  @Test
  public void test02(){
    List<User> arrayList = new ArrayList();
    arrayList.add(new User("老张",18,1000));
    arrayList.add(new User("老王",26,10000));
    arrayList.add(new User("老伞",15,200));
    arrayList.add(new User("老恶",33,2400));
    arrayList.add(new User("老巴",40,8800));

    //工资大于2000的
    List<User> collect = arrayList.stream().filter(e -> e.getSale() >= 2000).collect(Collectors.toList());
    System.out.println(collect);

    List<String> collect1 = arrayList.stream().map(User::getName).limit(2).collect(Collectors.toList());
    System.out.println(collect1);

  }

  /**
   *  实现接口方法 (有参 无返回值)
   **/
  @Test
  public void test03(){
    Consumer con = x -> System.out.println(x);
    con.accept("123");
  }

  /**
   *  实现接口方法 (有2参 方法体多条语句 有返回值)
   **/
  @Test
  public void test04(){
    Comparator<Integer> com = (x,y) -> {
      System.out.println("函数式接口");
      return Integer.compare(x,y);
    };

    System.out.println(com.compare(1, 2));
  }

  /**
   *  实现接口方法
   **/
  @Test
  public void test05(){
    //有中间操作方法
    Integer integer = optNum(100, x -> x * x);
    System.out.println(integer);

    //无中间操作方法
    Eat eat = () -> System.out.println("我在吃饭");
    eat.eat();
  }

  public Integer optNum(Integer num , Opt opt){
    return opt.op(num);
  }

  /**
   * 排序
   **/
  @Test
  public void test06(){
    List<User> arrayList = new ArrayList();
    arrayList.add(new User("老张",18,1000));
    arrayList.add(new User("老王",26,10000));
    arrayList.add(new User("老伞",15,200));
    arrayList.add(new User("老恶",33,2400));
    arrayList.add(new User("老巴",40,8800));

    Collections.sort(arrayList,(x,y) ->{
      if(x.getAge() == y.getAge()){
        return x.getName().compareTo(y.getName());
      }else{
        return Integer.compare(x.getAge(),y.getAge());
      }
    });

    arrayList.forEach(System.out::print);
  }

  /**
   * 四大核心 函数式接口
   *
   * Consumer<T> 消费形接口
   *      void accept(T t)
   *
   * Supplier<T> 供给型接口
   *      T get()
   *
   * Function<T, R> 函数型接口
   *      R apply(T t)
   *
   * Predicate<T> 断定型接口
   *      boolean test(T t)
   *
   * BiFunction<T, U, R> R apply(T t, U u)
   *
   * UnaryOperator<T>
   * (Function子接口)  T apply(T t)
   *
   * BinaryOperator<T>
   * (BiFunction 子接口)  T apply(T t1, T t2);
   *
   * BiConsumer<T, U>  void accept(T t, U u)
   *
   * ToIntFunction<T>
   * ToLongFunction<T>
   * ToDoubleFunction<T>  分 别 计 算 int 、long 、double、值的函数
   *
   * IntFunction<R>
   * LongFunction<R>
   * DoubleFunction<R>  参数分别为int、long、double 类型的函数
  **/
  @Test
  public void test07(){
    happy(1000.0,(e) -> System.out.println(e + "元我拿去花了"));
    gohappy(1000.0,() -> "大保健");
    see("黎明", e -> "我看着" + e + "有点帅");
    bijiao(900.0,e -> {
      int i = Double.compare(e, 1000);
      return i > 0?true:false;
    });
  }

  public void happy(Double money,Consumer<Double> con){
    con.accept(money);
  }
  public void gohappy(Double money, Supplier<String> sup){
    String str = sup.get();
    System.out.println("我拿了" + money + "元，去干了" + str);
  }
  public void see(String name,Function<String,String> fun){
    System.out.println(fun.apply(name));
  }
  public void bijiao(Double num1 , Predicate<Double> pre){
    boolean test = pre.test(num1);
    String s = test ? "大" : "小";
    System.out.println("传过来的" + num1 + "比默认值" + s);
  }



}
