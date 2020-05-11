package java_basics.singleton;

import java.util.ArrayList;
import java.util.List;

public class volatileSingleton{

  public static void main(String[] args) {
    Dog dog = new Dog();

    List<Dog> list = new ArrayList<>();

    for(int i = 0; i < 10 ; i++){
      new Thread(() ->{

        list.add(dog.getDog());

      },String.valueOf(i)).start();
    }

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if(Thread.activeCount() > 0){
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println(list);

  }

}

class Dog{

  private volatile Dog dog;

  public Dog getDog(){

    try {
      Thread.sleep(600);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if(dog != null){
      return dog;
    }else{
      return dog = new Dog();
    }
  }

}