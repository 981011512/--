package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfUserIdCard;
import com.cf.ucenter.domain.CfUserIdCardExample;
import com.cf.ucenter.request.CfUserIdCardQuery;

import java.util.List;

public interface CfUserIdCardService {

    CfUserIdCard add(CfUserIdCard cfUserIdCard);

    CfUserIdCard update(CfUserIdCard cfUserIdCard);

    Integer delete(Long id);

    CfUserIdCard findById(Long id);

    CfUserIdCard findById(Long id, boolean expectEmpty);

    List<CfUserIdCard> getListByQuery(CfUserIdCardQuery cfUserIdCardQuery);

    Integer countByQuery(CfUserIdCardQuery cfUserIdCardQuery);

    /**
     * 通过证件号排查该证件是否已经被绑定过
     * @param cfUserIdCard
     */
    void checkRepeatByLicenseNumber(CfUserIdCard cfUserIdCard);

    CfUserIdCardExample getExampleByQuery(CfUserIdCardQuery cfUserIdCardQuery);
}
