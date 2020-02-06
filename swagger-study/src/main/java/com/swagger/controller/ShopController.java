package com.swagger.controller;

import com.swagger.model.Shop;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ShopController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月15日 13:50
 * @Version 1.0.0
*/
@RestController
@RequestMapping("/shop")
@Api(tags = "商品模块接口")
public class ShopController {

    @GetMapping("/getShop")
    @ApiOperation("获取商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopName",value = "商品名称")
    })
    public Shop getShop(String shopName){
        return new Shop(shopName,15);
    }

    @GetMapping("/deleteShop")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopName",value = "商品名称")
    })
    @ApiOperation("删除商品")
    public Boolean deleteShop(String shopName){
        if("abc".equals(shopName)){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/addShop")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop",value = "商品封装信息")
    })
    @ApiOperation("商品添加")
    public Shop addShop(@RequestBody Shop shop){
        return new Shop(shop.getShopName(),shop.getNum());
    }



}
