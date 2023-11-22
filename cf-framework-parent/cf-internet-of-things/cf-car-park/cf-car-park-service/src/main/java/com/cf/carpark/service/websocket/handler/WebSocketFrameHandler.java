package com.cf.carpark.service.websocket.handler;

import com.cf.carpark.service.core.dto.InitParamDTO;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;


/**
 * @author gebilaowang
 * @date 2021/3/25 16:21
 */
@Slf4j
public class WebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private InitParamDTO initParamDTO;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String s = initParamDTO.getDataService().inputListening(ctx.channel(), null, msg.text(), 0);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        initParamDTO.getClientCache().add(ctx.channel(),null);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        initParamDTO.getClientCache().remove(ctx.channel());
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (ctx.channel().isActive()) {
            initParamDTO.getClientCache().remove(ctx.channel());
            ctx.close();
        }
    }

    public WebSocketFrameHandler(InitParamDTO initParamDTO) {
        this.initParamDTO = initParamDTO;
    }

    public WebSocketFrameHandler() {
    }
}
