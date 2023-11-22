package com.cf.logistics.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.logistics.admin.config.AuthenticationInterceptor;
import com.cf.logistics.admin.swagger.CfLogisticsQueueSwagger;
import com.cf.logistics.domain.CfLogisticsQueue;
import com.cf.logistics.domain.CfLogisticsStorehouseLinkUser;
import com.cf.logistics.domain.request.CfLogisticsQueueForm;
import com.cf.logistics.domain.request.CfLogisticsQueueQuery;
import com.cf.logistics.domain.request.CfLogisticsStorehouseLinkUserQuery;
import com.cf.logistics.service.CfLogisticsQueueService;
import com.cf.logistics.service.CfLogisticsStorehouseLinkUserService;
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
@RequestMapping("LogisticsQueueAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsQueueController implements CfLogisticsQueueSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsQueueService cfLogisticsQueueService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsStorehouseLinkUserService cfLogisticsStorehouseLinkUserService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueueController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsQueueForm cfLogisticsQueueForm) throws Exception {
        CfLogisticsQueue cfLogisticsQueue = new CfLogisticsQueue();
        BeanUtils.copyProperties(cfLogisticsQueueForm,cfLogisticsQueue);
        CfLogisticsQueue lastCfLogisticsQueue = cfLogisticsQueueService.add(cfLogisticsQueue);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsQueue);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueueController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsQueueForm cfLogisticsQueueForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfLogisticsQueue cfLogisticsQueue = new CfLogisticsQueue();
        BeanUtils.copyProperties(cfLogisticsQueueForm,cfLogisticsQueue);
        CfLogisticsQueue logisticsQueue = cfLogisticsQueueService.findById(cfLogisticsQueueForm.getId(), false);
        checkLinkerUser(userBasicInfo,logisticsQueue.getLogisticsStorehouseId());
        CfLogisticsQueue update = cfLogisticsQueueService.update(cfLogisticsQueue);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueueController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfLogisticsQueue logisticsQueue = cfLogisticsQueueService.findById(id, false);
        checkLinkerUser(userBasicInfo,logisticsQueue.getLogisticsStorehouseId());
        Integer delete = cfLogisticsQueueService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsQueueController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsQueueQuery cfLogisticsQueueQuery) throws Exception {

        //检查是否有权限进行该操作
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = checkLinkerUser(userBasicInfo, null);
        if(cfLogisticsStorehouseLinkUsers!=null && cfLogisticsStorehouseLinkUsers.size()>0){
            cfLogisticsQueueQuery.setLogisticsStorehouseIds(new ArrayList<>());
            for (CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser: cfLogisticsStorehouseLinkUsers){
                cfLogisticsQueueQuery.getLogisticsStorehouseIds().add(cfLogisticsStorehouseLinkUser.getLogisticsStorehouseId());
            }
        }

        List<CfLogisticsQueue> cfLogisticsQueues = cfLogisticsQueueService.getListByQuery(cfLogisticsQueueQuery);
        Integer countByQuery = cfLogisticsQueueService.countByQuery(cfLogisticsQueueQuery);
        if(cfLogisticsQueues==null || cfLogisticsQueues.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsQueues, countByQuery);
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
