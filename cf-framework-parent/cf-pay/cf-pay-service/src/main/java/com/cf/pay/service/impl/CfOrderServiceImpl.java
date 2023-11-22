package com.cf.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import com.cf.carpark.domain.request.CfCarParkSpecialCarQuery;
import com.cf.carpark.domain.type.CarParkUseLogCreatePosition;
import com.cf.carpark.domain.type.ReleaseType;
import com.cf.carpark.service.*;
import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.service.CfUserMessageService;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.report.CountByDay;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.CouponActivityCode;
import com.cf.framework.exception.CustomException;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.BCryptUtil;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.framework.utils.Snowflake;
import com.cf.pay.dao.mapper.CfOrderMapper;
import com.cf.pay.domain.*;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.domain.request.CfCountFinanceQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.domain.type.CouponStatus;
import com.cf.pay.domain.type.CouponType;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.*;
import com.cf.pay.service.config.AlipayConfig;
import com.cf.pay.service.util.HttpUtils;
import com.cf.pay.service.util.SignUtil;
import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.domain.CfThirdPartyLogin;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserRole;
import com.cf.ucenter.request.CfRoleQuery;
import com.cf.ucenter.request.CfThirdPartyLoginQuery;
import com.cf.ucenter.request.CfUserRoleQuery;
import com.cf.ucenter.service.CfRoleService;
import com.cf.ucenter.service.CfThirdPartyLoginService;
import com.cf.ucenter.service.CfUserRoleService;
import com.cf.ucenter.service.CfUserService;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.jsoup.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单管理服务
 *
 * @ClassName CfOrderServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/2/002 9:08
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfOrderServiceImpl implements CfOrderService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfOrderMapper cfOrderMapper;
    @Autowired
    private CfUserPaymentAgencyService cfUserPaymentAgencyService;
    @Autowired
    private CfAccountService cfAccountService;
    @Autowired
    private AlipayService alipayService;


    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkPackageService cfCarParkPackageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkPackagePriceService cfCarParkPackagePriceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfThirdPartyLoginService cfThirdPartyLoginService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponActivityService cfCouponActivityService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponService cfCouponService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkSpecialCarService cfCarParkSpecialCarService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfRoleService cfRoleService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserRoleService cfUserRoleService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserMessageService cfUserMessageService;

    private static Logger logger = LoggerFactory.getLogger(Snowflake.class);

    @Override
    public CfOrder add(CfOrder cfOrder) {
        if(StringUtils.isEmpty(cfOrder.getId()) || cfOrder.getId().length()<17){
            cfOrder.setId(idWorker.nextId());
        }
        cfOrder.setCreateTime(System.currentTimeMillis());

        if(cfOrder.getManualOffer()==null){
            cfOrder.setManualOffer(new BigDecimal(0.00));
        }
        if(cfOrder.getCollectionShopId()==null){
            cfOrder.setCollectionShopId("");
        }
        cfOrder.setUpdateTime(System.currentTimeMillis());
        cfOrderMapper.insertSelective(cfOrder);
        return cfOrder;
    }

    @Override
    public CfOrder update(CfOrder cfOrder) {
        cfOrder.setUpdateTime(System.currentTimeMillis());
        cfOrderMapper.updateByPrimaryKeySelective(cfOrder);
        return cfOrder;
    }

    @Override
    public CfOrder updateByPrimaryKeySelective(CfOrder cfOrder) {
        cfOrder.setUpdateTime(System.currentTimeMillis());
        cfOrderMapper.updateByPrimaryKeySelective(cfOrder);
        return cfOrder;
    }

    @Override
    public CfOrder findById(String id) {
        return cfOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfOrder findById(String id, Boolean expectEmpty) {
        CfOrder cfOrder = findById(id);
        if(cfOrder==null && !expectEmpty){
            ExceptionCast.cast(PayCode.ORDER_DOES_NOT_EXIST);
        }else if(cfOrder!=null && expectEmpty){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        return cfOrder;
    }

    @Override
    public CfOrderExample getExampleByQuery(CfOrderQuery cfOrderQuery) {
        CfOrderExample cfOrderExample = new CfOrderExample();
        CfOrderExample.Criteria criteria = cfOrderExample.createCriteria();

        if(cfOrderQuery.getRandomId()!=null){
            criteria.andRandomIdEqualTo(cfOrderQuery.getRandomId());
        }
        if(cfOrderQuery.getUid()!=null){
            criteria.andUidEqualTo(cfOrderQuery.getUid());
        }
        if(cfOrderQuery.getHandleUid()!=null){
            criteria.andHandleUidEqualTo(cfOrderQuery.getHandleUid());
        }
        if(cfOrderQuery.getGoodsId()!=null){
            criteria.andGoodsIdEqualTo(cfOrderQuery.getGoodsId());
        }
        if(cfOrderQuery.getGoodsIds()!=null && cfOrderQuery.getGoodsIds().size()>0){
            criteria.andGoodsIdIn(cfOrderQuery.getGoodsIds());
        }
        if(cfOrderQuery.getShopId()!=null){
            criteria.andShopIdEqualTo(cfOrderQuery.getShopId());
        }
        if(cfOrderQuery.getGoodsType()!=null){
            criteria.andGoodsTypeEqualTo(cfOrderQuery.getGoodsType());
        }
        if(cfOrderQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfOrderQuery.getStatus());
        }
        if(cfOrderQuery.getMinCreateTime()!=null && cfOrderQuery.getMinCreateTime()>0){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfOrderQuery.getMinCreateTime());
        }
        if(cfOrderQuery.getMaxCreateTime()!=null && cfOrderQuery.getMaxCreateTime()>0){
            criteria.andCreateTimeLessThanOrEqualTo(cfOrderQuery.getMaxCreateTime());
        }
        if(cfOrderQuery.getMinPayTime()!=null && cfOrderQuery.getMinPayTime()>0){
            criteria.andPayTimeGreaterThanOrEqualTo(cfOrderQuery.getMinPayTime());
        }
        if(cfOrderQuery.getMaxPayTime()!=null && cfOrderQuery.getMaxPayTime()>0){
            criteria.andPayTimeLessThanOrEqualTo(cfOrderQuery.getMaxPayTime());
        }
        if(cfOrderQuery.getCollectionShopId()!=null){
            criteria.andCollectionShopIdEqualTo(cfOrderQuery.getCollectionShopId());
        }
        if(cfOrderQuery.getCollectionOrderId()!=null){
            criteria.andCollectionOrderIdEqualTo(cfOrderQuery.getCollectionOrderId());
        }
        if(StringUtils.isNotEmpty(cfOrderQuery.getScoreKeyFlag())){
            criteria.andScoreKeyFlagEqualTo(cfOrderQuery.getScoreKeyFlag());
        }
        if(StringUtils.isNotEmpty(cfOrderQuery.getEffectObject())){
            criteria.andEffectObjectEqualTo(cfOrderQuery.getEffectObject());
        }
        if(cfOrderQuery.getMinAmountActuallyPaid()!=null){
            criteria.andAmountActuallyPaidGreaterThanOrEqualTo(cfOrderQuery.getMinAmountActuallyPaid());
        }
        if(cfOrderQuery.getMaxAmountActuallyPaid()!=null){
            criteria.andAmountActuallyPaidLessThanOrEqualTo(cfOrderQuery.getMaxAmountActuallyPaid());
        }
        if(StringUtils.isNotEmpty(cfOrderQuery.getOrderBy())){
            cfOrderExample.setOrderByClause(cfOrderQuery.getOrderBy());
        }
        if(cfOrderQuery.getPage()!=null && cfOrderQuery.getSize()!=null){
            PageHelper.startPage(cfOrderQuery.getPage(), cfOrderQuery.getSize());
        }
        return cfOrderExample;
    }

    @Override
    public List<CfOrder> getListByQuery(CfOrderQuery cfOrderQuery) {
        return cfOrderMapper.selectByExample(getExampleByQuery(cfOrderQuery));
    }

    @Override
    public Integer countByQuery(CfOrderQuery cfOrderQuery) {
        cfOrderQuery.setPage(null);
        return cfOrderMapper.countByExample(getExampleByQuery(cfOrderQuery));
    }

    @Override
    public Integer deleteByQuery(CfOrderQuery cfOrderQuery) {
        return cfOrderMapper.deleteByExample(getExampleByQuery(cfOrderQuery));
    }

    @Override
    public Integer updateByQuery(CfOrder cfOrder, CfOrderQuery cfOrderQuery) {
        return cfOrderMapper.updateByExampleSelective(cfOrder, getExampleByQuery(cfOrderQuery));
    }

    @Override
    public void overChildrenOrder(CfOrder cfOrder) {
        CfOrder updateOrder = new CfOrder();
        updateOrder.setAmountsPayable(new BigDecimal(0.00));
        updateOrder.setAmountActuallyPaid(new BigDecimal(0.00));
        updateOrder.setStatus(PayStatus.PAID);
        updateOrder.setPayTime(System.currentTimeMillis());
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setCollectionOrderId(cfOrder.getId());
        cfOrderQuery.setStatus(PayStatus.TO_BE_PAID);
        updateByQuery(updateOrder, cfOrderQuery);
    }

    @Override
    public List<CfOrder> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT ord.*,u1.user_name user_name,u2.user_name handle_uid_user_name FROM cf_order ord left join cf_user u1 on(u1.id=ord.uid) left join cf_user u2 on(u2.id=ord.handle_uid)";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfOrderMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_order ord";
        conditions.remove("group");
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfOrderMapper.selectListByConditionCounts(sql);
    }

    @Override
    public ResultMap payForOrder(CfOrder cfOrder, String cfUserPaymentAgencyId, String ip) throws Exception {
        CfUserPaymentAgency cfUserPaymentAgency = cfUserPaymentAgencyService.findById(cfUserPaymentAgencyId, false);
        if(cfOrder.getPayTime()!=null && cfOrder.getPayTime()>0){
            cfOrder.setUserPaymentAgencyId(cfUserPaymentAgencyId);
            return null;
        }
        //给订单设置最新的随机码(避免多此提交相同订单导致微信或者支付宝无法支付报错的问题)
//        cfOrder.setRandomId(idWorker.nextId());
        cfOrder.setPaymentAgencyShortName(cfUserPaymentAgency.getPaymentAgencyShortName());
//        cfOrder.setCouponId("");
        cfOrder.setUpdateTime(System.currentTimeMillis());
        cfOrder = update(cfOrder);
        if(cfOrder.getManualOfferSetTime()!=null && (System.currentTimeMillis()-cfOrder.getManualOfferSetTime()<900000) && cfOrder.getManualOffer()!=null && cfOrder.getManualOffer().doubleValue()>0 && cfOrder.getAmountsPayable().doubleValue()>cfOrder.getManualOffer().doubleValue()){
            BigDecimal amountsPayable = cfOrder.getAmountsPayable();
            cfOrder.setAmountsPayable(amountsPayable.subtract(cfOrder.getManualOffer()));
        }
        if(cfOrder.getAmountsPayable().doubleValue()<=0){
            ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
        }
        return getUnifiedOrderByPaymentAgency(cfUserPaymentAgency, cfOrder, ip);
    }

    @Override
    public ResultMap getUnifiedOrderByPaymentAgency(CfUserPaymentAgency cfUserPaymentAgency, CfOrder cfOrder, String ip) throws Exception {
        ResultMap resultMap = null;
        switch (cfUserPaymentAgency.getPaymentAgencyShortName()) {
            case "wei_xin_pay_cny":
                String openid = "";
                CfThirdPartyLoginQuery cfThirdPartyLoginQuery = new CfThirdPartyLoginQuery();
                cfThirdPartyLoginQuery.setUid(cfOrder.getUid());
                cfThirdPartyLoginQuery.setAppid(cfUserPaymentAgency.getAppid());
                cfThirdPartyLoginQuery.setPlatform(cfUserPaymentAgency.getUseScenes());
                List<CfThirdPartyLogin> cfThirdPartyLogins = cfThirdPartyLoginService.getListByQuery(cfThirdPartyLoginQuery);
                if(cfThirdPartyLogins.size()>0){
                    openid = cfThirdPartyLogins.get(0).getOpenid();
                }
                WxPayService wxPayService = new WxPayServiceImpl(cfUserPaymentAgency);
                if(cfUserPaymentAgency.getAccountNumberNote().equals("yi_sheng_pay")){
                    //易生支付

                }else if(cfUserPaymentAgency.getAccountNumberNote().equals("duo_la_bao")){
                    //哆啦宝

                }else{
                    //微信官方支付
                    if(cfOrder.getRefundAmount()==null){
                        cfOrder.setRefundAmount(new BigDecimal(0.00));
                    }
                    if(cfOrder.getRefundAmount().doubleValue()>0){
                        resultMap = wxPayService.refund(cfOrder.getThirdPartyOrderId(), cfOrder.getAmountActuallyPaid(), cfOrder.getRefundAmount(), cfOrder.getRefundReason());
                    }else{
                        try{
                            resultMap = wxPayService.unifiedOrder(cfOrder.getId(), cfOrder.getAmountsPayable().doubleValue(), cfOrder.getGoodsName(), ip, openid, cfUserPaymentAgency);
                        }catch (CustomException e){
                            if(e.getResultCode().mixMessage()!=null && e.getResultCode().mixMessage().equals("201 商户订单号重复")){
                                //如果是重复支付，给其再重新生成最新的id
                                String newOrderId = idWorker.nextId();
                                flushOrderId(newOrderId, cfOrder.getId());
                                return null;
                            }
                        }
                    }
                }
                break;
            case "wei_xin_app_pay_cny":
                openid = null;
                wxPayService = new WxPayServiceImpl(cfUserPaymentAgency);
                if(cfOrder.getRefundAmount()==null){
                    cfOrder.setRefundAmount(new BigDecimal(0.00));
                }
                if(cfOrder.getRefundAmount().doubleValue()>0){
                    resultMap = wxPayService.refund(cfOrder.getThirdPartyOrderId(), cfOrder.getAmountActuallyPaid(), cfOrder.getRefundAmount(), cfOrder.getRefundReason());
                }else{
                    try{
                        resultMap = wxPayService.unifiedOrder(cfOrder.getId(), cfOrder.getAmountsPayable().doubleValue(), cfOrder.getGoodsName(), ip, openid, cfUserPaymentAgency);
                    }catch (CustomException e){
                        if(e.getResultCode().mixMessage()!=null && e.getResultCode().mixMessage().equals("201 商户订单号重复")){
                            //如果是重复支付，给其再重新生成最新的id
                            String newOrderId = idWorker.nextId();
                            flushOrderId(newOrderId, cfOrder.getId());
                            return null;
                        }
                    }
                }
                break;
            case "wei_xin_h5_pay_cny":
                openid = "";
                cfThirdPartyLoginQuery = new CfThirdPartyLoginQuery();
                cfThirdPartyLoginQuery.setUid(cfOrder.getUid());
                cfThirdPartyLoginQuery.setAppid(cfUserPaymentAgency.getAppid());
                cfThirdPartyLoginQuery.setPlatform(cfUserPaymentAgency.getUseScenes());
                cfThirdPartyLogins = cfThirdPartyLoginService.getListByQuery(cfThirdPartyLoginQuery);
                if(cfThirdPartyLogins.size()>0){
                    openid = cfThirdPartyLogins.get(0).getOpenid();
                }
                wxPayService = new WxPayServiceImpl(cfUserPaymentAgency);
                if(!cfUserPaymentAgency.getAccountNumberNote().equals("yi_sheng_pay")) {
                    if (cfOrder.getRefundAmount() == null) {
                        cfOrder.setRefundAmount(new BigDecimal(0.00));
                    }
                    if (cfOrder.getRefundAmount().doubleValue() > 0) {
                        resultMap = wxPayService.refund(cfOrder.getThirdPartyOrderId(), cfOrder.getAmountActuallyPaid(), cfOrder.getRefundAmount(), cfOrder.getRefundReason());
                    } else {
                        try {
                            resultMap = wxPayService.unifiedOrder(cfOrder.getId(), cfOrder.getAmountsPayable().doubleValue(), cfOrder.getGoodsName(), ip, openid, cfUserPaymentAgency);
                        } catch (CustomException e) {
                            if (e.getResultCode().mixMessage() != null && e.getResultCode().mixMessage().equals("201 商户订单号重复")) {
                                //如果是重复支付，给其再重新生成最新的id
                                String newOrderId = idWorker.nextId();
                                flushOrderId(newOrderId, cfOrder.getId());
                                //                            resultMap = wxPayService.unifiedOrder(newOrderId, cfOrder.getAmountsPayable().doubleValue(), cfOrder.getGoodsName(), ip, openid);
                            }else{
                                logger.error("wei_xin_order_error");
                                logger.error(e.getResultCode().mixMessage());
                                logger.error(JSONObject.toJSONString(cfOrder));
                            }
                            return null;
                        }

                    }
                }else{
                    //易生支付
                    if(cfThirdPartyLogins.size()>0){
                        openid = cfThirdPartyLogins.get(0).getOpenid();
                    }
                    if(cfOrder.getRefundAmount()==null){
                        cfOrder.setRefundAmount(new BigDecimal(0.00));
                    }

                    Map<String, String> params = new HashMap<>();
                    params.put("openid",openid);
                    params.put("channelid",cfUserPaymentAgency.getPayKey());
                    params.put("merid",cfUserPaymentAgency.getSubMchId());
                    params.put("termid",cfUserPaymentAgency.getSubAppid());
                    params.put("opt","wxPreOrder");
                    params.put("tradetype","JSAPI");
                    params.put("tradetrace",cfOrder.getId());
                    params.put("tradeamt",String.valueOf((int)(cfOrder.getAmountsPayable().doubleValue()*100)));
                    params.put("body","电子支付结算");
                    params.put("notifyurl", cfUserPaymentAgency.getPayNotifyUrl());
                    params.put("version","2");
                    params.put("sign", SignUtil.getSign(params, cfUserPaymentAgency.getSecret()));

                    Connection.Response result = HttpUtils.post("https://open.eycard.cn:8443/WorthTech_Access_AppPaySystemV2/apppayacc", params, HttpUtils.FORM_TYPE);
                    Map jsonObject = JSONObject.parseObject(result.body());
                    if(!jsonObject.get("resultcode").toString().equals("00")){
                        System.out.println("提交的参数:"+params);
                        System.out.println("接口返回:"+jsonObject);
                        ExceptionCast.cast(PayCode.WECHAT_PAY_FAILED_TO_PLACE_A_UNIFIED_ORDER, jsonObject.get("returnmsg").toString());
                    }
                    Map prepayid = JSONObject.parseObject(jsonObject.get("prepayid").toString());
                    prepayid.put("sign",prepayid.get("paySign"));
                    prepayid.remove("paySign");
                    resultMap = ResultMap.ok().put("data", prepayid);
                }
                break;
            case "ali_min_pay_cny":
                cfThirdPartyLoginQuery = new CfThirdPartyLoginQuery();
                cfThirdPartyLoginQuery.setUid(cfOrder.getUid());
                cfThirdPartyLoginQuery.setAppid(cfUserPaymentAgency.getAppid());
                cfThirdPartyLoginQuery.setPlatform(cfUserPaymentAgency.getUseScenes());
                cfThirdPartyLogins = cfThirdPartyLoginService.getListByQuery(cfThirdPartyLoginQuery);
                openid = "";
                if(cfUserPaymentAgency.getAccountNumberNote().equals("duo_la_bao")){
                    //哆啦宝

                    Map<String, Object> returnMap = new HashMap<>();


                    resultMap = ResultMap.ok().put("data", returnMap);
                }else{
                    if(cfThirdPartyLogins == null || cfThirdPartyLogins.size()==0){
                        return null;
                    }
                    Object alipayConfig = alipayService.initAlipayConfig(cfUserPaymentAgency);
                    resultMap = alipayService.doPay(cfOrder, cfThirdPartyLogins.get(0).getOpenid(), alipayConfig);
                }

                break;
            case "ali_h5_pay_cny":
                Object alipayConfig = alipayService.initAlipayConfig(cfUserPaymentAgency);
                if(!cfUserPaymentAgency.getAccountNumberNote().equals("yi_sheng_pay")) {
                    resultMap = alipayService.doPay(cfOrder, "wap",alipayConfig);
                }else{
                    //易生支付

                }

                break;
            default:
                ExceptionCast.cast(PayCode.PAYMENT_INSTITUTION_DOES_NOT_EXIST);
        }
        return resultMap;
    }

    @Override
    public void handlePaySuccessfulOrder(CfOrder cfOrder) {
        update(cfOrder);
        switch (cfOrder.getGoodsType()){
            case (byte)1:
                CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.findById(cfOrder.getGoodsId(), false);
                cfCarParkUseLog.setPayTime(System.currentTimeMillis());
                break;
            case (byte)5:
                CfCarParkPackagePrice cfCarParkPackagePrice = cfCarParkPackagePriceService.findById(cfOrder.getGoodsId(), false);
                CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
                cfCarParkPackageQuery.setCarParkId(cfCarParkPackagePrice.getCarParkId());
                cfCarParkPackageQuery.setNumberPlate(cfOrder.getEffectObject());
                List<CfCarParkPackage> cfCarParkPackages = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
                if(cfCarParkPackages==null ||cfCarParkPackages.size()==0){
                    CfCarParkPackage cfCarParkPackage = new CfCarParkPackage();
                    cfCarParkPackage.setCarParkId(cfCarParkPackagePrice.getCarParkId());
                    cfCarParkPackage.setTypeKey(cfCarParkPackagePrice.getFlagKey());
                    cfCarParkPackage.setStartTime(System.currentTimeMillis());
                    cfCarParkPackage.setEndTime(System.currentTimeMillis()+cfCarParkPackagePrice.getTimeQuota());
                    cfCarParkPackage.setCreateTime(System.currentTimeMillis());
                    cfCarParkPackage.setUid(cfOrder.getUid());
                    cfCarParkPackage.setNumberPlate(cfOrder.getEffectObject());
                    cfCarParkPackageService.add(cfCarParkPackage);
                }else{
                    long oldEndTime = cfCarParkPackages.get(0).getEndTime();
                    if(oldEndTime>System.currentTimeMillis()){
                        cfCarParkPackages.get(0).setEndTime(oldEndTime+cfCarParkPackagePrice.getTimeQuota());
                    }else{
                        cfCarParkPackages.get(0).setEndTime(System.currentTimeMillis()+cfCarParkPackagePrice.getTimeQuota());
                    }
                    cfCarParkPackageService.update(cfCarParkPackages.get(0));
                    //更新跨区停车场的到期时间
                    cfCarParkPackageQuery.setParentId(cfCarParkPackages.get(0).getId());
                    CfCarParkPackage parkPackage = new CfCarParkPackage();
                    parkPackage.setEndTime(oldEndTime+cfCarParkPackagePrice.getTimeQuota());
                    cfCarParkPackageService.updateByQuery(cfCarParkPackageQuery, parkPackage);
                }
                break;
        }
    }

    @Override
    public List<CountByDay> limitDaysCountByDay(CfCountFinanceQuery cfCountFinanceQuery) {
        return cfOrderMapper.limitDaysCountByDay(cfCountFinanceQuery);
    }

    @Override
    public List<CountByDay> limitDaysCountByDayFromPayTime(CfCountFinanceQuery cfCountFinanceQuery) {
        return cfOrderMapper.limitDaysCountByDayFromPayTime(cfCountFinanceQuery);
    }

    @Override
    public List<CountByDay> yearMonthCountByDay(CfCountFinanceQuery cfCountFinanceQuery) {
        cfCountFinanceQuery.setDate(cfCountFinanceQuery.getYear()+"-"+cfCountFinanceQuery.getMonth()+"-16"+" 00:00:00");
        return cfOrderMapper.yearMonthCountByDay(cfCountFinanceQuery);
    }

    @Override
    public List<CountByDay> yearCountByMonth(CfCountFinanceQuery cfCountFinanceQuery) {
        cfCountFinanceQuery.setDate(cfCountFinanceQuery.getYear()+"-01-01 00:00:00");
        cfCountFinanceQuery.setEndDate(cfCountFinanceQuery.getYear()+"-12-31 23:59:59");
        return cfOrderMapper.yearCountByMonth(cfCountFinanceQuery);
    }

    @Override
    public Integer flushOrderId(String newOrderId, String oldOrderId) {
        return cfOrderMapper.flushOrderId(newOrderId, oldOrderId);
    }

    @Override
    public Object paySuccessAndupdateOrder(CfOrder cfOrder, BigDecimal paiedTotalFee) throws Exception {
        if(cfOrder.getStatus()==PayStatus.PAID){
            return null;
        }
        if(cfOrder.getGoodsType().equals(GoodsType.CARPARK_PAYMENT) || cfOrder.getGoodsType().equals(GoodsType.MALL_CONSUMPTION)){
            try {
                carParkUseLogPaySuccessfullHandle(cfOrder, paiedTotalFee);
            } catch (Exception e) {
                logger.error("停车缴费支付成功后处理出现异常，订单id："+cfOrder.getId());
                e.printStackTrace();
            }
        }else if(cfOrder.getGoodsType().equals(GoodsType.DEPOSIT)){
            CfAccountQuery cfAccountQuery = new CfAccountQuery();
            cfAccountQuery.setUid(cfOrder.getUid());
            cfAccountQuery.setScoreType(cfOrder.getScoreKeyFlag());
            cfAccountQuery.setChangeValue(paiedTotalFee);
            cfAccountService.checkAndAddBalance(cfAccountQuery);

            cfOrder.setAmountActuallyPaid(paiedTotalFee);
            cfOrder.setStatus(PayStatus.PAID);

        }else if(cfOrder.getGoodsType().equals(GoodsType.CARPARK_PAYMENT_PACKEAGE)){
            carParkPackagePaySuccessfullHandle(cfOrder, paiedTotalFee);
        }else if(cfOrder.getGoodsType().equals(GoodsType.COUPON_ACTIVITY_RECHARGE)){
            //增减活动额度
            CfCouponActivity cfCouponActivity = cfCouponActivityService.findById(cfOrder.getGoodsId());
            CfCouponActivity updateCouponActivity = new CfCouponActivity();
            updateCouponActivity.setId(cfCouponActivity.getId());
            switch (new Byte(cfOrder.getEffectObject())){
                case CouponType.TIMES_COUPON:   //次数券
                    updateCouponActivity.setRemainingTimes(cfOrder.getPurchaseQuantity()+cfCouponActivity.getRemainingTimes());
                    break;
                case CouponType.AMOUNT_COUPON:  //金额券
                    updateCouponActivity.setTotalIssueQuota((cfCouponActivity.getTotalIssueQuota().add((paiedTotalFee).multiply(cfCouponActivity.getRechargeRatio()))).setScale(2, BigDecimal.ROUND_HALF_UP));
                    break;
                case CouponType.TIME_COUPON:    //时长券
                    updateCouponActivity.setRemainingTime(cfOrder.getPurchaseQuantity().longValue()*3600000l+cfCouponActivity.getRemainingTime());
                    break;
                default:
                    ExceptionCast.cast(CouponActivityCode.ACTIVITY_NOT_MATCH_COUPON_TYPE);
                    break;
            }

            cfCouponActivityService.updateByPrimaryKeySelective(updateCouponActivity);
            cfOrder.setAmountActuallyPaid(paiedTotalFee);
            cfOrder.setStatus(PayStatus.PAID);
        }

        if(StringUtils.isNotEmpty(cfOrder.getUserPaymentAgencyId())){
            CfUserPaymentAgency cfUserPaymentAgency = cfUserPaymentAgencyService.findById(cfOrder.getUserPaymentAgencyId());
            if(cfUserPaymentAgency!=null){
                cfOrder.setPaymentAgencyShortName(cfUserPaymentAgency.getPaymentAgencyShortName());
            }
        }

        //通知超级管理员入账消息
        CfRoleQuery cfRoleQuery = new CfRoleQuery();
        cfRoleQuery.setFlagKey("admin");
        cfRoleQuery.setPage(1);
        cfRoleQuery.setSize(1);
        List<CfRole> cfRoleList = cfRoleService.getListByQuery(cfRoleQuery);
        if(cfRoleList!=null && cfRoleList.size()>0){
            try {
                CfUserRoleQuery cfUserRoleQuery = new CfUserRoleQuery();
                cfUserRoleQuery.setRoleId(cfRoleList.get(0).getId());
                List<CfUserRole> cfUserRoleList = cfUserRoleService.getListByQuery(cfUserRoleQuery);
                if(cfUserRoleList!=null && cfUserRoleList.size()>0){
                    for (CfUserRole cfUserRole: cfUserRoleList){
                        CfUserMessage cfUserMessage = new CfUserMessage();
                        cfUserMessage.setFromUid("0");
                        cfUserMessage.setToUid(cfUserRole.getUid());
                        cfUserMessage.setGroupId("");
                        cfUserMessage.setContents(JSONObject.toJSONString(cfOrder));
                        cfUserMessage.setType(4);
                        cfUserMessage.setIp("");
                        cfUserMessageService.sendMessage(cfUserMessage);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return update(cfOrder);
    }

    /**
     * 停车缴费支付成功后相关业务处理
     * @param cfOrder
     * @param paiedTotalFee
     * @return
     */
    private CfOrder carParkUseLogPaySuccessfullHandle(CfOrder cfOrder, BigDecimal paiedTotalFee) throws Exception{
        CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.findById(cfOrder.getGoodsId(), false);

        cfOrder.setAmountActuallyPaid(paiedTotalFee);
        cfOrder.setStatus(PayStatus.PAID);
        if(cfOrder.getGoodsType().equals(GoodsType.CARPARK_PAYMENT)){
            CfCarParkUseLog updateCarParkUseLog = new CfCarParkUseLog();
            updateCarParkUseLog.setId(cfCarParkUseLog.getId());
            updateCarParkUseLog.setPayTime(cfOrder.getPayTime());
            cfCarParkUseLog.setPayTime(cfOrder.getPayTime());
            cfCarParkUseLogService.updateByPrimaryKeySelective(updateCarParkUseLog);
        }
        //如果该停车记录存在赠送停车时间进行部分抵扣
        if(cfCarParkUseLog.getGiveAwayParkTime()>0){
            //更新指定特殊车辆的剩余停车时间(说明本次抵扣后已用完)
            CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
            cfCarParkSpecialCarQuery.setNumberPlate(cfCarParkUseLog.getNumberPlate());
            cfCarParkSpecialCarQuery.setCarParkId(cfCarParkUseLog.getCarParkId());
            cfCarParkSpecialCarQuery.setMaxStartTime(System.currentTimeMillis());
            cfCarParkSpecialCarQuery.setMinEndTime(System.currentTimeMillis());
            cfCarParkSpecialCarQuery.setPage(1);
            cfCarParkSpecialCarQuery.setSize(1);
            List<CfCarParkSpecialCar> cfCarParkSpecialCars = cfCarParkSpecialCarService.getListByQuery(cfCarParkSpecialCarQuery);
            if(cfCarParkSpecialCars!=null && cfCarParkSpecialCars.size()>0){
                CfCarParkSpecialCar cfCarParkSpecialCar = new CfCarParkSpecialCar();
                cfCarParkSpecialCar.setId(cfCarParkSpecialCars.get(0).getId());
                cfCarParkSpecialCar.setRemainingParkTime(0l);
                cfCarParkSpecialCarService.update(cfCarParkSpecialCar);
            }
        }
        //如果车辆未出场，生成新的停车记录和订单
        if(cfCarParkUseLog.getOutTime()==0){
            carParkUseLogPaySuccessfullNotOutHandle(cfOrder, cfCarParkUseLog);
        }else{
            CfCarParkUseLog cfCarParkUseLog2 = new CfCarParkUseLog();
            cfCarParkUseLog2.setId(cfCarParkUseLog.getId());
            cfCarParkUseLog2.setOutReleaseType(ReleaseType.AUTO);
            this.cfCarParkUseLogService.updateByPrimaryKeySelective(cfCarParkUseLog2);
            try {
                cfCarParkUseLog.setCfOrder(cfOrder);
                cfCarParkReleaseLogService.executeReleaseByCarParkUseLog(cfCarParkUseLog,"自助缴费开闸" ,(byte)1);
            } catch (Exception e) {
                //开闸失败不能影响其它账单后续操作，等待5秒后，进行二次开闸
                logger.error("电子支付成功后开闸失败，准备5秒后尝试二次开闸，停车记录id："+cfCarParkUseLog.getId());
                e.printStackTrace();
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000); //延时5秒
                            cfCarParkReleaseLogService.executeReleaseByCarParkUseLog(cfCarParkUseLog,"自助缴费开闸" ,(byte)1);
                        } catch (Exception e) {
                            logger.error("尝试二次开闸失败，停车记录id："+cfCarParkUseLog.getId());
                        }
                    }
                };
                thread.start();
            }
            //给值班人员发送即时消息通知
            if(StringUtils.isNotEmpty(cfCarParkUseLog.getOutHandleUid())){
                try {
                    cfCarParkUseLogService.sendMessage(cfCarParkUseLog, cfCarParkUseLog.getOutHandleUid(), 2);
                } catch (Exception e) {
                    //通知失败不能影响后续操作
                    logger.error("电子支付成功后通知岗亭人员失败，停车记录id："+cfCarParkUseLog.getId());
                }
            }
        }

        if(StringUtils.isNotEmpty(cfOrder.getCouponId())){
            CfCoupon coupon = cfCouponService.findById(cfOrder.getCouponId());
            if(coupon!=null && (coupon.getCouponType()!=(byte)1 || (coupon.getCouponType()!=(byte)1 && coupon.getDenomination().intValue()==1))){
                //更新优惠券状态
                CfCoupon cfCoupon = new CfCoupon();
                cfCoupon.setId(cfOrder.getCouponId());
                cfCoupon.setStatus(CouponStatus.USED);
                cfCoupon.setUseTime(System.currentTimeMillis());
                cfCoupon.setAmountUsed(cfOrder.getCouponPaid());
                cfCouponService.updateByPrimaryKeySelective(cfCoupon);
            }
            //次数券未用完，只减次数
            if(coupon!=null && coupon.getCouponType()==(byte)1 && coupon.getDenomination().intValue()>1){
                CfCoupon cfCoupon = new CfCoupon();
                cfCoupon.setId(cfOrder.getCouponId());
                cfCoupon.setDenomination(cfCoupon.getDenomination().subtract(new BigDecimal(1)));
                cfCouponService.updateByPrimaryKeySelective(cfCoupon);
            }
        }
        return cfOrder;
    }

    /**
     * 支付临停缴费成功但是车辆未出场处理
     * @param cfOrder
     * @param cfCarParkUseLog
     */
    private void carParkUseLogPaySuccessfullNotOutHandle(CfOrder cfOrder, CfCarParkUseLog cfCarParkUseLog) throws Exception {
        if(cfCarParkUseLog.getNumberPlate().equals("临A88888")){
            CfCarParkUseLog cfCarParkUseLog2 = new CfCarParkUseLog();
            cfCarParkUseLog2.setId(cfCarParkUseLog.getId());
            cfCarParkUseLog2.setOutTime(System.currentTimeMillis());
            cfCarParkUseLog2.setPayTime(cfOrder.getPayTime());
            cfCarParkUseLog2.setOutReleaseType(ReleaseType.AUTO);
            cfCarParkUseLogService.updateByPrimaryKeySelective(cfCarParkUseLog2);
            cfCarParkReleaseLogService.executeReleaseByCarParkUseLog(cfCarParkUseLog,"无牌车自助缴费开闸" ,(byte)1);
        }else{
            CfCarParkUseLog updateCarParkUseLog = new CfCarParkUseLog();
            updateCarParkUseLog.setId(cfCarParkUseLog.getId());
            updateCarParkUseLog.setOutTime(cfOrder.getPayTime());
            cfCarParkUseLogService.updateByPrimaryKeySelective(updateCarParkUseLog);

            cfCarParkUseLog.setId(idWorker.nextId());
            cfCarParkUseLog.setInTime(System.currentTimeMillis());
            cfCarParkUseLog.setCreatePosition(CarParkUseLogCreatePosition.IN);
            cfCarParkUseLog.setOutTime(0L);
            cfCarParkUseLog.setOutCheckPointId("");
            cfCarParkUseLog.setOutSmallImage("");
            cfCarParkUseLog.setOutBigImage("");
            cfCarParkUseLog.setPayTime(0L);
            cfCarParkUseLog.setUid("");
            cfCarParkUseLog.setSubscribeTime(0L);
            cfCarParkUseLog.setCancelSubscribeTime(0L);
            cfCarParkUseLog.setOutReleaseType(ReleaseType.UNKNOWN);
            cfCarParkUseLogService.add(cfCarParkUseLog);
        }
    }

    /**
     * 购买停车套餐支付成功后相关业务处理
     * @param cfOrder
     * @param paiedTotalFee
     * @return
     */
    private CfOrder carParkPackagePaySuccessfullHandle(CfOrder cfOrder, BigDecimal paiedTotalFee) throws Exception{
        cfOrder.setAmountActuallyPaid(paiedTotalFee);
        cfOrder.setStatus(PayStatus.PAID);
        //找到对应商品(停车套餐)
        CfCarParkPackagePrice cfCarParkPackagePrice = cfCarParkPackagePriceService.findById(cfOrder.getGoodsId(), false);
        //查询之前是否存在同类的套餐
        CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
        cfCarParkPackageQuery.setNumberPlate(cfOrder.getEffectObject());
        cfCarParkPackageQuery.setUid(cfOrder.getUid());
        cfCarParkPackageQuery.setTransRegional((byte)0);
        cfCarParkPackageQuery.setPackagePriceId(cfCarParkPackagePrice.getId());
        List<CfCarParkPackage> cfCarParkPackages = cfCarParkPackageService.getListByQuery(cfCarParkPackageQuery);
        CfCarParkPackage cfCarParkPackage = null;
        if(cfCarParkPackages==null || cfCarParkPackages.size()==0){
            //不存在，则新建
            cfCarParkPackage = new CfCarParkPackage();
            cfCarParkPackage.setCarParkId(cfCarParkPackagePrice.getCarParkId());
            cfCarParkPackage.setTypeKey(cfCarParkPackagePrice.getFlagKey());
            cfCarParkPackage.setUid(cfOrder.getUid());
            cfCarParkPackage.setNumberPlate(cfOrder.getEffectObject());
            cfCarParkPackage.setPackagePriceId(cfOrder.getGoodsId());
            cfCarParkPackage.setStartTime(System.currentTimeMillis());
            cfCarParkPackage.setSpecialGive((byte)0);
            cfCarParkPackage.setTransRegional((byte)0);
            cfCarParkPackage.setParentId("");
            CfUser cfUser = cfUserService.getUserByUid(cfOrder.getUid(), false);
            if(cfUser!=null){
                cfCarParkPackage.setPhone(cfUser.getPhone());
                cfCarParkPackage.setCarOwnerName(cfUser.getTrueName());
                cfCarParkPackage.setRemarks("自助购买");
            }else{
                cfCarParkPackage.setPhone("");
            }
            cfCarParkPackage.setMainCarParkId(cfCarParkPackagePrice.getCarParkId());
        }else{
            cfCarParkPackage = cfCarParkPackages.get(0);
        }
        if(StringUtils.isNotEmpty(cfCarParkPackage.getId())){
            long oldEndTime = cfCarParkPackages.get(0).getEndTime();
            //更新
            if(cfCarParkPackage.getEndTime()>System.currentTimeMillis()){
                //延期
                Long endTime = cfCarParkPackage.getEndTime();
                cfCarParkPackage.setEndTime(endTime+cfCarParkPackagePrice.getTimeQuota());
            }else{
                //从现在开始算
                cfCarParkPackage.setEndTime(System.currentTimeMillis()+cfCarParkPackagePrice.getTimeQuota());
            }
            //设置是否已经短信通知字段值为 0
            cfCarParkPackage.setNoticeExpiringSoon((byte)0);
            cfCarParkPackage.setNoticeExpired((byte)0);
            cfCarParkPackageService.update(cfCarParkPackage);

            //更新跨区停车场的到期时间
            cfCarParkPackageQuery.setParentId(cfCarParkPackages.get(0).getId());
            cfCarParkPackageQuery.setTransRegional(null);
            CfCarParkPackage parkPackage = new CfCarParkPackage();
            parkPackage.setEndTime(cfCarParkPackage.getEndTime());
            //设置跨区套餐是否已经短信通知字段值为 0
            parkPackage.setNoticeExpiringSoon((byte)0);
            parkPackage.setNoticeExpired((byte)0);
            cfCarParkPackageService.updateByQuery(cfCarParkPackageQuery, parkPackage);
        }else{
            //新建
            cfCarParkPackage.setEndTime(System.currentTimeMillis()+cfCarParkPackagePrice.getTimeQuota());
            cfCarParkPackageService.add(cfCarParkPackage);
        }
        //判断该账单是否存在临停车费追缴代收
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setCollectionOrderId(cfOrder.getId());
        cfOrderQuery.setGoodsType(GoodsType.CARPARK_PAYMENT);
        List<CfOrder> collectionOrderList = getListByQuery(cfOrderQuery);
        if(collectionOrderList!=null && collectionOrderList.size()>0){
            CfCarParkUseLog collectionCarParkUseLog = cfCarParkUseLogService.findById(collectionOrderList.get(0).getGoodsId());
            //如果该车辆还未支付出场，生成场内订单
            if(collectionCarParkUseLog!=null && collectionCarParkUseLog.getPayTime()==0){
                //结束被代缴的停车记录和其账单
                CfOrder collectionOrder = new CfOrder();
                collectionOrder.setId(collectionOrderList.get(0).getId());
                collectionOrder.setPayTime(System.currentTimeMillis());
                collectionOrder.setStatus(PayStatus.PAID);
                collectionOrder.setPaymentAgencyShortName(cfOrder.getPaymentAgencyShortName());
                collectionOrder.setAmountActuallyPaid(new BigDecimal(0.00));
                updateByPrimaryKeySelective(collectionOrder);

                CfCarParkUseLog collectionCarParkUseLogUpdate = new CfCarParkUseLog();
                collectionCarParkUseLogUpdate.setId(collectionCarParkUseLog.getId());
                collectionCarParkUseLogUpdate.setOutTime(collectionOrder.getPayTime());
                collectionCarParkUseLogUpdate.setPayTime(collectionOrder.getPayTime());
                cfCarParkUseLogService.updateByPrimaryKeySelective(collectionCarParkUseLogUpdate);

                carParkUseLogPaySuccessfullNotOutHandle(cfOrder, collectionCarParkUseLog);
            }
        }
        return cfOrder;
    }

    @Override
    public Object queryThirdPartyOrder(String platform, String orderId) throws Exception {
        CfOrder cfOrder = findById(orderId, false);
        CfUserPaymentAgency cfUserPaymentAgency = cfUserPaymentAgencyService.findById(cfOrder.getUserPaymentAgencyId(), false);
        Object returnObj = null;
        switch (platform){
            case "yi_sheng_pay":
                Map<String, String> params = new HashMap<>();
                params.put("channelid",cfUserPaymentAgency.getPayKey());
                params.put("merid",cfUserPaymentAgency.getSubMchId());
                params.put("termid",cfUserPaymentAgency.getSubAppid());
                params.put("opt","tradeQuery");
                params.put("tradetrace",cfOrder.getId());
                params.put("sign", SignUtil.getSign(params, cfUserPaymentAgency.getSecret()));
                String paramsString = "";
                String pre = "";
                int i = 0;
                for(Map.Entry<String, String> param: params.entrySet()){
                    pre = i==0 ? "?" : "&";
                    paramsString += pre + param.getKey() + "=" + param.getValue();
                    i++;
                }
                Connection.Response result = HttpUtils.get("https://open.eycard.cn:8443/WorthTech_Access_AppPaySystemV2/apppayacc"+paramsString);
                returnObj = result.body();
                break;
            default:
                ExceptionCast.cast(PayCode.PAYMENT_INSTITUTION_DOES_NOT_EXIST);
        }
        return returnObj;
    }

    @Override
    public BigDecimal countByField(CfOrderQuery cfOrderQuery) {
        BigDecimal countByField = cfOrderMapper.countByField(cfOrderQuery);
        if(countByField==null){
            return new BigDecimal("0.00");
        }
        return countByField;
    }
}
