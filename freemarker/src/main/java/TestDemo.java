import com.sun.deploy.util.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestDemo
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年01月09日 22:26
 * @Version 1.0.0
*/
public class TestDemo {

  public static void main(String[] args) throws Exception {
    //构建配置对象
    Configuration configuration = new Configuration(Configuration.getVersion());
    //加载目录
    configuration.setDirectoryForTemplateLoading(new File("E:\\work\\study\\项目\\健康医疗\\ftl"));
    //设置字符集
    configuration.setDefaultEncoding("utf-8");

    //加载模板
    Template template = configuration.getTemplate("test.ftl");
    //准备参数
    Map map = new HashMap();
    map.put("name","老王");
    map.put("message","老王来用freemarker");

    //创建输出流
    FileWriter fileWriter = new FileWriter("E:\\work\\study\\项目\\健康医疗\\ftl\\test.html");

    //设置参数 输出
    template.process(map,fileWriter);

    fileWriter.close();

  }

}
