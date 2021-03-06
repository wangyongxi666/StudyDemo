package com.ehcache.controller;

import com.alibaba.fastjson.JSON;
import com.ehcache.mapper.TbTableMapper;
import com.ehcache.pojo.LocalDateDemo;
import com.ehcache.pojo.TbTable;
import com.ehcache.service.TbService;
import net.minidev.json.JSONUtil;
import org.json.JSONString;
import org.skyscreamer.jsonassert.comparator.JSONCompareUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EhcacheController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月13日 13:52
 * @Version 1.0.0
*/
@RestController
@RequestMapping("/ehcache")
public class EhcacheController {

  @Autowired
  private TbService tbService;

  @Autowired
  private CacheManager cacheManager;

  @GetMapping("/findById/{id}")
  public void findById(@PathVariable int id){
//    TbTable tbTable1 = tbTableMapper.findById(id);
//    TbTable tbTable2 = tbTableMapper.findById(id);

    TbTable tbTable1 = this.test01(id);
    TbTable tbTable2 = this.test02(id);

    System.out.println(tbTable1);
    System.out.println(tbTable2);
    System.out.println(tbTable1 == tbTable2);

  }

  @GetMapping("/update/{id}")
  public void update(@PathVariable int id){
    tbService.update(id);
  }

  @GetMapping("/checkStack")
  public Object checkStack(){
    //方法的调用栈
    StackTraceElement stack[] = Thread.currentThread().getStackTrace();
    Map map = new HashMap();
    for (int i = 0; i < stack.length; i++) {
      System.out.print(stack[i].getClassName() + "->" + stack[i].getMethodName() + "-----");
      map.put(stack[i].getClassName(),stack[i].getMethodName());
    }

    String str = JSON.toJSONString(map);

    return str;
  }

  public TbTable test01(int id){

    TbTable tbTable1 = tbService.findById(id);
    return tbTable1;
  }

  public TbTable test02(int id){
    TbTable tbTable2 = tbService.findById(id);
    return tbTable2;
  }

  @GetMapping("/removeKey")
  public void removeKey(){
    cacheManager.getCache("tableCache").clear();
  }

  //验证 处理LocalDateTime 无法被序列化的问题
  @GetMapping("/testDate/{id}")
  public void testDate(@PathVariable String id){

    LocalDateDemo object = tbService.testDate(id);

  }



}
