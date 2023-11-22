package com.cf.logistics.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.admin.swagger.CfLogisticsStorehouseCargoTypeSwagger;
import com.cf.logistics.domain.CfLogisticsStorehouseCargoType;
import com.cf.logistics.domain.request.CfLogisticsStorehouseCargoTypeForm;
import com.cf.logistics.domain.request.CfLogisticsStorehouseCargoTypeQuery;
import com.cf.logistics.service.CfLogisticsStorehouseCargoTypeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsStorehouseCargoTypeAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsStorehouseCargoTypeController implements CfLogisticsStorehouseCargoTypeSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsStorehouseCargoTypeService cfLogisticsStorehouseCargoTypeService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseCargoTypeController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsStorehouseCargoTypeForm cfLogisticsStorehouseCargoTypeForm) throws Exception {
        CfLogisticsStorehouseCargoType cfLogisticsStorehouseCargoType = new CfLogisticsStorehouseCargoType();
        BeanUtils.copyProperties(cfLogisticsStorehouseCargoTypeForm,cfLogisticsStorehouseCargoType);
        CfLogisticsStorehouseCargoType lastCfLogisticsStorehouseCargoType = cfLogisticsStorehouseCargoTypeService.add(cfLogisticsStorehouseCargoType);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsStorehouseCargoType);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseCargoTypeController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsStorehouseCargoTypeForm cfLogisticsStorehouseCargoTypeForm) {
        CfLogisticsStorehouseCargoType cfLogisticsStorehouseCargoType = new CfLogisticsStorehouseCargoType();
        BeanUtils.copyProperties(cfLogisticsStorehouseCargoTypeForm,cfLogisticsStorehouseCargoType);
        CfLogisticsStorehouseCargoType update = cfLogisticsStorehouseCargoTypeService.update(cfLogisticsStorehouseCargoType);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseCargoTypeController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfLogisticsStorehouseCargoTypeService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseCargoTypeController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsStorehouseCargoTypeQuery cfLogisticsStorehouseCargoTypeQuery) throws Exception {
        List<CfLogisticsStorehouseCargoType> cfLogisticsStorehouseCargoTypes = cfLogisticsStorehouseCargoTypeService.getListByQuery(cfLogisticsStorehouseCargoTypeQuery);
        Integer countByQuery = cfLogisticsStorehouseCargoTypeService.countByQuery(cfLogisticsStorehouseCargoTypeQuery);
        if(cfLogisticsStorehouseCargoTypes==null || cfLogisticsStorehouseCargoTypes.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsStorehouseCargoTypes, countByQuery);
    }
}
