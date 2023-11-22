package com.cf.pay.service;

import com.cf.pay.domain.CfAccount;
import com.cf.pay.domain.CfAccountExample;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.domain.response.ResultMap;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户账户管理服务
 */
public interface CfAccountService {

    CfAccount add(CfAccount cfAccount);

    CfAccount update(CfAccount cfAccount);

    /**
     * 根据用户id和积分类型自动添加(存在则返回返回，否则添加)
     * @param cfAccount
     * @return
     */
    CfAccount autoCheckExistAndAddByUidAndScoreType(CfAccount cfAccount);

    CfAccountExample getExampleByQuery(CfAccountQuery cfAccountQuery);

    List<CfAccount> getListByQuery(CfAccountQuery cfAccountQuery);

    List<CfAccount> myAccountList(CfAccountQuery cfAccountQuery);

    Integer countByQuery(CfAccountQuery cfAccountQuery);

    /**
     * 根据条件和值更新账户余额
     * @param cfAccountQuery
     * @return
     */
    Integer updateBalanceByQuery(CfAccountQuery cfAccountQuery);

    /**
     * 检查积分是否满足扣费，如果满足直接扣费
     * @param cfAccountQuery
     * @return
     */
    CfAccount checkAndUseBalanceByQuery(CfAccountQuery cfAccountQuery);

    /**
     * 检查积分是否满足扣费(只查询)
     * @param cfAccountQuery
     * @return
     */
    CfAccount checkBalanceByQuery(CfAccountQuery cfAccountQuery);

    /**
     * 检查积分和新增积分，并且会产生一条充值账单记录
     * @param cfAccountQuery
     * @return
     */
    Integer checkAndAddBalanceByQuery(CfAccountQuery cfAccountQuery);

    /**
     * 检查积分和减少积分，并且会产生一条提现账单记录
     * @param cfAccountQuery 实体建议带 用户id和积分类型，还有要变动的值 三个字段的值
     * @return
     */
    Integer checkAndReduceBalanceByQuery(CfAccountQuery cfAccountQuery);

    /**
     * 检查积分和新增积分，【注意】该方法不会产生充值账单
     * @param cfAccountQuery
     * @return
     */
    CfAccount checkAndAddBalance(CfAccountQuery cfAccountQuery);

    /**
     * 客户端充值
     * @param cfAccountQuery
     * @return
     */
    ResultMap customerCheckAndAddBalanceByQuery(CfAccountQuery cfAccountQuery) throws Exception;

}
