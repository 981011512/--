package com.cf.chat.dao.repository;


import com.cf.chat.domain.CfUserMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CfUserMessageRepository extends MongoRepository<CfUserMessage,String> {

    List<CfUserMessage> queryCfUserMessagesByToUidEqualsAndStatusEquals(String to_uid, Integer status, Pageable pageable);
}
