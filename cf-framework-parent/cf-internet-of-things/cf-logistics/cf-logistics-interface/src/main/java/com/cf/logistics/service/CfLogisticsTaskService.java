package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsTask;
import com.cf.logistics.domain.CfLogisticsTaskExample;
import com.cf.logistics.domain.request.CfLogisticsTaskQuery;

import java.util.List;

public interface CfLogisticsTaskService {

    CfLogisticsTask add(CfLogisticsTask cfLogisticsTask) throws Exception;

    /**
     * 自动预约，添加任务时，传入的司机相关信息，会自动一键帮对应司机预约对应的物流货物装卸任务
     * @param cfLogisticsTask
     */
    void automaticReservationData(CfLogisticsTask cfLogisticsTask) throws Exception;

    CfLogisticsTask update(CfLogisticsTask cfLogisticsTask);

    int updateByQuery(CfLogisticsTask cfLogisticsTask, CfLogisticsTaskQuery cfLogisticsTaskQuery);

    /**
     * 更新子任务数
     * @param cfLogisticsTask
     * @return
     */
    int updateChildrenTaskCounts(CfLogisticsTask cfLogisticsTask);

    int delete(Long id);

    int deleteByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery);

    CfLogisticsTask findById(Long id);

    CfLogisticsTask findById(Long id, boolean expectEmpy);

    List<CfLogisticsTask> getListByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery);

    /**
     * 获取query条件查询任务，会联表查询仓库
     * @param cfLogisticsTaskQuery
     * @return
     */
    List<CfLogisticsTask> selectListByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery);

    Integer countByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery);

    CfLogisticsTaskExample getExampleByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery);

    /**
     * 更新已经预约车辆数
     * @param id
     * @param value
     * @return
     */
    Integer updateReservedVehicles(Long id, short value);

    /**
     * 切换任务排序顺序，只能切换排队和排队前的数据
     * @param taskId
     * @param sortIndex
     */
    void changeSortIndex(Long taskId, Integer sortIndex) throws Exception;
    
}
