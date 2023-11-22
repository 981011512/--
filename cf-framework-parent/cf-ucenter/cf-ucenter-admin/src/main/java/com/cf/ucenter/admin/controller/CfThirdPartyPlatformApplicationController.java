package com.cf.ucenter.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.admin.swagger.CfThirdPartyPlatformApplicationSwagger;
import com.cf.ucenter.domain.CfThirdPartyPlatformApplication;
import com.cf.ucenter.request.CfThirdPartyPlatformApplicationForm;
import com.cf.ucenter.request.CfThirdPartyPlatformApplicationQuery;
import com.cf.ucenter.service.CfThirdPartyPlatformApplicationService;
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
 * 第三方应用管理
 *
 * @ClassName CfThirdPartyPlatformApplicationController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/12/21/021 15:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("CfThirdPartyPlatformApplicationAdmin/")
@Validated
public class CfThirdPartyPlatformApplicationController implements CfThirdPartyPlatformApplicationSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfThirdPartyPlatformApplicationService cfThirdPartyPlatformApplicationService;

    @PreAuthorize("hasAuthority('ucenter-CfThirdPartyPlatformApplicationController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfThirdPartyPlatformApplicationQuery cfThirdPartyPlatformApplicationQuery) {
        List<CfThirdPartyPlatformApplication> list = cfThirdPartyPlatformApplicationService.getListByQuery(cfThirdPartyPlatformApplicationQuery);
        if(list!=null && list.size()>0){
            Integer integer = cfThirdPartyPlatformApplicationService.countByQuery(cfThirdPartyPlatformApplicationQuery);
            return new ResponseResult(CommonCode.SUCCESS, list, integer);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('ucenter-CfThirdPartyPlatformApplicationController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfThirdPartyPlatformApplicationForm cfThirdPartyPlatformApplicationForm) {
        CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication = new CfThirdPartyPlatformApplication();
        BeanUtils.copyProperties(cfThirdPartyPlatformApplicationForm, cfThirdPartyPlatformApplication);
        
        CfThirdPartyPlatformApplication department = cfThirdPartyPlatformApplicationService.add(cfThirdPartyPlatformApplication);
        if(department!=null){
            return new ResponseResult(CommonCode.SUCCESS, department);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('ucenter-CfThirdPartyPlatformApplicationController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfThirdPartyPlatformApplicationForm cfThirdPartyPlatformApplicationForm) {
        CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication = new CfThirdPartyPlatformApplication();
        BeanUtils.copyProperties(cfThirdPartyPlatformApplicationForm, cfThirdPartyPlatformApplication);

        CfThirdPartyPlatformApplication department = cfThirdPartyPlatformApplicationService.update(cfThirdPartyPlatformApplication);
        if(department!=null){
            return new ResponseResult(CommonCode.SUCCESS, department);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('ucenter-CfThirdPartyPlatformApplicationController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String appid) {
        cfThirdPartyPlatformApplicationService.delete(appid);
        return new ResponseResult(CommonCode.SUCCESS);
    }
}
