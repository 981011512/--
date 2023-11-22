package com.cf.logistics.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.logistics.admin.config.AuthenticationInterceptor;
import com.cf.logistics.admin.swagger.CfLogisticsStorehouseSwagger;
import com.cf.logistics.domain.CfLogisticsStorehouse;
import com.cf.logistics.domain.CfLogisticsStorehouseLinkUser;
import com.cf.logistics.domain.request.CfLogisticsStorehouseForm;
import com.cf.logistics.domain.request.CfLogisticsStorehouseLinkUserQuery;
import com.cf.logistics.domain.request.CfLogisticsStorehouseQuery;
import com.cf.logistics.service.CfLogisticsStorehouseLinkUserService;
import com.cf.logistics.service.CfLogisticsStorehouseService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("LogisticsStorehouseAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsStorehouseController implements CfLogisticsStorehouseSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsStorehouseService cfLogisticsStorehouseService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsStorehouseLinkUserService cfLogisticsStorehouseLinkUserService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsStorehouseForm cfLogisticsStorehouseForm) throws Exception {
        CfLogisticsStorehouse cfLogisticsStorehouse = new CfLogisticsStorehouse();
        BeanUtils.copyProperties(cfLogisticsStorehouseForm,cfLogisticsStorehouse);
        CfLogisticsStorehouse lastCfLogisticsStorehouse = cfLogisticsStorehouseService.add(cfLogisticsStorehouse);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsStorehouse);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsStorehouseForm cfLogisticsStorehouseForm) {
        CfLogisticsStorehouse cfLogisticsStorehouse = new CfLogisticsStorehouse();
        BeanUtils.copyProperties(cfLogisticsStorehouseForm,cfLogisticsStorehouse);
        CfLogisticsStorehouse update = cfLogisticsStorehouseService.update(cfLogisticsStorehouse);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfLogisticsStorehouseService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery) throws Exception {
        //检查是否有权限进行该操作
//        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
//        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = checkLinkerUser(userBasicInfo, null);
//        if(cfLogisticsStorehouseLinkUsers!=null && cfLogisticsStorehouseLinkUsers.size()>0){
//            cfLogisticsStorehouseQuery.setIds(new ArrayList<>());
//            for (CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser: cfLogisticsStorehouseLinkUsers){
//                cfLogisticsStorehouseQuery.getIds().add(cfLogisticsStorehouseLinkUser.getLogisticsStorehouseId());
//            }
//        }

        List<CfLogisticsStorehouse> cfLogisticsStorehouses = cfLogisticsStorehouseService.getListByQuery(cfLogisticsStorehouseQuery);
        Integer countByQuery = cfLogisticsStorehouseService.countByQuery(cfLogisticsStorehouseQuery);
        if(cfLogisticsStorehouses==null || cfLogisticsStorehouses.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsStorehouses, countByQuery);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsStorehouseController-selectListByQuery')")
    @Override
    @RequestMapping(value = "selectListByQuery", method = RequestMethod.GET)
    public ResponseResult selectListByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery) throws Exception {
//        //检查是否有权限进行该操作
//        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
//        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = checkLinkerUser(userBasicInfo, null);
//        if(cfLogisticsStorehouseLinkUsers!=null && cfLogisticsStorehouseLinkUsers.size()>0){
//            cfLogisticsStorehouseQuery.setIds(new ArrayList<>());
//            for (CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser: cfLogisticsStorehouseLinkUsers){
//                cfLogisticsStorehouseQuery.getIds().add(cfLogisticsStorehouseLinkUser.getLogisticsStorehouseId());
//            }
//        }

        List<CfLogisticsStorehouse> cfLogisticsStorehouses = cfLogisticsStorehouseService.selectListByQuery(cfLogisticsStorehouseQuery);
        Integer countByQuery = cfLogisticsStorehouseService.countByQuery(cfLogisticsStorehouseQuery);
        if(cfLogisticsStorehouses==null || cfLogisticsStorehouses.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsStorehouses, countByQuery);
    }

    /**
     * 检查用户是否有权限操作相关物流仓库数据
     * @param userBasicInfo
     * @param logisticsStorehouseId
     * @return
     */
    private List<CfLogisticsStorehouseLinkUser> checkLinkerUser(UserBasicInfo userBasicInfo, Long logisticsStorehouseId){
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery = new CfLogisticsStorehouseLinkUserQuery();
            cfLogisticsStorehouseLinkUserQuery.setUid(userBasicInfo.getId());
            cfLogisticsStorehouseLinkUserQuery.setLogisticsStorehouseId(logisticsStorehouseId);
            List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = cfLogisticsStorehouseLinkUserService.getListByQuery(cfLogisticsStorehouseLinkUserQuery);
            if(cfLogisticsStorehouseLinkUsers==null || cfLogisticsStorehouseLinkUsers.size()==0){
                ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
            }
            return cfLogisticsStorehouseLinkUsers;
        }
        return null;
    }
}
