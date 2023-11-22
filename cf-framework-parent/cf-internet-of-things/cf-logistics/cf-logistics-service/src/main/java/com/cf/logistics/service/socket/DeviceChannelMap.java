package com.cf.logistics.service.socket;

import io.netty.channel.Channel;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 建立用户ID与通道的关联
 */
public class DeviceChannelMap {
    // 用户保存用户id与通道的Map对象
    private static Map<String, CfLogisticsLedClient> userChannelMap;

    static {
        userChannelMap = new HashMap<String, CfLogisticsLedClient>();
    }

    /**
     * 添加用户id与channel的关联
     * @param userid
     * @param cfChargingClient
     */
    public static void put(String userid, CfLogisticsLedClient cfChargingClient) {
        userChannelMap.put(userid, cfChargingClient);
    }

    /**
     * 根据用户id移除用户id与channel的关联
     * @param userid
     */
    public static void remove(String userid) {
        userChannelMap.remove(userid);
    }

    /**
     * 根据通道id移除用户与channel的关联
     * @param channelId 通道的id
     */
    public static void removeByChannelId(String channelId) {
        if(!StringUtils.isNotBlank(channelId)) {
            return;
        }

        for (String s : userChannelMap.keySet()) {
            Channel channel = userChannelMap.get(s).getChannel();
            if(channelId.equals(channel.id().asLongText())) {
                System.out.println("客户端连接断开,取消用户" + s + "与通道" + channelId + "的关联");
                if(channel.isActive()){
                    channel.close();
                }
                userChannelMap.remove(s);
                break;
            }
        }
    }

    /**
     * 根据好友id获取对应的通道
     * @param friendid 好友id
     * @return Netty通道
     */
    public static CfLogisticsLedClient get(String friendid) {
        return userChannelMap.get(friendid);
    }

    public static void printf(){
        for ( Map.Entry<String, CfLogisticsLedClient> entry: userChannelMap.entrySet()){
            System.out.println(entry.getKey()+"===>"+entry.getValue().toString());
        }
        if(userChannelMap.size()==0){
            System.out.println("当前没有任何设备接入");
        }
    }
}
