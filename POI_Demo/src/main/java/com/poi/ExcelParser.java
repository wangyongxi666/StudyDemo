package com.poi;


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;

/**
 * 自定义Excel解析器
 */
public class ExcelParser {
  public void parse(String path) throws Exception {
    //1.根据Excel获取OPCPackage对象
    OPCPackage pkg = OPCPackage.open(path, PackageAccess.READ);
    try {
      //2.创建XSSFReader对象
      XSSFReader reader = new XSSFReader(pkg);
      //3.获取SharedStringsTable对象
      SharedStringsTable sst = reader.getSharedStringsTable();
      //4.获取StylesTable对象
      StylesTable styles = reader.getStylesTable();
      //5.创建Sax的XmlReader对象
      XMLReader parser = XMLReaderFactory.createXMLReader();
      //6.设置处理器
      parser.setContentHandler(new XSSFSheetXMLHandler(styles, sst, new SheetHandler(), false));
      XSSFReader.SheetIterator sheets = (XSSFReader.SheetIterator) reader.getSheetsData();
      //7.逐行读取
      while (sheets.hasNext()) {
        InputStream sheetstream = sheets.next();
        InputSource sheetSource = new InputSource(sheetstream);
        try {
          parser.parse(sheetSource);
        } finally {
          sheetstream.close();
        }
      }
    } finally {
      pkg.close();
    }
  }
}
