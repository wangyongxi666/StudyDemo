package com.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @ClassName brand
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月21日 14:06
 * @Version 1.0.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("tb_brand")
public class Brand {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String firstChar;

}
