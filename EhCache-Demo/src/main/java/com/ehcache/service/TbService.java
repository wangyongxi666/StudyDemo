package com.ehcache.service;

import com.ehcache.mapper.TbTableMapper;
import com.ehcache.pojo.LocalDateDemo;
import com.ehcache.pojo.TbTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName TbService
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月15日 21:04
 * @Version 1.0.0
*/
@Service
@CacheConfig(cacheNames = {"tableCache"})
public class TbService {

  @Autowired
  private TbTableMapper tbTableMapper;

  @Cacheable(key = "#id")
  public TbTable findById(int id) {

    TbTable tbTable = tbTableMapper.findById(id);

    return tbTable;

  }

  @CachePut(key = "#id")
  public TbTable update(int id) {

    TbTable tbTable = new TbTable();
    tbTable.setId(11);
    tbTable.setName("哈哈哈哈哈");
    tbTable.setNumber(80);

    return tbTable;

  }

  @Cacheable(key = "#id")
  public LocalDateDemo testDate(String id) {
    LocalDateTime now = LocalDateTime.now();

    LocalDateDemo localDateDemo = new LocalDateDemo();
    localDateDemo.setName("呵呵呵呵");
    localDateDemo.setAge(10000000);
    localDateDemo.setLocalDateTime(now);

    return localDateDemo;

  }
}
