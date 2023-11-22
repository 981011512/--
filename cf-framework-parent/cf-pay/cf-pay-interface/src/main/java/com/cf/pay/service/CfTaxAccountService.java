package com.cf.pay.service;

import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfTaxAccount;
import com.cf.pay.domain.CfTaxAccountExample;
import com.cf.pay.domain.request.CfTaxAccountQuery;
import com.cf.pay.domain.response.TaxNuoNuoResultMap;

import java.util.List;
import java.util.Map;

public interface CfTaxAccountService {

    CfTaxAccount add(CfTaxAccount cfTaxAccount);

    Integer delete(String id);

    CfTaxAccount update(CfTaxAccount cfTaxAccount);

    CfTaxAccount findById(String id);

    CfTaxAccount findById(String id, Boolean expectEmpty);

    CfTaxAccountExample getExampleByQuery(CfTaxAccountQuery cfTaxAccountQuery);

    List<CfTaxAccount> getListByQuery(CfTaxAccountQuery cfTaxAccountQuery);

    Integer countByQuery(CfTaxAccountQuery cfTaxAccountQuery);

    /**
     * 根据条件查询税务账号列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfTaxAccount> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询税务账号列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 开具电子发票
     * @param uid
     * @param cfOrder
     * @param platform baiwang-百望云  nuonuo-诺诺
     * @return
     */
    Object invoice(String uid, CfOrder cfOrder, String platform) throws Exception;

    /**
     * https://open.jss.com.cn/#/api-doc/common-api?id=100208
     * 通过诺诺开具电子发票
     * @param uid
     * @param cfOrder
     * @param cfTaxAccount
     * @return
     */
    Object InvoiceByNuoNuo(String uid, CfOrder cfOrder, CfTaxAccount cfTaxAccount) throws Exception;

    /**
     * 获取电子发票平台账号
     * @param uid
     * @param platform  baiwang-百望云  nuonuo-诺诺
     * @return
     */
    CfTaxAccount getCfTaxAccount(String uid, String platform) throws Exception;
}
