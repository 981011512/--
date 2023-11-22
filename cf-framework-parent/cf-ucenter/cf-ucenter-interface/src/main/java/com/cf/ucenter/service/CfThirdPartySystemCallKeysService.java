package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfThirdPartySystemCallKeys;
import com.cf.ucenter.domain.CfThirdPartySystemCallKeysExample;
import com.cf.ucenter.request.CfThirdPartySystemCallKeysQuery;

import java.util.List;

public interface CfThirdPartySystemCallKeysService {

    CfThirdPartySystemCallKeys add(CfThirdPartySystemCallKeys cfThirdPartySystemCallKeys);

    CfThirdPartySystemCallKeys update(CfThirdPartySystemCallKeys cfThirdPartySystemCallKeys);

    Integer delete(Long id);

    CfThirdPartySystemCallKeys findById(Long id);

    CfThirdPartySystemCallKeys findById(Long id, boolean expectEmpty);

    List<CfThirdPartySystemCallKeys> getListByQuery(CfThirdPartySystemCallKeysQuery cfThirdPartySystemCallKeysQuery);

    Integer countByQuery(CfThirdPartySystemCallKeysQuery cfThirdPartySystemCallKeysQuery);

    CfThirdPartySystemCallKeysExample getExampleByQuery(CfThirdPartySystemCallKeysQuery cfThirdPartySystemCallKeysQuery);
}
