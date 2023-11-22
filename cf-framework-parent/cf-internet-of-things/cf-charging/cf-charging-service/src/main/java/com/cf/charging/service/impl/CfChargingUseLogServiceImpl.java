package com.cf.charging.service.impl;

import com.cf.charging.dao.mapper.CfChargingUseLogMapper;
import com.cf.charging.domain.CfChargingStationDevice;
import com.cf.charging.domain.CfChargingUseLog;
import com.cf.charging.domain.CfChargingUseLogExample;
import com.cf.charging.domain.request.CfChargingStationDeviceQuery;
import com.cf.charging.domain.request.CfChargingUseLogQuery;
import com.cf.charging.service.CfChargingStationDeviceService;
import com.cf.charging.service.CfChargingUseLogService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.service.CfOrderService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfChargingUseLogServiceImpl implements CfChargingUseLogService {

    @Autowired
    private CfChargingUseLogMapper cfChargingUseLogMapper;
    @Autowired
    private CfChargingStationDeviceService cfChargingStationDeviceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfChargingUseLog add(CfChargingUseLog cfChargingUseLog) {
        cfChargingUseLog.setId(idWorker.nextId());
        cfChargingUseLog.setStartTime(System.currentTimeMillis());
        cfChargingUseLogMapper.insertSelective(cfChargingUseLog);
        //新增充电账单
        CfOrder cfOrder = new CfOrder();
        cfOrder.setRandomId("");
        cfOrder.setUid(cfChargingUseLog.getUid());
        cfOrder.setGoodsName("新能源充电费用");
        cfOrder.setGoodsId(cfChargingUseLog.getId());
        cfOrder.setGoodsType(GoodsType.NEW_ENERGY_CHARGING);
        cfOrder.setShopId(cfChargingUseLog.getChargingStationId());
        cfOrder.setAmountsPayable(new BigDecimal(0.00));
        cfOrder.setAmountActuallyPaid(new BigDecimal(0.00));
        cfOrderService.add(cfOrder);
        return cfChargingUseLog;
    }

    @Override
    public CfChargingUseLog update(CfChargingUseLog cfChargingUseLog) {
        cfChargingUseLogMapper.updateByPrimaryKeySelective(cfChargingUseLog);
        return cfChargingUseLog;
    }

    @Override
    public Integer delete(String id) {
        int i = cfChargingUseLogMapper.deleteByPrimaryKey(id);
        if(i>0){
            //同时删除账单
            CfOrderQuery cfOrderQuery = new CfOrderQuery();
            cfOrderQuery.setGoodsId(id);
            cfOrderQuery.setGoodsType(GoodsType.NEW_ENERGY_CHARGING);
            cfOrderService.deleteByQuery(cfOrderQuery);
        }
        return i;
    }

    @Override
    public CfChargingUseLogExample getExampleByQuery(CfChargingUseLogQuery cfChargingUseLogQuery) {
        CfChargingUseLogExample cfChargingUseLogExample = new CfChargingUseLogExample();
        CfChargingUseLogExample.Criteria criteria = cfChargingUseLogExample.createCriteria();

        if(cfChargingUseLogQuery.getId()!=null){
            criteria.andIdEqualTo(cfChargingUseLogQuery.getId());
        }
        if(cfChargingUseLogQuery.getChargingStationId()!=null){
            criteria.andChargingStationIdEqualTo(cfChargingUseLogQuery.getChargingStationId());
        }
        if(cfChargingUseLogQuery.getChargingDeviceId()!=null){
            criteria.andChargingDeviceIdEqualTo(cfChargingUseLogQuery.getChargingDeviceId());
        }
        if(cfChargingUseLogQuery.getChargingPort()!=null){
            criteria.andChargingPortEqualTo(cfChargingUseLogQuery.getChargingPort());
        }
        if(cfChargingUseLogQuery.getUid()!=null){
            criteria.andUidEqualTo(cfChargingUseLogQuery.getUid());
        }
        if(cfChargingUseLogQuery.getStartTime()!=null){
            criteria.andStartTimeEqualTo(cfChargingUseLogQuery.getStartTime());
        }
        if(cfChargingUseLogQuery.getEndTime()!=null){
            criteria.andEndTimeEqualTo(cfChargingUseLogQuery.getEndTime());
        }
        if(cfChargingUseLogQuery.getMinStartTime()!=null){
            criteria.andStartTimeGreaterThanOrEqualTo(cfChargingUseLogQuery.getStartTime());
        }
        if(cfChargingUseLogQuery.getMaxStartTime()!=null){
            criteria.andStartTimeLessThanOrEqualTo(cfChargingUseLogQuery.getMaxStartTime());
        }
        if(cfChargingUseLogQuery.getMinEndTime()!=null){
            criteria.andEndTimeGreaterThanOrEqualTo(cfChargingUseLogQuery.getEndTime());
        }
        if(cfChargingUseLogQuery.getMaxEndTime()!=null){
            criteria.andEndTimeLessThanOrEqualTo(cfChargingUseLogQuery.getMaxEndTime());
        }
        if(cfChargingUseLogQuery.getChargingStatus()!=null){
            criteria.andChargingStatusEqualTo(cfChargingUseLogQuery.getChargingStatus());
        }
        if(cfChargingUseLogQuery.getChargingType()!=null){
            criteria.andChargingTypeEqualTo(cfChargingUseLogQuery.getChargingType());
        }
        if(StringUtils.isNotEmpty(cfChargingUseLogQuery.getOrderBy())){
            cfChargingUseLogExample.setOrderByClause(cfChargingUseLogQuery.getOrderBy());
        }
        if(cfChargingUseLogQuery.getPage()!=null && cfChargingUseLogQuery.getSize()!=null){
            PageHelper.startPage(cfChargingUseLogQuery.getPage(), cfChargingUseLogQuery.getSize());
        }
        return cfChargingUseLogExample;
    }

    @Override
    public List<CfChargingUseLog> getListByQuery(CfChargingUseLogQuery cfChargingUseLogQuery) {
        return cfChargingUseLogMapper.selectByExample(getExampleByQuery(cfChargingUseLogQuery));
    }

    @Override
    public List<CfChargingUseLog> selectListByQuery(CfChargingUseLogQuery cfChargingUseLogQuery) {
        return cfChargingUseLogMapper.selectListByQuery(cfChargingUseLogQuery);
    }

    @Override
    public CfChargingUseLog findById(String id) {
        return cfChargingUseLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfChargingUseLog findById(String id, boolean expectEmpty) {
        CfChargingUseLog cfChargingUseLog = findById(id);
        if(expectEmpty && cfChargingUseLog!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfChargingUseLog==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfChargingUseLog;
    }

    @Override
    public Integer countByQuery(CfChargingUseLogQuery cfChargingUseLogQuery) {
        cfChargingUseLogQuery.setPage(null);
        return cfChargingUseLogMapper.countByExample(getExampleByQuery(cfChargingUseLogQuery));
    }

    @Override
    public List<CfChargingUseLog> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) throws Exception {
        String sql = "SELECT cstul.*,cs.id cs_id,cs.station_name cs_station_name,csd.alias_name as csd_alias_name " +
                "FROM cf_charging_use_log cstul " +
                "LEFT JOIN cf_charging_station_device csd ON(cstul.charging_device_id=csd.id) "+
                "LEFT JOIN cf_charging_station cs ON(cstul.charging_station_id=cs.id) ";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        List<CfChargingUseLog> cfChargingUseLogList = cfChargingUseLogMapper.selectListByCondition(sql);
        return cfChargingUseLogList;
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_charging_use_log cstul ";
        conditions.remove("group");
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, true);
        return cfChargingUseLogMapper.selectListByConditionCounts(sql);
    }

    @Override
    public CfChargingUseLog getCharingUseLogByDevcieSerialNumber(String serialNumber, String port) {
        if(StringUtils.isEmpty(serialNumber) || StringUtils.isEmpty(port)){
            return null;
        }
        CfChargingStationDeviceQuery cfChargingStationDeviceQuery = new CfChargingStationDeviceQuery();
        cfChargingStationDeviceQuery.setType((byte)1);
        cfChargingStationDeviceQuery.setBarCode(serialNumber);
        cfChargingStationDeviceQuery.setBrand("lv_chong_chong");
        List<CfChargingStationDevice> cfChargingStationDevices = cfChargingStationDeviceService.getListByQuery(cfChargingStationDeviceQuery);
        if(cfChargingStationDevices==null || cfChargingStationDevices.size()==0){
            return null;
        }
        CfChargingUseLogQuery cfChargingUseLogQuery = new CfChargingUseLogQuery();
        cfChargingUseLogQuery.setChargingDeviceId(cfChargingStationDevices.get(0).getId());
        cfChargingUseLogQuery.setChargingPort(port);
        cfChargingUseLogQuery.setOrderBy("start_time desc");
        cfChargingUseLogQuery.setPage(1);
        cfChargingUseLogQuery.setSize(1);
        List<CfChargingUseLog> cfChargingUseLogs = getListByQuery(cfChargingUseLogQuery);
        if(cfChargingUseLogs!=null && cfChargingUseLogs.size()>0 && cfChargingUseLogs.get(0).getEndTime()==0){
            return cfChargingUseLogs.get(0);
        }
        return null;
    }
}
