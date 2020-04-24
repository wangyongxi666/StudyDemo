package cn.itcast.shiro.config;

import cn.itcast.shiro.realm.MyAuthorizingRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date 2020年04月23日 16:09
 * @Version 1.0.0
 */
@Configuration
public class ShiroConfig {


  //Filter工厂，设置对应的过滤条件和跳转条件
  @Bean
  public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
    //1.创建shiro过滤器工厂
    ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean();
    //2.设置安全管理器
    filterFactory.setSecurityManager(securityManager);
    //3.通用配置（配置登录页面，登录成功页面，验证未成功页面）
    filterFactory.setLoginUrl("/autherror?code=1"); //设置登录页面
    filterFactory.setUnauthorizedUrl("/autherror?code=2"); //授权失败跳转页面
    //4.配置过滤器集合
    /**
     * key ：访问连接
     *     支持通配符的形式
     * value：过滤器类型
     *     shiro常用过滤器
     *         anno   ：匿名访问（表明此链接所有人可以访问）
     *         authc   ：认证后访问（表明此链接需登录认证成功之后可以访问）
     */
    Map<String, String> filterMap = new LinkedHashMap<String, String>();
    // 配置不会被拦截的链接 顺序判断
    filterMap.put("/user/home", "anon");
    filterMap.put("/subject/**", "authc");
    filterMap.put("/user/**", "authc");

    //5.设置过滤器
    filterFactory.setFilterChainDefinitionMap(filterMap);
    return filterFactory;
  }

  //创建realm
  @Bean
  public MyAuthorizingRealm getRealm() {
    return new MyAuthorizingRealm();
  }

  //配置安全管理器
  @Bean
  public SecurityManager securityManager(MyAuthorizingRealm realm) {
    //使用默认的安全管理器
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    //将自定义的realm交给安全管理器统一调度管理
    securityManager.setRealm(realm);
    //将自定义的会话管理器注册到安全管理器中
    securityManager.setSessionManager(sessionManager());
    //将自定义的redis缓存管理器注册到安全管理器中
    securityManager.setCacheManager(cacheManager());

    return securityManager;
  }


  @Value("${spring.redis.host}")
  private String host;
  @Value("${spring.redis.port}")
  private int port;


  //配置shiro redisManager
  public RedisManager redisManager() {
    RedisManager redisManager = new RedisManager();
    redisManager.setHost(host);
    redisManager.setPort(port);
    return redisManager;
  }



  /**
   * RedisSessionDAO shiro sessionDao层的实现 通过redis
   * 使用的是shiro-redis开源插件
   */
  public RedisSessionDAO redisSessionDAO() {
    RedisSessionDAO sessionDAO = new RedisSessionDAO();
    sessionDAO.setRedisManager(redisManager());
    return sessionDAO;
  }


  /**
   * 3.会话管理器
   */
  public DefaultWebSessionManager sessionManager() {
    MySessionManager sessionManager = new MySessionManager();
    sessionManager.setSessionDAO(redisSessionDAO());
    //禁用cookie
    sessionManager.setSessionIdCookieEnabled(false);
    //禁用url重写   url;jsessionid=id
    sessionManager.setSessionIdUrlRewritingEnabled(false);

    sessionManager.setGlobalSessionTimeout(1800000);
    return sessionManager;
  }

  //缓存管理器
  @Bean
  public RedisCacheManager cacheManager() {
    RedisCacheManager redisCacheManager = new RedisCacheManager();
    redisCacheManager.setRedisManager(redisManager());
    return redisCacheManager;
  }

  //配置shiro注解支持
  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
    advisor.setSecurityManager(securityManager);
    return advisor;
  }

}
