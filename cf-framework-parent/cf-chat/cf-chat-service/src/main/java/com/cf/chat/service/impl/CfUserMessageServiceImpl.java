package com.cf.chat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cf.chat.dao.repository.CfUserMessageRepository;
import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.domain.Message;
import com.cf.chat.netty.ChatHandler;
import com.cf.chat.netty.UserChannelMap;
import com.cf.chat.service.CfUserGroupMessageService;
import com.cf.chat.service.CfUserMessageService;
import com.cf.framework.domain.message.response.MessageCode;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.service.CfWeixinConfigService;
import com.mongodb.client.result.UpdateResult;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserMessageServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/15/015 18:39
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfUserMessageServiceImpl implements CfUserMessageService, ApplicationContextAware {
    private String collectionName = "cf_chat_message";

    @Autowired
    private CfUserMessageRepository cfUserMessageRepository;
    @Autowired
    MongoTemplate template;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfUserGroupMessageService cfUserGroupMessageService;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeixinConfigService cfWeixinConfigService;

    public static ApplicationContext applicationContext;

    @Override
    public void recoredUserServerIp(String serverLoaclIp, String uid) throws Exception {
        //将设备在线设备ip记录到redis中去
        redisTemplate.boundValueOps(CfUserMessage.USER_SERVER_IP+uid).set(serverLoaclIp);
        redisTemplate.expire(CfUserMessage.USER_SERVER_IP+uid,86400, TimeUnit.SECONDS);
    }

    @Override
    public CfUserMessage sendMessage(CfUserMessage _cfUserMessage) throws Exception {
        _cfUserMessage.setId(idWorker.nextId());
        _cfUserMessage.setCreateTime(System.currentTimeMillis());
        _cfUserMessage.setReceiveTime(0L);
        _cfUserMessage.setStatus(0);
//        CfUserMessage cfUserMessage = cfUserMessageRepository.insert(_cfUserMessage);
        if(StringUtils.isNotEmpty(_cfUserMessage.getGroupId())){
            cfUserGroupMessageService.sendGroupMessageByChannel(_cfUserMessage);
        }else{
            sendMessageByChannel(_cfUserMessage);
        }
//        sendMessageResultByChannel(_cfUserMessage);
        return _cfUserMessage;
    }

    @Override
    public CfUserMessage addMessageToMongondb(CfUserMessage _cfUserMessage) throws Exception {
        _cfUserMessage.setId(idWorker.nextId());
        _cfUserMessage.setCreateTime(System.currentTimeMillis());
        _cfUserMessage.setReceiveTime(0L);
        _cfUserMessage.setStatus(0);
        return cfUserMessageRepository.insert(_cfUserMessage);
    }

    @Override
    public void sendMessageByChannel(CfUserMessage cfUserMessage) throws Exception {
        Channel channel = UserChannelMap.get(cfUserMessage.getToUid());
        Message message = new Message();
        message.setType("chat_message");
        message.setCfUserMessage(cfUserMessage);
        if(channel != null) {
            //用户本机在线，实时发送
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(message)));
        }else{
            //用户离线或者不在同一服务区，从redis中找该用户
            String userLinkIp = redisTemplate.boundValueOps(CfUserMessage.USER_SERVER_IP+cfUserMessage.getToUid()).get();
            if(StringUtils.isEmpty(userLinkIp)){
                //说明目标用户未上过线
                return;
            }
            if(InetAddress.getLocalHost().getHostAddress().equals(userLinkIp)){
                //说明目标用户的确已经掉线，不在任何服务器中连接，将其从redis中剔除
                redisTemplate.delete(CfUserMessage.USER_SERVER_IP+cfUserMessage.getToUid());
                return;
            }
            //rpc远程调用消息推送服务
            String url = "dubbo://"+userLinkIp+":20883/com.cf.chat.service.CfUserMessageService?version=1.0.0";//更改不同的Dubbo服务暴露的ip地址&端口
            ReferenceBean<CfUserMessageService> referenceBean = new ReferenceBean<CfUserMessageService>();
            referenceBean.setApplicationContext(applicationContext);
            referenceBean.setInterface(CfUserMessageService.class);
            referenceBean.setUrl(url);
            referenceBean.afterPropertiesSet();
            CfUserMessageService cfUserMessageService = referenceBean.get();
            cfUserMessageService.sendMessageByChannel(cfUserMessage);
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
        }else{

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
    public List<CfUserMessage> selectNotReadMessageListByToUid(String uid, Integer page, Integer limit) {
        Sort sort = new Sort(Sort.Direction.ASC, "create_time");
        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        return cfUserMessageRepository.queryCfUserMessagesByToUidEqualsAndStatusEquals(uid, 0, pageable);
    }

    @Override
    public List<CfUserMessage> selectMessageListByToUidAndType(String uid, Integer type, Integer page, Integer limit) {
        Sort sort = new Sort(Sort.Direction.ASC, "create_time");
        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        return cfUserMessageRepository.queryCfUserMessagesByToUidEqualsAndTypeEquals(uid, type, pageable);
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
    public UserBasicInfo getBaseUserInfoByToken(String token)throws Exception {
        if(StringUtils.isEmpty(token)){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_ILLEGAL);
        }
        return authenticationInterceptor.parseJwt(token);
    }

    @Override
    public void getNotReadMessage(String uid) throws Exception {
        List<CfUserMessage> cfUserMessages = null;
        int page = 1;
        while (true){
            cfUserMessages = selectNotReadMessageListByToUid(uid, page, 30);
            page++;
            if(cfUserMessages!=null && cfUserMessages.size()>0){
                cfUserMessages.forEach(
                        item-> {
                            try {
                                sendMessageByChannel(item);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );
//                batchUpdateStatusByIds(cfUserMessages);
            }else{
                break;
            }
        }
    }

    @Override
    public void getRedisNotReadMessage(String uid) {
        while (true){
            //检查redis是否有临时离线消息
            String messageString = redisTemplate.opsForSet().pop("user_message_" + uid);
            if(StringUtils.isNotEmpty(messageString)){
                try{
                    Message message = JSON.parseObject(messageString, Message.class);
                    sendMessageByChannel(message.getCfUserMessage());
                } catch (Exception e){
                    System.out.println("解析消息体出错:"+messageString);
                    e.printStackTrace();
                }
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

    @Override
    public String getMinChatLinkCountsServiceIp() {
        Set<String> range = redisTemplate.boundZSetOps(ChatHandler.CHAT_LINK_COUNTS_REDIS_KEY).range(0l, 0l);

        //如果数据为空，进行ip组数据初始化
        if(range==null || range.size()==0){
            //获取配置
            List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("server_ip_list");
            CfWeixinConfig cfWeixinConfig = cfWeixinConfigs.get(0);
            Map<String, Integer> map = (Map<String, Integer>)JSONObject.parseObject(cfWeixinConfig.getValue(), Map.class);
            String ip = null;
            for (Map.Entry<String, Integer> entry:map.entrySet()){
                redisTemplate.boundZSetOps(ChatHandler.CHAT_LINK_COUNTS_REDIS_KEY).add(entry.getKey(), 0);
                ip = entry.getKey();
            }
            return ip;
        }else{
            List<String> strings = new ArrayList<>(range);
            return strings.get(0);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext _applicationContext) throws BeansException {
        applicationContext = _applicationContext;
    }
}
