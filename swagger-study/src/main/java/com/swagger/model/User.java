package com.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName User
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月15日 10:31
 * @Version 1.0.0
*/
@ApiModel("/用户模块")
public class User {

    @ApiModelProperty("/用户姓名")
    private String name;
    @ApiModelProperty("/用户年龄")
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
