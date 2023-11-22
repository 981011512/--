package com.cf.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2020/1/24 10:04.
 * @Modified By:
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cf_chat_message")
public class CfUserMessage implements Serializable {

    public static final String USER_SERVER_IP = "user_server_ip_";

    /**
     * 页面名称、别名、访问地址、类型（静态/动态）、页面模版、状态
     */
    @Id
    private String id;
    private String fromUid;
    private String toUid;
    private String groupId;
    private Integer status;
    private String contents;
    private Integer type;   //0-普通聊天/1-停车记录消息/2-硬件掉线通知/3-LCD广告屏消息/4-订单支付成功通知/5-充电通知/6-车辆无入场记录时推送可能停车记录/7-物流消息通知
    private String client;
    private String ip;
    private Long createTime;
    private Long receiveTime;



}
