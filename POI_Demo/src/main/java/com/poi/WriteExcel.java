package com.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName WriteExcel
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月25日 0:24
 * @Version 1.0.0
*/
public class WriteExcel {

  public static void main(String[] args) throws IOException {
    //创建工作簿
    Workbook workbook = new XSSFWorkbook();

    //创建表单sheet
    Sheet sheet = workbook.createSheet("test");

    //创建执行对象
    Row row = sheet.createRow(2);
    //创建单元格对象
    Cell cell = row.createCell(2);
    //像单元格中写入内容
    cell.setCellValue("测试poi代码");

    //获取输入流
    FileOutputStream ous = new FileOutputStream("E:\\work\\studywork\\project\\ihrm\\poi\\test.xlsx");

    //写入文件
    workbook.write(ous);

    ous.close();
  }

}
