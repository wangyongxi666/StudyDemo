import com.sun.org.apache.xpath.internal.SourceTree;

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
    List list = new ArrayList();
    list.add("老大");
    list.add("老二");
    list.add("老二");
    list.add("老三");
    list.add("老四");

//    List newList = (List) list.stream().filter(e -> e.equals("老二")).collect(Collectors.toList());

    for (Object o : list) {

    }

    System.out.print(list);
  }

}


