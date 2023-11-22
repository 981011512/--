package com.cf.pay.service.impl;

import com.alipay.api.domain.Coupon;
import com.cf.carpark.domain.CfCarParkCar;
import com.cf.carpark.domain.CfCarParkPackageLog;
import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.CfCarParkCarQuery;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.carpark.domain.type.FeeQueryMode;
import com.cf.carpark.service.CfCarParkCarService;
import com.cf.carpark.service.CfCarParkChargingRulesService;
import com.cf.carpark.service.CfCarParkReleaseLogService;
import com.cf.carpark.service.CfCarParkUseLogService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.pay.QrCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.CouponActivityCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfCouponActivityMapper;
import com.cf.pay.dao.mapper.CfCouponMapper;
import com.cf.pay.dao.mapper.CfUserPaymentAgencyMapper;
import com.cf.pay.domain.*;
import com.cf.pay.domain.request.*;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.domain.type.CouponStatus;
import com.cf.pay.domain.type.CouponType;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.*;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.CfStaffService;
import com.cf.ucenter.service.CfUserRoleService;
import com.cf.ucenter.service.CfUserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCouponActivityServiceImpl implements CfCouponActivityService {

    @Autowired
    private CfCouponActivityMapper cfCouponActivityMapper;
    @Autowired
    private CfCouponMapper cfCouponMapper;
    @Autowired
    private CfUserPaymentAgencyMapper cfUserPaymentAgencyMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfCouponActivityCouponTypeService cfCouponActivityCouponTypeService;
    @Autowired
    private CfStaffCouponSettingService cfStaffCouponSettingService;
    @Autowired
    private CfStaffCouponLogService cfStaffCouponLogService;
    @Autowired
    private CfCouponService cfCouponService;
    @Autowired
    private CfCouponActivityLinkShopService cfCouponActivityLinkShopService;
    @Autowired
    private CfCouponLinkShopService cfCouponLinkShopService;
    @Autowired
    private CfQrCodeService cfQrCodeService;
    @Autowired
    private CfOrderService cfOrderService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfStaffService cfStaffService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserRoleService cfUserRoleService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkCarService cfCarParkCarService;


    @Override
    public List<CfCouponActivity> getListByQuery(CfCouponActivityQuery cfCouponActivityQuery) {
        return cfCouponActivityMapper.selectByExample(getExampleByQuery(cfCouponActivityQuery));
    }

    @Override
    public CfCouponActivityExample getExampleByQuery(CfCouponActivityQuery cfCouponActivityQuery) {
        CfCouponActivityExample cfCouponActivityExample = new CfCouponActivityExample();
        CfCouponActivityExample.Criteria criteria = cfCouponActivityExample.createCriteria();
        if(cfCouponActivityQuery.getIds()!=null && cfCouponActivityQuery.getIds().size()>0){
            criteria.andIdIn(cfCouponActivityQuery.getIds());
        }
        if(cfCouponActivityQuery.getMainBodyIds()!=null && cfCouponActivityQuery.getMainBodyIds().size()>0){
            criteria.andMainBodyIdIn(cfCouponActivityQuery.getMainBodyIds());
        }
        if(cfCouponActivityQuery.getType()!=null){
            criteria.andTypeEqualTo(cfCouponActivityQuery.getType());
        }
        if(cfCouponActivityQuery.getMinStartTime()!=null){
            criteria.andStartTimeGreaterThan(cfCouponActivityQuery.getMinStartTime());
        }
        if(cfCouponActivityQuery.getMaxStartTime()!=null){
            criteria.andStartTimeLessThan(cfCouponActivityQuery.getMaxStartTime());
        }
        if(cfCouponActivityQuery.getMinEndTime()!=null){
            criteria.andEndTimeGreaterThan(cfCouponActivityQuery.getMinEndTime());
        }
        if(cfCouponActivityQuery.getMaxEndTime()!=null){
            criteria.andEndTimeLessThan(cfCouponActivityQuery.getMaxEndTime());
        }
        if(cfCouponActivityQuery.getMinDenomination()!=null){
            criteria.andDenominationGreaterThan(cfCouponActivityQuery.getMinDenomination());
        }
        if(cfCouponActivityQuery.getMaxDenomination()!=null){
            criteria.andDenominationLessThan(cfCouponActivityQuery.getMaxDenomination());
        }
        if(cfCouponActivityQuery.getMinThresholdPrice()!=null){
            criteria.andThresholdPriceGreaterThan(cfCouponActivityQuery.getMinThresholdPrice());
        }
        if(cfCouponActivityQuery.getMaxThresholdPrice()!=null){
            criteria.andThresholdPriceLessThan(cfCouponActivityQuery.getMaxThresholdPrice());
        }
        if(cfCouponActivityQuery.getMinTotalIssueQuantity()!=null){
            criteria.andTotalIssueQuantityGreaterThan(cfCouponActivityQuery.getMinTotalIssueQuantity());
        }
        if(cfCouponActivityQuery.getMaxTotalIssueQuantity()!=null){
            criteria.andTotalIssueQuantityLessThan(cfCouponActivityQuery.getMaxTotalIssueQuantity());
        }
        if(cfCouponActivityQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfCouponActivityQuery.getStatus());
        }
        if(StringUtils.isNotEmpty(cfCouponActivityQuery.getMainBodyId())){
            criteria.andMainBodyIdEqualTo(cfCouponActivityQuery.getMainBodyId());
        }
        if(StringUtils.isNotEmpty(cfCouponActivityQuery.getPhone())){
            criteria.andPhoneEqualTo(cfCouponActivityQuery.getPhone());
        }
        if(cfCouponActivityQuery.getAutoGiveAway()!=null){
            criteria.andAutoGiveAwayEqualTo(cfCouponActivityQuery.getAutoGiveAway());
        }
        if(cfCouponActivityQuery.getMinAutoGiveAwayTime()!=null){
            criteria.andAutoGiveAwayTimeGreaterThanOrEqualTo(cfCouponActivityQuery.getMinAutoGiveAwayTime());
        }
        if(cfCouponActivityQuery.getMaxAutoGiveAwayTime()!=null){
            criteria.andAutoGiveAwayTimeLessThanOrEqualTo(cfCouponActivityQuery.getMaxAutoGiveAwayTime());
        }
        if(StringUtils.isNotEmpty(cfCouponActivityQuery.getAutoGiveAwayDate())){
            criteria.andAutoGiveAwayDateEqualTo(cfCouponActivityQuery.getAutoGiveAwayDate());
        }
        if(StringUtils.isNotEmpty(cfCouponActivityQuery.getOrderBy())){
            cfCouponActivityExample.setOrderByClause(cfCouponActivityQuery.getOrderBy());
        }
        if(cfCouponActivityQuery.getPage()!=null && cfCouponActivityQuery.getSize()!=null){
            PageHelper.startPage(cfCouponActivityQuery.getPage(), cfCouponActivityQuery.getSize());
        }
        return cfCouponActivityExample;
    }

    @Override
    public Integer countByQuery(CfCouponActivityQuery cfCouponActivityQuery) {
        cfCouponActivityQuery.setPage(null);
        return cfCouponActivityMapper.countByExample(getExampleByQuery(cfCouponActivityQuery));
    }

    @Override
    public CfCouponActivity findById(String id) {
        return cfCouponActivityMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCouponActivity findById(String id, boolean expectEmpty) {
        CfCouponActivity cfCouponActivity = cfCouponActivityMapper.selectByPrimaryKey(id);
        if(expectEmpty && cfCouponActivity!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfCouponActivity==null){
            ExceptionCast.cast(CouponActivityCode.COUPONACTIVITY_DOES_NOT_EXIST);
        }
        return cfCouponActivity;
    }

    @Override
    public CfCouponActivity add(CfCouponActivity cfCouponActivity) {
        cfCouponActivity.setId(idWorker.nextId());
        cfCouponActivity.setCreateTime(System.currentTimeMillis());
        cfCouponActivity.setUpdateTime(System.currentTimeMillis());
        cfCouponActivityMapper.insertSelective(cfCouponActivity);
        return linkUserByPhone(cfCouponActivity);
    }

    @Override
    public CfCouponActivity update(CfCouponActivity cfCouponActivity) {
        cfCouponActivity.setUpdateTime(System.currentTimeMillis());
        cfCouponActivityMapper.updateByPrimaryKey(cfCouponActivity);
        return cfCouponActivity;
    }

    @Override
    public CfCouponActivity updateByPrimaryKeySelective(CfCouponActivity cfCouponActivity) {
        cfCouponActivity.setUpdateTime(System.currentTimeMillis());
        cfCouponActivityMapper.updateByPrimaryKeySelective(cfCouponActivity);
        return linkUserByPhone(cfCouponActivity);
    }

    @Override
    public CfCouponActivity linkUserByPhone(CfCouponActivity cfCouponActivity) {
        if(StringUtils.isNotEmpty(cfCouponActivity.getPhone())){
            CfUser cfUser = cfUserService.findByPhone(cfCouponActivity.getPhone());
            if(cfUser!=null){
                cfCouponActivity.setMainBodyId(cfUser.getId());
                cfCouponActivityMapper.updateByPrimaryKeySelective(cfCouponActivity);
                //给最新用户设置店主身份
                cfUserRoleService.addByUidAndRoleKey(cfUser.getId(),"merchant");
            }
        }
        return cfCouponActivity;
    }

    @Override
    public Integer delete(String id) {
        return cfCouponActivityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CfCouponActivity> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT cpa.* FROM cf_coupon_activity cpa";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCouponActivityMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_coupon_activity cpa";
        conditions.remove("group");
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCouponActivityMapper.selectListByConditionCounts(sql);
    }

    @Override
    public CfCouponActivity checkActivityAscription(String mainBodyId, String activityId) {
        CfCouponActivity cfCouponActivity = cfCouponActivityMapper.selectByPrimaryKey(activityId);
        if(cfCouponActivity==null || cfCouponActivity.getId()==null){
            ExceptionCast.cast(CouponActivityCode.COUPONACTIVITY_DOES_NOT_EXIST);
        }
        if(!cfCouponActivity.getMainBodyId().equals(mainBodyId)){
            ExceptionCast.cast(CouponActivityCode.ACTIVITY_NOT_MATCH_USER);
        }
        return cfCouponActivity;
    }

    @Override
    public CfCoupon staffOrShopkeeperGiveCouponToCar(String uid, String toUid, String numberPlate, Byte couponType, String cfCouponActivityId, Integer quantity, CfCouponActivityCouponType cfCouponActivityCouponType) throws Exception {

        if(quantity.longValue()<=0){
            ExceptionCast.cast(CouponActivityCode.MISSING_QUANTITY);
        }

        //检查该活动状态
        CfCouponActivity cfCouponActivity = findById(cfCouponActivityId, false);
        if(cfCouponActivity.getStatus()!=(byte)1){
            ExceptionCast.cast(CouponActivityCode.ACTIVITY_TO_BE_OPENED);
        }
        //判断额度是否足够
        switch (couponType){
            case CouponType.TIMES_COUPON:   //次数券
                if(cfCouponActivity.getRemainingTimes().intValue()<=0){
                    ExceptionCast.cast(CouponActivityCode.YOU_ACTIVITY_COUPON_BALANCE_INSUFFICIENT);
                }
                break;
            case CouponType.AMOUNT_COUPON:  //金额券
                if(cfCouponActivity.getIssuedQuota().add(new BigDecimal(quantity)).doubleValue()>cfCouponActivity.getTotalIssueQuota().add(cfCouponActivity.getAutoGiveAwayOverageQuota()).doubleValue()){
                    ExceptionCast.cast(CouponActivityCode.YOU_ACTIVITY_COUPON_BALANCE_INSUFFICIENT);
                }
                break;
            case CouponType.TIME_COUPON:    //时长券
                if(quantity.longValue()*3600000>cfCouponActivity.getRemainingTime().longValue()){
                    ExceptionCast.cast(CouponActivityCode.YOU_ACTIVITY_COUPON_BALANCE_INSUFFICIENT);
                }
                break;
            default:
                ExceptionCast.cast(CouponActivityCode.ACTIVITY_NOT_MATCH_COUPON_TYPE);
                break;
        }

        String shopId = getCouponActivityMainShopId(cfCouponActivity.getType(), cfCouponActivity.getId());

        List<String> inParkNumberPlateList = null;

        List<CfCouponActivityLinkShop> couponActivityLinkShops = getLinkShop(cfCouponActivity.getType(), cfCouponActivity.getId(), false);
        ArrayList<String> carParkIds = new ArrayList<>();
        ArrayList<String> requireUsingCarParkIds = new ArrayList<>();
        for (CfCouponActivityLinkShop cfCouponActivityLinkShop: couponActivityLinkShops){
            carParkIds.add(cfCouponActivityLinkShop.getShopId());
            if(cfCouponActivityLinkShop.getRequireUsing().byteValue()==(byte)1){
                requireUsingCarParkIds.add(cfCouponActivityLinkShop.getShopId());
            }
        }

        if(StringUtils.isEmpty(numberPlate) && StringUtils.isNotEmpty(toUid)){

            //如果只发给用户，不给车牌号，默认按无牌车发券处理
            CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
            cfCarParkUseLogQuery.setNumberPlate("临A88888");
            cfCarParkUseLogQuery.setPayTime(0L);
            cfCarParkUseLogQuery.setCarParkIds(carParkIds);
            Integer countByQuery = cfCarParkUseLogService.getCountByQuery(cfCarParkUseLogQuery);
            if(countByQuery==0){
                //找到该用户绑定的车辆(强制用户必须至少绑定一个车牌)
                CfCarParkCarQuery cfCarParkCarQuery = new CfCarParkCarQuery();
                cfCarParkCarQuery.setUid(toUid);
                List<CfCarParkCar> cfCarParkCars = cfCarParkCarService.getMyCarsByCondition(cfCarParkCarQuery);
                if(cfCarParkCars==null || cfCarParkCars.size()==0){
                    ExceptionCast.cast(CarParkCode.LICENSE_PLATE_NUMBER_HAS_NOT_BEEN_BOUND_YET);
                }
                ArrayList<String> numberPlateList = new ArrayList<>();
                for(CfCarParkCar cfCarParkCar: cfCarParkCars){
                    numberPlateList.add(cfCarParkCar.getNumberPlate());
                }
                ArrayList<String> carParkIds2 = new ArrayList<>();
                inParkNumberPlateList = checkCarIsInPark(numberPlateList, carParkIds2);
                if(inParkNumberPlateList==null || inParkNumberPlateList.size()==0){
                    ExceptionCast.cast(CarParkCode.CAR_NOT_IN_CARPARK);
                }
                numberPlate = inParkNumberPlateList.get(0);
            }
        }

        //如果传入车牌检查该车牌是否在停车场中
        if(StringUtils.isNotEmpty(numberPlate) && (inParkNumberPlateList==null || inParkNumberPlateList.size()==0)){
            if(requireUsingCarParkIds.size()>0){
                Integer carIsInPark = checkCarIsInPark(numberPlate, requireUsingCarParkIds);
                if(carIsInPark==0){
                    ExceptionCast.cast(CarParkCode.CAR_NOT_IN_CARPARK);
                }
            }
        }

        if(StringUtils.isEmpty(toUid) && StringUtils.isEmpty(numberPlate)){
            ExceptionCast.cast(CouponActivityCode.MISSING_GIFT_GOAL);
        }

        String fromUid = null;
        if(!uid.equals(cfCouponActivity.getMainBodyId())){
            fromUid = cfCouponActivity.getMainBodyId();
            //校验员工身份
            cfStaffService.checkStaffExistByEmployerIdAndStaffId(cfCouponActivity.getMainBodyId(), uid, "no");
            //判断该员工当日活动发券量是否已达到上限
            CfStaffCouponSettingQuery cfStaffCouponSettingQuery = new CfStaffCouponSettingQuery();
            cfStaffCouponSettingQuery.setCouponActivityId(cfCouponActivityId);
            cfStaffCouponSettingQuery.setStaffId(uid);
            cfStaffCouponSettingQuery.setCouponType(couponType);
            List<CfStaffCouponSetting> cfStaffCouponSettings = cfStaffCouponSettingService.getListByQuery(cfStaffCouponSettingQuery);
            if(cfStaffCouponSettings==null || cfStaffCouponSettings.size()==0){
                //自动给其创建一个当日额度为0的
                CfStaffCouponSetting cfStaffCouponSetting = new CfStaffCouponSetting();
                cfStaffCouponSetting.setStaffId(uid);
                cfStaffCouponSetting.setCouponActivityId(cfCouponActivityId);
                cfStaffCouponSetting.setCouponType(couponType);
                cfStaffCouponSetting.setSameDayQuota(new BigDecimal(0.00));
                CfStaffCouponSetting couponSetting = cfStaffCouponSettingService.add(cfStaffCouponSetting);
                cfStaffCouponSettings.add(couponSetting);
            }
            CfStaffCouponLogQuery cfStaffCouponLogQuery = new CfStaffCouponLogQuery();
            cfStaffCouponLogQuery.setStaffId(uid);
            cfStaffCouponLogQuery.setCouponType(couponType);
            cfStaffCouponLogQuery.setCouponActivityId(cfCouponActivityId);
            cfStaffCouponLogQuery.setMinCreateTime(DateUtil.getSameDayMinOrMaxTimestamp("min"));
            cfStaffCouponLogQuery.setMaxCreateTime(DateUtil.getSameDayMinOrMaxTimestamp("max"));
            BigDecimal sameDayBalance = cfStaffCouponLogService.countDenominationByQuery(cfStaffCouponLogQuery);
            if(sameDayBalance==null){
                sameDayBalance = new BigDecimal(0.00);
            }

            //如果未0则为不限制
            if( couponType==CouponType.AMOUNT_COUPON && (cfStaffCouponSettings.get(0).getSameDayQuota()).doubleValue()>0 && sameDayBalance.add(new BigDecimal(quantity)).compareTo(cfStaffCouponSettings.get(0).getSameDayQuota())==1){
                ExceptionCast.cast(CouponActivityCode.YOU_ACTIVITY_COUPON_BALANCE_INSUFFICIENT);
            }
        }else{
            fromUid = uid;
            //校验店主与活动的合法性
            checkActivityAscription(cfCouponActivity.getMainBodyId(), cfCouponActivityId);
        }

        //创建优惠券
        CfCoupon cfCoupon = new CfCoupon();
        cfCoupon.setToUid(toUid);
        cfCoupon.setFromUid(fromUid);
        cfCoupon.setScenes(cfCouponActivity.getType());
        cfCoupon.setShopId(shopId);
        cfCoupon.setGoodsId(numberPlate);
        cfCoupon.setThresholdPrice(new BigDecimal(0.00));
        cfCoupon.setEffectiveTime(System.currentTimeMillis());
        //如果没有传入优惠券类型，券有效期默认都为1个月
        cfCoupon.setEffectiveTime(System.currentTimeMillis());
        if(cfCouponActivityCouponType==null){
            cfCoupon.setExpireTime(System.currentTimeMillis()+2592000000l);
        }else{
            cfCoupon.setExpireTime(System.currentTimeMillis()+cfCouponActivityCouponType.getFixedExtensionTime());
        }

        //设置优惠券额度 同时判断是否有设置每日上限，如果有设置每日上限，判断是否有超额发券
        CfCouponQuery cfCouponQuery = new CfCouponQuery();
        cfCouponQuery.setMinEffectiveTime(DateUtil.minMillisecondBaseOnTheDayToTimestamp(System.currentTimeMillis()));
        cfCouponQuery.setCouponType(cfCoupon.getCouponType());
        cfCouponQuery.setShopId(cfCoupon.getShopId());
        cfCouponQuery.setCountField("denomination");
        switch (couponType){
            case CouponType.TIMES_COUPON:   //次数券
                if(cfCouponActivity.getTimesDailyLimit().intValue()>0){
                    //查询今日的送券总次数是否有超限
                    BigDecimal todaySendTotal = cfCouponMapper.sumByFieldAndQuery(cfCouponQuery);
                    if(todaySendTotal!=null && (todaySendTotal.intValue()+quantity)>cfCouponActivity.getTimesDailyLimit().intValue()){
                        ExceptionCast.cast(CouponActivityCode.COUPON_REACHED_UPPER_LIMIT);
                    }
                }
                cfCoupon.setDenomination(new BigDecimal(quantity));
                break;
            case CouponType.AMOUNT_COUPON:  //金额券
                if(cfCouponActivity.getAmountDailyLimit().doubleValue()>0d){
                    //查询今日的送券金额是否有超限
                    BigDecimal todaySendTotal = cfCouponMapper.sumByFieldAndQuery(cfCouponQuery);
                    if(todaySendTotal!=null && (todaySendTotal.doubleValue()+quantity.doubleValue())>cfCouponActivity.getAmountDailyLimit().doubleValue()){
                        ExceptionCast.cast(CouponActivityCode.COUPON_REACHED_UPPER_LIMIT);
                    }
                }
                cfCoupon.setDenomination(new BigDecimal(quantity));
                break;
            case CouponType.TIME_COUPON:    //时长券(毫秒)
                if(cfCouponActivity.getTimeDailyLimit().longValue()>0l){
                    //查询今日的送券金额是否有超限
                    BigDecimal todaySendTotal = cfCouponMapper.sumByFieldAndQuery(cfCouponQuery);
                    if(todaySendTotal!=null && (todaySendTotal.longValue()+quantity.longValue())>cfCouponActivity.getTimeDailyLimit().longValue()){
                        ExceptionCast.cast(CouponActivityCode.COUPON_REACHED_UPPER_LIMIT);
                    }
                }
                cfCoupon.setDenomination(new BigDecimal(quantity.longValue()*3600000l));
                break;
            default:
                ExceptionCast.cast(CouponActivityCode.ACTIVITY_NOT_MATCH_COUPON_TYPE);
                break;
        }

        cfCoupon.setStatus((byte)1);
        cfCoupon.setUseTime(0l);
        cfCoupon.setAmountUsed(new BigDecimal(0.00));
        cfCoupon.setCouponType(couponType);
        CfCoupon coupon = cfCouponService.add(cfCoupon);
        //添加优惠券可使用的停车场数据
        CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery = new CfCouponActivityLinkShopQuery();
        cfCouponActivityLinkShopQuery.setCouponActivityId(cfCouponActivityId);
        cfCouponActivityLinkShopQuery.setScene("carpark");
        List<CfCouponActivityLinkShop> cfCouponActivityLinkShops = cfCouponActivityLinkShopService.getListByQuery(cfCouponActivityLinkShopQuery);
        if(cfCouponActivityLinkShops!=null && cfCouponActivityLinkShops.size()>0){
            ArrayList<CfCouponLinkShop> cfCouponLinkShops = new ArrayList<CfCouponLinkShop>();
            for(CfCouponActivityLinkShop cfCouponActivityLinkShop: cfCouponActivityLinkShops){
                CfCouponLinkShop cfCouponLinkShop = new CfCouponLinkShop();
                cfCouponLinkShop.setCouponId(coupon.getId());
                cfCouponLinkShop.setScene("carpark");
                cfCouponLinkShop.setShopId(cfCouponActivityLinkShop.getShopId());
                cfCouponLinkShops.add(cfCouponLinkShop);
            }
            cfCouponLinkShopService.batchAdd(cfCouponLinkShops);
        }
        //添加发券记录
        CfStaffCouponLog cfStaffCouponLog = new CfStaffCouponLog();
        cfStaffCouponLog.setCouponId(coupon.getId());
        cfStaffCouponLog.setCouponActivityId(cfCouponActivityId);
        cfStaffCouponLog.setStaffId(uid);
        cfStaffCouponLog.setToUid(toUid);
        cfStaffCouponLog.setDenomination(cfCoupon.getDenomination());
        cfStaffCouponLog.setRecipientBody(numberPlate);
        cfStaffCouponLog.setCouponType(couponType);
        cfStaffCouponLogService.add(cfStaffCouponLog);
        //更新活动额度
        switch (couponType){
            case CouponType.TIMES_COUPON:   //次数券
                updateRemainingTimesById(cfCouponActivity.getId(), cfCoupon.getDenomination().negate());
                break;
            case CouponType.AMOUNT_COUPON:  //金额券
                //优先扣自动赠送的额度
                if(cfCouponActivity.getAutoGiveAwayOverageQuota().compareTo(cfCoupon.getDenomination()) == -1){
                    if(cfCouponActivity.getAutoGiveAwayOverageQuota().doubleValue()<=0){
                        //从可用正常余额中扣
                        updateIssuedQuotaById(cfCouponActivity.getId(), cfCoupon.getDenomination());
                    }else{
                        //先扣可用自动赠送的，再扣部分 正常可用余额
                        updateAutoGiveAwayOverageQuotaById(cfCouponActivity.getId(), cfCouponActivity.getAutoGiveAwayOverageQuota().negate());
                        updateIssuedQuotaById(cfCouponActivity.getId(), cfCoupon.getDenomination().subtract(cfCouponActivity.getAutoGiveAwayOverageQuota()));
                    }
                }else{
                    //更新自动赠送余额
                    updateAutoGiveAwayOverageQuotaById(cfCouponActivity.getId(), cfCoupon.getDenomination().negate());
                }
                break;
            case CouponType.TIME_COUPON:    //时长券
                updateRemainingTimeById(cfCouponActivity.getId(), cfCoupon.getDenomination().negate());
                break;
            default:
                ExceptionCast.cast(CouponActivityCode.ACTIVITY_NOT_MATCH_COUPON_TYPE);
                break;
        }


        //判断车辆5分钟内是否有被摄像头扫描到，若被扫码到,自动开闸
        if(StringUtils.isNotEmpty(numberPlate)){
            CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
            cfCarParkUseLogQuery.setNumberPlate(numberPlate);
            cfCarParkUseLogQuery.setPayTime(0l);
            cfCarParkUseLogQuery.setMinInTime(1l);
            cfCarParkUseLogQuery.setMinOutTime(System.currentTimeMillis()-300000);
            cfCarParkUseLogQuery.setOrderBy("cpul.out_time desc");
            cfCarParkUseLogQuery.setPage(1);
            cfCarParkUseLogQuery.setSize(1);
            List<CfCarParkUseLog> cfCarParkUseLogs = cfCarParkUseLogService.selectByQuery(cfCarParkUseLogQuery);
            if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0 && cfCarParkUseLogs.get(0).getPayTime().longValue()==0l){
                CfCarParkOrder cfCarParkOrder = cfCarParkChargingRulesService.calculateTheAmounPayable(cfCarParkUseLogs.get(0).getId(), "", FeeQueryMode.QUERY_MODE_QUERY_ONLY);
                if(System.currentTimeMillis()-cfCarParkOrder.getCfOrder().getUpdateTime()>=5000){
                    boolean useDirectly = false;

                    //优惠券金额大于等应付金额直接开闸
                    if(couponType==CouponType.AMOUNT_COUPON && cfCoupon.getDenomination().compareTo(cfCarParkOrder.getCfOrder().getAmountsPayable())>-1){
                        useDirectly = true;

                        //时长券满足直接抵扣
                    }else if(couponType==CouponType.TIME_COUPON){
                        useDirectly = true;
                    }

                    if(useDirectly){
                        //更新相关数据
                        cfCarParkUseLogs.get(0).setPayTime(System.currentTimeMillis());
                        CfOrderQuery cfOrderQuery = new CfOrderQuery();
                        cfOrderQuery.setGoodsId(cfCarParkUseLogs.get(0).getId());
                        List<CfOrder> cfOrders = cfOrderService.getListByQuery(cfOrderQuery);
                        if(cfOrders!=null && cfOrders.size()>0){
                            //更新订单
                            cfOrders.get(0).setPayTime(System.currentTimeMillis());
                            cfOrders.get(0).setStatus(PayStatus.PAID);
                            cfOrders.get(0).setPaymentAgencyShortName("coupon");
                            cfOrders.get(0).setCouponId(coupon.getId());
                            cfOrders.get(0).setUpdateTime(System.currentTimeMillis());
                            if(couponType==CouponType.AMOUNT_COUPON){
                                cfOrders.get(0).setCouponPaid(coupon.getDenomination());
                            }
                            cfOrderService.update(cfOrders.get(0));
                        }
                        //更新停车记录数据
                        CfCarParkUseLog cfCarParkUseLog = new CfCarParkUseLog();
                        cfCarParkUseLog.setId(cfCarParkUseLogs.get(0).getId());
                        cfCarParkUseLog.setPayTime(System.currentTimeMillis());
                        cfCarParkUseLogService.updateByPrimaryKeySelective(cfCarParkUseLog);

                        //将优惠券消费掉
                        coupon.setStatus(CouponStatus.USED);
                        coupon.setUseTime(System.currentTimeMillis());
                        coupon.setAmountUsed(coupon.getDenomination());
                        coupon = cfCouponService.update(coupon);
                        cfCarParkReleaseLogService.executeReleaseByCarParkUseLog(cfCarParkUseLogs.get(0),"商户发电子券满减开闸" ,(byte)1);

                        //通知岗亭人员该账单已支付
                        cfCarParkUseLogs.get(0).setPayTime(System.currentTimeMillis());
                        cfCarParkUseLogService.sendMessage(cfCarParkUseLogs.get(0), cfCarParkUseLogs.get(0).getOutHandleUid(), 2);
                    }
                }
            }
        }
        return coupon;
    }

    @Override
    public Integer updateIssuedQuotaById(String id, BigDecimal changeValue) {
        return cfCouponActivityMapper.updateIssuedQuotaById(id, changeValue);
    }

    @Override
    public Integer updateAutoGiveAwayOverageQuotaById(String id, BigDecimal changeValue) {
        return cfCouponActivityMapper.updateAutoGiveAwayOverageQuotaById(id, changeValue);
    }

    @Override
    public Integer updateRemainingTimesById(String id, BigDecimal changeValue) {
        return cfCouponActivityMapper.updateRemainingTimesById(id, changeValue);
    }

    @Override
    public Integer updateRemainingTimeById(String id, BigDecimal changeValue) {
        return cfCouponActivityMapper.updateRemainingTimeById(id, changeValue);
    }

    @Override
    public CfCoupon getCouponByQrCode(String uid, String qrCodeId, String numberPlate, CfCouponActivityCouponType cfCouponActivityCouponType) throws Exception {
        CfQrCode cfQrCode = cfQrCodeService.findById(qrCodeId, false);
        CfCouponActivity cfCouponActivity = findById(cfQrCode.getSourceId(), false);
        if(StringUtils.isNotEmpty(cfQrCode.getToUid()) || cfQrCode.getEffectiveTime()<=System.currentTimeMillis()){
            ExceptionCast.cast(QrCode.QR_CODE_INVALID);
        }
        cfQrCode.setToUid(uid);
        if(cfCouponActivity.getRepeatTimes().byteValue()==(byte)0){
            cfQrCodeService.update(cfQrCode);
        }
        //开始发券
        Long quantity = cfQrCode.getQuantity();
        if(cfQrCode.getSourceType()==(byte)3){
            quantity = cfQrCode.getQuantity()/3600000;
        }
        return staffOrShopkeeperGiveCouponToCar(cfQrCode.getFromUid(), uid, numberPlate, cfQrCode.getSourceType(), cfQrCode.getSourceId(), quantity.intValue(), cfCouponActivityCouponType);
    }

    @Override
    public Integer checkCarIsInPark(String numberPlate, List<String> carParkIds) {
        //先找到它最后一个出场时间
        CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
        cfCarParkUseLogQuery.setNumberPlate(numberPlate);
        cfCarParkUseLogQuery.setCarParkIds(carParkIds);
        List<CfCarParkUseLog> cfCarParkUseLogs = checkCarIsInPark(cfCarParkUseLogQuery);
        if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0 && cfCarParkUseLogs.get(0).getPayTime()==0){
            return 1;
        }
        return 0;
    }

    @Override
    public List<String> checkCarIsInPark(List<String> numberPlates, List<String> carParkIds) {
        //先找到它最后一个出场时间
        CfCarParkUseLogQuery cfCarParkUseLogQuery = new CfCarParkUseLogQuery();
        cfCarParkUseLogQuery.setNumberPlates(numberPlates);
        cfCarParkUseLogQuery.setCarParkIds(carParkIds);
        List<CfCarParkUseLog> cfCarParkUseLogs = checkCarIsInPark(cfCarParkUseLogQuery);
        if(cfCarParkUseLogs==null || cfCarParkUseLogs.size()==0){
            return null;
        }
        ArrayList<String> numberPlateList = new ArrayList<>();
        for(CfCarParkUseLog cfCarParkUseLog: cfCarParkUseLogs){
            numberPlateList.add(cfCarParkUseLog.getNumberPlate());
        }
        return numberPlateList;
    }

    private List<CfCarParkUseLog> checkCarIsInPark(CfCarParkUseLogQuery cfCarParkUseLogQuery) {

        cfCarParkUseLogQuery.setMinPayTime(1L);
        cfCarParkUseLogQuery.setPage(1);
        cfCarParkUseLogQuery.setSize(1);
        cfCarParkUseLogQuery.setOrderBy("out_time DESC");
        List<CfCarParkUseLog> cfCarParkUseLogs = cfCarParkUseLogService.getListByQuery(cfCarParkUseLogQuery);
        if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0){
            cfCarParkUseLogQuery.setMinInTime(cfCarParkUseLogs.get(0).getOutTime());
        }else{
            cfCarParkUseLogQuery.setMinInTime(1L);
        }
        cfCarParkUseLogQuery.setMinPayTime(null);
        cfCarParkUseLogQuery.setPayTime(0L);
        cfCarParkUseLogQuery.setOrderBy("create_time DESC");
        return cfCarParkUseLogService.getListByQuery(cfCarParkUseLogQuery);
    }

    @Override
    public ResultMap rechargeToCouponActivity(String uid, String couponActivityId, BigDecimal amountOfMoney, String useScenes, String ip, Byte couponType) throws Exception {

        String payTypeId = null;

        //先判断该活动是否存在
        CfCouponActivity cfCouponActivity = findById(couponActivityId, false);

        //获取主店铺，和支付账号
        String shopId = getCouponActivityMainShopId(cfCouponActivity.getType(), cfCouponActivity.getId());

        if(cfCouponActivity.getType()==(byte)1){
            List<CarParkPaymentAgency> carParkPaymentAgencies = cfUserPaymentAgencyMapper.findCarParkPaymentAgencyByCarParkIdAndScenes(shopId, useScenes);
            if(carParkPaymentAgencies==null || carParkPaymentAgencies.size()==0){
                ExceptionCast.cast(PayCode.NO_PARKING_PAYMENT_CONFIGURATION_FOUND);
            }else{
                payTypeId = carParkPaymentAgencies.get(0).getUserPaymentAgency();
            }
        }

        CfOrder cfOrder = null;
        //判断当前用户是否存在同类未支付的订单，如果存在使用旧订单进行支付
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setUid(uid);
        cfOrderQuery.setGoodsType(GoodsType.COUPON_ACTIVITY_RECHARGE);
        cfOrderQuery.setGoodsId(couponActivityId);
        cfOrderQuery.setStatus(PayStatus.TO_BE_PAID);
        cfOrderQuery.setMinCreateTime(System.currentTimeMillis()-600000);
        List<CfOrder> cfOrderList = cfOrderService.getListByQuery(cfOrderQuery);
        if(cfOrderList!=null && cfOrderList.size()>0){
            cfOrder = cfOrderList.get(0);
        }else {
            //创建新的订单
            cfOrder = new CfOrder();
        }
        cfOrder.setEffectObject(couponType.toString());
        switch (couponType){
            case CouponType.TIMES_COUPON:   //次数券
                cfOrder.setPurchaseQuantity(amountOfMoney.intValue());
                cfOrder.setAmountsPayable(amountOfMoney.multiply(cfCouponActivity.getTimesCouponPrice().setScale(2,BigDecimal.ROUND_HALF_UP)));
                break;
            case CouponType.AMOUNT_COUPON:  //金额券
                cfOrder.setAmountsPayable(amountOfMoney);
                break;
            case CouponType.TIME_COUPON:    //时长券
                cfOrder.setPurchaseQuantity(amountOfMoney.intValue());
                cfOrder.setAmountsPayable(amountOfMoney.multiply(cfCouponActivity.getTimeCouponPrice().setScale(2,BigDecimal.ROUND_HALF_UP)));
                break;
            default:
                ExceptionCast.cast(CouponActivityCode.ACTIVITY_NOT_MATCH_COUPON_TYPE);
                break;
        }

        if(cfOrderList==null || cfOrderList.size()==0){
            cfOrder.setRandomId(idWorker.nextId());
            cfOrder.setUid(uid);
            cfOrder.setGoodsName(cfCouponActivity.getTitle()+"-优惠券充值");
            cfOrder.setGoodsId(cfCouponActivity.getId());
            cfOrder.setGoodsImage(cfCouponActivity.getImage());
            cfOrder.setGoodsType(GoodsType.COUPON_ACTIVITY_RECHARGE);
            cfOrder.setShopId(shopId);
            cfOrder.setAmountActuallyPaid(new BigDecimal(0.00));
            cfOrder.setRefundAmount(new BigDecimal(0.00));
            cfOrder.setCouponId("");
            cfOrder.setStatus(PayStatus.TO_BE_PAID);
            cfOrder.setPayTime(0l);
            cfOrder.setRefundTime(0l);
            cfOrder.setCancelTime(0l);
            cfOrder.setUserPaymentAgencyId(payTypeId);
            cfOrder.setPaymentAgencyShortName("");
            cfOrder.setThirdPartyOrderId("");
            cfOrder.setScorePaid(new BigDecimal(0.00));
            cfOrder.setScoreKeyFlag("");
            cfOrder.setCouponPaid(new BigDecimal(0.00));
            cfOrder.setScoreMoney(new BigDecimal(0.00));
            cfOrder = cfOrderService.add(cfOrder);
        }
        return cfOrderService.payForOrder(cfOrder, payTypeId, ip);
    }

    @Override
    public String getCouponActivityMainShopId(byte couponActivityType, String couponActivityId) {
        //获取主店铺，和支付账号
        List<CfCouponActivityLinkShop> couponActivityLinkShops = getLinkShop(couponActivityType, couponActivityId, true);
        return couponActivityLinkShops.get(0).getShopId();   //主店铺id
    }

    private List<CfCouponActivityLinkShop> getLinkShop(byte couponActivityType, String couponActivityId, boolean isMainShop){
        List<CfCouponActivityLinkShop> cfCouponActivityLinkShops = null;
        switch (couponActivityType){
            case (byte)1:   //停车场
                CfCouponActivityLinkShopQuery activityLinkShopQuery = new CfCouponActivityLinkShopQuery();
                activityLinkShopQuery.setCouponActivityId(couponActivityId);
                activityLinkShopQuery.setScene("carpark");
                if(isMainShop){
                    activityLinkShopQuery.setMainShop((byte)1);
                }
                cfCouponActivityLinkShops = cfCouponActivityLinkShopService.getListByQuery(activityLinkShopQuery);
                if(cfCouponActivityLinkShops==null || cfCouponActivityLinkShops.size()==0){
                    ExceptionCast.cast(CarParkCode.CAR_PARK_NOT_EXISTS);
                }
                break;
            default:
                ExceptionCast.cast(CarParkCode.MISS_MIAN_SHOP,"该活动未设置主店铺");
        }
        return cfCouponActivityLinkShops;
    }

    @Override
    public List<CfCouponActivityLinkShop> getCouponActivityLinkShops(byte couponActivityType, String couponActivityId) {
        return getLinkShop(couponActivityType, couponActivityId, false);
    }

    @Override
    public void handleAutoGiveAway() throws Exception {
        //获取今天日期
        String todayStr = DateUtil.stampToDate(System.currentTimeMillis(), "dd");
        //获取今天要自动发券的数据
        CfCouponActivityQuery cfCouponActivityQuery = new CfCouponActivityQuery();
        cfCouponActivityQuery.setAutoGiveAwayDate(todayStr);
        cfCouponActivityQuery.setAutoGiveAway((byte)1);
        cfCouponActivityQuery.setMaxAutoGiveAwayTime(DateUtil.getSameDayMinOrMaxTimestamp("min"));
        cfCouponActivityQuery.setPage(1);
        cfCouponActivityQuery.setSize(300);
        CfCouponActivity couponActivity = new CfCouponActivity();
        List<CfCouponActivity> cfCouponActivities = getListByQuery(cfCouponActivityQuery);
        if(cfCouponActivities!=null && cfCouponActivities.size()>0){
            for(CfCouponActivity cfCouponActivity: cfCouponActivities){
                //设置自动发券时间
                couponActivity.setId(cfCouponActivity.getId());
                couponActivity.setAutoGiveAwayTime(System.currentTimeMillis());
                if(cfCouponActivity.getAutoGiveAwayQuota().doubleValue()<=0){
                    updateByPrimaryKeySelective(couponActivity);
                    continue;
                }
                if(cfCouponActivity.getAutoCleared()==(byte)1){
                    couponActivity.setAutoGiveAwayOverageQuota(cfCouponActivity.getAutoGiveAwayQuota());
                }else{
                    BigDecimal autoGiveAwayOverageQuota = cfCouponActivity.getAutoGiveAwayOverageQuota();
                    couponActivity.setAutoGiveAwayOverageQuota(autoGiveAwayOverageQuota.add(cfCouponActivity.getAutoGiveAwayQuota()));
                }
                updateByPrimaryKeySelective(couponActivity);
            }
        }
    }
}
