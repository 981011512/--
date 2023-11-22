package com.cf.carpark.api.controller;

import com.cf.carpark.api.config.AuthenticationInterceptor;
import com.cf.carpark.api.swagger.CfCarParkCarSwagger;
import com.cf.carpark.domain.CfCarParkCar;
import com.cf.carpark.domain.request.CfCarParkCarForm;
import com.cf.carpark.domain.request.CfCarParkCarQuery;
import com.cf.carpark.service.CfCarParkCarService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("carparkcar/")
@Validated
public class CfCarParkCarController implements CfCarParkCarSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkCarService cfCarParkCarService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfCarParkCarForm cfCarParkCarForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkCar cfCarParkCar = new CfCarParkCar();
        cfCarParkCar.setUid(userBasicInfo.getId());
        cfCarParkCar.setNumberPlate(cfCarParkCarForm.getNumberPlate());
        cfCarParkCar.setCreateTime(System.currentTimeMillis());
        cfCarParkCar.setUpdateTime(System.currentTimeMillis());
        cfCarParkCar.setStatus((byte)1);
        cfCarParkCar.setCarTypeKey("temporary_car");
        cfCarParkCar.setCarTypeStartTime(System.currentTimeMillis());
        cfCarParkCar.setCarTypeEndTime(System.currentTimeMillis());
        CfCarParkCar carParkCar = cfCarParkCarService.bindCarToUser(cfCarParkCar);
        return new ResponseResult(CommonCode.SUCCESS, carParkCar);
    }

    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        if(StringUtils.isEmpty(id)){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "miss id");
        }
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkCarQuery cfCarParkCarQuery = new CfCarParkCarQuery();
        cfCarParkCarQuery.setId(id);
        cfCarParkCarQuery.setUid(userBasicInfo.getId());
        Integer integer = cfCarParkCarService.deleteByQuery(cfCarParkCarQuery);
        return integer>0?new ResponseResult(CommonCode.SUCCESS):new ResponseResult(CommonCode.FAIL);
    }

    @Override
    @RequestMapping(value = "getMyCarsByCondition", method = RequestMethod.GET)
    public ResponseResult getMyCarsByCondition(CfCarParkCarQuery cfCarParkCarQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfCarParkCarQuery.setUid(userBasicInfo.getId());
        cfCarParkCarQuery.setOrderBy("cpc.update_time DESC");
        List<CfCarParkCar> cfCarParkCars = cfCarParkCarService.selectByQuery(cfCarParkCarQuery);
        if(cfCarParkCars!=null && cfCarParkCars.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkCars);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }
}
