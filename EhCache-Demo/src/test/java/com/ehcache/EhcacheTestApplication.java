package com.ehcache;

import com.ehcache.mapper.TbTableMapper;
import com.ehcache.pojo.TbTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName EhcacheTestApplication
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月13日 12:58
 * @Version 1.0.0
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class EhcacheTestApplication {

  @Autowired
  private TbTableMapper tbTableMapper;

  @Test
  public void test01(){
    System.out.println(tbTableMapper);
    TbTable t = tbTableMapper.findById(1);
    System.out.println(t);
    System.out.println("123");
  }

}
