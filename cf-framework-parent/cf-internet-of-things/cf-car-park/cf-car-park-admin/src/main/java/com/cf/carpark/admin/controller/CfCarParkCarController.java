package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkCarSwagger;
import com.cf.carpark.domain.CfCarParkCar;
import com.cf.carpark.domain.request.CfCarParkCarForm;
import com.cf.carpark.domain.request.CfCarParkCarQuery;
import com.cf.carpark.service.CfCarParkCarService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("carparkcarAdmin/")
@Validated
public class CfCarParkCarController implements CfCarParkCarSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkCarService cfCarParkCarService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfCarParkCarForm cfCarParkCarForm) throws Exception {
        CfCarParkCar cfCarParkCar = new CfCarParkCar();
        BeanUtils.copyProperties(cfCarParkCarForm, cfCarParkCar);
        CfCarParkCar carParkCar = cfCarParkCarService.add(cfCarParkCar);
        return new ResponseResult(CommonCode.SUCCESS, carParkCar);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfCarParkCarForm cfCarParkCarForm) throws Exception {
        CfCarParkCar cfCarParkCar = new CfCarParkCar();
        BeanUtils.copyProperties(cfCarParkCarForm, cfCarParkCar);
        CfCarParkCar carParkCar = cfCarParkCarService.update(cfCarParkCar);
        return new ResponseResult(CommonCode.SUCCESS, carParkCar);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        cfCarParkCarService.delete(id);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfCarParkCarQuery cfCarParkCarQuery) throws Exception {
        List<CfCarParkCar> cfCarParkCars = cfCarParkCarService.mapperSelectByQuery(cfCarParkCarQuery);
        Integer total = 0;
        if(cfCarParkCarQuery.getPage()==1){
            total = cfCarParkCarService.countByQuery(cfCarParkCarQuery);
        }
        if(cfCarParkCars!=null && cfCarParkCars.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkCars, total);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }
}
