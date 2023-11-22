package com.cf.chat.dao.repository;


import com.cf.chat.domain.CfUserGroupMessage;
import com.cf.chat.domain.CfUserMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CfUserGroupMessageRepository extends MongoRepository<CfUserGroupMessage,String> {

    List<CfUserGroupMessage> queryCfUserGroupMessagesByUidEqualsAndStatusEquals(String to_uid, Integer status, Pageable pageable);



}
