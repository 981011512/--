package com.cf.ucenter.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.admin.swagger.DepartmentSwagger;
import com.cf.ucenter.admin.swagger.RoleSwagger;
import com.cf.ucenter.domain.CfDepartment;
import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.request.CfDepartmentForm;
import com.cf.ucenter.request.CfRoleForm;
import com.cf.ucenter.service.AuthService;
import com.cf.ucenter.service.CfDepartmentService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门管理
 *
 * @ClassName DepartmentController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/21/021 15:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("department/")
@Validated
public class DepartmentController extends BaseController implements DepartmentSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private CfDepartmentService cfDepartmentService;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private AuthService authService;

    @PreAuthorize("hasAuthority('ucenter-DepartmentController-list')")
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseResult list() {
        List<CfDepartment> list = cfDepartmentService.list();
        if(list!=null){
            return new ResponseResult(CommonCode.SUCCESS, list);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('ucenter-DepartmentController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated CfDepartmentForm cfDepartmentForm) {
        CfDepartment cfDepartment = new CfDepartment();
        BeanUtils.copyProperties(cfDepartmentForm, cfDepartment);
        if(cfDepartmentForm.getIcon()==null){
            cfDepartmentForm.setIcon("");
        }
        
        CfDepartment department = cfDepartmentService.add(cfDepartment);
        if(department!=null){
            return new ResponseResult(CommonCode.SUCCESS, department);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('ucenter-DepartmentController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(CfDepartmentForm cfDepartmentForm) {
        CfDepartment cfDepartment = new CfDepartment();
        BeanUtils.copyProperties(cfDepartmentForm, cfDepartment);
        if(cfDepartmentForm.getIcon()==null){
            cfDepartmentForm.setIcon("");
        }
        CfDepartment department = cfDepartmentService.update(cfDepartment);
        if(department!=null){
            return new ResponseResult(CommonCode.SUCCESS, department);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('ucenter-DepartmentController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        cfDepartmentService.delete(id);
        return new ResponseResult(CommonCode.SUCCESS);
    }
}
