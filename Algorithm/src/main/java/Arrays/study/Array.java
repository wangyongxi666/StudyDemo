package Arrays.study;
/**
 * @ClassName Array
 * @Description 自定义动态数组
 * @Author YongXi.Wang
 * @Date  2020年01月06日 15:30
 * @Version 1.0.0
*/
public class Array<E> {

  private E[] data;

  //指向数组末尾没有元素的索引
  private int size;

  /**
   * 有参构造
   **/
  public Array(int capacity){
    data = (E[]) new Object[capacity];
    size = 0;
  }

  /**
   * 无参构造
  **/
  public Array(){
    this(10);
  }

  /**
   * 获取数据个数
   **/
  public int getSize(){
    return size;
  }

  /**
   * 获取数组容量
   **/
  public int getCapacity(){
    return data.length;
  }

  /**
   * 判断数组是否为空
   **/
  public boolean isEmpty(){
    return size == 0;
  }

  /**
   *  向数组末尾添加元素
   **/
  public void addLast(E e){
    add(size,e);
  }

  /**
   *  向数组首添加元素
   **/
  public void addFirst(E e){
    add(0,e);
  }

  /**
   *  向数组 指定位置添加元素
   **/
  public void add(int index,E e){
    //校验是否已满
    if(data.length == size){
      //数组扩容 判断当  实际数量 == 数组容量 ， 扩容一半
      resize(size ,1);
    }

    //判断位置是否合法
    if(index < 0 || index > size){
      throw new IllegalArgumentException("索引位置不合法");
    }

    //添加
    for(int i = size - 1; i >= index; i--){
        data[i + 1] = data[i];
    }

    data[index] = e;
    size ++;
  }

  /**
   *  根据索引获取数据
  **/
  public E get(int index){

    //判断位置是否合法
    if(index < 0 || index > size){
      throw new IllegalArgumentException("索引位置不合法");
    }

    return data[index];
  }

  /**
   *  根据索引修改数据
  **/
  public void set(int index,E e){

    //判断插入位置是否合法
    if(index < 0 || index > size){
      throw new IllegalArgumentException("索引位置不合法");
    }

    data[index] = e;
  }

  /**
   * 是否包含某个元素
  **/
  public boolean contain(E e){

    for (int i=0; i < size; i ++){
      if(data[i].equals(e)){
        return true;
      }
    }

    return false;
  }

  /**
   * 查找元素的索引 ， 不存在则返回-1
  **/
  public int getIndex(E e){

    for (int i=0; i < size; i ++){
      if(data[i].equals(e)){
        return i;
      }
    }

    return -1;
  }

  /**
   * 删除元素
  **/
  public E remove(int index){

    //判断位置是否合法
    if(index < 0 || index >= size){
      throw new IllegalArgumentException("索引位置不合法");
    }

    E e = data[index];

    for(int i = index + 1; i < size; i++){
      data[i - 1] = data[i];
    }

    size --;
    data[size] = null;

    if(data.length / 4 > size && size / 2 != 0 ){
      //数组扩容  判断当  实际数量 == 数组容量  / 4 ，缩容一半
      resize(size,0);
    }

    return e;
  }

  /**
   * 删除第一个元素
   **/
  public E removeFirst(){
    return remove(0);
  }

  /**
   * 删除最后一个元素
   **/
  public E removeLast(){
    return remove(size - 1);
  }

  /**
   * 根据传入数据删除数据
  **/
  public boolean removeElement(E e){
    int index = getIndex(e);
    if(index != -1){
      remove(index);
      return true;
    }
      return false;
  }

  /**
   * 根据传入数据删除数据 (删除所有)
   **/
  public void removeAllElement(E e){
    int index;
    while ((index = getIndex(e)) != -1){
      remove(index);
    }
  }

  /**
   * 数组调整容量
  **/
  private void resize(int size,int type) {

    if(data != null){

      E[] newData;

      //根据类型判断是扩容还是缩容
      if(type == 1){
        newData = (E[]) new Object[size * 2];
      }else{
        newData = (E[]) new Object[data.length / 2];
      }


      for(int i = 0; i < size; i ++){

        newData[i] = data[i];

      }

      data = newData;
    }

  }

  /**
   *  重写打印输出
  **/
  @Override
  public String toString() {
    StringBuffer sbf = new StringBuffer();

    //拼接字符串
    sbf.append(String.format("Array size = %d, capacity = %d\n",size,data.length));

    sbf.append("[");

    for (int i = 0; i < size; i++){

      sbf.append(data[i]);

      if(i < size - 1){
        sbf.append(",");
      }

    }

    sbf.append("]");

    return sbf.toString();
  }

}
