package cn.itcast.shiro.controller;

import cn.itcast.shiro.domain.User;
import cn.itcast.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Enumeration;

@RestController
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    //不需要登陆的方法
    @RequestMapping(value = "/user/home",method = RequestMethod.GET)
    public String home() {
        return "这个方法不需要登陆，欢迎回家";
    }

    //添加
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String add() {
        return "添加用户成功";
    }
	
    //查询
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String find() {
        return "查询用户成功";
    }

    //全部查询
    @RequiresPermissions(value = "user-find-all")
    @RequiresRoles(value = "系统管理员")
    @RequestMapping(value = "/user/all",method = RequestMethod.GET)
    public String findAll() {
        return "查询全部用户成功";
    }
    //全部查询
    @RequestMapping(value = "/user/findRole",method = RequestMethod.GET)
    public String findRole() {
        return "查询指定角色成功";
    }
	
    //更新
    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public String update(String id) {
        return "更新用户成功";
    }
	
    //删除
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String delete() {
        return "删除用户成功";
    }
	
	//用户登录
	@RequestMapping(value="/login")
    public String login(String username,String password) {
	  System.out.println("用户登录");

    String sid = null;
      try {

        //密码加密
//        Md5Hash md5Hash = new Md5Hash(password, username,3);

        //构造令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //获取session
          sid = (String) subject.getSession().getId();

          //使用subject进行登陆
        subject.login(token);
      } catch (AuthenticationException e) {
        e.printStackTrace();
        return "用户名或密码错误";
      }

      return "登录成功" + sid;
    }

	//过滤器跳转
	@RequestMapping(value="/autherror")
    public String autherror(@RequestParam Integer code) {

      return code == 1 ? "未登录":"未授权";
    }

    //登录成功后，打印所有session内容
    @RequestMapping(value="/show")
    public String show(HttpSession session) {
        // 获取session中所有的键值
        Enumeration<?> enumeration = session.getAttributeNames();
        // 遍历enumeration中的
        while (enumeration.hasMoreElements()) {
            // 获取session键值
            String name = enumeration.nextElement().toString();
            // 根据键值取session中的值
            Object value = session.getAttribute(name);
            // 打印结果
            System.out.println("<B>" + name + "</B>=" + value + "<br>/n");
        }
        return "查看session成功";
    }


    //登录成功后，打印所有subjectTest内容
    @RequestMapping(value="/user/subject/test",method = RequestMethod.GET)
    public String subjectTest() {

        System.out.println("hahahahhahaha");

        return "hhhh";

//        Subject subject = SecurityUtils.getSubject();
//        PrincipalCollection principals = subject.getPrincipals();
//        if(principals != null && !principals.isEmpty()){
//            User user = (User) principals.getPrimaryPrincipal();
//            System.out.println(user);
//            return "查看subject成功";
//        }else{
//            return "查看subject失败";
//        }
    }




}
