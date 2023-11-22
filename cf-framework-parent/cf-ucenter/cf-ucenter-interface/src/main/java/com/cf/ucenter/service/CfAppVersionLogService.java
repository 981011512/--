package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfAppVersionLog;
import com.cf.ucenter.domain.CfAppVersionLogExample;
import com.cf.ucenter.request.CfAppVersionLogQuery;

import java.util.List;

/**
 * app版本发行记录服务
 *
 * @ClassName CfAppVersionLogService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/11/011 23:06
 * @Version 1.0
 **/
public interface CfAppVersionLogService {

    /**
     * 版本检查
     * @param platform 应用平台(操作系统)
     * @param versionNumber 需传入自己当前正在使用的版本号
     * @return
     */
    CfAppVersionLog checkVersion(String platform, String versionNumber);

    CfAppVersionLog add(CfAppVersionLog cfAppVersionLog);

    CfAppVersionLog update(CfAppVersionLog cfAppVersionLog);

    Integer delete(String id);

    /**
     * 根据query查询实体条件获取数据列表
     * @param cfAppVersionLogQuery
     * @return
     */
    List<CfAppVersionLog> getListByQuery(CfAppVersionLogQuery cfAppVersionLogQuery);

    /**
     * 根据query查询实体条件获数据条目数
     * @param cfAppVersionLogQuery
     * @return
     */
    Integer countByQuery(CfAppVersionLogQuery cfAppVersionLogQuery);

    /**
     * 根据query实体获取mybatis的Example
     * @param cfAppVersionLogQuery
     * @return
     */
    CfAppVersionLogExample getExampleByQuery(CfAppVersionLogQuery cfAppVersionLogQuery);

}
