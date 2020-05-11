package cn.itcast.dubboxdemo.controller;
import cn.itcast.dubbodemo.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;


    @RequestMapping("/showName")
    public String showName(){
        return userService.getName();
    }

    @RequestMapping("/exceptionTest")
    @ResponseBody
    public String ExceptionTest(){

        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("try--catch 后面执行的语句");

    }
}