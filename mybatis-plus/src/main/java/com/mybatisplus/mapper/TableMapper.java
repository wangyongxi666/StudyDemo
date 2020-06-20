package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.pojo.Table;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName TableMapper
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 13:13
 * @Version 1.0.0
*/
public interface TableMapper extends BaseMapper<Table> {

  @Update("UPDATE TB_TABLE SET NAME = '大佬张' WHERE NUMBER = #{number}")
  public int updateNameByNumber(Integer number);

}
