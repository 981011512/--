package com.cf.pay.service;

import com.cf.pay.domain.CfHistoryOrder;
import com.cf.pay.domain.CfHistoryOrderExample;
import com.cf.pay.domain.request.CfHistoryOrderQuery;

import java.util.List;

public interface CfHistoryOrderService {

    CfHistoryOrder add(CfHistoryOrder cfHistoryOrder);

    CfHistoryOrderExample getExampleByQuery(CfHistoryOrderQuery cfHistoryOrderQuery);

    List<CfHistoryOrder> getListByQuery(CfHistoryOrderQuery cfHistoryOrderQuery);

    Integer countByQuery(CfHistoryOrderQuery cfHistoryOrderQuery);

}
