package com.cf.chat.service;

import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.domain.CfUserMessageVo;
import com.cf.chat.domain.Message;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import io.netty.channel.Channel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserMessageService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/15/015 12:44
 * @Version 1.0
 **/
public interface CfUserMessageService {

    /**
     * 发送用户消息
     * @param cfUserMessage
     * @return
     */
    public CfUserMessage sendMessage(CfUserMessage cfUserMessage);

    /**
     * 给通道塞入消息
     * @param cfUserMessage
     */
    public void sendMessageByChannel(CfUserMessage cfUserMessage);

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
     * 检查token是否合法
     * @param jwtString
     * @return
     */
    public String checkToken(String jwtString);

    /**
     * 获取指定用的未读消息(支持分页获取)
     * @param uid
     * @param page
     * @param limit
     * @return
     */
    public List<CfUserMessage> selectNotReadMessageListByToUid(String uid, Integer page, Integer limit);

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
    public UserBasicInfo getBaseUserInfoByToken(String token);

    /**
     * 获取离线消息
     * @param uid
     */
    public void getNotReadMessage(String uid);

    /**
     * 批量更新消息状态
     * @param cfUserMessages
     */
    public void batchUpdateStatusByIds(List<CfUserMessage> cfUserMessages);
}
