import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName FreemarkTest01
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date 2020年04月28日 18:40
 * @Version 1.0.0
 */
public class FreemarkTest01 {

  @Test
  public void testProcessTemplate() throws Exception {
    //1.创建freeMarker配置实例
    Configuration cfg = new Configuration();
    //2.设置模板加载器：开始加载模板，并且把模板加载在缓存中
    FileTemplateLoader templates = new FileTemplateLoader(new File("templates"));
    cfg.setTemplateLoader(templates);
    //3.创建数据模型
    Map<String, Object> dataModel = new HashMap<>();

    //构造list
    List<String> list = new ArrayList<>();
    list.add("西瓜");
    list.add("榴莲");
    list.add("芒果");

    dataModel.put("username", "Json");
    dataModel.put("name", "里斯");
    dataModel.put("flag", 1);
    dataModel.put("weeks", list);
    //4.获取模板
    Template template = cfg.getTemplate("template01.ftl");
    //
    /**
     * 5.处理模板内容(i.输出到文件)
     * process:
     * 参数一：数据模型（map集合）
     * 参数二：Writer对象（文件，控制台）
     */
    //i.输出到文件
    //template.process(dataModel, new FileWriter(newFile("C:\\Users\\ThinkPad\\Desktop\\ihrm\\day12\\测试\\aa.text")));
    //i.打印到控制台
    template.process(dataModel, new PrintWriter(System.out));//在控制台输出内容
  }


}
