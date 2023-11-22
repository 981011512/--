package com.cf.pay.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import com.cf.carpark.service.CfCarParkLinkUserService;
import com.cf.charging.domain.CfChargingStationLinkUser;
import com.cf.charging.domain.request.CfChargingStationLinkUserQuery;
import com.cf.charging.service.CfChargingStationLinkUserService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.pay.admin.config.AuthenticationInterceptor;
import com.cf.pay.admin.swagger.CfCouponSwagger;
import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.request.CfCouponForm;
import com.cf.pay.domain.type.PayScenes;
import com.cf.pay.service.CfCouponService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请在此填写描述
 *
 * @ClassName CfCouponController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/6/7/007 17:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("payCouponAdmin/")
@Validated
public class CfCouponController implements CfCouponSwagger {


    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfCouponService cfCouponService;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfChargingStationLinkUserService cfChargingStationLinkUserService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('pay-CfCouponController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions, String scenes) throws Exception {
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("to_uid");
        allowFileds.add("from_uid");
        allowFileds.add("scenes");
        allowFileds.add("shop_id");
        allowFileds.add("shop_id$in");
        allowFileds.add("goods_id");
        allowFileds.add("denomination");
        allowFileds.add("effective_time");
        allowFileds.add("expire_time");
        allowFileds.add("status");
        allowFileds.add("create_time");
        allowFileds.add("use_time");
        allowFileds.add("like");
        allowFileds.add("group");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","cpn");
        allowFiledsMap.put("to_uid","cpn");
        allowFiledsMap.put("from_uid","cpn");
        allowFiledsMap.put("scenes","cpn");
        allowFiledsMap.put("shop_id","cpn");
        allowFiledsMap.put("shop_id$in","cpn");
        allowFiledsMap.put("goods_id","cpn");
        allowFiledsMap.put("denomination","cpn");
        allowFiledsMap.put("refund_amount","cpn");
        allowFiledsMap.put("effective_time","cpn");
        allowFiledsMap.put("expire_time","cpn");
        allowFiledsMap.put("status","cpn");
        allowFiledsMap.put("create_time","cpn");
        allowFiledsMap.put("use_time","cpn");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("group","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0 && StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "finance")<0){
            if(StringUtils.isEmpty(scenes)){
                //如果不传入默认为停车优惠券
                scenes = PayScenes.PARKING;
            }
            switch (scenes){
                case PayScenes.PARKING:
                    CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
                    cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
                    List<CfCarParkLinkUser> cfCarParkLinkUsers = cfCarParkLinkUserService.getListByQuery(cfCarParkLinkUserQuery);
                    if(cfCarParkLinkUsers==null || cfCarParkLinkUsers.size()==0){
                        return new ResponseResult(CommonCode.NO_MORE_DATAS);
                    }
                    String carParkIds = "";
                    String shopId = "";
                    if(conditionsMap.containsKey("shop_id")){
                        Map<String, String> shopIdMap = (Map<String, String>) conditionsMap.get("shop_id");
                        if(StringUtils.isNotEmpty(shopIdMap.get("value"))){
                            shopId = shopIdMap.get("value");
                        }
                    }
                    for (CfCarParkLinkUser cfCarParkLinkUser: cfCarParkLinkUsers){
                        if(StringUtils.isEmpty(cfCarParkLinkUser.getCarParkId())){
                            continue;
                        }
                        if(shopId.equals(cfCarParkLinkUser.getCarParkId())){
                            carParkIds = "";
                            break;
                        }
                        carParkIds += ",'"+cfCarParkLinkUser.getCarParkId()+"'";
                    }

                    if(StringUtils.isNotEmpty(shopId) && StringUtils.isNotEmpty(carParkIds)){
                        //说明传入的店铺id不在当前用户的运营范围内
                        return new ResponseResult(CommonCode.NO_MORE_DATAS);
                    }

                    if(StringUtils.isNotEmpty(carParkIds)){
                        carParkIds = carParkIds.substring(1);
                    }

                    if(StringUtils.isNotEmpty(carParkIds)){
                        HashMap<String, String> valueMap = new HashMap<>();
                        valueMap.put("operator","in");
                        valueMap.put("value",carParkIds);
                        conditionsMap.put("shop_id$in", valueMap);
                    }else if(StringUtils.isEmpty(shopId)){
                        return new ResponseResult(CommonCode.NO_MORE_DATAS);
                    }
                    break;
                case PayScenes.CHARGING:
                    if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0 && StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "finance")<0){
                        CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery = new CfChargingStationLinkUserQuery();
                        cfChargingStationLinkUserQuery.setUid(userBasicInfo.getId());
                        List<CfChargingStationLinkUser> cfChargingStationLinkUsers = cfChargingStationLinkUserService.getListByQuery(cfChargingStationLinkUserQuery);
                        if(cfChargingStationLinkUsers==null || cfChargingStationLinkUsers.size()==0){
                            return new ResponseResult(CommonCode.NO_MORE_DATAS);
                        }
                        String chargingStationIds = "";
                        shopId = "";
                        if(conditionsMap.containsKey("shop_id")){
                            Map<String, String> shopIdMap = (Map<String, String>) conditionsMap.get("shop_id");
                            if(StringUtils.isNotEmpty(shopIdMap.get("value"))){
                                shopId = shopIdMap.get("value");
                            }
                        }
                        for (CfChargingStationLinkUser cfChargingStationLinkUser: cfChargingStationLinkUsers){
                            if(StringUtils.isEmpty(cfChargingStationLinkUser.getChargingStationId())){
                                continue;
                            }
                            if(shopId.equals(cfChargingStationLinkUser.getChargingStationId())){
                                chargingStationIds = "";
                                break;
                            }
                            chargingStationIds += ",'"+cfChargingStationLinkUser.getChargingStationId()+"'";
                        }
                        if(StringUtils.isNotEmpty(shopId) && StringUtils.isNotEmpty(chargingStationIds)){
                            //说明传入的店铺id不在当前用户的运营范围内
                            return new ResponseResult(CommonCode.NO_MORE_DATAS);
                        }

                        if(StringUtils.isNotEmpty(chargingStationIds)){
                            HashMap<String, String> valueMap = new HashMap<>();
                            valueMap.put("operator","in");
                            valueMap.put("value",chargingStationIds.substring(1));
                            conditionsMap.put("shop_id$in", valueMap);
                        }else if(StringUtils.isEmpty(shopId)){
                            return new ResponseResult(CommonCode.NO_MORE_DATAS);
                        }
                    }
                    break;
                default:
                    return new ResponseResult(CommonCode.INVALID_PARAM,null,"不支持的场景");
            }

        }

        List<CfCoupon> cfOrders = cfCouponService.selectListByCondition(conditionsMap, allowFiledsMap, allowFileds);
        Integer counts = cfCouponService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfOrders!=null && cfOrders.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfOrders, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('pay-CfCouponController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfCouponForm cfCouponForm) {
        CfCoupon cfCoupon = new CfCoupon();
        BeanUtils.copyProperties(cfCouponForm, cfCoupon);
        CfCoupon coupon = cfCouponService.add(cfCoupon);
        return new ResponseResult(CommonCode.SUCCESS, coupon);
    }

    @PreAuthorize("hasAuthority('pay-CfCouponController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfCouponForm cfCouponForm) {
        CfCoupon cfCoupon = new CfCoupon();
        BeanUtils.copyProperties(cfCouponForm, cfCoupon);
        CfCoupon coupon = cfCouponService.update(cfCoupon);
        return new ResponseResult(CommonCode.SUCCESS, coupon);
    }

    @PreAuthorize("hasAuthority('pay-CfCouponController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfCouponService.delete(id);
        if(delete==0){
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }
}
