package com.cf.chat.service;

import com.cf.chat.domain.CfUserMessage;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;

import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserMessageService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/15/015 12:44
 * @Version 1.0
 **/
public interface CfUserMessageService {

    /**
     * 记录用户ip
     * @param serverLoaclIp
     * @param uid
     */
    void recoredUserServerIp(String serverLoaclIp, String uid) throws Exception;

    /**
     * 发送用户消息
     * @param cfUserMessage
     * @return
     */
    public CfUserMessage sendMessage(CfUserMessage cfUserMessage) throws Exception;

    /**
     * 插入消息数据到mongodb中
     * @param cfUserMessage
     * @return
     */
    public CfUserMessage addMessageToMongondb(CfUserMessage cfUserMessage) throws Exception;

    /**
     * 给通道塞入消息
     * @param cfUserMessage
     */
    public void sendMessageByChannel(CfUserMessage cfUserMessage) throws Exception;

    /**
     * 通知发送者消息发送结果
     *
     * @param cfUserMessage
     */
    public void sendMessageResultByChannel(CfUserMessage cfUserMessage);

    /**
     * 改变消息状态
     * @param uid
     * @param messageId
     * @param status
     * @return
     */
    public Long updateStatus(String uid, String messageId, Integer status);

    /**
     * 获取指定用户未读消息(支持分页获取)
     * @param uid
     * @param page
     * @param limit
     * @return
     */
    public List<CfUserMessage> selectNotReadMessageListByToUid(String uid, Integer page, Integer limit);

    /**
     * 获取指定用户消息(支持分页获取)
     * @param uid
     * @param type
     * @param page
     * @param limit
     * @return
     */
    public List<CfUserMessage> selectMessageListByToUidAndType(String uid, Integer type, Integer page, Integer limit);

    /**
     * 根据消息id组查询消息数据
     * @param ids
     * @return
     */
    public List<CfUserMessage> selectListByIds(String[] ids);

    /**
     * 根据token获取用户基本信息
     * @param token
     * @return
     */
    public UserBasicInfo getBaseUserInfoByToken(String token)throws Exception;

    /**
     * 获取离线消息
     * @param uid
     */
    public void getNotReadMessage(String uid) throws Exception;

    /**
     * 获取redis离线消息
     * @param uid
     */
    void getRedisNotReadMessage(String uid);

    /**
     * 批量更新消息状态
     * @param cfUserMessages
     */
    void batchUpdateStatusByIds(List<CfUserMessage> cfUserMessages);

    /**
     * 获取即时通讯在线人数最少的服务器ip
     * @return
     */
    String getMinChatLinkCountsServiceIp();
}
