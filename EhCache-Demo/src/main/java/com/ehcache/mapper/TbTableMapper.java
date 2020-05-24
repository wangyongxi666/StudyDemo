package com.ehcache.mapper;

import com.ehcache.pojo.TbTable;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * @ClassName TbTableMapper
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月13日 12:50
 * @Version 1.0.0
*/
@Mapper
public interface TbTableMapper {

  public TbTable findById(int id);

}
