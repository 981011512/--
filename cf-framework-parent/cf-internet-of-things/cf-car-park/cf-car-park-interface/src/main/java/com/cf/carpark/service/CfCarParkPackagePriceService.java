package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkPackagePrice;
import com.cf.carpark.domain.CfCarParkPackagePriceExample;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.CfCarParkPackagePriceQuery;
import com.cf.pay.domain.response.ResultMap;

import java.util.List;
import java.util.Map;

/**
 * 停车套餐价格管理服务
 *
 * @ClassName CfCarParkPackagePriceService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/28/028 7:05
 * @Version 1.0
 **/
public interface CfCarParkPackagePriceService {

    public CfCarParkPackagePrice add(CfCarParkPackagePrice cfCarParkPackagePrice);

    public CfCarParkPackagePrice update(CfCarParkPackagePrice cfCarParkPackagePrice);

    public Integer delete(String id);

    public Integer deleteByQuery(CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery);

    public List<CfCarParkPackagePrice> getListByQuery(CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery);

    public CfCarParkPackagePriceExample getExampleByQuery(CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery);

    /**
     * 购买停车套餐
     * @param cfCarParkPackagePriceId
     * @param uid
     * @param payTypeId
     * @param numberPlate
     * @param ip
     * @return
     */
    public ResultMap buyCfCarParkPackage(String cfCarParkPackagePriceId, String uid, String payTypeId, String numberPlate, String ip) throws Exception;

    /**
     * 续费套餐时查询该车辆是否存在临停费追缴
     * @param cfCarParkPackagePrice
     * @param uid
     * @param numberPlate
     * @return
     * @throws Exception
     */
    CfCarParkOrder queryCfCarParkPackageRecoverFee(CfCarParkPackagePrice cfCarParkPackagePrice, String uid, String numberPlate) throws Exception;

    public CfCarParkPackagePrice findById(String id);

    public CfCarParkPackagePrice findById(String id, boolean expectEmpty);

    /**
     * 根据条件查询车辆套餐数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfCarParkPackagePrice> selectPackagePriceListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询车辆套餐数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectPackagePriceListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据id获取详情(返回包含名字)
     * @param id
     * @return
     */
    CfCarParkPackagePrice findByIdContainName(String id);

}
