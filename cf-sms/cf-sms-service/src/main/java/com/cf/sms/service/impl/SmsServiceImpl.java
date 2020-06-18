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
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.sms.dao.mapper.CfSmsMapper;
import com.cf.sms.domain.CfSms;
import com.cf.sms.service.SmsService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName SmsServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/25/025 22:50
 * @Version 1.0
 **/
@Service(version = "1.0.0")
public class SmsServiceImpl implements SmsService {

    @Autowired
    private CfSmsMapper cfSmsMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public ResponseResult sendSms(String phone, Integer type) {
        checkSendFrequently(phone, type);
        String code = (int)((Math.random()*9+1)*100000)+"";
        cfSmsMapper.insert(new CfSms(idWorker.nextId(),phone,code,type,0,System.currentTimeMillis(),
                System.currentTimeMillis()+CfSms.SMS_CODE_VALID_TIME));
        sendSmsByAli("",phone,"这填写您的短信签名","这填写您的短信模板id",
                "{\"code\":\""+code+"\"}","","");
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @Override
    public void checkSendFrequently(String phone, Integer type) {
        List<CfSms> lastSendLog = cfSmsMapper.getLastSendLog(phone, type);
        if(lastSendLog!=null && lastSendLog.size()>0 && lastSendLog.get(0).getCreateTime()+CfSms.SMS_SEND_FREQUENTLY_LIMIT_TIME>System.currentTimeMillis()){
            ExceptionCast.cast(SmsCode.SMS_SEND_FREQUENTLY);
        }
    }

    @Override
    public void sendSmsByAli(String RegionId, String PhoneNumbers, String SignName, String TemplateCode, String TemplateParam, String SmsUpExtendCode, String OutId) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "这填写您的key", "这添加您的密钥");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        if(StringUtils.isNotEmpty(RegionId)){
            request.putQueryParameter("RegionId", "cn-hangzhou");
        }
        if(StringUtils.isNotEmpty(PhoneNumbers)){
            request.putQueryParameter("PhoneNumbers", PhoneNumbers);
        }
        if(StringUtils.isNotEmpty(SignName)){
            request.putQueryParameter("SignName", SignName);
        }
        if(StringUtils.isNotEmpty(TemplateCode)){
            request.putQueryParameter("TemplateCode", TemplateCode);
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
            System.out.println("阿里云短信发送失败"+e.getMessage());
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("阿里云短信发送失败"+e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void checkCode(String phone, String code, Integer type) {
        int i = cfSmsMapper.updateLastValidSmsCodeStatus(phone, code, type, System.currentTimeMillis() - CfSms.SMS_CODE_VALID_TIME);
        if(i==0){
            ExceptionCast.cast(SmsCode.SMS_CODE_INVALID);
        }
    }
}
