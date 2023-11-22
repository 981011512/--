package com.cf.chat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.chat.service.CfWeiXinSubscribeToNotificationsService;
import com.cf.framework.domain.message.response.MessageCode;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.domain.weixin.WeiXinCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpClient;
import com.cf.ucenter.domain.CfSubscribeMessageTemplate;
import com.cf.ucenter.domain.CfThirdPartyLogin;
import com.cf.ucenter.domain.CfThirdPartyPlatformApplication;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.request.CfSubscribeMessageTemplateQuery;
import com.cf.ucenter.request.CfThirdPartyLoginQuery;
import com.cf.ucenter.service.*;
import com.cf.ucenter.type.CfWeiXinSubscribeToNotificationsType;
import com.cf.ucenter.type.ThirdPartyPlatformType;
import com.cf.ucenter.wxtools.WeiXinConfigUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfWeiXinSubscribeToNotificationsServiceImpl implements CfWeiXinSubscribeToNotificationsService {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeixinConfigService cfWeixinConfigService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfThirdPartyLoginService cfThirdPartyLoginService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAccessTokenManageService cfAccessTokenManageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfThirdPartyPlatformApplicationService cfThirdPartyPlatformApplicationService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfSubscribeMessageTemplateService cfSubscribeMessageTemplateService;

    @Override
    public JSONObject sendMessage(String toUid, String messageType, Map<String, String> contents, String appId)throws Exception {

        CfSubscribeMessageTemplateQuery cfSubscribeMessageTemplateQuery = new CfSubscribeMessageTemplateQuery();
        cfSubscribeMessageTemplateQuery.setAppid(appId);

        JSONObject body=new JSONObject();
        CfThirdPartyLoginQuery cfThirdPartyLoginQuery = new CfThirdPartyLoginQuery();
        cfThirdPartyLoginQuery.setUid(toUid);
        cfThirdPartyLoginQuery.setPlatform(ThirdPartyPlatformType.WX_MP);
        cfThirdPartyLoginQuery.setAppid(appId);
        List<CfThirdPartyLogin> cfThirdPartyLogins = cfThirdPartyLoginService.getListByQuery(cfThirdPartyLoginQuery);
        if(cfThirdPartyLogins==null || cfThirdPartyLogins.size()==0){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error","没有找到对应的小程序用户");
            return jsonObject;
        }
        body.put("touser",cfThirdPartyLogins.get(0).getOpenid());
        JSONObject json=new JSONObject();
        switch (messageType){
            case CfWeiXinSubscribeToNotificationsType.PAY_SUCCESSFUL:
                cfSubscribeMessageTemplateQuery.setMessageScenes(CfWeiXinSubscribeToNotificationsType.PAY_SUCCESSFUL);
                List<CfSubscribeMessageTemplate> cfSubscribeMessageTemplates = cfSubscribeMessageTemplateService.getListByQuery(cfSubscribeMessageTemplateQuery);
                if(cfSubscribeMessageTemplates==null || cfSubscribeMessageTemplates.size()==0){
                    ExceptionCast.cast(WeiXinCode.WECHAT_TEMPLATE_DOES_NOT_EXIST);
                }
                body.put("template_id",cfSubscribeMessageTemplates.get(0).getTemplateId());

                JSONObject itemJsonObject1 = new JSONObject();
                itemJsonObject1.put("value",contents.get("goods_name"));
                json.put("thing5",itemJsonObject1);

                JSONObject itemJsonObject2 = new JSONObject();
                itemJsonObject2.put("value",contents.get("amount"));
                json.put("amount2",itemJsonObject2);

                JSONObject itemJsonObject3 = new JSONObject();
                itemJsonObject3.put("value",contents.get("pay_time"));
                json.put("date3",itemJsonObject3);

                JSONObject itemJsonObject4 = new JSONObject();
                itemJsonObject4.put("value",contents.get("goods_counts"));
                json.put("thing6",itemJsonObject4);

                JSONObject itemJsonObject5 = new JSONObject();
                itemJsonObject5.put("value",contents.get("order_id"));
                json.put("character_string4",itemJsonObject5);
                break;
            case CfWeiXinSubscribeToNotificationsType.MONTHLY_CARD_EXPIRATION_NOTICE:
                cfSubscribeMessageTemplateQuery.setMessageScenes(CfWeiXinSubscribeToNotificationsType.MONTHLY_CARD_EXPIRATION_NOTICE);
                cfSubscribeMessageTemplates = cfSubscribeMessageTemplateService.getListByQuery(cfSubscribeMessageTemplateQuery);
                if(cfSubscribeMessageTemplates==null || cfSubscribeMessageTemplates.size()==0){
                    ExceptionCast.cast(WeiXinCode.WECHAT_TEMPLATE_DOES_NOT_EXIST);
                }
                body.put("template_id",cfSubscribeMessageTemplates.get(0).getTemplateId());

                itemJsonObject1 = new JSONObject();
                itemJsonObject1.put("value",contents.get("number_plate"));
                json.put("car_number1",itemJsonObject1);

                itemJsonObject2 = new JSONObject();
                itemJsonObject2.put("value",contents.get("car_park_name"));
                json.put("thing2",itemJsonObject2);

                itemJsonObject3 = new JSONObject();
                itemJsonObject3.put("value",contents.get("end_time"));
                json.put("time3",itemJsonObject3);

                itemJsonObject4 = new JSONObject();
                itemJsonObject4.put("value",contents.get("notice"));
                json.put("thing4",itemJsonObject4);
                break;
            case CfWeiXinSubscribeToNotificationsType.COUPON_NOTIFICATION:
                cfSubscribeMessageTemplateQuery.setMessageScenes(CfWeiXinSubscribeToNotificationsType.COUPON_NOTIFICATION);
                cfSubscribeMessageTemplates = cfSubscribeMessageTemplateService.getListByQuery(cfSubscribeMessageTemplateQuery);
                if(cfSubscribeMessageTemplates==null || cfSubscribeMessageTemplates.size()==0){
                    ExceptionCast.cast(WeiXinCode.WECHAT_TEMPLATE_DOES_NOT_EXIST);
                }
                body.put("template_id",cfSubscribeMessageTemplates.get(0).getTemplateId());

                itemJsonObject1 = new JSONObject();
                itemJsonObject1.put("value",contents.get("shop_name"));
                json.put("thing1",itemJsonObject1);

                itemJsonObject2 = new JSONObject();
                itemJsonObject2.put("value",contents.get("amount"));
                json.put("amount2",itemJsonObject2);

                itemJsonObject3 = new JSONObject();
                itemJsonObject3.put("value",contents.get("how_to_use"));
                json.put("thing3",itemJsonObject3);

                itemJsonObject4 = new JSONObject();
                itemJsonObject4.put("value",contents.get("start_time"));
                json.put("time4",itemJsonObject4);

                itemJsonObject5 = new JSONObject();
                itemJsonObject5.put("value",contents.get("end_time"));
                json.put("time5",itemJsonObject5);
                break;
            case CfWeiXinSubscribeToNotificationsType.LOGISTICS_LOADING_AND_UNLOADING:
                cfSubscribeMessageTemplateQuery.setMessageScenes(CfWeiXinSubscribeToNotificationsType.LOGISTICS_LOADING_AND_UNLOADING);
                cfSubscribeMessageTemplates = cfSubscribeMessageTemplateService.getListByQuery(cfSubscribeMessageTemplateQuery);
                if(cfSubscribeMessageTemplates==null || cfSubscribeMessageTemplates.size()==0){
                    ExceptionCast.cast(WeiXinCode.WECHAT_TEMPLATE_DOES_NOT_EXIST);
                }
                body.put("template_id",cfSubscribeMessageTemplates.get(0).getTemplateId());

                itemJsonObject1 = new JSONObject();
                itemJsonObject1.put("value",contents.get("queueIndex"));
                json.put("character_string1",itemJsonObject1);

                itemJsonObject2 = new JSONObject();
                itemJsonObject2.put("value","已叫号");
                json.put("phrase2",itemJsonObject2);

                itemJsonObject3 = new JSONObject();
                itemJsonObject3.put("value",contents.get("cfLogisticsStorehousePlatformName"));
                json.put("thing6",itemJsonObject3);

                itemJsonObject4 = new JSONObject();
                itemJsonObject4.put("value",contents.get("driverName"));
                json.put("thing8",itemJsonObject4);

                itemJsonObject5 = new JSONObject();
                itemJsonObject5.put("value",contents.get("numberPlate"));
                json.put("car_number10",itemJsonObject5);
                break;
            case CfWeiXinSubscribeToNotificationsType.LOGISTICS_QUEUE:
                cfSubscribeMessageTemplateQuery.setMessageScenes(CfWeiXinSubscribeToNotificationsType.LOGISTICS_QUEUE);
                cfSubscribeMessageTemplates = cfSubscribeMessageTemplateService.getListByQuery(cfSubscribeMessageTemplateQuery);
                if(cfSubscribeMessageTemplates==null || cfSubscribeMessageTemplates.size()==0){
                    ExceptionCast.cast(WeiXinCode.WECHAT_TEMPLATE_DOES_NOT_EXIST);
                }
                body.put("template_id",cfSubscribeMessageTemplates.get(0).getTemplateId());

                itemJsonObject1 = new JSONObject();
                itemJsonObject1.put("value",contents.get("number_of_queued_vehicles"));
                json.put("number1",itemJsonObject1);

                itemJsonObject2 = new JSONObject();
                itemJsonObject2.put("value",contents.get("notes"));
                json.put("thing2",itemJsonObject2);
                break;
            case CfWeiXinSubscribeToNotificationsType.LOGISTICS_NUMBER_OVER:
                cfSubscribeMessageTemplateQuery.setMessageScenes(CfWeiXinSubscribeToNotificationsType.LOGISTICS_NUMBER_OVER);
                cfSubscribeMessageTemplates = cfSubscribeMessageTemplateService.getListByQuery(cfSubscribeMessageTemplateQuery);
                if(cfSubscribeMessageTemplates==null || cfSubscribeMessageTemplates.size()==0){
                    ExceptionCast.cast(WeiXinCode.WECHAT_TEMPLATE_DOES_NOT_EXIST);
                }
                body.put("template_id",cfSubscribeMessageTemplates.get(0).getTemplateId());

                itemJsonObject1 = new JSONObject();
                itemJsonObject1.put("value",contents.get("numberPlate"));
                json.put("car_number1",itemJsonObject1);

                itemJsonObject2 = new JSONObject();
                itemJsonObject2.put("value","排队过号");
                json.put("phrase2",itemJsonObject2);

                itemJsonObject3 = new JSONObject();
                itemJsonObject3.put("value","超过截止时间，请重新排号");
                json.put("thing3",itemJsonObject3);
                break;
            case CfWeiXinSubscribeToNotificationsType.LOGISTICS_CANCEL_APPOINTMENT:
                cfSubscribeMessageTemplateQuery.setMessageScenes(CfWeiXinSubscribeToNotificationsType.LOGISTICS_CANCEL_APPOINTMENT);
                cfSubscribeMessageTemplates = cfSubscribeMessageTemplateService.getListByQuery(cfSubscribeMessageTemplateQuery);
                if(cfSubscribeMessageTemplates==null || cfSubscribeMessageTemplates.size()==0){
                    ExceptionCast.cast(WeiXinCode.WECHAT_TEMPLATE_DOES_NOT_EXIST);
                }
                body.put("template_id",cfSubscribeMessageTemplates.get(0).getTemplateId());

                itemJsonObject2 = new JSONObject();
                itemJsonObject2.put("value","已取消");
                json.put("phrase2",itemJsonObject2);

                itemJsonObject3 = new JSONObject();
                itemJsonObject3.put("value","因特殊原因取消预约");
                json.put("thing3",itemJsonObject3);

                itemJsonObject4 = new JSONObject();
                itemJsonObject4.put("value","请重新预约签到排队");
                json.put("thing4",itemJsonObject3);

                itemJsonObject5 = new JSONObject();
                itemJsonObject5.put("value",contents.get("numberPlate"));
                json.put("car_number5",itemJsonObject5);
                break;
            default:
                ExceptionCast.cast(MessageCode.ILLEGAL_TO_NOTIFICATIONS_MESSAGE_TYPE);
        }
        body.put("data",json);
        String accessToken = cfAccessTokenManageService.getWeiXinAccessToken(ThirdPartyPlatformType.WX_MP, appId);
        return (JSONObject)HttpClient.doPost(body, "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken, new HashMap<>(), true);
    }
}
