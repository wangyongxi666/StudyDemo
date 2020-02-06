import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName ServletTest
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年02月02日 12:53
 * @Version 1.0.0
*/
@WebServlet(urlPatterns = "/demo")
public class ServletTest implements Servlet{
  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
    System.out.println("初始化方法执行");
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//    servletResponse.setCharacterEncoding("UTF-8");
//    ServletOutputStream outputStream = servletResponse.getOutputStream();
//    outputStream.write("我跟你问好啊".getBytes());
//    outputStream.flush();
//    outputStream.close();
    System.out.println("你好啊");

    int i = 1 / 0;

    System.out.println("我很好啊");
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {
    System.out.println("销毁方法执行");
  }
}
