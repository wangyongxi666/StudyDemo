package com.swagger.controller;

import com.swagger.model.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @ClassName SwaggerController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月15日 9:47
 * @Version 1.0.0
*/
@RestController
@RequestMapping("/swagger")
@Api(tags = "/用户接口")
public class SwaggerController {

    @GetMapping("/getUserName")
    public String getUserName(){
        return "张三";
    }

    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户姓名"),
            @ApiImplicitParam(name = "userAge",value = "用户年龄",paramType = "int"),
            @ApiImplicitParam(name = "userBirthday",value = "用户生日",paramType = "date"),
            @ApiImplicitParam(name = "userMoney",value = "用户余额",paramType = "double")
    })
    @PostMapping("/addUserInfo")
    public void addUserInfo(String userName, Integer userAge, Date userBirthday,Double userMoney){

    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(String id){
        if("1".equals(id)){
            return "成功";
        }else {
            return "失败";
        }
    }

    @PutMapping("/updateUser")
    public void updateUser(String userInfo){

    }

    @GetMapping("/getUser")
    public User getUser(User user){
        return new User("李四",18);
    }
}
