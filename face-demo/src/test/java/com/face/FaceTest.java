package com.face;

import com.baidu.aip.face.AipFace;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * @ClassName FaceRegister
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月27日 21:54
 * @Version 1.0.0
*/
public class FaceTest {

  private AipFace client;

  @Before
  public void init(){
    client = new AipFace("19634940","2cik8dDMSHxLbdFSEnaWXhTm","Y28m4PFuTqufWAGvvMGGC8Wmarzw6SLw");
  }

  /**
   * 注册用户 往百度云上添加图片
  **/
  @Test
  public void registerTest() throws IOException {
    //创建百度一年交互client对象

    //设置参数
    HashMap<String,String> optMap = new HashMap<>();
    optMap.put("quality_control","NORMAL");
    optMap.put("liveness_control","NONE");

    //构造图片
    String path = "F:\\JAVA\\2019黑马视频配套资料\\2.加薪课\\基于SaaS平台的iHRM实战开发\\IHRM项目\\11.day11-刷脸登录\\资源\\照片\\001.png";
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    String base64 = Base64.encode(bytes);

    //调用api方法完成人脸注册
    JSONObject jsonObject = client.addUser(base64, "BASE64", "ihrm", "100", optMap);

    System.out.println(jsonObject.toString(2));
  }

  /**
   * 人脸更新
   **/
  @Test
  public void updateTest() throws IOException {
    //创建百度一年交互client对象

    //设置参数
    HashMap<String,String> optMap = new HashMap<>();
    optMap.put("quality_control","NORMAL");
    optMap.put("liveness_control","NONE");

    //构造图片
    String path = "F:\\JAVA\\2019黑马视频配套资料\\2.加薪课\\基于SaaS平台的iHRM实战开发\\IHRM项目\\11.day11-刷脸登录\\资源\\照片\\001.png";
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    String base64 = Base64.encode(bytes);

    //调用api方法完成人脸注册
    JSONObject jsonObject = client.updateUser(base64, "BASE64", "ihrm", "100", optMap);

    System.out.println(jsonObject.toString(2));
  }

  /**
   * 人脸检测 识别是否是人脸
  **/
  @Test
  public void checkTest() throws IOException {

    //构造图片
    String path = "F:\\JAVA\\2019黑马视频配套资料\\2.加薪课\\基于SaaS平台的iHRM实战开发\\IHRM项目\\11.day11-刷脸登录\\资源\\照片\\001.png";
//    String path = "F:\\JAVA\\2019黑马视频配套资料\\2.加薪课\\基于SaaS平台的iHRM实战开发\\IHRM项目\\11.day11-刷脸登录\\资源\\照片\\logo.jpg";
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    String base64 = Base64.encode(bytes);

    //调用api方法
    JSONObject jsonObject = client.detect(base64, "BASE64", null);
    System.out.println(jsonObject.toString(1));
  }

  /**
   * 人脸搜索 识别相似度最高的几个（默认一个）
   **/
  @Test
  public void searchFace() throws IOException {
    //构造图片
    String path1 = "F:\\JAVA\\2019黑马视频配套资料\\2.加薪课\\基于SaaS平台的iHRM实战开发\\IHRM项目\\11.day11-刷脸登录\\资源\\照片\\001.png";
    String path2 = "F:\\JAVA\\2019黑马视频配套资料\\2.加薪课\\基于SaaS平台的iHRM实战开发\\IHRM项目\\11.day11-刷脸登录\\资源\\照片\\003.png";
    String path3 = "F:\\JAVA\\2019黑马视频配套资料\\2.加薪课\\基于SaaS平台的iHRM实战开发\\IHRM项目\\11.day11-刷脸登录\\资源\\照片\\003.png";
    String path4 = "F:\\JAVA\\2019黑马视频配套资料\\2.加薪课\\基于SaaS平台的iHRM实战开发\\IHRM项目\\11.day11-刷脸登录\\资源\\照片\\004.jpg";
    byte[] bytes = Files.readAllBytes(Paths.get(path3));
    String base64 = Base64.encode(bytes);

    JSONObject jsonObject = client.search(base64, "BASE64", "ihrm", null);
    System.out.println(jsonObject.toString(2));
  }

}
