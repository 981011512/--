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
 * @Date:Created in 2018/1/24 10:04.
 * @Modified By:
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cf_chat_message")
public class CfUserMessage implements Serializable {
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
    private Integer type;
    private String client;
    private String ip;
    private Long createTime;
    private Long receiveTime;



}
