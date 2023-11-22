package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfThirdPartyPlatformApplication;
import com.cf.ucenter.domain.CfThirdPartyPlatformApplicationExample;
import com.cf.ucenter.request.CfThirdPartyPlatformApplicationQuery;

import java.util.List;

public interface CfThirdPartyPlatformApplicationService {

    CfThirdPartyPlatformApplication add(CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication);

    CfThirdPartyPlatformApplication update(CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication);

    Integer delete(String appid);

    CfThirdPartyPlatformApplication findByAppId(String appid);

    CfThirdPartyPlatformApplication findByAppId(String appid, boolean expectEmpy);

    List<CfThirdPartyPlatformApplication> getListByQuery(CfThirdPartyPlatformApplicationQuery cfThirdPartyPlatformApplicationQuery);

    Integer countByQuery(CfThirdPartyPlatformApplicationQuery cfThirdPartyPlatformApplicationQuery);

    CfThirdPartyPlatformApplicationExample getExampleByQuery(CfThirdPartyPlatformApplicationQuery cfThirdPartyPlatformApplicationQuery);
}
