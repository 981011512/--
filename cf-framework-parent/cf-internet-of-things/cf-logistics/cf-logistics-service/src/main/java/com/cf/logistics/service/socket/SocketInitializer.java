package com.cf.logistics.service.socket;

import com.cf.chat.domain.DeviceMessage;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class SocketInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // ------------------
        // 用于支持Socket协议
        // ------------------

        // 二进制的编解码器
        pipeline.addLast(new SocketHandler());
        // 对写大数据流的支持
        pipeline.addLast(new ChunkedWriteHandler());
        // 添加对HTTP请求和响应的聚合器:只要使用Netty进行Http编程都需要使用
        // 对HttpMessage进行聚合，聚合成FullHttpRequest或者FullHttpResponse
        // 在netty编程中都会使用到Handler
        pipeline.addLast(new HttpObjectAggregator(1024 * 64));

//        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        // 添加Netty空闲超时检查的支持
        // 1. 读空闲超时（超过一定的时间会发送对应的事件消息）
        // 2. 写空闲超时
        // 3. 读写空闲超时
        pipeline.addLast(new IdleStateHandler(150, 150, 150));

        pipeline.addLast(new HearBeatHandler());
        // 添加自定义的handler
        //请求的解码
//        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        //解码封装成的目标类
        pipeline.addLast(new ProtobufDecoder(DeviceMessage.HeartbeatRequest.getDefaultInstance()));//ChannelInboundHandlerAdapter
        //响应的编码
//        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
//        pipeline.addLast(new ProtobufEncoder());//ChannelOutboundHandlerAdapter
        //自定义Handler
        pipeline.addLast(new ProtobufHandler());

    }
}
