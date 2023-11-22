package com.cf.pay.service.impl;

import com.cf.carpark.service.CfCarParkCarService;
import com.cf.framework.domain.pay.AccountCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfAccountMapper;
import com.cf.pay.domain.CfAccount;
import com.cf.pay.domain.CfAccountExample;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfScoreType;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.request.CfScoreTypeQuery;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfAccountService;
import com.cf.pay.service.CfOrderService;
import com.cf.pay.service.CfScoreTypeService;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.CfUserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfAccountServiceImpl implements CfAccountService {

    @Autowired
    private CfAccountMapper cfAccountMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfScoreTypeService cfScoreTypeService;
    @Autowired
    private CfOrderService cfOrderService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;


    @Override
    public CfAccount add(CfAccount cfAccount) {
        cfAccount.setId(idWorker.nextId());
        cfAccount.setCreateTime(System.currentTimeMillis());
        int insert = cfAccountMapper.insert(cfAccount);
        if(insert>0){
            return cfAccount;
        }
        ExceptionCast.cast(CommonCode.FAIL);
        return null;
    }

    @Override
    public CfAccount update(CfAccount cfAccount) {
        cfAccountMapper.updateByPrimaryKey(cfAccount);
        return cfAccount;
    }

    @Override
    public CfAccount autoCheckExistAndAddByUidAndScoreType(CfAccount cfAccount) {
        CfAccountQuery cfAccountQuery = new CfAccountQuery();
        cfAccountQuery.setUid(cfAccount.getUid());
        cfAccountQuery.setScoreType(cfAccount.getScoreType());
        List<CfAccount> cfAccounts = getListByQuery(cfAccountQuery);
        if(cfAccounts==null || cfAccounts.size()==0){
            return add(cfAccount);
        }
        return cfAccounts.get(0);
    }

    @Override
    public CfAccountExample getExampleByQuery(CfAccountQuery cfAccountQuery) {
        CfAccountExample cfAccountExample = new CfAccountExample();
        CfAccountExample.Criteria criteria = cfAccountExample.createCriteria();
        if(cfAccountQuery.getId()!=null){
            criteria.andIdEqualTo(cfAccountQuery.getId());
        }
        if(StringUtils.isNotEmpty(cfAccountQuery.getUid())){
            criteria.andUidEqualTo(cfAccountQuery.getUid());
        }
        if(StringUtils.isNotEmpty(cfAccountQuery.getScoreType())){
            criteria.andScoreTypeEqualTo(cfAccountQuery.getScoreType());
        }
        if(cfAccountQuery.getType()!=null){
            criteria.andTypeEqualTo(cfAccountQuery.getType());
        }

        if(cfAccountQuery.getMinBalance()!=null){
            criteria.andBalanceGreaterThanOrEqualTo(cfAccountQuery.getMinBalance());
        }
        if(cfAccountQuery.getMaxBalance()!=null){
            criteria.andBalanceLessThanOrEqualTo(cfAccountQuery.getMaxBalance());
        }
        if(cfAccountQuery.getMinFreeze()!=null){
            criteria.andFreezeGreaterThanOrEqualTo(cfAccountQuery.getMinFreeze());
        }
        if(cfAccountQuery.getMaxFreeze()!=null){
            criteria.andFreezeLessThanOrEqualTo(cfAccountQuery.getMaxFreeze());
        }
        if(cfAccountQuery.getMinCreateTime()!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfAccountQuery.getMinCreateTime());
        }
        if(cfAccountQuery.getMaxCreateTime()!=null){
            criteria.andCreateTimeLessThanOrEqualTo(cfAccountQuery.getMaxCreateTime());
        }

        if(StringUtils.isNotEmpty(cfAccountQuery.getOrderBy())){
            cfAccountExample.setOrderByClause(cfAccountQuery.getOrderBy());
        }

        if(cfAccountQuery.getPage()!=null && cfAccountQuery.getSize()!=null){
            PageHelper.startPage(cfAccountQuery.getPage(), cfAccountQuery.getSize());
        }

        return cfAccountExample;
    }

    @Override
    public List<CfAccount> getListByQuery(CfAccountQuery cfAccountQuery) {
        return cfAccountMapper.selectByExample(getExampleByQuery(cfAccountQuery));
    }

    @Override
    public List<CfAccount> myAccountList(CfAccountQuery cfAccountQuery) {
        List<CfAccount> cfAccountList = cfAccountMapper.selectByExample(getExampleByQuery(cfAccountQuery));
        if(cfAccountList==null || cfAccountList.size()==0){
            //创建新的账户
            CfAccount cfAccount = new CfAccount();
            cfAccount.setUid(cfAccountQuery.getUid());
            cfAccount.setScoreType("cny");
            cfAccount.setBalance(new BigDecimal(0.00));
            cfAccount.setFreeze(0l);
            cfAccount.setType((byte)0);
            CfAccount account = add(cfAccount);
            cfAccountList = new ArrayList<>();
            cfAccountList.add(account);
        }
        return cfAccountList;
    }

    @Override
    public Integer countByQuery(CfAccountQuery cfAccountQuery) {
        cfAccountQuery.setPage(null);
        return cfAccountMapper.countByExample(getExampleByQuery(cfAccountQuery));
    }

    @Override
    public Integer updateBalanceByQuery(CfAccountQuery cfAccountQuery) {
        return cfAccountMapper.updateBalanceByQuery(cfAccountQuery);
    }

    @Override
    public CfAccount checkAndUseBalanceByQuery(CfAccountQuery cfAccountQuery) {
        CfAccount cfAccount = checkBalanceByQuery(cfAccountQuery);
        Integer integer = cfAccountMapper.updateBalanceByQuery(cfAccountQuery);
        return integer>0 ? cfAccount: null;
    }

    @Override
    public CfAccount checkBalanceByQuery(CfAccountQuery cfAccountQuery) {
        if(cfAccountQuery.getChangeValue().doubleValue()>=0){
            ExceptionCast.cast(CommonCode.INVALID_PARAM, "当前操作只能扣除资金账户余额");
        }
        List<CfAccount> cfAccounts = cfAccountMapper.selectByExample(getExampleByQuery(cfAccountQuery));
        if(cfAccounts==null || cfAccounts.size()==0){
            ExceptionCast.cast(AccountCode.ACCOUNT_NOT_EXIST);
        }
        if(cfAccounts.get(0).getBalance().doubleValue()<cfAccountQuery.getChangeValue().doubleValue()){
            ExceptionCast.cast(AccountCode.ACCOUNT_INSUFFICIENT_BALANCE);
        }
        return cfAccounts.get(0);
    }

    @Override
    public Integer checkAndAddBalanceByQuery(CfAccountQuery cfAccountQuery) {

        CfAccount cfAccount = checkAndAddBalance(cfAccountQuery);

        if(cfAccount!=null && cfAccountQuery.getChangeValue().doubleValue()>0){
            CfScoreTypeQuery cfScoreTypeQuery = new CfScoreTypeQuery();
            cfScoreTypeQuery.setKeyFlag(cfAccountQuery.getScoreType());
            List<CfScoreType> cfScoreTypes = cfScoreTypeService.getListByQuery(cfScoreTypeQuery);
            if(cfScoreTypes==null || cfScoreTypes.size()==0){
                ExceptionCast.cast(AccountCode.SCORE_TYPE_NOT_EXIST);
            }

            //新增账单记录
            CfOrder cfOrder = new CfOrder();
            cfOrder.setRandomId(idWorker.nextId());
            cfOrder.setUid(cfAccountQuery.getUid());
            cfOrder.setGoodsName("资金账户["+cfScoreTypes.get(0).getName()+"]充值");
            cfOrder.setGoodsId(cfScoreTypes.get(0).getId());
            cfOrder.setGoodsType(GoodsType.DEPOSIT);
            cfOrder.setAmountsPayable(cfAccountQuery.getChangeValue());
            cfOrder.setAmountActuallyPaid(cfAccountQuery.getChangeValue());
            cfOrder.setStatus(PayStatus.PAID);
            cfOrder.setPayTime(System.currentTimeMillis());
            cfOrder.setPaymentAgencyShortName("cash_pay_cny");
            cfOrder.setEffectObject(cfAccount.getId());
            cfOrder.setHandleUid(cfAccountQuery.getHandleUid());
            cfOrder.setScoreKeyFlag(cfAccountQuery.getScoreType());
            cfOrder.setShopId(cfAccountQuery.getShopId());
            cfOrderService.add(cfOrder);
        }
        return 1;
    }

    @Override
    public Integer checkAndReduceBalanceByQuery(CfAccountQuery cfAccountQuery) {
        CfAccountQuery updateCfAccountQuery = new CfAccountQuery();
        updateCfAccountQuery.setUid(cfAccountQuery.getUid());
        updateCfAccountQuery.setScoreType(cfAccountQuery.getScoreType());
        updateCfAccountQuery.setChangeValue(cfAccountQuery.getChangeValue().abs().negate());
        CfAccount cfAccount = checkAndUseBalanceByQuery(updateCfAccountQuery);

        if(cfAccount!=null){
            CfScoreTypeQuery cfScoreTypeQuery = new CfScoreTypeQuery();
            cfScoreTypeQuery.setKeyFlag(cfAccountQuery.getScoreType());
            List<CfScoreType> cfScoreTypes = cfScoreTypeService.getListByQuery(cfScoreTypeQuery);
            if(cfScoreTypes==null || cfScoreTypes.size()==0){
                ExceptionCast.cast(AccountCode.SCORE_TYPE_NOT_EXIST);
            }

            //新增账单记录
            CfOrder cfOrder = new CfOrder();
            cfOrder.setRandomId(idWorker.nextId());
            cfOrder.setUid(cfAccountQuery.getUid());
            cfOrder.setGoodsName("资金账户["+cfScoreTypes.get(0).getName()+"]提现");
            cfOrder.setGoodsId(cfScoreTypes.get(0).getId());
            cfOrder.setGoodsType(GoodsType.WITHDRAW);
            cfOrder.setAmountsPayable(cfAccountQuery.getChangeValue().abs());
            cfOrder.setAmountActuallyPaid(cfAccountQuery.getChangeValue().abs());
            cfOrder.setStatus(PayStatus.PAID);
            cfOrder.setPayTime(System.currentTimeMillis());
            cfOrder.setPaymentAgencyShortName(cfAccountQuery.getScoreType());
            cfOrder.setEffectObject(cfAccount.getId());
            cfOrder.setHandleUid(cfAccountQuery.getHandleUid());
            cfOrder.setScoreKeyFlag(cfAccountQuery.getScoreType());
            cfOrder.setShopId(cfAccountQuery.getShopId());
            cfOrderService.add(cfOrder);
        }
        return 1;
    }

    @Override
    public CfAccount checkAndAddBalance(CfAccountQuery cfAccountQuery) {

        if(cfAccountQuery.getChangeValue().doubleValue()<0){
            ExceptionCast.cast(CommonCode.INVALID_PARAM, "资金账户余额变动幅度必须大于0");
        }
        if(StringUtils.isEmpty(cfAccountQuery.getUid()) || StringUtils.isEmpty(cfAccountQuery.getUid())){
            ExceptionCast.cast(AccountCode.MISS_SOCRE_TYPE_OR_UID);
        }

        //判断用户是否存在
        CfUser cfUser = cfUserService.checkUserExistByUid(cfAccountQuery.getUid(), false);

        CfAccount account = null;
        Integer integer = 0;
        List<CfAccount> cfAccounts = cfAccountMapper.selectByExample(getExampleByQuery(cfAccountQuery));
        if(cfAccounts==null || cfAccounts.size()==0){
            //创建新的账户
            CfAccount cfAccount = new CfAccount();
            cfAccount.setUid(cfAccountQuery.getUid());
            cfAccount.setScoreType(cfAccountQuery.getScoreType());
            cfAccount.setBalance(cfAccountQuery.getChangeValue());
            cfAccount.setFreeze(0l);
            cfAccount.setType((byte)0);
            account = add(cfAccount);
            integer = 1;
        }else{
            account = cfAccounts.get(0);
            integer = cfAccountMapper.updateBalanceByQuery(cfAccountQuery);
        }
        if(integer>0){
            return account;
        }
        return null;
    }

    @Override
    public ResultMap customerCheckAndAddBalanceByQuery(CfAccountQuery cfAccountQuery) throws Exception {
        if(cfAccountQuery.getChangeValue().doubleValue()<=0){
            ExceptionCast.cast(CommonCode.INVALID_PARAM, "资金账户余额变动幅度必须大于0");
        }
        if(StringUtils.isEmpty(cfAccountQuery.getUid()) || StringUtils.isEmpty(cfAccountQuery.getUid())){
            ExceptionCast.cast(AccountCode.MISS_SOCRE_TYPE_OR_UID);
        }

        //判断用户是否存在
        CfUser cfUser = cfUserService.checkUserExistByUid(cfAccountQuery.getUid(), false);

        CfAccount account = null;
        List<CfAccount> cfAccounts = cfAccountMapper.selectByExample(getExampleByQuery(cfAccountQuery));
        if(cfAccounts==null || cfAccounts.size()==0){
            //创建新的账户
            CfAccount cfAccount = new CfAccount();
            cfAccount.setUid(cfAccountQuery.getUid());
            cfAccount.setScoreType(cfAccountQuery.getScoreType());
            cfAccount.setBalance(new BigDecimal(0.00));
            cfAccount.setFreeze(0l);
            cfAccount.setType((byte)0);
            account = add(cfAccount);
        }else{
            account = cfAccounts.get(0);
        }

        CfScoreTypeQuery cfScoreTypeQuery = new CfScoreTypeQuery();
        cfScoreTypeQuery.setKeyFlag(cfAccountQuery.getScoreType());
        List<CfScoreType> cfScoreTypes = cfScoreTypeService.getListByQuery(cfScoreTypeQuery);
        if(cfScoreTypes==null || cfScoreTypes.size()==0){
            ExceptionCast.cast(AccountCode.SCORE_TYPE_NOT_EXIST);
        }

        //查询最近10分钟内的是否有未提交的充值账单，如果有重复利用
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setGoodsType((byte)2);
        cfOrderQuery.setEffectObject(account.getId());
        cfOrderQuery.setUid(cfAccountQuery.getUid());
        cfOrderQuery.setStatus((byte)0);
        cfOrderQuery.setMinCreateTime(System.currentTimeMillis()-600000);
        List<CfOrder> cfOrders = cfOrderService.getListByQuery(cfOrderQuery);
        CfOrder order = null;
        if(cfOrders!=null && cfOrders.size()>0){
            order = cfOrders.get(0);
        }else{
            //新增账单记录
            CfOrder cfOrder = new CfOrder();
            cfOrder.setRandomId(idWorker.nextId());
            cfOrder.setUid(cfAccountQuery.getUid());
            cfOrder.setGoodsName("资金账户["+cfScoreTypes.get(0).getName()+"]充值");
            cfOrder.setGoodsId(cfScoreTypes.get(0).getId());
            cfOrder.setGoodsType((byte)2);
            cfOrder.setAmountsPayable(cfAccountQuery.getChangeValue());
            cfOrder.setAmountActuallyPaid(new BigDecimal(0));
            cfOrder.setStatus((byte)0);
            cfOrder.setPayTime(0l);
            cfOrder.setEffectObject(account.getId());
            cfOrder.setUserPaymentAgencyId(cfAccountQuery.getPayTypeId());
            cfOrder.setScoreKeyFlag(cfAccountQuery.getScoreType());
            order = cfOrderService.add(cfOrder);
        }

        return cfOrderService.payForOrder(order, cfAccountQuery.getPayTypeId(), cfAccountQuery.getIpAddress());
    }
}
