package com.cf.carpark.api.controller;

import com.cf.carpark.api.swagger.CfCarParkCarTypeSwagger;
import com.cf.carpark.domain.CfCarParkCarType;
import com.cf.carpark.service.CfCarParkCarTypeService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkCarTypeController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/23/023 22:00
 * @Version 1.0
 **/
@RestController
@RequestMapping("carparkcartype/")
@Validated
public class CfCarParkCarTypeController implements CfCarParkCarTypeSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkCarTypeService cfCarParkCarTypeService;

    @Override
    @RequestMapping(value = "getAllList", method = RequestMethod.GET)
    public ResponseResult getAllList() {
        List<CfCarParkCarType> cfCarParkCarTypes = cfCarParkCarTypeService.getAllList();
        if(cfCarParkCarTypes==null || cfCarParkCarTypes.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkCarTypes);
    }
}
