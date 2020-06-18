package com.cf.chat.service;

import com.cf.chat.domain.CfUserGroupMessage;
import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.domain.CfUserMessageVo;

import java.util.List;

public interface CfUserGroupMessageService {
    /**
     * 获取指定用用户未读群消息(支持分页获取)
     * @param uid
     * @param page
     * @param limit
     * @return
     */
    public List<CfUserGroupMessage> selectNotReadGroupMessageListByToUid(String uid, Integer page, Integer limit);

    /**
     * 将群消息发送给群成员(除了发送者自己)
     * @param cfUserMessage
     */
    public void sendGroupMessageByChannel(CfUserMessage cfUserMessage);

    /**
     * 根据id串批量更新数据状态
     * @param cfUserGroupMessages
     */
    public void batchUpdateStatusByIds(List<CfUserGroupMessage> cfUserGroupMessages);

    /**
     * 获取离线消息
     *
     * @param uid
     */
    public void getNotReadMessage(String uid);
}
