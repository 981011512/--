package com.cf.chat.dao.repository;


import com.cf.chat.domain.CfUserMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CfUserMessageRepository extends MongoRepository<CfUserMessage,String> {

    /**
     * 根据接收者和状态查询聊天记录
     * @param to_uid
     * @param status
     * @param pageable
     * @return
     */
    List<CfUserMessage> queryCfUserMessagesByToUidEqualsAndStatusEquals(String to_uid, Integer status, Pageable pageable);

    /**
     * 根据接收者和类型查询聊天记录
     * @param to_uid
     * @param type
     * @param pageable
     * @return
     */
    List<CfUserMessage> queryCfUserMessagesByToUidEqualsAndTypeEquals(String to_uid, Integer type, Pageable pageable);
}
