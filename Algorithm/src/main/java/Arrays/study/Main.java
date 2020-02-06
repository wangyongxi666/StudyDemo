package Arrays.study;
/**
 * @ClassName Main
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年01月06日 15:29
 * @Version 1.0.0
*/
public class Main {

  public static void main(String[] args) {

    Array<Integer> array = new Array(10);
    for (int i = 0; i < 10; i++){
      array.addLast(i);
    }
    System.out.println(array);

    array.add(1,100);
    System.out.println(array);

    array.addFirst(-1);
    System.out.println(array);

    System.out.println(array.contain(5));
    System.out.println(array.contain(88));

    System.out.println(array.getIndex(5));
    System.out.println(array.getIndex(88));

    array.remove(0);
    System.out.println(array);

    array.removeFirst();
    System.out.println(array);

    array.removeLast();
    System.out.println(array);

    System.out.println("remove: " + array.removeElement(8));
    System.out.println(array);

    System.out.println("remove: " + array.removeElement(999));
    System.out.println(array);

    array.addFirst(88);
    array.addFirst(88);
    array.addFirst(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    System.out.println(array);

    array.removeAllElement(88);
    System.out.println(array);

    //测试扩容
    array.addFirst(88);
    array.addFirst(88);
    array.addFirst(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    array.addLast(88);
    System.out.println(array);

    //测试缩容
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    System.out.println(array);
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    System.out.println(array);
    array.removeLast();
    array.removeLast();
    array.removeLast();
    array.removeLast();
    System.out.println(array);

  }
}
