package com.mybatisplus.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.mapper.BrandMapper;
import com.mybatisplus.pojo.Brand;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MybatisPlusApplicationTests {

	@Autowired
	private BrandMapper brandMapper;

	//查询全部
	@Test
	public void selectList(){
		List<Brand> brands = brandMapper.selectList(null);
		for (Brand brand : brands) {
			System.out.println(brand);
		}
	}

	//插入一条
	@Test
	public void testInsert(){
		Brand brand = new Brand();
		brand.setId(null);
		brand.setName("海尔");
		brand.setFirstChar("H");
		int insert = brandMapper.insert(brand);
		System.out.println(insert);

		System.out.println("id = " + brand.getId());
	}

	//根据id查询
	@Test
	public void selectById(){
		Long num = 11L;
		System.out.println(num);
	}

	//根据id更新
	@Test
	public void updateById(){
		Brand brand = new Brand();
		brand.setId(25L);
		brand.setName("步步高");
		brand.setFirstChar("B");
		int result = brandMapper.updateById(brand);
		System.out.println("影响了 ： " + result + " 行");
	}

	//根据条件更新 含实体类
	@Test
	public void update(){
		Brand brand = new Brand();
		brand.setName("超级步步高");
		brand.setFirstChar("C");

		QueryWrapper<Brand> wrapper = new QueryWrapper();
		wrapper.eq("first_char","B");
		brandMapper.update(brand,wrapper);
	}

	//根据条件更新 不含实体类
	@Test
	public void update2(){
		UpdateWrapper<Brand> wrapper = new UpdateWrapper();
		wrapper.set("name","步步高")
                .set("fristChar","B")
				.eq("first_char","B");
		brandMapper.update(null,wrapper);
	}

	//使用map封装删除条件
	@Test
	public void deleteForMap(){
		Map<String,Object> map = new HashMap<>();
		map.put("name","步步高");
		map.put("first_char","B");
		brandMapper.deleteByMap(map);
	}

	//使用实体类封装删除条件
	@Test
	public void deleteForPojo(){
	    Brand brand = new Brand();
        brand.setName("步步高");
        brand.setFirstChar("B");

        QueryWrapper<Brand> wrapper = new QueryWrapper<>(brand);
        brandMapper.delete(wrapper);
    }

    //查询大于操作
    @Test
    public void selectByGt(){
		QueryWrapper<Brand> wrapper = new QueryWrapper<>();
		wrapper.gt("id",10);

        Integer count = brandMapper.selectCount(wrapper);
        System.out.println(count);
    }

    //分页操作
    @Test
    public void getPage(){
        QueryWrapper wrapper = new QueryWrapper();

        Page<Brand> page = new Page<>(2,5);
        IPage<Brand> iPage = brandMapper.selectPage(page,null);
        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getSize());
        System.out.println(iPage.getRecords());
    }

    @Test
    public void findById(){
        Brand brand = brandMapper.findById(12L);
        System.out.println(brand);
    }



}
