package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfUserSource;
import com.cf.ucenter.domain.CfUserSourceExample;
import com.cf.ucenter.request.CfUserSourceQuery;

import java.util.List;
import java.util.Map;

/**
 * 用户资源放行管理
 */
public interface CfUserSourceService {

    /**
     * 添加用户资源权限
     * @param sourceId
     * @param sourceType
     * @param uidAndAuth 用户id和其对应的权限 Map<用户id, Map<是否能编辑，0/1>>
     * @param createrId
     * @return
     */
    List<CfUserSource> add(String sourceId, String sourceType, Map<String, Map<String, Byte>> uidAndAuth, String createrId);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Integer batchDelete(String ids);

    /**
     * 更新
     * @param cfUserSource
     * @return
     */
    CfUserSource update(CfUserSource cfUserSource);

    CfUserSourceExample getExampleByQuery(CfUserSourceQuery cfUserSourceQuery);

    /**
     * 根据query条件查询数据列表
     * @param cfUserSourceQuery
     * @return
     */
    List<CfUserSource> getListByQuery(CfUserSourceQuery cfUserSourceQuery);

    /**
     * 根据query统计数据条数
     * @param cfUserSourceQuery
     * @return
     */
    Integer countByQuery(CfUserSourceQuery cfUserSourceQuery);

}
