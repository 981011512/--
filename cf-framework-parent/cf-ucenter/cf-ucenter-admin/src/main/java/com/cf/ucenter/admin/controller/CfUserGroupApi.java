package com.cf.ucenter.admin.controller;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.admin.config.AuthenticationInterceptor;
import com.cf.ucenter.admin.swagger.CfUserGroupSwagger;
import com.cf.ucenter.domain.CfUserGroup;
import com.cf.ucenter.service.CfUserGroupService;
import org.apache.dubbo.config.annotation.Reference;
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

@RestController
@RequestMapping("friendsAdmin/")
@Validated
public class CfUserGroupApi implements CfUserGroupSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfUserGroupService cfUserGroupService;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('ucenter-CfUserGroupApi-createGroup')")
    @Override
    @RequestMapping(value = "createGroup", method = RequestMethod.POST)
    public ResponseResult createGroup(
        @RequestParam("name")
        @NotEmpty String name,
        @RequestParam("people_cap")
        @Pattern(regexp = "^(200|500|1000|2000){1}$", message = "暂时只支持200|500|1000|2000人群") String peopleCap) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        return cfUserGroupService.createGroup(new CfUserGroup(idWorker.nextId(),name,"",(short)0,Short.parseShort(peopleCap),(byte)0,(byte)0,userBasicInfo.getId(),
            System.currentTimeMillis(),""));
    }
}
