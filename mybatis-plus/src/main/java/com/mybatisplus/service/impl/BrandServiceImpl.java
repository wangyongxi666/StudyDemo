package com.mybatisplus.service.impl;

import com.mybatisplus.mapper.BrandMapper;
import com.mybatisplus.service.BrandService;
import org.springframework.stereotype.Service;

/**
 * @ClassName BrandServiceImpl
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月22日 14:08
 * @Version 1.0.0
*/
@Service
public class BrandServiceImpl implements BrandService{

    private BrandMapper brandMapper;

    @Override
    public void getItemById(String id) {

    }
}
