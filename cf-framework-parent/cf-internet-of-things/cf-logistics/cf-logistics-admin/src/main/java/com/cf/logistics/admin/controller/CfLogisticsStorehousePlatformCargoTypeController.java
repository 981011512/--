package com.cf.logistics.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.admin.swagger.CfLogisticsStorehousePlatformCargoTypeSwagger;
import com.cf.logistics.domain.CfLogisticsStorehousePlatformCargoType;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformCargoTypeForm;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformCargoTypeQuery;
import com.cf.logistics.service.CfLogisticsStorehousePlatformCargoTypeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsStorehousePlatformCargoTypeAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsStorehousePlatformCargoTypeController implements CfLogisticsStorehousePlatformCargoTypeSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsStorehousePlatformCargoTypeService cfLogisticsStorehousePlatformCargoTypeService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehousePlatformCargoTypeController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsStorehousePlatformCargoTypeForm cfLogisticsStorehousePlatformCargoTypeForm) throws Exception {
        CfLogisticsStorehousePlatformCargoType cfLogisticsStorehousePlatformCargoType = new CfLogisticsStorehousePlatformCargoType();
        BeanUtils.copyProperties(cfLogisticsStorehousePlatformCargoTypeForm,cfLogisticsStorehousePlatformCargoType);
        CfLogisticsStorehousePlatformCargoType lastCfLogisticsStorehousePlatformCargoType = cfLogisticsStorehousePlatformCargoTypeService.add(cfLogisticsStorehousePlatformCargoType);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsStorehousePlatformCargoType);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehousePlatformCargoTypeController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsStorehousePlatformCargoTypeForm cfLogisticsStorehousePlatformCargoTypeForm) {
        CfLogisticsStorehousePlatformCargoType cfLogisticsStorehousePlatformCargoType = new CfLogisticsStorehousePlatformCargoType();
        BeanUtils.copyProperties(cfLogisticsStorehousePlatformCargoTypeForm,cfLogisticsStorehousePlatformCargoType);
        CfLogisticsStorehousePlatformCargoType update = cfLogisticsStorehousePlatformCargoTypeService.update(cfLogisticsStorehousePlatformCargoType);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehousePlatformCargoTypeController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfLogisticsStorehousePlatformCargoTypeService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehousePlatformCargoTypeController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery) throws Exception {
        List<CfLogisticsStorehousePlatformCargoType> cfLogisticsStorehousePlatformCargoTypes = cfLogisticsStorehousePlatformCargoTypeService.getListByQuery(cfLogisticsStorehousePlatformCargoTypeQuery);
        Integer countByQuery = cfLogisticsStorehousePlatformCargoTypeService.countByQuery(cfLogisticsStorehousePlatformCargoTypeQuery);
        if(cfLogisticsStorehousePlatformCargoTypes==null || cfLogisticsStorehousePlatformCargoTypes.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsStorehousePlatformCargoTypes, countByQuery);
    }
}
