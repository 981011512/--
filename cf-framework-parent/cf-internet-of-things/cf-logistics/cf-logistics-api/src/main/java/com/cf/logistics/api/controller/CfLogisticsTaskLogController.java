package com.cf.logistics.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.logistics.api.config.AuthenticationInterceptor;
import com.cf.logistics.api.swagger.CfLogisticsTaskLogSwagger;
import com.cf.logistics.domain.*;
import com.cf.logistics.domain.request.*;
import com.cf.logistics.service.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("LogisticsTaskLog/")
@Validated
@CrossOrigin
public class CfLogisticsTaskLogController implements CfLogisticsTaskLogSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsTaskService cfLogisticsTaskService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsTaskLogService cfLogisticsTaskLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsStorehouseLinkUserService cfLogisticsStorehouseLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsStorehouseService cfLogisticsStorehouseService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsStorehousePlatformService cfLogisticsStorehousePlatformService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsFactoryService cfLogisticsFactoryService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsQueuingAreaService cfLogisticsQueuingAreaService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "selectListByQuery", method = RequestMethod.GET)
    public ResponseResult selectListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) throws Exception {

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfLogisticsTaskLogService.checkUserDocumentsStatus(userBasicInfo.getId());
        cfLogisticsTaskLogQuery.setDeliverUid(userBasicInfo.getId());
        List<CfLogisticsTaskLog> cfLogisticsTaskLogs = cfLogisticsTaskLogService.selectListByQuery(cfLogisticsTaskLogQuery);
        Integer countByQuery = cfLogisticsTaskLogService.countByQuery(cfLogisticsTaskLogQuery);
        if(cfLogisticsTaskLogs==null || cfLogisticsTaskLogs.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsTaskLogs, countByQuery);
    }

    @Override
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ResponseResult findById(Long taskLogId) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.findById(taskLogId, false);
        if(!cfLogisticsTaskLog.getDeliverUid().equals(userBasicInfo.getId())){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null, "该预约数据不属于您");
        }
        //查询月台
        cfLogisticsTaskLog.setCfLogisticsQueuingArea(cfLogisticsQueuingAreaService.findById(cfLogisticsTaskLog.getQueuingAreaId(), false));;

        //查询其前面有几个人在排队
        CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        cfLogisticsTaskLogQuery.setQueuingAreaId(cfLogisticsTaskLog.getQueuingAreaId());
        if(cfLogisticsTaskLog.getTaskLogStatus()==(byte)2){
            cfLogisticsTaskLogQuery.setMaxQueueIndex(new Integer(cfLogisticsTaskLog.getQueueIndex()-1).shortValue());
        }
        cfLogisticsTaskLogQuery.setTaskLogStatus((byte)2);
        //赋值排队人数
        cfLogisticsTaskLog.setNumberOfPeopleInLine(cfLogisticsTaskLogService.countByQuery(cfLogisticsTaskLogQuery));
        //查询当前用户是否进行预约过该任务
        cfLogisticsTaskLogQuery.setLogisticsPlatformId(null);
        cfLogisticsTaskLogQuery.setMaxQueueIndex(null);
        cfLogisticsTaskLogQuery.setMaxTaskLogStatus((byte)5);
        cfLogisticsTaskLogQuery.setDeliverUid(userBasicInfo.getId());
        Integer reservedCounts = cfLogisticsTaskLogService.countByQuery(cfLogisticsTaskLogQuery);
        if(reservedCounts.intValue()>0){
            cfLogisticsTaskLog.setReserved((byte)1);
        }else{
            cfLogisticsTaskLog.setReserved((byte)0);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsTaskLog);

    }

    @Override
    @RequestMapping(value = "reserveTask", method = RequestMethod.POST)
    public ResponseResult reserveTask(@RequestBody ReserveParams reserveParams) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.reserveTask(userBasicInfo.getId(), reserveParams.getTaskId(), reserveParams.getNumberPlate(), reserveParams.getDeliveryNoteCode(), reserveParams.getDeliveryNoteImage());
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsTaskLog);
    }

    @Override
    @RequestMapping(value = "reserveSignIn", method = RequestMethod.PUT)
    public ResponseResult reserveSignIn(@RequestBody ReserveParams reserveParams) throws Exception {
        if(reserveParams.getPositionX()==null || reserveParams.getPositionY()==null){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供经纬度");
        }
        CfLogisticsFactoryQuery cfLogisticsFactoryQuery = new CfLogisticsFactoryQuery();
        cfLogisticsFactoryQuery.setPositionX(reserveParams.getPositionX());
        cfLogisticsFactoryQuery.setPositionY(reserveParams.getPositionY());
        List<CfLogisticsFactory> cfLogisticsFactoryList = cfLogisticsFactoryService.selectNearLogisticsFactory(cfLogisticsFactoryQuery);
        if(cfLogisticsFactoryList==null || cfLogisticsFactoryList.size()==0){
            return new ResponseResult(CommonCode.FAIL, null, "附近暂时无可签到点");
        }
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfLogisticsTaskLogService.reserveSignIn(userBasicInfo.getId(), reserveParams.getTaskLogId());
        return new ResponseResult(CommonCode.SUCCESS, null, "签到成功，请及时车辆入场按指导前往排队区");
    }

    @Override
    @RequestMapping(value = "cancelAppointment", method = RequestMethod.GET)
    public ResponseResult cancelAppointment(Long taskLogId) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.findById(taskLogId, false);
        if(!cfLogisticsTaskLog.getDeliverUid().equals(userBasicInfo.getId())){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null, "该预约数据不属于您");
        }
        if(cfLogisticsTaskLog.getTaskLogStatus().byteValue()>=(byte)2){
            return new ResponseResult(CommonCode.FAIL,null,"您不能操作取消排队操作，请联系管理员协助");
        }
        CfLogisticsTaskLog logisticsTaskLog = cfLogisticsTaskLogService.cancelAppointment(cfLogisticsTaskLog);
        return new ResponseResult(CommonCode.SUCCESS, logisticsTaskLog);
    }
}
