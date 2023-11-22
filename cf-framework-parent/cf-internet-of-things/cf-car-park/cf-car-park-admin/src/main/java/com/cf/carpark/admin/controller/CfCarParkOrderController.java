package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkOrderSwagger;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import com.cf.carpark.domain.request.CfCarParkSpecialCarQuery;
import com.cf.carpark.domain.type.FeeQueryMode;
import com.cf.carpark.service.*;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.report.CountByDay;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.request.CfCountFinanceQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.domain.type.CouponScenes;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfCouponService;
import com.cf.pay.service.CfOrderService;
import com.cf.ucenter.service.CfSystemConfigService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
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
@RequestMapping("carparkOrderAdmin/")
@Validated
public class CfCarParkOrderController implements CfCarParkOrderSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfOrderService cfOrderService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfCouponService cfCouponService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfCarParkPackageService cfCarParkPackageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfCarParkCarTypeService cfCarParkCarTypeService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfSystemConfigService cfSystemConfigService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfCarParkSpecialCarService cfCarParkSpecialCarService;
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected CarParkController carParkController;

    @PreAuthorize("hasAuthority('carpark-CfCarParkOrderController-queryOrderByUseId')")
    @Override
    @RequestMapping(value = "queryOrderByUseId", method = RequestMethod.GET)
    public ResponseResult queryOrderByUseId(String id, String mode) throws Exception {
        CfCarParkOrder cfCarParkOrder = null;
        if(StringUtils.isEmpty(mode)){
            mode = "realTime";
        }

        CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.findById(id, false);
        if(mode.equals("realTime")){
            cfCarParkOrder = cfCarParkChargingRulesService.calculateTheAmounPayable(cfCarParkUseLog, "", FeeQueryMode.QUERY_MODE_QUERY_ONLY);
        }else{
            cfCarParkUseLog.setCountFeeStatus((byte)1);
            cfCarParkOrder = cfCarParkChargingRulesService.calculateTheAmounPayable(cfCarParkUseLog, "", FeeQueryMode.QUERY_MODE_QUERY_ONLY);
        }

        String fileSourceAddress = cfSystemConfigService.getValueByKey("file_source_address", "http://file.cfeng.wang/");
        if(cfCarParkOrder.getCfCarParkUseLog()!=null){
            FileUtils.handleFileSourcePrefix(cfCarParkOrder.getCfCarParkUseLog(), fileSourceAddress, "inSmallImage");
            FileUtils.handleFileSourcePrefix(cfCarParkOrder.getCfCarParkUseLog(), fileSourceAddress, "outSmallImage");
            FileUtils.handleFileSourcePrefix(cfCarParkOrder.getCfCarParkUseLog(), fileSourceAddress, "inBigImage");
            FileUtils.handleFileSourcePrefix(cfCarParkOrder.getCfCarParkUseLog(), fileSourceAddress, "outBigImage");
        }

        //更新应付金额
        if(cfCarParkOrder.getCfOrder().getStatus()== PayStatus.TO_BE_PAID){
            CfOrder order = new CfOrder();
            order.setId(cfCarParkOrder.getCfOrder().getId());
            order.setAmountsPayable(cfCarParkOrder.getCfOrder().getAmountsPayable());
            cfOrderService.updateByPrimaryKeySelective(order);
        }

        //查询优惠券
        List<CfCoupon> cfCoupons = cfCouponService.getAvailableByShopIdAndScenes(System.currentTimeMillis(), cfCarParkOrder.getCfOrder().getShopId(), CouponScenes.CARPARK, cfCarParkOrder.getCfOrder().getEffectObject(), "");
        //查询套餐
        CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
        cfCarParkPackageQuery.setNumberPlate(cfCarParkOrder.getCfCarParkUseLog().getNumberPlate());
        cfCarParkPackageQuery.setCarParkId(cfCarParkOrder.getCfCarParkUseLog().getCarParkId());
//        cfCarParkPackageQuery.setMinEndTime(System.currentTimeMillis());
        cfCarParkPackageQuery.setPage(1);
        cfCarParkPackageQuery.setSize(1);
        List<CfCarParkPackage> cfCarParkPackageList = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
        if(cfCarParkPackageList!=null && cfCarParkPackageList.size()>0){
            //填充套餐名称
            CfCarParkCarType cfCarParkCarType = cfCarParkCarTypeService.findByKey(cfCarParkPackageList.get(0).getTypeKey(), false);
            cfCarParkOrder.setCfCarParkCarType(cfCarParkCarType);
            cfCarParkPackageList.get(0).setName(cfCarParkCarType.getName());
            cfCarParkOrder.setCfCarParkPackage(cfCarParkPackageList.get(0));
            if(cfCarParkPackageList.get(0).getEndTime()>System.currentTimeMillis() && cfCarParkPackageList.get(0).getStatus()==(byte)1){
                cfCarParkOrder.getCfOrder().setAmountsPayable(new BigDecimal("0.00"));
                cfCarParkOrder.getCfOrder().setAmountActuallyPaid(new BigDecimal("0.00"));
            }
        }else{
            CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
            cfCarParkSpecialCarQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
            cfCarParkSpecialCarQuery.setNumberPlate(cfCarParkUseLog.getNumberPlate());
            List<CfCarParkSpecialCar> cfCarParkSpecialCars = cfCarParkSpecialCarService.getListByQuery(cfCarParkSpecialCarQuery);
            if(cfCarParkSpecialCars!=null && cfCarParkSpecialCars.size()>0){
                cfCarParkOrder.setCfCarParkSpecialCar(cfCarParkSpecialCars.get(0));
                CfCarParkCarType cfCarParkCarType = cfCarParkCarTypeService.findByKey(cfCarParkSpecialCars.get(0).getTypeKey(), false);
                cfCarParkOrder.setCfCarParkCarType(cfCarParkCarType);
            }else{
                //没有数据这设置为临时车
                CfCarParkCarType cfCarParkCarType = cfCarParkCarTypeService.findByKey("temporary_car", false);
                cfCarParkOrder.setCfCarParkCarType(cfCarParkCarType);
            }
        }

        cfCarParkOrder.setCfCouponList(cfCoupons);

        return new ResponseResult(CommonCode.SUCCESS, cfCarParkOrder);
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

    @PreAuthorize("hasAuthority('carpark-CfCarParkOrderController-countByQuery')")
    @Override
    @RequestMapping(value = "countByQuery", method = RequestMethod.GET)
    public ResponseResult countByQuery(CfCountFinanceQuery cfCountFinanceQuery) throws Exception {

        if(StringUtils.isEmpty(cfCountFinanceQuery.getDate())){
            cfCountFinanceQuery.setDate("2018-01-01 00:00:00");
        }
        if(StringUtils.isEmpty(cfCountFinanceQuery.getEndDate())){
            cfCountFinanceQuery.setEndDate(DateUtil.stampToDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        }

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        List<CfCarParkLinkUser> linkUsers = carParkController.getLinkUsersAndCheck(userBasicInfo);
        if(linkUsers!=null && linkUsers.size()>0){
            cfCountFinanceQuery.setShopIds(new ArrayList<>());
            for (CfCarParkLinkUser cfCarParkLinkUser: linkUsers){
                cfCountFinanceQuery.getShopIds().add(cfCarParkLinkUser.getCarParkId());
            }
        }

        List<CountByDay> countByDays = cfOrderService.limitDaysCountByDayFromPayTime(cfCountFinanceQuery);
        return new ResponseResult(CommonCode.SUCCESS, countByDays);
    }
}
