package com.cf.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfTaxAccountMapper;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfTaxAccount;
import com.cf.pay.domain.CfTaxAccountExample;
import com.cf.pay.domain.request.CfTaxAccountQuery;
import com.cf.pay.domain.response.TaxNuoNuoResultMap;
import com.cf.pay.service.CfTaxAccountService;
import nuonuo.open.sdk.NNOpenSDK;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfTaxAccountServiceImpl implements CfTaxAccountService {

    @Autowired
    private CfTaxAccountMapper cfTaxAccountMapper;
    @Autowired
    private IdWorker idWorker;


    @Override
    public CfTaxAccount add(CfTaxAccount cfTaxAccount) {
        cfTaxAccount.setId(idWorker.nextId());
        cfTaxAccount.setCreateTime(System.currentTimeMillis());
        cfTaxAccount.setUpdateTime(System.currentTimeMillis());
        cfTaxAccountMapper.insert(cfTaxAccount);
        return cfTaxAccount;
    }

    @Override
    public Integer delete(String id) {
        return cfTaxAccountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfTaxAccount update(CfTaxAccount cfTaxAccount) {
        cfTaxAccount.setUpdateTime(System.currentTimeMillis());
        cfTaxAccountMapper.updateByPrimaryKey(cfTaxAccount);
        return cfTaxAccount;
    }

    @Override
    public CfTaxAccount findById(String id) {
        return cfTaxAccountMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfTaxAccount findById(String id, Boolean expectEmpty) {
        CfTaxAccount cfTaxAccount = findById(id);
        if(expectEmpty && cfTaxAccount!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && cfTaxAccount==null){
            ExceptionCast.cast(PayCode.TAX_ACCOUNT_NOT_EXIST);
        }
        return cfTaxAccount;
    }

    @Override
    public CfTaxAccountExample getExampleByQuery(CfTaxAccountQuery cfTaxAccountQuery) {
        CfTaxAccountExample cfTaxAccountExample = new CfTaxAccountExample();
        CfTaxAccountExample.Criteria criteria = cfTaxAccountExample.createCriteria();
        if(StringUtils.isNotEmpty(cfTaxAccountQuery.getTaxAgency())){
            criteria.andTaxAgencyEqualTo(cfTaxAccountQuery.getTaxAgency());
        }
        if(StringUtils.isNotEmpty(cfTaxAccountQuery.getUid())){
            criteria.andUidEqualTo(cfTaxAccountQuery.getUid());
        }
        if(cfTaxAccountQuery.getMinCreateTime()!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfTaxAccountQuery.getCreateTime());
        }
        if(cfTaxAccountQuery.getMaxCreateTime()!=null){
            criteria.andCreateTimeLessThanOrEqualTo(cfTaxAccountQuery.getMaxCreateTime());
        }
        if(cfTaxAccountQuery.getMinUpdateTime()!=null){
            criteria.andUpdateTimeGreaterThanOrEqualTo(cfTaxAccountQuery.getUpdateTime());
        }
        if(cfTaxAccountQuery.getMaxUpdateTime()!=null){
            criteria.andUpdateTimeLessThanOrEqualTo(cfTaxAccountQuery.getMaxUpdateTime());
        }
        return cfTaxAccountExample;
    }

    @Override
    public List<CfTaxAccount> getListByQuery(CfTaxAccountQuery cfTaxAccountQuery) {
        return cfTaxAccountMapper.selectByExample(getExampleByQuery(cfTaxAccountQuery));
    }

    @Override
    public Integer countByQuery(CfTaxAccountQuery cfTaxAccountQuery) {
        return cfTaxAccountMapper.countByExample(getExampleByQuery(cfTaxAccountQuery));
    }

    @Override
    public List<CfTaxAccount> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT pmt.* FROM cf_tax_account ta";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfTaxAccountMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_tax_account ta";
        conditions.remove("group");
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfTaxAccountMapper.selectListByConditionCounts(sql);
    }

    @Override
    public Object invoice(String uid, CfOrder cfOrder, String platform) throws Exception {
        CfTaxAccount cfTaxAccount = getCfTaxAccount(uid, platform);
        switch (platform){
            case "nuonuo":
                InvoiceByNuoNuo(uid, cfOrder, cfTaxAccount);
                break;
            default:
                ExceptionCast.cast(PayCode.TAX_PLATFORM_NOT_EXIST);
        }
        return null;
    }

    @Override
    public Object InvoiceByNuoNuo(String uid, CfOrder cfOrder, CfTaxAccount cfTaxAccount) throws Exception {
        CfTaxAccount taxAccount = getCfTaxAccount(uid, "nuonuo");
        JSONObject content = new JSONObject();
        content.put("", "");
        //TODO 继续完成诺诺电子发票开票请求参数
        nuonuoTaxBusinessRequest(content.toJSONString(), taxAccount, "https://sdk.nuonuo.com/open/v1/services", "nuonuo.ElectronInvoice.InvoiceRedApply");
        return null;
    }

    @Override
    public CfTaxAccount getCfTaxAccount(String uid, String platform) throws Exception {
        CfTaxAccountQuery cfTaxAccountQuery = new CfTaxAccountQuery();
        cfTaxAccountQuery.setUid(uid);
        cfTaxAccountQuery.setTaxAgency(platform);
        List<CfTaxAccount> cfTaxAccounts = getListByQuery(cfTaxAccountQuery);
        if(cfTaxAccounts==null || cfTaxAccounts.size()==0){
            ExceptionCast.cast(PayCode.TAX_ACCOUNT_NOT_EXIST);
        }
        if(cfTaxAccounts.get(0).getAccessTokenExpiredTime()>System.currentTimeMillis()){
            return cfTaxAccounts.get(0);
        }
        JSONObject requestParams = getConfigParams(cfTaxAccounts.get(0));
        switch (platform){
            case "nuonuo"://诺诺电子发票平台
                HashMap<String, String> requestHeaders = new HashMap<>();
                requestHeaders.put("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
                JSONObject result = (JSONObject)HttpClient.doPost(requestParams, requestParams.getString("get_access_token_url"), requestHeaders, true);
                if(result.containsKey("access_token")){
                    cfTaxAccounts.get(0).setAccessToken(result.getString("access_token"));
                    Long expiresIn = new Long(result.getString("expires_in"));
                    cfTaxAccounts.get(0).setAccessTokenExpiredTime(System.currentTimeMillis()+(expiresIn*1000)-60000);
                    update(cfTaxAccounts.get(0));
                    return cfTaxAccounts.get(0);
                }
                ExceptionCast.cast(CommonCode.FAIL,result.getString("error_description"));
                break;
            default:
                ExceptionCast.cast(PayCode.TAX_PLATFORM_NOT_EXIST);
        }
        return null;
    }

    /**
     * 请求诺诺开票业务
     * @param content
     * @param cfTaxAccount
     * @param url
     * @param method
     * @return
     */
    private Object nuonuoTaxBusinessRequest(String content, CfTaxAccount cfTaxAccount, String url, String method)
    {
        JSONObject configParams = getConfigParams(cfTaxAccount);
        NNOpenSDK nnSDK = NNOpenSDK.getIntance();
        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，32位随机码，无需修改，保持默认即可
        return nnSDK.sendPostSyncRequest(url, senid, configParams.getString("client_id"), configParams.getString("client_secret"),
                cfTaxAccount.getAccessToken(), configParams.getString("taxnum"), method, content);
    }

    /**
     * 读取电子税务账号配置项参数
     * @param cfTaxAccount
     * @return
     */
    private JSONObject getConfigParams(CfTaxAccount cfTaxAccount)
    {
        JSONObject configParams = JSONObject.parseObject(cfTaxAccount.getConfigParams());
        JSONObject requestParams = new JSONObject();
        switch (cfTaxAccount.getTaxAgency()){
            case "nuonuo":
                if(!configParams.containsKey("client_id")){
                    ExceptionCast.cast(PayCode.TAX_ACCOUNT_MISSING_CONFIGURATION, "missing param: client_id");
                }
                requestParams.put("client_id",configParams.getString("client_id"));
                if(!configParams.containsKey("client_secret")){
                    ExceptionCast.cast(PayCode.TAX_ACCOUNT_MISSING_CONFIGURATION, "missing param: client_secret");
                }
                requestParams.put("client_secret",configParams.getString("client_secret"));
                if(!configParams.containsKey("get_access_token_url")){
                    ExceptionCast.cast(PayCode.TAX_ACCOUNT_MISSING_CONFIGURATION, "missing param: get_access_token_url");
                }
                requestParams.put("get_access_token_url",configParams.getString("get_access_token_url"));
                if(!configParams.containsKey("taxnum ")){
                    ExceptionCast.cast(PayCode.TAX_ACCOUNT_MISSING_CONFIGURATION, "missing param: taxnum ");
                }
                requestParams.put("taxnum ",configParams.getString("taxnum "));
                if(!configParams.containsKey("grant_type ")){
                    ExceptionCast.cast(PayCode.TAX_ACCOUNT_MISSING_CONFIGURATION, "missing param: grant_type ");
                }
                requestParams.put("grant_type ",configParams.getString("grant_type "));
                break;
            default:
                ExceptionCast.cast(PayCode.TAX_PLATFORM_NOT_EXIST);
        }
        return requestParams;
    }
}
