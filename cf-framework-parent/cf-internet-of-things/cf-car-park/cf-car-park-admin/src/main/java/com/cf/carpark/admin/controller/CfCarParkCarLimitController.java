package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.swagger.CfCarParkCarLimitSwagger;
import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfCarParkCarLimit;
import com.cf.carpark.domain.request.CfCarParkCarLimitForm;
import com.cf.carpark.domain.request.CfCarParkCarLimitQuery;
import com.cf.carpark.service.CfCarParkCarLimitService;
import com.cf.carpark.service.CfCarParkService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carParkCarLimitAdmin/")
@Validated
public class CfCarParkCarLimitController implements CfCarParkCarLimitSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkCarLimitService cfCarParkCarLimitService;

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarLimitController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfCarParkCarLimitForm cfCarParkCarLimitForm) {
        CfCarParkCarLimit cfCarParkCarLimit = new CfCarParkCarLimit();
        BeanUtils.copyProperties(cfCarParkCarLimitForm,cfCarParkCarLimit);
        CfCarParkCarLimit carParkCarLimit = cfCarParkCarLimitService.add(cfCarParkCarLimit);
        return new ResponseResult(CommonCode.SUCCESS, carParkCarLimit);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarLimitController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfCarParkCarLimitForm cfCarParkCarLimitForm) {
        CfCarParkCarLimit cfCarParkCarLimit = new CfCarParkCarLimit();
        BeanUtils.copyProperties(cfCarParkCarLimitForm,cfCarParkCarLimit);
        CfCarParkCarLimit carParkCarLimit = cfCarParkCarLimitService.update(cfCarParkCarLimit);
        return new ResponseResult(CommonCode.SUCCESS, carParkCarLimit);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarLimitController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfCarParkCarLimitService.delete(id);
        return delete>0 ? new ResponseResult(CommonCode.SUCCESS) : new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarLimitController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(@Validated CfCarParkCarLimitQuery cfCarParkCarLimitQuery) {
        List<CfCarParkCarLimit> cfCarParkCarLimits = cfCarParkCarLimitService.getListByQuery(cfCarParkCarLimitQuery);
        return cfCarParkCarLimits!=null && cfCarParkCarLimits.size()>0 ? new ResponseResult(CommonCode.SUCCESS, cfCarParkCarLimits) : new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarLimitController-selectContinCarParkByQuery')")
    @Override
    @RequestMapping(value = "selectContinCarParkByQuery", method = RequestMethod.GET)
    public ResponseResult selectContinCarParkByQuery(@Validated CfCarParkCarLimitQuery cfCarParkCarLimitQuery) {
        List<CfCarParkCarLimit> cfCarParkCarLimits = cfCarParkCarLimitService.selectContinCarParkByQuery(cfCarParkCarLimitQuery);
        Integer total = 0;
        if(cfCarParkCarLimitQuery.getPage()==1){
            total = cfCarParkCarLimitService.countByQuery(cfCarParkCarLimitQuery);
        }
        return cfCarParkCarLimits!=null && cfCarParkCarLimits.size()>0 ? new ResponseResult(CommonCode.SUCCESS, cfCarParkCarLimits, total) : new ResponseResult(CommonCode.NO_MORE_DATAS);
    }
}
