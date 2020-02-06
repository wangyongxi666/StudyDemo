import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName App
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年12月28日 21:44
 * @Version 1.0.0
*/
public class App {

  public static void main(String[] args) {
    new ClassPathXmlApplicationContext("spring-jobs.xml");
  }
}
