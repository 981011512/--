package com.cf.logistics.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.admin.swagger.CfLogisticsStorehousePlatformSwagger;
import com.cf.logistics.domain.CfLogisticsStorehousePlatform;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformForm;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformQuery;
import com.cf.logistics.service.CfLogisticsStorehousePlatformService;
import com.cf.logistics.service.CfLogisticsStorehouseService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsStorehousePlatformAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsStorehousePlatformController implements CfLogisticsStorehousePlatformSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfLogisticsStorehousePlatformService cfLogisticsStorehousePlatformService;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfLogisticsStorehouseService cfLogisticsStorehouseService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehousePlatformController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsStorehousePlatformForm cfLogisticsStorehousePlatformForm) throws Exception {
        cfLogisticsStorehouseService.findById(cfLogisticsStorehousePlatformForm.getStorehouseId(), false);
        CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform = new CfLogisticsStorehousePlatform();
        BeanUtils.copyProperties(cfLogisticsStorehousePlatformForm,cfLogisticsStorehousePlatform);
        CfLogisticsStorehousePlatform lastCfLogisticsStorehousePlatform = cfLogisticsStorehousePlatformService.add(cfLogisticsStorehousePlatform);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsStorehousePlatform);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehousePlatformController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsStorehousePlatformForm cfLogisticsStorehousePlatformForm) {
        cfLogisticsStorehouseService.findById(cfLogisticsStorehousePlatformForm.getStorehouseId(), false);
        CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform = new CfLogisticsStorehousePlatform();
        BeanUtils.copyProperties(cfLogisticsStorehousePlatformForm,cfLogisticsStorehousePlatform);
        CfLogisticsStorehousePlatform update = cfLogisticsStorehousePlatformService.update(cfLogisticsStorehousePlatform);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehousePlatformController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfLogisticsStorehousePlatformService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehousePlatformController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsStorehousePlatformQuery cfLogisticsStorehousePlatformQuery) throws Exception {
        List<CfLogisticsStorehousePlatform> cfLogisticsStorehousePlatforms = cfLogisticsStorehousePlatformService.getListByQuery(cfLogisticsStorehousePlatformQuery);
        Integer countByQuery = cfLogisticsStorehousePlatformService.countByQuery(cfLogisticsStorehousePlatformQuery);
        if(cfLogisticsStorehousePlatforms==null || cfLogisticsStorehousePlatforms.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsStorehousePlatforms, countByQuery);
    }
}
