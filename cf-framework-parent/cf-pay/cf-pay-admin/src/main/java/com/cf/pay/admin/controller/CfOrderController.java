package com.cf.pay.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import com.cf.carpark.service.CfCarParkLinkUserService;
import com.cf.charging.domain.CfChargingStationLinkUser;
import com.cf.charging.domain.request.CfChargingStationLinkUserQuery;
import com.cf.charging.service.CfChargingStationLinkUserService;
import com.cf.framework.domain.report.CountByDay;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.pay.admin.config.AuthenticationInterceptor;
import com.cf.pay.admin.swagger.CfOrderSwagger;
import com.cf.pay.domain.CfHistoryOrder;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.request.CfCountFinanceQuery;
import com.cf.pay.domain.request.CfHistoryOrderQuery;
import com.cf.pay.domain.request.CfOrderForm;
import com.cf.pay.domain.type.PayScenes;
import com.cf.pay.service.CfHistoryOrderService;
import com.cf.pay.service.CfOrderService;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("orderAdmin/")
@Validated
public class CfOrderController implements CfOrderSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfOrderService cfOrderService;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfHistoryOrderService cfHistoryOrderService;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfChargingStationLinkUserService cfChargingStationLinkUserService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('pay-CfOrderController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions, String scenes) throws Exception {
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("uid");
        allowFileds.add("goods_name");
        allowFileds.add("goods_id");
        allowFileds.add("goods_type");
        allowFileds.add("amounts_payable");
        allowFileds.add("amount_actually_paid");
        allowFileds.add("refund_amount");
        allowFileds.add("coupon_id");
        allowFileds.add("shop_id");
        allowFileds.add("shop_id$in");
        allowFileds.add("status");
        allowFileds.add("create_time");
        allowFileds.add("pay_time");
        allowFileds.add("refund_time");
        allowFileds.add("cancel_time");
        allowFileds.add("payment_agency_short_name");
        allowFileds.add("third_party_order_id");
        allowFileds.add("effect_object");
        allowFileds.add("handle_uid");
        allowFileds.add("like");
        allowFileds.add("group");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","ord");
        allowFiledsMap.put("uid","ord");
        allowFiledsMap.put("goods_name","ord");
        allowFiledsMap.put("goods_id","ord");
        allowFiledsMap.put("goods_type","ord");
        allowFiledsMap.put("amounts_payable","ord");
        allowFiledsMap.put("amount_actually_paid","ord");
        allowFiledsMap.put("refund_amount","ord");
        allowFiledsMap.put("coupon_id","ord");
        allowFiledsMap.put("shop_id","ord");
        allowFiledsMap.put("shop_id$in","ord");
        allowFiledsMap.put("status","ord");
        allowFiledsMap.put("create_time","ord");
        allowFiledsMap.put("pay_time","ord");
        allowFiledsMap.put("refund_time","ord");
        allowFiledsMap.put("cancel_time","ord");
        allowFiledsMap.put("payment_agency_short_name","ord");
        allowFiledsMap.put("third_party_order_id","ord");
        allowFiledsMap.put("effect_object","ord");
        allowFiledsMap.put("handle_uid","ord");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("group","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0 && StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "finance")<0){
            if(StringUtils.isEmpty(scenes)){
                return new ResponseResult(CommonCode.INVALID_PARAM,null,"请提供场景");
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

        List<CfOrder> cfOrders = cfOrderService.selectListByCondition(conditionsMap, allowFiledsMap, allowFileds);
        Integer counts = cfOrderService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfOrders!=null && cfOrders.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfOrders, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('pay-CfOrderController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfOrderForm cfOrderForm) {
        CfOrder cfOrder = new CfOrder();
        BeanUtils.copyProperties(cfOrderForm, cfOrder);
        CfOrder order = cfOrderService.add(cfOrder);
        return new ResponseResult(CommonCode.SUCCESS, order);
    }

    @PreAuthorize("hasAuthority('pay-CfOrderController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfOrderForm cfOrderForm) {
        CfOrder cfOrder = new CfOrder();
        BeanUtils.copyProperties(cfOrderForm, cfOrder);
        cfOrder.setManualOfferSetTime(System.currentTimeMillis());
        CfOrder order = cfOrderService.update(cfOrder);
        return new ResponseResult(CommonCode.SUCCESS, order);
    }

    @PreAuthorize("hasAuthority('pay-CfOrderController-updateManualOffer')")
    @Override
    @RequestMapping(value = "updateManualOffer", method = RequestMethod.PUT)
    public ResponseResult updateManualOffer(String id, BigDecimal manualOffer) {
        CfOrder cfOrder = cfOrderService.findById(id, false);
        cfOrder.setManualOffer(manualOffer);
        cfOrder.setManualOfferSetTime(System.currentTimeMillis());
        CfOrder order = cfOrderService.update(cfOrder);
        return new ResponseResult(CommonCode.SUCCESS, order);
    }

    @PreAuthorize("hasAuthority('pay-CfOrderController-countFinance')")
    @Override
    @RequestMapping(value = "countFinance", method = RequestMethod.GET)
    public ResponseResult countFinance(CfCountFinanceQuery cfCountFinanceQuery) {
        cfCountFinanceQuery.setCountAll(false);
        if(cfCountFinanceQuery.getDate()==null || StringUtils.isEmpty(cfCountFinanceQuery.getDate()) || cfCountFinanceQuery.getDate().equals("null")){
            cfCountFinanceQuery.setDate(null);
        }
        if(cfCountFinanceQuery.getEndDate()==null || StringUtils.isEmpty(cfCountFinanceQuery.getEndDate()) || cfCountFinanceQuery.getEndDate().equals("null")){
            cfCountFinanceQuery.setEndDate(null);
        }
        if(cfCountFinanceQuery.getPaymentAgencyShortName()==null || StringUtils.isEmpty(cfCountFinanceQuery.getPaymentAgencyShortName())|| cfCountFinanceQuery.getPaymentAgencyShortName().equals("null")){
            cfCountFinanceQuery.setPaymentAgencyShortName(null);
        }

        List<CountByDay> list = null;
        BigDecimal total = new BigDecimal("0");
        switch (cfCountFinanceQuery.getCountType()){
            case "before_day_count_by_day":
                list = cfOrderService.limitDaysCountByDay(cfCountFinanceQuery);
                cfCountFinanceQuery.setCountAll(true);
                List<CountByDay> countDay = cfOrderService.limitDaysCountByDay(cfCountFinanceQuery);
                if(countDay.get(0)!=null){
                    total = countDay.get(0).getCount();
                }
                break;
            case "month_count_by_day":
                list = cfOrderService.yearMonthCountByDay(cfCountFinanceQuery);
                cfCountFinanceQuery.setCountAll(true);
                List<CountByDay> countMonth = cfOrderService.yearMonthCountByDay(cfCountFinanceQuery);
                total = countMonth.get(0).getCount();
                break;
            case "year_count_by_month":
                list = cfOrderService.yearCountByMonth(cfCountFinanceQuery);
                cfCountFinanceQuery.setCountAll(true);
                List<CountByDay> countYear = cfOrderService.yearCountByMonth(cfCountFinanceQuery);
                total = countYear.get(0).getCount();
                break;
        }

        if(list==null || list.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, list, total);
    }

    @PreAuthorize("hasAuthority('pay-CfOrderController-historyOrder')")
    @Override
    @RequestMapping(value = "historyOrder", method = RequestMethod.GET)
    public ResponseResult historyOrder(CfHistoryOrderQuery cfHistoryOrderQuery) {
        List<CfHistoryOrder> cfHistoryOrderList = cfHistoryOrderService.getListByQuery(cfHistoryOrderQuery);
        Integer counts = cfHistoryOrderService.countByQuery(cfHistoryOrderQuery);
        if(cfHistoryOrderList!=null && cfHistoryOrderList.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfHistoryOrderList, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @RequestMapping(value = "queryThirdPartyOrder", method = RequestMethod.GET)
    public ResponseResult queryThirdPartyOrder(String platform, String orderId) throws Exception {
        Object thirdPartyOrder = cfOrderService.queryThirdPartyOrder(platform, orderId);
        return new ResponseResult(CommonCode.SUCCESS, thirdPartyOrder);
    }
}
