package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.pojo.Brand;

/**
 * @ClassName BrandMapper
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月21日 14:13
 * @Version 1.0.0
*/
public interface BrandMapper extends BaseMapper<Brand>{

    public Brand findById(Long id);
}
