package thread.mq;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName BlockingDequeDemo
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年01月20日 9:40
 * @Version 1.0.0
*/
public class BlockingDequeDemo{

  public static void main(String[] args) {
    BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(3);

    try {
      blockingDeque.offer("张三");
      blockingDeque.offer("李四");
      blockingDeque.offer("王五");
      blockingDeque.offer("李六",3, TimeUnit.SECONDS);

      System.out.println(blockingDeque);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
