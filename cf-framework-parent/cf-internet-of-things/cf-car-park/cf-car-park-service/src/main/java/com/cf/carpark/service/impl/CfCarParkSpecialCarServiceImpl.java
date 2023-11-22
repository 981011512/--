package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkSpecialCarMapper;
import com.cf.carpark.domain.CfCarParkSpecialCar;
import com.cf.carpark.domain.CfCarParkSpecialCarExample;
import com.cf.carpark.domain.request.CfCarParkSpecialCarQuery;
import com.cf.carpark.service.CfCarParkSpecialCarService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.domain.CfCouponActivity;
import com.cf.pay.domain.request.CfCouponActivityQuery;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkSpecialCarServiceImpl implements CfCarParkSpecialCarService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfCarParkSpecialCarMapper cfCarParkSpecialCarMapper;


    @Override
    public CfCarParkSpecialCar add(CfCarParkSpecialCar cfCarParkSpecialCar) {
        cfCarParkSpecialCar.setId(idWorker.nextId());
        cfCarParkSpecialCar.setCreateTime(System.currentTimeMillis());
        cfCarParkSpecialCarMapper.insertSelective(cfCarParkSpecialCar);
        return cfCarParkSpecialCar;
    }

    @Override
    public Integer batchAdd(List<CfCarParkSpecialCar> cfCarParkSpecialCarList) {
        return cfCarParkSpecialCarMapper.batchAdd(cfCarParkSpecialCarList);
    }

    @Override
    public CfCarParkSpecialCar update(CfCarParkSpecialCar cfCarParkSpecialCar) {
        cfCarParkSpecialCarMapper.updateByPrimaryKeySelective(cfCarParkSpecialCar);
        return cfCarParkSpecialCar;
    }

    @Override
    public Integer delete(String id) {
        return cfCarParkSpecialCarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery) {
        return cfCarParkSpecialCarMapper.deleteByExample(getExampleByQuery(cfCarParkSpecialCarQuery));
    }

    @Override
    public CfCarParkSpecialCar findById(String id) {
        return cfCarParkSpecialCarMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkSpecialCar findById(String id, boolean expectEmpty) {
        CfCarParkSpecialCar carParkSpecialCar = findById(id);
        if(expectEmpty && carParkSpecialCar!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && carParkSpecialCar==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return carParkSpecialCar;
    }

    @Override
    public CfCarParkSpecialCarExample getExampleByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery) {
        CfCarParkSpecialCarExample cfCarParkSpecialCarExample = new CfCarParkSpecialCarExample();
        CfCarParkSpecialCarExample.Criteria criteria = cfCarParkSpecialCarExample.createCriteria();
        if(cfCarParkSpecialCarQuery.getId()!=null){
            criteria.andIdEqualTo(cfCarParkSpecialCarQuery.getId());
        }
        if(cfCarParkSpecialCarQuery.getCarParkId()!=null){
            criteria.andCarParkIdEqualTo(cfCarParkSpecialCarQuery.getCarParkId());
        }
        if(cfCarParkSpecialCarQuery.getCarParkIds()!=null){
            criteria.andCarParkIdIn(cfCarParkSpecialCarQuery.getCarParkIds());
        }
        if(cfCarParkSpecialCarQuery.getPhone()!=null){
            criteria.andPhoneEqualTo(cfCarParkSpecialCarQuery.getPhone());
        }
        if(cfCarParkSpecialCarQuery.getNumberPlate()!=null){
            criteria.andNumberPlateEqualTo(cfCarParkSpecialCarQuery.getNumberPlate());
        }
        if(cfCarParkSpecialCarQuery.getUid()!=null){
            criteria.andUidEqualTo(cfCarParkSpecialCarQuery.getUid());
        }
        if(cfCarParkSpecialCarQuery.getTypeKey()!=null){
            criteria.andTypeKeyEqualTo(cfCarParkSpecialCarQuery.getTypeKey());
        }
        if(cfCarParkSpecialCarQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfCarParkSpecialCarQuery.getStatus());
        }
        if(cfCarParkSpecialCarQuery.getMinStartTime()!=null){
            criteria.andStartTimeGreaterThanOrEqualTo(cfCarParkSpecialCarQuery.getMinStartTime());
        }
        if(cfCarParkSpecialCarQuery.getMaxStartTime()!=null){
            criteria.andStartTimeLessThanOrEqualTo(cfCarParkSpecialCarQuery.getMaxStartTime());
        }
        if(cfCarParkSpecialCarQuery.getMinEndTime()!=null){
            criteria.andEndTimeGreaterThanOrEqualTo(cfCarParkSpecialCarQuery.getMinEndTime());
        }
        if(cfCarParkSpecialCarQuery.getMaxEndTime()!=null){
            criteria.andEndTimeLessThanOrEqualTo(cfCarParkSpecialCarQuery.getMaxEndTime());
        }
        if(cfCarParkSpecialCarQuery.getMinCreateTime()!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfCarParkSpecialCarQuery.getMinCreateTime());
        }
        if(cfCarParkSpecialCarQuery.getMaxCreateTime()!=null){
            criteria.andCreateTimeLessThanOrEqualTo(cfCarParkSpecialCarQuery.getMaxCreateTime());
        }
        if(cfCarParkSpecialCarQuery.getMaxAutoGiveAwayTime()!=null){
            criteria.andAutoGiveAwayTimeLessThanOrEqualTo(cfCarParkSpecialCarQuery.getMaxAutoGiveAwayTime());
        }
        if(cfCarParkSpecialCarQuery.getAutoGiveAway()!=null){
            criteria.andAutoGiveAwayEqualTo(cfCarParkSpecialCarQuery.getAutoGiveAway());
        }
        if(cfCarParkSpecialCarQuery.getAutoGiveAwayDate()!=null){
            criteria.andAutoGiveAwayDateEqualTo(cfCarParkSpecialCarQuery.getAutoGiveAwayDate());
        }

        if(StringUtils.isNotEmpty(cfCarParkSpecialCarQuery.getOrderBy())){
            cfCarParkSpecialCarExample.setOrderByClause(cfCarParkSpecialCarQuery.getOrderBy());
        }
        if(cfCarParkSpecialCarQuery.getPage()!=null && cfCarParkSpecialCarQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkSpecialCarQuery.getPage(), cfCarParkSpecialCarQuery.getSize());
        }
        return cfCarParkSpecialCarExample;
    }

    @Override
    public List<CfCarParkSpecialCar> getListByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery) {
        return cfCarParkSpecialCarMapper.selectByExample(getExampleByQuery(cfCarParkSpecialCarQuery));
    }

    @Override
    public List<CfCarParkSpecialCar> selectContinCarParkByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery) {
        return cfCarParkSpecialCarMapper.selectContinCarParkByQuery(cfCarParkSpecialCarQuery);
    }

    @Override
    public Integer countByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery) {
        cfCarParkSpecialCarQuery.setPage(null);
        return cfCarParkSpecialCarMapper.countByExample(getExampleByQuery(cfCarParkSpecialCarQuery));
    }

    @Override
    public void handleAutoGiveAway() throws Exception {
        //获取今天日期
        String todayStr = DateUtil.stampToDate(System.currentTimeMillis(), "dd");
        //获取今天要自动赠送的停车时长
        CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
        cfCarParkSpecialCarQuery.setAutoGiveAwayDate(todayStr);
        cfCarParkSpecialCarQuery.setAutoGiveAway((byte)1);
        cfCarParkSpecialCarQuery.setMaxAutoGiveAwayTime(DateUtil.getSameDayMinOrMaxTimestamp("min"));
        cfCarParkSpecialCarQuery.setPage(1);
        cfCarParkSpecialCarQuery.setSize(300);
        CfCarParkSpecialCar cfCarParkSpecialCar = new CfCarParkSpecialCar();
        List<CfCarParkSpecialCar> cfCarParkSpecialCarList = getListByQuery(cfCarParkSpecialCarQuery);
        if(cfCarParkSpecialCarList!=null && cfCarParkSpecialCarList.size()>0){
            for(CfCarParkSpecialCar carParkSpecialCar: cfCarParkSpecialCarList){
                //设置自动赠送时间
                cfCarParkSpecialCar.setId(carParkSpecialCar.getId());
                cfCarParkSpecialCar.setAutoGiveAwayTime(System.currentTimeMillis());
                if(carParkSpecialCar.getAutoGiveAwayAmount().doubleValue()<=0){
                    update(cfCarParkSpecialCar);
                    continue;
                }
                if(carParkSpecialCar.getAutoCleared()==(byte)1){
                    cfCarParkSpecialCar.setRemainingParkTime(carParkSpecialCar.getAutoGiveAwayAmount().longValue());
                }else{
                    Long remainingParkTime = carParkSpecialCar.getRemainingParkTime();
                    cfCarParkSpecialCar.setRemainingParkTime(remainingParkTime+carParkSpecialCar.getAutoGiveAwayAmount().longValue());
                }
                update(cfCarParkSpecialCar);
            }
        }
    }
}
