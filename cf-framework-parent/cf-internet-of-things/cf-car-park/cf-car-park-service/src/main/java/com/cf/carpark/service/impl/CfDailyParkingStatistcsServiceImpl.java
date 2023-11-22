package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfDailyParkingStatistcsMapper;
import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfDailyParkingStatistcs;
import com.cf.carpark.domain.CfDailyParkingStatistcsExample;
import com.cf.carpark.domain.request.CfCarParkQuery;
import com.cf.carpark.domain.request.CfCarParkReleaseLogQuery;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.carpark.domain.request.CfDailyParkingStatistcsQuery;
import com.cf.carpark.service.CfCarParkReleaseLogService;
import com.cf.carpark.service.CfCarParkService;
import com.cf.carpark.service.CfCarParkUseLogService;
import com.cf.carpark.service.CfDailyParkingStatistcsService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfOrderService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfDailyParkingStatistcsServiceImpl implements CfDailyParkingStatistcsService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfDailyParkingStatistcsMapper cfDailyParkingStatistcsMapper;
    @Autowired
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Autowired
    private CfCarParkService cfCarParkService;
    @Autowired
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;

    @Override
    public CfDailyParkingStatistcs add(CfDailyParkingStatistcs cfDailyParkingStatistcs) {
        cfDailyParkingStatistcs.setId(idWorker.nextId());
        cfDailyParkingStatistcs.setCountsTime(System.currentTimeMillis());
        cfDailyParkingStatistcsMapper.insertSelective(cfDailyParkingStatistcs);
        return cfDailyParkingStatistcs;
    }

    @Override
    public CfDailyParkingStatistcs update(CfDailyParkingStatistcs cfDailyParkingStatistcs) {
        cfDailyParkingStatistcs.setCountsTime(System.currentTimeMillis());
        cfDailyParkingStatistcsMapper.updateByPrimaryKeySelective(cfDailyParkingStatistcs);
        return cfDailyParkingStatistcs;
    }

    @Override
    public Integer updateByQuery(CfDailyParkingStatistcs cfDailyParkingStatistcs, CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery) {
        return cfDailyParkingStatistcsMapper.updateByExampleSelective(cfDailyParkingStatistcs, getExampleByQuery(cfDailyParkingStatistcsQuery));
    }

    @Override
    public Integer delete(String id) {
        return cfDailyParkingStatistcsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery) {
        return cfDailyParkingStatistcsMapper.deleteByExample(getExampleByQuery(cfDailyParkingStatistcsQuery));
    }

    @Override
    public CfDailyParkingStatistcs findById(String id) {
        return cfDailyParkingStatistcsMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfDailyParkingStatistcs findById(String id, boolean expectEmpty) {
        CfDailyParkingStatistcs cfDailyParkingStatistcs = findById(id);
        if(expectEmpty && cfDailyParkingStatistcs!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfDailyParkingStatistcs==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfDailyParkingStatistcs;
    }

    @Override
    public CfDailyParkingStatistcsExample getExampleByQuery(CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery) {
        CfDailyParkingStatistcsExample cfDailyParkingStatistcsExample = new CfDailyParkingStatistcsExample();
        CfDailyParkingStatistcsExample.Criteria criteria = cfDailyParkingStatistcsExample.createCriteria();
        if(cfDailyParkingStatistcsQuery.getCarparkId()!=null){
            criteria.andCarparkIdEqualTo(cfDailyParkingStatistcsQuery.getCarparkId());
        }
        if(cfDailyParkingStatistcsQuery.getMinStartTime()!=null){
            criteria.andStartTimeGreaterThanOrEqualTo(cfDailyParkingStatistcsQuery.getMinStartTime());
        }
        if(cfDailyParkingStatistcsQuery.getMaxStartTime()!=null){
            criteria.andStartTimeLessThanOrEqualTo(cfDailyParkingStatistcsQuery.getMaxStartTime());
        }
        if(cfDailyParkingStatistcsQuery.getMinEndTime()!=null){
            criteria.andEndTimeGreaterThanOrEqualTo(cfDailyParkingStatistcsQuery.getMinEndTime());
        }
        if(cfDailyParkingStatistcsQuery.getMaxEndTime()!=null){
            criteria.andEndTimeLessThanOrEqualTo(cfDailyParkingStatistcsQuery.getMaxEndTime());
        }
        if(cfDailyParkingStatistcsQuery.getYear()!=null){
            criteria.andYearEqualTo(cfDailyParkingStatistcsQuery.getYear());
        }
        if(cfDailyParkingStatistcsQuery.getMinYear()!=null){
            criteria.andYearGreaterThanOrEqualTo(cfDailyParkingStatistcsQuery.getMinYear());
        }
        if(cfDailyParkingStatistcsQuery.getMaxYear()!=null){
            criteria.andYearLessThanOrEqualTo(cfDailyParkingStatistcsQuery.getMaxYear());
        }
        if(cfDailyParkingStatistcsQuery.getMonth()!=null){
            criteria.andMonthEqualTo(cfDailyParkingStatistcsQuery.getMonth());
        }
        if(cfDailyParkingStatistcsQuery.getMinMonth()!=null){
            criteria.andMonthGreaterThanOrEqualTo(cfDailyParkingStatistcsQuery.getMinMonth());
        }
        if(cfDailyParkingStatistcsQuery.getMaxMonth()!=null){
            criteria.andMonthLessThanOrEqualTo(cfDailyParkingStatistcsQuery.getMaxMonth());
        }
        if(cfDailyParkingStatistcsQuery.getDate()!=null){
            criteria.andDateEqualTo(cfDailyParkingStatistcsQuery.getDate());
        }
        if(cfDailyParkingStatistcsQuery.getMinDate()!=null){
            criteria.andDateGreaterThanOrEqualTo(cfDailyParkingStatistcsQuery.getMinDate());
        }
        if(cfDailyParkingStatistcsQuery.getMaxDate()!=null){
            criteria.andDateLessThanOrEqualTo(cfDailyParkingStatistcsQuery.getMaxDate());
        }
        if(StringUtils.isNotEmpty(cfDailyParkingStatistcsQuery.getOrderBy())){
            cfDailyParkingStatistcsExample.setOrderByClause(cfDailyParkingStatistcsQuery.getOrderBy());
        }
        if(cfDailyParkingStatistcsQuery.getPage()!=null && cfDailyParkingStatistcsQuery.getSize()!=null){
            PageHelper.startPage(cfDailyParkingStatistcsQuery.getPage(), cfDailyParkingStatistcsQuery.getSize());
        }
        return cfDailyParkingStatistcsExample;
    }

    @Override
    public List<CfDailyParkingStatistcs> getListByQuery(CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery) {
        return cfDailyParkingStatistcsMapper.selectByExample(getExampleByQuery(cfDailyParkingStatistcsQuery));
    }

    @Override
    public Integer countByQuery(CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery) {
        cfDailyParkingStatistcsQuery.setPage(null);
        return cfDailyParkingStatistcsMapper.countByExample(getExampleByQuery(cfDailyParkingStatistcsQuery));
    }

    @Override
    public void statisticsDatas(String dateStr, Long startTime, Long endTime, boolean countMonth) throws Exception {
        //查询所有停车场
        CfCarParkQuery cfCarParkQuery = new CfCarParkQuery();
        List<CfCarPark> cfCarParkList = cfCarParkService.getListByQuery(cfCarParkQuery);
        if(cfCarParkList!=null && cfCarParkList.size()>0){
            for (CfCarPark cfCarPark: cfCarParkList){
                statisticsDatas(dateStr, startTime, endTime, cfCarPark,countMonth);
            }
        }
        //统计所有
        CfCarPark cfCarPark = new CfCarPark();
        cfCarPark.setId("");
        cfCarPark.setName("总计");
        statisticsDatas(dateStr, startTime, endTime, cfCarPark,countMonth);
    }

    private void statisticsDatas(String dayStr, Long startTime, Long endTime, CfCarPark cfCarPark, boolean countMonth) throws Exception {
        //先判断指定日期是否有统计过
        String[] todayArr = dayStr.split("-");
        CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery = new CfDailyParkingStatistcsQuery();
        cfDailyParkingStatistcsQuery.setYear(new Integer(todayArr[0]).shortValue());
        cfDailyParkingStatistcsQuery.setMonth(new Integer(todayArr[1]).byteValue());
        if(!countMonth){
            cfDailyParkingStatistcsQuery.setDate(new Integer(todayArr[2]).byteValue());
        }else{
            cfDailyParkingStatistcsQuery.setDate((byte)0);
        }
        cfDailyParkingStatistcsQuery.setCarparkId(cfCarPark.getId());
        List<CfDailyParkingStatistcs> cfDailyParkingStatistcsList = getListByQuery(cfDailyParkingStatistcsQuery);

        CfDailyParkingStatistcs cfDailyParkingStatistcs = new CfDailyParkingStatistcs();

        if(!countMonth){
            cfDailyParkingStatistcs.setTitle(dayStr+"-"+cfCarPark.getName()+"停车数据统计");
        }else{
            cfDailyParkingStatistcs.setTitle(todayArr[0]+"-"+todayArr[1]+"-"+cfCarPark.getName()+"停车数据统计");
        }
        cfDailyParkingStatistcs.setYear(new Integer(todayArr[0]).shortValue());
        cfDailyParkingStatistcs.setMonth(new Integer(todayArr[1]).byteValue());
        if(!countMonth){
            cfDailyParkingStatistcs.setDate(new Integer(todayArr[2]).byteValue());
        }else{
            cfDailyParkingStatistcs.setDate((byte)0);
        }
        cfDailyParkingStatistcs.setCarparkId(cfCarPark.getId());
        cfDailyParkingStatistcs.setStartTime(startTime);
        cfDailyParkingStatistcs.setEndTime(endTime);

        //总停车数
        CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
        cfCarParkUseLogQuery.setCarParkId(cfCarPark.getId());
        cfCarParkUseLogQuery.setMinCreateTime(cfDailyParkingStatistcs.getStartTime());
        cfCarParkUseLogQuery.setMaxCreateTime(cfDailyParkingStatistcs.getEndTime());
        cfDailyParkingStatistcs.setParkingCounts(cfCarParkUseLogService.getCountByQuery(cfCarParkUseLogQuery));
        //各种车牌颜色数量
        cfCarParkUseLogQuery.setCarNumberPlateColor((byte)1);
        cfDailyParkingStatistcs.setBlueNumberPlateCounts(cfCarParkUseLogService.getCountByQuery(cfCarParkUseLogQuery));
        cfCarParkUseLogQuery.setCarNumberPlateColor((byte)2);
        cfDailyParkingStatistcs.setYellowNumberPlateCounts(cfCarParkUseLogService.getCountByQuery(cfCarParkUseLogQuery));
        cfCarParkUseLogQuery.setCarNumberPlateColor((byte)5);
        cfDailyParkingStatistcs.setGreenNumberPlateCounts(cfCarParkUseLogService.getCountByQuery(cfCarParkUseLogQuery));
        //临时停车数
        cfCarParkUseLogQuery.setCarNumberPlateColor(null);
        cfCarParkUseLogQuery.setCarType("temporary_car");
        cfDailyParkingStatistcs.setParkingTemporaryCounts(cfCarParkUseLogService.getCountByQuery(cfCarParkUseLogQuery));
        //总车位
        if(cfCarPark==null || StringUtils.isEmpty(cfCarPark.getId())){
            CfCarParkQuery cfCarParkQuery = new CfCarParkQuery();
            cfCarParkQuery.setCountField("parking_space_number");
            cfDailyParkingStatistcs.setParkingSpace(cfCarParkService.countByField(cfCarParkQuery).intValue());
            //已使用车位数
            cfCarParkQuery.setCountField("used_parking_space_number");
            cfDailyParkingStatistcs.setParkingUsedSpace(cfCarParkService.countByField(cfCarParkQuery).intValue());
        }else{
            if(cfCarPark!=null){
                cfDailyParkingStatistcs.setParkingSpace(cfCarPark.getParkingSpaceNumber());
                if(cfCarPark.getUsedParkingSpaceNumber().intValue()>cfCarPark.getParkingSpaceNumber().intValue()){
                    cfDailyParkingStatistcs.setParkingUsedSpace(cfCarPark.getParkingSpaceNumber());
                }else if(cfCarPark.getUsedParkingSpaceNumber().intValue()<0){
                    cfDailyParkingStatistcs.setParkingUsedSpace(0);
                }else{
                    cfDailyParkingStatistcs.setParkingUsedSpace(cfCarPark.getUsedParkingSpaceNumber());
                }
            }
        }

        //无入场时间的记录数
        cfCarParkUseLogQuery.setCarType(null);
        cfCarParkUseLogQuery.setInTime(0l);
        cfDailyParkingStatistcs.setParkingNotInTimeCounts(cfCarParkUseLogService.getCountByQuery(cfCarParkUseLogQuery));
        //异常放行停车数
        CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery = new CfCarParkReleaseLogQuery();
        cfCarParkReleaseLogQuery.setCarparkId(cfCarPark.getId());
        cfCarParkReleaseLogQuery.setMinApplicationTime(cfDailyParkingStatistcs.getStartTime());
        cfCarParkReleaseLogQuery.setMaxApplicationTime(cfDailyParkingStatistcs.getEndTime());
        cfCarParkReleaseLogQuery.setType((byte)2);
        cfDailyParkingStatistcs.setParkingAbnormalReleaseCounts(cfCarParkReleaseLogService.getCountByQuery(cfCarParkReleaseLogQuery));
        //总停车时间
        cfCarParkUseLogQuery.setCarType(null);
        //统计有进出时间的停车时间
        cfCarParkUseLogQuery.setMinPayTime(1l);
        cfCarParkUseLogQuery.setMinInTime(1l);
        cfCarParkUseLogQuery.setMinOutTime(1l);
        cfCarParkUseLogQuery.setCountField("out_time-in_time");
        Long totalParkingTime = cfCarParkUseLogService.countByField(cfCarParkUseLogQuery);
        if(totalParkingTime==null){
            totalParkingTime = 0l;
        }
        //统计还未出场的停车时间
        cfCarParkUseLogQuery.setPayTime(0l);
        cfCarParkUseLogQuery.setMaxInTime(startTime-1000);
        Integer integer = cfCarParkUseLogService.countByQuery(cfCarParkUseLogQuery);
        Long notOutTotalInTime = (endTime-startTime)*integer.longValue();
        if(notOutTotalInTime==null){
            notOutTotalInTime = 0l;
        }
        //时间统计为秒数
        cfDailyParkingStatistcs.setParkingTimeCounts(totalParkingTime/1000+notOutTotalInTime/1000);
        //车辆套餐新购和续费次数
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setGoodsId(cfCarPark.getId());
        cfOrderQuery.setMinPayTime(cfDailyParkingStatistcs.getStartTime());
        cfOrderQuery.setMaxPayTime(cfDailyParkingStatistcs.getEndTime());
        cfOrderQuery.setStatus(PayStatus.PAID);
        cfOrderQuery.setGoodsType(GoodsType.CARPARK_PAYMENT_PACKEAGE);
        cfDailyParkingStatistcs.setParkingPackageRenewalCounts(cfOrderService.countByQuery(cfOrderQuery));


        //查询今天的停车统计数据
        if(cfDailyParkingStatistcsList==null || cfDailyParkingStatistcsList.size()==0){
            //新增
            add(cfDailyParkingStatistcs);
        }else{
            //更新
            cfDailyParkingStatistcs.setId(cfDailyParkingStatistcsList.get(0).getId());
            update(cfDailyParkingStatistcs);
        }
    }
}
