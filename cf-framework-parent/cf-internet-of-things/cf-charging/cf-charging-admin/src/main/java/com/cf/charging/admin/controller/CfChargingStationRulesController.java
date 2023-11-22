package com.cf.charging.admin.controller;

import com.cf.charging.admin.swagger.CfChargingStationRulesSwagger;
import com.cf.charging.domain.CfChargingStationRules;
import com.cf.charging.domain.request.*;
import com.cf.charging.service.CfChargingStationRulesService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("chargingRulesAdmin/")
@Validated
@CrossOrigin
public class CfChargingStationRulesController implements CfChargingStationRulesSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationRulesService cfChargingStationRulesService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('charging-CfChargingStationRulesController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfChargingStationRulesForm cfChargingStationRulesForm) throws Exception {
        CfChargingStationRules cfChargingStationRules = new CfChargingStationRules();
        BeanUtils.copyProperties(cfChargingStationRulesForm,cfChargingStationRules);
        CfChargingStationRules lastCfChargingStationRules = cfChargingStationRulesService.add(cfChargingStationRules);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingStationRules);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationRulesController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfChargingStationRulesForm cfChargingStationRulesForm) throws Exception {
        CfChargingStationRules cfChargingStationRules = new CfChargingStationRules();
        BeanUtils.copyProperties(cfChargingStationRulesForm,cfChargingStationRules);
        CfChargingStationRules lastCfChargingStationRules = cfChargingStationRulesService.update(cfChargingStationRules);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingStationRules);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationRulesController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        Integer delete = cfChargingStationRulesService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationRulesController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfChargingStationRulesQuery cfChargingStationRulesQuery) throws Exception {
        List<CfChargingStationRules> cfChargingStationRulesList = cfChargingStationRulesService.getListByQuery(cfChargingStationRulesQuery);
        if(cfChargingStationRulesList==null || cfChargingStationRulesList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingStationRulesList);
    }
}
