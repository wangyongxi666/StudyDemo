package cn.itcast.dubbodemo.service.impl;

import cn.itcast.dubbodemo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {
    public String getName() {
        return "itcast";
    }
}