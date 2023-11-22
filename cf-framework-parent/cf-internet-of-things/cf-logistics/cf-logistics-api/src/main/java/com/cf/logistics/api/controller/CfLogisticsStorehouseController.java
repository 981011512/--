package com.cf.logistics.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.api.swagger.CfLogisticsStorehouseSwagger;
import com.cf.logistics.domain.CfLogisticsStorehouse;
import com.cf.logistics.domain.request.CfLogisticsStorehouseForm;
import com.cf.logistics.domain.request.CfLogisticsStorehouseQuery;
import com.cf.logistics.service.CfLogisticsStorehouseService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsStorehouse/")
@Validated
@CrossOrigin
public class CfLogisticsStorehouseController implements CfLogisticsStorehouseSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsStorehouseService cfLogisticsStorehouseService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery) throws Exception {
        if(StringUtils.isEmpty(cfLogisticsStorehouseQuery.getStorehouseName()) || cfLogisticsStorehouseQuery.getStorehouseName().length()<2){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null, "没有提供仓库搜索关键字，或者提供的关键字太短，需要两个以上关键字");
        }
        List<CfLogisticsStorehouse> cfLogisticsStorehouses = cfLogisticsStorehouseService.getListByQuery(cfLogisticsStorehouseQuery);
        Integer countByQuery = cfLogisticsStorehouseService.countByQuery(cfLogisticsStorehouseQuery);
        if(cfLogisticsStorehouses==null || cfLogisticsStorehouses.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsStorehouses, countByQuery);
    }

    @Override
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ResponseResult findById(Long id) throws Exception {
        CfLogisticsStorehouse cfLogisticsStorehouse = cfLogisticsStorehouseService.findById(id, false);
        if(cfLogisticsStorehouse==null){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsStorehouse);
    }
}
