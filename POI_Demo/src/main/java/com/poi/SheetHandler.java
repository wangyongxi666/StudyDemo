package com.poi;

import com.pojo.PoiEntity;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

//自定义Sheet基于Sax的解析处理器
public class SheetHandler implements XSSFSheetXMLHandler.SheetContentsHandler {
    //封装实体对象
    private PoiEntity entity;
    /**
     * 解析行开始
     */
    @Override
    public void startRow(int rowNum) {
        if (rowNum >0 ) {
            entity = new PoiEntity();
       }
   }

    /**
     * 解析每一个单元格
     */
    @Override
    public void cell(String cellReference, String formattedValue, XSSFComment comment)
{
        if(entity != null) {
          //判断单元格名称，Excel上面的A.B.C.....标题
            switch (cellReference.substring(0, 1)) {
                case "A":
                    entity.setId(formattedValue);
                    break;
                case "B":
                    entity.setBreast(formattedValue);
                    break;
                case "C":
                    entity.setAdipocytes(formattedValue);
                    break;
                case "D":
                    entity.setNegative(formattedValue);
                    break;
                case "E":
                    entity.setStaining(formattedValue);
                    break;
                case "F":
                    entity.setSupportive(formattedValue);
                    break;
                default:
                    break;
           }
       }
   }

    /**
     * 解析行结束
     */
    public void endRow(int rowNum) {
        System.out.println(entity);
   }

    //处理头尾
    public void headerFooter(String text, boolean isHeader, String tagName) {
   }
}