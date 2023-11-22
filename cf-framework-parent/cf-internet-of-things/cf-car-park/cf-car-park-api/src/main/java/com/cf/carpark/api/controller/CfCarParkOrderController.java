package com.cf.carpark.api.controller;

import com.cf.carpark.api.config.AuthenticationInterceptor;
import com.cf.carpark.api.swagger.CfCarParkOrderSwagger;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.PayForCarUseLog;
import com.cf.carpark.domain.type.FeeQueryMode;
import com.cf.carpark.service.CfCarParkChargingRulesService;
import com.cf.carpark.service.CfCarParkUseLogService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.domain.type.CouponScenes;
import com.cf.pay.domain.type.CouponStatus;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfCouponService;
import com.cf.pay.service.CfOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * 停车订单
 *
 * @ClassName CfCarParkOrderController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/5/005 15:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("carparkorder/")
@Validated
public class CfCarParkOrderController implements CfCarParkOrderSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponService cfCouponService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "queryOrderByUseId", method = RequestMethod.GET)
    public ResponseResult queryOrderByUseId(String id, String couponId, String useCoupon) throws Exception {
        if(StringUtils.isEmpty(useCoupon)){
            useCoupon = "yes";
        }
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkOrder cfCarParkOrder = cfCarParkChargingRulesService.calculateTheAmounPayable(id, "", FeeQueryMode.QUERY_MODE_QUERY_ONLY);
        CfOrder cfOrder = cfCarParkOrder.getCfOrder();
        if(System.currentTimeMillis()-cfOrder.getManualOfferSetTime()<=900000){
            BigDecimal amountsPayable = cfOrder.getAmountsPayable();
            cfOrder.setAmountsPayable(amountsPayable.subtract(cfOrder.getManualOffer()));
        }else{
            cfOrder.setAmountsPayable(cfCarParkOrder.getCfOrder().getAmountsPayable());
        }
//        //更新应付金额
//        if(cfCarParkOrder.getCfOrder().getStatus()== PayStatus.TO_BE_PAID){
//            CfOrder order = new CfOrder();
//            order.setId(cfOrder.getId());
//            order.setAmountsPayable(cfOrder.getAmountsPayable());
//            cfOrderService.updateByPrimaryKeySelective(order);
//        }
        cfCarParkOrder.setCfOrder(cfOrder);
        if(useCoupon.equals("yes")){
            cfCarParkOrder.setCfCouponList(cfCouponService.getAvailableByShopIdAndScenes(System.currentTimeMillis(), cfCarParkOrder.getCfOrder().getShopId(), CouponScenes.CARPARK, cfCarParkOrder.getCfOrder().getEffectObject(),userBasicInfo.getId()));
            if(StringUtils.isEmpty(couponId) && cfCarParkOrder.getCfCouponList()!=null && cfCarParkOrder.getCfCouponList().size()>0){
                couponId = cfCarParkOrder.getCfCouponList().get(0).getId();
            }
            if(StringUtils.isNotEmpty(couponId)){
                CfCoupon cfCoupon = cfCouponService.findById(couponId, false);
                if(cfCoupon.getCouponType()==(byte)3 && cfCoupon.getDenomination().longValue()+cfCarParkOrder.getCfCarParkUseLog().getInTime()<cfCarParkOrder.getCfCarParkUseLog().getOutTime()){
                    long inTime = cfCoupon.getDenomination().longValue() + cfCarParkOrder.getCfCarParkUseLog().getInTime();
                    cfCarParkOrder.getCfCarParkUseLog().setInTime(inTime);
                }
                if(cfCarParkOrder.getCfOrder().getStatus()!=0){
                    ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
                }

                //如果人工设置了优惠金额，电子优惠券不再使用
                boolean usedCoupon = true;
                if(cfCarParkOrder.getCfOrder().getManualOfferSetTime()==0 || (System.currentTimeMillis()-cfCarParkOrder.getCfOrder().getManualOfferSetTime()>=900000)){
                    if(System.currentTimeMillis()<cfCoupon.getEffectiveTime() || System.currentTimeMillis()>cfCoupon.getExpireTime() || cfCoupon.getStatus()!=1){
                        usedCoupon = false;
                    }

                    if(StringUtils.isNotEmpty(cfCoupon.getGoodsId()) && !cfCoupon.getGoodsId().equals(cfCarParkOrder.getCfCarParkUseLog().getNumberPlate())){
                        usedCoupon = false;
                    }else if(StringUtils.isEmpty(cfCoupon.getGoodsId()) && StringUtils.isNotEmpty(cfCoupon.getToUid()) && !cfCoupon.getToUid().equals(userBasicInfo.getId())){
                        usedCoupon = false;
                    }

                    if(cfCoupon.getScenes()!=0 && cfCoupon.getScenes()!=1){
                        usedCoupon = false;
                    }
                    if(StringUtils.isNotEmpty(cfCoupon.getGoodsId()) && !cfCoupon.getGoodsId().equals(cfCarParkOrder.getCfCarParkUseLog().getNumberPlate())){
                        usedCoupon = false;
                    }
                    if(cfCoupon.getCouponType()==(byte)1 ||
                            (cfCoupon.getCouponType()==(byte)2 && cfCoupon.getDenomination().doubleValue()>=cfCarParkOrder.getCfOrder().getAmountsPayable().doubleValue()) ||
                            (cfCoupon.getCouponType()==(byte)3 && cfCoupon.getDenomination().longValue()+cfCarParkOrder.getCfCarParkUseLog().getInTime()>=cfCarParkOrder.getCfCarParkUseLog().getOutTime())
                    ){
                        //禁止手动优惠券全额支付
                        ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
                    }else if(usedCoupon){
                        if(cfCoupon.getCouponType()==(byte)2){
                            cfCarParkOrder.getCfOrder().setAmountsPayable(
                                    cfCarParkOrder.getCfOrder().getAmountsPayable().subtract(cfCoupon.getDenomination())
                            );
                        }
                    }
                }
                if(cfCarParkOrder.getCfOrder().getStatus()!=0){
                    ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
                }
            }
        }

        //模糊掉返回停车数据
        if(cfCarParkOrder.getCfCarPark()!=null){
            cfCarParkOrder.getCfCarPark().setName(StringTools.vaguePartString(cfCarParkOrder.getCfCarPark().getName(),3,2));
            cfCarParkOrder.getCfCarPark().setPositionX(null);
            cfCarParkOrder.getCfCarPark().setPositionY(null);
        }
        if(cfCarParkOrder.getInCheckpoint()!=null){
            cfCarParkOrder.getInCheckpoint().setName(StringTools.vaguePartString(cfCarParkOrder.getInCheckpoint().getName(),3,2));
            cfCarParkOrder.getInCheckpoint().setPositionX(null);
            cfCarParkOrder.getInCheckpoint().setPositionY(null);
        }
        if(cfCarParkOrder.getOutCheckpoint()!=null){
            cfCarParkOrder.getOutCheckpoint().setName(StringTools.vaguePartString(cfCarParkOrder.getOutCheckpoint().getName(),3,2));
            cfCarParkOrder.getOutCheckpoint().setPositionX(null);
            cfCarParkOrder.getOutCheckpoint().setPositionY(null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkOrder);
    }

    @Override
    @RequestMapping(value = "payForCarUseLog", method = RequestMethod.PUT)
    public ResponseResult payForCarUseLog(HttpServletRequest httpServletRequest, @RequestBody @Validated PayForCarUseLog payForCarUseLog) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        ResultMap resultMap = StringUtils.isEmpty(payForCarUseLog.getCouponId()) ? cfCarParkChargingRulesService.calculateTheAmounPayableAndHandlePay(payForCarUseLog.getId(), userBasicInfo.getId(), payForCarUseLog.getPayTypeId(), HttpClient.getIPAddress(httpServletRequest)) :
                cfCarParkChargingRulesService.calculateTheAmounPayableAndHandlePay(payForCarUseLog.getId(), userBasicInfo.getId(), payForCarUseLog.getCouponId(), payForCarUseLog.getPayTypeId(), HttpClient.getIPAddress(httpServletRequest));
        return new ResponseResult(CommonCode.SUCCESS, resultMap);
    }

    @Override
    public CfOrder getOrderByCarUseLogId(String carParkUseLogId) {
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setGoodsType(GoodsType.CARPARK_PAYMENT);
        cfOrderQuery.setGoodsId(carParkUseLogId);
        List<CfOrder> listByCondition = cfOrderService.getListByQuery(cfOrderQuery);
        if(listByCondition==null || listByCondition.size()==0){
            ExceptionCast.cast(PayCode.ORDER_DOES_NOT_EXIST);
        }
        return listByCondition.get(0);
    }
}
