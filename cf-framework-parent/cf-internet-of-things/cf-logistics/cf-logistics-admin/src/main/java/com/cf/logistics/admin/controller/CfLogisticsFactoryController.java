package com.cf.logistics.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.admin.swagger.CfLogisticsFactorySwagger;
import com.cf.logistics.domain.CfLogisticsFactory;
import com.cf.logistics.domain.request.CfLogisticsFactoryForm;
import com.cf.logistics.domain.request.CfLogisticsFactoryQuery;
import com.cf.logistics.service.CfLogisticsFactoryService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsFactoryAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsFactoryController implements CfLogisticsFactorySwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsFactoryService cfLogisticsFactoryService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsFactoryController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsFactoryForm cfLogisticsFactoryForm) throws Exception {
        CfLogisticsFactory cfLogisticsFactory = new CfLogisticsFactory();
        BeanUtils.copyProperties(cfLogisticsFactoryForm,cfLogisticsFactory);
        CfLogisticsFactory lastCfLogisticsFactory = cfLogisticsFactoryService.add(cfLogisticsFactory);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsFactory);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsFactoryController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsFactoryForm cfLogisticsFactoryForm) {
        CfLogisticsFactory cfLogisticsFactory = new CfLogisticsFactory();
        BeanUtils.copyProperties(cfLogisticsFactoryForm,cfLogisticsFactory);
        CfLogisticsFactory update = cfLogisticsFactoryService.update(cfLogisticsFactory);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsFactoryController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfLogisticsFactoryService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsFactoryController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsFactoryQuery cfLogisticsFactoryQuery) throws Exception {
        List<CfLogisticsFactory> cfLogisticsFactorys = cfLogisticsFactoryService.getListByQuery(cfLogisticsFactoryQuery);
        Integer countByQuery = cfLogisticsFactoryService.countByQuery(cfLogisticsFactoryQuery);
        if(cfLogisticsFactorys==null || cfLogisticsFactorys.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsFactorys, countByQuery);
    }
}
