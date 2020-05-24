package com.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Demo1
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年05月17日 20:20
 * @Version 1.0.0
*/
public class DemoJDK14 {

  private static final Logger LOGGER = LoggerFactory.getLogger(DemoJDK14.class);

  public static void main(String[] args) {

    LOGGER.info("我是info");

    System.out.println("我被夹在中间了");

    LOGGER.debug("我是debug");

    LOGGER.error("我是error");
  }

}
