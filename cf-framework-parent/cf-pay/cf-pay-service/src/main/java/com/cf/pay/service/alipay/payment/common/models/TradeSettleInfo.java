// This file is auto-generated, don't edit it. Thanks.
package com.cf.pay.service.alipay.payment.common.models;

import com.aliyun.tea.*;

public class TradeSettleInfo extends TeaModel {
    @NameInMap("trade_settle_detail_list")
    @Validation(required = true)
    public TradeSettleDetail[] tradeSettleDetailList;

    public static TradeSettleInfo build(java.util.Map<String, ?> map) throws Exception {
        TradeSettleInfo self = new TradeSettleInfo();
        return TeaModel.build(map, self);
    }

}
