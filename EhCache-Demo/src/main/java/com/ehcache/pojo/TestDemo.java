package com.ehcache.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDemo {
    /**
    * 
    */
    private Integer id;

    /**
    * 商标名称，sbmc
    */
    private String title;

    /**
    * 申请日期，sqrq
    */
    private Integer applyDate;

    /**
    * 申请人名称中文，sqrmcZw
    */
    private String applicantCh;

    /**
    * 申请人名称英文，sqrmcYw
    */
    private String applicantEn;

    /**
    * 申请人地址中文，sqrdzZw
    */
    private String addressCh;

    /**
    * 代理/办理机构，dlrmc
    */
    private String agency;

    /**
    * 最新商标状态，newProcess
    */
    private Integer latestStatus;

    /**
    * 专用权期限开始时间，zyqqx
    */
    private Integer optionsStart;

    /**
    * 专用权期限结束时间，zyqqx
    */
    private Integer optionsEnd;

    /**
    * 修改日期
    */
    private Integer update;
}