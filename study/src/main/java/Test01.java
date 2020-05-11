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

    Class<Test01> test01Class = Test01.class;

    ClassLoader classLoader = test01Class.getClassLoader();

    List<Object> objects = Collections.synchronizedList(new ArrayList<>());
    objects.add(123);

  }

}


