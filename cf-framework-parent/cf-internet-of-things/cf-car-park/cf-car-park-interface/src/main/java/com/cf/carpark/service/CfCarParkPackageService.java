package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkPackage;
import com.cf.carpark.domain.CfCarParkPackageExample;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;

import java.util.List;
import java.util.Map;

/**
 * 车场套餐服务
 *
 * @ClassName CfCarParkPackageService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/23/023 18:58
 * @Version 1.0
 **/
public interface CfCarParkPackageService {

    public CfCarParkPackage add(CfCarParkPackage cfCarParkPackage);

    public CfCarParkPackage artificialAdd(CfCarParkPackage cfCarParkPackage, String handleUid) throws Exception;

    public CfCarParkPackage update(CfCarParkPackage cfCarParkPackage);

    /**
     * 纯更新不做任何其它业务操作
     * @param cfCarParkPackage
     * @return
     */
    public CfCarParkPackage onlyUpdate(CfCarParkPackage cfCarParkPackage);

    public CfCarParkPackage artificialUpdate(CfCarParkPackage cfCarParkPackage, String handleUid) throws Exception;

    void handleParentId(CfCarParkPackage cfCarParkPackage);

    /**
     * 如果没有提供用户id，只提供手机号，自动关联对应的用户
     * @param cfCarParkPackage
     * @return
     */
    CfCarParkPackage handleUidByPhone(CfCarParkPackage cfCarParkPackage);

    CfCarParkPackageExample getExampleByQuery(CfCarParkPackageQuery cfCarParkPackageQuery);

    List<CfCarParkPackage> getListByQuery(CfCarParkPackageQuery cfCarParkPackageQuery);

    List<CfCarParkPackage> selectByQuery(CfCarParkPackageQuery cfCarParkPackageQuery);

    List<CfCarParkPackage> getListByQueryContainCarParkName(CfCarParkPackageQuery cfCarParkPackageQuery);

    /**
     * 根据条件批量更新
     * @param cfCarParkPackageQuery
     * @param cfCarParkPackage
     * @return
     */
    Integer updateByQuery(CfCarParkPackageQuery cfCarParkPackageQuery, CfCarParkPackage cfCarParkPackage);

    Integer delete(String id) throws Exception;

    Integer deleteByQuery(CfCarParkPackageQuery cfCarParkPackageQuery) throws Exception;

    /**
     * 获取根据条件匹配的数据条数
     * @param cfCarParkPackageQuery
     * @return
     */
    public Integer countsByQuery(CfCarParkPackageQuery cfCarParkPackageQuery);

    public CfCarParkPackage findById(String id);

    public CfCarParkPackage findById(String id, boolean expectEmpty);

    /**
     * 存在则更新，否则添加
     * @param cfCarParkPackage
     * @return
     */
    public CfCarParkPackage addOrUpdate(CfCarParkPackage cfCarParkPackage);

    /**
     * 根据条件查询车场套餐数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfCarParkPackage> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询车场套餐数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 判断某个车牌号在指定停车场套餐是否有效
     * @param numberPlate
     * @param carParkId
     * @param uid
     * @return
     */
    public CfCarParkPackage checkPackeEffectiveness(String numberPlate, String carParkId, String uid);

    /**
     * 根据query条件更新
     * @param cfCarParkPackage
     * @param cfCarParkPackageQuery
     * @return
     */
    Integer updateByQuery(CfCarParkPackage cfCarParkPackage, CfCarParkPackageQuery cfCarParkPackageQuery);

    /**
     * 根据手机号批量绑定用户
     * @param uid
     * @param phone
     * @return
     */
    Integer batchBindUserByPhone(String uid, String phone);

    /**
     * 更新家庭组套餐起止时间
     * @param cfCarParkPackage
     * @return
     */
    Integer updateGroupFlagTime(CfCarParkPackage cfCarParkPackage);

    /**
     * 同步车牌套餐到相机设备
     * @param operateType 0-添加白名单/1-删除白名单
     * @param cfCarParkPackages
     * @throws Exception
     */
    void synchronizePackageDataToDevice(byte operateType, List<CfCarParkPackage> cfCarParkPackages) throws Exception;

}
