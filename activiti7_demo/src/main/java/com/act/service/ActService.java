package com.act.service;

import com.act.pojo.ProcInstance;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.activiti.engine.runtime.ProcessInstance;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName ActService
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年04月30日 10:34
 * @Version 1.0.0
*/
public class ActService {

  private RepositoryService repositoryService;

  //上传流程文件
  public void deployProcess(MultipartFile files) throws IOException {
    String fileName = files.getOriginalFilename();
    Deployment deploy = repositoryService.createDeployment().addBytes(fileName, files.getBytes()).deploy();
    System.out.println(" 部署 ID:" + deploy.getId());
  }

  //查询所有已部署流程
  public List<ProcessDefinition> getProcessDefinitionList(String companyId) {
    return repositoryService.createProcessDefinitionQuery().processDefinitionTenantId(companyId).latestVersion().list();
  }


  //流程挂起/激活
  public void suspendProcess(String processKey) {
    ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processKey).latestVersion().singleResult();
    if(definition.isSuspended()) { //如果是挂起状态，这里激活此流程
      repositoryService.activateProcessDefinitionById(definition.getId());
    }else{
      //如果不是挂起状态，这里挂起此流程
      repositoryService.suspendProcessDefinitionById(definition.getId());
    }
  }


  //查询所有发起的流程
  public Page getProcessInstances(ProcInstance in, int page, int size) {
//    Specification<ProcInstance> spec = new Specification<ProcInstance>() {
//      public Predicate toPredicate(Root<ProcInstance> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
//        List<Predicate> list = new ArrayList<>();
//        if(!StringUtils.isEmpty(in.getProcessState())) {
//          Expression<String> exp = root.<String>get("processState");
//          list.add(exp.in(in.getProcessState().split(",")));
//        }
//        if(!StringUtils.isEmpty(in.getUserId())) {
//
//          list.add(cb.equal(root.get("userId").as(String.class),in.getUserId()));
//        }
//        if(!StringUtils.isEmpty(in.getProcessKey())) {
//
//          list.add(cb.equal(root.get("processKey").as(String.class),in.getProcessKey()));
//        }
//        if(!StringUtils.isEmpty(in.getProcCurrNodeUserId())) {
//
//          list.add(cb.like(root.get("procCurrNodeUserId").as(String.class),"%"+in.getProcCurrNodeUserId()+"%"));
//        }
//        return cb.and(list.toArray(new Predicate[list.size()]));
//      }
//    };
//    return procInstanceDao.findAll(spec, new PageRequest(page, size));
    return null;
  }

}
