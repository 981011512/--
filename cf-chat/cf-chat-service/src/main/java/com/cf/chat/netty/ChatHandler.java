package com.cf.chat.netty;

import com.alibaba.fastjson.JSON;
import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.domain.Message;
import com.cf.chat.service.CfUserGroupMessageService;
import com.cf.chat.service.CfUserMessageService;
import com.cf.framework.domain.message.response.MessageCode;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.SpringUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;

/**
 * 处理消息的handler
 * TextWebSocketFrame: 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // 用来保存所有的客户端连接
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM");

    // 当Channel中有新的事件消息会自动调用
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // 当接收到数据后会自动调用

        // 获取客户端发送过来的文本消息
        Message message = JSON.parseObject(msg.text(), Message.class);

        // 通过SpringUtil工具类获取Spring上下文容器
        CfUserMessageService cfUserMessageService = SpringUtil.getBean(CfUserMessageService.class);
        CfUserGroupMessageService cfUserGroupMessageService = SpringUtil.getBean(CfUserGroupMessageService.class);
        UserBasicInfo userBasicInfo = cfUserMessageService.getBaseUserInfoByToken(message.getToken());
        switch (message.getType()) {
            case "create_link":
                UserChannelMap.put(userBasicInfo.getId(), ctx.channel());
                UserChannelMap.print();
                Thread messageThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        cfUserMessageService.getNotReadMessage(userBasicInfo.getId());
                    }
                });
                messageThread.start();
                Thread groupMessageThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        cfUserGroupMessageService.getNotReadMessage(userBasicInfo.getId());
                    }
                });
                groupMessageThread.start();
                break;
            case "send_message":
                CfUserMessage _message = message.getCfUserMessage();
                _message.setFromUid(userBasicInfo.getId());
                SocketAddress socketAddress = ctx.channel().remoteAddress();
                String ip = socketAddress.toString();
                ip = ip.substring(1,ip.indexOf(":"));
                _message.setIp(ip);
                cfUserMessageService.sendMessage(_message);
                break;
            case "change_status":
                cfUserMessageService.updateStatus(userBasicInfo.getId(),
                        message.getCfUserMessage().getId(),1);
                break;
            case "heartbeat_check":
                break;
        }
    }

    // 当有新的客户端连接服务器之后，会自动调用这个方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 将新的通道加入到clients
        clients.add(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        UserChannelMap.removeByChannelId(ctx.channel().id().asLongText());
        ctx.channel().close();
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("关闭通道");
        UserChannelMap.removeByChannelId(ctx.channel().id().asLongText());
        UserChannelMap.print();
    }
}