package com.cf.logistics.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.admin.swagger.CfLogisticsVehicleSwagger;
import com.cf.logistics.domain.CfLogisticsVehicle;
import com.cf.logistics.domain.request.CfLogisticsVehicleForm;
import com.cf.logistics.domain.request.CfLogisticsVehicleQuery;
import com.cf.logistics.service.CfLogisticsVehicleService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsVehicleAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsVehicleController implements CfLogisticsVehicleSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsVehicleService cfLogisticsVehicleService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsVehicleController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsVehicleForm cfLogisticsVehicleForm) throws Exception {
        CfLogisticsVehicle cfLogisticsVehicle = new CfLogisticsVehicle();
        BeanUtils.copyProperties(cfLogisticsVehicleForm,cfLogisticsVehicle);
        CfLogisticsVehicle lastCfLogisticsVehicle = cfLogisticsVehicleService.add(cfLogisticsVehicle);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsVehicle);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsVehicleController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsVehicleForm cfLogisticsVehicleForm) {
        CfLogisticsVehicle cfLogisticsVehicle = new CfLogisticsVehicle();
        BeanUtils.copyProperties(cfLogisticsVehicleForm,cfLogisticsVehicle);
        CfLogisticsVehicle update = cfLogisticsVehicleService.update(cfLogisticsVehicle);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsVehicleController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfLogisticsVehicleService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsVehicleController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsVehicleQuery cfLogisticsVehicleQuery) throws Exception {
        List<CfLogisticsVehicle> cfLogisticsVehicles = cfLogisticsVehicleService.getListByQuery(cfLogisticsVehicleQuery);
        Integer countByQuery = cfLogisticsVehicleService.countByQuery(cfLogisticsVehicleQuery);
        if(cfLogisticsVehicles==null || cfLogisticsVehicles.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsVehicles, countByQuery);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsVehicleController-manuallySynchronizeTmsSystemData')")
    @Override
    @RequestMapping(value = "manuallySynchronizeTmsSystemData", method = RequestMethod.GET)
    public ResponseResult manuallySynchronizeTmsSystemData() throws Exception {
        List<CfLogisticsVehicle> cfLogisticsVehicles = cfLogisticsVehicleService.synchronizeTmsVehicle();
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsVehicles);
    }
}
