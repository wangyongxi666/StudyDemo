package com.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Table
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月01日 13:13
 * @Version 1.0.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("tb_table")
public class Table {

  private int id;
  private String name;
  private int number;

}
