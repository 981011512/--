package com.cf.carpark.service.websocket.service;

import com.cf.carpark.service.core.cache.IServerListCache;
import com.cf.carpark.service.core.dto.ClientDTO;
import com.cf.carpark.service.core.enums.ServerTypeEnum;
import com.cf.carpark.service.core.server.IServer;
import com.cf.carpark.service.core.service.IWebsocketDataService;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;


/**
 * @author gebilaowang
 * @date 2021/3/25 16:23
 */
@Slf4j
@Service
public class WebSocketMqttDataServiceImplMatt implements IWebsocketDataService {

    @Override
    public void push(String userOnlyCode, String message) {
    }

    @Override
    public void pushTopic(Channel channel, String message, String topic) throws Exception {
        try{
            IServerListCache.getServer(ServerTypeEnum.MQTT).send(channel, topic,message, 0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void pushTopicAll(String message,String... topics ) throws Exception {
        for (String topic: topics) {
            IServerListCache.getServer(ServerTypeEnum.MQTT).sendAll(topic,message);
        }
    }

    @Override
    public void pushAll(String message) {

    }


    @Override
    public String inputListening(Channel channel, String topic, String inputMessage) {
        log.info("ws来货啦+====》{}",inputMessage);
        IServer iServer = IServerListCache.SERVER_LIST_MAP.get(ServerTypeEnum.WS.TYPE);
        Collection<ClientDTO> clientAllList = iServer.getClientAllList();
        if (!CollectionUtils.isEmpty(clientAllList)) {
            for (ClientDTO clientDTO : clientAllList) {
                Channel channel1 = clientDTO.getChannel();
                channel1.writeAndFlush(new TextWebSocketFrame(inputMessage));
            }
        }
//        channel.writeAndFlush(new TextWebSocketFrame(inputMessage));
        return inputMessage;
    }
}
