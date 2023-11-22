package com.cf.carpark.service.core.cache;

import com.cf.carpark.service.core.dto.ClientDTO;
import io.netty.channel.Channel;

import java.util.List;
import java.util.Map;

/**
 * 主题缓存
 * @author gebilaowang
 * @date 2021/3/11 10:41
 */
public interface ITopicCache {
    // 主题总数量
    int count();
    // 添加主题
    void add(Channel channel, String topic, String message);
    // 删除主题
    void remove(Channel channel,String topic,String message);
    // 提取主题内所有客户端
    Map<String, List<ClientDTO>> get(String topic);
}
