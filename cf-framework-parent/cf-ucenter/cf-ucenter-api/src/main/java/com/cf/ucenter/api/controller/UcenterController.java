package com.cf.ucenter.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.domain.CfCarParkPackage;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import com.cf.carpark.service.CfCarParkPackageService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.BCryptUtil;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.*;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.domain.request.CfCouponActivityQuery;
import com.cf.pay.domain.request.CfUserPaymentAgencyQuery;
import com.cf.pay.service.*;
import com.cf.ucenter.api.config.AuthenticationInterceptor;
import com.cf.ucenter.api.swagger.UcenterSwagger;
import com.cf.ucenter.domain.*;
import com.cf.ucenter.request.*;
import com.cf.ucenter.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请在此填写描述
 *
 * @ClassName UcenterController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/21/021 15:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("ucenter/")
@Validated
public class UcenterController implements UcenterSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;
    @Autowired
    private HttpServletRequest request;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfSystemConfigService cfSystemConfigService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfThirdPartyLoginService cfThirdPartyLoginService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAccountService cfAccountService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponService cfCouponService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponActivityService cfCouponActivityService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkPackageService cfCarParkPackageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserRoleService cfUserRoleService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private AuthService authService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserPaymentAgencyService cfUserPaymentAgencyService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;

    @Override
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseResult register(
            @RequestParam("phone")
        @Pattern(regexp = "^(1[3-9])[0-9]{9}$", message = "手机号不合法") String phone,
            @RequestParam("sms_code")
        @NotEmpty String smsCode,
            @RequestParam("username")
        @Pattern(regexp = "^[a-zA-Z0-9_]{5,32}$", message = "用户名长度5-32位") String userName,
            @RequestParam("password")
        @Size(min = 10, max = 32, message = "密码长度10-32位") String password,
            @RequestParam("nick_name")
            @Size(min = 1, max = 20, message = "昵称长度1-20位") String nickName) {
        return new ResponseResult(CommonCode.SUCCESS, cfUserService.register(phone, smsCode, userName, password, nickName));
    }

    @Override
    @RequestMapping(value = "findByKey", method = RequestMethod.GET)
    public ResponseResult findByKey(
            @RequestParam("key")
            @Pattern(regexp = "^[a-zA-Z0-9_]{1,64}$", message = "关键字长度1-64位") String key) {
        List<CfUser> cfUsers = cfUserService.findByPhoneOrUidOrName(key);
        return cfUsers != null ? new ResponseResult(CommonCode.SUCCESS, cfUsers) : new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ResponseResult findById(String uid, String simpleQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        boolean filling = false;
        if(StringUtils.isEmpty(uid) || userBasicInfo.getId().equals(uid)){
            uid = userBasicInfo.getId();
            filling = true;
        }
        CfUser cfUser = cfUserService.getUserByUid(uid, filling);

        if (cfUser != null) {
            cfUser.setPassword("");
            if(!uid.equals(userBasicInfo.getId())){
                cfUser.setPhone("");
                cfUser.setEmail("");
            }
            FileUtils.handleFileSourcePrefix(cfUser, "", "avatar");
            return new ResponseResult(CommonCode.SUCCESS, cfUser);
        } else {
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
    }

    @Override
    @RequestMapping(value = "modifyPasswordByPhoneAndCode", method = RequestMethod.PUT)
    public ResponseResult modifyPasswordByPhoneAndCode(String password, String smsCode) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfUserService.modifyPasswordByPhoneAndCode(userBasicInfo.getId(), password, smsCode);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @Override
    @RequestMapping(value = "recoverPasswordByPhoneAndCode", method = RequestMethod.PUT)
    public ResponseResult recoverPasswordByPhoneAndCode(String phone, String password, String smsCode) {
        cfUserService.recoverPasswordByPhoneAndCode(phone, password, smsCode);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @Override
    @RequestMapping(value = "customerBaseUpdate", method = RequestMethod.PUT)
    public ResponseResult customerBaseUpdate(@Validated @RequestBody CfUserCustomerForm cfUserCustomerForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfUser cfUser = new CfUser();
        BeanUtils.copyProperties(cfUserCustomerForm, cfUser);
        cfUser.setId(userBasicInfo.getId());
        CfUser user = cfUserService.customerBaseUpdate(cfUser);
        CfAccountQuery cfAccountQuery = new CfAccountQuery();
        cfAccountQuery.setUid(cfUser.getId());
        cfAccountQuery.setScoreType("common_use");
        List<CfAccount> cfAccounts = cfAccountService.getListByQuery(cfAccountQuery);
        if(cfAccounts!=null && cfAccounts.size()>0){
            cfUser.setScore(cfAccounts.get(0).getBalance());
        }else{
            cfUser.setScore(new BigDecimal(0.00));
        }
        FileUtils.handleFileSourcePrefix(cfUser, "", "avatar");
        return new ResponseResult(CommonCode.SUCCESS, user);
    }

    private CfUser checkByUnionIdAndApiTokenAndPlatform(String unionId, String apiToken, String platform, String AppId){
        //获取token，进行校验
        CfSystemConfigQuery cfSystemConfigQuery = new CfSystemConfigQuery();
        cfSystemConfigQuery.setEnName("api_token");
        List<CfSystemConfig> cfSystemConfigs = cfSystemConfigService.getListByQuery(cfSystemConfigQuery);
        if(cfSystemConfigs==null || cfSystemConfigs.size()==0){
            ExceptionCast.cast(UcenterCode.SYSTEM_CONFIGURATION_DOES_NOT_EXIST, "api_token");
        }
        if(!apiToken.equals(cfSystemConfigs.get(0).getValue())){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_ILLEGAL);
        }

        CfUser cfUser = new CfUser();

        //先判断这个微信用户是否存在
        CfThirdPartyLoginQuery cfThirdPartyLoginQuery = new CfThirdPartyLoginQuery();
        cfThirdPartyLoginQuery.setPlatform(platform);
        cfThirdPartyLoginQuery.setUnionid(unionId);
        List<CfThirdPartyLogin> cfThirdPartyLogins = cfThirdPartyLoginService.getListByQuery(cfThirdPartyLoginQuery);
        if(cfThirdPartyLogins==null || cfThirdPartyLogins.size()==0){
            WxUser wxUser = new WxUser();
            wxUser.setUnionid(unionId);
            wxUser.setNickname("");
            wxUser.setHeadimgurl("");
            wxUser.setSex(0);
            wxUser.setOpenid("");
            wxUser.setAppid(AppId);
            cfUser = cfUserService.addOrUpdateUserByWxUser(wxUser, platform);
        }else{
            cfUser = cfUserService.getUserByUid(cfThirdPartyLogins.get(0).getUid(), false);
            if(cfUser==null || cfUser.getId()==null){
                ExceptionCast.cast(UcenterCode.UCENTER_ACCOUNT_NOTEXISTS);
            }
        }
        return cfUser;
    }

    @Override
    @RequestMapping(value = "updateCustomerByWxUser", method = RequestMethod.POST)
    public ResponseResult updateCustomerByWxUser(@RequestBody CfWxUserForm cfWxUserForm) throws Exception {
        CfUser cfUser = checkByUnionIdAndApiTokenAndPlatform(cfWxUserForm.getUnionid(), cfWxUserForm.getToken(), cfWxUserForm.getPlatform(), cfWxUserForm.getAppId());

        //更新用户账户相关信息
        CfAccount account = new CfAccount();
        if(cfWxUserForm.getScore()!=null && cfWxUserForm.getScoreAction()!=null && StringUtils.isNotEmpty(cfWxUserForm.getScoreType())){
            CfAccount cfAccount = new CfAccount();
            cfAccount.setUid(cfUser.getId());
            cfAccount.setScoreType(cfWxUserForm.getScoreType());
            cfAccount.setBalance(new BigDecimal(0.00));
            cfAccount.setFreeze(0L);
            cfAccount.setType((byte)0);
            //先判断该用户账户是否已经存在
            account = cfAccountService.autoCheckExistAndAddByUidAndScoreType(cfAccount);


            if(cfWxUserForm.getScoreAction()==(byte)0){
                account.setBalance(cfWxUserForm.getScore());
            }else if(cfWxUserForm.getScoreAction()==(byte)-1){
                BigDecimal balance = account.getBalance();
                account.setBalance(balance.subtract(cfWxUserForm.getScore()));
                if(account.getBalance().doubleValue()<0){
                    account.setBalance(new BigDecimal(0.00));
                }
            }else if(cfWxUserForm.getScoreAction()==(byte)1){
                BigDecimal balance = account.getBalance();
                account.setBalance(balance.add(cfWxUserForm.getScore()));
            }
            cfAccountService.update(account);
        }
        //给相关用户发券
        CfCoupon cfCoupon = new CfCoupon();
        if(cfWxUserForm.getCouponDenomination()!=null && cfWxUserForm.getCouponScenes()!=null && cfWxUserForm.getCouponType()!=null
        && cfWxUserForm.getEffectiveTime()!=null && cfWxUserForm.getExpireTime()!=null && StringUtils.isNotEmpty(cfWxUserForm.getShopIds())){
            cfCoupon.setFromUid("0");
            cfCoupon.setToUid(cfUser.getId());
            cfCoupon.setScenes(cfWxUserForm.getCouponScenes());
            cfCoupon.setShopId("");
            cfCoupon.setGoodsId("");
            cfCoupon.setDenomination(cfWxUserForm.getCouponDenomination());
            cfCoupon.setThresholdPrice(new BigDecimal(0.00));
            cfCoupon.setStatus((byte)1);
            cfCoupon.setAmountUsed(new BigDecimal(0.00));
            cfCoupon.setCouponType(cfWxUserForm.getCouponType());
            cfCoupon.setEffectiveTime(cfWxUserForm.getEffectiveTime());
            cfCoupon.setExpireTime(cfWxUserForm.getExpireTime());
            cfCoupon.setUseTime(0L);
            String scene = null;
            switch (cfWxUserForm.getCouponScenes()){
                case (byte)1:
                    scene = "carpark";
                    break;
                case (byte)2:
                    scene = "shop";
                    break;
                default:
                    scene = "common";
            }
            cfCoupon = cfCouponService.addCouponAndLinkshops(cfCoupon, cfWxUserForm.getShopIds(), scene);
        }
        //更改指定账单
        CfOrder cfOrder = null;
        if(cfWxUserForm.getOrderForm()!=null && StringUtils.isNotEmpty(cfWxUserForm.getOrderForm().getId())){
            checkSign(cfWxUserForm);
            cfOrder = cfOrderService.findById(cfWxUserForm.getOrderForm().getId(), false);
            cfOrder.setUserPaymentAgencyId(cfWxUserForm.getOrderForm().getUserPaymentAgencyId());
            if(StringUtils.isNotEmpty(cfWxUserForm.getOrderForm().getCouponId())){
                cfCouponService.findById(cfWxUserForm.getOrderForm().getCouponId(), false);
                cfOrder.setCouponId(cfWxUserForm.getOrderForm().getCouponId());
            }
            cfOrder.setUid(cfUser.getId());
            cfOrder.setThirdPartyOrderId(cfWxUserForm.getOrderForm().getThirdPartyOrderId());
            cfOrder.setPayTime(System.currentTimeMillis());

            cfOrderService.paySuccessAndupdateOrder(cfOrder, cfWxUserForm.getOrderForm().getAmountActuallyPaid());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",cfUser);
        jsonObject.put("account",account);
        jsonObject.put("cfCoupon",cfCoupon);
        jsonObject.put("cfOrder",cfOrder);
        return new ResponseResult(CommonCode.SUCCESS, jsonObject);
    }

    private void checkSign(CfWxUserForm cfWxUserForm) throws Exception {
        //获取token，进行校验
        CfSystemConfigQuery cfSystemConfigQuery = new CfSystemConfigQuery();
        cfSystemConfigQuery.setEnName("api_token");
        List<CfSystemConfig> cfSystemConfigs = cfSystemConfigService.getListByQuery(cfSystemConfigQuery);
        if(cfSystemConfigs==null || cfSystemConfigs.size()==0){
            ExceptionCast.cast(UcenterCode.SYSTEM_CONFIGURATION_DOES_NOT_EXIST, "api_token");
        }
        Map<String,String> params = new HashMap<>();
        Class cls = cfWxUserForm.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            Field f = fields[i];
            f.setAccessible(true);
            if(f.getName()!=null && !f.getName().equals("serialVersionUID") && !f.getName().equals("orderForm") && !f.getName().equals("signType") && !f.getName().equals("dataSign") && f.get(cfWxUserForm)!=null && StringUtils.isNotEmpty(f.get(cfWxUserForm).toString())){
                params.put(f.getName(), f.get(cfWxUserForm).toString());
            }else if(f.getName().equals("orderForm") && f.get(cfWxUserForm)!=null){
                Class cls2 = cfWxUserForm.getOrderForm().getClass();
                Field[] fields2 = cls2.getDeclaredFields();
                for(int j=0; j<fields.length; j++){
                    Field f2 = fields2[j];
                    f2.setAccessible(true);
                    if(f2.getName()!=null && f2.get(cfWxUserForm.getOrderForm())!=null && StringUtils.isNotEmpty(f2.get(cfWxUserForm.getOrderForm()).toString())){
                        params.put(f2.getName(), f2.get(cfWxUserForm.getOrderForm()).toString());
                    }
                }
            }
        }
        params.put("sign", cfWxUserForm.getDataSign());
        boolean signatureValid = BCryptUtil.isSignatureValid(params, cfSystemConfigs.get(0).getValue(), cfWxUserForm.getSignType());
        if(!signatureValid){
            throw new Exception("invalid sign");
        }
    }

    @Override
    @RequestMapping(value = "getUserInfoByUnionIdAndApiToken", method = RequestMethod.GET)
    public ResponseResult getUserInfoByUnionIdAndApiToken(CfWxUserForm cfWxUserForm) {
        CfUser cfUser = checkByUnionIdAndApiTokenAndPlatform(cfWxUserForm.getUnionid(), cfWxUserForm.getToken(), cfWxUserForm.getPlatform(), cfWxUserForm.getAppId());

        UserBasicInfo userBasicInfo = new UserBasicInfo();
        userBasicInfo.setRoles(new ArrayList<String>());
        if(cfUser.getCfRoles()!=null && cfUser.getCfRoles().size()>0){
            for (CfRole cfRole: cfUser.getCfRoles()){
                userBasicInfo.getRoles().add(cfRole.getFlagKey());
            }
        }
        userBasicInfo.setId(cfUser.getId());
        userBasicInfo.setUsername(cfUser.getUserName());
        userBasicInfo.setAuthorities(new ArrayList<>());
        userBasicInfo.setExp(2592000000l);
        AuthToken authToken = authService.createJwtToken(userBasicInfo);
        return new ResponseResult(CommonCode.SUCCESS, cfUser, authToken, 0);
    }

    @Override
    @RequestMapping(value = "bindPhone", method = RequestMethod.POST)
    public ResponseResult bindPhone(@RequestBody CheckSms checkSms) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfUser cfUser = cfUserService.bindPhone(userBasicInfo.getId(), checkSms.getPhone(), checkSms.getSmsCode());

        //临时使用，后期此处代码删除  判断该手机号是否有商户活动，如果有将对应活动绑定到该用户名下
        CfCouponActivityQuery cfCouponActivityQuery = new CfCouponActivityQuery();
        cfCouponActivityQuery.setPhone(checkSms.getPhone());
        List<CfCouponActivity> cfCouponActivities = cfCouponActivityService.getListByQuery(cfCouponActivityQuery);
        if(cfCouponActivities!=null && cfCouponActivities.size()>0 && StringUtils.isEmpty(cfCouponActivities.get(0).getMainBodyId())){
            cfCouponActivities.get(0).setMainBodyId(cfUser.getId());
            cfCouponActivityService.update(cfCouponActivities.get(0));
            //设置该用户为商家
            cfUserRoleService.addByUidAndRoleKey(userBasicInfo.getId(),"merchant");
        }

        //临时使用，后期此处代码删除  判断该手机号是否有套餐，如果有将对应套餐绑定到该用户名下
        CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
        cfCarParkPackageQuery.setPhone(checkSms.getPhone());
        cfCarParkPackageQuery.setUid("");
        CfCarParkPackage cfCarParkPackage = new CfCarParkPackage();
        cfCarParkPackage.setUid(cfUser.getId());
        cfCarParkPackageService.batchBindUserByPhone(cfUser.getId(), checkSms.getPhone());

        return new ResponseResult(CommonCode.SUCCESS, cfUser);
    }

    @Override
    @RequestMapping(value = "getClientIp", method = RequestMethod.GET)
    public ResponseResult getClientIp(HttpServletRequest request) throws Exception {
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return new ResponseResult(CommonCode.SUCCESS, ipAddress);
    }
}
