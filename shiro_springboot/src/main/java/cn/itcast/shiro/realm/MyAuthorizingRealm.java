package cn.itcast.shiro.realm;

import cn.itcast.shiro.domain.Permission;
import cn.itcast.shiro.domain.Role;
import cn.itcast.shiro.domain.User;
import cn.itcast.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName AuthorizingRealm
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date 2020年04月23日 15:37
 * @Version 1.0.0
 */
@Component
public class MyAuthorizingRealm extends AuthorizingRealm {

  @Autowired
  private UserService userService;

  @Override
  public void setName(String name) {
    super.setName("myAuthorizingRealm");
  }

  public MyAuthorizingRealm(){

  }

  /**
   * 构造授权方法
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    //1.获取认证的用户数据
    User user = (User) principalCollection.getPrimaryPrincipal();
    System.out.println(user);
    //2.构造认证数据
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    Set<Role> roles = user.getRoles();
    for (Role role : roles) {
      //添加角色信息
      info.addRole(role.getName());
      for (Permission permission : role.getPermissions()) {
        //添加权限信息
        info.addStringPermission(permission.getCode());
      }
    }
    return info;
  }


  /**
   * 认证方法
   */
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    //1.获取登录的upToken
    UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
    //2.获取输入的用户名密码
    String username = upToken.getUsername();
    String password = new String(upToken.getPassword());
    //3.数据库查询用户
    User user = userService.findByName(username);
    System.out.println(user);
    //4.用户存在并且密码匹配存储用户数据
    if (user != null && user.getPassword().equals(password)) {
      SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
      return info;
    } else {
      //返回null会抛出异常，表明用户不存在或密码不匹配
      return null;
    }
  }
}

