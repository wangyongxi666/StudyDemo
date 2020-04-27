package com.face;

import com.baidu.aip.util.Base64Util;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Path;

/**
 * @ClassName QRCodeTest
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月27日 23:32
 * @Version 1.0.0
*/
public class QRCodeTest {

  //保存到本地图片
//  public static void main(String[] args) throws Exception {
//    //二维码中的信息
//    String content = "http://www.baidu.com";
//
//    //zxing生成二维码(保存到本地图片，支持已data url形式体现)
//    //创建QRCodeWriter对象
//    QRCodeWriter writer =  new QRCodeWriter();
//
//    //基本配置
//    BitMatrix bt = writer.encode(content, BarcodeFormat.QR_CODE, 200, 200);
//
//    Path path = new File("F:\\JAVA\\2019黑马视频配套资料\\2.加薪课\\基于SaaS平台的iHRM实战开发\\IHRM项目\\11.day11-刷脸登录\\资源\\照片\\qrcode.png").toPath();
//
//    //保存二维码到本地
//    MatrixToImageWriter.writeToPath(bt,"png",path);
//
//  }

  //生成 data url 形式
  public static void main(String[] args) throws Exception {
    //二维码中的信息
    String content = "http://www.baidu.com";

    //zxing生成二维码(保存到本地图片，支持已data url形式体现)
    //创建QRCodeWriter对象
    QRCodeWriter writer =  new QRCodeWriter();

    //基本配置
    BitMatrix bt = writer.encode(content, BarcodeFormat.QR_CODE, 200, 200);

    //创建 输出流
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    //将二维码 数据存入流中
    BufferedImage image = MatrixToImageWriter.toBufferedImage(bt);

    ImageIO.write(image,"png",os);

    //以byte数组进行base64处理
    String encode = Base64Util.encode(os.toByteArray());
    String URL = "data:image/png;base64," + encode;
    System.out.println(URL);
  }

}
