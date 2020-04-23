import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @ClassName Test01
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年02月22日 17:34
 * @Version 1.0.0
*/
public class Test01 {
  public static void main(String[] args) {

    System.out.println("---------------ArraysList-----------------");
    List<String> list = new ArrayList();

    list.add("2");
    list.add("3");
    list.add("4");
    list.add("1");
    list.add("9");

    for (String str : list) {
      System.out.println(str);
    }

    System.out.println("---------------LinkedList-----------------");

    List<String> list2 = new LinkedList();

    list2.add("2");
    list2.add("3");
    list2.add("4");
    list2.add("1");
    list2.add("9");

    for (String str : list2) {
      System.out.println(str);
    }
  }

}
