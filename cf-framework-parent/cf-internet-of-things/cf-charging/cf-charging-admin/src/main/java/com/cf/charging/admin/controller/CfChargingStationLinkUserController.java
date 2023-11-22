package com.cf.charging.admin.controller;

import com.cf.charging.admin.swagger.CfChargingStationLinkUserSwagger;
import com.cf.charging.domain.CfChargingStationLinkUser;
import com.cf.charging.domain.request.CfChargingStationLinkUserForm;
import com.cf.charging.domain.request.CfChargingStationLinkUserQuery;
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
@RequestMapping("cfChargingStationLinkUserAdmin/")
@Validated
@CrossOrigin
public class CfChargingStationLinkUserController implements CfChargingStationLinkUserSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationLinkUserService cfChargingStationLinkUserService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('charging-CfChargingStationLinkUserController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfChargingStationLinkUserForm cfChargingStationLinkUserForm) throws Exception {
        CfChargingStationLinkUser cfChargingStationLinkUser = new CfChargingStationLinkUser();
        BeanUtils.copyProperties(cfChargingStationLinkUserForm,cfChargingStationLinkUser);
        CfChargingStationLinkUser lastCfChargingStationLinkUser = cfChargingStationLinkUserService.add(cfChargingStationLinkUser);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingStationLinkUser);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationLinkUserController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfChargingStationLinkUserForm cfChargingStationLinkUserForm) {
        CfChargingStationLinkUser cfChargingStationLinkUser = new CfChargingStationLinkUser();
        BeanUtils.copyProperties(cfChargingStationLinkUserForm,cfChargingStationLinkUser);
        CfChargingStationLinkUser newCfChargingStationLinkUser = cfChargingStationLinkUserService.update(cfChargingStationLinkUser);
        return new ResponseResult(CommonCode.SUCCESS, newCfChargingStationLinkUser);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationLinkUserController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery) throws Exception {
        List<CfChargingStationLinkUser> cfChargingStationLinkUserList = cfChargingStationLinkUserService.getListByQuery(cfChargingStationLinkUserQuery);
        if(cfChargingStationLinkUserList==null || cfChargingStationLinkUserList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingStationLinkUserList);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationLinkUserController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        Integer delete = cfChargingStationLinkUserService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }
}
