package com.cf.chat.service.impl;

import com.alibaba.fastjson.JSON;
import com.cf.chat.dao.repository.CfUserMessageRepository;
import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.domain.Message;
import com.cf.chat.netty.UserChannelMap;
import com.cf.chat.service.CfUserGroupMessageService;
import com.cf.chat.service.CfUserMessageService;
import com.cf.framework.domain.message.response.MessageCode;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.service.AuthService;
import com.mongodb.client.result.UpdateResult;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Optional;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserMessageServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/15/015 18:39
 * @Version 1.0
 **/
@Service(version = "1.0.0")
@Transactional
public class CfUserMessageServiceImpl implements CfUserMessageService {
    private String collectionName = "cf_chat_message";

    @Autowired
    private CfUserMessageRepository cfUserMessageRepository;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private AuthService authService;
    @Autowired
    MongoTemplate template;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfUserGroupMessageService cfUserGroupMessageService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public CfUserMessage sendMessage(CfUserMessage _cfUserMessage) {
        _cfUserMessage.setId(idWorker.nextId());
        _cfUserMessage.setCreateTime(System.currentTimeMillis());
        _cfUserMessage.setReceiveTime(0L);
        _cfUserMessage.setStatus(0);
        CfUserMessage cfUserMessage = cfUserMessageRepository.insert(_cfUserMessage);
        if(StringUtils.isNotEmpty(cfUserMessage.getGroupId())){
            cfUserGroupMessageService.sendGroupMessageByChannel(cfUserMessage);
        }else{
            sendMessageByChannel(cfUserMessage);
        }
        sendMessageResultByChannel(cfUserMessage);
        return cfUserMessage;
    }

    @Override
    public void sendMessageByChannel(CfUserMessage cfUserMessage) {
        Channel channel = UserChannelMap.get(cfUserMessage.getToUid());
        if(channel != null) {
            Message message = new Message();
            message.setType("chat_message");
            message.setCfUserMessage(cfUserMessage);
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(message)));
        }
    }

    @Override
    public void sendMessageResultByChannel(CfUserMessage cfUserMessage) {
        Channel channel = UserChannelMap.get(cfUserMessage.getFromUid());
        if (channel != null) {
            Message message = new Message();
            message.setType("chat_message");
            message.setCfUserMessage(cfUserMessage);
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(message)));
        }
    }

    @Override
    public Long updateStatus(String uid, String messageId, Integer status) {
        Optional<CfUserMessage> optional = cfUserMessageRepository.findById(messageId);
        if(!optional.isPresent()){
            ExceptionCast.cast(MessageCode.MESSAGE_NOT_EXISTSNAME);
        }
        CfUserMessage cfUserMessage = optional.get();
        if(!cfUserMessage.getToUid().equals(uid)){
            ExceptionCast.cast(MessageCode.NO_AUTH_UPDATE_MESSAGE);
        }
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(messageId));
        Update update = new Update();
        update.set("status",status);
        UpdateResult updateResult = template.updateFirst(query, update, CfUserMessage.class);
        return updateResult.getModifiedCount();
    }

    @Override
    public String checkToken(String jwtString) {
        return authService.checkJwtToken(jwtString);
    }

    @Override
    public List<CfUserMessage> selectNotReadMessageListByToUid(String uid, Integer page, Integer limit) {
        Sort sort = new Sort(Sort.Direction.ASC, "create_time");
        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        return cfUserMessageRepository.queryCfUserMessagesByToUidEqualsAndStatusEquals(uid, 0, pageable);
    }

    @Override
    public List<CfUserMessage> selectListByIds(String[] ids) {
        Sort sort = new Sort(Sort.Direction.ASC, "create_time");
        Criteria criteria = new Criteria();
        criteria.and("id").in(ids);
        Query query = new Query(criteria);
        query.with(sort);
        return mongoTemplate.find(query, CfUserMessage.class);
    }

    @Override
    public UserBasicInfo getBaseUserInfoByToken(String token) {
        if(token==null || token==""){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_ILLEGAL);
        }
        String tokenStr = checkToken(token);
        return JSON.parseObject(tokenStr, UserBasicInfo.class);
    }

    @Override
    public void getNotReadMessage(String uid) {
        List<CfUserMessage> cfUserMessages = null;
        while (true){
            cfUserMessages = selectNotReadMessageListByToUid(uid, 1, 30);
            if(cfUserMessages!=null && cfUserMessages.size()>0){
                cfUserMessages.forEach(item->sendMessageByChannel(item));
                batchUpdateStatusByIds(cfUserMessages);
            }else{
                break;
            }
        }
    }

    @Override
    public void batchUpdateStatusByIds(List<CfUserMessage> cfUserMessages) {
        Update update = new Update();
        update.set("status",1);
        Query query = new Query();
        List<String> list = new ArrayList<>();
        cfUserMessages.forEach(item->list.add(item.getId()));
        query.addCriteria(Criteria.where("_id").in(list));
        template.updateMulti(query,update,CfUserMessage.class);
    }
}
