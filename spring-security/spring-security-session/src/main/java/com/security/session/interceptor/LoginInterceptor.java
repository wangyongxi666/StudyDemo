package com.security.session.interceptor;

import com.security.session.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LoginInterceptor
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年06月19日 20:36
 * @Version 1.0.0
*/
@Component
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    System.out.println("拦截器拦截了登陆请求");

    String url = request.getRequestURL().toString();

    if(url.contains("r1")){
      return true;
    }

    Object attribute = request.getSession().getAttribute(User.USER_KEY);
    if(attribute == null){
      returnMsg("请登录",response);
    }

    User user = (User) attribute;

    if(user.getRoles().contains("r2") && url.contains("r2")){
      return true;
    }

    returnMsg("权限不足",response);

    return true;
  }

  //向页面写出数据
  public void returnMsg(String message, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = response.getWriter();
    writer.write(message);
    writer.close();
  }


}
