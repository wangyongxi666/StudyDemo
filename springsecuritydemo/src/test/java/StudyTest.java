import org.junit.Test;

/**
 * @ClassName StudyTest
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date 2020年01月26日 17:04
 * @Version 1.0.0
 */
public class StudyTest {

  class Student {
    private int age;
    private String name;

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Student{" +
              "age=" + age +
              ", name='" + name + '\'' +
              '}';
    }

  }

  public void test01() {

    final Student student = new Student();
    student.setAge(18);


    System.out.println(student);


  }
}
