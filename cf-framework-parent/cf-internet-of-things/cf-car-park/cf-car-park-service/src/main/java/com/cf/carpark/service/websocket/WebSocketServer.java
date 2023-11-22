package com.cf.carpark.service.websocket;

import com.cf.carpark.service.core.cache.IServerListCache;
import com.cf.carpark.service.core.dto.ClientDTO;
import com.cf.carpark.service.core.dto.InitParamDTO;
import com.cf.carpark.service.core.enums.ServerRunStatusEnum;
import com.cf.carpark.service.core.enums.ServerTypeEnum;
import com.cf.carpark.service.core.server.AbsServer;
import com.cf.carpark.service.core.server.IServer;
import com.cf.carpark.service.websocket.handler.WebSocketFrameHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;

/**
 * WS服务
 * @author gebilaowang
 * @date 2021/3/25 15:53
 */
@Slf4j
public class WebSocketServer extends AbsServer {
    @Override
    public IServer run() {
        EventLoopGroup boosGroup = new NioEventLoopGroup(initParamDTO.getBoosTread());
        EventLoopGroup workGroup = new NioEventLoopGroup(initParamDTO.getWorkTread());
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            InitParamDTO initParamDTO = this.initParamDTO;
            serverBootstrap.group(boosGroup, workGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();

                            pipeline.addLast(new HttpServerCodec());
                            pipeline.addLast(new ChunkedWriteHandler());

                            pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));

                            pipeline.addLast(new HttpObjectAggregator(1024 * 1024));
                            pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
                            pipeline.addLast(new WebSocketFrameHandler(initParamDTO));
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(this.initParamDTO.getPort()))
                    .addListener(future -> {
                     log.info("服务端成功绑定端口号={}", this.initParamDTO.getPort());
                    });
        }catch (Exception e){
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
            log.error("websocketServer启动失败:{}",e);
        }
        // 将已启动的服务添加到 服务列表，便于以后管理使用
        IServerListCache.SERVER_LIST_MAP.put(ServerTypeEnum.WS.TYPE,this);
        return this;
    }

    @Override
    public ServerRunStatusEnum status() {
        return null;
    }

    @Override
    public void sendByFlageKey(String flageKey, String topic, String sendMessage) {

    }

    @Override
    public void sendAll(String topic, String sendMessage) {

    }

    @Override
    public void sendAllWithoutTopic(String sendMessage) {

    }

    @Override
    public Collection<ClientDTO> getClientAllList() {
        return initParamDTO.getClientCache().getAllList();
    }

    @Override
    public List<ClientDTO> getClientListByTopic(String... topic) {
        return null;
    }

    public WebSocketServer(InitParamDTO initParamDTO) {
        this.initParamDTO = initParamDTO;
    }

    public WebSocketServer() {
    }

    @Override
    public ChannelFuture send(Channel channel, String topic, String sendMessage, Integer packetId) throws InterruptedException {
        return null;
    }
}
