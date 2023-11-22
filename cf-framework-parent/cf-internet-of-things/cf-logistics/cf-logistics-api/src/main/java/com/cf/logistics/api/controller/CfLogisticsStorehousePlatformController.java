package com.cf.logistics.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.api.swagger.CfLogisticsStorehousePlatformSwagger;
import com.cf.logistics.domain.CfLogisticsStorehousePlatform;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformForm;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformQuery;
import com.cf.logistics.service.CfLogisticsStorehousePlatformService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsStorehousePlatform/")
@Validated
@CrossOrigin
public class CfLogisticsStorehousePlatformController implements CfLogisticsStorehousePlatformSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsStorehousePlatformService cfLogisticsStorehousePlatformService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsStorehousePlatformQuery cfLogisticsStorehousePlatformQuery) throws Exception {
        if(cfLogisticsStorehousePlatformQuery.getStorehouseId()==null){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null, "请提供仓库id");
        }
        List<CfLogisticsStorehousePlatform> cfLogisticsStorehousePlatforms = cfLogisticsStorehousePlatformService.getListByQuery(cfLogisticsStorehousePlatformQuery);
        Integer countByQuery = cfLogisticsStorehousePlatformService.countByQuery(cfLogisticsStorehousePlatformQuery);
        if(cfLogisticsStorehousePlatforms==null || cfLogisticsStorehousePlatforms.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsStorehousePlatforms, countByQuery);
    }
}
