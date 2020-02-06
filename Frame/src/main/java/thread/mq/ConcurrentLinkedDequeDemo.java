package thread.mq;

import com.sun.deploy.util.StringUtils;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName ConcurrentLinkedDequeDemo
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年01月20日 9:12
 * @Version 1.0.0
*/
public class ConcurrentLinkedDequeDemo {

  public static void main(String[] args) {
    ConcurrentLinkedQueue<String> con = new ConcurrentLinkedQueue();
    con.offer("张三");
    con.offer("李四");
    con.offer("王五");

//    System.out.println(con.poll());
//    System.out.println(con.poll());
    System.out.println(con.peek());
    System.out.println(con.peek());
    System.out.println(con.size());

  }

}
