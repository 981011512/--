package com.cf.logistics.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.logistics.LogisticsCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.dao.mapper.CfLogisticsTaskMapper;
import com.cf.logistics.domain.CfLogisticsTask;
import com.cf.logistics.domain.CfLogisticsTaskExample;
import com.cf.logistics.domain.CfLogisticsTaskLog;
import com.cf.logistics.domain.request.CfLogisticsTaskLogQuery;
import com.cf.logistics.domain.request.CfLogisticsTaskQuery;
import com.cf.logistics.service.CfLogisticsTaskLogService;
import com.cf.logistics.service.CfLogisticsTaskService;
import com.cf.ucenter.domain.CfThirdPartyLogin;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserDriverLicense;
import com.cf.ucenter.request.CfUserDriverLicenseQuery;
import com.cf.ucenter.service.CfUserDriverLicenseService;
import com.cf.ucenter.service.CfUserService;
import com.cf.ucenter.type.ThirdPartyPlatformType;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsTaskServiceImpl implements CfLogisticsTaskService {

    @Autowired
    private CfLogisticsTaskMapper cfLogisticsTaskMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfLogisticsTaskLogService cfLogisticsTaskLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserDriverLicenseService cfUserDriverLicenseService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;

    @Override
    public CfLogisticsTask add(CfLogisticsTask cfLogisticsTask) throws Exception {
        if(cfLogisticsTask.getId()==null){
            cfLogisticsTask.setId(idWorker.nextLongId());
        }
        if(cfLogisticsTask.getVehiclesRequired()==null || cfLogisticsTask.getVehiclesRequired().shortValue()==(short)0){
            cfLogisticsTask.setVehiclesRequired((short)01);
        }
        if(cfLogisticsTask.getPid()==null || cfLogisticsTask.getPid().longValue()==0){
            cfLogisticsTask.setSortIndex(1);
        }else{
            //查询其名下子任务，方便给最大序号
            CfLogisticsTaskQuery cfLogisticsTaskQuery = new CfLogisticsTaskQuery();
            cfLogisticsTaskQuery.setPid(cfLogisticsTask.getPid());
            cfLogisticsTask.setSortIndex(countByQuery(cfLogisticsTaskQuery).intValue()+2);
        }
        cfLogisticsTask.setCreateTime(System.currentTimeMillis());
        cfLogisticsTask.setUpdateTime(System.currentTimeMillis());
        cfLogisticsTaskMapper.insertSelective(cfLogisticsTask);
        updateChildrenTaskCounts(cfLogisticsTask);
        automaticReservationData(cfLogisticsTask);
        return cfLogisticsTask;
    }

    @Override
    public void automaticReservationData(CfLogisticsTask cfLogisticsTask) throws Exception {
        if(StringUtils.isEmpty(cfLogisticsTask.getVehicleName()) || StringUtils.isEmpty(cfLogisticsTask.getDriverName()) || StringUtils.isEmpty(cfLogisticsTask.getDriverTel())){
            return;
        }
        CfUser cfUser = null;
        //查询对应的司机是否存在
        cfUser = cfUserService.findByPhone(cfLogisticsTask.getDriverTel());
        if(cfUser==null){
            //如果司机不存在，创建对应的司机
            CfUserDriverLicense cfUserDriverLicense = new CfUserDriverLicense();
            cfUserDriverLicense.setUid("");
            cfUserDriverLicense.setUserName(cfLogisticsTask.getDriverName());
            cfUserDriverLicense.setSex((byte)2);
            cfUserDriverLicense.setNationality("");
            cfUserDriverLicense.setAddress("");
            cfUserDriverLicense.setBirthdayYear((short)0);
            cfUserDriverLicense.setBirthdayMonth((byte)0);
            cfUserDriverLicense.setBirthdayDay((byte)0);
            cfUserDriverLicense.setFirstIssueYear((short)0);
            cfUserDriverLicense.setFirstIssueMonth((byte)0);
            cfUserDriverLicense.setFirstIssueDay((byte)0);
            cfUserDriverLicense.setCarClass("");
            cfUserDriverLicense.setStartTime(0l);
            cfUserDriverLicense.setEndTime(0l);
            cfUserDriverLicense.setCertificateNumber("");
            cfUserDriverLicense.setIssuingAuthority("");
            cfUserDriverLicense.setFileNumber("");
            cfUserDriverLicense.setInternshipPeriodEnds(0l);
            cfUserDriverLicense.setCheckStatus((byte)1);
            cfUserDriverLicense.setPhone(cfLogisticsTask.getDriverTel());
            cfUserDriverLicense.setQualificationCertificateNumber("");

            cfUser = new CfUser();

            //判断是否存在重复的手机号
            CfUserDriverLicenseQuery cfUserDriverLicenseQuery = new CfUserDriverLicenseQuery();
            cfUserDriverLicenseQuery.setPhone(cfLogisticsTask.getDriverTel());
            List<CfUserDriverLicense> driverLicenseList = cfUserDriverLicenseService.getListByQuery(cfUserDriverLicenseQuery);
            if(driverLicenseList!=null && driverLicenseList.size()>0){
                cfUserDriverLicense.setId(driverLicenseList.get(0).getId());
                cfUserDriverLicenseService.update(cfUserDriverLicense);
                cfUser.setId(driverLicenseList.get(0).getUid());
                cfUser.setTrueName(driverLicenseList.get(0).getUserName());
            }else{
                cfUserDriverLicenseService.add(cfUserDriverLicense);
                cfUser.setId(cfUserDriverLicense.getUid());
                cfUser.setTrueName(cfUserDriverLicense.getUserName());
            }
        }

        if(!cfLogisticsTask.getDriverName().equals(cfUser.getTrueName())){
            return;
        }
        //走预约流程
        cfLogisticsTaskLogService.reserveTask(cfUser.getId(), cfLogisticsTask.getId(), cfLogisticsTask.getVehicleName(), cfLogisticsTask.getWaybillNumber(),"");
    }

    @Override
    public CfLogisticsTask update(CfLogisticsTask cfLogisticsTask) {
        cfLogisticsTask.setUpdateTime(System.currentTimeMillis());
        if(cfLogisticsTask.getVehiclesRequired()==null || cfLogisticsTask.getVehiclesRequired().shortValue()==(short)0){
            cfLogisticsTask.setVehiclesRequired((short)01);
        }
        cfLogisticsTaskMapper.updateByPrimaryKeySelective(cfLogisticsTask);
        if(cfLogisticsTask.getPid()==null){
            CfLogisticsTask logisticsTask = findById(cfLogisticsTask.getId());
            cfLogisticsTask.setPid(logisticsTask.getPid());
        }
        updateChildrenTaskCounts(cfLogisticsTask);
        return cfLogisticsTask;
    }

    @Override
    public int updateByQuery(CfLogisticsTask cfLogisticsTask, CfLogisticsTaskQuery cfLogisticsTaskQuery) {
        cfLogisticsTask.setUpdateTime(System.currentTimeMillis());
        return cfLogisticsTaskMapper.updateByExampleSelective(cfLogisticsTask,getExampleByQuery(cfLogisticsTaskQuery));
    }

    @Override
    public int updateChildrenTaskCounts(CfLogisticsTask cfLogisticsTask) {
        CfLogisticsTaskQuery cfLogisticsTaskQuery = new CfLogisticsTaskQuery();

        if(cfLogisticsTask.getPid()==null || cfLogisticsTask.getPid().longValue()==0l){
            cfLogisticsTaskQuery.setPid(cfLogisticsTask.getId());

        }else{
            cfLogisticsTaskQuery.setPid(cfLogisticsTask.getPid());
        }
        Integer children = countByQuery(cfLogisticsTaskQuery);
        CfLogisticsTask updateCfLogisticsTask = new CfLogisticsTask();
        updateCfLogisticsTask.setId(cfLogisticsTaskQuery.getPid());
        updateCfLogisticsTask.setChildrenTaskCounts(children.byteValue());
        return cfLogisticsTaskMapper.updateByPrimaryKeySelective(updateCfLogisticsTask);
    }

    @Override
    public int delete(Long id) {
        int i = cfLogisticsTaskMapper.deleteByPrimaryKey(id);
        if(i>0){
            //删除其它对应的预约记录
            CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
            cfLogisticsTaskLogQuery.setTaskId(id);
            cfLogisticsTaskLogService.deleteByQuery(cfLogisticsTaskLogQuery);
        }
        return i;
    }

    @Override
    public int deleteByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery) {
        List<CfLogisticsTask> cfLogisticsTasks = getListByQuery(cfLogisticsTaskQuery);
        List<Long> taskIds = new ArrayList<>();
        if(cfLogisticsTasks!=null && cfLogisticsTasks.size()>0){
            for(CfLogisticsTask cfLogisticsTask: cfLogisticsTasks){
                taskIds.add(cfLogisticsTask.getId());
            }
        }
        int i = cfLogisticsTaskMapper.deleteByExample(getExampleByQuery(cfLogisticsTaskQuery));
        if(i>0){
            //删除其它对应的预约记录
            CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
            cfLogisticsTaskLogQuery.setTaskIds(taskIds);
            cfLogisticsTaskLogService.deleteByQuery(cfLogisticsTaskLogQuery);
        }
        return i;
    }

    @Override
    public CfLogisticsTask findById(Long id) {
        return cfLogisticsTaskMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsTask findById(Long id, boolean expectEmpty) {
        CfLogisticsTask cfLogisticsTask = findById(id);
        if(expectEmpty && cfLogisticsTask!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsTask==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsTask;
    }

    @Override
    public List<CfLogisticsTask> getListByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery) {
        return cfLogisticsTaskMapper.selectByExample(getExampleByQuery(cfLogisticsTaskQuery));
    }

    @Override
    public List<CfLogisticsTask> selectListByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery) {
        ArrayList<String> allowOrderBy = new ArrayList<>();
        allowOrderBy.add("lgshts.task_status asc");
        allowOrderBy.add("lgshts.task_status desc");
        allowOrderBy.add("lgshts.emergency_level asc");
        allowOrderBy.add("lgshts.emergency_level desc");
        allowOrderBy.add("lgshts.start_time asc");
        allowOrderBy.add("lgshts.start_time desc");
        cfLogisticsTaskQuery.setOrderBy(DbUtils.makeAllowOrderBy(allowOrderBy,cfLogisticsTaskQuery.getOrderBy()));
        return cfLogisticsTaskMapper.selectListByQuery(cfLogisticsTaskQuery);
    }

    @Override
    public Integer countByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery) {
        cfLogisticsTaskQuery.setPage(null);
        cfLogisticsTaskQuery.setOrderBy(null);
        return cfLogisticsTaskMapper.countByExample(getExampleByQuery(cfLogisticsTaskQuery));
    }

    @Override
    public CfLogisticsTaskExample getExampleByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery) {
        CfLogisticsTaskExample cfLogisticsTaskExample = new CfLogisticsTaskExample();
        CfLogisticsTaskExample.Criteria criteria = cfLogisticsTaskExample.createCriteria();

        if(cfLogisticsTaskQuery.getIds()!=null && cfLogisticsTaskQuery.getIds().size()>0){
            criteria.andIdIn(cfLogisticsTaskQuery.getIds());
        }
        if(cfLogisticsTaskQuery.getPid()!=null){
            criteria.andPidEqualTo(cfLogisticsTaskQuery.getPid());
        }
        if(cfLogisticsTaskQuery.getMinCreateTime()!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfLogisticsTaskQuery.getMinCreateTime());
        }
        if(cfLogisticsTaskQuery.getMaxCreateTime()!=null){
            criteria.andCreateTimeLessThanOrEqualTo(cfLogisticsTaskQuery.getMaxCreateTime());
        }

        if(cfLogisticsTaskQuery.getMinStartTime()!=null){
            criteria.andStartTimeGreaterThanOrEqualTo(cfLogisticsTaskQuery.getMinStartTime());
        }
        if(cfLogisticsTaskQuery.getMaxStartTime()!=null){
            criteria.andStartTimeLessThanOrEqualTo(cfLogisticsTaskQuery.getMaxStartTime());
        }

        if(cfLogisticsTaskQuery.getMinEndTime()!=null){
            criteria.andEndTimeGreaterThanOrEqualTo(cfLogisticsTaskQuery.getMinEndTime());
        }
        if(cfLogisticsTaskQuery.getMaxEndTime()!=null){
            criteria.andEndTimeLessThanOrEqualTo(cfLogisticsTaskQuery.getMaxEndTime());
        }

        if(cfLogisticsTaskQuery.getCargoType()!=null){
            criteria.andCargoTypeEqualTo(cfLogisticsTaskQuery.getCargoType());
        }
        if(cfLogisticsTaskQuery.getCarType()!=null){
            criteria.andCarTypeEqualTo(cfLogisticsTaskQuery.getCarType());
        }
        if(cfLogisticsTaskQuery.getWaybillNumber()!=null){
            criteria.andWaybillNumberEqualTo(cfLogisticsTaskQuery.getWaybillNumber());
        }
        if(cfLogisticsTaskQuery.getEmergencyLevel()!=null){
            criteria.andEmergencyLevelEqualTo(cfLogisticsTaskQuery.getEmergencyLevel());
        }
        if(cfLogisticsTaskQuery.getLogisticsStorehouseId()!=null){
            criteria.andLogisticsStorehouseIdEqualTo(cfLogisticsTaskQuery.getLogisticsStorehouseId());
        }
        if(cfLogisticsTaskQuery.getFactoryId()!=null){
            criteria.andFactoryIdEqualTo(cfLogisticsTaskQuery.getFactoryId());
        }
        if(cfLogisticsTaskQuery.getLogisticsStorehouseIds()!=null){
            criteria.andLogisticsStorehouseIdIn(cfLogisticsTaskQuery.getLogisticsStorehouseIds());
        }
        if(cfLogisticsTaskQuery.getSortIndex()!=null){
            criteria.andSortIndexEqualTo(cfLogisticsTaskQuery.getSortIndex());
        }

        if(StringUtils.isNotEmpty(cfLogisticsTaskQuery.getOrderBy())){
            cfLogisticsTaskExample.setOrderByClause(cfLogisticsTaskQuery.getOrderBy());
        }
        if(cfLogisticsTaskQuery.getPage()!=null && cfLogisticsTaskQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsTaskQuery.getPage(), cfLogisticsTaskQuery.getSize());
        }
        return cfLogisticsTaskExample;
    }

    @Override
    public Integer updateReservedVehicles(Long id, short value) {
        return cfLogisticsTaskMapper.updateReservedVehicles(id, value);
    }

    @Override
    public void changeSortIndex(Long taskId, Integer sortIndex) throws Exception {
        CfLogisticsTask cfLogisticsTask = findById(taskId, false);
        if(cfLogisticsTask.getSortIndex().intValue()==sortIndex.intValue()){
            //自己切换自己序号，无意义，不做任何处理
            return;
        }
        if(cfLogisticsTask.getPid()==0l){
            ExceptionCast.cast(LogisticsCode.ONLY_CHILD_DATA_CAN_BE_OPERATED);
        }
        if(sortIndex.intValue()==1){
            //说明是子任务要放到主任务位置
            //找到父任务
            CfLogisticsTask parentCfLogisticsTask = findById(cfLogisticsTask.getPid(), false);
            //如果主任务对应的预约正在装卸货或者之后的状态，禁止切换
            CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
            cfLogisticsTaskLogQuery.setTaskId(cfLogisticsTask.getPid());
            List<CfLogisticsTaskLog> parentCfLogisticsTaskLogList = cfLogisticsTaskLogService.getListByQuery(cfLogisticsTaskLogQuery);
            if(parentCfLogisticsTaskLogList!=null && parentCfLogisticsTaskLogList.size()>0 && parentCfLogisticsTaskLogList.get(0).getTaskLogStatus().byteValue()>=(byte)3){
                ExceptionCast.cast(LogisticsCode.PROHIBIT_SWITCHING_ORDER);
            }
            cfLogisticsTaskLogQuery.setTaskId(taskId);
            List<CfLogisticsTaskLog> currentCfLogisticsTaskLogList = cfLogisticsTaskLogService.getListByQuery(cfLogisticsTaskLogQuery);
            if(currentCfLogisticsTaskLogList!=null && currentCfLogisticsTaskLogList.size()>0 && parentCfLogisticsTaskLogList.get(0).getTaskLogStatus().byteValue()==(byte)2){
                //切换两者的预约排队顺序
                CfLogisticsTaskLog updateCfLogisticsTaskLog = new CfLogisticsTaskLog();
                updateCfLogisticsTaskLog.setId(parentCfLogisticsTaskLogList.get(0).getId());
                updateCfLogisticsTaskLog.setPid(currentCfLogisticsTaskLogList.get(0).getId());
                updateCfLogisticsTaskLog.setQueueIndex(currentCfLogisticsTaskLogList.get(0).getQueueIndex());
                cfLogisticsTaskLogService.update(updateCfLogisticsTaskLog);
                updateCfLogisticsTaskLog.setId(currentCfLogisticsTaskLogList.get(0).getId());
                updateCfLogisticsTaskLog.setPid(0l);
                updateCfLogisticsTaskLog.setQueueIndex(parentCfLogisticsTaskLogList.get(0).getQueueIndex());
                cfLogisticsTaskLogService.update(updateCfLogisticsTaskLog);
            }
            //其它所有子预约父任务都指向当前预约
            if(currentCfLogisticsTaskLogList!=null && currentCfLogisticsTaskLogList.size()>0){
                CfLogisticsTaskLog updateCfLogisticsTaskLog = new CfLogisticsTaskLog();
                updateCfLogisticsTaskLog.setPid(currentCfLogisticsTaskLogList.get(0).getId());
                CfLogisticsTaskLogQuery logisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
                logisticsTaskLogQuery.setPid(parentCfLogisticsTaskLogList.get(0).getId());
                cfLogisticsTaskLogService.updateByQuery(updateCfLogisticsTaskLog, logisticsTaskLogQuery);
            }

            //主任务变为子任务，子任务变为主任务
            CfLogisticsTask updateCfLogisticsTask = new CfLogisticsTask();
            updateCfLogisticsTask.setId(cfLogisticsTask.getPid());
            updateCfLogisticsTask.setPid(taskId);
            updateCfLogisticsTask.setChildrenTaskCounts((byte)0);
            updateCfLogisticsTask.setSortIndex(cfLogisticsTask.getSortIndex());
            update(updateCfLogisticsTask);

            updateCfLogisticsTask.setId(taskId);
            updateCfLogisticsTask.setPid(0l);
            updateCfLogisticsTask.setChildrenTaskCounts(parentCfLogisticsTask.getChildrenTaskCounts());
            updateCfLogisticsTask.setSortIndex(1);
            update(updateCfLogisticsTask);

            //将其它子任务主任务全部指向已经排到第一位的主任务
            CfLogisticsTaskQuery cfLogisticsTaskQuery = new CfLogisticsTaskQuery();
            cfLogisticsTaskQuery.setPid(cfLogisticsTask.getPid());

            updateCfLogisticsTask.setId(null);
            updateCfLogisticsTask.setPid(taskId);
            updateCfLogisticsTask.setChildrenTaskCounts(null);
            updateCfLogisticsTask.setSortIndex(null);

            updateByQuery(updateCfLogisticsTask, cfLogisticsTaskQuery);

            //看看是否需要刷新led大屏
            if(parentCfLogisticsTaskLogList!=null && parentCfLogisticsTaskLogList.size()>0 && parentCfLogisticsTaskLogList.get(0).getTaskLogStatus().byteValue()==(byte)2){
                if(parentCfLogisticsTaskLogList.get(0).getQueuingAreaId().longValue()>0l){
                    cfLogisticsTaskLogService.flushLesScreenData(parentCfLogisticsTaskLogList.get(0).getQueuingAreaId());
                    //给子任务找到相应的队列并排队，通知司机前往对应的排队区进行排队(noticeDirverQueueOrDriverLoadingOrUnloading该方法已带刷新对应队列led)
                    cfLogisticsTaskLogService.noticeDirverQueueOrDriverLoadingOrUnloading(currentCfLogisticsTaskLogList.get(0),"asc");
                }
            }
        }else{
            //子任务之间的任务切换
            //找到被替换的任务
            CfLogisticsTaskQuery cfLogisticsTaskQuery = new CfLogisticsTaskQuery();
            cfLogisticsTaskQuery.setSortIndex(sortIndex);
            cfLogisticsTaskQuery.setPid(cfLogisticsTask.getPid());
            List<CfLogisticsTask> replacedCfLogisticsTaskList = getListByQuery(cfLogisticsTaskQuery);
            if(replacedCfLogisticsTaskList==null || replacedCfLogisticsTaskList.size()==0){
                ExceptionCast.cast(LogisticsCode.TASK_SORT_INDEX_NOT_FOUND);
            }
            CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery = new CfLogisticsTaskLogQuery();
            cfLogisticsTaskLogQuery.setTaskId(replacedCfLogisticsTaskList.get(0).getId());
            List<CfLogisticsTaskLog> replacedCfLogisticsTaskLogList = cfLogisticsTaskLogService.getListByQuery(cfLogisticsTaskLogQuery);
            if(replacedCfLogisticsTaskLogList!=null && replacedCfLogisticsTaskLogList.size()>0){
                if(replacedCfLogisticsTaskLogList.get(0).getTaskLogStatus().byteValue()>=3){
                    ExceptionCast.cast(LogisticsCode.PROHIBIT_SWITCHING_ORDER);
                }
            }
            cfLogisticsTaskLogQuery.setTaskId(taskId);
            List<CfLogisticsTaskLog> currentCfLogisticsTaskLogList = cfLogisticsTaskLogService.getListByQuery(cfLogisticsTaskLogQuery);
            if(currentCfLogisticsTaskLogList!=null && currentCfLogisticsTaskLogList.size()>0){
                CfLogisticsTaskLog updateCfLogisticsTaskLog = new CfLogisticsTaskLog();
                updateCfLogisticsTaskLog.setId(replacedCfLogisticsTaskLogList.get(0).getId());
                updateCfLogisticsTaskLog.setQueueIndex(currentCfLogisticsTaskLogList.get(0).getQueueIndex());
                cfLogisticsTaskLogService.update(updateCfLogisticsTaskLog);

                updateCfLogisticsTaskLog.setId(currentCfLogisticsTaskLogList.get(0).getId());
                updateCfLogisticsTaskLog.setQueueIndex(replacedCfLogisticsTaskLogList.get(0).getQueueIndex());
                cfLogisticsTaskLogService.update(updateCfLogisticsTaskLog);
            }

            //开始替换
            CfLogisticsTask updateCfLogisticsTask = new CfLogisticsTask();
            updateCfLogisticsTask.setId(replacedCfLogisticsTaskList.get(0).getId());
            updateCfLogisticsTask.setSortIndex(cfLogisticsTask.getSortIndex());
            update(updateCfLogisticsTask);

            updateCfLogisticsTask.setId(taskId);
            updateCfLogisticsTask.setSortIndex(sortIndex);
            update(updateCfLogisticsTask);

            //看看是否需要刷新led大屏
            if((currentCfLogisticsTaskLogList!=null && currentCfLogisticsTaskLogList.size()>0 && currentCfLogisticsTaskLogList.get(0).getTaskLogStatus().byteValue()==(byte)2) || (replacedCfLogisticsTaskLogList!=null && replacedCfLogisticsTaskLogList.size()>0 && replacedCfLogisticsTaskLogList.get(0).getTaskLogStatus().byteValue()==(byte)2)){
                if(currentCfLogisticsTaskLogList.get(0).getTaskLogStatus().byteValue()==(byte)2 && currentCfLogisticsTaskLogList.get(0).getQueuingAreaId().longValue()>0l){
                    cfLogisticsTaskLogService.flushLesScreenData(currentCfLogisticsTaskLogList.get(0).getQueuingAreaId());
                    //给子任务找到相应的队列并排队，通知司机前往对应的排队区进行排队(noticeDirverQueueOrDriverLoadingOrUnloading该方法已带刷新对应队列led)
                    cfLogisticsTaskLogService.noticeDirverQueueOrDriverLoadingOrUnloading(replacedCfLogisticsTaskLogList.get(0),"asc");
                }else{
                    cfLogisticsTaskLogService.flushLesScreenData(replacedCfLogisticsTaskLogList.get(0).getQueuingAreaId());
                    //给子任务找到相应的队列并排队，通知司机前往对应的排队区进行排队(noticeDirverQueueOrDriverLoadingOrUnloading该方法已带刷新对应队列led)
                    cfLogisticsTaskLogService.noticeDirverQueueOrDriverLoadingOrUnloading(currentCfLogisticsTaskLogList.get(0),"asc");
                }
            }
        }
    }
}
