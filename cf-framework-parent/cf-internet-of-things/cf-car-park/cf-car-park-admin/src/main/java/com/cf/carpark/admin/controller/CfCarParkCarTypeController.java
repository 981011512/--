package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.swagger.CfCarParkCarTypeSwagger;
import com.cf.carpark.domain.CfCarParkCarType;
import com.cf.carpark.domain.request.CfCarParkCarTypeForm;
import com.cf.carpark.service.CfCarParkCarTypeService;
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

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkCarTypeController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/23/023 22:00
 * @Version 1.0
 **/
@RestController
@RequestMapping("carparkcartypeAdmin/")
@Validated
public class CfCarParkCarTypeController implements CfCarParkCarTypeSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkCarTypeService cfCarParkCarTypeService;

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarTypeController-getAllList')")
    @Override
    @RequestMapping(value = "getAllList", method = RequestMethod.GET)
    public ResponseResult getAllList() {
        List<CfCarParkCarType> cfCarParkCarTypes = cfCarParkCarTypeService.getAllList();
        if(cfCarParkCarTypes==null || cfCarParkCarTypes.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkCarTypes);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarTypeController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfCarParkCarTypeForm cfCarParkCarTypeForm) {
        CfCarParkCarType cfCarParkCarType = new CfCarParkCarType();
        BeanUtils.copyProperties(cfCarParkCarTypeForm, cfCarParkCarType);
        CfCarParkCarType carParkCarType = cfCarParkCarTypeService.add(cfCarParkCarType);
        return new ResponseResult(CommonCode.SUCCESS, carParkCarType);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarTypeController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfCarParkCarTypeForm cfCarParkCarTypeForm) {
        CfCarParkCarType cfCarParkCarType = new CfCarParkCarType();
        BeanUtils.copyProperties(cfCarParkCarTypeForm, cfCarParkCarType);
        CfCarParkCarType carParkCarType = cfCarParkCarTypeService.update(cfCarParkCarType);
        return new ResponseResult(CommonCode.SUCCESS, carParkCarType);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCarTypeController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfCarParkCarTypeService.delete(id);
        return delete>0 ? new ResponseResult(CommonCode.SUCCESS) : new ResponseResult(CommonCode.FAIL);
    }
}
