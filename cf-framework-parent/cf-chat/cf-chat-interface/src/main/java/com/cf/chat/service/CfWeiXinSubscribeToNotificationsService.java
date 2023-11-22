package com.cf.chat.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 微信订阅消息通知服务
 */
public interface CfWeiXinSubscribeToNotificationsService {

    /**
     * 发送订阅消息
     * @param toUid
     * @param messageType
     * @param contents
     * @param appId
     */
    JSONObject sendMessage(String toUid, String messageType, Map<String, String> contents, String appId)throws Exception;

}
