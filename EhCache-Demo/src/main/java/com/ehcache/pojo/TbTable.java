package com.ehcache.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName TbTable
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月13日 12:46
 * @Version 1.0.0
*/
@Data
@NoArgsConstructor
public class TbTable implements Serializable{

  private static final long serialVersionUID = 6726373562361625119L;

  private int id;

  private String name;

  private int number;

}
