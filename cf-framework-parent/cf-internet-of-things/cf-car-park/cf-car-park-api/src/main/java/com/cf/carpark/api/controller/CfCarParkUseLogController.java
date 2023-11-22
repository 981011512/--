package com.cf.carpark.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.api.config.AuthenticationInterceptor;
import com.cf.carpark.api.swagger.CfCarParkUseLogSwagger;
import com.cf.carpark.device.camera.ZhenShi911202002050;
import com.cf.carpark.domain.CfCarParkCar;
import com.cf.carpark.domain.CfCarParkReleaseLog;
import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.CfCarParkCarQuery;
import com.cf.carpark.domain.request.CfCarParkUseLogForm;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.carpark.domain.type.DeviceBrand;
import com.cf.carpark.domain.type.FeeQueryMode;
import com.cf.carpark.service.CfCarParkCarService;
import com.cf.carpark.service.CfCarParkChargingRulesService;
import com.cf.carpark.service.CfCarParkReleaseLogService;
import com.cf.carpark.service.CfCarParkUseLogService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.*;
import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.type.CouponScenes;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfCouponService;
import com.cf.pay.service.CfOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

/**
 *
 * @ClassName CfCarParkUseLogController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/28/028 8:55
 * @Version 1.0
 **/
@RestController
@RequestMapping("carparklog/")
@Validated
public class CfCarParkUseLogController implements CfCarParkUseLogSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkCarService cfCarParkCarService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponService cfCouponService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;
    @Autowired
    protected HttpServletRequest request;

    private static Logger logger = LoggerFactory.getLogger(Snowflake.class);

    @Override
    public String getHttpData(HttpServletRequest httpServletRequest) throws Exception {
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        StringBuffer sb = null;
        try{
            inputStream = httpServletRequest.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            sb = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e){
            throw e;
        }finally {
            try{
                bufferedReader.close();
                inputStream.close();
            }catch (Exception e){
                throw e;
            }

        }
        return sb.toString();
    }

    @Override
    @RequestMapping(value = "add")
    public Object add(HttpServletRequest httpServletRequest, HttpServletResponse response, String contents, String deviceBrand) throws Exception{
        String sb = null;
        Map carLogMap = null;
        if(StringUtils.isNotEmpty(contents)){
            sb = contents;
        }else{
            if(deviceBrand.equals(DeviceBrand.QIAN_YI)){
                carLogMap = getAllRequestParam(httpServletRequest);
            }else{
                sb = getHttpData(httpServletRequest);
            }
        }

        if(StringUtils.isNotEmpty(sb)){
            carLogMap = (JSONObject.parseObject(sb));
            carLogMap.put("deviceBrand",httpServletRequest.getParameter("deviceBrand"));
        }else{
            if(carLogMap==null || carLogMap.get("AlarmInfoPlate")==null){
                carLogMap = new HashMap<String, Object>();
                Map<String, String[]> parameterMap = request.getParameterMap();
                for(Map.Entry<String, String[]> map:parameterMap.entrySet()){
                    carLogMap.put(map.getKey(), map.getValue()[0]);
                }
            }
        }

        Object o = cfCarParkUseLogService.parseCarParkUseLogForm(carLogMap);
        if(carLogMap.containsKey("deviceBrand") && carLogMap.get("deviceBrand").toString().equals(DeviceBrand.HUA_XIA)){
            int length = JSON.toJSONString(o).length();
            response.setContentLength(length);
            return JSON.toJSONString(o);
        }
        return o;
    }

    @Override
    @RequestMapping(value = "getCarParkUseLogList", method = RequestMethod.GET)
    public ResponseResult getCarParkUseLogList(CfCarParkUseLogQuery cfCarParkUseLogQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringUtils.isNotEmpty(cfCarParkUseLogQuery.getNumberPlate()) && cfCarParkUseLogQuery.getNumberPlate().length()<5){
            cfCarParkUseLogQuery.setNumberPlate(null);
        }
        if(StringUtils.isEmpty(cfCarParkUseLogQuery.getNumberPlate())){
            CfCarParkCarQuery cfCarParkCarQuery = new CfCarParkCarQuery();
            cfCarParkCarQuery.setUid(userBasicInfo.getId());
            List<CfCarParkCar> cfCarParkCars = cfCarParkCarService.getMyCarsByCondition(cfCarParkCarQuery);
            if(cfCarParkCars!=null && cfCarParkCars.size()>0){
                List<String> numberPlates = new ArrayList<String>();
                for (CfCarParkCar cfCarParkCar: cfCarParkCars){
                    numberPlates.add(cfCarParkCar.getNumberPlate());
                }
                cfCarParkUseLogQuery.setNumberPlates(numberPlates);
            }else{
                return new ResponseResult(CommonCode.NO_MORE_DATAS);
            }
        }
        cfCarParkUseLogQuery.setOrderBy("cpul.create_time desc");
        List<CfCarParkUseLog> cfCarParkUseLogs = cfCarParkUseLogService.selectByQuery(cfCarParkUseLogQuery);
        if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0){
            for (CfCarParkUseLog cfCarParkUseLog: cfCarParkUseLogs){
                if(cfCarParkUseLog.getCfCarPark()!=null){
                    cfCarParkUseLog.getCfCarPark().setName(StringTools.vaguePartString(cfCarParkUseLog.getCfCarPark().getName(),3,2));
                    cfCarParkUseLog.getCfCarPark().setPositionX(null);
                    cfCarParkUseLog.getCfCarPark().setPositionY(null);
                }
            }
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkUseLogs);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @RequestMapping(value = "pollingMonitoring")
    public Object pollingMonitoring(HttpServletRequest httpServletRequest, String deviceBrand) throws Exception {
        String deviceSerialNumber = "";
        Map<String, Object> param = getAllRequestParam(httpServletRequest);
//        logger.error("Map数据: "+param);
        if(StringUtils.isNotEmpty(deviceBrand)){
            switch (deviceBrand){
                case DeviceBrand.ZHEN_SHI:
                    deviceSerialNumber = param.get("serialno").toString();
                    if(StringUtils.isEmpty(deviceSerialNumber)){
                        ZhenShi911202002050 zhenShi911202002050 = BeanUtils.deepMapToBean(ZhenShi911202002050.class.newInstance().getClass(), param);
                        deviceSerialNumber = zhenShi911202002050.getAlarmInfoPlate().getSerialno();
                    }
                    break;
                case DeviceBrand.QIAN_YI:
                    deviceSerialNumber = ((Map<String, Object>)param.get("heartbeat")).get("serialno").toString();
                    break;
                case DeviceBrand.HK:
                    deviceSerialNumber = param.get("serialNo").toString();
                    break;
                case DeviceBrand.DH:
                    deviceSerialNumber = param.get("serialNo").toString();
                    break;
                default:
                    return new ResponseResult(CarParkCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
            }
            if(StringUtils.isEmpty(deviceSerialNumber)){
                return new ResponseResult(CarParkCode.DEVICE_SERIAL_NUMBER_IS_NOT_SPECIFIED);
            }
//            return "{\"Response_AlarmInfoPlate\":{\"info\":\"ok\",\"plateid\":\"1416298816614875136\",\"channelNum\":0,\"manualTrigger\":\"fail\",\"is_pay\":null,\"serialData\":[{\"serialChannel\":0,\"data\":\"AGT//2IbAAEBAAIBAQMAAP8AAAAAAAAIALnzQTg4ODg4aTo=\",\"dataLen\":48,\"channel\":null,\"serialno\":null,\"ipaddr\":null,\"deviceName\":null},{\"serialChannel\":0,\"data\":\"AGT//2IZAQMBAAIDAQMA//8AAAAAAAAGAMHZyrGztQ13\",\"dataLen\":44,\"channel\":null,\"serialno\":null,\"ipaddr\":null,\"deviceName\":null},{\"serialChannel\":0,\"data\":\"AGT//2IbAgQBAAIEAQMA/wAAAAAAAAAIALu206254sHZYQk=\",\"dataLen\":48,\"channel\":null,\"serialno\":null,\"ipaddr\":null,\"deviceName\":null},{\"serialChannel\":0,\"data\":\"AGT//2ImAwEBAAIBAQMAAP8AAAAAAAATALu206254sHZLMfrvPXL2cL90NBO8w==\",\"dataLen\":64,\"channel\":null,\"serialno\":null,\"ipaddr\":null,\"deviceName\":null},{\"serialChannel\":0,\"data\":\"AGT//zAJALnzQTg4ODg4MaU=\",\"dataLen\":24,\"channel\":null,\"serialno\":null,\"ipaddr\":null,\"deviceName\":null},{\"serialChannel\":0,\"data\":\"AGT//zAHAMHZyrGztbfd\",\"dataLen\":20,\"channel\":null,\"serialno\":null,\"ipaddr\":null,\"deviceName\":null},{\"serialChannel\":0,\"data\":\"AGT//zAJAbu206254sHZMlg=\",\"dataLen\":24,\"channel\":null,\"serialno\":null,\"ipaddr\":null,\"deviceName\":null}],\"TriggerImage\":null}}";
            Map<String, Object> stringObjectMap = cfCarParkReleaseLogService.releaseMonitoring(deviceSerialNumber, deviceBrand);
            if(stringObjectMap.get("prefix")!=null && stringObjectMap.get("carParkReleaseLog")!=null){
                cfCarParkReleaseLogService.cleanReleaseRedis(stringObjectMap.get("prefix").toString(), (CfCarParkReleaseLog) stringObjectMap.get("carParkReleaseLog"));
            }else if(stringObjectMap.get("capture")!=null){
                cfCarParkReleaseLogService.cleanCaptureRedis(stringObjectMap.get("prefix").toString());
            }
            return stringObjectMap.get("object");
        }else{
            return new ResponseResult(CarParkCode.DEVICE_BRAND_IS_NOT_SPECIFIED);
        }
    }

    private Map<String, Object> getAllRequestParam(final HttpServletRequest request) throws Exception {
        String sb = getHttpData(request);
        Map res = (JSONObject.parseObject(sb));
        if(res==null){
            res = new HashMap();
        }
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp && temp.hasMoreElements()) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                Object value = request.getParameter(en);
                res.put(en, value);
            }
        }
        return res;
    }

    @Override
    @RequestMapping(value = "applyForAccess", method = RequestMethod.GET)
    public ResponseResult applyForAccess(
            @Pattern(regexp = "^(in|out){1}$", message = "请提供方向in/out")
            String direction,
            @NotEmpty(message = "请提供关卡id")
            String checkPointId,
            @Min(value = 1, message = "1-正常放行/2-异常放行")
            @Max(value = 2, message = "1-正常放行/2-异常放行")
            byte type,
            String deviceNo
    ) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.applyForAccess(userBasicInfo.getId(), direction, checkPointId, type, deviceNo);
        return cfCarParkUseLog==null?new ResponseResult(CommonCode.FAIL):new ResponseResult(CommonCode.SUCCESS, cfCarParkUseLog);
    }

    @Override
    @RequestMapping(value = "subscribeParkingSpace", method = RequestMethod.POST)
    public ResponseResult subscribeParkingSpace(HttpServletRequest httpServletRequest, @Validated @RequestBody CfCarParkUseLogForm cfCarParkUseLogForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkUseLog carParkUseLog = new CfCarParkUseLog();
        carParkUseLog.setUid(userBasicInfo.getId());
        carParkUseLog.setNumberPlate(cfCarParkUseLogForm.getNumberPlate());
        carParkUseLog.setCarParkId(cfCarParkUseLogForm.getCarParkId());
        carParkUseLog.setSubscribeTime(cfCarParkUseLogForm.getSubscribeTime());
        CfCarParkOrder cfCarParkOrder = cfCarParkUseLogService.subscribeParkingSpace(carParkUseLog, cfCarParkUseLogForm.getPayTypeId(), HttpClient.getIPAddress(httpServletRequest));
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkOrder);
    }

    @Override
    @RequestMapping(value = "getLastCarParkUseLogList", method = RequestMethod.GET)
    public ResponseResult getLastCarParkUseLogList(CfCarParkUseLogQuery cfCarParkUseLogQuery) throws Exception {
        if(StringUtils.isEmpty(cfCarParkUseLogQuery.getOutCheckPointId())){
            ExceptionCast.cast(CommonCode.INVALID_PARAM, "outCheckPointId required: 必须指定出入关卡id");
        }
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfCarParkUseLogQuery.setPayTime(0l);
        cfCarParkUseLogQuery.setMinInTime(1l);
        cfCarParkUseLogQuery.setMinOutTime(System.currentTimeMillis()-180000);
        cfCarParkUseLogQuery.setOrderBy("cpul.out_time desc");
        cfCarParkUseLogQuery.setPage(1);
        cfCarParkUseLogQuery.setSize(1);
        List<CfCarParkUseLog> cfCarParkUseLogs = cfCarParkUseLogService.selectByQuery(cfCarParkUseLogQuery);
        if(cfCarParkUseLogs!=null && cfCarParkUseLogs.size()>0){
            CfCarParkOrder cfCarParkOrder = cfCarParkChargingRulesService.calculateTheAmounPayable(cfCarParkUseLogs.get(0).getId(), "", FeeQueryMode.QUERY_MODE_QUERY_ONLY);
            CfOrder cfOrder = cfCarParkOrder.getCfOrder();

            String couponId = null;
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


//            if(cfCarParkOrder.getCfOrder().getAmountsPayable().doubleValue()>0 && (System.currentTimeMillis()-cfCarParkOrder.getCfOrder().getManualOfferSetTime()<=900000)){
//                BigDecimal amountsPayable = cfCarParkOrder.getCfOrder().getAmountsPayable();
//                cfOrder.setAmountsPayable(amountsPayable.subtract(cfCarParkOrder.getCfOrder().getManualOffer()));
//            }else{
//                cfOrder.setAmountsPayable(cfCarParkOrder.getCfOrder().getAmountsPayable());
//            }
//
////            //更新应付金额
////            if(cfCarParkOrder.getCfOrder().getStatus()== PayStatus.TO_BE_PAID){
////                CfOrder order = new CfOrder();
////                order.setId(cfOrder.getId());
////                order.setAmountsPayable(cfOrder.getAmountsPayable());
////                cfOrderService.updateByPrimaryKeySelective(order);
////            }
//            cfCarParkOrder.setCfOrder(cfOrder);
//            cfCarParkOrder.setCfCouponList(cfCouponService.getAvailableByShopIdAndScenes(System.currentTimeMillis(), cfCarParkOrder.getCfOrder().getShopId(), CouponScenes.CARPARK, cfCarParkOrder.getCfOrder().getEffectObject(),userBasicInfo.getId()));
//
//            if(cfCarParkOrder.getCfCouponList()!=null && cfCarParkOrder.getCfCouponList().size()>0){
//                CfCoupon cfCoupon = cfCarParkOrder.getCfCouponList().get(0);
//                if(cfCoupon.getCouponType()==(byte)3 && cfCoupon.getDenomination().longValue()+cfCarParkOrder.getCfCarParkUseLog().getInTime()<cfCarParkOrder.getCfCarParkUseLog().getOutTime()){
//                    long inTime = cfCoupon.getDenomination().longValue() + cfCarParkOrder.getCfCarParkUseLog().getInTime();
//                    cfCarParkOrder.getCfCarParkUseLog().setInTime(inTime);
//                }
//                if(cfCarParkOrder.getCfOrder().getStatus()!=0){
//                    ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
//                }
//
//                //如果人工设置了优惠金额，电子优惠券不再使用
//                boolean useCoupon = true;
//                if(cfCarParkOrder.getCfOrder().getManualOfferSetTime()==0 || (System.currentTimeMillis()-cfCarParkOrder.getCfOrder().getManualOfferSetTime()>=900000)){
//                    if(System.currentTimeMillis()<cfCoupon.getEffectiveTime() || System.currentTimeMillis()>cfCoupon.getExpireTime() || cfCoupon.getStatus()!=1){
//                        useCoupon = false;
//                    }
//
//                    if(StringUtils.isNotEmpty(cfCoupon.getGoodsId()) && !cfCoupon.getGoodsId().equals(cfCarParkOrder.getCfCarParkUseLog().getNumberPlate())){
//                        useCoupon = false;
//                    }else if(StringUtils.isEmpty(cfCoupon.getGoodsId()) && StringUtils.isNotEmpty(cfCoupon.getToUid()) && !cfCoupon.getToUid().equals(userBasicInfo.getId())){
//                        useCoupon = false;
//                    }
//
//                    if(cfCoupon.getScenes()!=0 && cfCoupon.getScenes()!=1){
//                        useCoupon = false;
//                    }
//                    if(StringUtils.isNotEmpty(cfCoupon.getGoodsId()) && !cfCoupon.getGoodsId().equals(cfCarParkOrder.getCfCarParkUseLog().getNumberPlate())){
//                        useCoupon = false;
//                    }
//                    if(cfCoupon.getCouponType()==(byte)1 ||
//                            (cfCoupon.getCouponType()==(byte)2 && cfCoupon.getDenomination().doubleValue()>=cfCarParkOrder.getCfOrder().getAmountsPayable().doubleValue()) ||
//                            (cfCoupon.getCouponType()==(byte)3 && cfCoupon.getDenomination().longValue()+cfCarParkOrder.getCfCarParkUseLog().getInTime()>=cfCarParkOrder.getCfCarParkUseLog().getOutTime())
//                    ){
//                        //禁止手动优惠券全额支付
//                        ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
//                    }else if(useCoupon){
//                        if(cfCoupon.getCouponType()==(byte)2){
//                            cfCarParkOrder.getCfOrder().setAmountsPayable(
//                                    cfCarParkOrder.getCfOrder().getAmountsPayable().subtract(cfCoupon.getDenomination())
//                            );
//                        }
//                    }
//                }
//                if(cfCarParkOrder.getCfOrder().getStatus()!=0){
//                    ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
//                }
//            }
//
//            //模糊掉返回停车数据
//            if(cfCarParkOrder.getCfCarPark()!=null){
//                cfCarParkOrder.getCfCarPark().setName(StringTools.vaguePartString(cfCarParkOrder.getCfCarPark().getName(),3,2));
//                cfCarParkOrder.getCfCarPark().setPositionX(null);
//                cfCarParkOrder.getCfCarPark().setPositionY(null);
//            }
//            if(cfCarParkOrder.getInCheckpoint()!=null){
//                cfCarParkOrder.getInCheckpoint().setName(StringTools.vaguePartString(cfCarParkOrder.getInCheckpoint().getName(),3,2));
//                cfCarParkOrder.getInCheckpoint().setPositionX(null);
//                cfCarParkOrder.getInCheckpoint().setPositionY(null);
//            }
//            if(cfCarParkOrder.getOutCheckpoint()!=null){
//                cfCarParkOrder.getOutCheckpoint().setName(StringTools.vaguePartString(cfCarParkOrder.getOutCheckpoint().getName(),3,2));
//                cfCarParkOrder.getOutCheckpoint().setPositionX(null);
//                cfCarParkOrder.getOutCheckpoint().setPositionY(null);
//            }
            return new ResponseResult(CommonCode.SUCCESS,cfCarParkOrder);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @RequestMapping(value = "ccbPayTest", method = RequestMethod.GET)
    public ResponseResult ccbPayTest(String cfCarParkUseLogId, String numberPlate) throws Exception {
        cfCarParkChargingRulesService.ccbPayTest(cfCarParkUseLogId, numberPlate);
        return null;
    }

    @Override
    @RequestMapping(value = "manuallyUpload", method = RequestMethod.POST, headers = "content-type=multipart/form-data;charset=utf-8")
    public ResponseResult manuallyUpload(MultipartFile file, String carParkCheckPointId, Long time, String platform) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringUtils.isEmpty(platform)){
            platform = "ali_oss";
        }
        if(time==null){
            time = System.currentTimeMillis();
        }
        CfCarParkOrder cfCarParkOrder = cfCarParkUseLogService.manuallyUpload(file.getBytes(), file.getOriginalFilename(), carParkCheckPointId, time, userBasicInfo.getId(), platform);
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkOrder);
    }
}
