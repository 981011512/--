package com.cf.logistics.service.socket;

import com.cf.chat.domain.DeviceMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtobufHandler extends SimpleChannelInboundHandler<DeviceMessage.HeartbeatRequest> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DeviceMessage.HeartbeatRequest heartbeatRequest) throws Exception {
        String deviceId = heartbeatRequest.getDeviceId();
        System.out.println("接收到设备ID:"+deviceId);
    }
}
