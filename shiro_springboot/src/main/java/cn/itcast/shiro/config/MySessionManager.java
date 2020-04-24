package cn.itcast.shiro.config;

import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.SubjectContext;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @ClassName MySessionManager
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月23日 20:38
 * @Version 1.0.0
*/

//自定义sessinManager
public class MySessionManager extends DefaultWebSessionManager {

  @Override
  protected Serializable getSessionId(ServletRequest request, ServletResponse response) {

    /**
     * 头信息中具有sessionid
     *     请求头：Authorization： sessionid
     *
     * 指定sessionId的获取方式
     */

    //获取请求头Authorization中的数据
    String id = WebUtils.toHttp(request).getHeader("Authorization");

    if(StringUtils.isEmpty(id)) {
      //如果没有携带，生成新的sessionId
      return super.getSessionId(request,response);
    }else{
      //返回sessionId；
      request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");
      request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
      request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
      return id;
    }
  }
}
