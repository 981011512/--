package com.cf.ucenter.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipayEncrypt;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.cf.carpark.domain.CfCarParkPackage;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import com.cf.carpark.service.CfCarParkPackageService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.request.LoginRequest;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.Snowflake;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.CfAccount;
import com.cf.pay.domain.CfCouponActivity;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.domain.request.CfCouponActivityQuery;
import com.cf.pay.service.CfAccountService;
import com.cf.pay.service.CfCouponActivityService;
import com.cf.ucenter.api.config.AuthenticationInterceptor;
import com.cf.ucenter.api.swagger.AuthSwagger;
import com.cf.ucenter.domain.*;
import com.cf.ucenter.request.CfThirdPartyLoginQuery;
import com.cf.ucenter.request.CfWeixinConfigQuery;
import com.cf.ucenter.service.*;
import com.cf.ucenter.type.ThirdPartyPlatformType;
import com.cf.ucenter.wxtools.CheckUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * 请在此填写描述
 *
 * @ClassName AuthSwaggerController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/10/010 23:10
 * @Version 1.0
 **/
@RestController
@RequestMapping("auth/")
public class AuthController implements AuthSwagger {

    @Value("${auth.clientId}")
    String clientId;
    @Value("${auth.clientSecret}")
    String clientSecret;
    @Value("${auth.cookieDomain}")
    String cookieDomain;
    @Value("${auth.cookieMaxAge}")
    int cookieMaxAge;
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private AuthService authService;

    private static Logger logger = LoggerFactory.getLogger(Snowflake.class);

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeixinConfigService cfWeixinConfigService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAccountService cfAccountService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponActivityService cfCouponActivityService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserRoleService cfUserRoleService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkPackageService cfCarParkPackageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfThirdPartyLoginService cfThirdPartyLoginService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfThirdPartyPlatformApplicationService cfThirdPartyPlatformApplicationService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAccessTokenManageService cfAccessTokenManageService;

    @Override
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseResult login(@RequestBody LoginRequest loginRequest) throws Exception {
        if(loginRequest==null || StringUtils.isEmpty(loginRequest.getUsername())){
            ExceptionCast.cast(AuthCode.AUTH_USERNAME_NONE);
        }
        if(StringUtils.isEmpty(loginRequest.getPassword())){
            ExceptionCast.cast(AuthCode.AUTH_PASSWORD_NONE);
        }
        AuthToken authToken = authService.login(loginRequest.getUsername(), loginRequest.getPassword(), clientId, clientSecret);
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(authToken.getJwt_token());
        CfUser cfUser = cfUserService.getUserByUid(userBasicInfo.getId(), true);
        cfUser.setPassword(null);
        CfAccountQuery cfAccountQuery = new CfAccountQuery();
        cfAccountQuery.setUid(cfUser.getId());
        cfAccountQuery.setScoreType("common_use");
        List<CfAccount> cfAccounts = cfAccountService.getListByQuery(cfAccountQuery);
        if(cfAccounts!=null && cfAccounts.size()>0){
            cfUser.setScore(cfAccounts.get(0).getBalance());
        }else{
            cfUser.setScore(new BigDecimal(0.00));
        }
        return new ResponseResult(CommonCode.SUCCESS, cfUser, authToken, 0);
    }

    @Override
    @RequestMapping(value = "loginByPhone", method = RequestMethod.POST)
    public ResponseResult loginByPhone(@RequestBody LoginRequest loginRequest) {
        AuthToken authToken = authService.loginByPhone(loginRequest.getPhone(), loginRequest.getSmsCode(), clientId, clientSecret);
        return new ResponseResult(CommonCode.SUCCESS, null, authToken, 0);
    }

    @Override
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ResponseResult logout(String type) throws Exception {
        String jwt = HttpHearderUtils.getAuthorization(request);
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(jwt);
        Object deleteResult = null;
        if(type.equals("all")){
            deleteResult = stringRedisTemplate.delete("user:" + userBasicInfo.getUsername());
        }else if(type.equals("current")){
            deleteResult = stringRedisTemplate.boundSetOps("user:" + userBasicInfo.getUsername()).remove(jwt);
        }else{
            return new ResponseResult(CommonCode.FAIL, null, "invalid typ");
        }
        return new ResponseResult(CommonCode.SUCCESS, deleteResult);
    }

    @Override
    @RequestMapping(value = "wxLogin", method = RequestMethod.GET)
    public ModelAndView wxLogin() throws Exception {

        List<CfWeixinConfig> cfWeixinConfigs = getWeiXinLoginConfigragtion("h5_login");
        String weixinAppId = getWeiXinConfigragtionByEnName("h5_appid", cfWeixinConfigs);
        String callbackUrl = getWeiXinConfigragtionByEnName("h5_login_callback_url", cfWeixinConfigs);

        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + weixinAppId +
                "&redirect_uri=" + callbackUrl +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:"+url);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "getWxBaseUserInfoByCode", method = RequestMethod.GET)
    public ModelAndView getWxBaseUserInfoByCode(String code, String appid) throws Exception {
        Map<String, String> params = getLoginParams();
        String paramUri = params.get("paramUri");
        List<CfWeixinConfig> cfWeixinConfigs = getWeiXinLoginConfigragtion("h5_login");
        if(StringUtils.isEmpty(appid)){
            //获取默认的为微信公众号appid
            appid = getWeiXinConfigragtionByEnName("h5_appid", cfWeixinConfigs);
        }
        CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication = cfThirdPartyPlatformApplicationService.findByAppId(appid, false);
        String loginSuccessRedirectUrl = params.get("url")!=null ? params.get("url") : getWeiXinConfigragtionByEnName("h5_login_success_redirect_url", cfWeixinConfigs);

        // 第二步：通过code换取网页授权access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid +
                "&secret=" + cfThirdPartyPlatformApplication.getPublicKey() +
                "&code=" + code +
                "&grant_type=authorization_code";
        JSONObject jsonObject = HttpClient.doGet(url);

        // 第四步：拉取用户信息(需scope为 snsapi_userinfo)
        url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + jsonObject.getString("access_token") +
                "&openid=" + jsonObject.getString("openid") +
                "&lang=zh_CN";
        JSONObject userInfoJson = HttpClient.doGet(url);
        if(userInfoJson.get("errcode")!=null){
            ExceptionCast.cast(AuthCode.WECHAT_LOGIN_FAILED, userInfoJson.get("errmsg")+"");
            return null;
        }

        WxUser wxUser = getWxUserByUserInfoJson(userInfoJson);
        wxUser.setAppid(appid);
        CfUser cfUser = cfUserService.addOrUpdateUserByWxUser(wxUser, ThirdPartyPlatformType.WX_WB);
        cfUser.setPassword("");

        UserBasicInfo userBasicInfo = new UserBasicInfo();
        userBasicInfo.setId(cfUser.getId());
        userBasicInfo.setUsername(cfUser.getUserName());
        userBasicInfo.setAuthorities(new ArrayList<>());
        AuthToken authToken = authService.createJwtToken(userBasicInfo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:"+loginSuccessRedirectUrl+paramUri+"&jwt_token="+
                URLEncoder.encode(JSONObject.toJSONString(authToken),"UTF-8") +
                "&userInfo="+URLEncoder.encode(JSONObject.toJSONString(cfUser),"UTF-8"));
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "createJumpToWxMinData", method = RequestMethod.GET)
    public ResponseResult createJumpToWxMinData(String url, String appid) throws Exception {
        if(StringUtils.isEmpty(appid)){
            //获取默认微信公众号appid
            List<CfWeixinConfig> cfWeixinConfigs = getWeiXinLoginConfigragtion("h5_login");
            appid = getWeiXinConfigragtionByEnName("h5_appid", cfWeixinConfigs);
        }
        CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication = cfAccessTokenManageService.maintainWeiXinAccessToken(ThirdPartyPlatformType.WX_WB, appid);

        JSONObject ticketInfoJson = HttpClient.doGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+cfThirdPartyPlatformApplication.getTokenValue()+"&type=jsapi");
        Map<String, String> jumpData = new HashMap<>();
        jumpData.put("timestamp", LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"))+"");
        jumpData.put("noncestr", StringTools.getRandomString("",16));
        jumpData.put("appId", appid);
        String sha1Hex = DigestUtils.sha1Hex("jsapi_ticket=" + ticketInfoJson.getString("ticket") + "&noncestr=" + jumpData.get("noncestr") + "&timestamp=" +
                jumpData.get("timestamp") + "&url=" + url);
        jumpData.put("signature", sha1Hex);
        jumpData.put("original_id", cfThirdPartyPlatformApplication.getOriginalId());
        return new ResponseResult(CommonCode.SUCCESS, jumpData);
    }

    @Override
    @RequestMapping(value = "getAliBaseUserInfoByCode", method = RequestMethod.GET)
    public ModelAndView getAliBaseUserInfoByCode(String auth_code, String appid) throws Exception {

        if(StringUtils.isEmpty(auth_code)){
            return null;
        }
        List<CfWeixinConfig> cfWeixinConfigs = null;
        if(StringUtils.isEmpty(appid)){
            cfWeixinConfigs = getWeiXinLoginConfigragtion("ali_h5_login");
            appid = getWeiXinConfigragtionByEnName("ali_h5_appid", cfWeixinConfigs);
        }
        Map<String, String> params = getLoginParams();
        String paramUri = params.get("paramUri");
        CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication = cfThirdPartyPlatformApplicationService.findByAppId(appid, false);

        String url = params.get("url");
        if(StringUtils.isEmpty(url)){
            if(cfWeixinConfigs==null){
                cfWeixinConfigs = getWeiXinLoginConfigragtion("ali_h5_login");
            }
            url = getWeiXinConfigragtionByEnName("ali_h5_login_success_redirect_url", cfWeixinConfigs);
        }

        DefaultAlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", appid, cfThirdPartyPlatformApplication.getPrivateKey(),"json","UTF-8",cfThirdPartyPlatformApplication.getPublicKey(),"RSA2");
        // 通过authCode获取accessToken
        AlipaySystemOauthTokenRequest oauthTokenRequest = new AlipaySystemOauthTokenRequest();
        oauthTokenRequest.setCode(auth_code);
        oauthTokenRequest.setGrantType("authorization_code");
        AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(oauthTokenRequest);
        String accessToken = oauthTokenResponse.getAccessToken();
        if(StringUtils.isEmpty(accessToken)){
            ExceptionCast.cast(UcenterCode.UCENTER_LOGIN_ERROR,"支付获取accessToken为空");
        }

        // 根据accessToken获取用户信息
        AlipayUserInfoShareResponse userInfoResponse = alipayClient.execute(new AlipayUserInfoShareRequest(), accessToken);
        if (!userInfoResponse.isSuccess()){
            ExceptionCast.cast(UcenterCode.UCENTER_LOGIN_ERROR,"支付获取用户信息失败");
        }
        WxUser wxUser = new WxUser();
        wxUser.setUnionid(userInfoResponse.getUserId());
        wxUser.setOpenid(userInfoResponse.getUserId());
        wxUser.setSex(2);
        if(StringUtils.isEmpty(userInfoResponse.getNickName())){
            wxUser.setNickname("暂无昵称");
        }else{
            wxUser.setNickname(userInfoResponse.getNickName());
        }
        if(StringUtils.isEmpty(userInfoResponse.getAvatar())){
            wxUser.setHeadimgurl("");
        }else{
            wxUser.setHeadimgurl(userInfoResponse.getAvatar());
        }
        wxUser.setAppid(appid);
        CfUser cfUser = cfUserService.addOrUpdateUserByWxUser(wxUser, ThirdPartyPlatformType.ALI_WEB);
        cfUser.setPassword("");

        UserBasicInfo userBasicInfo = new UserBasicInfo();
        userBasicInfo.setId(cfUser.getId());
        userBasicInfo.setUsername(cfUser.getUserName());
        userBasicInfo.setAuthorities(new ArrayList<>());
        AuthToken authToken = authService.createJwtToken(userBasicInfo);



        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:"+url+paramUri+"&jwt_token="+
                URLEncoder.encode(JSONObject.toJSONString(authToken),"UTF-8") +
                "&userInfo="+URLEncoder.encode(JSONObject.toJSONString(cfUser),"UTF-8"));
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "getAliMinBaseUserInfoByCode", method = RequestMethod.GET)
    public ResponseResult getAliMinBaseUserInfoByCode(String auth_code, String appid) throws Exception {
        if(StringUtils.isEmpty(auth_code)){
            return null;
        }

        if(StringUtils.isEmpty(appid)){
            //获取默认的支付宝小程序appid
            List<CfWeixinConfig> cfWeixinConfigs = getWeiXinLoginConfigragtion("ali_h5_login");
            appid = getWeiXinConfigragtionByEnName("ali_min_appid", cfWeixinConfigs);
        }
        CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication = cfThirdPartyPlatformApplicationService.findByAppId(appid, false);

        DefaultAlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", appid, cfThirdPartyPlatformApplication.getPrivateKey(), "json", "UTF-8", cfThirdPartyPlatformApplication.getPublicKey(), "RSA2");
        // 通过authCode获取accessToken
        AlipaySystemOauthTokenRequest oauthTokenRequest = new AlipaySystemOauthTokenRequest();
        oauthTokenRequest.setCode(auth_code);
        oauthTokenRequest.setGrantType("authorization_code");
        AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(oauthTokenRequest);
        String accessToken = oauthTokenResponse.getAccessToken();
        if(StringUtils.isEmpty(accessToken)){
            ExceptionCast.cast(UcenterCode.UCENTER_LOGIN_ERROR,oauthTokenResponse.getSubMsg());
        }

        // 根据accessToken获取用户信息
        AlipayUserInfoShareResponse userInfoResponse = alipayClient.execute(new AlipayUserInfoShareRequest(), accessToken);
        if (!userInfoResponse.isSuccess()){
            ExceptionCast.cast(UcenterCode.UCENTER_LOGIN_ERROR,"支付获取用户信息失败");
        }
        WxUser wxUser = new WxUser();
        wxUser.setUnionid(userInfoResponse.getUserId());
        wxUser.setOpenid(userInfoResponse.getUserId());
        wxUser.setSex(2);
        if(StringUtils.isEmpty(userInfoResponse.getNickName())){
            wxUser.setNickname("暂无昵称");
        }else{
            wxUser.setNickname(userInfoResponse.getNickName());
        }
        if(StringUtils.isEmpty(userInfoResponse.getAvatar())){
            wxUser.setHeadimgurl("");
        }else{
            wxUser.setHeadimgurl(userInfoResponse.getAvatar());
        }
        wxUser.setAppid(appid);
        CfUser cfUser = cfUserService.addOrUpdateUserByWxUser(wxUser, ThirdPartyPlatformType.ALI_MP);
        cfUser.setPassword("");

        UserBasicInfo userBasicInfo = new UserBasicInfo();
        userBasicInfo.setId(cfUser.getId());
        userBasicInfo.setUsername(cfUser.getUserName());
        userBasicInfo.setAuthorities(new ArrayList<>());
        AuthToken authToken = authService.createJwtToken(userBasicInfo);

        return new ResponseResult(CommonCode.SUCCESS, cfUser, authToken, 0);
    }

    @Override
    @RequestMapping(value = "getWxBaseUserInfoByCodeAndLoginType", method = RequestMethod.GET)
    public ResponseResult getWxBaseUserInfoByCodeAndLoginType(String code,@Pattern(regexp = "^[mp|app]$", message = "请提供登录方式(mp-小程序|app-手机应用)") String loginType, String encryptedData, String iv, String url, String appid) throws Exception {
        if(StringUtils.isEmpty(appid)){
            //获取默认的微信应用appid
            if(loginType.equals("mp")){
                List<CfWeixinConfig> cfWeixinConfigs = getWeiXinLoginConfigragtion("mp_login");
                appid = getWeiXinConfigragtionByEnName("mp_appid", cfWeixinConfigs);
            }else if(loginType.equals("app")){
                List<CfWeixinConfig> cfWeixinConfigs = getWeiXinLoginConfigragtion("app_login");
                appid = getWeiXinConfigragtionByEnName("app_appid", cfWeixinConfigs);
            }else{
                ExceptionCast.cast(CommonCode.FAIL, "Login method is not currently supported");
            }
        }

        CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication = cfThirdPartyPlatformApplicationService.findByAppId(appid, false);

        if(loginType.equals("mp")){
            url = StringUtils.isNotEmpty(url) ? url : "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid +
                    "&secret=" + cfThirdPartyPlatformApplication.getPublicKey() + "&js_code="+code+"&grant_type=authorization_code";
        }else if(loginType.equals("app")){
            url = StringUtils.isNotEmpty(url) ? url : "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid +
                    "&secret=" + cfThirdPartyPlatformApplication.getPublicKey() + "&code="+code+"&grant_type=authorization_code";
        }else{
            ExceptionCast.cast(CommonCode.FAIL, "Login method is not currently supported");
        }

        JSONObject userInfoJson1 = HttpClient.doGet(url);
        JSONObject userInfoJson = null;
        if(userInfoJson1.get("errcode")!=null){
            ExceptionCast.cast(AuthCode.WECHAT_LOGIN_FAILED, userInfoJson1.get("errmsg")+"");
            return null;
        }

        if(loginType.equals("mp")){
            userInfoJson = getEncryptedData(encryptedData,userInfoJson1.getString("session_key"),iv);
            if(userInfoJson.get("openid")==null){
                userInfoJson.put("openid",userInfoJson1.get("openid"));
            }
            if(userInfoJson.get("unionid")==null){
                userInfoJson.put("unionid",userInfoJson1.get("unionid"));
            }
        }else if(loginType.equals("app")){
            String accessToken = cfAccessTokenManageService.getWeiXinAccessToken(ThirdPartyPlatformType.WX_APP, appid);
            userInfoJson = getWeiXinUserInfoByAccessToken(accessToken, userInfoJson.getString("openid"));
        }else{
            ExceptionCast.cast(AuthCode.WECHAT_LOGIN_FAILED, "Login method is not currently supported");
        }

        WxUser wxUser = getWxUserByUserInfoJson(userInfoJson);
        wxUser.setAppid(appid);
        CfUser cfUser = cfUserService.addOrUpdateUserByWxUser(wxUser, ThirdPartyPlatformType.WX_MP);
        cfUser.setPassword("");
        CfAccountQuery cfAccountQuery = new CfAccountQuery();
        cfAccountQuery.setUid(cfUser.getId());
        cfAccountQuery.setScoreType("common_use");
        List<CfAccount> cfAccounts = cfAccountService.getListByQuery(cfAccountQuery);
        if(cfAccounts!=null && cfAccounts.size()>0){
            cfUser.setScore(cfAccounts.get(0).getBalance());
        }else{
            cfUser.setScore(new BigDecimal(0.00));
        }

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
    @RequestMapping(value = "getUserPhonenumberByCodeAndLoginType", method = RequestMethod.GET)
    public ResponseResult getUserPhonenumberByCodeAndLoginType(String code, String loginType, String encryptedData, String iv, String appid) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(loginType.equals(ThirdPartyPlatformType.WX_MP)){
            if(StringUtils.isEmpty(appid)){
                //获取系统默认的appid
                List<CfWeixinConfig> cfWeixinConfigs = getWeiXinLoginConfigragtion("mp_login");
                appid = getWeiXinConfigragtionByEnName("mp_appid", cfWeixinConfigs);
            }
            String accessToken = cfAccessTokenManageService.getWeiXinAccessToken(ThirdPartyPlatformType.WX_MP, appid);
            JSONObject body = new JSONObject();
            body.put("code",code);
            JSONObject result = (JSONObject) HttpClient.doPost(body, "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=" + accessToken, new HashMap<>(), true);
            if(result.getInteger("errcode")==0){
                JSONObject phoneInfonfo = (JSONObject) result.get("phone_info");
                //判断该手机号是否已经绑定
                CfUser oldUser = cfUserService.findByPhone(phoneInfonfo.getString("purePhoneNumber"));
                CfUser cfUser = cfUserService.checkUserExistByUid(userBasicInfo.getId(), false);
                if(oldUser!=null){
                    CfThirdPartyLoginQuery cfThirdPartyLoginQuery = new CfThirdPartyLoginQuery();
                    cfThirdPartyLoginQuery.setUid(oldUser.getId());
                    cfThirdPartyLoginQuery.setAppid(appid);
                    cfThirdPartyLoginQuery.setPlatform(ThirdPartyPlatformType.WX_MP);
                    List<CfThirdPartyLogin> cfThirdPartyLoginList = cfThirdPartyLoginService.getListByQuery(cfThirdPartyLoginQuery);
                    if(cfThirdPartyLoginList!=null && cfThirdPartyLoginList.size()>0){
                        //如果原来已经有了微信登录数据，清除原有用户的手机绑定。更新当前用户的手机绑定
                        CfUser user = new CfUser();
                        user.setId(oldUser.getId());
                        user.setPhone("");
                        cfUserService.updateByPrimaryKeySelective(user);

                        user = new CfUser();
                        user.setId(userBasicInfo.getId());
                        user.setPhone(phoneInfonfo.getString("purePhoneNumber"));
                        cfUserService.updateByPrimaryKeySelective(user);
                    }else{
                        cfThirdPartyLoginQuery.setUid(userBasicInfo.getId());
                        cfThirdPartyLoginQuery.setAppid(appid);
                        cfThirdPartyLoginQuery.setPlatform(ThirdPartyPlatformType.WX_MP);

                        CfThirdPartyLogin updateCfThirdPartyLogin = new CfThirdPartyLogin();
                        updateCfThirdPartyLogin.setUid(oldUser.getId());
                        cfThirdPartyLoginService.updateByQuery(updateCfThirdPartyLogin, cfThirdPartyLoginQuery);
                    }
                }else{
                    //更新用户手机号
                    CfUser user = new CfUser();
                    user.setId(userBasicInfo.getId());
                    user.setPhone(phoneInfonfo.getString("purePhoneNumber"));
                    cfUserService.updateByPrimaryKeySelective(user);
                }

                cfUser.setPhone(phoneInfonfo.getString("purePhoneNumber"));
                cfUser.setPassword(null);
                //临时使用，后期此处代码删除  判断该手机号是否有商户活动，如果有将对应活动绑定到该用户名下
                CfCouponActivityQuery cfCouponActivityQuery = new CfCouponActivityQuery();
                cfCouponActivityQuery.setPhone(phoneInfonfo.getString("purePhoneNumber"));
                List<CfCouponActivity> cfCouponActivities = cfCouponActivityService.getListByQuery(cfCouponActivityQuery);
                if(cfCouponActivities!=null && cfCouponActivities.size()>0 && StringUtils.isEmpty(cfCouponActivities.get(0).getMainBodyId())){
                    cfCouponActivities.get(0).setMainBodyId(cfUser.getId());
                    cfCouponActivityService.update(cfCouponActivities.get(0));
                    //设置该用户为商家
                    cfUserRoleService.addByUidAndRoleKey(userBasicInfo.getId(),"merchant");
                }

                //临时使用，后期此处代码删除  判断该手机号是否有套餐，如果有将对应套餐绑定到该用户名下
                CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
                cfCarParkPackageQuery.setPhone(phoneInfonfo.getString("purePhoneNumber"));
                cfCarParkPackageQuery.setUid("");
                CfCarParkPackage cfCarParkPackage = new CfCarParkPackage();
                cfCarParkPackage.setUid(cfUser.getId());
                cfCarParkPackageService.batchBindUserByPhone(cfUser.getId(), phoneInfonfo.getString("purePhoneNumber"));
                return new ResponseResult(CommonCode.SUCCESS, cfUser, 1);
            }else{
                return new ResponseResult(CommonCode.FAIL, result, result.getString("errmsg"));
            }
        }else if(loginType.equals(ThirdPartyPlatformType.ALI_MP)){
            String response = code;

            //1. 获取验签和解密所需要的参数
            Map<String, String> openapiResult = JSON.parseObject(response,
                    new TypeReference<Map<String, String>>() {
                    }, Feature.OrderedField);
            String signType = "RSA2";
            String charset = "UTF-8";
            String encryptType = "AES";
            String sign = openapiResult.get("sign");
            String content = openapiResult.get("response");

            // 是否加密
            boolean isDataEncrypted = !content.startsWith("{");
            boolean signCheckPass = false;

            //2. 验签
            String signContent = content;
            List<CfWeixinConfig> cfWeixinConfigs = getWeiXinLoginConfigragtion("ali_h5_login");
            String decryptKey = getWeiXinConfigragtionByEnName("ali_h5_decrypt_key", cfWeixinConfigs);
            String signVeriKey = getWeiXinConfigragtionByEnName("ali_h5_public_key", cfWeixinConfigs);
            ;
            // 如果是加密的报文则需要在密文的前后添加双引号
            if (isDataEncrypted) {
                signContent = "\"" + signContent + "\"";
            }
            try {
                signCheckPass = AlipaySignature.rsaCheck(signContent, sign, signVeriKey, charset, signType);
            } catch (AlipayApiException e) {
                // 验签异常, 日志
            }
            if(!signCheckPass) {
                // 验签不通过（异常或者报文被篡改），终止流程（不需要做解密）
                throw new Exception("验签失败");
            }

            //3. 解密
            String plainData = null;
            if (isDataEncrypted) {
                try {
                    plainData = AlipayEncrypt.decryptContent(content, encryptType, decryptKey, charset);
                } catch (AlipayApiException e) {
                    //解密异常, 记录日志
                    throw new Exception("解密异常");
                }
            } else {
                plainData = content;
            }
            System.out.println(plainData);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
    }

    private Map<String, String> getLoginParams() throws Exception{

        Map<String, String> returnParams = new HashMap<>();
        String paramUri = "";

        Map<String, String> param = getAllRequestParam(request);
        Set<Map.Entry<String, String>> entries = param.entrySet();
        int i = 0;
        for(Map.Entry<String, String> entrie: entries){
            if(entrie.getKey().equals("datas") && StringUtils.isNotEmpty(entrie.getValue())){
                Map<String, String> datas = JSONObject.parseObject(entrie.getValue(), new TypeReference<Map<String, String>>() {
                });
                Set<Map.Entry<String, String>> entries2 = datas.entrySet();
                String qrCodeId = null;
                for(Map.Entry<String, String> entrie2: entries2){
                    if(entrie2.getKey().equals("url")){
                        returnParams.put("url",entrie2.getValue());
                        continue;
                    }
                    if(i==0){
                        paramUri += "?"+entrie2.getKey()+"="+entrie2.getValue();
                    }else{
                        paramUri += "&"+entrie2.getKey()+"="+entrie2.getValue();
                    }
                    i++;
                    if(entrie2.getKey().equals("qrCodeId")){
                        qrCodeId = entrie2.getValue();
                    }
                }

                if(qrCodeId!=null){
                    paramUri = "/getCoupons"+paramUri;
                }
                continue;
            }else{
                if(i==0){
                    paramUri += "?"+entrie.getKey()+"="+entrie.getValue();
                }else{
                    paramUri += "&"+entrie.getKey()+"="+entrie.getValue();
                }
                i++;
            }


        }
        returnParams.put("paramUri",paramUri);
        return returnParams;
    }

    private WxUser getWxUserByUserInfoJson(JSONObject userInfoJson)
    {
        WxUser wxUser = new WxUser();
        if(StringUtils.isNotEmpty(userInfoJson.getString("city"))){
            wxUser.setCity(userInfoJson.getString("city"));
        }else {
            wxUser.setCity("");
        }
        if(StringUtils.isNotEmpty(userInfoJson.getString("country"))){
            wxUser.setCountry(userInfoJson.getString("country"));
        }else {
            wxUser.setCountry("");
        }
        if(StringUtils.isNotEmpty(userInfoJson.getString("avatarUrl"))){
            wxUser.setHeadimgurl(userInfoJson.getString("avatarUrl"));
        }else if(StringUtils.isNotEmpty(userInfoJson.getString("headimgurl"))){
            wxUser.setHeadimgurl(userInfoJson.getString("headimgurl"));
        }else {
            wxUser.setHeadimgurl("");
        }
        if(StringUtils.isNotEmpty(userInfoJson.getString("nickName"))){
            wxUser.setNickname(userInfoJson.getString("nickName"));
        }else if(StringUtils.isNotEmpty(userInfoJson.getString("nickname"))){
            wxUser.setNickname(userInfoJson.getString("nickname"));
        }else {
            wxUser.setNickname("");
        }
        if(StringUtils.isNotEmpty(userInfoJson.getString("province"))){
            wxUser.setProvince(userInfoJson.getString("province"));
        }else {
            wxUser.setProvince("");
        }
        if(StringUtils.isNotEmpty(userInfoJson.getString("openId"))){
            wxUser.setOpenid(userInfoJson.getString("openId"));
        }else if(StringUtils.isNotEmpty(userInfoJson.getString("openid"))){
            wxUser.setOpenid(userInfoJson.getString("openid"));
        }
        wxUser.setUnionid("");
        if(StringUtils.isNotEmpty(userInfoJson.getString("unionid"))){
            wxUser.setUnionid(userInfoJson.getString("unionid"));
        }
        if(StringUtils.isNotEmpty(userInfoJson.getString("unionId"))){
            wxUser.setUnionid(userInfoJson.getString("unionId"));
        }
        if(StringUtils.isNotEmpty(userInfoJson.getString("gender"))){
            wxUser.setSex(Integer.parseInt(userInfoJson.getString("gender")));
        }else if(StringUtils.isNotEmpty(userInfoJson.getString("sex"))){
            wxUser.setSex(Integer.parseInt(userInfoJson.getString("sex")));
        }else {
            wxUser.setSex(0);
        }
        return wxUser;
    }

    private JSONObject getEncryptedData(String encryptedData, String sessionkey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionkey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.这个if中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + 1;
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            System.out.println("encryptedData="+encryptedData+",sessionkey="+sessionkey+",iv="+iv);
            e.printStackTrace();
            ExceptionCast.cast(AuthCode.WECHAT_LOGIN_FAILED, "weixin userInfo decode fail");
        }
        return null;
    }

    private JSONObject getWeiXinUserInfoByAccessToken(String accessToken, String openId) throws Exception
    {
        JSONObject userInfoJson = HttpClient.doGet("https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken+"&openid="+openId);
        if(userInfoJson.get("errcode")!=null){
            ExceptionCast.cast(AuthCode.WECHAT_LOGIN_FAILED, userInfoJson.get("errmsg")+"");
            return null;
        }
        return userInfoJson;
    }

    private List<CfWeixinConfig> getWeiXinLoginConfigragtion(String scenes)
    {
        CfWeixinConfigQuery cfWeixinConfigQuery = new CfWeixinConfigQuery();
        cfWeixinConfigQuery.setUseScenes(scenes);
        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getListByQuery(cfWeixinConfigQuery);
        if(cfWeixinConfigs.size()==0){
            ExceptionCast.cast(UcenterCode.MISSING_WECHAT_CONFIGURATION, "database miss weixin login configragtion data");
        }
        return cfWeixinConfigs;
    }

    private String getWeiXinConfigragtionByEnName(String enName, List<CfWeixinConfig> cfWeixinConfigs)
    {
        String value = null;
        for(CfWeixinConfig cfWeixinConfig: cfWeixinConfigs){
            if(cfWeixinConfig.getEnName().equals(enName)){
                value = cfWeixinConfig.getValue();
                break;
            }
        }
        if(value==null){
            ExceptionCast.cast(UcenterCode.WECHAT_CONFIGURATION_DOES_NOT_EXIST, "miss configragtion: "+enName);
        }
        return value;
    }

    @RequestMapping(value = "testWxin", method = RequestMethod.GET)
    public JSONObject testWxin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        return HttpClient.doGet(cfWeixinConfigService.returnGetIpUrl());
    }

    @Override
    @RequestMapping(value = "getUserAccount", method = RequestMethod.GET)
    public ResponseResult getUserAccount(CfAccountQuery cfAccountQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfAccountQuery.setUid(userBasicInfo.getId());
        List<CfAccount> cfAccounts = cfAccountService.getListByQuery(cfAccountQuery);
        if(cfAccounts==null || cfAccounts.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfAccounts);
    }

    private Map<String, String> getAllRequestParam(final HttpServletRequest request) throws Exception {
        String sb = getHttpData(request);
        Map res = (JSONObject.parseObject(sb));
        if(res==null){
            res = new HashMap();
        }
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp && temp.hasMoreElements()) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
            }
        }
        return res;
    }

    private String getHttpData(HttpServletRequest httpServletRequest) throws Exception {
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
}
