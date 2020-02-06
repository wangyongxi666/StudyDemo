package com.wxpay.wx_pay.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WxPayController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2019年10月30日 9:09
 * @Version 1.0.0
*/
@RequestMapping("/wx")
@RestController
public class WxPayController {

  @PostMapping("/pay")
  public String toWxPay(){
    return null;
  }
}
