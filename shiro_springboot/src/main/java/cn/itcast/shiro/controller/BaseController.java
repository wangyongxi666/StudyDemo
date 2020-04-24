package cn.itcast.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName BaseController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月24日 13:55
 * @Version 1.0.0
*/
public class BaseController {

  //使用shiro获取
  @ModelAttribute
  public void setResAnReq(HttpServletRequest request, HttpServletResponse response) {
    //获取session中的安全数据
    Subject subject = SecurityUtils.getSubject();
    //1.subject获取所有的安全数据集合
    PrincipalCollection principals = subject.getPrincipals();
    if(principals != null && !principals.isEmpty()){
      System.out.println("成功测试");
    }
  }
}
