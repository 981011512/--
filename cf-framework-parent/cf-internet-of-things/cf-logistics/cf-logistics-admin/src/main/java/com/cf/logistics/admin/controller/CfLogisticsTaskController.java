package com.cf.logistics.admin.controller;

import com.cf.framework.domain.logistics.LogisticsCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.BCryptUtil;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.logistics.admin.config.AuthenticationInterceptor;
import com.cf.logistics.admin.swagger.CfLogisticsTaskSwagger;
import com.cf.logistics.domain.*;
import com.cf.logistics.domain.request.*;
import com.cf.logistics.service.*;
import com.cf.ucenter.domain.CfSystemConfig;
import com.cf.ucenter.domain.CfThirdPartySystemCallKeys;
import com.cf.ucenter.request.CfSystemConfigQuery;
import com.cf.ucenter.request.CfWxUserForm;
import com.cf.ucenter.service.CfThirdPartySystemCallKeysService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("LogisticsTaskAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsTaskController implements CfLogisticsTaskSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfLogisticsTaskService cfLogisticsTaskService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfLogisticsStorehouseLinkUserService cfLogisticsStorehouseLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfThirdPartySystemCallKeysService cfThirdPartySystemCallKeysService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfLogisticsStorehouseService cfLogisticsStorehouseService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfLogisticsFactoryService cfLogisticsFactoryService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfLogisticsStorehousePlatformCargoTypeService cfLogisticsStorehousePlatformCargoTypeService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "thirdPartyPaskPush", method = RequestMethod.POST)
    public ResponseResult thirdPartyPaskPush(@Validated @RequestBody CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception {
        if(StringUtils.isEmpty(cfLogisticsTaskForm.getSignType()) || StringUtils.isEmpty(cfLogisticsTaskForm.getSign()) || cfLogisticsTaskForm.getKeyId()==null){
            return new ResponseResult(CommonCode.INVALID_PARAM, null ,"keyId/signType/sign 这三个字段都要提供");
        }

        //判断物流单号是否有重复
        if(StringUtils.isNotEmpty(cfLogisticsTaskForm.getWaybillNumber())){
            CfLogisticsTaskQuery cfLogisticsTaskQuery = new CfLogisticsTaskQuery();
            cfLogisticsTaskQuery.setWaybillNumber(cfLogisticsTaskForm.getWaybillNumber());
            List<CfLogisticsTask> cfLogisticsTaskList = cfLogisticsTaskService.getListByQuery(cfLogisticsTaskQuery);
            if(cfLogisticsTaskList!=null && cfLogisticsTaskList.size()>0){
                return new ResponseResult(CommonCode.DUPLICATE_DATA, null,"指定的运单已存在");
            }
        }

        //校验签名是否正常
        checkSign(cfLogisticsTaskForm);

        //判断指定工厂是否存在
        CfLogisticsFactory cfLogisticsFactory = null;
        if(StringUtils.isNotEmpty(cfLogisticsTaskForm.getFactory())){
            CfLogisticsFactoryQuery cfLogisticsFactoryQuery = new CfLogisticsFactoryQuery();
            cfLogisticsFactoryQuery.setFactoryName(cfLogisticsTaskForm.getLogisticsStorehouseName());
            List<CfLogisticsFactory> cfLogisticsFactoryList = cfLogisticsFactoryService.getListByQuery(cfLogisticsFactoryQuery);
            if(cfLogisticsFactoryList!=null && cfLogisticsFactoryList.size()>0){
                cfLogisticsFactory = cfLogisticsFactoryList.get(0);
            }
        }else{
            cfLogisticsFactory = cfLogisticsFactoryService.findById(cfLogisticsTaskForm.getFactoryId());
        }
        if(cfLogisticsFactory==null){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null,"指定的工厂不存在");
        }

        CfLogisticsTask cfLogisticsTask = new CfLogisticsTask();
        BeanUtils.copyProperties(cfLogisticsTaskForm,cfLogisticsTask);
        cfLogisticsTask.setEditerUid("");
        cfLogisticsTask.setFactoryId(cfLogisticsFactory.getId());
        CfLogisticsTask lastCfLogisticsTask = cfLogisticsTaskService.add(cfLogisticsTask);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsTask);
    }

    @Override
    @RequestMapping(value = "thirdPartyPaskUpdate", method = RequestMethod.PUT)
    public ResponseResult thirdPartyPaskUpdate(@Validated @RequestBody CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception {
        if(StringUtils.isEmpty(cfLogisticsTaskForm.getSignType()) || StringUtils.isEmpty(cfLogisticsTaskForm.getSign()) || cfLogisticsTaskForm.getKeyId()==null){
            return new ResponseResult(CommonCode.INVALID_PARAM, null ,"keyId/signType/sign 这三个字段都要提供");
        }

        //校验签名是否正常
        checkSign(cfLogisticsTaskForm);

        //判断指定工厂是否存在
        CfLogisticsFactory cfLogisticsFactory = null;
        if(StringUtils.isNotEmpty(cfLogisticsTaskForm.getFactory())){
            CfLogisticsFactoryQuery cfLogisticsFactoryQuery = new CfLogisticsFactoryQuery();
            cfLogisticsFactoryQuery.setFactoryName(cfLogisticsTaskForm.getLogisticsStorehouseName());
            List<CfLogisticsFactory> cfLogisticsFactoryList = cfLogisticsFactoryService.getListByQuery(cfLogisticsFactoryQuery);
            if(cfLogisticsFactoryList!=null && cfLogisticsFactoryList.size()>0){
                cfLogisticsFactory = cfLogisticsFactoryList.get(0);
            }
        }else{
            cfLogisticsFactory = cfLogisticsFactoryService.findById(cfLogisticsTaskForm.getFactoryId());
        }
        if(cfLogisticsFactory==null){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null,"指定的工厂不存在");
        }

        CfLogisticsTask cfLogisticsTask = new CfLogisticsTask();
        BeanUtils.copyProperties(cfLogisticsTaskForm,cfLogisticsTask);
        cfLogisticsTask.setEditerUid("");
        cfLogisticsTask.setFactoryId(cfLogisticsFactory.getId());
        CfLogisticsTask lastCfLogisticsTask = cfLogisticsTaskService.update(cfLogisticsTask);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsTask);
    }

    @Override
    @RequestMapping(value = "thirdPartyPaskDelete", method = RequestMethod.DELETE)
    public ResponseResult thirdPartyPaskDelete(@Validated @RequestBody CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception {
        if(StringUtils.isEmpty(cfLogisticsTaskForm.getSignType()) || StringUtils.isEmpty(cfLogisticsTaskForm.getSign()) || cfLogisticsTaskForm.getKeyId()==null){
            return new ResponseResult(CommonCode.INVALID_PARAM, null ,"keyId/signType/sign 这三个字段都要提供");
        }

        //校验签名是否正常
        checkSign(cfLogisticsTaskForm);
        Integer delete = cfLogisticsTaskService.delete(cfLogisticsTaskForm.getId());
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception {
        //检查是否有权限进行该操作
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
//        if(cfLogisticsTaskForm.getLogisticsStorehouseId()==null){
//            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供仓库id");
//        }
//        checkLinkerUser(userBasicInfo, cfLogisticsTaskForm.getLogisticsStorehouseId());

        CfLogisticsTask cfLogisticsTask = new CfLogisticsTask();
        BeanUtils.copyProperties(cfLogisticsTaskForm,cfLogisticsTask);
        cfLogisticsTask.setEditerUid(userBasicInfo.getId());
        if(cfLogisticsTask.getCargoType()==null){
            return new ResponseResult(CommonCode.INVALID_PARAM,null, "请提供货物类型");
        }
        CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery = new CfLogisticsStorehousePlatformCargoTypeQuery();
        cfLogisticsStorehousePlatformCargoTypeQuery.setFactoryId(cfLogisticsTaskForm.getFactoryId());
        cfLogisticsStorehousePlatformCargoTypeQuery.setCargoType(cfLogisticsTaskForm.getCargoType());
        List<CfLogisticsStorehousePlatformCargoType> cfLogisticsStorehousePlatformCargoTypes = cfLogisticsStorehousePlatformCargoTypeService.getListByQuery(cfLogisticsStorehousePlatformCargoTypeQuery);
        if(cfLogisticsStorehousePlatformCargoTypes==null || cfLogisticsStorehousePlatformCargoTypes.size()==0){
            return new ResponseResult(LogisticsCode.CARGO_TYPE_NOF_FOUND,null);
        }
        CfLogisticsTask lastCfLogisticsTask = cfLogisticsTaskService.add(cfLogisticsTask);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsTask);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception {
        //检查是否有权限进行该操作
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(cfLogisticsTaskForm.getId()==null){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供任务id");
        }
//        CfLogisticsTask logisticsTask = cfLogisticsTaskService.findById(cfLogisticsTaskForm.getId(), false);
//        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = checkLinkerUser(userBasicInfo, logisticsTask.getLogisticsStorehouseId());
//        if(cfLogisticsStorehouseLinkUsers!=null && !logisticsTask.getEditerUid().equals(userBasicInfo.getId())){
//            return new ResponseResult(CommonCode.UNAUTHORISE, null, "该任务不属于您");
//        }

        CfLogisticsTask cfLogisticsTask = new CfLogisticsTask();
        BeanUtils.copyProperties(cfLogisticsTaskForm,cfLogisticsTask);
        if(cfLogisticsTask.getCargoType()!=null){
            CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery = new CfLogisticsStorehousePlatformCargoTypeQuery();
            cfLogisticsStorehousePlatformCargoTypeQuery.setFactoryId(cfLogisticsTaskForm.getFactoryId());
            cfLogisticsStorehousePlatformCargoTypeQuery.setCargoType(cfLogisticsTaskForm.getCargoType());
            List<CfLogisticsStorehousePlatformCargoType> cfLogisticsStorehousePlatformCargoTypes = cfLogisticsStorehousePlatformCargoTypeService.getListByQuery(cfLogisticsStorehousePlatformCargoTypeQuery);
            if(cfLogisticsStorehousePlatformCargoTypes==null || cfLogisticsStorehousePlatformCargoTypes.size()==0){
                return new ResponseResult(LogisticsCode.CARGO_TYPE_NOF_FOUND,null);
            }
        }
        CfLogisticsTask update = cfLogisticsTaskService.update(cfLogisticsTask);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) throws Exception {
        //检查是否有权限进行该操作
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(id==null){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供任务id");
        }
//        CfLogisticsTask logisticsTask = cfLogisticsTaskService.findById(id, false);
//        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = checkLinkerUser(userBasicInfo, logisticsTask.getLogisticsStorehouseId());
//        if(cfLogisticsStorehouseLinkUsers!=null && !logisticsTask.getEditerUid().equals(userBasicInfo.getId())){
//            return new ResponseResult(CommonCode.UNAUTHORISE, null, "该任务不属于您");
//        }

        Integer delete = cfLogisticsTaskService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskController-selectListByQuery')")
    @Override
    @RequestMapping(value = "selectListByQuery", method = RequestMethod.GET)
    public ResponseResult selectListByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery) throws Exception {

        //检查是否有权限进行该操作
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
//        List<CfLogisticsStorehouseLinkUser> cfLogisticsStorehouseLinkUsers = checkLinkerUser(userBasicInfo, null);
//
//        if(cfLogisticsStorehouseLinkUsers!=null){
//            List<Long> logisticsStorehouseIds = new ArrayList<>();
//            for(CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser: cfLogisticsStorehouseLinkUsers){
//                logisticsStorehouseIds.add(cfLogisticsStorehouseLinkUser.getLogisticsStorehouseId());
//            }
//            cfLogisticsTaskQuery.setLogisticsStorehouseIds(logisticsStorehouseIds);
//        }

        List<CfLogisticsTask> cfLogisticsTasks = cfLogisticsTaskService.selectListByQuery(cfLogisticsTaskQuery);
        Integer countByQuery = cfLogisticsTaskService.countByQuery(cfLogisticsTaskQuery);
        if(cfLogisticsTasks==null || cfLogisticsTasks.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsTasks, countByQuery);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsTaskController-changeSortIndex')")
    @Override
    @RequestMapping(value = "changeSortIndex", method = RequestMethod.PUT)
    public ResponseResult changeSortIndex(Long taskId, Integer sortIndex) throws Exception {
        cfLogisticsTaskService.changeSortIndex(taskId, sortIndex);
        return new ResponseResult(CommonCode.SUCCESS, null);
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

    private void checkSign(CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception {
        CfThirdPartySystemCallKeys cfThirdPartySystemCallKeys = cfThirdPartySystemCallKeysService.findById(cfLogisticsTaskForm.getKeyId());
        if(cfThirdPartySystemCallKeys==null || cfThirdPartySystemCallKeys.getStartTime()>System.currentTimeMillis() || cfThirdPartySystemCallKeys.getEndTime()<System.currentTimeMillis() || !cfThirdPartySystemCallKeys.getUseScenes().equals("LogisticsTask")){
            ExceptionCast.cast(UcenterCode.INVALID_CALL_KEY);
        }
        Map<String,String> params = new HashMap<>();
        Class cls = cfLogisticsTaskForm.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            Field f = fields[i];
            f.setAccessible(true);
            if(f.getName()!=null && !f.getName().equals("serialVersionUID") && !f.getName().equals("sign") && f.get(cfLogisticsTaskForm)!=null && StringUtils.isNotEmpty(f.get(cfLogisticsTaskForm).toString())){
                params.put(f.getName(), f.get(cfLogisticsTaskForm).toString());
            }
        }
        params.put("sign", cfLogisticsTaskForm.getSign());
        boolean signatureValid = BCryptUtil.isSignatureValid(params, cfThirdPartySystemCallKeys.getKeyValue(), cfLogisticsTaskForm.getSignType());
        if(!signatureValid){
            throw new Exception("invalid sign");
        }
    }
}
