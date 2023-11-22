package com.cf.logistics.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.admin.swagger.CfLogisticsQueuingAreaSwagger;
import com.cf.logistics.domain.CfLogisticsQueuingArea;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaForm;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaQuery;
import com.cf.logistics.service.CfLogisticsQueuingAreaService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsQueuingAreaAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsQueuingAreaController implements CfLogisticsQueuingAreaSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsQueuingAreaService cfLogisticsQueuingAreaService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueuingAreaController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsQueuingAreaForm cfLogisticsQueuingAreaForm) throws Exception {
        CfLogisticsQueuingArea cfLogisticsQueuingArea = new CfLogisticsQueuingArea();
        BeanUtils.copyProperties(cfLogisticsQueuingAreaForm,cfLogisticsQueuingArea);
        CfLogisticsQueuingArea lastCfLogisticsQueuingArea = cfLogisticsQueuingAreaService.add(cfLogisticsQueuingArea);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsQueuingArea);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueuingAreaController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsQueuingAreaForm cfLogisticsQueuingAreaForm) {
        CfLogisticsQueuingArea cfLogisticsQueuingArea = new CfLogisticsQueuingArea();
        BeanUtils.copyProperties(cfLogisticsQueuingAreaForm,cfLogisticsQueuingArea);
        CfLogisticsQueuingArea update = cfLogisticsQueuingAreaService.update(cfLogisticsQueuingArea);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueuingAreaController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfLogisticsQueuingAreaService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueuingAreaController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery) throws Exception {
        List<CfLogisticsQueuingArea> cfLogisticsQueuingAreas = cfLogisticsQueuingAreaService.getListByQuery(cfLogisticsQueuingAreaQuery);
        Integer countByQuery = cfLogisticsQueuingAreaService.countByQuery(cfLogisticsQueuingAreaQuery);
        if(cfLogisticsQueuingAreas==null || cfLogisticsQueuingAreas.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsQueuingAreas, countByQuery);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueuingAreaController-selectListByQuery')")
    @Override
    @RequestMapping(value = "selectListByQuery", method = RequestMethod.GET)
    public ResponseResult selectListByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery) throws Exception {
        List<CfLogisticsQueuingArea> cfLogisticsQueuingAreas = cfLogisticsQueuingAreaService.selectListByQuery(cfLogisticsQueuingAreaQuery);
        Integer countByQuery = cfLogisticsQueuingAreaService.countByQuery(cfLogisticsQueuingAreaQuery);
        if(cfLogisticsQueuingAreas==null || cfLogisticsQueuingAreas.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsQueuingAreas, countByQuery);
    }
}
