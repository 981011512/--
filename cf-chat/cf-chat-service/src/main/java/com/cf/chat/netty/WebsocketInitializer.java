package com.cf.chat.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class WebsocketInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // ------------------
        // 用于支持Http协议
        // ------------------

        // websocket基于http协议，需要有http的编解码器
        pipeline.addLast(new HttpServerCodec());
        // 对写大数据流的支持
        pipeline.addLast(new ChunkedWriteHandler());
        // 添加对HTTP请求和响应的聚合器:只要使用Netty进行Http编程都需要使用
        // 对HttpMessage进行聚合，聚合成FullHttpRequest或者FullHttpResponse
        // 在netty编程中都会使用到Handler
        pipeline.addLast(new HttpObjectAggregator(1024 * 64));

        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        // 添加Netty空闲超时检查的支持
        // 1. 读空闲超时（超过一定的时间会发送对应的事件消息）
        // 2. 写空闲超时
        // 3. 读写空闲超时
        pipeline.addLast(new IdleStateHandler(4, 8, 12));

        pipeline.addLast(new HearBeatHandler());
        // 添加自定义的handler
        pipeline.addLast(new ChatHandler());

    }
}
