package java_basics.singleton;

import java.util.Properties;

/**
 * @ClassName singletonTest
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 9:16
 * @Version 1.0.0
*/
public class singletonTest {

  public static void main(String[] args) {
    User user = User.getUser();
    User user2 = User.getUser();
    System.out.println("user:" + (user == user2));

    UserUpdate userUpdate = UserUpdate.getUser();
    UserUpdate userUpdate2 = UserUpdate.getUser();
    System.out.println("userUpdate:" + (userUpdate == userUpdate2));

    Student student = Student.getStudent();
    Student student2 = Student.getStudent();
    System.out.println("student:" + (student == student2));

    Complate complate = Complate.COMPLATE;
    Complate complate2 = Complate.COMPLATE;
    System.out.println("complate:" + (complate == complate2));

    Car car = Car.getCar();
    Car car2 = Car.getCar();
    System.out.println("Car:" + (car == car2));
  }


}

//懒汉式 线程不安全
class User{

  private static User user;

  public static User getUser(){
    if(user == null){
      return user = new User();
    }else {
      return user;
    }
  }

}

//懒汉式 线程安全(效率低)
class UserUpdate{

  private static UserUpdate userUpdate;

  public synchronized static UserUpdate getUser(){
    if(userUpdate == null){
      return userUpdate = new UserUpdate();
    }else {
      return userUpdate;
    }
  }

}

//懒汉式 线程安全(效率高)
class UserTop{

  private static UserTop userTop;

  public static UserTop getUser(){

    if(userTop == null){
      synchronized (UserTop.class){
        if(userTop == null){
          return userTop = new UserTop();
        }else{
          return userTop;
        }
      }
    }else {
      return userTop;
    }
  }

}

//饿汉式
class Student{

  private final static Student STUDENT = new Student();

  public static Student getStudent(){
    return STUDENT;
  }
}

class Car{

  public Car(){}

  public static Car getCar(){
    return Dog.car;
  }

  private static class Dog{
    private static final Car car= new Car();
  }

}





