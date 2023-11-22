package com.cf.chat.netty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.domain.Message;
import com.cf.chat.service.CfUserGroupMessageService;
import com.cf.chat.service.CfUserMessageService;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.SpringUtil;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.service.CfWeixinConfigService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.net.InetAddress;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 处理消息的handler
 * TextWebSocketFrame: 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    public static String CHAT_LINK_COUNTS_REDIS_KEY = "chat_link_counts";

    // 用来保存所有的客户端连接
    public static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM");

    // 当Channel中有新的事件消息会自动调用
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // 当接收到数据后会自动调用

        // 获取客户端发送过来的文本消息
        Message message = JSON.parseObject(msg.text(), Message.class);

        // 通过SpringUtil工具类获取Spring上下文容器

//        CfUserGroupMessageService cfUserGroupMessageService = SpringUtil.getBean(CfUserGroupMessageService.class);


        switch (message.getType()) {
            case "create_link":
                CfUserMessageService cfUserMessageService = SpringUtil.getBean(CfUserMessageService.class);
                UserBasicInfo userBasicInfo = cfUserMessageService.getBaseUserInfoByToken(message.getToken());
                UserChannelMap.put(userBasicInfo.getId(), ctx.channel());
//                cfUserMessageService.getNotReadMessage(userBasicInfo.getId());
//                cfUserGroupMessageService.getNotReadMessage(userBasicInfo.getId());
                //将当前用户所在服务器本地ip记录到redis中去
                cfUserMessageService.recoredUserServerIp(InetAddress.getLocalHost().getHostAddress(), userBasicInfo.getId());
                break;
            case "send_message":
                cfUserMessageService = SpringUtil.getBean(CfUserMessageService.class);
                userBasicInfo = cfUserMessageService.getBaseUserInfoByToken(message.getToken());
                CfUserMessage _message = message.getCfUserMessage();
                _message.setFromUid(userBasicInfo.getId());
                SocketAddress socketAddress = ctx.channel().remoteAddress();
                String ip = socketAddress.toString();
                ip = ip.substring(1,ip.indexOf(":"));
                _message.setIp(ip);
                cfUserMessageService.sendMessage(_message);
                break;
            case "change_status":
                try {
//                    cfUserMessageService.updateStatus(userBasicInfo.getId(), message.getCfUserMessage().getId(),1);
                }catch (Exception e){
                    //mongodb会无端报错，但是不影响更新状态，后期检查
                }
                break;
            case "heartbeat_check":
                //检查redis是否有临时离线消息
//                cfUserMessageService.getRedisNotReadMessage(userBasicInfo.getId());
                break;
        }
    }

    // 当有新的客户端连接服务器之后，会自动调用这个方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 将新的通道加入到clients
        clients.add(ctx.channel());
        setChatLinkerCounts();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        UserChannelMap.removeByChannelId(ctx.channel().id().asLongText());
        ctx.channel().close();
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("关闭WebSocket通道");
        UserChannelMap.removeByChannelId(ctx.channel().id().asLongText());
        clients.remove(ctx.channel());
        if(ctx.channel().isActive()){
            ctx.channel().close();
        }
        setChatLinkerCounts();
//        UserChannelMap.print();
    }

    /**
     * 获取本服务器的外网ip
     * @return
     */
    private String getServiceIp() throws Exception {
        CfWeixinConfigService cfWeixinConfigService = SpringUtil.getBean(CfWeixinConfigService.class);
        JSONObject jsonObject = HttpClient.doGet(cfWeixinConfigService.returnGetIpUrl());

        //获取配置
        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("server_ip_list");
        CfWeixinConfig cfWeixinConfig = cfWeixinConfigs.get(0);
        Map<String, String> map = (Map<String, String>)JSONObject.parseObject(cfWeixinConfig.getValue(), Map.class);
        String ip = "";
        int i = 0;
        String defaultIp = "";
        for (Map.Entry<String, String> entry:map.entrySet()){
            if(i==0){
                defaultIp = entry.getKey();
            }
            i++;
            if(!map.containsKey(jsonObject.getString("data"))){
                break;
            }
            if(jsonObject.getString("data").equals(entry.getKey())){
                ip = entry.getKey();
                break;
            }
        }
        return ip.equals("") ? defaultIp : ip;
    }

    /**
     * 设置当前服务器的在线人数
     */
    private void setChatLinkerCounts() throws Exception{
        String serviceIp = getServiceIp();
        if(serviceIp==null){
            return;
        }
        // 通过SpringUtil工具类获取Spring上下文容器
        StringRedisTemplate redisTemplate = SpringUtil.getBean(StringRedisTemplate.class);
        System.out.println("当前在线人数:"+clients.size());
        redisTemplate.boundZSetOps(ChatHandler.CHAT_LINK_COUNTS_REDIS_KEY).add(serviceIp, clients.size());
    }


}