package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarPark;
import com.cf.framework.domain.response.ResponseResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 停车场管理
 *
 * @ClassName CfCarParkService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/3/13/013 11:22
 * @Version 1.0
 **/
public interface CfCarParkService {

    /**
     * 添加停车场
     * @param cfCarPark
     * @return
     */
    public CfCarPark add(CfCarPark cfCarPark);

    /**
     * 删除停车场
     * @param id
     * @return
     */
    public Integer delete(String id);

    /**
     * 更新停车场信息
     * @param cfCarPark
     * @return
     */
    public CfCarPark update(CfCarPark cfCarPark);

    /**
     * 根据id获取一条停车场数据
     * @param id
     * @return
     */
    public CfCarPark findById(String id);

    /**
     * 根据条件查询停车场数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfCarPark> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);
    
    //这里只是提供了基础的停车场模块和功能，如果你想使用完整的，更高级，更专业的停车场系统商业源代码，请联系我们公司 微信 Dove981011512  谢谢！ 为千万级数据专业大系统而生

}
