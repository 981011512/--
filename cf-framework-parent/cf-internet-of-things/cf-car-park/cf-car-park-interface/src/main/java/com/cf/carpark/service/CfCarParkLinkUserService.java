package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.CfCarParkLinkUserExample;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;

import java.util.List;

/**
 * 停车场管理员管理服务
 *
 * @ClassName CfCarParkLinkUserService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/28/028 7:05
 * @Version 1.0
 **/
public interface CfCarParkLinkUserService {

    CfCarParkLinkUser add(CfCarParkLinkUser cfCarParkLinkUser);

    Integer delete(String id);

    Integer deleteByQuery(CfCarParkLinkUserQuery cfCarParkLinkUserQuery);

    CfCarParkLinkUser update(CfCarParkLinkUser cfCarParkLinkUser);

    Integer updateByQuery(CfCarParkLinkUser cfCarParkLinkUser, CfCarParkLinkUserQuery cfCarParkLinkUserQuery);

    CfCarParkLinkUser findById(String id);

    CfCarParkLinkUser findById(String id, boolean expectEmpty);

    CfCarParkLinkUserExample getExampleByQuery(CfCarParkLinkUserQuery cfCarParkLinkUserQuery);

    List<CfCarParkLinkUser> getListByQuery(CfCarParkLinkUserQuery cfCarParkLinkUserQuery);

    List<CfCarParkLinkUser> selectByQueryLeftJoinUser(CfCarParkLinkUserQuery cfCarParkLinkUserQuery);

    Integer countByQuery(CfCarParkLinkUserQuery cfCarParkLinkUserQuery);

    /**
     * 校验Saas模式下用户是否具有操作停车场相关数据的权限
     * @param userBasicInfo
     * @param cfCarParkId
     * @param action 操作类型(edit-编辑/delete-删除)
     * @return 返回true则表示当前用户为超级管理员或者是停车场主
     */
    boolean checkSaasAction(UserBasicInfo userBasicInfo, String cfCarParkId, String action);

    /**
     * 校验用户是否是超级管理员或者指定停车场的主人
     * @param userBasicInfo
     * @param cfCarParkId
     */
    void checkHostOrAdminer(UserBasicInfo userBasicInfo, String cfCarParkId);

    /**
     * 检查重复数据
     * @param cfCarParkLinkUser
     */
    void checkRepeatData(CfCarParkLinkUser cfCarParkLinkUser);
}
