package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkChargingRulesMapper;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.*;
import com.cf.carpark.domain.type.CarParkUseLogCreatePosition;
import com.cf.carpark.domain.type.FeeQueryMode;
import com.cf.carpark.service.*;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.CustomException;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.domain.CfAccount;
import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.request.CCBScannedChargebackForm;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.domain.request.CfCouponQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.response.CCBScannedChargeback;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.domain.type.CouponScenes;
import com.cf.pay.domain.type.CouponStatus;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.*;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 停车场收费规则
 *
 * @ClassName CfCarParkChargingRulesServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/5/005 16:21
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkChargingRulesServiceImpl implements CfCarParkChargingRulesService {

    final static String UNIT_OF_TIME = "unit_of_time";  //单位时间(停车计费模式)
    final static String EACH = "each";  //每次(停车计费模式)，不累加
    final static String EACH_ADD = "each_add";  //每次(停车计费模式)，累加

    @Autowired
    CfCarParkUseLogService cfCarParkUseLogService;
    @Autowired
    CfCarParkService cfCarParkService;
    @Autowired
    CfCarParkChargingRulesMapper cfCarParkChargingRulesMapper;
    @Autowired
    CfCarParkCheckpointService cfCarParkCheckpointService;
    @Autowired
    CfCarParkPaymentAgencyService cfCarParkPaymentAgencyService;
    @Autowired
    IdWorker idWorker;
    @Autowired
    CfCarParkPackageService cfCarParkPackageService;
    @Autowired
    CfCarParkCarLimitService cfCarParkCarLimitService;
    @Autowired
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;
    @Autowired
    private CfCarParkCarService cfCarParkCarService;
    @Autowired
    private CfCarParkPackagePriceService cfCarParkPackagePriceService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponService cfCouponService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CCBpayService ccBpayService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAccountService cfAccountService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserPaymentAgencyService cfUserPaymentAgencyService;

    @Override
    public ResultMap calculateTheAmounPayableAndHandlePay(String cfCarParkUseLogId, String uid, String payTypeId, String ipAddress) throws Exception{

        CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.findById(cfCarParkUseLogId, false);

        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setGoodsId(cfCarParkUseLogId);
        List<CfOrder> cfOrders = cfOrderService.getListByQuery(cfOrderQuery);
        if(cfOrders==null || cfOrders.size()==0){
            ExceptionCast.cast(PayCode.ORDER_DOES_NOT_EXIST);
        }
        if(cfOrders.get(0).getPayTime()>0){
            ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
        }
        if(StringUtils.isNotEmpty(cfOrders.get(0).getUid()) && !uid.equals(cfOrders.get(0).getUid()) && (System.currentTimeMillis()-cfOrders.get(0).getUpdateTime()<10000)){
            ExceptionCast.cast(CommonCode.FREQUENT_OPERATION);
        }

        CfCarParkOrder cfCarParkOrder = calculateTheAmounPayable(cfCarParkUseLog, uid, FeeQueryMode.QUERY_MODE_QUERY_AND_UPDATE);
        if(cfCarParkOrder.getCfOrder().getStatus()!=0){
            ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
        }
        cfCarParkOrder.getCfOrder().setUid(uid);
        cfCarParkOrder.getCfOrder().setUserPaymentAgencyId(payTypeId);
        cfCarParkOrder.getCfOrder().setCouponId("");
        return cfOrderService.payForOrder(cfCarParkOrder.getCfOrder(), payTypeId, ipAddress);
    }

    @Override
    public ResultMap calculateTheAmounPayableAndHandlePay(String cfCarParkUseLogId, String uid, String couponId, String payTypeId, String ipAddress) throws Exception {

        CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.findById(cfCarParkUseLogId, false);
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setGoodsId(cfCarParkUseLogId);
        List<CfOrder> cfOrders = cfOrderService.getListByQuery(cfOrderQuery);
        if(cfOrders==null || cfOrders.size()==0){
            ExceptionCast.cast(PayCode.ORDER_DOES_NOT_EXIST);
        }
        if(cfOrders.get(0).getPayTime()>0){
            ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
        }
        if(StringUtils.isNotEmpty(cfOrders.get(0).getUid()) && !uid.equals(cfOrders.get(0).getUid()) && (System.currentTimeMillis()-cfOrders.get(0).getUpdateTime()<10000)){
            ExceptionCast.cast(CommonCode.FREQUENT_OPERATION);
        }
        CfCoupon cfCoupon = cfCouponService.findById(couponId, false);

        if(cfCoupon.getCouponType()==(byte)3 && cfCoupon.getDenomination().longValue()+cfCarParkUseLog.getInTime()<cfCarParkUseLog.getOutTime()){
            long inTime = cfCoupon.getDenomination().longValue() + cfCarParkUseLog.getInTime();
            cfCarParkUseLog.setInTime(inTime);
        }

        CfCarParkOrder cfCarParkOrder = calculateTheAmounPayable(cfCarParkUseLogId, uid, FeeQueryMode.QUERY_MODE_QUERY_AND_UPDATE);
        cfCarParkOrder.getCfOrder().setUserPaymentAgencyId(payTypeId);
        if(cfCarParkOrder.getCfOrder().getStatus()!=0){
            ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
        }

        //如果人工设置了优惠金额，电子优惠券不再使用
        if(cfCarParkOrder.getCfOrder().getManualOfferSetTime()==0 || (System.currentTimeMillis()-cfCarParkOrder.getCfOrder().getManualOfferSetTime()>=900000)){
            if(System.currentTimeMillis()<cfCoupon.getEffectiveTime() || System.currentTimeMillis()>cfCoupon.getExpireTime() || cfCoupon.getStatus()!=1){
                ExceptionCast.cast(PayCode.COUPON_HAS_EXPIRED_OR_IS_NOT_YET_VALID);
            }

            if(StringUtils.isNotEmpty(cfCoupon.getGoodsId()) && !cfCoupon.getGoodsId().equals(cfCarParkOrder.getCfCarParkUseLog().getNumberPlate())){
                ExceptionCast.cast(PayCode.COUPON_USAGE_OBJECT_DO_NOT_MATCH);
            }else if(StringUtils.isEmpty(cfCoupon.getGoodsId()) && StringUtils.isNotEmpty(cfCoupon.getToUid()) && !cfCoupon.getToUid().equals(uid)){
                ExceptionCast.cast(PayCode.THIS_COUPON_DOES_NOT_BELONG_TO_YOU);
            }

            if(cfCoupon.getScenes()!=0 && cfCoupon.getScenes()!=1){
                ExceptionCast.cast(PayCode.COUPON_USAGE_SCENARIOS_DO_NOT_MATCH);
            }
//            if(StringUtils.isNotEmpty(cfCoupon.getShopId()) && !cfCoupon.getShopId().equals(cfCarParkOrder.getCfCarPark().getId())){
//                ExceptionCast.cast(PayCode.COUPON_USAGE_SCENARIOS_DO_NOT_MATCH);
//            }
            if(StringUtils.isNotEmpty(cfCoupon.getGoodsId()) && !cfCoupon.getGoodsId().equals(cfCarParkOrder.getCfCarParkUseLog().getNumberPlate())){
                ExceptionCast.cast(PayCode.COUPON_USAGE_SCENARIOS_DO_NOT_MATCH);
            }
            if((cfCoupon.getCouponType()==(byte)1 && cfCoupon.getDenomination().intValue()>0) ||
                    (cfCoupon.getCouponType()==(byte)2 && cfCoupon.getDenomination().doubleValue()>=cfCarParkOrder.getCfOrder().getAmountsPayable().doubleValue()) ||
                    (cfCoupon.getCouponType()==(byte)3 && cfCoupon.getDenomination().longValue()+cfCarParkUseLog.getInTime()>=cfCarParkUseLog.getOutTime())
            ){

                //禁止手动优惠券全额支付
                ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
            }else{
                cfCarParkOrder.getCfOrder().setCouponId(couponId);
                if(cfCoupon.getCouponType()==(byte)2){
                    cfCarParkOrder.getCfOrder().setAmountsPayable(
                            cfCarParkOrder.getCfOrder().getAmountsPayable().subtract(cfCoupon.getDenomination())
                    );
                }
            }
        }
        return cfOrderService.payForOrder(cfCarParkOrder.getCfOrder(), payTypeId, ipAddress);
    }

    @Override
    public CfCarParkOrder calculateTheAmounPayable(String cfCarParkUseLogId, String uid, String queryMode) throws Exception {

        CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.findById(cfCarParkUseLogId, false);
//        if(cfCarParkUseLog.getInTime()==0){
        //只有入场记录的直接放行
//            cfCarParkReleaseLogService.executeReleaseByCarParkUseLog(cfCarParkUseLog, "无进场场记录，自动放行");
//            ExceptionCast.cast(CarParkCode.AN_EXCEPTION_IN_THIS_RECORD);
//        }
        return calculateTheAmounPayable(cfCarParkUseLog, uid, queryMode);

    }

    @Override
    public CfCarParkOrder calculateTheAmounPayable(CfCarParkUseLog cfCarParkUseLog, String uid, String queryMode) throws Exception {

        CfCarParkOrder cfCarParkOrder = calculateTheAmounPayableWithOutOther(cfCarParkUseLog, uid);

        //判断是否存在子订单(代收订单)
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setCollectionShopId(cfCarParkUseLog.getCarParkId());
        cfOrderQuery.setStatus(PayStatus.TO_BE_PAID);
        cfOrderQuery.setEffectObject(cfCarParkUseLog.getNumberPlate());
        List<CfOrder> cfOrders = cfOrderService.getListByQuery(cfOrderQuery);
        //合计代付总金额
        BigDecimal totalCollectionFee = new BigDecimal(0.00);
        if(queryMode.equals(FeeQueryMode.QUERY_MODE_QUERY_AND_UPDATE) && cfOrders!=null && cfOrders.size()>0){
            CfOrder order = new CfOrder();
            order.setCollectionOrderId(cfCarParkOrder.getCfOrder().getId());
            order.setPayTime(System.currentTimeMillis());
            order.setStatus(PayStatus.PAID);
            order.setAmountsPayable(new BigDecimal(0.00));
            order.setAmountActuallyPaid(new BigDecimal(0.00));
            cfOrderService.updateByQuery(order,cfOrderQuery);
            for (CfOrder cfOrder: cfOrders){
                totalCollectionFee = totalCollectionFee.add(cfOrder.getAmountsPayable());
            }
            cfCarParkOrder.getCfOrder().setCollectionAmount(totalCollectionFee.add(cfCarParkOrder.getCfOrder().getCollectionAmount()));
        }

        if(queryMode.equals(FeeQueryMode.QUERY_MODE_QUERY_AND_UPDATE) && totalCollectionFee.doubleValue()>0 && cfCarParkOrder.getCfOrder().getStatus()==PayStatus.TO_BE_PAID){
            cfCarParkOrder.getCfOrder().setPayTime(0l);

            //更新订单和停车记录
            CfOrder cfOrder = new CfOrder();
            cfOrder.setId(cfCarParkOrder.getCfOrder().getId());
            cfOrder.setPayTime(0l);
            cfCarParkOrder.getCfOrder().setPayTime(0l);
            cfOrder.setCollectionAmount(cfCarParkOrder.getCfOrder().getCollectionAmount());
            cfOrder.setPaymentAgencyShortName("");
            cfOrderService.updateByPrimaryKeySelective(cfOrder);
            CfCarParkUseLog parkUseLog = new CfCarParkUseLog();
            parkUseLog.setPayTime(0l);
            parkUseLog.setId(cfCarParkUseLog.getId());
            cfCarParkUseLog.setPayTime(0l);
            cfCarParkUseLogService.updateByPrimaryKeySelective(parkUseLog);
        }

        if(cfCarParkOrder.getCfOrder().getStatus()==PayStatus.TO_BE_PAID){
            cfCarParkUseLog.setPayTime(0l);
            cfCarParkOrder.getCfOrder().setAmountsPayable(cfCarParkOrder.getCfOrder().getAmountsPayable().add(cfCarParkOrder.getCfOrder().getCollectionAmount()));
        }

        if(queryMode.equals(FeeQueryMode.QUERY_MODE_QUERY_AND_UPDATE) && cfCarParkUseLog.getPayTime()>0 && cfCarParkOrder.getCfOrder().getStatus()==PayStatus.TO_BE_PAID && cfCarParkOrder.getCfOrder().getCollectionAmount().doubleValue()==0){
            cfCarParkOrder.getCfOrder().setPayTime(System.currentTimeMillis());
            cfCarParkOrder.getCfOrder().setStatus(PayStatus.PAID);
            cfOrderService.update(cfCarParkOrder.getCfOrder());

            CfCarParkUseLog parkUseLog = new CfCarParkUseLog();
            parkUseLog.setId(cfCarParkUseLog.getId());
            parkUseLog.setPayTime(System.currentTimeMillis());
            cfCarParkUseLog.setPayTime(System.currentTimeMillis());
            cfCarParkUseLogService.updateByPrimaryKeySelective(parkUseLog);
            return cfCarParkOrder;
        }

        if(System.currentTimeMillis()-cfCarParkOrder.getCfOrder().getManualOfferSetTime()<=900000 && cfCarParkOrder.getCfOrder().getManualOffer().doubleValue()>0){
            cfCarParkOrder.setCfOrder(cfCarParkOrder.getCfOrder());
            return cfCarParkOrder;
        }
        if(cfCarParkOrder.getCfCarParkPackage()!=null && cfCarParkOrder.getCfOrder().getStatus()==PayStatus.TO_BE_PAID){
            if(StringUtils.isNotEmpty(uid)){
                if(StringUtils.isEmpty(cfCarParkUseLog.getUid()) && !uid.equals("0") && cfCarParkUseLog.getNumberPlate().indexOf("临")<0) {
                    //套餐车辆，禁止手动更新订单
                    ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
                }
            }
            cfCarParkOrder.getCfOrder().setPayTime(System.currentTimeMillis());
            cfCarParkOrder.getCfOrder().setPaymentAgencyShortName("package");
            cfCarParkOrder.getCfOrder().setAmountActuallyPaid(new BigDecimal(0));
            cfCarParkOrder.getCfOrder().setAmountsPayable(new BigDecimal(0));
        }else if(cfCarParkUseLog.getCfCarParkCarLimit()!=null && cfCarParkUseLog.getCfCarParkCarLimit().getFreeRelease()==(byte)1 && cfCarParkOrder.getCfOrder().getStatus()==PayStatus.TO_BE_PAID){
            cfCarParkOrder.getCfOrder().setPayTime(System.currentTimeMillis());
            cfCarParkOrder.getCfOrder().setPaymentAgencyShortName("system_free_time");
            cfCarParkOrder.getCfOrder().setAmountActuallyPaid(new BigDecimal(0.00));
            cfCarParkOrder.getCfOrder().setAmountsPayable(new BigDecimal(0.00));
            cfCarParkOrder.getCfOrder().setStatus(PayStatus.PAID);
        }else{
            //判断是否存在预支付停车费
            if(cfCarParkUseLog.getSubscribeTime()>0){

            }
        }

        if(queryMode.equals(FeeQueryMode.QUERY_MODE_QUERY_AND_UPDATE) && cfCarParkOrder.getCfOrder().getPayTime()>0 && cfCarParkOrder.getCfOrder().getStatus()==PayStatus.TO_BE_PAID && cfCarParkOrder.getCfOrder().getCollectionAmount().doubleValue()==0){
            cfCarParkOrder.getCfOrder().setStatus(PayStatus.PAID);
            cfCarParkOrder.setCfOrder(cfOrderService.update(cfCarParkOrder.getCfOrder()));
            //更新停车记录支付时间
            CfCarParkUseLog parkUseLog = new CfCarParkUseLog();
            parkUseLog.setId(cfCarParkUseLog.getId());
            parkUseLog.setPayTime(System.currentTimeMillis());
            cfCarParkUseLogService.updateByPrimaryKeySelective(parkUseLog);
        }

        if(cfCarParkOrder.getCfOrder().getPayTime()>0 && queryMode.equals(FeeQueryMode.QUERY_MODE_QUERY_ONLY)){
            cfCarParkOrder.getCfOrder().setPayTime(0l);
            cfCarParkOrder.getCfOrder().setStatus(PayStatus.TO_BE_PAID);
            cfCarParkOrder.getCfCarParkUseLog().setPayTime(0l);
        }

        return cfCarParkOrder;
    }

    // 注意，此方法内禁止设置订单状态为已付，会导致其它方法业务异常
    private CfCarParkOrder calculateTheAmounPayableWithOutOther(CfCarParkUseLog cfCarParkUseLog, String uid) throws Exception{

        Long inTime = cfCarParkUseLog.getInTime();

        //校正出场时间小于入场时间的情况
        if(cfCarParkUseLog.getOutTime()<=cfCarParkUseLog.getInTime()){
            cfCarParkUseLog.setOutTime(System.currentTimeMillis());
        }

        //给2分钟的支付时间，避免在电子支付或者现金支付时，存在临界时间
        if(cfCarParkUseLog.getCountFeeStatus()==(byte)0 && System.currentTimeMillis()-cfCarParkUseLog.getOutTime()>120000){
            cfCarParkUseLog.setOutTime(System.currentTimeMillis());
        }

        List<CfCarParkChargingRules> carParkChargingRules = null;  //停车收费规则(递归降栈内存之用)
        Integer counts = 0; //已经第N次计算费用
        double currentPrice = 0; //当前价格(针对某个时间段按次数算的情况时使用)
        String currentCalculateingCarType = "temporary_car"; //当前计费车辆类型

        //如果为固定费用的停车记录，时间不用实时时间
        if(cfCarParkUseLog.getCountFeeStatus()==(byte)0 && (cfCarParkUseLog.getOutTime()==null || cfCarParkUseLog.getOutTime()==0)){
            cfCarParkUseLog.setOutTime(System.currentTimeMillis());
        }

        if(cfCarParkUseLog.getCfCarParkCarLimit()==null){
            CfCarParkCarLimit carParkCarLimit = cfCarParkCarLimitService.getCarTypeLimit(cfCarParkUseLog.getNumberPlate(), cfCarParkUseLog.getCarParkId());
            cfCarParkUseLog.setCfCarParkCarLimit(carParkCarLimit);
        }
        if(cfCarParkUseLog.getCfCarParkCarLimit()==null){
            //获取临时车的相关限制规则
            CfCarParkCarLimitQuery cfCarParkCarLimitQuery = new CfCarParkCarLimitQuery();
            if(StringUtils.isEmpty(cfCarParkUseLog.getCarType())){
                cfCarParkCarLimitQuery.setCarTypeKey(currentCalculateingCarType);
            }else{
                cfCarParkCarLimitQuery.setCarTypeKey(cfCarParkUseLog.getCarType());
            }
            cfCarParkCarLimitQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
            cfCarParkCarLimitQuery.setPage(1);
            cfCarParkCarLimitQuery.setSize(1);
            List<CfCarParkCarLimit> cfCarParkCarLimits = cfCarParkCarLimitService.getListByQuery(cfCarParkCarLimitQuery);
            if(cfCarParkCarLimits!=null && cfCarParkCarLimits.size()>0){
                cfCarParkUseLog.setCfCarParkCarLimit(cfCarParkCarLimits.get(0));
            }
        }

        CfCarPark cfCarPark = cfCarParkService.findById(cfCarParkUseLog.getCarParkId(), false);
        CfCarPark calculateingCfCarPark = cfCarPark;    //计费时使用的停车场
        calculateingCfCarPark.setCurrentFeeUpperLimit(new BigDecimal(0));

        CfCarParkOrder cfCarParkOrder = new CfCarParkOrder();
        cfCarParkOrder.setCfCarParkUseLog(cfCarParkUseLog);
        cfCarParkOrder.setCfCarPark(cfCarPark);
        CfCarParkCheckpoint inCheckPoint = cfCarParkCheckpointService.findById(cfCarParkUseLog.getInCheckPointId());
        CfCarParkCheckpoint outCheckPoint = cfCarParkCheckpointService.findById(cfCarParkUseLog.getOutCheckPointId());
        cfCarParkOrder.setInCheckpoint(inCheckPoint);
        cfCarParkOrder.setOutCheckpoint(outCheckPoint);

        CfOrder cfOrder = null;
        if(StringUtils.isEmpty(cfCarParkUseLog.getId())){
            //表示系统后台进行价格测算，没有真实的停车记录数据
            cfOrder = new CfOrder();
            cfOrder.setPayTime(0l);
            cfOrder.setStatus(PayStatus.TO_BE_PAID);
            cfOrder.setCollectionAmount(new BigDecimal(0.00));
            cfOrder.setAmountsPayable(new BigDecimal(0.00));
            cfOrder.setAmountActuallyPaid(new BigDecimal(0.00));
        }else{
            CfOrderQuery cfOrderQuery = new CfOrderQuery();
            cfOrderQuery.setGoodsId(cfCarParkUseLog.getId());
            cfOrderQuery.setPage(1);
            cfOrderQuery.setSize(1);
            List<CfOrder> cfOrderList = cfOrderService.getListByQuery(cfOrderQuery);
            if(cfOrderList==null || cfOrderList.size()==0){
                ExceptionCast.cast(PayCode.ORDER_DOES_NOT_EXIST);
            }
            cfOrder = cfOrderList.get(0);
        }
        cfOrder.setUid(uid);

        List<CfCarParkPackage> cfCarParkPackageList = null;

        boolean allowUsePackage =  false;   //是否允许使用套擦(主要避免代付订单与，家庭组套餐中，临时失效的家庭组车辆收费 存在冲突的问题)

        //如果该停车场需要代收，标记当前订单为代收订单(解决旧订单未被标记的问题)
        if(StringUtils.isNotEmpty(cfCarPark.getCollectionCarparkId())){
            cfOrder.setCollectionShopId(cfCarPark.getCollectionCarparkId());
            //判断其套餐是否有效且未被禁用
            //如果为临时车牌，必须有用户id传入
            if(cfCarParkUseLog.getNumberPlate().indexOf("临")>=0 && StringUtils.isEmpty(uid)){
                cfCarParkPackageList = null;
            }else {
                CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
                cfCarParkPackageQuery.setNumberPlate(cfCarParkUseLog.getNumberPlate());
                cfCarParkPackageQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
                cfCarParkPackageQuery.setStatus((byte)1);
                if(cfCarParkUseLog.getNumberPlate().indexOf("临")>=0){
                    cfCarParkPackageQuery.setUid(uid);
                }
                cfCarParkPackageQuery.setOrderBy("end_time desc");
                cfCarParkPackageQuery.setPage(1);
                cfCarParkPackageQuery.setSize(1);
                cfCarParkPackageList = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
            }

            //如果套餐车辆已经过期,判断该类型套餐产品是否有宽限期
            if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getEndTime()<System.currentTimeMillis()){
                CfCarParkPackagePrice cfCarParkPackagePrice = cfCarParkPackagePriceService.findById(cfCarParkPackageList.get(0).getPackagePriceId());
                if(cfCarParkPackagePrice!=null && cfCarParkPackagePrice.getUseGracePeriod()==(byte)1 && cfCarParkPackagePrice.getGracePeriod().longValue()>0){
                    Long endTime = cfCarParkPackageList.get(0).getEndTime();
                    //让宽限期生效
                    cfCarParkPackageList.get(0).setEndTime(endTime+cfCarParkPackagePrice.getGracePeriod().longValue());
                }
            }

            if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getStartTime()<=System.currentTimeMillis() && cfCarParkPackageList.get(0).getEndTime()>System.currentTimeMillis() && cfCarParkPackageList.get(0).getStatus()==(byte)1){
                allowUsePackage = true;
            }else if(cfCarParkPackageList==null || cfCarParkPackageList.size()!=1){
                cfCarParkPackageList = new ArrayList<>();   //避免下面代码再次查询，提高代码执行效率
            }
        }

        CfCarParkPackage cfCarParkPackage = null;
        if(cfCarParkUseLog.getCountFeeStatus()==(byte)0 || allowUsePackage){
            if(cfCarParkPackageList==null){
                if(cfCarParkUseLog.getNumberPlate().indexOf("临")>=0 && StringUtils.isEmpty(uid)){
                    cfCarParkPackageList = null;
                }else {
                    CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
                    cfCarParkPackageQuery.setNumberPlate(cfCarParkUseLog.getNumberPlate());
                    cfCarParkPackageQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
                    if(cfCarParkUseLog.getNumberPlate().indexOf("临")>=0){
                        cfCarParkPackageQuery.setUid(uid);
                    }
                    cfCarParkPackageQuery.setOrderBy("end_time desc");
                    cfCarParkPackageQuery.setStatus((byte)1);
                    cfCarParkPackageQuery.setPage(1);
                    cfCarParkPackageQuery.setSize(1);
                    cfCarParkPackageList = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
                    if(cfCarParkPackageList==null || cfCarParkPackageList.size()==0){
                        cfCarParkPackageQuery.setStatus(null);
                        cfCarParkPackageList = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
                    }
                }
            }

            //如果套餐为特殊车辆套餐，禁止按正常套餐资格给其使用，该车辆仅享受特殊车辆待遇
            if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0){
                if(StringUtils.isNotEmpty(cfCarParkPackageList.get(0).getSpecialCarId())){
                    cfCarParkPackageList = null;
                }
            }

            if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0 && (cfCarParkPackageList.get(0).getStartTime()>System.currentTimeMillis() || cfCarParkPackageList.get(0).getEndTime()<=System.currentTimeMillis())){
                //判断是否在入场之后过期，如果是在入场后过期，计算费用的开始时间要往后延
                if(cfCarParkPackageList.get(0).getEndTime()<=System.currentTimeMillis() && cfCarParkPackageList.get(0).getEndTime()>cfCarParkUseLog.getInTime()){
                    cfCarParkUseLog.setInTime(cfCarParkPackageList.get(0).getEndTime());
                }
                if(calculateingCfCarPark.getSpecialFeeExpiredCar()==(byte)0){
                    //过期月卡按临时车收费
                    currentCalculateingCarType = "temporary_car";
                }
            }else if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0 && cfCarParkPackageList.get(0).getStatus()==(byte)1 && cfCarParkPackageList.get(0).getStartTime()<=System.currentTimeMillis() && cfCarParkPackageList.get(0).getEndTime()>System.currentTimeMillis()){
                cfCarParkPackage = cfCarParkPackageList.get(0);
            }
        }

        if(cfCarParkUseLog.getCfCarParkCarLimit()!=null){
            currentCalculateingCarType = cfCarParkUseLog.getCfCarParkCarLimit().getCarTypeKey();
        }

        Double totalFee = 0d;
        long outTime = cfCarParkUseLog.getOutTime()==0 || cfCarParkUseLog.getOutTime()==null?System.currentTimeMillis():cfCarParkUseLog.getOutTime();

        //使用停车场面板设置
        long freeTime = 0l;
        if(cfCarParkUseLog.getCreatePosition().equals(CarParkUseLogCreatePosition.OUT)){
            //场外产生的停车记录
            freeTime = currentCalculateingCarType.equals("temporary_car")?cfCarPark.getFreeTime():cfCarPark.getExpiredCarFreeTime();
        }else{
            //提前缴费产生的二次停车记录，免停时间使用离场限制时间
            freeTime = cfCarPark.getLeaveTimeLimit();
        }

        //使用私有定制的车限制设置(优先级最高)
        long giveTime = 0l; //赠送的免停时间
        if(cfCarParkUseLog.getCfCarParkCarLimit()!=null){
            //场外进入，使用私有定制的免费时间，场内提前缴费使用私有定制的免费离场时间
            freeTime = cfCarParkUseLog.getCreatePosition().equals(CarParkUseLogCreatePosition.OUT)?
                    cfCarParkUseLog.getCfCarParkCarLimit().getFreeTime():cfCarParkUseLog.getCfCarParkCarLimit().getLeaveTimeLimit();
            if(cfCarParkUseLog.getCfCarParkCarLimit().getGiveFreeTime()==(byte)1){
                giveTime = freeTime;
            }
            if(cfCarParkUseLog.getCfCarParkCarLimit().getFeeUpperLimit().doubleValue()>0){
                cfCarPark.setFeeUpperLimit(cfCarParkUseLog.getCfCarParkCarLimit().getFeeUpperLimit());
            }
        }

        //如果该停车场有设置特殊车牌号，尝试当前车牌号是否为特殊车牌号
        if(StringUtils.isNotEmpty(cfCarPark.getSpecialNumberPlate())){
            String[] specialNumberPlates = cfCarPark.getSpecialNumberPlate().split(",");
            int length = specialNumberPlates.length;
            for(int i=0; i<length; i++ ){
                if(cfCarParkUseLog.getNumberPlate().indexOf(specialNumberPlates[i])>=0){
                    //特殊车牌号直接免停车费，例如警车，消防车，武警车等
                    freeTime = 31536000000l;
                    break;
                }
            }
        }

        //判断该车辆是否有赠送的停车时长
        if(freeTime<(cfCarParkUseLog.getOutTime()-cfCarParkUseLog.getInTime()) && cfCarParkUseLog.getCfCarParkCarLimit()!=null && cfCarParkUseLog.getCfCarParkCarLimit().getCfCarParkSpecialCar()!=null && cfCarParkUseLog.getCfCarParkCarLimit().getCfCarParkSpecialCar().getRemainingParkTime()>0){
            Long remainingParkTime = cfCarParkUseLog.getCfCarParkCarLimit().getCfCarParkSpecialCar().getRemainingParkTime();
            if((freeTime+remainingParkTime)>=(cfCarParkUseLog.getOutTime()-cfCarParkUseLog.getInTime())){
                //说明赠送的停车时长足够抵扣本次停车时长
                //标记停车记录减免的停车时长
                cfCarParkUseLog.setGiveAwayParkTime((cfCarParkUseLog.getOutTime()-cfCarParkUseLog.getInTime())-freeTime);
            }else{
                //赠送的停车时间只能抵扣部分停车时长
                //标记停车记录减免的停车时长
                cfCarParkUseLog.setGiveAwayParkTime(remainingParkTime);
            }
            freeTime += cfCarParkUseLog.getCfCarParkCarLimit().getCfCarParkSpecialCar().getRemainingParkTime();
        }

        cfCarParkUseLog.setFreeTime(freeTime);

        //如果该车辆类型为免费停车类型，直接结束订单
        if(cfCarParkUseLog.getCfCarParkCarLimit()!=null && cfCarParkUseLog.getCfCarParkCarLimit().getFreeRelease()==(byte)1){
            cfOrder.setPayTime(System.currentTimeMillis());
        }

        //只查询一条收费规则的条件
        CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery = new CfCarParkChargingRulesQuery();
        cfCarParkChargingRulesQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
        cfCarParkChargingRulesQuery.setStatus((byte)1);
        cfCarParkChargingRulesQuery.setCarType(currentCalculateingCarType);
        cfCarParkChargingRulesQuery.setPage(1);
        cfCarParkChargingRulesQuery.setSize(1);

        //计费模式，如果该车辆类型未设置，则使用该停车场全局设置的收费模式
        String billingModel = cfCarParkUseLog.getCfCarParkCarLimit()!=null && StringUtils.isNotEmpty(cfCarParkUseLog.getCfCarParkCarLimit().getBillingModel()) ? cfCarParkUseLog.getCfCarParkCarLimit().getBillingModel() : cfCarPark.getBillingModel();
        Long upperLimitTime = cfCarParkUseLog.getCfCarParkCarLimit()!=null ? cfCarParkUseLog.getCfCarParkCarLimit().getUpperLimitTime() : 0l;

        if(cfCarParkUseLog.getInTime()>0 && (cfCarParkUseLog.getOutTime()>cfCarParkUseLog.getInTime()+freeTime) && cfOrder.getPayTime()==0){
            if(billingModel.equals("static")){
                carParkChargingRules = getListByCondition(cfCarParkChargingRulesQuery);
                if(carParkChargingRules==null || carParkChargingRules.size()==0){
                    ExceptionCast.cast(CarParkCode.CHARGING_RULES_NOT_FOUND);
                }
                totalFee = fixedCalculateTheAmounPayable(cfCarParkUseLog.getInTime()+giveTime, outTime, cfCarPark, carParkChargingRules.get(0).getFee().doubleValue(), currentCalculateingCarType, calculateingCfCarPark, counts, upperLimitTime);
            }else if(billingModel.equals("dynamic")){
                totalFee = dynamicCalculateTheAmounPayable(cfCarParkUseLog.getInTime()+giveTime, outTime, 0d, currentCalculateingCarType, calculateingCfCarPark, counts, carParkChargingRules, upperLimitTime, 0d, cfCarParkUseLog.getInTime()+giveTime);
            }else if(billingModel.equals("24_dynamic")){
                currentPrice = 0d;
                totalFee = dynamic24HoursCalculateTheAmounPayable(outTime-cfCarParkUseLog.getInTime()-giveTime, 0l, currentCalculateingCarType, calculateingCfCarPark, counts, carParkChargingRules, currentPrice);
            }else if(billingModel.equals("24_static")){
                carParkChargingRules = getListByCondition(cfCarParkChargingRulesQuery);
                if(carParkChargingRules==null || carParkChargingRules.size()==0){
                    ExceptionCast.cast(CarParkCode.CHARGING_RULES_NOT_FOUND);
                }
                totalFee = fixed24HoursCalculateTheAmounPayable(cfCarParkUseLog.getInTime()+giveTime, outTime, cfCarPark, carParkChargingRules.get(0).getFee().doubleValue(), currentCalculateingCarType, calculateingCfCarPark, counts);
            }else if(billingModel.equals("only_one")){
                //每天只收一次费
                carParkChargingRules = getListByCondition(cfCarParkChargingRulesQuery);
                if(carParkChargingRules==null || carParkChargingRules.size()==0){
                    ExceptionCast.cast(CarParkCode.CHARGING_RULES_NOT_FOUND);
                }
                //查询该车俩是否在当天，当前停车场缴纳过费用
                CfOrderQuery thisDayOrderQuery = new CfOrderQuery();
//                thisDayOrderQuery.setMinPayTime(DateUtil.minMillisecondBaseOnTheDayToTimestamp(System.currentTimeMillis()));
//                thisDayOrderQuery.setMaxPayTime(DateUtil.maxMillisecondBaseOnTheDayToTimestamp(System.currentTimeMillis()));
                thisDayOrderQuery.setGoodsType(GoodsType.CARPARK_PAYMENT);
                thisDayOrderQuery.setStatus(PayStatus.PAID);
                thisDayOrderQuery.setMinAmountActuallyPaid(new BigDecimal("0.01"));
                thisDayOrderQuery.setEffectObject(cfCarParkUseLog.getNumberPlate());
                thisDayOrderQuery.setShopId(cfCarParkUseLog.getCarParkId());
                thisDayOrderQuery.setOrderBy("create_time desc");
                thisDayOrderQuery.setPage(1);
                thisDayOrderQuery.setSize(1);
                List<CfOrder> orderList = cfOrderService.getListByQuery(thisDayOrderQuery);
                if(orderList!=null && orderList.size()>0){
                    //判断上次支付的时间跟本次入场时间是否在同一天，如果在同一天，本次停车时间由入场时间当天晚上12点后开始算起
                    if(DateUtil.maxMillisecondBaseOnTheDayToTimestamp(cfCarParkUseLog.getInTime()).longValue()==DateUtil.maxMillisecondBaseOnTheDayToTimestamp(orderList.get(0).getPayTime()).longValue()){
                        totalFee = dynamicCalculateTheAmounPayable(DateUtil.maxMillisecondBaseOnTheDayToTimestamp(cfCarParkUseLog.getInTime())+1001l+giveTime, outTime, 0d, currentCalculateingCarType, calculateingCfCarPark, counts, carParkChargingRules, upperLimitTime, 0d, DateUtil.maxMillisecondBaseOnTheDayToTimestamp(cfCarParkUseLog.getInTime())+1001l+giveTime);
                    }else{
                        BigDecimal countFee = new BigDecimal("0.00");
                        for (CfOrder order: orderList){
                            countFee.add(order.getAmountActuallyPaid());
                        }
                        totalFee = dynamicCalculateTheAmounPayable(cfCarParkUseLog.getInTime()+giveTime, outTime, 0d, currentCalculateingCarType, calculateingCfCarPark, counts, carParkChargingRules, upperLimitTime, countFee.doubleValue(), cfCarParkUseLog.getInTime()+giveTime);
                    }
                }else{
                    totalFee = dynamicCalculateTheAmounPayable(cfCarParkUseLog.getInTime()+giveTime, outTime, 0d, currentCalculateingCarType, calculateingCfCarPark, counts, carParkChargingRules, upperLimitTime, 0d, cfCarParkUseLog.getInTime()+giveTime);
                }
            }else if(billingModel.equals("24_only_one")){
                cfCarParkChargingRulesQuery.setSize(null);
                //24小时只收一次费
                carParkChargingRules = getListByCondition(cfCarParkChargingRulesQuery);
                if(carParkChargingRules==null || carParkChargingRules.size()==0){
                    ExceptionCast.cast(CarParkCode.CHARGING_RULES_NOT_FOUND);
                }
                //查询该车俩是否在24小时，当前停车场缴纳过费用

                CfOrderQuery thisDayOrderQuery = new CfOrderQuery();
                thisDayOrderQuery.setGoodsType(GoodsType.CARPARK_PAYMENT);
                thisDayOrderQuery.setStatus(PayStatus.PAID);
                thisDayOrderQuery.setMinPayTime(cfCarParkUseLog.getOutTime()-172800000l);
                thisDayOrderQuery.setMinAmountActuallyPaid(new BigDecimal("0.01"));
                thisDayOrderQuery.setEffectObject(cfCarParkUseLog.getNumberPlate());
                thisDayOrderQuery.setShopId(cfCarParkUseLog.getCarParkId());
                thisDayOrderQuery.setOrderBy("pay_time asc");
                List<CfOrder> orderList = cfOrderService.getListByQuery(thisDayOrderQuery);

                CfCarParkUseLog previousCarParkUseLog = null;

                //查询对应的停车记录
                if(orderList!=null && orderList.size()>0){
                    previousCarParkUseLog = cfCarParkUseLogService.findById(orderList.get(orderList.size()-1).getGoodsId(), false);
                }

//                if((cfCarParkUseLog.getOutTime() - cfCarParkUseLog.getInTime()>cfCarPark.getFreeTime()) && orderList!=null && orderList.size()>0 && previousCarParkUseLog!=null && (((cfCarParkUseLog.getOutTime()-previousCarParkUseLog.getInTime())<=86400000l) || ((cfCarParkUseLog.getOutTime()-previousCarParkUseLog.getInTime())>86400000l && (previousCarParkUseLog.getOutTime()-previousCarParkUseLog.getInTime())>86400000l && (cfCarParkUseLog.getOutTime()-previousCarParkUseLog.getOutTime())<=86400000l))){
                if((cfCarParkUseLog.getOutTime() - cfCarParkUseLog.getInTime()>cfCarPark.getFreeTime()) && orderList!=null && orderList.size()>0 && previousCarParkUseLog!=null){
                    //计算N个24小时模
                    double parking24HoursNumbers = Math.ceil((new Double(previousCarParkUseLog.getOutTime() - previousCarParkUseLog.getInTime())) / 86400000d);
                    Long newEstStartTime = new Double((parking24HoursNumbers*86400000d)+new Double(previousCarParkUseLog.getInTime())).longValue();
                    long countPayTime = newEstStartTime;
                    if(newEstStartTime<cfCarParkUseLog.getInTime()){
                        newEstStartTime = cfCarParkUseLog.getInTime();
                    }
                    if(cfCarPark.getFeeUpperLimit().doubleValue()>0 && orderList.get(orderList.size()-1).getAmountsPayable().doubleValue()<cfCarPark.getFeeUpperLimit().doubleValue() && newEstStartTime>cfCarParkUseLog.getInTime()){
                        //本次24小时内，并且收费未达到费用上限
                        newEstStartTime = cfCarParkUseLog.getInTime();
                        countPayTime = cfCarParkUseLog.getOutTime()-86400000l;
                    }
                    if(newEstStartTime<cfCarParkUseLog.getOutTime() && (cfCarParkUseLog.getOutTime() - newEstStartTime>cfCarPark.getFreeTime())){
                        //已经超过上次24小时免费期
                        BigDecimal totalPaid = new BigDecimal("0.00");
                        if(orderList!=null && orderList.size()>0){
                            for(CfOrder order: orderList){
                                if(order.getPayTime()>=countPayTime){
                                    totalPaid = totalPaid.add(order.getAmountsPayable());
                                }
                            }
                        }

                        if(cfCarPark.getFeeUpperLimit().doubleValue()>0 && totalPaid.doubleValue()<cfCarPark.getFeeUpperLimit().doubleValue()){
                            totalFee = dynamic24HoursCalculateTheAmounPayable(outTime-newEstStartTime-giveTime, 0l, currentCalculateingCarType, calculateingCfCarPark, 0, carParkChargingRules, 0d);
                            if(totalPaid.doubleValue()>0 && totalPaid.doubleValue()+totalFee>cfCarPark.getFeeUpperLimit().doubleValue()){
                                totalFee = cfCarPark.getFeeUpperLimit().doubleValue() - totalPaid.doubleValue();
                            }
                        }else{
                            totalFee = 0d;
                        }
                    }else{
                        //还处在上次免费期内
                        totalFee = 0d;
                    }

                }else{
                    currentPrice = 0d;
                    totalFee = dynamic24HoursCalculateTheAmounPayable(outTime-cfCarParkUseLog.getInTime()-giveTime, 0l, currentCalculateingCarType, calculateingCfCarPark, 0, carParkChargingRules, currentPrice);
                }
            }

        }else if(StringUtils.isNotEmpty(uid)){
            if(StringUtils.isEmpty(cfCarParkUseLog.getUid()) && cfCarParkUseLog.getNumberPlate().indexOf("临")<0){
                //免停期，禁止手动更新订单
                ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
            }
        }

        if(totalFee==0 && cfOrder.getStatus()==PayStatus.TO_BE_PAID && cfOrder.getCollectionAmount().doubleValue()==0){
            cfCarParkUseLog.setPayTime(System.currentTimeMillis());
            cfOrder.setPaymentAgencyShortName("system_free_time");
            cfOrder.setPayTime(cfCarParkUseLog.getPayTime());
        }

        if(cfOrder.getStatus()==PayStatus.TO_BE_PAID) {
            cfOrder.setAmountsPayable((new BigDecimal(totalFee.toString())).setScale(2, RoundingMode.DOWN));
        }

        cfCarParkOrder.setCfCarParkPackage(cfCarParkPackage);
        if(cfCarParkPackage!=null && StringUtils.isEmpty(uid) && cfOrder.getStatus()==PayStatus.TO_BE_PAID){
            cfOrder.setPaymentAgencyShortName("package");
            cfOrder.setAmountsPayable(new BigDecimal(0.00));
        }else if(cfCarParkPackage!=null && (StringUtils.isNotEmpty(uid) && !uid.equals("0")) && cfCarParkUseLog.getNumberPlate().indexOf("临")<0){
            //使用套餐，禁止手动更新订单
            ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
        }

        //如果费用为0则不存在代付，不标记代付
        if(cfOrder.getAmountsPayable().doubleValue()==0 && cfOrder.getStatus()==PayStatus.TO_BE_PAID){
            cfOrder.setCollectionShopId("");
            cfOrder.setCollectionOrderId("");
        }

        cfCarParkOrder.setCfOrder(cfOrder);

        //主要解决套餐到期时间卡在停车期间的问题
        cfCarParkOrder.getCfCarParkUseLog().setInTime(inTime);

        return cfCarParkOrder;
    }

    @Override
    public CfCarParkOrder deBugCalculateTheAmounPayable(CfCarParkUseLog cfCarParkUseLog) throws Exception {
        if(cfCarParkUseLog.getNumberPlate()==null){
            cfCarParkUseLog.setNumberPlate("");
        }
        //查询该车牌在指定停车场的车辆类型
        CfCarParkCarLimit carParkCarLimit = cfCarParkCarLimitService.getCarTypeLimit(cfCarParkUseLog.getNumberPlate(), cfCarParkUseLog.getCarParkId());
        cfCarParkUseLog.setCfCarParkCarLimit(carParkCarLimit);
        if(cfCarParkUseLog.getCreatePosition()==null){
            cfCarParkUseLog.setCreatePosition(CarParkUseLogCreatePosition.OUT);
        }
        return calculateTheAmounPayableWithOutOther(cfCarParkUseLog, null);
    }

    @Override
    public CfOrder handleParkingSpaceSubscribeOrder(CfCarParkUseLog cfCarParkUseLog, CfOrder cfOrder, List<CfOrder> cfOrderList) {
        if(cfOrderList.size()>1){
            cfOrderService.update(cfOrder);
            //已经存在补缴订单
            CfOrder order = cfOrderList.get(1);
            BigDecimal amountsPayable = cfOrder.getAmountsPayable();
            BigDecimal amountActuallyPaid = cfOrder.getAmountActuallyPaid();
            order.setAmountsPayable(amountsPayable.subtract(amountActuallyPaid));
            order.setUid(cfOrder.getUid());
            cfOrder = order;
        }else{
            BigDecimal amountsPayable = cfOrder.getAmountsPayable();
            BigDecimal amountActuallyPaid = cfOrder.getAmountActuallyPaid();
            //预支付费用大于本次应缴停车费，多余款项进行退款
            if(amountActuallyPaid.compareTo(amountsPayable)==1){
                cfOrder.setPayTime(System.currentTimeMillis());
                cfOrder.setStatus(PayStatus.PAID);
                cfOrder.setRefundTime(System.currentTimeMillis());
                cfOrder.setRefundAmount(amountActuallyPaid.subtract(amountsPayable));
            }
            //刚刚好足够，支付完成
            else if(amountActuallyPaid.compareTo(amountsPayable)==0){
                cfOrder.setPayTime(System.currentTimeMillis());
                cfOrder.setStatus(PayStatus.PAID);
            }
            //预支付费用小于本次应缴停车费需再次补缴，新增补缴订单
            else{
                CfOrder order = new CfOrder();
                BeanUtils.copyProperties(cfOrder,order);
                order.setGoodsName("停车缴费:"+cfCarParkUseLog.getNumberPlate()+"[追加缴费]");
                order.setAmountsPayable(amountsPayable.subtract(amountActuallyPaid));
                order.setStatus(PayStatus.TO_BE_PAID);
            }
        }
        return cfOrder;
    }

    @Override
    public Double fixedCalculateTheAmounPayable(Long startTime, Long endTime, CfCarPark cfCarPark, Double unitPrice, String currentCalculateingCarType, CfCarPark calculateingCfCarPark, Integer counts, Long upperLimitTime) throws Exception
    {
        //根据自己实际情况计费规则返回
        return 0D;
    }

    @Override
    public Double fixed24HoursCalculateTheAmounPayable(Long startTime, Long endTime, CfCarPark cfCarPark, Double unitPrice, String currentCalculateingCarType, CfCarPark calculateingCfCarPark, Integer counts) throws Exception {
        //根据自己实际情况计费规则返回
        return 0D;
    }

    @Override
    public Double dynamicCalculateTheAmounPayable(Long startTime, Long endTime, Double totalFee, String carType, CfCarPark calculateingCfCarPark, Integer counts,
                                                  List<CfCarParkChargingRules> carParkChargingRules, Long upperLimitTime, Double countFee, Long originalStartTime) throws Exception {
        //根据自己实际情况计费规则返回
        return 0D;
    }

    @Override
    public Double dynamic24HoursCalculateTheAmounPayable(Long totalTime, Long startCountTime, String carType, CfCarPark calculateingCfCarPark, Integer counts, List<CfCarParkChargingRules> carParkChargingRules, double currentPrice) throws Exception {
        //根据自己实际情况计费规则返回
        return 0D;
    }

    @Override
    public List<CfCarParkChargingRules> getListByCarParkId(String carParkId) throws Exception {
        CfCarParkChargingRulesExample cfCarParkChargingRulesExample = new CfCarParkChargingRulesExample();
        CfCarParkChargingRulesExample.Criteria criteria = cfCarParkChargingRulesExample.createCriteria();
        criteria.andCarParkIdEqualTo(carParkId);
        cfCarParkChargingRulesExample.setOrderByClause("start_time ASC");
        List<CfCarParkChargingRules> cfCarParkChargingRules = cfCarParkChargingRulesMapper.selectByExample(cfCarParkChargingRulesExample);
        if(cfCarParkChargingRules!=null && cfCarParkChargingRules.size()>0){
            for(CfCarParkChargingRules carParkChargingRules: cfCarParkChargingRules){
                carParkChargingRules.setStartTime(DateUtil.MillisecondBaseOnTheDayToTimestamp(carParkChargingRules.getStartTime()));
                carParkChargingRules.setEndTime(DateUtil.MillisecondBaseOnTheDayToTimestamp(carParkChargingRules.getEndTime()));
            }
        }
        return cfCarParkChargingRules;
    }

    @Override
    public List<CfCarParkChargingRules> getListByCondition(CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery) {
        CfCarParkChargingRulesExample cfCarParkChargingRulesExample = new CfCarParkChargingRulesExample();
        CfCarParkChargingRulesExample.Criteria criteria = cfCarParkChargingRulesExample.createCriteria();
        if(cfCarParkChargingRulesQuery.getMinStartTime()!=null && cfCarParkChargingRulesQuery.getMinStartTime()>0){
            criteria.andStartTimeGreaterThanOrEqualTo(cfCarParkChargingRulesQuery.getMinStartTime());
        }
        if(cfCarParkChargingRulesQuery.getMaxStartTime()!=null && cfCarParkChargingRulesQuery.getMaxStartTime()>0){
            criteria.andStartTimeLessThanOrEqualTo(cfCarParkChargingRulesQuery.getMaxStartTime());
        }
        if(cfCarParkChargingRulesQuery.getMinEndTime()!=null && cfCarParkChargingRulesQuery.getMinEndTime()>0){
            criteria.andEndTimeGreaterThanOrEqualTo(cfCarParkChargingRulesQuery.getMinEndTime());
        }
        if(cfCarParkChargingRulesQuery.getMaxEndTime()!=null && cfCarParkChargingRulesQuery.getMaxEndTime()>0){
            criteria.andEndTimeLessThanOrEqualTo(cfCarParkChargingRulesQuery.getMaxEndTime());
        }
        if(cfCarParkChargingRulesQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfCarParkChargingRulesQuery.getStatus());
        }
        if(cfCarParkChargingRulesQuery.getCarParkId()!=null){
            criteria.andCarParkIdEqualTo(cfCarParkChargingRulesQuery.getCarParkId());
        }
        if(cfCarParkChargingRulesQuery.getCarType()!=null){
            criteria.andCarTypeEqualTo(cfCarParkChargingRulesQuery.getCarType());
        }

        if(StringUtils.isNotEmpty(cfCarParkChargingRulesQuery.getOrderBy())){
            cfCarParkChargingRulesExample.setOrderByClause(cfCarParkChargingRulesQuery.getOrderBy());
        }else{
            cfCarParkChargingRulesExample.setOrderByClause("start_time ASC");
        }

        if(cfCarParkChargingRulesQuery.getPage()!=null && cfCarParkChargingRulesQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkChargingRulesQuery.getPage(), cfCarParkChargingRulesQuery.getSize());
        }
        return cfCarParkChargingRulesMapper.selectByExample(cfCarParkChargingRulesExample);
    }

    @Override
    public CfCarParkChargingRules add(CfCarParkChargingRules cfCarParkChargingRules) throws Exception {
        cfCarParkChargingRules.setId(idWorker.nextId());
        cfCarParkChargingRules.setCreateTime(System.currentTimeMillis());
        cfCarParkChargingRules.setUpdateTime(System.currentTimeMillis());
        cfCarParkChargingRules.setStatus((byte)1);
        validAndHandleChargingRulesStartEndTime(cfCarParkChargingRules);
        cfCarParkChargingRulesMapper.insert(cfCarParkChargingRules);
        cfCarParkChargingRules.setStartTime(DateUtil.MillisecondBaseOnTheDayToTimestamp(cfCarParkChargingRules.getStartTime()));
        cfCarParkChargingRules.setEndTime(DateUtil.MillisecondBaseOnTheDayToTimestamp(cfCarParkChargingRules.getEndTime()));
        updateCarParkCurrentPrice(cfCarParkChargingRules.getCarParkId());
        return cfCarParkChargingRules;
    }

    @Override
    public CfCarParkChargingRules update(CfCarParkChargingRules cfCarParkChargingRules) throws Exception {
        CfCarParkChargingRules parkChargingRules = cfCarParkChargingRulesMapper.selectByPrimaryKey(cfCarParkChargingRules.getId());
        if(parkChargingRules==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        cfCarParkChargingRules.setCreateTime(parkChargingRules.getCreateTime());
        cfCarParkChargingRules.setUpdateTime(System.currentTimeMillis());
        validAndHandleChargingRulesStartEndTime(cfCarParkChargingRules);
        cfCarParkChargingRulesMapper.updateByPrimaryKey(cfCarParkChargingRules);
        cfCarParkChargingRules.setStartTime(DateUtil.MillisecondBaseOnTheDayToTimestamp(cfCarParkChargingRules.getStartTime()));
        cfCarParkChargingRules.setEndTime(DateUtil.MillisecondBaseOnTheDayToTimestamp(cfCarParkChargingRules.getEndTime()));
        updateCarParkCurrentPrice(cfCarParkChargingRules.getCarParkId());
        return cfCarParkChargingRules;
    }

    /**
     * 更新停车场列表对外显示价格
     * @param carParkId
     */
    private void updateCarParkCurrentPrice(String carParkId){
        CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery = new CfCarParkChargingRulesQuery();
        cfCarParkChargingRulesQuery.setCarParkId(carParkId);
        cfCarParkChargingRulesQuery.setOrderBy("fee asc");
        cfCarParkChargingRulesQuery.setPage(1);
        cfCarParkChargingRulesQuery.setSize(1);
        List<CfCarParkChargingRules> cfCarParkChargingRules = getListByCondition(cfCarParkChargingRulesQuery);
        if(cfCarParkChargingRules!=null && cfCarParkChargingRules.size()>0){
            CfCarPark cfCarPark = new CfCarPark();
            cfCarPark.setId(carParkId);
            cfCarPark.setCurrentPrice(cfCarParkChargingRules.get(0).getFee());
            cfCarParkService.update(cfCarPark);
        }
    }

    @Override
    public Integer delete(String cfCarParkChargingRulesId) {
        return cfCarParkChargingRulesMapper.deleteByPrimaryKey(cfCarParkChargingRulesId);
    }

    @Override
    public Integer deleteByQuery(CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery) {
        return cfCarParkChargingRulesMapper.deleteByExample(getExampleByQuery(cfCarParkChargingRulesQuery));
    }

    @Override
    public CfCarParkChargingRulesExample getExampleByQuery(CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery) {
        CfCarParkChargingRulesExample cfCarParkChargingRulesExample = new CfCarParkChargingRulesExample();
        CfCarParkChargingRulesExample.Criteria criteria = cfCarParkChargingRulesExample.createCriteria();
        if(StringUtils.isNotEmpty(cfCarParkChargingRulesQuery.getCarParkId())){
            criteria.andCarParkIdEqualTo(cfCarParkChargingRulesQuery.getCarParkId());
        }

        if(StringUtils.isNotEmpty(cfCarParkChargingRulesQuery.getOrderBy())){
            cfCarParkChargingRulesExample.setOrderByClause(cfCarParkChargingRulesQuery.getOrderBy());
        }
        if(cfCarParkChargingRulesQuery.getPage()!=null && cfCarParkChargingRulesQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkChargingRulesQuery.getPage(), cfCarParkChargingRulesQuery.getSize());
        }
        return cfCarParkChargingRulesExample;
    }

    @Override
    public CfCarParkChargingRules validAndHandleChargingRulesStartEndTime(CfCarParkChargingRules cfCarParkChargingRules) {
        if(cfCarParkChargingRules.getEndTime()<=cfCarParkChargingRules.getStartTime()){
            ExceptionCast.cast(CarParkCode.END_TIME_MUST_BE_GREATER_THAN_START_TIME);
        }
        try {
            cfCarParkChargingRules.setStartTime(DateUtil.getMillisecondBaseOnTheDay(cfCarParkChargingRules.getStartTime()));
            cfCarParkChargingRules.setEndTime(DateUtil.getMillisecondBaseOnTheDay(cfCarParkChargingRules.getEndTime()));
        } catch (Exception e) {
            ExceptionCast.cast(CommonCode.SERVER_ERROR, e.getMessage());
        }
        return cfCarParkChargingRules;
    }

    @Override
    public ResultMap payForCarUseLog(CfOrder cfOrder, String payTypeId, String ipAddress) throws Exception {
        return cfOrderService.payForOrder(cfOrder, payTypeId, ipAddress);
    }

    @Override
    public CfOrder automaticPayment(CfCarParkUseLog cfCarParkUseLog, String numberPlate) throws Exception {

        //先计算没有任何优惠的停车费
        cfCarParkUseLog.setUid("0");
        CfCarParkOrder cfCarParkOrder = calculateTheAmounPayable(cfCarParkUseLog, "0", FeeQueryMode.QUERY_MODE_QUERY_AND_UPDATE);
        //自动使用优惠券
        CfOrder cfOrder = autoUseCouponDeduction(cfCarParkOrder.getCfOrder());
        if(cfOrder.getPayTime()>0){
            return cfOrder;
        }

        //使用账户余额支付
        cfOrder = accountPay(cfOrder);

        //暂时不继续往下走
        return cfOrder;

//        CfUserPaymentAgency cfUserPaymentAgency = cfCarParkPaymentAgencyService.getUserPaymentAgencyByCarParkIdAndShortName(cfCarParkOrder.getCfCarPark().getId(), "ccb_pay");
//        CCBScannedChargebackForm ccbScannedChargebackForm = new CCBScannedChargebackForm();
//        ccbScannedChargebackForm.setMERFLAG("1");
//        ccbScannedChargebackForm.setORDERID(cfOrder.getId());
//        ccbScannedChargebackForm.setAMOUNT(cfOrder.getAmountActuallyPaid().setScale(2, BigDecimal.ROUND_DOWN));
//        ccbScannedChargebackForm.setPROINFO(cfOrder.getGoodsName());
//        ccbScannedChargebackForm.setAUTHNO(numberPlate);
//
//        //检查是否绑定了无感支付，若开通了无感支付尝试使用无感支付
//        cfOrder = secretFreePayment(cfOrder, cfUserPaymentAgency, ccbScannedChargebackForm);
//        if(cfOrder.getPayTime()>0){
//            return cfOrder;
//        }
//
//        //如果未开启无感支付或者无感支付失败，进行被扫码收款
//        return scannedChargeback(cfOrder, cfUserPaymentAgency, ccbScannedChargebackForm);
    }

    @Override
    public CfOrder accountPay(CfOrder cfOrder) {
        CfCarParkCarQuery cfCarParkCarQuery = new CfCarParkCarQuery();
        cfCarParkCarQuery.setNumberPlate(cfOrder.getEffectObject());
        cfCarParkCarQuery.setStatus((byte)2);

        List<CfCarParkCar> cfCarParkCars = cfCarParkCarService.mapperSelectByQuery(cfCarParkCarQuery);
        if(cfCarParkCars==null || cfCarParkCars.size()==0){
            return cfOrder;
        }
        try{
            CfAccountQuery cfAccountQuery = new CfAccountQuery();
            cfAccountQuery.setUid(cfCarParkCars.get(0).getUid());
            cfAccountQuery.setScoreType("cny");
            cfAccountQuery.setChangeValue(cfOrder.getAmountsPayable().negate());
            CfAccount cfAccount = cfAccountService.checkAndUseBalanceByQuery(cfAccountQuery);
            if(cfAccount!=null){
                cfOrder.setStatus(PayStatus.PAID);
                cfOrder.setPayTime(System.currentTimeMillis());
                cfOrder.setAmountActuallyPaid(cfOrder.getAmountsPayable());
                cfOrder.setPaymentAgencyShortName("system_fund_account");
                cfOrder = cfOrderService.update(cfOrder);
            }
        } catch (Exception e){
            return cfOrder;
        }
        return cfOrder;
    }

    @Override
    public CfOrder ccbPayTest(String carParkUseLogId, String numberPlate) throws Exception {
        //先计算没有任何优惠的停车费
        CfCarParkOrder cfCarParkOrder = calculateTheAmounPayable(carParkUseLogId, "", FeeQueryMode.QUERY_MODE_QUERY_AND_UPDATE);
        CfUserPaymentAgency cfUserPaymentAgency = cfUserPaymentAgencyService.findById("1338784889721450496", false);

        CfOrder cfOrder = cfCarParkOrder.getCfOrder();

        CCBScannedChargebackForm ccbScannedChargebackForm = new CCBScannedChargebackForm();
        ccbScannedChargebackForm.setMERFLAG("1");
        ccbScannedChargebackForm.setORDERID(cfOrder.getId());
        ccbScannedChargebackForm.setAMOUNT(cfOrder.getAmountActuallyPaid().setScale(2, BigDecimal.ROUND_DOWN));
        ccbScannedChargebackForm.setPROINFO(cfOrder.getGoodsName());
        ccbScannedChargebackForm.setAUTHNO(numberPlate);

        //检查是否绑定了无感支付，若开通了无感支付尝试使用无感支付
        cfOrder = secretFreePayment(cfOrder, cfUserPaymentAgency, ccbScannedChargebackForm);
        return cfOrder;
    }

    @Override
    public CfOrder autoUseCouponDeduction(CfOrder cfOrder) {

        if(cfOrder.getPayTime()>0){
            return cfOrder;
        }
        cfOrder.setUid("");
        List<CfCoupon> cfCoupons = cfCouponService.getAvailableByShopIdAndScenes(System.currentTimeMillis(),cfOrder.getShopId(),CouponScenes.CARPARK,cfOrder.getEffectObject(),cfOrder.getUid());

        //TODO 后期此代码要删除掉(优惠通知提醒绑定车牌服务上线后)
        if(cfCoupons==null || cfCoupons.size()==0){
            //若车牌无法直接匹配到优惠券，再次尝试从绑定车辆人员从进行寻找优惠券进行抵扣
            cfCoupons = cfCouponService.getAvailableByShopIdAndScenesAndLinkUids(System.currentTimeMillis(), cfOrder.getShopId(), CouponScenes.CARPARK, cfOrder.getEffectObject());
        }

        if(cfCoupons!=null && cfCoupons.size()>0){

            BigDecimal amountsPayable = cfOrder.getAmountsPayable();

            cfOrder.setCouponId(cfCoupons.get(0).getId());

            CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.findById(cfOrder.getGoodsId(), false);
            if(cfCarParkUseLog.getOutTime()==0){
                cfCarParkUseLog.setOutTime(System.currentTimeMillis());
            }

            if((cfCoupons.get(0).getCouponType()==(byte)1 && cfCoupons.get(0).getDenomination().intValue()>0) ||
                    (cfCoupons.get(0).getCouponType()==(byte)3 && cfCoupons.get(0).getDenomination().longValue()+cfCarParkUseLog.getInTime()>=cfCarParkUseLog.getOutTime())){
                //如果该优惠券为次数券或者满足条件的时长券直接抵扣
                cfOrder.setStatus(PayStatus.PAID);
                cfOrder.setPayTime(System.currentTimeMillis());
                cfOrder.setAmountActuallyPaid(new BigDecimal("0"));
                cfOrder.setCouponPaid(amountsPayable);
                cfOrder.setCouponId(cfCoupons.get(0).getId());
                cfOrder.setPaymentAgencyShortName("coupon");
                if(cfCoupons.get(0).getCouponType()!=(byte)1 || (cfCoupons.get(0).getCouponType()==(byte)1 && cfCoupons.get(0).getDenomination().intValue()==1)){
                    cfCoupons.get(0).setStatus(CouponStatus.USED);
                }
                if(cfCoupons.get(0).getCouponType()==(byte)1){
                    cfCoupons.get(0).setDenomination(cfCoupons.get(0).getDenomination().subtract(new BigDecimal(1)));
                }
                cfCoupons.get(0).setAmountUsed(amountsPayable);
                //直接更新订单
                cfOrder = cfOrderService.update(cfOrder);
                //将优惠券直接使用掉
                cfCoupons.get(0).setUseTime(System.currentTimeMillis());
                cfCouponService.update(cfCoupons.get(0));
            }else if(cfCoupons.get(0).getCouponType()==(byte)2 && amountsPayable.doubleValue()<=cfCoupons.get(0).getDenomination().doubleValue()){
                //券完全抵扣
                cfOrder.setStatus(PayStatus.PAID);
                cfOrder.setPayTime(System.currentTimeMillis());
                cfOrder.setAmountActuallyPaid(new BigDecimal("0"));
                cfOrder.setCouponPaid(amountsPayable);
                cfOrder.setCouponId(cfCoupons.get(0).getId());
                cfOrder.setPaymentAgencyShortName("coupon");
                cfCoupons.get(0).setAmountUsed(amountsPayable);
                cfCoupons.get(0).setStatus(CouponStatus.USED);
                //直接更新订单
                cfOrder = cfOrderService.update(cfOrder);
                //将优惠券直接使用掉
                cfCoupons.get(0).setUseTime(System.currentTimeMillis());
                cfCouponService.update(cfCoupons.get(0));
            }else if(cfCoupons.get(0).getCouponType()==(byte)2 && amountsPayable.doubleValue()>cfCoupons.get(0).getDenomination().doubleValue()){
                //券部分抵扣
                cfOrder.setCouponPaid(cfCoupons.get(0).getDenomination());
                cfOrder.setCouponId(cfCoupons.get(0).getId());
            }
        }
        return cfOrder;
    }

    @Override
    public CfOrder scannedChargeback(CfOrder cfOrder, CfUserPaymentAgency cfUserPaymentAgency, CCBScannedChargebackForm ccbScannedChargebackForm) throws Exception {
        if(cfOrder.getAmountsPayable().doubleValue()==0){
            return cfOrder;
        }
        ccbScannedChargebackForm.setTXCODE("PAY100");
        CCBScannedChargeback ccbScannedChargeback = ccBpayService.ccbPayRequest("https://ibsbjstar.ccb.com.cn/CCBIS/B2CMainPlat_00_BEPAY?", cfUserPaymentAgency, ccbScannedChargebackForm, "get");
        //TODO 更新订单相关数据

        return cfOrder;
    }

    @Override
    public CfOrder secretFreePayment(CfOrder cfOrder, CfUserPaymentAgency cfUserPaymentAgency, CCBScannedChargebackForm ccbScannedChargebackForm) throws Exception {
        if(cfOrder.getAmountsPayable().doubleValue()==0){
            return cfOrder;
        }
        //先检查是否存在无感支付
        ccbScannedChargebackForm.setTXCODE("CXY001");
        CCBScannedChargeback ccbScannedChargeback = ccBpayService.ccbPayRequest("https://ibsbjstar.ccb.com.cn/CCBIS/B2CMainPlat_02_BEPAY?", cfUserPaymentAgency, ccbScannedChargebackForm,"post");
        //TODO 判断是否存在无感支付，如果不存在无感支付直接返回账单，继续其他方式支付

        //申请无感支付
//        ccbScannedChargebackForm.setTXCODE("CXY000");
//        ccbScannedChargeback = ccBpayService.ccbPayRequest("https://ibsbjstar.ccb.com.cn/CCBIS/B2CBEMainPlat_00_ENPAY?", cfUserPaymentAgency, ccbScannedChargebackForm,"post");
        //TODO 更新订单相关数据

        return cfOrder;
    }
}
