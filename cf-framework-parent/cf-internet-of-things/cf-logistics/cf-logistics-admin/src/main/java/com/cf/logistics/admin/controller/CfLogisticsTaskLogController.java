package com.cf.logistics.admin.controller;

import com.cf.framework.domain.logistics.LogisticsCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.logistics.admin.config.AuthenticationInterceptor;
import com.cf.logistics.admin.swagger.CfLogisticsTaskLogSwagger;
import com.cf.logistics.domain.CfLogisticsStorehouseLinkUser;
import com.cf.logistics.domain.CfLogisticsTask;
import com.cf.logistics.domain.CfLogisticsTaskLog;
import com.cf.logistics.domain.request.CfLogisticsStorehouseLinkUserQuery;
import com.cf.logistics.domain.request.CfLogisticsTaskLogForm;
import com.cf.logistics.domain.request.CfLogisticsTaskLogQuery;
import com.cf.logistics.domain.request.ReserveParams;
import com.cf.logistics.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("LogisticsTaskLogAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsTaskLogController implements CfLogisticsTaskLogSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsTaskLogService cfLogisticsTaskLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsTaskService cfLogisticsTaskService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsStorehouseLinkUserService cfLogisticsStorehouseLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsStorehouseService cfLogisticsStorehouseService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsStorehousePlatformService cfLogisticsStorehousePlatformService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsTaskLogForm cfLogisticsTaskLogForm) throws Exception {
        //检查是否有权限进行该操作
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
//        if(cfLogisticsTaskLogForm.getLogisticsStorehouseId()==null){
//            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供仓库id");
//        }
//        checkLinkerUser(userBasicInfo, cfLogisticsTaskLogForm.getLogisticsStorehouseId());

        CfLogisticsTaskLog cfLogisticsTaskLog = new CfLogisticsTaskLog();
        BeanUtils.copyProperties(cfLogisticsTaskLogForm,cfLogisticsTaskLog);
        CfLogisticsTaskLog lastCfLogisticsTaskLog = cfLogisticsTaskLogService.add(cfLogisticsTaskLog);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsTaskLog);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsTaskLogForm cfLogisticsTaskLogForm) throws Exception {
        //检查是否有权限进行该操作
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
//        if(cfLogisticsTaskLogForm.getLogisticsStorehouseId()==null){
//            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供仓库id");
//        }
//        //非超级管理员不能操作非自己名下仓库任务的的预约记录
//        CfLogisticsTaskLog logisticsTaskLog = cfLogisticsTaskLogService.findById(cfLogisticsTaskLogForm.getId(), false);
//        CfLogisticsTask logisticsTask = cfLogisticsTaskService.findById(logisticsTaskLog.getTaskId(), false);
//        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = checkLinkerUser(userBasicInfo, logisticsTask.getLogisticsStorehouseId());
//        if(cfLogisticsStorehouseLinkUsers!=null && !logisticsTask.getEditerUid().equals(userBasicInfo.getId())){
//            return new ResponseResult(CommonCode.UNAUTHORISE, null, "该任务不属于您");
//        }

        CfLogisticsTaskLog cfLogisticsTaskLog = new CfLogisticsTaskLog();
        BeanUtils.copyProperties(cfLogisticsTaskLogForm,cfLogisticsTaskLog);
        cfLogisticsTaskLogService.update(cfLogisticsTaskLog);
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsTaskLog);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) throws Exception {
        //检查是否有权限进行该操作
//        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(id==null){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提预约id");
        }
//        //非超级管理员不能操作非自己名下仓库任务的的预约记录
//        CfLogisticsTaskLog logisticsTaskLog = cfLogisticsTaskLogService.findById(id, false);
//        CfLogisticsTask logisticsTask = cfLogisticsTaskService.findById(logisticsTaskLog.getTaskId(), false);
//        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = checkLinkerUser(userBasicInfo, logisticsTask.getLogisticsStorehouseId());
//        if(cfLogisticsStorehouseLinkUsers!=null && !logisticsTask.getEditerUid().equals(userBasicInfo.getId())){
//            return new ResponseResult(CommonCode.UNAUTHORISE, null, "该任务不属于您");
//        }

        Integer delete = cfLogisticsTaskLogService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-selectListByQuery')")
    @Override
    @RequestMapping(value = "selectListByQuery", method = RequestMethod.GET)
    public ResponseResult selectListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) throws Exception {

        //检查是否有权限进行该操作
//        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
//        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = checkLinkerUser(userBasicInfo, null);
//        if(cfLogisticsStorehouseLinkUsers!=null){
//            List<Long> logisticsStorehouseIds = new ArrayList<>();
//            for(CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser: cfLogisticsStorehouseLinkUsers){
//                logisticsStorehouseIds.add(cfLogisticsStorehouseLinkUser.getLogisticsStorehouseId());
//            }
//            cfLogisticsTaskLogQuery.setLogisticsStorehouseIds(logisticsStorehouseIds);
//        }
        List<CfLogisticsTaskLog> cfLogisticsTaskLogs = cfLogisticsTaskLogService.selectListByQuery(cfLogisticsTaskLogQuery);
        Integer countByQuery = cfLogisticsTaskLogService.countByQuery(cfLogisticsTaskLogQuery);
        if(cfLogisticsTaskLogs==null || cfLogisticsTaskLogs.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsTaskLogs, countByQuery);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-selectDeliverListByQuery')")
    @Override
    @RequestMapping(value = "selectDeliverListByQuery", method = RequestMethod.GET)
    public ResponseResult selectDeliverListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) throws Exception {
        //检查是否有权限进行该操作
//        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
//        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = checkLinkerUser(userBasicInfo, null);
//        if(cfLogisticsStorehouseLinkUsers!=null){
//            List<Long> logisticsStorehouseIds = new ArrayList<>();
//            for(CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser: cfLogisticsStorehouseLinkUsers){
//                logisticsStorehouseIds.add(cfLogisticsStorehouseLinkUser.getLogisticsStorehouseId());
//            }
//            cfLogisticsTaskLogQuery.setLogisticsStorehouseIds(logisticsStorehouseIds);
//        }
        List<CfLogisticsTaskLog> cfLogisticsTaskLogs = cfLogisticsTaskLogService.selectDeliverListByQuery(cfLogisticsTaskLogQuery);
        Integer countByQuery = cfLogisticsTaskLogService.countByQuery(cfLogisticsTaskLogQuery);
        if(cfLogisticsTaskLogs==null || cfLogisticsTaskLogs.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsTaskLogs, countByQuery);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-helpOthersMakeAnAppointment')")
    @Override
    @RequestMapping(value = "helpOthersMakeAnAppointment", method = RequestMethod.POST)
    public ResponseResult helpOthersMakeAnAppointment(@RequestBody CfLogisticsTaskLogForm cfLogisticsTaskLogForm) throws Exception {
        //检查是否有权限进行该操作
//        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(cfLogisticsTaskLogForm.getTaskId()==null){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提任务id");
        }
        //非超级管理员不能操作非自己名下仓库任务的的预约记录
//        CfLogisticsTask logisticsTask = cfLogisticsTaskService.findById(cfLogisticsTaskLogForm.getTaskId(), false);
//        checkLinkerUser(userBasicInfo, logisticsTask.getLogisticsStorehouseId());

        if(StringUtils.isEmpty(cfLogisticsTaskLogForm.getDeliverUid())){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供司机id");
        }
//        checkLinkerUser(userBasicInfo, cfLogisticsTaskLogForm.getLogisticsStorehouseId());

        //检查对应司机有没有认证个人消息
        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.reserveTask(cfLogisticsTaskLogForm.getDeliverUid(), cfLogisticsTaskLogForm.getTaskId(),
                cfLogisticsTaskLogForm.getNumberPlate(), cfLogisticsTaskLogForm.getDeliveryNoteCode(), cfLogisticsTaskLogForm.getDeliveryNoteImage());
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsTaskLog);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-cancelAppointment')")
    @Override
    @RequestMapping(value = "cancelAppointment", method = RequestMethod.GET)
    public ResponseResult cancelAppointment(Long taskLogId) throws Exception {
        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.findById(taskLogId, false);
        if(cfLogisticsTaskLog.getTaskLogStatus().byteValue()>=(byte)3){
            return new ResponseResult(CommonCode.FAIL,null,"当前未处在已预约或排队中状态");
        }
        CfLogisticsTaskLog logisticsTaskLog = cfLogisticsTaskLogService.cancelAppointment(cfLogisticsTaskLog);
        return new ResponseResult(CommonCode.SUCCESS, logisticsTaskLog);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-taskUseLogChangeDriver')")
    @Override
    @RequestMapping(value = "taskUseLogChangeDriver", method = RequestMethod.PUT)
    public ResponseResult taskUseLogChangeDriver(@RequestBody ReserveParams reserveParams) throws Exception {
        if(StringUtils.isEmpty(reserveParams.getUid())){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供司机id");
        }
        if(reserveParams.getTaskLogId()==null){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提任务预约id");
        }

        //检查是否有权限进行该操作
//        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        //非超级管理员不能操作非自己名下仓库任务的的预约记录
        CfLogisticsTaskLog logisticsTaskLog = cfLogisticsTaskLogService.findById(reserveParams.getTaskLogId(), false);
        if(logisticsTaskLog.getDeliverUid().equals(reserveParams.getUid())){
            return new ResponseResult(CommonCode.FAIL, null, "相同用户");
        }
//        CfLogisticsTask logisticsTask = cfLogisticsTaskService.findById(logisticsTaskLog.getTaskId(), false);
//        checkLinkerUser(userBasicInfo, logisticsTask.getLogisticsStorehouseId());
        cfLogisticsTaskLogService.checkUserDocumentsStatus(reserveParams.getUid());
        //判断当前用户是否有重复预约
        CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        cfLogisticsTaskLogQuery.setDeliverUid(reserveParams.getUid());
        cfLogisticsTaskLogQuery.setTaskId(logisticsTaskLog.getTaskId());
        Integer countByQuery = cfLogisticsTaskLogService.countByQuery(cfLogisticsTaskLogQuery);
        if(countByQuery.intValue()>0){
            ExceptionCast.cast(LogisticsCode.REPEAT_APPOINTMENT);
        }
        CfLogisticsTaskLog cfLogisticsTaskLog = new CfLogisticsTaskLog();
        cfLogisticsTaskLog.setId(reserveParams.getTaskLogId());
        cfLogisticsTaskLog.setDeliverUid(reserveParams.getUid());
        if(StringUtils.isNotEmpty(reserveParams.getNumberPlate())){
            cfLogisticsTaskLog.setNumberPlate(reserveParams.getNumberPlate());
        }
        cfLogisticsTaskLogService.update(cfLogisticsTaskLog);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-getUserIdentityInformaiton')")
    @Override
    @RequestMapping(value = "getUserIdentityInformaiton", method = RequestMethod.GET)
    public ResponseResult getUserIdentityInformaiton(Long taskLogId) throws Exception {
        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.findById(taskLogId, false);
        //检查是否有权限进行该操作
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        checkLinkerUser(userBasicInfo, cfLogisticsTaskLog.getLogisticsStorehouseId());

        Map<String, Object> userDocuments = cfLogisticsTaskLogService.checkUserDocumentsStatus(cfLogisticsTaskLog.getDeliverUid());
        FileUtils.handleFileSourcePrefix(userDocuments.get("UserDriverLicense"),"","images");
        FileUtils.handleFileSourcePrefix(userDocuments.get("UserIdCard"),"","images");
        return new ResponseResult(CommonCode.SUCCESS, userDocuments);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-getLogInfoAndUserIdentityInformaiton')")
    @Override
    @RequestMapping(value = "getLogInfoAndUserIdentityInformaiton", method = RequestMethod.GET)
    public ResponseResult getLogInfoAndUserIdentityInformaiton(Long taskLogId) throws Exception {

        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.findById(taskLogId, false);
        //检查是否有权限进行该操作
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        checkLinkerUser(userBasicInfo, cfLogisticsTaskLog.getLogisticsStorehouseId());

        //查询仓库
        cfLogisticsTaskLog.setCfLogisticsStorehouse(cfLogisticsStorehouseService.findById(cfLogisticsTaskLog.getLogisticsStorehouseId(),false));
        //查询月台
        cfLogisticsTaskLog.setCfLogisticsStorehousePlatform(cfLogisticsStorehousePlatformService.findById(cfLogisticsTaskLog.getLogisticsPlatformId(),false));

        Map<String, Object> userDocuments = cfLogisticsTaskLogService.checkUserDocumentsStatus(cfLogisticsTaskLog.getDeliverUid());
        FileUtils.handleFileSourcePrefix(userDocuments.get("UserDriverLicense"),"","images");
        FileUtils.handleFileSourcePrefix(userDocuments.get("UserIdCard"),"","images");
        userDocuments.put("cfLogisticsTaskLog",cfLogisticsTaskLog);

        return new ResponseResult(CommonCode.SUCCESS,userDocuments);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-cargoCheck')")
    @Override
    @RequestMapping(value = "cargoCheck", method = RequestMethod.GET)
    public ResponseResult cargoCheck(Long taskLogId) throws Exception {

        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.findById(taskLogId, false);
        //检查是否有权限进行该操作
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
//        checkLinkerUser(userBasicInfo, cfLogisticsTaskLog.getLogisticsStorehouseId());
        if(cfLogisticsTaskLog.getTaskLogStatus().byteValue()==(byte)0 || cfLogisticsTaskLog.getTaskLogStatus().byteValue()==(byte)5){
            return new ResponseResult(LogisticsCode.NOT_IN_LINE);
        }
        cfLogisticsTaskLog.setCheckerUid(userBasicInfo.getId());
        cfLogisticsTaskLogService.cargoCheck(cfLogisticsTaskLog);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-confirmVehicleStorage')")
    @Override
    @RequestMapping(value = "confirmVehicleStorage", method = RequestMethod.GET)
    public ResponseResult confirmVehicleStorage(Long taskLogId) throws Exception {
        CfLogisticsTaskLog cfLogisticsTaskLog = new CfLogisticsTaskLog();
        cfLogisticsTaskLog.setId(taskLogId);
        cfLogisticsTaskLog.setTaskLogStatus((byte)3);
        Integer update = cfLogisticsTaskLogService.update(cfLogisticsTaskLog);
        return update>0 ? new ResponseResult(CommonCode.SUCCESS) : new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-checkUserDocumentsStatusByPhone')")
    @Override
    @RequestMapping(value = "checkUserDocumentsStatusByPhone", method = RequestMethod.GET)
    public ResponseResult checkUserDocumentsStatusByPhone(String phone) throws Exception {
        Map<String, Object> stringObjectMap = cfLogisticsTaskLogService.checkUserDocumentsStatusByPhone(phone);
        return new ResponseResult(CommonCode.SUCCESS,stringObjectMap);
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

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-logisticsTaskLogTop')")
    @Override
    @RequestMapping(value = "logisticsTaskLogTop", method = RequestMethod.GET)
    public ResponseResult logisticsTaskLogTop(Long taskLogId) throws Exception {
        cfLogisticsTaskLogService.logisticsTaskLogTop(taskLogId);
        return new ResponseResult(CommonCode.SUCCESS,null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-numberOver')")
    @Override
    @RequestMapping(value = "numberOver", method = RequestMethod.GET)
    public ResponseResult numberOver(Long taskLogId) throws Exception {
        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.findById(taskLogId, false);
        if(cfLogisticsTaskLog.getTaskLogStatus().byteValue()!=(byte)1 && cfLogisticsTaskLog.getTaskLogStatus().byteValue()!=(byte)2){
            return new ResponseResult(LogisticsCode.NOT_IN_LINE);
        }
        cfLogisticsTaskLogService.numberOver(cfLogisticsTaskLog, true);
        return new ResponseResult(CommonCode.SUCCESS,null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskLogController-changeQueuingArea')")
    @Override
    @RequestMapping(value = "changeQueuingArea", method = RequestMethod.GET)
    public ResponseResult changeQueuingArea(Long taskLogId, Long queuingAreaId) throws Exception {
        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.changeQueuingArea(taskLogId, queuingAreaId);
        return cfLogisticsTaskLog!=null ? new ResponseResult(CommonCode.SUCCESS, cfLogisticsTaskLog) : new ResponseResult(CommonCode.FAIL, null);
    }
}
