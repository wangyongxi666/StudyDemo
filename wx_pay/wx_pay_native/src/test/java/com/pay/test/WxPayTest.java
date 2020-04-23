package com.pay.test;

import com.github.wxpay.sdk.MyConfig;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WxPayTest
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年02月29日 18:56
 * @Version 1.0.0
*/
public class WxPayTest {

  public static void main(String[] args) throws Exception {
    MyConfig myConfig = new MyConfig();
    WXPay wxPay = new WXPay(myConfig);

    Map payMap = new HashMap();

    payMap.put("body","畅购商城支付结账");
    payMap.put("out_trade_no","8899005");
    payMap.put("total_fee","1");
    payMap.put("spbill_create_ip","127.0.0.1");
    payMap.put("trade_type","NATIVE");
    payMap.put("notify_url","http://www.baidu.com");


    Map result = wxPay.unifiedOrder(payMap);
    System.out.println(result);
  }

}
