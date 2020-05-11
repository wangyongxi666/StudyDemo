package com.act.controller;

import com.act.common.PageResult;
import com.act.common.Result;
import com.act.common.ResultCode;
import com.act.pojo.ProcInstance;
import com.act.service.ActService;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.engine.runtime.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ActController
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月30日 10:32
 * @Version 1.0.0
*/
@RequestMapping("/act")
@RestController
public class ActController {

  @Autowired
  private ActService actService;

  //上传流程文件
  @RequestMapping(value = "/process/deploy", method = RequestMethod.POST)
  public Result deployProcess(@RequestParam("file") MultipartFile file) throws IOException {
    actService.deployProcess(file);
    return new Result(ResultCode.SUCCESS);
  }

  // 查询所有的流程信息
  @RequestMapping(value = "/process/definition", method = RequestMethod.GET)
  public Result definitionList() {
    List list = actService.getProcessDefinitionList("1");
    return new Result(ResultCode.SUCCESS, list);
  }

  // 挂起和恢复流程
  @RequestMapping(value = "/process/suspend/{processKey}", method = RequestMethod.GET)
  public Result setProcessAblitily(@PathVariable String processKey) {
    actService.suspendProcess(processKey);
    return new Result(ResultCode.SUCCESS);
  }

  // 依据流程实例，查询流程信息
  @RequestMapping(value = "/process/instance/{page}/{size}", method = RequestMethod.PUT)
  public Result getProcessInstances(@RequestBody ProcInstance procInstance, int page, int size) {
    //1.调用service完成查询
    Page pageUser = actService.getProcessInstances(procInstance,page,size);
    //2.构造返回结果
//    PageResult pageResult = new PageResult(pageUser.getTotalElements(), pageUser.getContent());
    return new Result(ResultCode.SUCCESS, null);
  }


}
