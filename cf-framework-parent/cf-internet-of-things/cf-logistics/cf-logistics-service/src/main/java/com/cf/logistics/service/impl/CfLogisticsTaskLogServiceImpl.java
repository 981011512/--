package com.cf.logistics.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfCarParkVisit;
import com.cf.carpark.domain.request.CfCarParkVisitQuery;
import com.cf.carpark.service.CfCarParkService;
import com.cf.carpark.service.CfCarParkVisitService;
import com.cf.chat.service.CfWeiXinSubscribeToNotificationsService;
import com.cf.framework.domain.logistics.LogisticsCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.framework.utils.StringTools;
import com.cf.logistics.dao.mapper.CfLogisticsTaskLogMapper;
import com.cf.logistics.domain.*;
import com.cf.logistics.domain.device.CfLinXinLed;
import com.cf.logistics.domain.device.CfLinXinLedArea;
import com.cf.logistics.domain.device.CfLinXinLedProgram;
import com.cf.logistics.domain.request.*;
import com.cf.logistics.service.*;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserDriverLicense;
import com.cf.ucenter.request.CfUserDriverLicenseQuery;
import com.cf.ucenter.service.CfUserDriverLicenseService;
import com.cf.ucenter.service.CfUserService;
import com.cf.ucenter.type.CfWeiXinSubscribeToNotificationsType;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsTaskLogServiceImpl implements CfLogisticsTaskLogService {

    @Autowired
    private CfLogisticsTaskLogMapper cfLogisticsTaskLogMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfLogisticsTaskService cfLogisticsTaskService;
    @Autowired
    private CfLogisticsStorehousePlatformService cfLogisticsStorehousePlatformService;
    @Autowired
    private CfLogisticsStorehouseService cfLogisticsStorehouseService;
    @Autowired
    private CfLogisticsStorehousePlatformCargoTypeService cfLogisticsStorehousePlatformCargoTypeService;
    @Autowired
    private CfLogisticsQueuingAreaPlatformService cfLogisticsQueuingAreaPlatformService;
    @Autowired
    private CfLogisticsQueuingAreaService cfLogisticsQueuingAreaService;
    @Autowired
    private CfLogisticsFactoryService cfLogisticsFactoryService;
    @Autowired
    private CfLogisticsLedDeviceService cfLogisticsLedDeviceService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeiXinSubscribeToNotificationsService cfWeiXinSubscribeToNotificationsService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserDriverLicenseService cfUserDriverLicenseService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkService cfCarParkService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkVisitService cfCarParkVisitService;

    @Override
    public CfLogisticsTaskLog add(CfLogisticsTaskLog cfLogisticsTaskLog) {
        if(cfLogisticsTaskLog.getId()==null){
            cfLogisticsTaskLog.setId(idWorker.nextLongId());
        }
        cfLogisticsTaskLog.setCreateTime(System.currentTimeMillis());
        if(cfLogisticsTaskLog.getQueueIndex()==null){
            cfLogisticsTaskLog.setQueueIndex((short)20000);
        }
        cfLogisticsTaskLogMapper.insertSelective(cfLogisticsTaskLog);
        return cfLogisticsTaskLog;
    }

    @Override
    public Integer update(CfLogisticsTaskLog cfLogisticsTaskLog) {
        return cfLogisticsTaskLogMapper.updateByPrimaryKeySelective(cfLogisticsTaskLog);
    }

    @Override
    public int updateByQuery(CfLogisticsTaskLog CfLogisticsTaskLog, CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) {
        return cfLogisticsTaskLogMapper.updateByExampleSelective(CfLogisticsTaskLog,getExampleByQuery(cfLogisticsTaskLogQuery));
    }

    @Override
    public int delete(Long id) {
        return cfLogisticsTaskLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) {
        return cfLogisticsTaskLogMapper.deleteByExample(getExampleByQuery(cfLogisticsTaskLogQuery));
    }

    @Override
    public CfLogisticsTaskLog findById(Long id) {
        return cfLogisticsTaskLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsTaskLog findById(Long id, boolean expectEmpty) {
        CfLogisticsTaskLog cfLogisticsTaskLog = findById(id);
        if(expectEmpty && cfLogisticsTaskLog!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsTaskLog==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsTaskLog;
    }

    @Override
    public List<CfLogisticsTaskLog> getListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) {
        return cfLogisticsTaskLogMapper.selectByExample(getExampleByQuery(cfLogisticsTaskLogQuery));
    }

    @Override
    public List<CfLogisticsTaskLog> selectListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) {
        ArrayList<String> allowOrderBy = new ArrayList<>();
        allowOrderBy.add("lgshtslg.queue_index asc");
        allowOrderBy.add("lgshtslg.queue_index desc");
        if(!allowOrderBy.contains(cfLogisticsTaskLogQuery.getOrderBy())){
            cfLogisticsTaskLogQuery.setOrderBy(null);
        }
        return cfLogisticsTaskLogMapper.selectListByQuery(cfLogisticsTaskLogQuery);
    }

    @Override
    public List<CfLogisticsTaskLog> selectDeliverListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) {
        ArrayList<String> allowOrderBy = new ArrayList<>();
        allowOrderBy.add("lgshtslg.queue_index asc");
        allowOrderBy.add("lgshtslg.queue_index desc");
        allowOrderBy.add("lgshtslg.emergency_level asc");
        allowOrderBy.add("lgshtslg.emergency_level desc");
        cfLogisticsTaskLogQuery.setOrderBy(DbUtils.makeAllowOrderBy(allowOrderBy,cfLogisticsTaskLogQuery.getOrderBy()));
        return cfLogisticsTaskLogMapper.selectDeliverListByQuery(cfLogisticsTaskLogQuery);
    }

    @Override
    public Integer countByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) {
        cfLogisticsTaskLogQuery.setPage(null);
        cfLogisticsTaskLogQuery.setOrderBy(null);
        return cfLogisticsTaskLogMapper.countByExample(getExampleByQuery(cfLogisticsTaskLogQuery));
    }

    @Override
    public CfLogisticsTaskLogExample getExampleByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) {
        CfLogisticsTaskLogExample cfLogisticsTaskLogExample = new CfLogisticsTaskLogExample();
        CfLogisticsTaskLogExample.Criteria criteria = cfLogisticsTaskLogExample.createCriteria();

        if(cfLogisticsTaskLogQuery.getIds()!=null && cfLogisticsTaskLogQuery.getIds().size()>0){
            criteria.andIdIn(cfLogisticsTaskLogQuery.getIds());
        }
        if(cfLogisticsTaskLogQuery.getPid()!=null){
            criteria.andPidEqualTo(cfLogisticsTaskLogQuery.getPid());
        }
        if(cfLogisticsTaskLogQuery.getTaskId()!=null){
            criteria.andTaskIdEqualTo(cfLogisticsTaskLogQuery.getTaskId());
        }
        if(cfLogisticsTaskLogQuery.getTaskIds()!=null && cfLogisticsTaskLogQuery.getTaskIds().size()>0){
            criteria.andTaskIdIn(cfLogisticsTaskLogQuery.getTaskIds());
        }
        if(cfLogisticsTaskLogQuery.getDeliverUid()!=null){
            criteria.andDeliverUidEqualTo(cfLogisticsTaskLogQuery.getDeliverUid());
        }
        if(cfLogisticsTaskLogQuery.getCheckerUid()!=null){
            criteria.andCheckerUidEqualTo(cfLogisticsTaskLogQuery.getCheckerUid());
        }
        if(cfLogisticsTaskLogQuery.getTaskLogStatus()!=null){
            criteria.andTaskLogStatusEqualTo(cfLogisticsTaskLogQuery.getTaskLogStatus());
        }
        if(cfLogisticsTaskLogQuery.getMinTaskLogStatus()!=null){
            criteria.andTaskLogStatusGreaterThanOrEqualTo(cfLogisticsTaskLogQuery.getMinTaskLogStatus());
        }
        if(cfLogisticsTaskLogQuery.getMaxTaskLogStatus()!=null){
            criteria.andTaskLogStatusLessThanOrEqualTo(cfLogisticsTaskLogQuery.getMaxTaskLogStatus());
        }
        if(cfLogisticsTaskLogQuery.getNumberPlate()!=null){
            criteria.andNumberPlateEqualTo(cfLogisticsTaskLogQuery.getNumberPlate());
        }
        if(cfLogisticsTaskLogQuery.getDeliveryNoteCode()!=null){
            criteria.andDeliveryNoteCodeEqualTo(cfLogisticsTaskLogQuery.getDeliveryNoteCode());
        }
        if(cfLogisticsTaskLogQuery.getItemNumber()!=null){
            criteria.andItemNumberEqualTo(cfLogisticsTaskLogQuery.getItemNumber());
        }
        if(cfLogisticsTaskLogQuery.getCategory()!=null){
            criteria.andCategoryEqualTo(cfLogisticsTaskLogQuery.getCategory());
        }
        if(cfLogisticsTaskLogQuery.getNotifyDriverTime()!=null){
            criteria.andNotifyDriverTimeEqualTo(cfLogisticsTaskLogQuery.getNotifyDriverTime());
        }
        if(cfLogisticsTaskLogQuery.getMinNotifyDriverTime()!=null){
            criteria.andNotifyDriverTimeGreaterThanOrEqualTo(cfLogisticsTaskLogQuery.getMinNotifyDriverTime());
        }
        if(cfLogisticsTaskLogQuery.getMaxNotifyDriverTime()!=null){
            criteria.andNotifyDriverTimeLessThanOrEqualTo(cfLogisticsTaskLogQuery.getMaxNotifyDriverTime());
        }
        if(cfLogisticsTaskLogQuery.getLogisticsStorehouseId()!=null){
            criteria.andLogisticsStorehouseIdEqualTo(cfLogisticsTaskLogQuery.getLogisticsStorehouseId());
        }
        if(cfLogisticsTaskLogQuery.getLogisticsStorehouseIds()!=null){
            criteria.andLogisticsStorehouseIdIn(cfLogisticsTaskLogQuery.getLogisticsStorehouseIds());
        }
        if(cfLogisticsTaskLogQuery.getLogisticsPlatformId()!=null){
            criteria.andLogisticsPlatformIdEqualTo(cfLogisticsTaskLogQuery.getLogisticsPlatformId());
        }
        if(cfLogisticsTaskLogQuery.getMinQueueIndex()!=null){
            criteria.andQueueIndexGreaterThanOrEqualTo(cfLogisticsTaskLogQuery.getMinQueueIndex());
        }
        if(cfLogisticsTaskLogQuery.getMaxQueueIndex()!=null){
            criteria.andQueueIndexLessThanOrEqualTo(cfLogisticsTaskLogQuery.getMaxQueueIndex());
        }
        if(cfLogisticsTaskLogQuery.getQueuingAreaId()!=null){
            criteria.andQueuingAreaIdEqualTo(cfLogisticsTaskLogQuery.getQueuingAreaId());
        }
        if(cfLogisticsTaskLogQuery.getMinCreateTime()!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfLogisticsTaskLogQuery.getMinCreateTime());
        }
        if(cfLogisticsTaskLogQuery.getMaxCreateTime()!=null){
            criteria.andCreateTimeLessThanOrEqualTo(cfLogisticsTaskLogQuery.getMaxCreateTime());
        }
        if(cfLogisticsTaskLogQuery.getFactoryId()!=null){
            criteria.andFactoryIdEqualTo(cfLogisticsTaskLogQuery.getFactoryId());
        }


        if(StringUtils.isNotEmpty(cfLogisticsTaskLogQuery.getOrderBy())){
            cfLogisticsTaskLogExample.setOrderByClause(cfLogisticsTaskLogQuery.getOrderBy());
        }
        if(cfLogisticsTaskLogQuery.getPage()!=null && cfLogisticsTaskLogQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsTaskLogQuery.getPage(), cfLogisticsTaskLogQuery.getSize());
        }
        return cfLogisticsTaskLogExample;
    }

    @Override
    public Map<String, Object> checkUserDocumentsStatus(String uid) throws Exception {
        CfUserDriverLicense cfUserDriverLicense = cfUserService.checkUserDriverDocumentsStatus(uid);
        Map<String, Object> cfUserDriverLicenseMap = new HashMap<>();
        cfUserDriverLicenseMap.put("UserDriverLicense",cfUserDriverLicense);
        return cfUserDriverLicenseMap;
    }

    @Override
    public Map<String, Object> checkUserDocumentsStatusByPhone(String phone) throws Exception {
        CfUser cfUser = cfUserService.findByPhone(phone);
        if(cfUser==null){
            ExceptionCast.cast(UcenterCode.PHONE_IS_NOT_REGISTERED);
        }
        Map<String, Object> stringObjectMap = checkUserDocumentsStatus(cfUser.getId());
        stringObjectMap.put("cfUser",cfUser);
        return stringObjectMap;
    }

    @Override
    public CfLogisticsTaskLog reserveTask(String uid, Long taskId, String numberPlate, String deliveryNoteCode, String deliveryNoteImage) throws Exception {
        //先判断当前用户是否已经通过真实证件审核
        CfLogisticsTask cfLogisticsTask = cfLogisticsTaskService.findById(taskId, false);
        if(cfLogisticsTask.getTaskStatus().byteValue()==(byte)1){
            ExceptionCast.cast(LogisticsCode.APPOINTMENT_IS_FULL);
        }
        if(cfLogisticsTask.getStartTime()>System.currentTimeMillis() || cfLogisticsTask.getEndTime()<System.currentTimeMillis()){
            ExceptionCast.cast(LogisticsCode.NOT_WITHIN_THE_APPOINTMENT_TIME_PERIOD);
        }

        checkUserDocumentsStatus(uid);
        //单个司机针对一个工厂只能同时存在一个未完成的预约
        CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        cfLogisticsTaskLogQuery.setDeliverUid(uid);
        cfLogisticsTaskLogQuery.setFactoryId(cfLogisticsTask.getFactoryId());
        cfLogisticsTaskLogQuery.setMaxTaskLogStatus((byte)4);
        Integer countByQuery = countByQuery(cfLogisticsTaskLogQuery);
        if(countByQuery.intValue()>0){
            ExceptionCast.cast(LogisticsCode.REPEAT_APPOINTMENT);
        }
        short queueIndex = (short) 5000;
        //制作预约插入数据
        CfLogisticsTaskLog cfLogisticsTaskLog = new CfLogisticsTaskLog();
        cfLogisticsTaskLog.setTaskId(taskId);
        cfLogisticsTaskLog.setDeliverUid(uid);
        cfLogisticsTaskLog.setReserveQuantity(new Double(Math.floor(cfLogisticsTask.getResEach()/cfLogisticsTask.getVehiclesRequired())).intValue());
        cfLogisticsTaskLog.setReserveWeight(new Double(Math.floor(cfLogisticsTask.getWeight()/cfLogisticsTask.getVehiclesRequired())).longValue());
        cfLogisticsTaskLog.setNumberPlate(numberPlate);
        cfLogisticsTaskLog.setDeliveryNoteCode(deliveryNoteCode);
        cfLogisticsTaskLog.setDeliveryNoteImage(deliveryNoteImage);
        cfLogisticsTaskLog.setEmergencyLevel(cfLogisticsTask.getEmergencyLevel());
        cfLogisticsTaskLog.setFactoryId(cfLogisticsTask.getFactoryId());
        cfLogisticsTaskLog.setCategory(cfLogisticsTask.getCargoType());
        cfLogisticsTaskLog.setQueueIndex(queueIndex);

        //判断是否有子任务
        CfLogisticsTaskQuery cfLogisticsTaskQuery = new CfLogisticsTaskQuery();
        cfLogisticsTaskQuery.setPid(taskId);
        List<CfLogisticsTask> cfLogisticsTasks = cfLogisticsTaskService.getListByQuery(cfLogisticsTaskQuery);

        CfLogisticsTaskLog lastCfLogisticsTaskLog = add(cfLogisticsTaskLog);
        CfLogisticsTaskLog taskLog = new CfLogisticsTaskLog();
        BeanUtils.copyProperties(lastCfLogisticsTaskLog, taskLog);
        if(cfLogisticsTasks!=null && cfLogisticsTasks.size()>0){
            //有子任务，生成多个子预约数据
            CfLogisticsTask updateChildrenLogisticsTask = new CfLogisticsTask();
            for (CfLogisticsTask logisticsTask: cfLogisticsTasks){
                ++queueIndex;
                cfLogisticsTaskLog.setPid(taskLog.getId());
                cfLogisticsTaskLog.setTaskId(logisticsTask.getId());
                cfLogisticsTaskLog.setReserveQuantity(new Double(Math.floor(logisticsTask.getResEach()/logisticsTask.getVehiclesRequired())).intValue());
                cfLogisticsTaskLog.setReserveWeight(new Double(Math.floor(logisticsTask.getWeight()/logisticsTask.getVehiclesRequired())).longValue());
                cfLogisticsTaskLog.setLogisticsStorehouseId(logisticsTask.getLogisticsStorehouseId());
                cfLogisticsTaskLog.setId(null);
                cfLogisticsTaskLog.setFactoryId(logisticsTask.getFactoryId());
                cfLogisticsTaskLog.setCategory(logisticsTask.getCargoType());
                cfLogisticsTaskLog.setQueueIndex(queueIndex);
                add(cfLogisticsTaskLog);
                //更新任务中已预约车辆数
                cfLogisticsTaskService.updateReservedVehicles(logisticsTask.getId(), (short)1);
                if((short)(logisticsTask.getReservedVehicles().shortValue()+(short)1)>=logisticsTask.getVehiclesRequired().shortValue()){
                    //预约已经满了的话，设置为 装/卸货中
                    updateChildrenLogisticsTask.setId(logisticsTask.getId());
                    updateChildrenLogisticsTask.setTaskStatus((byte)1);
                    cfLogisticsTaskService.update(updateChildrenLogisticsTask);
                }
            }
        }

        //更新任务中已预约车辆数
        cfLogisticsTaskService.updateReservedVehicles(taskId, (short)1);

        if((short)(cfLogisticsTask.getReservedVehicles().shortValue()+(short)1)>=cfLogisticsTask.getVehiclesRequired().shortValue()){
            //预约已经满了的话，设置为 装/卸货中
            CfLogisticsTask updateLogisticsTask = new CfLogisticsTask();
            updateLogisticsTask.setId(cfLogisticsTask.getId());
            updateLogisticsTask.setTaskStatus((byte)1);
            cfLogisticsTaskService.update(updateLogisticsTask);
        }

        return taskLog;
    }

    @Override
    public CfLogisticsTaskLog cancelAppointment(CfLogisticsTaskLog cfLogisticsTaskLog) throws Exception {
        //判断其是否是排队中车辆且排队在第一位的，如果是排队在第一位的，叫号下一位司机
        if(cfLogisticsTaskLog.getQueuingAreaId()!=null && cfLogisticsTaskLog.getTaskLogStatus().byteValue()==(byte)2){
            CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
            cfLogisticsTaskLogQuery.setQueuingAreaId(cfLogisticsTaskLog.getQueuingAreaId());
            cfLogisticsTaskLogQuery.setTaskLogStatus((byte)2);
            cfLogisticsTaskLogQuery.setOrderBy("queue_index asc");
            cfLogisticsTaskLogQuery.setPage(1);
            cfLogisticsTaskLogQuery.setSize(1);
            List<CfLogisticsTaskLog> cfLogisticsTaskLogList = getListByQuery(cfLogisticsTaskLogQuery);
            if(cfLogisticsTaskLogList!=null && cfLogisticsTaskLogList.size()>0 && cfLogisticsTaskLogList.get(0).getId().longValue()==cfLogisticsTaskLog.getId().longValue()){
                //按过号处理
                numberOver(cfLogisticsTaskLog, false);
            }
        }

        //更新其状态未已取消预约状态
//        CfLogisticsTaskLog updateCfLogisticsTaskLog = new CfLogisticsTaskLog();
//        updateCfLogisticsTaskLog.setId(cfLogisticsTaskLog.getId());
//        updateCfLogisticsTaskLog.setTaskLogStatus((byte)6);
//        update(updateCfLogisticsTaskLog);

        //查询并判断其任务状态，如果其任务已经为被预约满状态，设置为待预约，归还已预约车辆数目
        CfLogisticsTask cfLogisticsTask = cfLogisticsTaskService.findById(cfLogisticsTaskLog.getTaskId(), false);
        CfLogisticsTask updateCfLogisticsTask = new CfLogisticsTask();
        updateCfLogisticsTask.setId(cfLogisticsTaskLog.getTaskId());
        updateCfLogisticsTask.setReservedVehicles((short)(cfLogisticsTask.getReservedVehicles().shortValue()-(short)1));
        updateCfLogisticsTask.setTaskStatus((byte)0);
        cfLogisticsTaskService.update(updateCfLogisticsTask);
//        cfLogisticsTaskLog.setTaskLogStatus(updateCfLogisticsTaskLog.getTaskLogStatus());
        delete(cfLogisticsTaskLog.getId());
        //如果其存在子预约，对其子预约进行递归操作
        if(cfLogisticsTaskLog.getPid().longValue()==0l){
            CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
            cfLogisticsTaskLogQuery.setPid(cfLogisticsTaskLog.getId());
            List<CfLogisticsTaskLog> cfLogisticsTaskLogList = getListByQuery(cfLogisticsTaskLogQuery);
            if(cfLogisticsTaskLogList!=null && cfLogisticsTaskLogList.size()>0){
                for(CfLogisticsTaskLog logisticsTaskLog: cfLogisticsTaskLogList){
                    cancelAppointment(logisticsTaskLog);
                }
            }
            //只通知父级任务已取消预约
            noticeDirverCancelAppointment(cfLogisticsTaskLog);
        }
        //判断该任务是否为当前预约用户创建的，如果是当前用户自助创建的，删除对应任务
        if(cfLogisticsTask.getEditerUid().equals(cfLogisticsTaskLog.getDeliverUid())){
            cfLogisticsTaskService.delete(cfLogisticsTaskLog.getTaskId());
        }else{
            //如果创建该任务是普通用户，也删除掉该任务
            CfUser cfUser = cfUserService.getUserByUid(cfLogisticsTask.getEditerUid(), true);
            if(cfUser!=null && (cfUser.getCfRoles()==null || cfUser.getCfRoles().size()==0)){
                cfLogisticsTaskService.delete(cfLogisticsTaskLog.getTaskId());
            }
        }

        //删除对应停车场的车辆预约到访记录
        CfLogisticsFactory cfLogisticsFactory = cfLogisticsFactoryService.findById(cfLogisticsTask.getFactoryId(), false);
        if(StringUtils.isNotEmpty(cfLogisticsFactory.getCarParkIds())){
            String[] carParkIds = cfLogisticsFactory.getCarParkIds().split(",");
            if(carParkIds.length>0){
                ArrayList<Long> parkIdList = new ArrayList<>();
                for(int i=0; i<carParkIds.length; i++){
                    parkIdList.add(new Long(carParkIds[i]));
                }
                CfCarParkVisitQuery cfCarParkVisitQuery = new CfCarParkVisitQuery();
                cfCarParkVisitQuery.setCarParkIds(parkIdList);
                cfCarParkVisitQuery.setFromUid(new Long(cfLogisticsTaskLog.getDeliverUid()));
                cfCarParkVisitService.deleteByQuery(cfCarParkVisitQuery);
            }
        }

        return cfLogisticsTaskLog;
    }

    @Override
    public void reserveSignIn(String uid, Long taskLogId) throws Exception {
        CfLogisticsTaskLog cfLogisticsTaskLog = findById(taskLogId, false);
        CfLogisticsTask cfLogisticsTask = cfLogisticsTaskService.findById(cfLogisticsTaskLog.getTaskId(), false);
        if(!cfLogisticsTaskLog.getDeliverUid().equals(uid)){
            ExceptionCast.cast(LogisticsCode.APPOINTMENT_RECORD_DOES_NOT_BELONG_TO_YOU);
        }
        if(cfLogisticsTaskLog.getTaskLogStatus()!=(byte)0){
            ExceptionCast.cast(LogisticsCode.CHECK_IN_IS_PROHIBITED);
        }
        if(cfLogisticsTaskLog.getPid()!=(byte)0){
            ExceptionCast.cast(LogisticsCode.CHECK_IN_IS_PROHIBITED);
        }
        noticeDirverQueueOrDriverLoadingOrUnloading(cfLogisticsTaskLog,"desc");

        //新增对应停车场的车辆预约到访记录
        CfLogisticsFactory cfLogisticsFactory = cfLogisticsFactoryService.findById(cfLogisticsTask.getFactoryId(), false);
        if(StringUtils.isNotEmpty(cfLogisticsFactory.getCarParkIds())){
            String[] carParkIds = cfLogisticsFactory.getCarParkIds().split(",");
            if(carParkIds.length==0){
                return;
            }
            for(int i=0; i<carParkIds.length; i++){
                //校验对应停车场是否存在
                CfCarPark cfCarPark = cfCarParkService.findById(carParkIds[i]);
                if(cfCarPark==null){
                    continue;
                }
                //开始添加到访记录
                CfCarParkVisit cfCarParkVisit = new CfCarParkVisit();
                cfCarParkVisit.setCarParkId(new Long(carParkIds[i]));
                cfCarParkVisit.setExpirationTime(System.currentTimeMillis()+86400000l);//默认24小时内有效
                cfCarParkVisit.setFromUid(new Long(cfLogisticsTaskLog.getDeliverUid()));
                cfCarParkVisit.setPlateNumber(cfLogisticsTaskLog.getNumberPlate());
                cfCarParkVisit.setProcessStatus((byte)1);
                cfCarParkVisitService.add(cfCarParkVisit);
            }
        }
    }

    @Override
    public void noticeDriverQueue(CfLogisticsTaskLog cfLogisticsTaskLog, Integer numberOfQueuedVehicles) throws Exception {
        if(cfLogisticsTaskLog.getCfLogisticsQueuingArea()==null){
            cfLogisticsTaskLog.setCfLogisticsQueuingArea(cfLogisticsQueuingAreaService.findById(cfLogisticsTaskLog.getQueuingAreaId(),false));
        }
        CfLogisticsFactory cfLogisticsFactory = cfLogisticsFactoryService.findById(cfLogisticsTaskLog.getFactoryId());
        //如果该预约处在排队中，刷新一下LED大屏
        if(cfLogisticsTaskLog.getTaskLogStatus()>=(byte)2){
            flushLesScreenData(cfLogisticsTaskLog.getQueuingAreaId());
        }
        if(cfLogisticsFactory==null || StringUtils.isEmpty(cfLogisticsFactory.getWxMpAppid())){
            //如果仓库没有绑定微信appid，不进行推送
            return;
        }
        Map<String,String> contents = new HashMap<>();
        contents.put("number_of_queued_vehicles",numberOfQueuedVehicles+"");
        contents.put("notes","请您及时前往"+cfLogisticsTaskLog.getCfLogisticsQueuingArea().getAreaName()+"进行排队");
        JSONObject jsonObject = cfWeiXinSubscribeToNotificationsService.sendMessage(cfLogisticsTaskLog.getDeliverUid(), CfWeiXinSubscribeToNotificationsType.LOGISTICS_QUEUE, contents,
                cfLogisticsFactory.getWxMpAppid());
        System.out.println("微信物流排队通知结果: "+jsonObject.toJSONString());
    }

    @Override
    public void noticeDriverLoadingOrUnloading(CfLogisticsTaskLog cfLogisticsTaskLog) throws Exception {
        if(cfLogisticsTaskLog.getLogisticsStorehouseId().longValue()==0l || cfLogisticsTaskLog.getLogisticsPlatformId().longValue()==0l){
            List<CfLogisticsStorehousePlatform> cfLogisticsStorehousePlatformList = getPlatformListByUseLog(cfLogisticsTaskLog);
            cfLogisticsTaskLog.setCfLogisticsStorehousePlatform(cfLogisticsStorehousePlatformList.get(0));
            cfLogisticsTaskLog.setLogisticsStorehouseId(cfLogisticsStorehousePlatformList.get(0).getStorehouseId());
            cfLogisticsTaskLog.setLogisticsPlatformId(cfLogisticsStorehousePlatformList.get(0).getId());
        }
        if(cfLogisticsTaskLog.getCfLogisticsStorehouse()==null){
            cfLogisticsTaskLog.setCfLogisticsStorehouse(cfLogisticsStorehouseService.findById(cfLogisticsTaskLog.getLogisticsStorehouseId(),false));
        }
        if(cfLogisticsTaskLog.getCfLogisticsStorehousePlatform()==null){
            cfLogisticsTaskLog.setCfLogisticsStorehousePlatform(cfLogisticsStorehousePlatformService.findById(cfLogisticsTaskLog.getLogisticsPlatformId(),false));
        }
        CfLogisticsTaskLog updateCfLogisticsTaskLog = new CfLogisticsTaskLog();
        updateCfLogisticsTaskLog.setId(cfLogisticsTaskLog.getId());
        updateCfLogisticsTaskLog.setLogisticsPlatformId(cfLogisticsTaskLog.getLogisticsPlatformId());
        updateCfLogisticsTaskLog.setLogisticsStorehouseId(cfLogisticsTaskLog.getLogisticsStorehouseId());
        CfLogisticsFactory cfLogisticsFactory = cfLogisticsFactoryService.findById(cfLogisticsTaskLog.getFactoryId());
        //如果该预约处在排队中，刷新一下LED大屏
        if(cfLogisticsTaskLog.getTaskLogStatus()>=(byte)2){
            flushLesScreenData(cfLogisticsTaskLog.getQueuingAreaId());
        }
        if(cfLogisticsFactory==null || StringUtils.isEmpty(cfLogisticsFactory.getWxMpAppid())){
            //如果仓库没有绑定微信appid，不进行推送
            return;
        }else{
            updateCfLogisticsTaskLog.setNotifyDriverTime(System.currentTimeMillis());
            update(updateCfLogisticsTaskLog);
        }
        Map<String,String> contents = new HashMap<>();
        contents.put("queueIndex",cfLogisticsTaskLog.getQueueIndex()+"");
        contents.put("cfLogisticsStorehousePlatformName",cfLogisticsTaskLog.getCfLogisticsStorehousePlatform().getPlatformName());
        //查询司机信息
        CfUserDriverLicenseQuery cfUserDriverLicenseQuery = new CfUserDriverLicenseQuery();
        cfUserDriverLicenseQuery.setUid(cfLogisticsTaskLog.getDeliverUid());
        List<CfUserDriverLicense> cfUserDriverLicenseList = cfUserDriverLicenseService.getListByQuery(cfUserDriverLicenseQuery);
        if(cfUserDriverLicenseList!=null && cfUserDriverLicenseList.size()>0){
            contents.put("driverName",cfUserDriverLicenseList.get(0).getUserName());
        }else{
            contents.put("driverName","司机");
        }
        contents.put("numberPlate",cfLogisticsTaskLog.getNumberPlate());

        JSONObject jsonObject = cfWeiXinSubscribeToNotificationsService.sendMessage(cfLogisticsTaskLog.getDeliverUid(), CfWeiXinSubscribeToNotificationsType.LOGISTICS_LOADING_AND_UNLOADING, contents,
                cfLogisticsFactory.getWxMpAppid());
        System.out.println("微信物流装卸货通知结果: "+jsonObject.toJSONString());
    }

    @Override
    public void cargoCheck(CfLogisticsTaskLog cfLogisticsTaskLog) throws Exception {
        //更改预约状态
        CfLogisticsTaskLog newLogisticsTaskLog = new CfLogisticsTaskLog();
        newLogisticsTaskLog.setCheckerUid(cfLogisticsTaskLog.getCheckerUid());
        newLogisticsTaskLog.setId(cfLogisticsTaskLog.getId());
        newLogisticsTaskLog.setTaskLogStatus((byte)5);
        update(newLogisticsTaskLog);
        //如果所有预约已经完成，切换任务状态
        CfLogisticsTaskLogQuery logisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        logisticsTaskLogQuery.setTaskId(cfLogisticsTaskLog.getTaskId());
        logisticsTaskLogQuery.setMaxTaskLogStatus((byte)2);
        Integer countByQuery = countByQuery(logisticsTaskLogQuery);
        if(countByQuery.intValue()==0){
            CfLogisticsTask cfLogisticsTask = new CfLogisticsTask();
            cfLogisticsTask.setId(cfLogisticsTaskLog.getTaskId());
            cfLogisticsTask.setTaskStatus((byte)2);
            cfLogisticsTaskService.update(cfLogisticsTask);
        }

        //刷新一下LED大屏
        if(cfLogisticsTaskLog.getTaskLogStatus()>=(byte)2){
            flushLesScreenData(cfLogisticsTaskLog.getQueuingAreaId());
        }
        //如果其为父级任务且有子任务，叫号当前司机直接进行下一个子任务
        if(cfLogisticsTaskLog.getPid()==0){
            //找其子任务，给其排到第一位
            CfLogisticsTaskLogQuery childrenCfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
            childrenCfLogisticsTaskLogQuery.setPid(cfLogisticsTaskLog.getId());
            childrenCfLogisticsTaskLogQuery.setMaxTaskLogStatus((byte)1);
            childrenCfLogisticsTaskLogQuery.setOrderBy("queue_index asc");
            List<CfLogisticsTaskLog> cfLogisticsTaskLogList = getListByQuery(childrenCfLogisticsTaskLogQuery);
            if(cfLogisticsTaskLogList!=null && cfLogisticsTaskLogList.size()>0){
                noticeDirverQueueOrDriverLoadingOrUnloading(cfLogisticsTaskLogList.get(0),"asc");
                return;
            }
        }else{
            //看看一个父级任务还有没有子任务，如果有，继续通知下一个子任务排队或装卸货
            CfLogisticsTaskLogQuery childrenCfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
            childrenCfLogisticsTaskLogQuery.setPid(cfLogisticsTaskLog.getPid());
            childrenCfLogisticsTaskLogQuery.setMaxTaskLogStatus((byte)1);
            childrenCfLogisticsTaskLogQuery.setOrderBy("queue_index asc");
            List<CfLogisticsTaskLog> cfLogisticsTaskLogList = getListByQuery(childrenCfLogisticsTaskLogQuery);
            if(cfLogisticsTaskLogList!=null && cfLogisticsTaskLogList.size()>0){
                //排除它自己
                int i = 0;
                for(CfLogisticsTaskLog logisticsTaskLog: cfLogisticsTaskLogList){
                    if(cfLogisticsTaskLog.getId().longValue()==logisticsTaskLog.getId().longValue()){
                        //剔除它自己
                        cfLogisticsTaskLogList.remove(i);
                        break;
                    }
                    i++;
                }
                if(cfLogisticsTaskLogList!=null && cfLogisticsTaskLogList.size()>0){
                    noticeDirverQueueOrDriverLoadingOrUnloading(cfLogisticsTaskLogList.get(0),"asc");
                }
                return;
            }
        }
        //如果后面还有排队司机，通知下一位司机
        CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        cfLogisticsTaskLogQuery.setQueuingAreaId(cfLogisticsTaskLog.getQueuingAreaId());
        cfLogisticsTaskLogQuery.setTaskLogStatus((byte)2);
        cfLogisticsTaskLogQuery.setOrderBy("queue_index asc");
        cfLogisticsTaskLogQuery.setPage(1);
        cfLogisticsTaskLogQuery.setSize(10);
        List<CfLogisticsTaskLog> cfLogisticsTaskLogList = getListByQuery(cfLogisticsTaskLogQuery);
        Short queueIndex = (short)0;
        if(cfLogisticsTaskLogList!=null && cfLogisticsTaskLogList.size()>0){
            queueIndex = cfLogisticsTaskLogList.get(0).getQueueIndex();
            //当前核验记录后面的所有数据排队顺序往前移动一步
//            cfLogisticsTaskLogQuery.setOrderBy(null);
//            cfLogisticsTaskLogQuery.setPage(null);
//            cfLogisticsTaskLogQuery.setSize(null);
//            if(cfLogisticsTaskLogList.get(0).getQueueIndex().intValue()>cfLogisticsTaskLog.getQueueIndex().intValue()){
//                //操作的是第一个数据
//                cfLogisticsTaskLogQuery.setQueueIndexChangeValue((short)(-(cfLogisticsTaskLogList.get(0).getQueueIndex().intValue()-1)));
//                cfLogisticsTaskLogList.get(0).setQueueIndex((short)1);
//            }else{
//                //操作的不是第一个数据
//                cfLogisticsTaskLogQuery.setMinQueueIndex((short)(cfLogisticsTaskLog.getQueueIndex().intValue()+1));
//                cfLogisticsTaskLogQuery.setQueueIndexChangeValue((short)-1);
//                cfLogisticsTaskLogList.get(0).setQueueIndex((short)(queueIndex.intValue()-1));
//            }
//            cfLogisticsTaskLogMapper.increaseQueueIndex(cfLogisticsTaskLogQuery);

            //计算前10个顺序
            Integer newQueueIndex = 1;
            for(CfLogisticsTaskLog logisticsTaskLog: cfLogisticsTaskLogList){
                newLogisticsTaskLog.setCheckerUid(null);
                newLogisticsTaskLog.setId(logisticsTaskLog.getId());
                newLogisticsTaskLog.setTaskLogStatus(null);
                newLogisticsTaskLog.setQueueIndex(newQueueIndex.shortValue());
                update(newLogisticsTaskLog);
                newQueueIndex++;
            }
            noticeDriverLoadingOrUnloading(cfLogisticsTaskLogList.get(0));
        }

        //删除对应停车场的车辆预约到访记录
        CfLogisticsFactory cfLogisticsFactory = cfLogisticsFactoryService.findById(cfLogisticsTaskLog.getFactoryId(), false);
        if(StringUtils.isNotEmpty(cfLogisticsFactory.getCarParkIds())){
            String[] carParkIds = cfLogisticsFactory.getCarParkIds().split(",");
            if(carParkIds.length>0){
                ArrayList<Long> parkIdList = new ArrayList<>();
                for(int i=0; i<carParkIds.length; i++){
                    parkIdList.add(new Long(carParkIds[i]));
                }
                CfCarParkVisitQuery cfCarParkVisitQuery = new CfCarParkVisitQuery();
                cfCarParkVisitQuery.setCarParkIds(parkIdList);
                cfCarParkVisitQuery.setFromUid(new Long(cfLogisticsTaskLog.getDeliverUid()));
                cfCarParkVisitService.deleteByQuery(cfCarParkVisitQuery);
            }
        }
    }

    @Override
    public void noticeDirverQueueOrDriverLoadingOrUnloading(CfLogisticsTaskLog cfLogisticsTaskLog, String orderBy) throws Exception{
        CfLogisticsTaskLog updateCfLogisticsTaskLog = new CfLogisticsTaskLog();
        updateCfLogisticsTaskLog.setId(cfLogisticsTaskLog.getId());

        List<CfLogisticsStorehousePlatform> cfLogisticsStorehousePlatformList = getPlatformListByUseLog(cfLogisticsTaskLog);

        //找到最优排队区
        CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery = new CfLogisticsQueuingAreaPlatformQuery();
        cfLogisticsQueuingAreaPlatformQuery.setLogisticsStorehousePlatformIds(new ArrayList<>());
        for(CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform: cfLogisticsStorehousePlatformList){
            cfLogisticsQueuingAreaPlatformQuery.getLogisticsStorehousePlatformIds().add(cfLogisticsStorehousePlatform.getId());
        }
        List<CfLogisticsQueuingAreaPlatform> cfLogisticsQueuingAreaPlatformList = cfLogisticsQueuingAreaPlatformService.getListByQuery(cfLogisticsQueuingAreaPlatformQuery);
        if(cfLogisticsQueuingAreaPlatformList==null || cfLogisticsQueuingAreaPlatformList.size()==0){
            ExceptionCast.cast(LogisticsCode.CAN_NOT_FIND_QUEUING_AREA);
        }
        CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery = new CfLogisticsQueuingAreaQuery();
        cfLogisticsQueuingAreaQuery.setIds(new ArrayList<>());
        for (CfLogisticsQueuingAreaPlatform cfLogisticsQueuingAreaPlatform: cfLogisticsQueuingAreaPlatformList){
            if(!cfLogisticsQueuingAreaQuery.getIds().contains(cfLogisticsQueuingAreaPlatform.getId())){
                cfLogisticsQueuingAreaQuery.getIds().add(cfLogisticsQueuingAreaPlatform.getQueuingAreaId());
            }
        }
        cfLogisticsQueuingAreaQuery.setOrderBy("used_queue_capacity asc");
        cfLogisticsQueuingAreaQuery.setPage(1);
        cfLogisticsQueuingAreaQuery.setSize(1);
        List<CfLogisticsQueuingArea> cfLogisticsQueuingAreaList = cfLogisticsQueuingAreaService.getListByQuery(cfLogisticsQueuingAreaQuery);
        if(cfLogisticsQueuingAreaList==null || cfLogisticsQueuingAreaList.size()==0){
            ExceptionCast.cast(LogisticsCode.CAN_NOT_FIND_QUEUING_AREA);
        }

        //找到当前排队最小(大)序号
        CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        cfLogisticsTaskLogQuery.setQueuingAreaId(cfLogisticsQueuingAreaList.get(0).getId());
        cfLogisticsTaskLogQuery.setTaskLogStatus((byte)2);
        //如果是紧急单(vip)，排到最近一个vip后后面(前面)
        if(cfLogisticsTaskLog.getEmergencyLevel()==(byte)1){
            cfLogisticsTaskLogQuery.setEmergencyLevel(cfLogisticsTaskLog.getEmergencyLevel());
        }
        if(orderBy.equals("asc")){
            cfLogisticsTaskLogQuery.setOrderBy("queue_index asc");
        }else{
            cfLogisticsTaskLogQuery.setOrderBy("queue_index desc");
        }
        cfLogisticsTaskLogQuery.setPage(1);
        cfLogisticsTaskLogQuery.setSize(1);
        List<CfLogisticsTaskLog> cfLogisticsTaskLogs = getListByQuery(cfLogisticsTaskLogQuery);
        if(cfLogisticsTaskLogs!=null && cfLogisticsTaskLogs.size()>0){
            if(orderBy.equals("asc")){
                updateCfLogisticsTaskLog.setQueueIndex(new Integer(cfLogisticsTaskLogs.get(0).getQueueIndex()-1).shortValue());
            }else{
                //如果是紧急任务，判断最后一个的下一位是否有普通任务，如果有，整体普通任务往下移动一位
                if(cfLogisticsTaskLog.getEmergencyLevel()==(byte)1){
                    cfLogisticsTaskLogQuery.setPage(null);
                    cfLogisticsTaskLogQuery.setOrderBy(null);
                    cfLogisticsTaskLogQuery.setEmergencyLevel(null);
                    cfLogisticsTaskLogQuery.setQueueIndex((short)(cfLogisticsTaskLogs.get(0).getQueueIndex().intValue()+1));
                    Integer commonQueue = countByQuery(cfLogisticsTaskLogQuery);
                    if(commonQueue>0){
                        //所有普通任务后移一位
                        cfLogisticsTaskLogQuery.setQueueIndex(null);
                        cfLogisticsTaskLogQuery.setQueueIndexChangeValue((short)1);
                        cfLogisticsTaskLogMapper.increaseQueueIndex(cfLogisticsTaskLogQuery);
                    }
                    updateCfLogisticsTaskLog.setQueueIndex(cfLogisticsTaskLogs.get(0).getQueueIndex());
                }else{
                    //普通任务直接排到最后面
                    updateCfLogisticsTaskLog.setQueueIndex(new Integer(cfLogisticsTaskLogs.get(0).getQueueIndex()+1).shortValue());
                }
            }

        }else{
            updateCfLogisticsTaskLog.setQueueIndex((short)1);
        }

        //更新排队序号,排队区域
        updateCfLogisticsTaskLog.setQueuingAreaId(cfLogisticsQueuingAreaList.get(0).getId());

        //更新排队区域已使用容量
        CfLogisticsQueuingArea cfLogisticsQueuingArea = new CfLogisticsQueuingArea();
        cfLogisticsQueuingArea.setId(cfLogisticsQueuingAreaList.get(0).getId());
        cfLogisticsQueuingArea.setUsedQueueCapacity(cfLogisticsQueuingAreaList.get(0).getUsedQueueCapacity()+1);
        cfLogisticsQueuingAreaService.update(cfLogisticsQueuingArea);

        //查询其前面有几个人在排队
        CfLogisticsTaskLogQuery logisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        logisticsTaskLogQuery.setQueuingAreaId(cfLogisticsQueuingAreaList.get(0).getId());
        if(cfLogisticsTaskLog.getTaskLogStatus()==(byte)2){
            logisticsTaskLogQuery.setMaxQueueIndex(new Integer(cfLogisticsTaskLog.getQueueIndex()-1).shortValue());
        }
        logisticsTaskLogQuery.setTaskLogStatus((byte)2);
        //赋值排队人数
        Integer integer = countByQuery(logisticsTaskLogQuery);
        cfLogisticsTaskLog.setQueuingAreaId(cfLogisticsQueuingAreaList.get(0).getId());
        //设置其状态为排队中
        updateCfLogisticsTaskLog.setTaskLogStatus((byte)2);
        if(integer.intValue()==0){
            //说明前面没人，通知当前司机直接去装卸货
            cfLogisticsTaskLog.setLogisticsStorehouseId(cfLogisticsStorehousePlatformList.get(0).getStorehouseId());
            cfLogisticsTaskLog.setLogisticsPlatformId(cfLogisticsStorehousePlatformList.get(0).getId());

            updateCfLogisticsTaskLog.setLogisticsPlatformId(cfLogisticsStorehousePlatformList.get(0).getId());
            updateCfLogisticsTaskLog.setLogisticsStorehouseId(cfLogisticsStorehousePlatformList.get(0).getStorehouseId());
            update(updateCfLogisticsTaskLog);
            //通知司机直接去装卸货
            cfLogisticsTaskLog.setTaskLogStatus((byte)2);
            cfLogisticsTaskLog.setQueueIndex(updateCfLogisticsTaskLog.getQueueIndex());
            noticeDriverLoadingOrUnloading(cfLogisticsTaskLog);
        }else{
            update(updateCfLogisticsTaskLog);
            //通知司机去排队
            cfLogisticsTaskLog.setTaskLogStatus((byte)2);
            cfLogisticsTaskLog.setQueueIndex(updateCfLogisticsTaskLog.getQueueIndex());
            noticeDriverQueue(cfLogisticsTaskLog,integer);
        }
    }

    @Override
    public List<CfLogisticsStorehousePlatform> getPlatformListByUseLog(CfLogisticsTaskLog cfLogisticsTaskLog) {
        //根据货物类型先找到可选月台
        CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery = new CfLogisticsStorehousePlatformCargoTypeQuery();
        cfLogisticsStorehousePlatformCargoTypeQuery.setCargoType(cfLogisticsTaskLog.getCategory());
        cfLogisticsStorehousePlatformCargoTypeQuery.setFactoryId(cfLogisticsTaskLog.getFactoryId());
        List<CfLogisticsStorehousePlatformCargoType> cfLogisticsStorehousePlatformCargoTypeList = cfLogisticsStorehousePlatformCargoTypeService.getListByQuery(cfLogisticsStorehousePlatformCargoTypeQuery);

        //根据月台多个id查询月台列表
        CfLogisticsStorehousePlatformQuery cfLogisticsStorehousePlatformQuery = new CfLogisticsStorehousePlatformQuery();
        if(cfLogisticsStorehousePlatformCargoTypeList!=null && cfLogisticsStorehousePlatformCargoTypeList.size()>0){
            for(CfLogisticsStorehousePlatformCargoType cfLogisticsStorehousePlatformCargoType: cfLogisticsStorehousePlatformCargoTypeList){
                cfLogisticsStorehousePlatformQuery.setIds(new ArrayList<>());
                cfLogisticsStorehousePlatformQuery.getIds().add(cfLogisticsStorehousePlatformCargoType.getLogisticsStorehousePlatformId());
            }
        }else{
            ExceptionCast.cast(LogisticsCode.CAN_NOT_FIND_PLATFORM);
        }
        cfLogisticsStorehousePlatformQuery.setPlatformStatus((byte)1);
        List<CfLogisticsStorehousePlatform> cfLogisticsStorehousePlatformList = cfLogisticsStorehousePlatformService.getListByQuery(cfLogisticsStorehousePlatformQuery);
        if(cfLogisticsStorehousePlatformList==null || cfLogisticsStorehousePlatformList.size()==0){
            ExceptionCast.cast(LogisticsCode.CAN_NOT_FIND_PLATFORM);
        }
        return cfLogisticsStorehousePlatformList;
    }

    @Override
    public void noticeDirverCancelAppointment(CfLogisticsTaskLog cfLogisticsTaskLog) throws Exception {
        CfLogisticsFactory cfLogisticsFactory = cfLogisticsFactoryService.findById(cfLogisticsTaskLog.getFactoryId());
        CfLogisticsTaskLog updateCfLogisticsTaskLog = new CfLogisticsTaskLog();
        updateCfLogisticsTaskLog.setId(cfLogisticsTaskLog.getId());
        //如果该预约处在排队中，刷新一下LED大屏
        if(cfLogisticsTaskLog.getTaskLogStatus()>=(byte)2){
            flushLesScreenData(cfLogisticsTaskLog.getQueuingAreaId());
        }
        if(cfLogisticsFactory==null || StringUtils.isEmpty(cfLogisticsFactory.getWxMpAppid())){
            //如果仓库没有绑定微信appid，不进行推送
            return;
        }else{
            updateCfLogisticsTaskLog.setNotifyDriverTime(System.currentTimeMillis());
            update(updateCfLogisticsTaskLog);
        }
        Map<String,String> contents = new HashMap<>();
        contents.put("queueIndex",cfLogisticsTaskLog.getQueueIndex()+"");
        contents.put("numberPlate",cfLogisticsTaskLog.getNumberPlate());

        JSONObject jsonObject = cfWeiXinSubscribeToNotificationsService.sendMessage(cfLogisticsTaskLog.getDeliverUid(), CfWeiXinSubscribeToNotificationsType.LOGISTICS_CANCEL_APPOINTMENT, contents,
                cfLogisticsFactory.getWxMpAppid());
        System.out.println("微信物流取消预约通知结果: "+jsonObject.toJSONString());
    }

    @Override
    public void noticeDirverNumberOver(CfLogisticsTaskLog cfLogisticsTaskLog) throws Exception {
        CfLogisticsFactory cfLogisticsFactory = cfLogisticsFactoryService.findById(cfLogisticsTaskLog.getFactoryId());
        CfLogisticsTaskLog updateCfLogisticsTaskLog = new CfLogisticsTaskLog();
        updateCfLogisticsTaskLog.setId(cfLogisticsTaskLog.getId());
        //如果该预约处在排队中，刷新一下LED大屏
        if(cfLogisticsTaskLog.getTaskLogStatus()>=2){
            flushLesScreenData(cfLogisticsTaskLog.getQueuingAreaId());
        }
        if(cfLogisticsFactory==null || StringUtils.isEmpty(cfLogisticsFactory.getWxMpAppid())){
            //如果仓库没有绑定微信appid，不进行推送
            return;
        }else{
            updateCfLogisticsTaskLog.setNotifyDriverTime(System.currentTimeMillis());
            update(updateCfLogisticsTaskLog);
        }
        Map<String,String> contents = new HashMap<>();
        contents.put("numberPlate",cfLogisticsTaskLog.getNumberPlate());

        JSONObject jsonObject = cfWeiXinSubscribeToNotificationsService.sendMessage(cfLogisticsTaskLog.getDeliverUid(), CfWeiXinSubscribeToNotificationsType.LOGISTICS_NUMBER_OVER, contents,
                cfLogisticsFactory.getWxMpAppid());
        System.out.println("微信物流过号通知结果: "+jsonObject.toJSONString());
    }

    @Override
    public void logisticsTaskLogTop(Long id) throws Exception {
        CfLogisticsTaskLog cfLogisticsTaskLog = findById(id, false);
        if(cfLogisticsTaskLog.getTaskLogStatus()!=(byte)1 && cfLogisticsTaskLog.getTaskLogStatus()!=(byte)2){
            ExceptionCast.cast(LogisticsCode.NOT_IN_LINE);
        }
        //如果该预约处在排队中，刷新一下LED大屏
        if(cfLogisticsTaskLog.getTaskLogStatus()>=2){
            flushLesScreenData(cfLogisticsTaskLog.getQueuingAreaId());
        }
        //判断该任务紧急程度，如果是紧急，排到第一位，如果是一般，拍到普通的第一位
        CfLogisticsTask cfLogisticsTask = cfLogisticsTaskService.findById(cfLogisticsTaskLog.getTaskId(), false);
        CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        cfLogisticsTaskLogQuery.setEmergencyLevel(cfLogisticsTask.getEmergencyLevel());
        cfLogisticsTaskLogQuery.setQueuingAreaId(cfLogisticsTaskLog.getQueuingAreaId());
        cfLogisticsTaskLogQuery.setOrderBy("queue_index asc");
        cfLogisticsTaskLogQuery.setPage(1);
        cfLogisticsTaskLogQuery.setSize(1);
        List<CfLogisticsTaskLog> cfLogisticsTaskLogList = getListByQuery(cfLogisticsTaskLogQuery);
        if(cfLogisticsTaskLogList!=null && cfLogisticsTaskLogList.size()>0 && cfLogisticsTaskLogList.get(0).getId().longValue()!=id.longValue()){
            CfLogisticsTaskLog updateCfLogisticsTaskLog = new CfLogisticsTaskLog();
            updateCfLogisticsTaskLog.setId(id);
            updateCfLogisticsTaskLog.setLogisticsStorehouseId(cfLogisticsTaskLogList.get(0).getLogisticsStorehouseId());
            updateCfLogisticsTaskLog.setLogisticsPlatformId(cfLogisticsTaskLogList.get(0).getLogisticsPlatformId());
            cfLogisticsTaskLogQuery.setOrderBy(null);
            cfLogisticsTaskLogQuery.setPage(null);
            cfLogisticsTaskLogQuery.setSize(null);
            if(cfLogisticsTaskLog.getEmergencyLevel()==(byte)1 && cfLogisticsTaskLogList.get(0).getQueueIndex().intValue()==1){
                //该组数据整体向下平移1个序号
                cfLogisticsTaskLogQuery.setEmergencyLevel(null);
                //当前预约记录顺序放到第一位
                cfLogisticsTaskLogQuery.setQueueIndexChangeValue((short)1);
                cfLogisticsTaskLogMapper.increaseQueueIndex(cfLogisticsTaskLogQuery);
                updateCfLogisticsTaskLog.setQueueIndex((short) 1);
                update(updateCfLogisticsTaskLog);
            }else if(cfLogisticsTaskLog.getEmergencyLevel()==(byte)0 && cfLogisticsTaskLogList.get(0).getEmergencyLevel().byteValue()==(byte)1){
                //普通排队整体往下移动一位
                cfLogisticsTaskLog.setEmergencyLevel((byte)0);
                cfLogisticsTaskLogQuery.setQueueIndexChangeValue((short)1);
                cfLogisticsTaskLogMapper.increaseQueueIndex(cfLogisticsTaskLogQuery);
                //当前预约记录顺序放到第一位
                updateCfLogisticsTaskLog.setQueueIndex((short)(cfLogisticsTaskLogList.get(0).getQueueIndex().intValue()+1));
                update(updateCfLogisticsTaskLog);
            }else if(cfLogisticsTaskLog.getEmergencyLevel()==(byte)0){
                //队列中，所有队列都是普通队列，普通排队整体往下移动一位
                cfLogisticsTaskLog.setEmergencyLevel((byte)0);
                cfLogisticsTaskLogQuery.setQueueIndexChangeValue((short)1);
                cfLogisticsTaskLogMapper.increaseQueueIndex(cfLogisticsTaskLogQuery);
                //当前预约记录顺序放到第一位
                updateCfLogisticsTaskLog.setQueueIndex(cfLogisticsTaskLogList.get(0).getQueueIndex());
                update(updateCfLogisticsTaskLog);
            }else{
                //紧急任务直接往前移动一位
                updateCfLogisticsTaskLog.setQueueIndex((short)(cfLogisticsTaskLogList.get(0).getQueueIndex().intValue()-1));
                update(updateCfLogisticsTaskLog);
            }
        }
    }

    @Override
    public CfLogisticsTaskLog changeQueuingArea(Long id, Long queuingAreaId) throws Exception {
        CfLogisticsTaskLog cfLogisticsTaskLog = findById(id, false);
        if(queuingAreaId.longValue()==cfLogisticsTaskLog.getQueuingAreaId().longValue()){
            //不能换到原来队列，无意义
            return null;
        }
        CfLogisticsTaskLog updateCfLogisticsTaskLog = new CfLogisticsTaskLog();
        updateCfLogisticsTaskLog.setId(id);
        updateCfLogisticsTaskLog.setQueuingAreaId(queuingAreaId);

        CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        cfLogisticsTaskLogQuery.setQueuingAreaId(queuingAreaId);
        cfLogisticsTaskLogQuery.setTaskLogStatus((byte)2);
        cfLogisticsTaskLogQuery.setEmergencyLevel(cfLogisticsTaskLog.getEmergencyLevel());
        cfLogisticsTaskLogQuery.setOrderBy("queue_index desc");
        cfLogisticsTaskLogQuery.setPage(1);
        cfLogisticsTaskLogQuery.setSize(1);
        List<CfLogisticsTaskLog> cfLogisticsTaskLogList = getListByQuery(cfLogisticsTaskLogQuery);
        if(cfLogisticsTaskLogList==null || cfLogisticsTaskLogList.size()==0){
            //说明新的队列此类型任务前面没车
            if(cfLogisticsTaskLog.getEmergencyLevel()==(byte)0){
                //查看前面有没有紧急任务
                cfLogisticsTaskLogQuery.setEmergencyLevel((byte)1);
                cfLogisticsTaskLogList = getListByQuery(cfLogisticsTaskLogQuery);
                if(cfLogisticsTaskLogList==null || cfLogisticsTaskLogList.size()==0){
                    updateCfLogisticsTaskLog.setQueueIndex((short)1);
                }else{
                    //排到紧急任务后面
                    updateCfLogisticsTaskLog.setQueueIndex(new Integer(cfLogisticsTaskLogList.get(0).getQueueIndex().intValue()+1).shortValue());
                }
            }else{
                //普通队列整理偏移一位
                cfLogisticsTaskLogQuery.setOrderBy(null);
                cfLogisticsTaskLogQuery.setPage(null);
                cfLogisticsTaskLogQuery.setSize(null);
                cfLogisticsTaskLog.setEmergencyLevel((byte)0);
                cfLogisticsTaskLogQuery.setQueueIndexChangeValue((short)1);
                cfLogisticsTaskLogMapper.increaseQueueIndex(cfLogisticsTaskLogQuery);
                //紧急任务从前面开始排队
                updateCfLogisticsTaskLog.setQueueIndex((short)1);
            }
        }else{
            //说明新的队列此类型任务前面有车
            if(cfLogisticsTaskLogList.get(0).getEmergencyLevel()==(byte)1){
                //普通队列整理偏移一位
                cfLogisticsTaskLogQuery.setOrderBy(null);
                cfLogisticsTaskLogQuery.setPage(null);
                cfLogisticsTaskLogQuery.setSize(null);
                cfLogisticsTaskLog.setEmergencyLevel((byte)0);
                cfLogisticsTaskLogQuery.setQueueIndexChangeValue((short)1);
                cfLogisticsTaskLogMapper.increaseQueueIndex(cfLogisticsTaskLogQuery);
                //紧急队列放到紧急任务后面一位
                updateCfLogisticsTaskLog.setQueueIndex(new Integer(cfLogisticsTaskLogList.get(0).getQueueIndex().intValue()+1).shortValue());
            }else if(cfLogisticsTaskLogList.get(0).getEmergencyLevel()==(byte)0){
                updateCfLogisticsTaskLog.setQueueIndex(new Integer(cfLogisticsTaskLogList.get(0).getQueueIndex().intValue()+1).shortValue());
            }
        }
        update(updateCfLogisticsTaskLog);

        if(cfLogisticsTaskLog.getTaskLogStatus()>=2){
            //刷新它原来的排队区域led大屏
            flushLesScreenData(cfLogisticsTaskLog.getQueuingAreaId());
            //刷新它现在的排队区域led大屏
            flushLesScreenData(queuingAreaId);
        }

        cfLogisticsTaskLog.setQueuingAreaId(queuingAreaId);
        cfLogisticsTaskLog.setQueueIndex(updateCfLogisticsTaskLog.getQueueIndex());
        return cfLogisticsTaskLog;
    }

    @Override
    public void numberOver(CfLogisticsTaskLog cfLogisticsTaskLog, boolean wXinNotice) throws Exception {
        CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        cfLogisticsTaskLogQuery.setMinQueueIndex((short)(cfLogisticsTaskLog.getQueueIndex()+(short)1));
        cfLogisticsTaskLogQuery.setOrderBy("queue_index asc");
        cfLogisticsTaskLogQuery.setPage(1);
        cfLogisticsTaskLogQuery.setSize(1);
        List<CfLogisticsTaskLog> cfLogisticsTaskLogList = getListByQuery(cfLogisticsTaskLogQuery);
        //找到第二个
        if(cfLogisticsTaskLogList!=null && cfLogisticsTaskLogList.size()>0){
            //交换顺序
            CfLogisticsTaskLog updateLogisticsTaskLog = new CfLogisticsTaskLog();
            updateLogisticsTaskLog.setId(cfLogisticsTaskLog.getId());
            updateLogisticsTaskLog.setQueueIndex(cfLogisticsTaskLogList.get(0).getQueueIndex());
            update(updateLogisticsTaskLog);
            updateLogisticsTaskLog.setId(cfLogisticsTaskLogList.get(0).getId());
            updateLogisticsTaskLog.setQueueIndex(cfLogisticsTaskLog.getQueueIndex());
            updateLogisticsTaskLog.setLogisticsStorehouseId(cfLogisticsTaskLog.getLogisticsStorehouseId());
            updateLogisticsTaskLog.setLogisticsPlatformId(cfLogisticsTaskLog.getLogisticsPlatformId());
            update(updateLogisticsTaskLog);
        }
        //通知第一个预约已经过号
        if(wXinNotice){
            noticeDirverNumberOver(cfLogisticsTaskLog);
        }
    }

    @Override
    public String flushLesScreenData(Long queuingAreaId) throws Exception {

        CfLogisticsQueuingArea cfLogisticsQueuingArea = cfLogisticsQueuingAreaService.findById(queuingAreaId);
        List<CfLogisticsQueuingArea> cfLogisticsQueuingAreaList = null;
        if(cfLogisticsQueuingArea==null){
            return "指定的队列不存在";
        }
        if(StringUtils.isNotEmpty(cfLogisticsQueuingArea.getGroupFlag())){
            //说明存在多队列共用一块led大屏的情况
            CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery = new CfLogisticsQueuingAreaQuery();
            cfLogisticsQueuingAreaQuery.setGroupFlag(cfLogisticsQueuingArea.getGroupFlag());
            cfLogisticsQueuingAreaQuery.setOrderBy("sort_index asc");
            cfLogisticsQueuingAreaList = cfLogisticsQueuingAreaService.getListByQuery(cfLogisticsQueuingAreaQuery);
        }
        //先找到对应设备
        CfLogisticsLedDeviceQuery cfLogisticsLedDeviceQuery = new CfLogisticsLedDeviceQuery();
        cfLogisticsLedDeviceQuery.setQueuingAreaId(queuingAreaId);
        cfLogisticsLedDeviceQuery.setOrderBy("index_no asc");
        List<CfLogisticsLedDevice> cfLogisticsLedDeviceList = cfLogisticsLedDeviceService.getListByQuery(cfLogisticsLedDeviceQuery);
        if(cfLogisticsLedDeviceList==null || cfLogisticsLedDeviceList.size()==0){
            return "没有找到led主板";
        }
        //找到正在排队的车辆
        CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
        cfLogisticsTaskLogQuery.setQueuingAreaId(queuingAreaId);
        cfLogisticsTaskLogQuery.setTaskLogStatus((byte)2);
        cfLogisticsTaskLogQuery.setOrderBy("queue_index asc");
        cfLogisticsTaskLogQuery.setPage(1);
        if(StringUtils.isNotEmpty(cfLogisticsQueuingArea.getGroupFlag())){
            cfLogisticsTaskLogQuery.setSize(5);
        }else{
            cfLogisticsTaskLogQuery.setSize(10);
        }
        List<CfLogisticsTaskLog> cfLogisticsTaskLogList = getListByQuery(cfLogisticsTaskLogQuery);
        if(StringUtils.isNotEmpty(cfLogisticsQueuingArea.getGroupFlag()) && cfLogisticsQueuingAreaList!=null && cfLogisticsQueuingAreaList.size()>1){
            //查询第二队列数据
            cfLogisticsTaskLogQuery.setQueuingAreaId(cfLogisticsQueuingAreaList.get(1).getId());
            List<CfLogisticsTaskLog> cfLogisticsTaskLogList2 = getListByQuery(cfLogisticsTaskLogQuery);
            if(cfLogisticsTaskLogList2!=null || cfLogisticsTaskLogList2.size()>0){
                if(cfLogisticsTaskLogList.size()<5){
                    for(int i=0; i<5-cfLogisticsTaskLogList.size(); i++){
                        //给其加入空排队信息进行占位
                        CfLogisticsTaskLog nullCfLogisticsTaskLog = new CfLogisticsTaskLog();
                        nullCfLogisticsTaskLog.setQueueIndex((short)(cfLogisticsTaskLogList.size()+1));
                        nullCfLogisticsTaskLog.setNumberPlate("       ");
                        cfLogisticsTaskLogList.add(nullCfLogisticsTaskLog);
                    }
                }
                for (CfLogisticsTaskLog cfLogisticsTaskLog: cfLogisticsTaskLogList2){
                    cfLogisticsTaskLogList.add(cfLogisticsTaskLog);
                }
            }
        }
        if(cfLogisticsTaskLogList==null || cfLogisticsTaskLogList.size()==0){
            int nunnIndex = 0;
            for (CfLogisticsLedDevice cfLogisticsLedDevice: cfLogisticsLedDeviceList){
                //【文本列表】
                ArrayList<CfLinXinLedArea> cfLinXinLedAreaArrayList = new ArrayList<>();
                //文本1
                String palyContents = "";
                if(nunnIndex==0){
                    if(cfLogisticsQueuingAreaList==null || cfLogisticsQueuingAreaList.size()<2){
                        //单队列
                        palyContents = "          "+cfLogisticsQueuingArea.getAreaName();
                    }else{
                        //双队列
                        palyContents = "  "+cfLogisticsQueuingAreaList.get(0).getAreaName()+"    "+cfLogisticsQueuingAreaList.get(1).getAreaName();
                    }
                }
                cfLinXinLedAreaArrayList.add(new CfLinXinLedArea(1, 0, 0, 256, 48, 1, 16, 16, 0, 1, 4, 3, 0, 0, 256, 48, 1, 9, 0, palyContents));
                //【节目】
                //节目1
                CfLinXinLedProgram cfLinXinLedProgram = new CfLinXinLedProgram(0, 0, 1, cfLinXinLedAreaArrayList);
                //【第一个主板内容】
                ArrayList<CfLinXinLedProgram> cfLinXinLedProgramArrayList = new ArrayList<>();
                cfLinXinLedProgramArrayList.add(cfLinXinLedProgram);
                CfLinXinLed cfLinXinLed = new CfLinXinLed(256, 48, 1, 5, 2, cfLinXinLedProgramArrayList);
                try {
                    cfLogisticsLedDeviceService.sendTcpData(cfLogisticsLedDevice.getSerialNumber(), cfLinXinLed);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                nunnIndex++;
            }
            return "当前无车辆排队";
        }

        //二次制作要显示的数据 type: queueName-队列名称,car-车牌信息
        List<String> showContentsList = new ArrayList<>();
        int index = 0;
        for(CfLogisticsTaskLog cfLogisticsTaskLog: cfLogisticsTaskLogList){
//            if(index>loopTImes){
//                break;
//            }
            if(index==0){
                //装入队列名和部分车牌信息
                if(cfLogisticsTaskLogList.size()>(index+5)){
                    //右边有内容显示
                    showContentsList.add("          "+cfLogisticsQueuingArea.getAreaName()+"             "+ StringTools.preMakeUp("0",+cfLogisticsTaskLogList.get(index).getQueueIndex()+"",2) +" "+cfLogisticsTaskLogList.get(index).getNumberPlate()+"     "+StringTools.preMakeUp("0",+cfLogisticsTaskLogList.get(index+5).getQueueIndex()+"",2)+" "+cfLogisticsTaskLogList.get(index+5).getNumberPlate());
                }else{
                    //只显示左边
                    showContentsList.add("          "+cfLogisticsQueuingArea.getAreaName()+"             "+ StringTools.preMakeUp("0",+cfLogisticsTaskLogList.get(index).getQueueIndex()+"",2)+" "+cfLogisticsTaskLogList.get(index).getNumberPlate());
                }
                index += 1;
            }else{
                if(cfLogisticsTaskLogList.size()<index+1){
                    break;
                }
                //装入车牌信息
                if(cfLogisticsTaskLogList.size()>(index+5)){
                    //右边有内容显示
                    String tempContents = "  "+StringTools.preMakeUp("0",+cfLogisticsTaskLogList.get(index).getQueueIndex()+"",2)+" "+cfLogisticsTaskLogList.get(index).getNumberPlate()+"     "+StringTools.preMakeUp("0",+cfLogisticsTaskLogList.get(index+5).getQueueIndex()+"",2)+" "+cfLogisticsTaskLogList.get(index+5).getNumberPlate();
                    if(cfLogisticsTaskLogList.size()>(index+1)){
                        if(cfLogisticsTaskLogList.size()>(index+6)){
                            //右边有内容显示
                            tempContents += "     "+StringTools.preMakeUp("0",+cfLogisticsTaskLogList.get(index+1).getQueueIndex()+"",2)+" "+cfLogisticsTaskLogList.get(index+1).getNumberPlate()+"     "+StringTools.preMakeUp("0",+cfLogisticsTaskLogList.get(index+6).getQueueIndex()+"",2)+" "+cfLogisticsTaskLogList.get(index+6).getNumberPlate();
                        }else{
                            //只显示左边
                            tempContents += "     "+StringTools.preMakeUp("0",+cfLogisticsTaskLogList.get(index+1).getQueueIndex()+"",2)+" "+cfLogisticsTaskLogList.get(index+1).getNumberPlate()+"                ";
                        }
                    }
                    showContentsList.add(tempContents);
                }else{
                    //只显示左边
                    String tempContents = "  "+StringTools.preMakeUp("0",+cfLogisticsTaskLogList.get(index).getQueueIndex()+"",2)+" "+cfLogisticsTaskLogList.get(index).getNumberPlate()+"      ";
                    if(cfLogisticsTaskLogList.size()>(index+1)){
                        tempContents += "               "+StringTools.preMakeUp("0",+cfLogisticsTaskLogList.get(index+1).getQueueIndex()+"",2)+" "+cfLogisticsTaskLogList.get(index+1).getNumberPlate();
                    }
                    showContentsList.add(tempContents);
                }
                index += 2;
            }
        }

        int deviceIndex = 0;
        for (CfLogisticsLedDevice cfLogisticsLedDevice: cfLogisticsLedDeviceList){
            //【文本列表】
            ArrayList<CfLinXinLedArea> cfLinXinLedAreaArrayList = new ArrayList<>();
            //文本1
            String palyContents = "";
            if(deviceIndex+1<=showContentsList.size()){
                palyContents = showContentsList.get(deviceIndex);
            }
            cfLinXinLedAreaArrayList.add(new CfLinXinLedArea(1, 0, 0, 256, 48, 1, 16, 16, 0, 1, 4, 3, 0, 0, 256, 48, 1, 9, 0, palyContents));
            //【节目】
            //节目1
            CfLinXinLedProgram cfLinXinLedProgram = new CfLinXinLedProgram(0, 0, 1, cfLinXinLedAreaArrayList);
            //【第一个主板内容】
            ArrayList<CfLinXinLedProgram> cfLinXinLedProgramArrayList = new ArrayList<>();
            cfLinXinLedProgramArrayList.add(cfLinXinLedProgram);
            CfLinXinLed cfLinXinLed = new CfLinXinLed(256, 48, 1, 5, 2, cfLinXinLedProgramArrayList);
            try {
                cfLogisticsLedDeviceService.sendTcpData(cfLogisticsLedDevice.getSerialNumber(), cfLinXinLed);
            } catch (Exception e) {
                e.printStackTrace();
            }
            deviceIndex++;
        }
        return "刷新内容成功";
    }
}
