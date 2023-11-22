package com.cf.sms.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.sms.response.SmsCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.IdWorker;
import com.cf.sms.dao.mapper.CfSmsMapper;
import com.cf.sms.domain.CfSms;
import com.cf.sms.service.SmsService;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.service.CfWeixinConfigService;
import com.cf.ucenter.wxtools.WeiXinConfigUtils;
import com.tencentcloudapi.captcha.v20190722.CaptchaClient;
import com.tencentcloudapi.captcha.v20190722.models.DescribeCaptchaMiniResultRequest;
import com.tencentcloudapi.captcha.v20190722.models.DescribeCaptchaMiniResultResponse;
import com.tencentcloudapi.captcha.v20190722.models.DescribeCaptchaResultRequest;
import com.tencentcloudapi.captcha.v20190722.models.DescribeCaptchaResultResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 请在此填写描述
 *
 * @ClassName SmsServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/25/025 22:50
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
public class SmsServiceImpl implements SmsService {

    @Autowired
    private CfSmsMapper cfSmsMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeixinConfigService cfWeixinConfigService;

    @Override
    public void sendSms(String phone, Integer type) {
        checkSendFrequently(phone, type);
        String code = (int)((Math.random()*9+1)*100000)+"";
        cfSmsMapper.insert(new CfSms(idWorker.nextId(),phone,code,type,0,System.currentTimeMillis(),
                System.currentTimeMillis()+CfSms.SMS_CODE_VALID_TIME));

        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("ali_sms");
        String signName = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("sign_name", cfWeixinConfigs);
        String templateCode = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("template_code", cfWeixinConfigs);
        String regionId = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("region_id", cfWeixinConfigs);
        String accessKeyId = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("access_key_id", cfWeixinConfigs);
        String secret = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("secret", cfWeixinConfigs);

        sendSmsByAli(phone,"{\"code\":\""+code+"\"}",signName,templateCode,regionId,accessKeyId,secret,"","");
    }

    @Override
    public void checkSendFrequently(String phone, Integer type) {
        List<CfSms> lastSendLog = cfSmsMapper.getLastSendLog(phone, type);
        if(lastSendLog!=null && lastSendLog.size()>0 && lastSendLog.get(0).getCreateTime()+CfSms.SMS_SEND_FREQUENTLY_LIMIT_TIME>System.currentTimeMillis()){
            ExceptionCast.cast(SmsCode.SMS_SEND_FREQUENTLY);
        }
    }

    @Override
    public void sendSmsByAli(String PhoneNumbers, String TemplateParam, String signName, String templateCode, String regionId, String accessKeyId, String secret, String SmsUpExtendCode, String OutId) {

        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, secret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        if(StringUtils.isNotEmpty(PhoneNumbers)){
            request.putQueryParameter("PhoneNumbers", PhoneNumbers);
        }
        if(StringUtils.isNotEmpty(signName)){
            request.putQueryParameter("SignName", signName);
        }
        if(StringUtils.isNotEmpty(templateCode)){
            request.putQueryParameter("TemplateCode", templateCode);
        }
        if(StringUtils.isNotEmpty(TemplateParam)){
            request.putQueryParameter("TemplateParam", TemplateParam);
        }
        if(StringUtils.isNotEmpty(SmsUpExtendCode)){
            request.putQueryParameter("SmsUpExtendCode", SmsUpExtendCode);
        }
        if(StringUtils.isNotEmpty(OutId)){
            request.putQueryParameter("OutId", OutId);
        }

        try {
            CommonResponse response = client.getCommonResponse(request);
        } catch (ServerException e) {
            ExceptionCast.cast(CommonCode.FAIL, e.getMessage());
        } catch (ClientException e) {
            ExceptionCast.cast(CommonCode.FAIL, e.getMessage());
        }
    }

    @Override
    public void checkCode(String phone, String code, Integer type) {
        String phoneSmsCheckCounts = null;
        String redisKey = phone+"_"+type;
        try {
            phoneSmsCheckCounts = stringRedisTemplate.opsForValue().get(redisKey);
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionCast.cast(CommonCode.SERVER_ERROR, e.getMessage());
        }
        if(phoneSmsCheckCounts!=null && Integer.parseInt(phoneSmsCheckCounts)>=5){
            ExceptionCast.cast(SmsCode.CHECKING_TOO_FREQUENTLY);
        }

        int i = cfSmsMapper.updateLastValidSmsCodeStatus(phone, code, type, System.currentTimeMillis());
        if(i==0){
            if(phoneSmsCheckCounts!=null){
                Long expire = stringRedisTemplate.getExpire(phone, TimeUnit.MILLISECONDS);
                Long time = expire>0?expire:300000L;
                stringRedisTemplate.boundValueOps(redisKey).set((Integer.parseInt(phoneSmsCheckCounts)+1)+"",time, TimeUnit.MILLISECONDS);
            }else{
                stringRedisTemplate.boundValueOps(redisKey).set("1",300000L, TimeUnit.MILLISECONDS);
            }
            ExceptionCast.cast(SmsCode.SMS_CODE_INVALID);
        }
        stringRedisTemplate.delete(redisKey);
    }

    @Override
    public void checkTencentMpCaptcha(String ip, String ticket, String platform, String randstr) throws Exception {

        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("tencent_captcha");
        String secretId = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("secret_id", cfWeixinConfigs);
        String secretKey = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("secret_key", cfWeixinConfigs);
        String captchaAppId = WeiXinConfigUtils.getWeiXinConfigragtionByEnName(platform+"_captcha_app_id", cfWeixinConfigs);
        String appSecretKey = WeiXinConfigUtils.getWeiXinConfigragtionByEnName(platform+"_app_secret_key", cfWeixinConfigs);


        //验证码腾讯图形验证码
        Credential cred = new Credential(secretId, secretKey);

        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("captcha.tencentcloudapi.com");

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        CaptchaClient client = new CaptchaClient(cred, "", clientProfile);

        if(StringUtils.isNotEmpty(randstr)){
            DescribeCaptchaResultRequest describeCaptchaResultRequest = new DescribeCaptchaResultRequest();
            describeCaptchaResultRequest.setCaptchaType(9L);
            describeCaptchaResultRequest.setTicket(ticket);
            describeCaptchaResultRequest.setUserIp(ip);
            describeCaptchaResultRequest.setCaptchaAppId(new Long(captchaAppId));
            describeCaptchaResultRequest.setAppSecretKey(appSecretKey);
            describeCaptchaResultRequest.setRandstr(randstr);
            DescribeCaptchaResultResponse describeCaptchaResultResponse = client.DescribeCaptchaResult(describeCaptchaResultRequest);
            if(describeCaptchaResultResponse.getCaptchaCode()!=1){
                ExceptionCast.cast(UcenterCode.CAPTCHA_NOT_MATCH);
            }
        }else{
            DescribeCaptchaMiniResultRequest req = new DescribeCaptchaMiniResultRequest();
            req.setCaptchaType(9L);
            req.setTicket(ticket);
            req.setUserIp(ip);
            req.setCaptchaAppId(new Long(captchaAppId));
            req.setAppSecretKey(appSecretKey);
            DescribeCaptchaMiniResultResponse resp = client.DescribeCaptchaMiniResult(req);
            if(resp.getCaptchaCode()!=1){
                ExceptionCast.cast(UcenterCode.CAPTCHA_NOT_MATCH);
            }
        }

//        String s = DescribeCaptchaResultResponse.toJsonString(resp);

    }
}
