package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.swagger.CfCarParkPackageLogSwagger;
import com.cf.carpark.domain.CfCarParkPackageLog;
import com.cf.carpark.domain.request.CfCarParkPackageLogQuery;
import com.cf.carpark.service.CfCarParkPackageLogService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carparkpackageLogAdmin/")
@Validated
public class CfCarParkPackageLogController implements CfCarParkPackageLogSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkPackageLogService cfCarParkPackageLogService;

    @PreAuthorize("hasAuthority('carpark-CfCarParkPackageLogController-selectByQuery')")
    @Override
    @RequestMapping(value = "selectByQuery", method = RequestMethod.GET)
    public ResponseResult selectByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery) throws Exception {
        List<CfCarParkPackageLog> cfCarParkPackageLogs = cfCarParkPackageLogService.selectByQuery(cfCarParkPackageLogQuery);
        if(cfCarParkPackageLogs==null || cfCarParkPackageLogs.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        Integer total = 0;
        if(cfCarParkPackageLogQuery.getPage()==1){
            total = cfCarParkPackageLogService.countByQuery(cfCarParkPackageLogQuery);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkPackageLogs, total);
    }
}
