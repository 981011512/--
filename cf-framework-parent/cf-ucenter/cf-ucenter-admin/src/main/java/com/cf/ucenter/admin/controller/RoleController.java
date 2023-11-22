package com.cf.ucenter.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.admin.swagger.RoleSwagger;
import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.request.CfRoleForm;
import com.cf.ucenter.service.CfRoleService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色管理
 *
 * @ClassName RoleController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/21/021 15:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("roleAdmin/")
@Validated
public class RoleController implements RoleSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfRoleService cfRoleService;

    @PreAuthorize("hasAuthority('ucenter-RoleController-list')")
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseResult list() {
        List<CfRole> list = cfRoleService.list();
        if(list!=null){
            return new ResponseResult(CommonCode.SUCCESS, list);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('ucenter-RoleController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfRoleForm cfRoleForm) {
        CfRole cfRole = new CfRole();
        BeanUtils.copyProperties(cfRoleForm, cfRole);
        if(cfRole.getIcon()==null){
            cfRole.setIcon("");
        }

        CfRole role = cfRoleService.add(cfRole);
        if(role!=null){
            return new ResponseResult(CommonCode.SUCCESS, cfRole);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('ucenter-RoleController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfRoleForm cfRoleForm) {
        CfRole cfRole = cfRoleService.update(cfRoleForm);
        if(cfRole!=null){
            return new ResponseResult(CommonCode.SUCCESS, cfRole);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('ucenter-RoleController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        cfRoleService.delete(id);
        return new ResponseResult(CommonCode.SUCCESS);
    }
}
