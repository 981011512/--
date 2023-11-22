package com.cf.charging.admin.controller;

import com.cf.charging.admin.swagger.CfChargingPortSwagger;
import com.cf.charging.domain.CfChargingPort;
import com.cf.charging.domain.request.CfChargingPortForm;
import com.cf.charging.domain.request.CfChargingPortQuery;
import com.cf.charging.service.CfChargingPortService;
import com.cf.charging.service.CfChargingStationLinkUserService;
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
@RequestMapping("chargingPortAdmin/")
@Validated
@CrossOrigin
public class CfChargingPortController implements CfChargingPortSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationLinkUserService cfCarParkLinkUserQuery;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingPortService cfChargingPortService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('charging-CfChargingPortController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfChargingPortForm cfChargingPortForm) throws Exception {
        CfChargingPort cfChargingPort = new CfChargingPort();
        BeanUtils.copyProperties(cfChargingPortForm,cfChargingPort);
        CfChargingPort lastCfChargingPort = cfChargingPortService.add(cfChargingPort);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingPort);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingPortController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfChargingPortForm cfChargingPortForm) {
        CfChargingPort cfChargingPort = new CfChargingPort();
        BeanUtils.copyProperties(cfChargingPortForm,cfChargingPort);
        CfChargingPort lastCfChargingPort = cfChargingPortService.update(cfChargingPort);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingPort);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingPortController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        Integer delete = cfChargingPortService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingPortController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfChargingPortQuery cfChargingPortQuery) throws Exception {
        List<CfChargingPort> cfChargingPortList = cfChargingPortService.getListByQuery(cfChargingPortQuery);
        if(cfChargingPortList==null || cfChargingPortList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingPortList);
    }
}
