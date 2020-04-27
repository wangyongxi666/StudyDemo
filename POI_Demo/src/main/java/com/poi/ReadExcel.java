package com.poi;
/**
 * @ClassName ReadExcel
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月27日 0:10
 * @Version 1.0.0
*/
public class ReadExcel {

  public static void main(String[] args) {
    String fileName = "F:\\JAVA\\2019黑马视频配套资料\\2.加薪课\\基于SaaS平台的iHRM实战开发\\IHRM项目\\8.POI高级\\资源\\百万数据报表\\demo.xlsx";

    try {
      ExcelParser excelParser = new ExcelParser();
      excelParser.parse(fileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
