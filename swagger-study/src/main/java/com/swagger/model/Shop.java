package com.swagger.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

/**
 * @ClassName Shop
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月15日 23:15
 * @Version 1.0.0
*/
@ApiModel("商品实体类")
public class Shop {

    @ApiModelProperty("商品名称")
    private String shopName;
    @ApiModelProperty("商品数量")
    private Integer num;

    public Shop() {
    }

    public Shop(String shopName, Integer num) {
        this.shopName = shopName;
        this.num = num;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
