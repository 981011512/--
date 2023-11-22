package com.cf.pay.service.impl;
import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.request.CfCarParkQuery;
import com.cf.carpark.service.CfCarParkService;
import com.cf.charging.domain.CfChargingStation;
import com.cf.charging.domain.request.CfChargingStationQuery;
import com.cf.charging.service.CfChargingStationService;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfDailyIncomeStatisticsMapper;
import com.cf.pay.domain.CfDailyIncomeStatistics;
import com.cf.pay.domain.CfDailyIncomeStatisticsExample;
import com.cf.pay.domain.CfPaymentAgency;
import com.cf.pay.domain.request.CfDailyIncomeStatisticsQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.request.CfPaymentAgencyQuery;
import com.cf.pay.domain.type.CountModel;
import com.cf.pay.service.CfDailyIncomeStatisticsService;
import com.cf.pay.service.CfOrderService;
import com.cf.pay.service.CfPaymentAgencyService;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
//@Transactional
public class CfDailyIncomeStatisticsServiceImpl implements CfDailyIncomeStatisticsService {

    public static final String[] goosType = {"停车缴费","充值","商城消费","转账","停车套餐","车位预订","优惠券活动充值","新能源充电","提现","退款","收款"};

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfDailyIncomeStatisticsMapper cfDailyIncomeStatisticsMapper;
    @Autowired
    private CfOrderService cfOrderService;
    @Autowired
    private CfPaymentAgencyService cfPaymentAgencyService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkService cfCarParkService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfChargingStationService cfChargingStationService;

    @Override
    public CfDailyIncomeStatistics add(CfDailyIncomeStatistics cfDailyIncomeStatistics) {
        cfDailyIncomeStatistics.setId(idWorker.nextId());
        cfDailyIncomeStatistics.setCountsTime(System.currentTimeMillis());
        cfDailyIncomeStatisticsMapper.insertSelective(cfDailyIncomeStatistics);
        return cfDailyIncomeStatistics;
    }

    @Override
    public CfDailyIncomeStatistics update(CfDailyIncomeStatistics cfDailyIncomeStatistics) {
        cfDailyIncomeStatistics.setCountsTime(System.currentTimeMillis());
        cfDailyIncomeStatisticsMapper.updateByPrimaryKeySelective(cfDailyIncomeStatistics);
        return cfDailyIncomeStatistics;
    }

    @Override
    public Integer updateByQuery(CfDailyIncomeStatistics cfDailyIncomeStatistics, CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery) {
        cfDailyIncomeStatistics.setCountsTime(System.currentTimeMillis());
        return cfDailyIncomeStatisticsMapper.updateByExampleSelective(cfDailyIncomeStatistics, getExampleByQuery(cfDailyIncomeStatisticsQuery));
    }

    @Override
    public Integer delete(String id) {
        return cfDailyIncomeStatisticsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery) {
        return cfDailyIncomeStatisticsMapper.deleteByExample(getExampleByQuery(cfDailyIncomeStatisticsQuery));
    }

    @Override
    public CfDailyIncomeStatisticsExample getExampleByQuery(CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery) {
        CfDailyIncomeStatisticsExample cfDailyIncomeStatisticsExample = new CfDailyIncomeStatisticsExample();
        CfDailyIncomeStatisticsExample.Criteria criteria = cfDailyIncomeStatisticsExample.createCriteria();
        if(cfDailyIncomeStatisticsQuery.getShopId()!=null){
            criteria.andShopIdEqualTo(cfDailyIncomeStatisticsQuery.getShopId());
        }
        if(cfDailyIncomeStatisticsQuery.getPaymentAgencyShortName()!=null){
            criteria.andPaymentAgencyShortNameEqualTo(cfDailyIncomeStatisticsQuery.getPaymentAgencyShortName());
        }
        if(cfDailyIncomeStatisticsQuery.getGoodsType()!=null){
            criteria.andGoodsTypeEqualTo(cfDailyIncomeStatisticsQuery.getGoodsType());
        }
        if(cfDailyIncomeStatisticsQuery.getMinStartTime()!=null){
            criteria.andStartTimeGreaterThanOrEqualTo(cfDailyIncomeStatisticsQuery.getMinStartTime());
        }
        if(cfDailyIncomeStatisticsQuery.getMaxStartTime()!=null){
            criteria.andStartTimeLessThanOrEqualTo(cfDailyIncomeStatisticsQuery.getMaxStartTime());
        }
        if(cfDailyIncomeStatisticsQuery.getMinEndTime()!=null){
            criteria.andEndTimeGreaterThanOrEqualTo(cfDailyIncomeStatisticsQuery.getMinEndTime());
        }
        if(cfDailyIncomeStatisticsQuery.getMaxEndTime()!=null){
            criteria.andEndTimeLessThanOrEqualTo(cfDailyIncomeStatisticsQuery.getMaxEndTime());
        }
        if(cfDailyIncomeStatisticsQuery.getYear()!=null){
            criteria.andYearEqualTo(cfDailyIncomeStatisticsQuery.getYear());
        }
        if(cfDailyIncomeStatisticsQuery.getMinYear()!=null){
            criteria.andYearGreaterThanOrEqualTo(cfDailyIncomeStatisticsQuery.getMinYear());
        }
        if(cfDailyIncomeStatisticsQuery.getMaxYear()!=null){
            criteria.andYearLessThanOrEqualTo(cfDailyIncomeStatisticsQuery.getMaxYear());
        }
        if(cfDailyIncomeStatisticsQuery.getMonth()!=null){
            criteria.andMonthEqualTo(cfDailyIncomeStatisticsQuery.getMonth());
        }
        if(cfDailyIncomeStatisticsQuery.getMinMonth()!=null){
            criteria.andMonthGreaterThanOrEqualTo(cfDailyIncomeStatisticsQuery.getMinMonth());
        }
        if(cfDailyIncomeStatisticsQuery.getMaxMonth()!=null){
            criteria.andMonthLessThanOrEqualTo(cfDailyIncomeStatisticsQuery.getMaxMonth());
        }
        if(cfDailyIncomeStatisticsQuery.getDate()!=null){
            criteria.andDateEqualTo(cfDailyIncomeStatisticsQuery.getDate());
        }
        if(cfDailyIncomeStatisticsQuery.getMinDate()!=null){
            criteria.andDateGreaterThanOrEqualTo(cfDailyIncomeStatisticsQuery.getMinDate());
        }
        if(cfDailyIncomeStatisticsQuery.getMaxDate()!=null){
            criteria.andDateLessThanOrEqualTo(cfDailyIncomeStatisticsQuery.getMaxDate());
        }
        if(StringUtils.isNotEmpty(cfDailyIncomeStatisticsQuery.getOrderBy())){
            cfDailyIncomeStatisticsExample.setOrderByClause(cfDailyIncomeStatisticsQuery.getOrderBy());
        }
        if(cfDailyIncomeStatisticsQuery.getPage()!=null && cfDailyIncomeStatisticsQuery.getSize()!=null){
            PageHelper.startPage(cfDailyIncomeStatisticsQuery.getPage(), cfDailyIncomeStatisticsQuery.getSize());
        }
        return cfDailyIncomeStatisticsExample;
    }

    @Override
    public List<CfDailyIncomeStatistics> getListByQuery(CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery) {
        return cfDailyIncomeStatisticsMapper.selectByExample(getExampleByQuery(cfDailyIncomeStatisticsQuery));
    }

    @Override
    public Integer countByQuery(CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery) {
        cfDailyIncomeStatisticsQuery.setPage(null);
        return cfDailyIncomeStatisticsMapper.countByExample(getExampleByQuery(cfDailyIncomeStatisticsQuery));
    }

    @Override
    public void statisticsDatas(String dateStr, Long startTime, Long endTime, String countModel) throws Exception {
        if(!countModel.equals(CountModel.COUNT_MODEL_DAY) && !countModel.equals(CountModel.COUNT_MODEL_MONTH) && !countModel.equals(CountModel.COUNT_MODEL_YEAR)){
            return;
        }
        String[] dayArr = dateStr.split("-");
        //统计停车场
        CfCarParkQuery cfCarParkQuery = new CfCarParkQuery();
        List<CfCarPark> cfCarParkList = cfCarParkService.getListByQuery(cfCarParkQuery);
        if(cfCarParkList!=null && cfCarParkList.size()>0){
            for(CfCarPark cfCarPark: cfCarParkList){
                byte[] goodsTypeList = { (byte)1, (byte)5, (byte)6 };
                //根据商品类型进行统计
                for(int m=0; m<goodsTypeList.length; m++){
                    int j = m;
                    Thread thread = new Thread(new Runnable() {
                        @SneakyThrows
                        @Override
                        public void run() {
                            //异步统计
                            //根据支付机构进行统计
                            String countTitle = "";
                            CfPaymentAgencyQuery cfPaymentAgencyQuery = new CfPaymentAgencyQuery();
                            List<CfPaymentAgency> cfPaymentAgencyList = cfPaymentAgencyService.getListByQuery(cfPaymentAgencyQuery);
                            if(cfPaymentAgencyList!=null && cfPaymentAgencyList.size()>0){
                                for(CfPaymentAgency cfPaymentAgency: cfPaymentAgencyList){
                                    if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                                        countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+cfCarPark.getName()+"-"+goosType[goodsTypeList[j]]+"-"+cfPaymentAgency.getName();
                                    }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                                        countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+cfCarPark.getName()+"-"+goosType[goodsTypeList[j]]+"-"+cfPaymentAgency.getName();
                                    }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                                        countTitle = dayArr[0]+"年-"+cfCarPark.getName()+"-"+goosType[goodsTypeList[j]]+"-"+cfPaymentAgency.getName();
                                    }
                                    statisticsDatas(dateStr,startTime,endTime,goodsTypeList[j],cfPaymentAgency.getShortName(), cfCarPark.getId(),countTitle, countModel);
                                }
                            }

                            //无支付机构统计
                            if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                                countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+cfCarPark.getName()+"-"+goosType[goodsTypeList[j]];
                            }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                                countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+cfCarPark.getName()+"-"+goosType[goodsTypeList[j]];
                            }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                                countTitle = dayArr[0]+"年-"+cfCarPark.getName()+"-"+goosType[goodsTypeList[j]];
                            }
                            statisticsDatas(dateStr,startTime,endTime,goodsTypeList[j],"",cfCarPark.getId(),countTitle, countModel);
                        }
                    });
                    thread.start();
                }
                //无商品类型统计
                CfPaymentAgencyQuery cfPaymentAgencyQuery = new CfPaymentAgencyQuery();
                List<CfPaymentAgency> cfPaymentAgencyList = cfPaymentAgencyService.getListByQuery(cfPaymentAgencyQuery);
                if(cfPaymentAgencyList!=null && cfPaymentAgencyList.size()>0){
                    for(CfPaymentAgency cfPaymentAgency: cfPaymentAgencyList){
                        Thread threadIn = new Thread(new Runnable() {
                            @SneakyThrows
                            @Override
                            public void run() {
                                String countTitle = "";
                                if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                                    countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+cfCarPark.getName()+"-"+cfPaymentAgency.getName();
                                }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                                    countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+cfCarPark.getName()+"-"+cfPaymentAgency.getName();
                                }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                                    countTitle = dayArr[0]+"年-"+cfCarPark.getName()+"-"+cfPaymentAgency.getName();
                                }
                                statisticsDatas(dateStr,startTime,endTime,(byte)0,cfPaymentAgency.getShortName(), cfCarPark.getId(),countTitle, countModel);
                            }
                        });
                        threadIn.start();
                    }
                }

                //总统计
                String countTitle = "";
                if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                    countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+cfCarPark.getName();
                }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                    countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+cfCarPark.getName();
                }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                    countTitle = dayArr[0]+"年-"+dayArr[1]+"月-"+cfCarPark.getName();
                }
                statisticsDatas(dateStr,startTime,endTime,(byte)0,"",cfCarPark.getId(),countTitle, countModel);
            }
        }


        //统计充电站-----------------------
        CfChargingStationQuery cfChargingStationQuery = new CfChargingStationQuery();
        List<CfChargingStation> cfChargingStationList = cfChargingStationService.getListByQuery(cfChargingStationQuery);
        if(cfChargingStationList!=null && cfChargingStationList.size()>0){
            for(CfChargingStation cfChargingStation: cfChargingStationList){
                byte[] goodsTypeList = { (byte)8 };
                //根据商品类型进行统计
                for(int m=0; m<goodsTypeList.length; m++){
                    int j = m;
                    Thread thread = new Thread(new Runnable() {
                        @SneakyThrows
                        @Override
                        public void run() {
                            String countTitle = "";
                            //异步统计
                            //根据支付机构进行统计
                            CfPaymentAgencyQuery cfPaymentAgencyQuery = new CfPaymentAgencyQuery();
                            List<CfPaymentAgency> cfPaymentAgencyList = cfPaymentAgencyService.getListByQuery(cfPaymentAgencyQuery);
                            if(cfPaymentAgencyList!=null && cfPaymentAgencyList.size()>0){
                                for(CfPaymentAgency cfPaymentAgency: cfPaymentAgencyList){
                                    if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                                        countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+cfChargingStation.getStationName()+"-"+goosType[goodsTypeList[j]]+"-"+cfPaymentAgency.getName();
                                    }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                                        countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+cfChargingStation.getStationName()+"-"+goosType[goodsTypeList[j]]+"-"+cfPaymentAgency.getName();
                                    }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                                        countTitle = dayArr[0]+"年-"+cfChargingStation.getStationName()+"-"+goosType[goodsTypeList[j]]+"-"+cfPaymentAgency.getName();
                                    }
                                    statisticsDatas(dateStr,startTime,endTime,goodsTypeList[j],cfPaymentAgency.getShortName(),cfChargingStation.getId(),countTitle, countModel);
                                }
                            }
                            //无支付机构统计
                            if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                                countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+cfChargingStation.getStationName()+"-"+goosType[goodsTypeList[j]];
                            }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                                countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+cfChargingStation.getStationName()+"-"+goosType[goodsTypeList[j]];
                            }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                                countTitle = dayArr[0]+"年-"+cfChargingStation.getStationName()+"-"+goosType[goodsTypeList[j]];
                            }

                            statisticsDatas(dateStr,startTime,endTime,goodsTypeList[j],"",cfChargingStation.getId(),countTitle, countModel);
                        }
                    });
                    thread.start();
                }
                //无商品类型
                CfPaymentAgencyQuery cfPaymentAgencyQuery = new CfPaymentAgencyQuery();
                List<CfPaymentAgency> cfPaymentAgencyList = cfPaymentAgencyService.getListByQuery(cfPaymentAgencyQuery);
                if(cfPaymentAgencyList!=null && cfPaymentAgencyList.size()>0){
                    for(CfPaymentAgency cfPaymentAgency: cfPaymentAgencyList){
                        Thread threadIn = new Thread(new Runnable() {
                            @SneakyThrows
                            @Override
                            public void run() {
                                String countTitle = "";
                                if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                                    countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+cfChargingStation.getStationName()+"-"+cfPaymentAgency.getName();
                                }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                                    countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+cfChargingStation.getStationName()+"-"+cfPaymentAgency.getName();
                                }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                                    countTitle = dayArr[0]+"年-"+cfChargingStation.getStationName()+"-"+cfPaymentAgency.getName();
                                }
                                statisticsDatas(dateStr,startTime,endTime,(byte)0,cfPaymentAgency.getShortName(), cfChargingStation.getId(),countTitle, countModel);
                            }
                        });
                        threadIn.start();
                    }
                }

                //总统计
                String countTitle = "";
                if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                    countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+cfChargingStation.getStationName();
                }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                    countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+cfChargingStation.getStationName();
                }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                    countTitle = dayArr[0]+"年-"+cfChargingStation.getStationName();
                }
                statisticsDatas(dateStr,startTime,endTime,(byte)0,"",cfChargingStation.getId(),countTitle, countModel);
            }
        }

        //无条件统计
        //根据商品类型进行统计
        for(byte n=1; n<=(byte)10; n++){
            byte i=n;
            Thread thread = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    //异步统计
                    //根据支付机构进行统计
                    String countTitle = "";
                    CfPaymentAgencyQuery cfPaymentAgencyQuery = new CfPaymentAgencyQuery();
                    List<CfPaymentAgency> cfPaymentAgencyList = cfPaymentAgencyService.getListByQuery(cfPaymentAgencyQuery);
                    if(cfPaymentAgencyList!=null && cfPaymentAgencyList.size()>0){
                        for(CfPaymentAgency cfPaymentAgency: cfPaymentAgencyList){
                            if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                                countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+goosType[i]+"-"+cfPaymentAgency.getName();
                            }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                                countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+goosType[i]+"-"+cfPaymentAgency.getName();
                            }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                                countTitle = dayArr[0]+"年-"+goosType[i]+"-"+cfPaymentAgency.getName();
                            }
                            statisticsDatas(dateStr,startTime,endTime,i,cfPaymentAgency.getShortName(),"",countTitle, countModel);
                        }
                    }
                    //无支付机构统计
                    if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                        countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+goosType[i];
                    }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                        countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+goosType[i];
                    }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                        countTitle = dayArr[0]+"年-"+goosType[i];
                    }
                    statisticsDatas(dateStr,startTime,endTime,i,"","",countTitle, countModel);
                }
            });
            thread.start();
        }
        //无商品类型统计
        CfPaymentAgencyQuery cfPaymentAgencyQuery = new CfPaymentAgencyQuery();
        List<CfPaymentAgency> cfPaymentAgencyList = cfPaymentAgencyService.getListByQuery(cfPaymentAgencyQuery);
        if(cfPaymentAgencyList!=null && cfPaymentAgencyList.size()>0){
            for(CfPaymentAgency cfPaymentAgency: cfPaymentAgencyList){
                Thread threadIn = new Thread(new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        String countTitle = "";
                        if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
                            countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[2]+"日-"+cfPaymentAgency.getName();
                        }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
                            countTitle = dayArr[0]+"年"+dayArr[1]+"月-"+cfPaymentAgency.getName();
                        }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
                            countTitle = dayArr[0]+"年-"+cfPaymentAgency.getName();
                        }
                        statisticsDatas(dateStr,startTime,endTime,(byte)0,cfPaymentAgency.getShortName(), "",countTitle, countModel);
                    }
                });
                threadIn.start();
            }
        }
        //总统计
        String countTitle = "";
        if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
            countTitle = dayArr[0]+"年"+dayArr[1]+"月"+dayArr[1]+"日";
        }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
            countTitle = dayArr[0]+"年"+dayArr[1]+"月";
        }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
            countTitle = dayArr[0]+"年";
        }
        statisticsDatas(dateStr,startTime,endTime,(byte)0,"","",countTitle, countModel);
    }

    private void statisticsDatas(String dayStr, Long startTime, Long endTime, Byte goodsType, String paymentAgencyShortName, String shopId, String title, String countModel) throws Exception {
        //先判断指定日期是否有统计过
        String[] todayArr = dayStr.split("-");
        CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery = new CfDailyIncomeStatisticsQuery();
        cfDailyIncomeStatisticsQuery.setYear(new Integer(todayArr[0]).shortValue());
        if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
            cfDailyIncomeStatisticsQuery.setMonth(new Integer(todayArr[1]).byteValue());
            cfDailyIncomeStatisticsQuery.setDate(new Integer(todayArr[2]).byteValue());
        }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
            cfDailyIncomeStatisticsQuery.setMonth(new Integer(todayArr[1]).byteValue());
            cfDailyIncomeStatisticsQuery.setDate((byte)0);
        }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
            cfDailyIncomeStatisticsQuery.setMonth((byte)0);
            cfDailyIncomeStatisticsQuery.setDate((byte)0);
        }
        cfDailyIncomeStatisticsQuery.setShopId(shopId);
        cfDailyIncomeStatisticsQuery.setPaymentAgencyShortName(paymentAgencyShortName);
        cfDailyIncomeStatisticsQuery.setGoodsType(goodsType);

        List<CfDailyIncomeStatistics> cfDailyParkingStatistcsList = getListByQuery(cfDailyIncomeStatisticsQuery);

        CfDailyIncomeStatistics cfDailyIncomeStatistics = new CfDailyIncomeStatistics();

        cfDailyIncomeStatistics.setTitle(title);
        cfDailyIncomeStatistics.setYear(new Integer(todayArr[0]).shortValue());
        if(countModel.equals(CountModel.COUNT_MODEL_DAY)){
            cfDailyIncomeStatistics.setMonth(new Integer(todayArr[1]).byteValue());
            cfDailyIncomeStatistics.setDate(new Integer(todayArr[2]).byteValue());
        }else if(countModel.equals(CountModel.COUNT_MODEL_MONTH)){
            cfDailyIncomeStatistics.setMonth(new Integer(todayArr[1]).byteValue());
            cfDailyIncomeStatistics.setDate((byte)0);
        }else if(countModel.equals(CountModel.COUNT_MODEL_YEAR)){
            cfDailyIncomeStatistics.setMonth((byte)0);
            cfDailyIncomeStatistics.setDate((byte)0);
        }
        cfDailyIncomeStatistics.setStartTime(startTime);
        cfDailyIncomeStatistics.setEndTime(endTime);
        cfDailyIncomeStatistics.setShopId(shopId);
        cfDailyIncomeStatistics.setPaymentAgencyShortName(paymentAgencyShortName);
        cfDailyIncomeStatistics.setGoodsType(goodsType);

        //总交易笔数
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        if(StringUtils.isNotEmpty(shopId)){
            cfOrderQuery.setShopId(shopId);
        }
        if(StringUtils.isNotEmpty(paymentAgencyShortName)){
            cfOrderQuery.setPaymentAgencyShortName(paymentAgencyShortName);
        }
        if(goodsType!=null && goodsType.intValue()>0){
            cfOrderQuery.setGoodsType(goodsType);
        }
        cfOrderQuery.setMinPayTime(cfDailyIncomeStatistics.getStartTime());
        cfOrderQuery.setMaxPayTime(cfDailyIncomeStatistics.getEndTime());
        cfDailyIncomeStatistics.setPayCounts(cfOrderService.countByQuery(cfOrderQuery));
        //应付金额
        cfOrderQuery.setCountField("amounts_payable");
        cfDailyIncomeStatistics.setAmountsPayable(cfOrderService.countByField(cfOrderQuery));
        //实付金额
        cfOrderQuery.setCountField("amount_actually_paid");
        cfDailyIncomeStatistics.setAmountActuallyPaid(cfOrderService.countByField(cfOrderQuery));
        //退款金额
        cfOrderQuery.setCountField("refund_amount");
        cfDailyIncomeStatistics.setRefundAmount(cfOrderService.countByField(cfOrderQuery));

        if(cfDailyParkingStatistcsList==null || cfDailyParkingStatistcsList.size()==0){
            //新增
            add(cfDailyIncomeStatistics);
        }else{
            //更新
            cfDailyIncomeStatistics.setId(cfDailyParkingStatistcsList.get(0).getId());
            update(cfDailyIncomeStatistics);
        }
    }
}
