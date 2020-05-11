package com.mybatisplus.mybatisplus;

import com.mybatisplus.mapper.TableMapper;
import com.mybatisplus.pojo.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TranTest
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 14:17
 * @Version 1.0.0
 */

@Service
public class TranService {

  @Autowired
  private TableMapper tableMapper;

  @Autowired
  private static int i = 1;

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void test003(Table table){

    if(i > 1){
      System.out.println(1 / 0);
    }

    tableMapper.updateById(table);

    i++;
  }

}

