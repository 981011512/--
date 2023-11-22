package com.cf.ucenter.service;


import com.cf.ucenter.domain.CfSystemConfig;
import com.cf.ucenter.domain.CfSystemConfigExample;
import com.cf.ucenter.request.CfSystemConfigQuery;

import java.util.List;

/**
 * 系统配置管理
 *
 * @ClassName CfSystemConfigService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2021/4/6/006 15:15
 * @Version 1.0
 **/
public interface CfSystemConfigService {

    CfSystemConfig add(CfSystemConfig cfSystemConfig);

    CfSystemConfig update(CfSystemConfig cfSystemConfig);

    Integer delete(String enName);

    CfSystemConfigExample getExampleByQuery(CfSystemConfigQuery cfSystemConfigQuery);

    List<CfSystemConfig> getListByQuery(CfSystemConfigQuery cfSystemConfigQuery);

    Integer countByQuery(CfSystemConfigQuery cfSystemConfigQuery);

    String getValueByKey(String configKey, String defaultValue);


}
