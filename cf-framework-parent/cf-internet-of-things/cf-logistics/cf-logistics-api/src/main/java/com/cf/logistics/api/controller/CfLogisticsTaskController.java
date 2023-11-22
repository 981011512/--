package com.cf.logistics.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.logistics.api.config.AuthenticationInterceptor;
import com.cf.logistics.api.swagger.CfLogisticsTaskSwagger;
import com.cf.logistics.domain.*;
import com.cf.logistics.domain.request.CfLogisticsStorehouseLinkUserQuery;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformCargoTypeQuery;
import com.cf.logistics.domain.request.CfLogisticsTaskForm;
import com.cf.logistics.domain.request.CfLogisticsTaskQuery;
import com.cf.logistics.service.*;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserDriverLicense;
import com.cf.ucenter.request.CfUserDriverLicenseQuery;
import com.cf.ucenter.service.CfUserDriverLicenseService;
import com.cf.ucenter.service.CfUserService;
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
@RequestMapping("LogisticsTask/")
@Validated
@CrossOrigin
public class CfLogisticsTaskController implements CfLogisticsTaskSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsTaskService cfLogisticsTaskService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsTaskLogService cfLogisticsTaskLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsStorehouseLinkUserService cfLogisticsStorehouseLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsStorehousePlatformCargoTypeService cfLogisticsStorehousePlatformCargoTypeService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsFactoryService cfLogisticsFactoryService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserDriverLicenseService cfUserDriverLicenseService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "selectListByQuery", method = RequestMethod.GET)
    public ResponseResult selectListByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        //检查用户合法性
        CfUser cfUser = cfUserService.getUserByUid(userBasicInfo.getId(), false);
        if(cfUser.getDriverLicenseStatus().byteValue()!=( byte)2){
            return new ResponseResult(CommonCode.FAIL,null, "您的驾驶证未上传或者未通过审核，请联系管理员处理");
        }
        List<CfLogisticsTask> cfLogisticsTasks = cfLogisticsTaskService.selectListByQuery(cfLogisticsTaskQuery);
        if(cfLogisticsTaskQuery.getPage()==null || cfLogisticsTaskQuery.getSize()==null){
            return new ResponseResult(CommonCode.NO_MORE_DATAS,null, "请提供页码和每次请求数量");
        }
        if(cfLogisticsTaskQuery.getPage()>5 || cfLogisticsTaskQuery.getSize()>20){
            return new ResponseResult(CommonCode.NO_MORE_DATAS,null, "您请求的数据量已经超限");
        }
        Integer countByQuery = cfLogisticsTaskService.countByQuery(cfLogisticsTaskQuery);
        if(cfLogisticsTasks==null || cfLogisticsTasks.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsTasks, countByQuery);
    }

    @Override
    @RequestMapping(value = "driverCreateTask", method = RequestMethod.POST)
    public ResponseResult driverCreateTask(@RequestBody CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringUtils.isEmpty(cfLogisticsTaskForm.getVehicleName())){
            return new ResponseResult(CommonCode.FAIL,null, "请您提供车牌号");
        }
        //检查用户合法性
        CfUser cfUser = cfUserService.getUserByUid(userBasicInfo.getId(), false);
        if(StringUtils.isEmpty(cfUser.getTrueName())){
            CfUser updateUser = new CfUser();
            updateUser.setId(userBasicInfo.getId());
            updateUser.setTrueName(cfUser.getPhone());
            cfUser.setTrueName(cfUser.getPhone());
            cfUserService.updateByPrimaryKeySelective(updateUser);
            CfUserDriverLicense cfUserDriverLicense = new CfUserDriverLicense();
            cfUserDriverLicense.setUserName(cfUser.getTrueName());
            CfUserDriverLicenseQuery cfUserDriverLicenseQuery = new CfUserDriverLicenseQuery();
            cfUserDriverLicenseQuery.setUid(userBasicInfo.getId());
            cfUserDriverLicenseService.updateByQUery(cfUserDriverLicense, cfUserDriverLicenseQuery);
        }
        if(cfUser.getDriverLicenseStatus().byteValue()!=( byte)2){
            return new ResponseResult(CommonCode.FAIL,null, "您的驾驶证未上传或者未通过审核，请联系管理员处理");
        }
        if(cfLogisticsTaskForm.getFactoryId()==null){
            return new ResponseResult(CommonCode.FAIL,null, "请提仓库(id)");
        }
        CfLogisticsFactory cfLogisticsFactory = cfLogisticsFactoryService.findById(cfLogisticsTaskForm.getFactoryId());
        if(cfLogisticsFactory==null){
            return new ResponseResult(CommonCode.FAIL,null, "指定的工厂不存在");
        }
        if(StringUtils.isEmpty(cfLogisticsTaskForm.getCargoType())){
            return new ResponseResult(CommonCode.FAIL,null, "请提供货物类型");
        }
        CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery = new CfLogisticsStorehousePlatformCargoTypeQuery();
        cfLogisticsStorehousePlatformCargoTypeQuery.setFactoryId(cfLogisticsTaskForm.getFactoryId());
        cfLogisticsStorehousePlatformCargoTypeQuery.setCargoType(cfLogisticsTaskForm.getCargoType());
        List<CfLogisticsStorehousePlatformCargoType> cfLogisticsStorehousePlatformCargoTypes = cfLogisticsStorehousePlatformCargoTypeService.getListByQuery(cfLogisticsStorehousePlatformCargoTypeQuery);
        if(cfLogisticsStorehousePlatformCargoTypes==null || cfLogisticsStorehousePlatformCargoTypes.size()==0){
            return new ResponseResult(CommonCode.FAIL,null, "指定的货物类型不存在");
        }
        if(cfLogisticsTaskForm.getTaskType()==null || (cfLogisticsTaskForm.getTaskType().byteValue()!=(byte)0 && cfLogisticsTaskForm.getTaskType().byteValue()!=(byte)1)){
            return new ResponseResult(CommonCode.FAIL,null, "请告知您是装货(0)还是卸货(1)");
        }
        if(StringUtils.isEmpty(cfLogisticsTaskForm.getWaybillNumber())){
            return new ResponseResult(CommonCode.FAIL,null, "请您提供物流单号");
        }

        CfLogisticsTask cfLogisticsTask = new CfLogisticsTask();
        cfLogisticsTask.setTaskTitle( cfUser.getTrueName()+"-"+cfLogisticsTaskForm.getCargoType()+"-"+ DateUtil.stampToDate(System.currentTimeMillis(),"yyyy-MM-dd") );
        cfLogisticsTask.setEditerUid(userBasicInfo.getId());
        cfLogisticsTask.setStartTime(System.currentTimeMillis());
        cfLogisticsTask.setEndTime(cfLogisticsTask.getStartTime()+86400000l);
        cfLogisticsTask.setOrigin(cfLogisticsTaskForm.getOrigin());
        cfLogisticsTask.setDestination(cfLogisticsTaskForm.getDestination());
        cfLogisticsTask.setCargoType(cfLogisticsTaskForm.getCargoType());
        cfLogisticsTask.setCarType(cfLogisticsTaskForm.getCarType());
        cfLogisticsTask.setVehiclesRequired((short)1);
        cfLogisticsTask.setVehiclesRequired((short)0);
        cfLogisticsTask.setResEach(cfLogisticsTaskForm.getResEach());
        cfLogisticsTask.setWeight(cfLogisticsTaskForm.getWeight());
        cfLogisticsTask.setTaskStatus((byte)0);
        cfLogisticsTask.setTaskType(cfLogisticsTaskForm.getTaskType());
        cfLogisticsTask.setFactoryId(cfLogisticsTaskForm.getFactoryId());
        cfLogisticsTask.setSupplier(cfLogisticsTaskForm.getSupplier());
        cfLogisticsTask.setWaybillNumber(cfLogisticsTaskForm.getWaybillNumber());
        cfLogisticsTask.setEmergencyLevel((byte)0);

        //让其能自动预约
        cfLogisticsTask.setDriverName(cfUser.getTrueName());
        cfLogisticsTask.setDriverTel(cfUser.getPhone());
        cfLogisticsTask.setVehicleName(cfLogisticsTaskForm.getVehicleName());

        CfLogisticsTask logisticsTask = cfLogisticsTaskService.add(cfLogisticsTask);
        return new ResponseResult(CommonCode.SUCCESS,logisticsTask);
    }
}
