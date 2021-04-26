package com.cf.chat.service.impl;

import com.alibaba.fastjson.JSON;
import com.cf.chat.dao.repository.CfUserGroupMessageRepository;
import com.cf.chat.domain.CfUserGroupMessage;
import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.domain.CfUserMessageVo;
import com.cf.chat.domain.Message;
import com.cf.chat.netty.UserChannelMap;
import com.cf.chat.service.CfUserGroupMessageService;
import com.cf.chat.service.CfUserMessageService;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.domain.CfUserGroupMember;
import com.cf.ucenter.service.CfUserGroupService;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0.0")
@Transactional
public class CfUserGroupMessageServiceImpl implements CfUserGroupMessageService {
    @Autowired
    private CfUserGroupMessageRepository cfUserGroupMessageRepository;
    @Autowired
    private CfUserMessageService cfUserMessageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private CfUserGroupService cfUserGroupService;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<CfUserGroupMessage> selectNotReadGroupMessageListByToUid(String uid, Integer page, Integer limit) {
        Sort sort = new Sort(Sort.Direction.ASC, "create_time");
        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        return cfUserGroupMessageRepository.queryCfUserGroupMessagesByUidEqualsAndStatusEquals(uid, 0, pageable);
    }

    @Override
    public void sendGroupMessageByChannel(CfUserMessage cfUserMessage) {
        List<CfUserGroupMember> cfUserGroupMembers = cfUserGroupService.getUserGroupMemberByGroupId(cfUserMessage.getGroupId());
        if(cfUserGroupMembers!=null && cfUserGroupMembers.size()>0){
            for (CfUserGroupMember cfUserGroupMember: cfUserGroupMembers){
                cfUserMessage.setToUid(cfUserGroupMember.getUid());
                if(cfUserGroupMember.getUid().equals(cfUserMessage.getFromUid())){
                    continue;   //跳过发送者自己
                }
                Channel channel = UserChannelMap.get(cfUserGroupMember.getUid());
                if(channel != null) {
                    //直接发送，对方直接接收
                    Message message = new Message();
                    message.setType("chat_message");
                    message.setCfUserMessage(cfUserMessage);
                    channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(message)));
                }else{
                    //记录群成员的离线消息
                    cfUserGroupMessageRepository.insert(new CfUserGroupMessage(idWorker.nextId(),cfUserGroupMember.getUid(),
                        cfUserMessage.getGroupId(),cfUserMessage.getId(),0,System.currentTimeMillis()));
                }
            }
        }
    }

    @Override
    public void batchUpdateStatusByIds(List<CfUserGroupMessage> cfUserGroupMessages) {
        Update update = new Update();
        update.set("status",1);
        Query query = new Query();
        List<String> list = new ArrayList<>();
        cfUserGroupMessages.forEach(item->list.add(item.getId()));
        query.addCriteria(Criteria.where("_id").in(list));
        mongoTemplate.updateMulti(query,update,CfUserGroupMessage.class);
    }

    @Override
    public void getNotReadMessage(String uid) {
        List<CfUserGroupMessage> cfUserGroupMessages = null;
        while (true) {
            cfUserGroupMessages = selectNotReadGroupMessageListByToUid(uid, 1, 30);
            if (cfUserGroupMessages != null && cfUserGroupMessages.size() > 0) {
                List<String> ids = new ArrayList<>();
                Integer index = 0;
                String[] idArr = new String[cfUserGroupMessages.size()];
                for (CfUserGroupMessage cfUserGroupMessage : cfUserGroupMessages) {
                    idArr[index] = cfUserGroupMessage.getMessageId();
                    index++;
                }
                List<CfUserMessage> cfUserMessages = cfUserMessageService.selectListByIds(idArr);
                if (cfUserMessages != null && cfUserMessages.size() > 0) {
                    for (CfUserMessage cfUserMessage : cfUserMessages) {
                        cfUserMessage.setToUid(uid);
                        cfUserMessageService.sendMessageByChannel(cfUserMessage);
                    }
                }
                batchUpdateStatusByIds(cfUserGroupMessages);
            } else {
                break;
            }
        }

    }
}
