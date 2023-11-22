package com.cf.position.service;

import com.cf.position.domain.CfAreas;

import java.util.List;

/**
 * 地区管理
 *
 * @ClassName CfAreasService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/25/025 8:19
 * @Version 1.0
 **/
public interface CfAreasService {

    /**
     * 获取所有地区数据
     * @param recursive 是否递归查询
     * @return
     */
    public List<CfAreas> selectAll(Boolean recursive);

    /**
     * 根据层级和父级id查询
     * @param level
     * @param parentId
     * @param maxLevel
     * @param loop
     * @return
     */
    public List<CfAreas> selectByLevelAndParentId(Integer level, String parentId, Integer maxLevel, boolean loop);

}
