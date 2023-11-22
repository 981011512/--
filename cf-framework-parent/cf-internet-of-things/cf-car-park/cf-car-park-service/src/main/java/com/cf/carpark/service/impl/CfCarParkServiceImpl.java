package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkLinkUserMapper;
import com.cf.carpark.dao.mapper.CfCarParkMapper;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.request.*;
import com.cf.carpark.domain.type.ActionType;
import com.cf.carpark.service.*;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.domain.CfHistoryOrder;
import com.cf.pay.domain.CfPaymentAgency;
import com.cf.pay.domain.request.CfHistoryOrderQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.request.CfPaymentAgencyQuery;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfHistoryOrderService;
import com.cf.pay.service.CfPaymentAgencyService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/3/14/014 9:28
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkServiceImpl implements CfCarParkService {
    @Autowired
    private CfCarParkMapper cfCarParkMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfCarParkLinkUserMapper cfCarParkLinkUserMapper;
    @Autowired
    private CfCarParkCheckpointService cfCarParkCheckpointService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfPaymentAgencyService cfPaymentAgencySer;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfHistoryOrderService cfHistoryOrderService;
    @Autowired
    private CfCarParkDeviceService cfCarParkDeviceService;
    @Autowired
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;
    @Autowired
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Autowired
    private CfCarParkPackageService cfCarParkPackageService;
    @Autowired
    private CfCarParkSpecialCarService cfCarParkSpecialCarService;
    @Autowired
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;
    @Autowired
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Autowired
    private CfCarParkCarLimitService cfCarParkCarLimitService;
    @Autowired
    private CfCarParkPackagePriceService cfCarParkPackagePriceService;
    @Autowired
    private CfCarParkPaymentAgencyService cfCarParkPaymentAgencyService;
    @Autowired
    private CfCarParkVisitService cfCarParkVisitService;
    @Autowired
    private CfCarParkWhitelistIssuedLogService cfCarParkWhitelistIssuedLogService;

    @Override
    public CfCarPark add(CfCarPark cfCarPark) {
        cfCarPark.setId(idWorker.nextId());
        cfCarParkMapper.insertSelective(cfCarPark);
        return cfCarPark;
    }

    @Override
    public Integer delete(String id) throws Exception {
        int i = cfCarParkMapper.deleteByPrimaryKey(id);
        if(i==0){
            return i;
        }
        //删除对应的白名单下发记录
        CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
        cfCarParkPackageQuery.setCarParkId(id);
        List<CfCarParkPackage> cfCarParkPackages = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
        CfCarParkWhitelistIssuedLogQuery cfCarParkWhitelistIssuedLogQuery = new CfCarParkWhitelistIssuedLogQuery();
        if(cfCarParkPackages!=null && cfCarParkPackages.size()>0){
            cfCarParkWhitelistIssuedLogQuery.setNumberPlates(new ArrayList<>());
            for(CfCarParkPackage cfCarParkPackage: cfCarParkPackages){
                cfCarParkWhitelistIssuedLogQuery.getNumberPlates().add(cfCarParkPackage.getNumberPlate());
            }
            try {
                cfCarParkWhitelistIssuedLogService.deleteByQuery(cfCarParkWhitelistIssuedLogQuery);
            } catch (Exception e) {

            }
        }
        //删除对应的车辆套餐
        cfCarParkPackageService.deleteByQuery(cfCarParkPackageQuery);
        //删除对应的通道
        CfCarParkCheckpointQuery cfCarParkCheckpointQuery = new CfCarParkCheckpointQuery();
        cfCarParkCheckpointQuery.setCarParkId(id);
        cfCarParkCheckpointService.deleteByQuery(cfCarParkCheckpointQuery);
        //删除对应的硬件
        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
        cfCarParkDeviceQuery.setCarParkId(id);
        cfCarParkDeviceService.deleteByQuery(cfCarParkDeviceQuery);
        //删除对应的收费规则
        CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery = new CfCarParkChargingRulesQuery();
        cfCarParkChargingRulesQuery.setCarParkId(id);
        cfCarParkChargingRulesService.deleteByQuery(cfCarParkChargingRulesQuery);
        //删除对应的关联人员
        CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
        cfCarParkLinkUserQuery.setCarParkId(id);
        cfCarParkLinkUserService.deleteByQuery(cfCarParkLinkUserQuery);
        //删除对应的特殊车辆记录
        CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
        cfCarParkSpecialCarQuery.setCarParkId(id);
        cfCarParkSpecialCarService.deleteByQuery(cfCarParkSpecialCarQuery);
        //删除对应的放行记录
        CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery = new CfCarParkReleaseLogQuery();
        cfCarParkReleaseLogQuery.setCarparkId(id);
        cfCarParkReleaseLogService.deleteByQuery(cfCarParkReleaseLogQuery);
        //删除对应的停车记录
        CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
        cfCarParkUseLogQuery.setCarParkId(id);
        try {
            cfCarParkUseLogService.deleteByQuery(cfCarParkUseLogQuery);
        } catch (Exception e) {

        }
        //删除对应的车辆定制
        CfCarParkCarLimitQuery cfCarParkCarLimitQuery = new CfCarParkCarLimitQuery();
        cfCarParkCarLimitQuery.setCarParkId(id);
        cfCarParkCarLimitService.deleteByQuery(cfCarParkCarLimitQuery);
        //删除对应的车辆套餐产品
        CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery = new CfCarParkPackagePriceQuery();
        cfCarParkPackagePriceQuery.setCarParkId(id);
        cfCarParkPackagePriceService.deleteByQuery(cfCarParkPackagePriceQuery);
        //删除对应的停车场收款账号
        CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery = new CfCarParkPaymentAgencyQuery();
        cfCarParkPaymentAgencyQuery.setCarParkId(id);
        cfCarParkPaymentAgencyService.deleteByQuery(cfCarParkPaymentAgencyQuery);
        //删除车辆到访记录
        CfCarParkVisitQuery cfCarParkVisitQuery = new CfCarParkVisitQuery();
        cfCarParkVisitQuery.setCarParkId(new Long(id));
        cfCarParkVisitService.deleteByQuery(cfCarParkVisitQuery);
        return i;
    }

    @Override
    public CfCarPark update(CfCarPark cfCarPark) {
        CfCarPark carPark = findById(cfCarPark.getId(), false);
        cfCarPark.setCreaterId(carPark.getCreaterId());
        cfCarParkMapper.updateByPrimaryKeySelective(cfCarPark);
        return cfCarPark;
    }

    @Override
    public Integer updateByQuery(CfCarPark cfCarPark, CfCarParkQuery cfCarParkQuery) {
        return cfCarParkMapper.updateByExample(cfCarPark, getExampleByQuery(cfCarParkQuery));
    }

    @Override
    public CfCarPark findById(String id) {
        CfCarPark cfCarPark = cfCarParkMapper.selectByPrimaryKey(id);
        return cfCarPark;
    }

    @Override
    public CfCarPark findById(String id, Boolean expectEmpty) {
        CfCarPark cfCarPark = findById(id);
        if(expectEmpty && cfCarPark!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && cfCarPark==null){
            ExceptionCast.cast(CarParkCode.CAR_PARK_NOT_EXISTS);
        }
        return cfCarPark;
    }

    @Override
    public List<CfCarPark> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT cp.*, cpck.counts check_point_counts FROM cf_car_park cp LEFT JOIN (SELECT car_park_id,sum(1) counts from cf_car_park_checkpoint GROUP BY car_park_id) cpck ON (cp.id = cpck.car_park_id)";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCarParkMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_car_park cp";
        conditions.remove("group");
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCarParkMapper.selectListByConditionCounts(sql);
    }

    @Override
    public List<CfCarPark> selectNearbyDatas(BigDecimal positionX, BigDecimal positionY, Integer page, Integer limit) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        return cfCarParkMapper.selectNearbyDatas(positionX, positionY, (page-1)*limit, limit,DateUtil.getMillisecondBaseOnTheDay(currentTimeMillis),currentTimeMillis);
    }

    @Override
    public List<CfCarPark> getListByQuery(CfCarParkQuery cfCarParkQuery) {
        CfCarParkExample exampleByQuery = getExampleByQuery(cfCarParkQuery);
        return cfCarParkMapper.selectByExample(exampleByQuery);
    }

    @Override
    public CfCarParkExample getExampleByQuery(CfCarParkQuery cfCarParkQuery) {
        CfCarParkExample cfCarParkExample = new CfCarParkExample();
        CfCarParkExample.Criteria criteria = cfCarParkExample.createCriteria();
        if(StringUtils.isNotEmpty(cfCarParkQuery.getId())){
            criteria.andIdEqualTo(cfCarParkQuery.getId());
        }
        if(cfCarParkQuery.getIds()!=null && cfCarParkQuery.getIds().size()>0){
            criteria.andIdIn(cfCarParkQuery.getIds());
        }
        if(StringUtils.isNotEmpty(cfCarParkQuery.getName())){
            criteria.andNameLike(cfCarParkQuery.getName());
        }
        if(StringUtils.isNotEmpty(cfCarParkQuery.getCreaterId())){
            criteria.andCreaterIdEqualTo(cfCarParkQuery.getCreaterId());
        }
        if(cfCarParkQuery.getMinPositionX()!=null){
            criteria.andPositionXGreaterThanOrEqualTo(cfCarParkQuery.getMinPositionX());
        }
        if(cfCarParkQuery.getMaxPositionX()!=null){
            criteria.andPositionXLessThanOrEqualTo(cfCarParkQuery.getMaxPositionX());
        }
        if(cfCarParkQuery.getMinPositionY()!=null){
            criteria.andPositionYGreaterThanOrEqualTo(cfCarParkQuery.getMinPositionY());
        }
        if(cfCarParkQuery.getMaxPositionY()!=null){
            criteria.andPositionYLessThanOrEqualTo(cfCarParkQuery.getMaxPositionY());
        }
        if(cfCarParkQuery.getMinStartBusinessHours()!=null){
            criteria.andStartBusinessHoursGreaterThanOrEqualTo(cfCarParkQuery.getMinStartBusinessHours());
        }
        if(cfCarParkQuery.getMaxStartBusinessHours()!=null){
            criteria.andStartBusinessHoursLessThanOrEqualTo(cfCarParkQuery.getMaxStartBusinessHours());
        }
        if(cfCarParkQuery.getMinEndBusinessHours()!=null){
            criteria.andEndBusinessHoursGreaterThanOrEqualTo(cfCarParkQuery.getMinEndBusinessHours());
        }
        if(cfCarParkQuery.getMaxEndBusinessHours()!=null){
            criteria.andEndBusinessHoursLessThanOrEqualTo(cfCarParkQuery.getMaxEndBusinessHours());
        }
        if(cfCarParkQuery.getMinParkingSpaceNumber()!=null){
            criteria.andParkingSpaceNumberGreaterThanOrEqualTo(cfCarParkQuery.getMinParkingSpaceNumber());
        }
        if(cfCarParkQuery.getMaxParkingSpaceNumber()!=null){
            criteria.andParkingSpaceNumberLessThanOrEqualTo(cfCarParkQuery.getMaxParkingSpaceNumber());
        }
        if(cfCarParkQuery.getMinUsedParkingSpaceNumber()!=null){
            criteria.andUsedParkingSpaceNumberGreaterThanOrEqualTo(cfCarParkQuery.getMinUsedParkingSpaceNumber());
        }
        if(cfCarParkQuery.getMaxUsedParkingSpaceNumber()!=null){
            criteria.andUsedParkingSpaceNumberLessThanOrEqualTo(cfCarParkQuery.getMaxUsedParkingSpaceNumber());
        }
        if(cfCarParkQuery.getMinFreeTime()!=null){
            criteria.andFreeTimeGreaterThanOrEqualTo(cfCarParkQuery.getMinFreeTime());
        }
        if(cfCarParkQuery.getMaxFreeTime()!=null){
            criteria.andFreeTimeLessThanOrEqualTo(cfCarParkQuery.getMaxFreeTime());
        }
        if(cfCarParkQuery.getMinScore()!=null){
            criteria.andScoreGreaterThanOrEqualTo(cfCarParkQuery.getMinScore());
        }
        if(cfCarParkQuery.getMaxScore()!=null){
            criteria.andScoreLessThanOrEqualTo(cfCarParkQuery.getMaxScore());
        }
        if(cfCarParkQuery.getMinNumberOfComments()!=null){
            criteria.andNumberOfCommentsGreaterThanOrEqualTo(cfCarParkQuery.getMinNumberOfComments());
        }
        if(cfCarParkQuery.getMaxNumberOfComments()!=null){
            criteria.andNumberOfCommentsLessThanOrEqualTo(cfCarParkQuery.getMaxNumberOfComments());
        }
        if(cfCarParkQuery.getMinFeeUpperLimit()!=null){
            criteria.andFeeUpperLimitGreaterThanOrEqualTo(cfCarParkQuery.getMinFeeUpperLimit());
        }
        if(cfCarParkQuery.getMaxFeeUpperLimit()!=null){
            criteria.andFeeUpperLimitLessThanOrEqualTo(cfCarParkQuery.getMaxFeeUpperLimit());
        }
        if(cfCarParkQuery.getMinStartingPrice()!=null){
            criteria.andStartingPriceGreaterThanOrEqualTo(cfCarParkQuery.getMinStartingPrice());
        }
        if(cfCarParkQuery.getMaxStartingPrice()!=null){
            criteria.andStartingPriceLessThanOrEqualTo(cfCarParkQuery.getMaxStartingPrice());
        }
        if(cfCarParkQuery.getMinUnitDuration()!=null){
            criteria.andUnitDurationGreaterThanOrEqualTo(cfCarParkQuery.getMinUnitDuration());
        }
        if(cfCarParkQuery.getMaxUnitDuration()!=null){
            criteria.andUnitDurationLessThanOrEqualTo(cfCarParkQuery.getMaxUnitDuration());
        }
        if(cfCarParkQuery.getBillingModel()!=null){
            criteria.andBillingModelEqualTo(cfCarParkQuery.getBillingModel());
        }

        if(cfCarParkQuery.getSpecialFeeExpiredCar()!=null){
            criteria.andSpecialFeeExpiredCarEqualTo(cfCarParkQuery.getSpecialFeeExpiredCar());
        }
        if(cfCarParkQuery.getShowExpiredCarType()!=null){
            criteria.andShowExpiredCarTypeEqualTo(cfCarParkQuery.getShowExpiredCarType());
        }

        if(StringUtils.isNotEmpty(cfCarParkQuery.getOrderBy())){
            cfCarParkExample.setOrderByClause(cfCarParkQuery.getOrderBy());
        }
        if(cfCarParkQuery.getPage()!=null && cfCarParkQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkQuery.getPage(), cfCarParkQuery.getSize());
        }
        if(cfCarParkQuery.getShowDistance()!=null){
            cfCarParkExample.setDistance(true);
        }
        return cfCarParkExample;
    }

    @Override
    public List<CfCarPark> selectContalDistanceListByQuery(CfCarParkQuery cfCarParkQuery) {
        int page = (cfCarParkQuery.getPage() - 1)*cfCarParkQuery.getSize();
        cfCarParkQuery.setPage(page);
        return cfCarParkMapper.selectContalDistanceListByQuery(cfCarParkQuery);
    }

    @Override
    public List<CfCarPark> selectContainDistanceListByCouponId(BigDecimal positionX, BigDecimal positionY, String couponId) {
        return cfCarParkMapper.selectContainDistanceListByCouponId(positionX, positionY, couponId);
    }

    @Override
    public List<CfCarPark> getListByLinkerUser(String uid, Integer page, Integer size) {
        List<CfCarPark> cfCarParks = cfCarParkMapper.getListByLinkerUser(uid, page, size);
        if(cfCarParks!=null && cfCarParks.size()>0){
            CfCarParkCheckpointQuery checkpointQuery = new CfCarParkCheckpointQuery();
            for(CfCarPark cfCarPark: cfCarParks){
                checkpointQuery.setCarParkId(cfCarPark.getId());
                cfCarPark.setCfCarParkCheckpointList(cfCarParkCheckpointService.selectByQuery(checkpointQuery));
            }
        }
        return cfCarParks;
    }

    @Override
    public CfCarParkFinanceReport getCarParkFinanceReportList(CfOrderQuery cfOrderQuery) throws Exception {

        CfCarParkFinanceReport totalCarParkFinanceReport = new CfCarParkFinanceReport();
        totalCarParkFinanceReport.setCarParkName("项目合计");

        totalCarParkFinanceReport.setParkingTotalAmountsPayable(0.00);
        totalCarParkFinanceReport.setParkingTotalAmountActuallyPaid(0.00);

        totalCarParkFinanceReport.setParkingPackageTotalAmountsPayable(0.00);
        totalCarParkFinanceReport.setParkingPackageTotalAmountActuallyPaid(0.00);

        totalCarParkFinanceReport.setParkCouponActivityRechargeTotalAmountsPayable(0.00);
        totalCarParkFinanceReport.setParkCouponActivityRechargeTotalAmountActuallyPaid(0.00);

        totalCarParkFinanceReport.setPaymentChannel(new HashMap<>());

        //获取所有支付渠道列表
        CfPaymentAgencyQuery cfPaymentAgencyQuery = new CfPaymentAgencyQuery();
        List<CfPaymentAgency> cfPaymentAgencies = cfPaymentAgencySer.getListByQuery(cfPaymentAgencyQuery);
        if(cfPaymentAgencies!=null && cfPaymentAgencies.size()>0){
            for(CfPaymentAgency cfPaymentAgency: cfPaymentAgencies){
                if(cfPaymentAgency.getShortName().equals("system_free_time") || cfPaymentAgency.getShortName().equals("abnormal_termination_of_order")){
                    continue;
                }
                cfOrderQuery.setCountField("amount_actually_paid");
                cfOrderQuery.setPaymentAgencyShortName(cfPaymentAgency.getShortName());
                totalCarParkFinanceReport.getPaymentChannel().put(cfPaymentAgency.getShortName(),cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));
            }
        }

        cfOrderQuery.setPaymentAgencyShortName(null);

        if(cfOrderQuery.getGoodsType()==null){
            cfOrderQuery.setGoodsType((byte)1);
            cfOrderQuery.setCountField("amounts_payable");
            totalCarParkFinanceReport.setParkingTotalAmountsPayable(cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));
            cfOrderQuery.setCountField("amount_actually_paid");
            totalCarParkFinanceReport.setParkingTotalAmountActuallyPaid(cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));

            cfOrderQuery.setGoodsType((byte)5);
            cfOrderQuery.setCountField("amounts_payable");
            totalCarParkFinanceReport.setParkingPackageTotalAmountsPayable(cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));
            cfOrderQuery.setCountField("amount_actually_paid");
            totalCarParkFinanceReport.setParkingPackageTotalAmountActuallyPaid(cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));

            cfOrderQuery.setGoodsType((byte)7);
            cfOrderQuery.setCountField("amounts_payable");
            totalCarParkFinanceReport.setParkCouponActivityRechargeTotalAmountsPayable(cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));
            cfOrderQuery.setCountField("amount_actually_paid");
            totalCarParkFinanceReport.setParkCouponActivityRechargeTotalAmountActuallyPaid(cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));
        }else{
            switch (cfOrderQuery.getGoodsType()){
                case (byte)1:
                    totalCarParkFinanceReport.setCarParkName("停车缴费");
                    break;
                case (byte)5:
                    totalCarParkFinanceReport.setCarParkName("停车套餐");
                    break;
                case (byte)7:
                    totalCarParkFinanceReport.setCarParkName("优惠活动");
                    break;
            }
        }

        //统计所有实收
//        cfOrderQuery.setGoodsType(null);
//        cfOrderQuery.setStatus(PayStatus.PAID);
//        cfOrderQuery.setCountField("amounts_payable");
//        totalCarParkFinanceReport.setTotalAmountsPayable(cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));
//        cfOrderQuery.setCountField("amount_actually_paid");
//        totalCarParkFinanceReport.setTotalAmountActuallyPaid(cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));

        //维护历史账单，如果已经存在，不处理
        if(StringUtils.isNotEmpty(cfOrderQuery.getShopId()) && cfOrderQuery.getMinPayTime()!=null &&
                cfOrderQuery.getMaxPayTime()<=DateUtil.getSameDayMinOrMaxTimestamp("min")
                && (cfOrderQuery.getMaxPayTime()-cfOrderQuery.getMinPayTime()<=86400000)
                && (cfOrderQuery.getMaxPayTime()-cfOrderQuery.getMinPayTime()>86390000)
                && (DateUtil.stampToDate(cfOrderQuery.getMinPayTime(), "yyyy-MM-dd HH:mm:ss").indexOf("00:00:00")>=0)
        ){
            CfHistoryOrderQuery cfHistoryOrderQuery = new CfHistoryOrderQuery();
            cfHistoryOrderQuery.setShopId(cfOrderQuery.getShopId());
            cfHistoryOrderQuery.setOrderTime(DateUtil.minMillisecondBaseOnTheDayToTimestamp(cfOrderQuery.getMinPayTime()));
            Integer count = cfHistoryOrderService.countByQuery(cfHistoryOrderQuery);
            if(count==0){
                //插入历史账单数据
                CfHistoryOrder cfHistoryOrder = new CfHistoryOrder();
                cfHistoryOrder.setShopId(cfOrderQuery.getShopId());
                cfHistoryOrder.setOrderTime(cfHistoryOrderQuery.getOrderTime());
                if(totalCarParkFinanceReport.getParkingTotalAmountsPayable()!=null){
                    cfHistoryOrder.setParkFeeAmountsPayable(new BigDecimal(totalCarParkFinanceReport.getParkingTotalAmountsPayable()));
                }else{
                    cfHistoryOrder.setParkFeeAmountsPayable(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getParkingTotalAmountActuallyPaid()!=null){
                    cfHistoryOrder.setParkFeeAmountActuallyPaid(new BigDecimal(totalCarParkFinanceReport.getParkingTotalAmountActuallyPaid()));
                }else{
                    cfHistoryOrder.setParkFeeAmountActuallyPaid(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getParkingPackageTotalAmountsPayable()!=null){
                    cfHistoryOrder.setParkPackageAmountsPayable(new BigDecimal(totalCarParkFinanceReport.getParkingPackageTotalAmountsPayable()));
                }else{
                    cfHistoryOrder.setParkPackageAmountsPayable(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getParkingPackageTotalAmountActuallyPaid()!=null){
                    cfHistoryOrder.setParkPackageAmountActuallyPaid(new BigDecimal(totalCarParkFinanceReport.getParkingPackageTotalAmountActuallyPaid()));
                }else{
                    cfHistoryOrder.setParkPackageAmountActuallyPaid(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getParkCouponActivityRechargeTotalAmountsPayable()!=null){
                    cfHistoryOrder.setRechargeAmountsPayable(new BigDecimal(totalCarParkFinanceReport.getParkCouponActivityRechargeTotalAmountsPayable()));
                }else{
                    cfHistoryOrder.setRechargeAmountsPayable(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getParkCouponActivityRechargeTotalAmountActuallyPaid()!=null){
                    cfHistoryOrder.setRechargeAmountActuallyPaid(new BigDecimal(totalCarParkFinanceReport.getParkCouponActivityRechargeTotalAmountActuallyPaid()));
                }else{
                    cfHistoryOrder.setRechargeAmountActuallyPaid(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getPaymentChannel().get("cash_pay_cny")!=null){
                    cfHistoryOrder.setCashPay(new BigDecimal(totalCarParkFinanceReport.getPaymentChannel().get("cash_pay_cny")));
                }else{
                    cfHistoryOrder.setCashPay(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getPaymentChannel().get("wei_xin_h5_pay_cny")!=null){
                    cfHistoryOrder.setWeixinH5Pay(new BigDecimal(totalCarParkFinanceReport.getPaymentChannel().get("wei_xin_h5_pay_cny")));
                }else{
                    cfHistoryOrder.setWeixinH5Pay(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getPaymentChannel().get("wei_xin_min_pay_cny")!=null){
                    cfHistoryOrder.setWeixinMinPay(new BigDecimal(totalCarParkFinanceReport.getPaymentChannel().get("wei_xin_min_pay_cny")));
                }else{
                    cfHistoryOrder.setWeixinMinPay(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getPaymentChannel().get("wei_xin_app_pay_cny")!=null){
                    cfHistoryOrder.setWeixinAppPay(new BigDecimal(totalCarParkFinanceReport.getPaymentChannel().get("wei_xin_app_pay_cny")));
                }else{
                    cfHistoryOrder.setWeixinAppPay(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getPaymentChannel().get("ali_h5_pay_cny")!=null){
                    cfHistoryOrder.setAliH5Pay(new BigDecimal(totalCarParkFinanceReport.getPaymentChannel().get("ali_h5_pay_cny")));
                }else{
                    cfHistoryOrder.setAliH5Pay(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getPaymentChannel().get("ali_min_pay_cny")!=null){
                    cfHistoryOrder.setAliMinPay(new BigDecimal(totalCarParkFinanceReport.getPaymentChannel().get("ali_min_pay_cny")));
                }else{
                    cfHistoryOrder.setAliMinPay(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getPaymentChannel().get("ali_app_pay_cny")!=null){
                    cfHistoryOrder.setAliAppPay(new BigDecimal(totalCarParkFinanceReport.getPaymentChannel().get("ali_app_pay_cny")));
                }else{
                    cfHistoryOrder.setAliAppPay(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getPaymentChannel().get("package")!=null){
                    cfHistoryOrder.setParkPackagePay(new BigDecimal(totalCarParkFinanceReport.getPaymentChannel().get("package")));
                }else{
                    cfHistoryOrder.setParkPackagePay(new BigDecimal(0.00));
                }

                if(totalCarParkFinanceReport.getPaymentChannel().get("ccb_Password_free_payment_cny")!=null){
                    cfHistoryOrder.setBbcPay(new BigDecimal(totalCarParkFinanceReport.getPaymentChannel().get("ccb_Password_free_payment_cny")));
                }else{
                    cfHistoryOrder.setBbcPay(new BigDecimal(0.00));
                }
                cfHistoryOrderService.add(cfHistoryOrder);
            }
        }

        return totalCarParkFinanceReport;
    }

    @Override
    public CfCarParkFinanceReport getCarParkTotalFinanceReport(CfOrderQuery cfOrderQuery) throws Exception {
        CfCarParkFinanceReport cfCarParkFinanceReport = new CfCarParkFinanceReport();
        cfOrderQuery.setCountField("amounts_payable");
        cfCarParkFinanceReport.setTotalAmountsPayable(cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));
        cfOrderQuery.setCountField("amount_actually_paid");
        cfCarParkFinanceReport.setTotalAmountActuallyPaid(cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));

        cfOrderQuery.setCountField("amounts_payable");
        cfOrderQuery.setPaymentAgencyShortName("abnormal_termination_of_order");
        Map<String, Double> abnormalTerminationOfOrderTotal = new HashMap<>();
        abnormalTerminationOfOrderTotal.put("abnormalTerminationOfOrderTotal", cfCarParkMapper.getCarParkFinanceReport(cfOrderQuery));
        cfCarParkFinanceReport.setPaymentChannel(abnormalTerminationOfOrderTotal);
        return cfCarParkFinanceReport;
    }

    @Override
    public Integer updateUsedParkingSpaceNumber(String carParkId, Integer changeValue) {
        return cfCarParkMapper.updateUsedParkingSpaceNumber(carParkId, changeValue);
    }

    @Override
    public void updateHistoryOrder(CfCarParkFinanceReport totalCarParkFinanceReport, String ShopId) {

    }

    @Override
    public Long countByField(CfCarParkQuery cfCarParkQuery) {
        return cfCarParkMapper.countByField(cfCarParkQuery);
    }
}
