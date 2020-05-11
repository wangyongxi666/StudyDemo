package com.mybatisplus.mybatisplus;

import com.mybatisplus.mapper.TableMapper;
import com.mybatisplus.pojo.Table;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TransactionalTest
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 13:17
 * @Version 1.0.0
*/

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionalTest {

  private static int i = 1;

  @Autowired
  private TableMapper tableMapper;
  @Autowired
  private TranService tranService;

  @Test
  public void test01(){
    Table table = tableMapper.selectById(1);
    System.out.println(table);
  }

  @Test
  @Transactional(rollbackFor={Exception.class,RuntimeException.class})
  @Rollback(false)
  public void test02_1(){

    Table table1 = new Table();
    Table table2 = new Table();

    table1.setId(1);
    table1.setNumber(11111);

    table2.setId(2);
    table2.setNumber(22222);

    this.test02_2(table1);
    this.test02_2(table2);
  }

//  @Test
//  @Rollback(false)
//  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Transactional()
  public void test02_2(Table table){

    if(i > 1){
      System.out.println(1 / 0);
    }

    tableMapper.updateById(table);

    System.out.println("执行了一次update");

    i ++;

  }

  @Transactional()
  @Test
  @Rollback(false)
  public void test03(){
    Table table1 = new Table();
    Table table2 = new Table();

    table1.setId(1);
    table1.setNumber(11111);

    table2.setId(2);
    table2.setNumber(22222);

    tranService.test003(table1);
    tranService.test003(table2);
  }

}
