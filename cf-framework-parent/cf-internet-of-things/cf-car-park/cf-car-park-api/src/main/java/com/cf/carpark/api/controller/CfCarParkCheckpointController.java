package com.cf.carpark.api.controller;

import com.cf.carpark.api.swagger.CfCarParkCheckpointSwagger;
import com.cf.carpark.domain.CfCarParkCheckpoint;
import com.cf.carpark.domain.request.CfCarParkCheckpointQuery;
import com.cf.carpark.service.CfCarParkCheckpointService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carparkCheckpoint/")
@Validated
public class CfCarParkCheckpointController implements CfCarParkCheckpointSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkCheckpointService cfCarParkCheckpointService;

    @Override
    @RequestMapping(value = "selectNearbyCheckPoint", method = RequestMethod.GET)
    public ResponseResult selectNearbyCheckPoint(CfCarParkCheckpointQuery cfCarParkCheckpointQuery) {
        List<CfCarParkCheckpoint> cfCarParkCheckpoints = cfCarParkCheckpointService.selectNearbyCheckPoint(cfCarParkCheckpointQuery);
        if(cfCarParkCheckpoints==null || cfCarParkCheckpoints.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkCheckpoints);
    }

    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery) {
        if(cfCarParkCheckpointQuery.getPage()>3 || cfCarParkCheckpointQuery.getSize()>10){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "you got too much data !");
        }
        List<CfCarParkCheckpoint> cfCarParkCheckpoints = cfCarParkCheckpointService.getListByQuery(cfCarParkCheckpointQuery);
        if(cfCarParkCheckpoints==null || cfCarParkCheckpoints.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        for(CfCarParkCheckpoint cfCarParkCheckpoint: cfCarParkCheckpoints){
            cfCarParkCheckpoint.setPositionX(null);
            cfCarParkCheckpoint.setPositionY(null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkCheckpoints);
    }
}
