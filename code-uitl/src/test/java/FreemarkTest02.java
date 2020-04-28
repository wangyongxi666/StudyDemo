import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.*;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class FreemarkTest02 {
  private Configuration conf;

  @Before
  public void init() {
    conf = new Configuration();
  }

  @Test
  public void testProcessTemplateString() throws Exception {
    String templateString = "欢迎您：${username}";
    Map<String, Object> dataMap = new HashMap();
    dataMap.put("username", "张三");
    StringWriter out = new StringWriter();
    /**
     * 自定义模板
     * 1.模板名称
     * 2.模板的正文内容
     * 3.configuration对象
     */
    Template template = new Template("templateString...", new StringReader(templateString), conf);
    //处理模板内容
    template.process(dataMap, out);
    System.out.println(out.toString());
  }
}