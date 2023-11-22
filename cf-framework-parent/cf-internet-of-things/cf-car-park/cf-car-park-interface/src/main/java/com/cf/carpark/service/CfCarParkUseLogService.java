package com.cf.carpark.service;

import com.cf.carpark.device.camera.HuaXia.HuaXiaResponse;
import com.cf.carpark.device.camera.ZhenShiResponse911202002050;
import com.cf.carpark.device.led.PlayRule;
import com.cf.carpark.domain.CfCarParkDevice;
import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.domain.CfCarParkUseLogExample;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.carpark.domain.request.CfCountCarParkUseLogQuery;
import com.cf.carpark.domain.request.CountPayAmountByDutyQuery;
import com.cf.framework.domain.report.CountByDay;
import com.cf.pay.domain.CfOrder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 停车记录管理
 *
 * @ClassName CfCarParkUseLogService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 15:26
 * @Version 1.0
 **/
public interface CfCarParkUseLogService {

    /**
     * 添加停车记录
     * @param cfCarParkUseLog
     * @return
     */
    public CfCarParkUseLog add(CfCarParkUseLog cfCarParkUseLog);

    /**
     * 删除
     * @param id
     * @return
     */
    public Integer delete(String id);

    /**
     * 批量删除
     * @param cfCarParkUseLogQuery
     * @return
     */
    public Integer deleteByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    /**
     * 禁止重复数据添加
     * @param cfCarParkUseLog
     */
    public CfCarParkUseLog forbidRepeatLog(CfCarParkUseLog cfCarParkUseLog);

    /**
     * 根据条件获取数据
     * @param cfCarParkUseLogQuery
     * @return
     */
    public List<CfCarParkUseLog> getListByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    public Integer getCountByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    Integer countByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    /**
     * 根据传入的query条件查询(本操作不会走内置的criteria操作)，order by 条件必须后端控制，否则存在SQL注入
     * @param cfCarParkUseLogQuery
     * @return
     */
    public List<CfCarParkUseLog> selectByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    /**
     * 根据传入的query条件查询(含订单数据)(本操作不会走内置的criteria操作)，order by 条件必须后端控制，否则存在SQL注入
     * @param cfCarParkUseLogQuery
     * @return
     */
    public List<CfCarParkUseLog> selectByQueryContainOrder(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    public CfCarParkUseLogExample getExampleByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    /**
     * 更新
     * @param cfCarParkUseLog
     * @return
     */
    public CfCarParkUseLog update(CfCarParkUseLog cfCarParkUseLog);

    /**
     * 只更新不为空的字段
     * @param cfCarParkUseLog
     * @return
     */
    public CfCarParkUseLog updateByPrimaryKeySelective(CfCarParkUseLog cfCarParkUseLog);

    /**
     * 根据id获取一条停车记录
     * @param id
     * @return
     */
    public CfCarParkUseLog findById(String id);

    /**
     * 根据id获取一条停车记录
     * @param id
     * @param expectEmpty
     * @return
     */
    public CfCarParkUseLog findById(String id, Boolean expectEmpty);

    /**
     * 判断是否为臻识相机
     * @param carLogMap
     * @return
     */
    public CfCarParkUseLog checkIsZhenShi911202002050(Map carLogMap) throws Exception;

    /**
     * 处理华夏相机数据
     * @param carLogMap
     * @return
     */
    CfCarParkUseLog checkIsHuaXia(Map carLogMap) throws Exception;

    /**
     * 硬件数据转为停车记录
     * @param carLogMap
     * @return
     * @throws Exception
     */
    CfCarParkUseLog deviceDataToCarParkUseLog(Map carLogMap) throws Exception;

    /**
     * 上传车牌图片
     * @param base64
     * @param decoderType
     * @return
     */
    public String uploadNumberPlateImage(String base64, String decoderType) throws Exception;

    /**
     * 解析停车场记录表单数据
     * @param carLogMap
     * @return
     */
    public Object parseCarParkUseLogForm(Map carLogMap) throws Exception;

    /**
     * 处理臻识和千熠相机开关闸
     * @param zhenShiResponse911202002050
     * @param value
     */
    public void setCameraOpenOrClose(ZhenShiResponse911202002050 zhenShiResponse911202002050, String value);

    /**
     * 处理华夏相机开关闸
     * @param huaXiaResponse
     * @param value
     */
    public void setCameraOpenOrClose(HuaXiaResponse huaXiaResponse, String value);

    /**
     * 处理相机数据和返回相关命令
     * @param cfCarParkUseLog
     * @param carLogMap
     * @param cameraBrand
     * @return
     * @throws Exception
     */
    Object handleCameraData(CfCarParkUseLog cfCarParkUseLog, Map carLogMap, String cameraBrand) throws Exception;

    /**
     * 根据显示屏的行号控制内容显示
     * @param playRule
     * @param cfCarParkDevice
     * @param scenes
     * @return
     */
    PlayRule showByDeviceRows(PlayRule playRule, CfCarParkDevice cfCarParkDevice, String scenes) throws Exception;

    /**
     * 给值班人员推送消息
     * @param cfCarParkUseLog
     * @param dutyUid
     * @param messageType
     * @throws Exception
     */
    void sendMessage(CfCarParkUseLog cfCarParkUseLog, String dutyUid, Integer messageType) throws Exception;

    /**
     * 给LCD屏幕推送消息
     * @param toUid
     * @param messageType
     * @param contents
     * @throws Exception
     */
    void sendLcdMessage(String toUid, Integer messageType, String contents) throws Exception;

    /**
     * 根据硬件推送的数据处理停车记录数据
     * @param cfCarParkUseLog   解析后得到的停车记录实体数据
     * @param cfCarParkDevice  硬件设备数据
     * @param inOrOutTime 进出场时间
     * @param smallImage 小图
     * @param bigImage 大图
     * @return
     */
    public CfCarParkUseLog handleUseLogByDevicePushData(CfCarParkUseLog cfCarParkUseLog,
     CfCarParkDevice cfCarParkDevice, Long inOrOutTime, String smallImage, String bigImage);

    /**
     * 检查是否存在进行中的停车预定
     * @param cfCarParkUseLog
     * @return
     */
    public CfCarParkUseLog checkExistsSubscribeLog(CfCarParkUseLog cfCarParkUseLog);

    /**
     * 生成基础订单
     * @param cfCarParkUseLog
     * @return
     */
    public CfOrder makeCfOrderData(CfCarParkUseLog cfCarParkUseLog);

    /**
     * 支付成功后，推送硬件显示和播报消息
     * @param cfCarParkUseLog
     */
    PlayRule paySuccessfulPushDeviceMessage(CfCarParkUseLog cfCarParkUseLog) throws Exception;

    /**
     * 根据条件查询停车记录数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfCarParkUseLog> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) throws Exception;

    /**
     * 根据条件查询停车记录数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 申请通行
     * @param uid
     * @param direction
     * @param checkPointId
     * @param type
     * @param deviceNo
     * @return
     */
    public CfCarParkUseLog applyForAccess(String uid, String direction, String checkPointId, byte type, String deviceNo) throws Exception;

    /**
     * 放行临时车辆
     * @param cfCarParkUseLog
     * @param direction
     * @param type
     */
    public void releaseTemporaryCar(CfCarParkUseLog cfCarParkUseLog, String direction, byte type) throws Exception;

    /**
     * 车位预订
     * @param cfCarParkUseLog
     * @param payTypeId
     * @param ip
     * @return
     */
    public CfCarParkOrder subscribeParkingSpace(CfCarParkUseLog cfCarParkUseLog, String payTypeId, String ip) throws Exception;

    /**
     * 统计前N天每天的停车记录数(支持传入地区或停车场)
     * @param cfCountCarParkUseLogQuery
     * @return
     */
    public List<CountByDay> limitDaysCountByDay(CfCountCarParkUseLogQuery cfCountCarParkUseLogQuery);

    /**
     * 获取某个年份某个月数的停车数(支持传入地区或停车场)
     * @param cfCountCarParkUseLogQuery
     * @return
     */
    public List<CountByDay> yearMonthCountByDay(CfCountCarParkUseLogQuery cfCountCarParkUseLogQuery);

    /**
     * 获取某个年份每个月份的停车数
     * @param cfCountCarParkUseLogQuery
     * @return
     */
    public List<CountByDay> yearCountByMonth(CfCountCarParkUseLogQuery cfCountCarParkUseLogQuery);

    /**
     * 统计岗亭值班人员一段时间内各渠道收费情况
     * @param countPayAmountByDutyQuery
     * @return
     */
    BigDecimal countPayAmountByDuty(CountPayAmountByDutyQuery countPayAmountByDutyQuery);

    /**
     * 人工主动上报停车记录(断电断网  人工手机一键快捷补录停车数据)
     * @param numberPlateImage
     * @param originalFilename
     * @param carParkCheckPointId
     * @param timeStamp
     * @param uid
     * @param platform
     * @return
     */
    CfCarParkOrder manuallyUpload(byte[] numberPlateImage, String originalFilename, String carParkCheckPointId, Long timeStamp, String uid, String platform) throws Exception;

    /**
     * 统计某个字段
     * @param cfCarParkUseLogQuery
     * @return
     */
    Long countByField(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    /**
     * 上传停车数据到 深圳 绿景智慧建造平台
     * @param cfCarParkUseLog
     * @param config 第三方平台账号
     */
    void lVGEMSmartConstructionPlatform(CfCarParkUseLog cfCarParkUseLog, Map<String, String> config) throws Exception;

    /**
     * 上传停车数据到 上海市公共停车信息平台
     * @param cfCarParkUseLog
     * @param config 第三方平台账号
     */
    void ShanghaiPublicParkingInformationPlatform(CfCarParkUseLog cfCarParkUseLog, Map<String, String> config) throws Exception;
}
