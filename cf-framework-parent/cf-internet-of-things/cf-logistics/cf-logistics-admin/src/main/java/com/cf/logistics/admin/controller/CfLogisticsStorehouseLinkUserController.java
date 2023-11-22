package com.cf.logistics.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.admin.swagger.CfLogisticsStorehouseLinkUserSwagger;
import com.cf.logistics.domain.CfLogisticsStorehouseLinkUser;
import com.cf.logistics.domain.request.CfLogisticsStorehouseLinkUserForm;
import com.cf.logistics.domain.request.CfLogisticsStorehouseLinkUserQuery;
import com.cf.logistics.service.CfLogisticsStorehouseLinkUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsStorehouseLinkUserAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsStorehouseLinkUserController implements CfLogisticsStorehouseLinkUserSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsStorehouseLinkUserService cfLogisticsStorehouseLinkUserService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseLinkUserController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsStorehouseLinkUserForm cfLogisticsStorehouseLinkUserForm) throws Exception {
        CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser = new CfLogisticsStorehouseLinkUser();
        BeanUtils.copyProperties(cfLogisticsStorehouseLinkUserForm,cfLogisticsStorehouseLinkUser);
        CfLogisticsStorehouseLinkUser lastCfLogisticsStorehouseLinkUser = cfLogisticsStorehouseLinkUserService.add(cfLogisticsStorehouseLinkUser);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsStorehouseLinkUser);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseLinkUserController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsStorehouseLinkUserForm cfLogisticsStorehouseLinkUserForm) {
        CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser = new CfLogisticsStorehouseLinkUser();
        BeanUtils.copyProperties(cfLogisticsStorehouseLinkUserForm,cfLogisticsStorehouseLinkUser);
        CfLogisticsStorehouseLinkUser update = cfLogisticsStorehouseLinkUserService.update(cfLogisticsStorehouseLinkUser);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseLinkUserController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfLogisticsStorehouseLinkUserService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseLinkUserController-selectListByQuery')")
    @Override
    @RequestMapping(value = "selectListByQuery", method = RequestMethod.GET)
    public ResponseResult selectListByQuery(CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery) throws Exception {
        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = cfLogisticsStorehouseLinkUserService.selectListByQuery(cfLogisticsStorehouseLinkUserQuery);
        Integer countByQuery = cfLogisticsStorehouseLinkUserService.countByQuery(cfLogisticsStorehouseLinkUserQuery);
        if(cfLogisticsStorehouseLinkUsers==null || cfLogisticsStorehouseLinkUsers.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsStorehouseLinkUsers, countByQuery);
    }
}
