package com.cf.logistics.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.admin.swagger.CfLogisticsQueuingAreaPlatformSwagger;
import com.cf.logistics.domain.CfLogisticsQueuingAreaPlatform;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaPlatformForm;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaPlatformQuery;
import com.cf.logistics.service.CfLogisticsQueuingAreaPlatformService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsQueuingAreaPlatformAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsQueuingAreaPlatformController implements CfLogisticsQueuingAreaPlatformSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsQueuingAreaPlatformService cfLogisticsQueuingAreaPlatformService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueuingAreaPlatformController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsQueuingAreaPlatformForm cfLogisticsQueuingAreaPlatformForm) throws Exception {
        CfLogisticsQueuingAreaPlatform cfLogisticsQueuingAreaPlatform = new CfLogisticsQueuingAreaPlatform();
        BeanUtils.copyProperties(cfLogisticsQueuingAreaPlatformForm,cfLogisticsQueuingAreaPlatform);
        CfLogisticsQueuingAreaPlatform lastCfLogisticsQueuingAreaPlatform = cfLogisticsQueuingAreaPlatformService.add(cfLogisticsQueuingAreaPlatform);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsQueuingAreaPlatform);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueuingAreaPlatformController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsQueuingAreaPlatformForm cfLogisticsQueuingAreaPlatformForm) {
        CfLogisticsQueuingAreaPlatform cfLogisticsQueuingAreaPlatform = new CfLogisticsQueuingAreaPlatform();
        BeanUtils.copyProperties(cfLogisticsQueuingAreaPlatformForm,cfLogisticsQueuingAreaPlatform);
        CfLogisticsQueuingAreaPlatform update = cfLogisticsQueuingAreaPlatformService.update(cfLogisticsQueuingAreaPlatform);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueuingAreaPlatformController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfLogisticsQueuingAreaPlatformService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueuingAreaPlatformController-selectByQuery')")
    @Override
    @RequestMapping(value = "selectByQuery", method = RequestMethod.GET)
    public ResponseResult selectByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery) throws Exception {
        List<CfLogisticsQueuingAreaPlatform> cfLogisticsQueuingAreaPlatforms = cfLogisticsQueuingAreaPlatformService.selectByQuery(cfLogisticsQueuingAreaPlatformQuery);
        Integer countByQuery = cfLogisticsQueuingAreaPlatformService.countByQuery(cfLogisticsQueuingAreaPlatformQuery);
        if(cfLogisticsQueuingAreaPlatforms==null || cfLogisticsQueuingAreaPlatforms.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsQueuingAreaPlatforms, countByQuery);
    }
}
