package com.cf.logistics.service.socket;

import com.cf.framework.utils.SpringUtil;
import com.cf.logistics.service.CfLogisticsLedDeviceService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 处理消息的handler
 * TextWebSocketFrame: 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 */
public class SocketHandler extends ByteToMessageDecoder {

    // 用来保存所有的客户端连接
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    CfLogisticsLedDeviceService cfLogisticsLedDeviceService = SpringUtil.getBean(CfLogisticsLedDeviceService.class);

    // 当Channel中有新的事件消息会自动调用
    @Autowired
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            cfLogisticsLedDeviceService.handleLink(ctx, msg);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
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
        cause.printStackTrace();
        DeviceChannelMap.removeByChannelId(ctx.channel().id().asLongText());
        clients.remove(ctx.channel());
    }

    @Override
    public void handlerRemoved0(ChannelHandlerContext ctx) throws Exception {
        System.out.println("关闭Socket通道");
        DeviceChannelMap.removeByChannelId(ctx.channel().id().asLongText());
        clients.remove(ctx.channel());
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if(byteBuf.readableBytes() > 8){
            list.add(byteBuf.readLong());
        }
    }
}