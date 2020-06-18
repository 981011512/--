package com.cf.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cf_chat_group_message")
public class CfUserGroupMessage implements Serializable {
    @Id
    private String id;
    private String uid;
    private String groupId;
    private String messageId;
    private Integer status; //状态(0-未读/1-已读/2-已撤回)
    private Long createTime;
}
