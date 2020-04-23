import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.junit.Test;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JasperReportsDemo
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年01月31日 21:26
 * @Version 1.0.0
*/
public class JasperReportsDemo {

  @Test
  public void test01() throws Exception{
    String jrxmlPath =
            "D:\\Program Files\\Java\\JavaApp\\IDEA\\idea-git\\dubboDemo\\jasperReports\\src\\main\\resources\\demo.jrxml";
    String jasperPath =
            "D:\\Program Files\\Java\\JavaApp\\IDEA\\idea-git\\dubboDemo\\jasperReports\\src\\main\\resources\\demo.jasper";

    //编译模板
    JasperCompileManager.compileReportToFile(jrxmlPath,jasperPath);

    //构造数据
    Map paramters = new HashMap();
    paramters.put("reportDate","2019-10-10");
    paramters.put("company","itcast");

    List<Map> list = new ArrayList();
    Map map1 = new HashMap();
    map1.put("name","xiaoming");
    map1.put("address","beijing");
    map1.put("email","xiaoming@itcast.cn");
    Map map2 = new HashMap();
    map2.put("name","xiaoli");
    map2.put("address","nanjing");
    map2.put("email","xiaoli@itcast.cn");
    list.add(map1);
    list.add(map2);

    //填充数据
    JasperPrint jasperPrint =
            JasperFillManager.fillReport(jasperPath,
                    paramters,
                    new JRBeanCollectionDataSource(list));

    //输出文件
    String pdfPath = "D:\\test.pdf";
    JasperExportManager.exportReportToPdfFile(jasperPrint,pdfPath);
  }

  @Test
  public void testReport_JDBC() throws Exception{
    //准备数据源
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/health",
                    "root",
                    "1234");

    String jrxmlPath = "D:\\Program Files\\Java\\JavaApp\\IDEA\\idea-git\\dubboDemo\\jasperReports\\src\\main\\resources\\demo1.jrxml";
    String jasperPath = "D:\\Program Files\\Java\\JavaApp\\IDEA\\idea-git\\dubboDemo\\jasperReports\\src\\main\\resources\\demo1.jasper";

    //模板编译 后缀为jasper
    JasperCompileManager.compileReportToFile(jrxmlPath,jasperPath);

    //构造数据
    Map paramters = new HashMap();
    paramters.put("company","传智播客");

    //填充数据---使用JDBC数据源方式填充
    JasperPrint jasperPrint =
            JasperFillManager.fillReport(jasperPath,
                    paramters,
                    connection);

    //输出文件
    String pdfPath = "D:\\test.pdf";
    JasperExportManager.exportReportToPdfFile(jasperPrint,pdfPath);
  }

  @Test
  public void testReport_JavaBean() throws Exception{
    String jrxmlPath = "D:\\Program Files\\Java\\JavaApp\\IDEA\\idea-git\\dubboDemo\\jasperReports\\src\\main\\resources\\demo2.jrxml";
    String jasperPath = "D:\\Program Files\\Java\\JavaApp\\IDEA\\idea-git\\dubboDemo\\jasperReports\\src\\main\\resources\\demo2.jasper";

    //编译模板
    JasperCompileManager.compileReportToFile(jrxmlPath,jasperPath);

    //构造数据
    Map paramters = new HashMap();
    paramters.put("company","传智播客");

    List<Map> list = new ArrayList();
    Map map1 = new HashMap();
    map1.put("tName","入职体检套餐");
    map1.put("tCode","RZTJ");
    map1.put("tAge","18-60");
    map1.put("tPrice","500");

    Map map2 = new HashMap();
    map2.put("tName","阳光爸妈老年健康体检");
    map2.put("tCode","YGBM");
    map2.put("tAge","55-60");
    map2.put("tPrice","500");
    list.add(map1);
    list.add(map2);

    //填充数据---使用JavaBean数据源方式填充
    JasperPrint jasperPrint =
            JasperFillManager.fillReport(jasperPath,
                    paramters,
                    new JRBeanCollectionDataSource(list));
    //输出文件
    String pdfPath = "D:\\test.pdf";
    JasperExportManager.exportReportToPdfFile(jasperPrint,pdfPath);
  }

}
