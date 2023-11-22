package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsStorehousePlatform;
import com.cf.logistics.domain.CfLogisticsTaskLog;
import com.cf.logistics.domain.CfLogisticsTaskLogExample;
import com.cf.logistics.domain.request.CfLogisticsTaskLogQuery;

import java.util.List;
import java.util.Map;

public interface CfLogisticsTaskLogService {

    CfLogisticsTaskLog add(CfLogisticsTaskLog cfLogisticsTaskLog);

    Integer update(CfLogisticsTaskLog cfLogisticsTaskLog);

    int updateByQuery(CfLogisticsTaskLog CfLogisticsTaskLog, CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery);

    int delete(Long id);

    int deleteByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery);

    CfLogisticsTaskLog findById(Long id);

    CfLogisticsTaskLog findById(Long id, boolean expectEmpy);

    List<CfLogisticsTaskLog> getListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery);

    /**
     * 获取query条件查询任务预约，会联表查询仓库
     * @param cfLogisticsTaskLogQuery
     * @return
     */
    List<CfLogisticsTaskLog> selectListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery);

    /**
     * 获取query条件查询任务预约，会联表查询驾驶证
     * @param cfLogisticsTaskLogQuery
     * @return
     */
    List<CfLogisticsTaskLog> selectDeliverListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery);

    Integer countByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery);

    CfLogisticsTaskLogExample getExampleByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery);

    /**
     * 检查用户的身份证和驾驶证是否已经上传并审核通过，如果正常会返回驾驶证和身份证数据
     * @param uid
     */
    Map<String, Object> checkUserDocumentsStatus(String uid) throws Exception;

    /**
     * 通过手机号检查用户的身份证和驾驶证是否已经上传并审核通过，如果正常会返回驾驶证和身份证数据
     * @param phone
     */
    Map<String, Object> checkUserDocumentsStatusByPhone(String phone) throws Exception;

    /**
     * 预约任务
     * @param uid
     * @param taskId
     * @param numberPlate
     * @param deliveryNoteCode
     * @param deliveryNoteImage
     * @return
     * @throws Exception
     */
    CfLogisticsTaskLog reserveTask(String uid, Long taskId, String numberPlate, String deliveryNoteCode, String deliveryNoteImage) throws Exception;

    /**
     * 取消预约
     * @param cfLogisticsTaskLog
     * @return
     * @throws Exception
     */
    CfLogisticsTaskLog cancelAppointment(CfLogisticsTaskLog cfLogisticsTaskLog) throws Exception;

    /**
     * 预约签到
     * @param uid
     * @param taskLogId
     * @return
     * @throws Exception
     */
    void reserveSignIn(String uid, Long taskLogId) throws Exception;

    /**
     * 通知车主排队
     * @param cfLogisticsTaskLog
     * @param numberOfQueuedVehicles
     */
    void noticeDriverQueue(CfLogisticsTaskLog cfLogisticsTaskLog, Integer numberOfQueuedVehicles) throws Exception;

    /**
     * 通知车主装卸货
     * @param cfLogisticsTaskLog
     */
    void noticeDriverLoadingOrUnloading(CfLogisticsTaskLog cfLogisticsTaskLog) throws Exception;

    /**
     * 确认核验预约记录
     * @param cfLogisticsTaskLog
     * @throws Exception
     */
    void cargoCheck(CfLogisticsTaskLog cfLogisticsTaskLog) throws Exception;

    /**
     * 通知司机排队或装卸货
     * @param cfLogisticsTaskLog
     * @param orderBy 排队  asc-插入到最前面，desc排到最后面
     * @throws Exception
     */
    public void noticeDirverQueueOrDriverLoadingOrUnloading(CfLogisticsTaskLog cfLogisticsTaskLog, String orderBy) throws Exception;

    /**
     * 根据预约找到合适的月台
     * @param cfLogisticsTaskLog
     * @return
     */
    List<CfLogisticsStorehousePlatform> getPlatformListByUseLog(CfLogisticsTaskLog cfLogisticsTaskLog);

    /**
     * 取消预约后通知司机
     * @param cfLogisticsTaskLog
     * @throws Exception
     */
    public void noticeDirverCancelAppointment(CfLogisticsTaskLog cfLogisticsTaskLog) throws Exception;

    /**
     * 排队过号后通知司机
     * @param cfLogisticsTaskLog
     * @throws Exception
     */
    public void noticeDirverNumberOver(CfLogisticsTaskLog cfLogisticsTaskLog) throws Exception;

    /**
     * 记录置顶
     * @param id 记录id
     */
    void logisticsTaskLogTop(Long id) throws Exception;

    /**
     * 更换排队区域
     * @param id 记录id
     * @param queuingAreaId 排队区域(队列)id，要换到哪个区域就传哪个区域的id
     */
    CfLogisticsTaskLog changeQueuingArea(Long id, Long queuingAreaId) throws Exception;

    /**
     * 过号处理
     * @param cfLogisticsTaskLog
     * @param wXinNotice    是否要进行微信服务通知
     * @throws Exception
     */
    void numberOver(CfLogisticsTaskLog cfLogisticsTaskLog, boolean wXinNotice) throws Exception;

    /**
     * 刷新led大屏数据
     * @param queuingAreaId
     */
    String flushLesScreenData(Long queuingAreaId) throws Exception;

}
