package com.cf.ucenter.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.admin.swagger.RoleSwagger;
import com.cf.ucenter.admin.swagger.UcenterSwagger;
import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.domain.CfRoleAuth;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.request.CfRoleForm;
import com.cf.ucenter.request.CfUserForm;
import com.cf.ucenter.service.AuthService;
import com.cf.ucenter.service.CfRoleService;
import com.cf.ucenter.service.CfUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @ClassName RoleController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/21/021 15:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("role/")
@Validated
public class RoleController extends BaseController implements RoleSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private CfRoleService cfRoleService;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private AuthService authService;

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
    public ResponseResult add(@Validated CfRoleForm cfRoleForm) {
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
    public ResponseResult update(@Validated CfRoleForm cfRoleForm) {
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
