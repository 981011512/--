package com.cf.ucenter.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.api.swagger.CfAppVersionLogSwagger;
import com.cf.ucenter.domain.CfAppVersionLog;
import com.cf.ucenter.service.CfAppVersionLogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appVersion/")
@Validated
public class CfAppVersionLogController implements CfAppVersionLogSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAppVersionLogService cfAppVersionLogService;

    @Override
    @RequestMapping(value = "checkVersion", method = RequestMethod.GET)
    public ResponseResult checkVersion(String platform, String versionNumber) {
        CfAppVersionLog cfAppVersionLog = cfAppVersionLogService.checkVersion(platform, versionNumber);
        if(cfAppVersionLog==null){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfAppVersionLog);
    }
}
