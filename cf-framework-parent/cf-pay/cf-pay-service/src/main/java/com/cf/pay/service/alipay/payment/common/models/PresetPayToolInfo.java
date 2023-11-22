// This file is auto-generated, don't edit it. Thanks.
package com.cf.pay.service.alipay.payment.common.models;

import com.aliyun.tea.*;

public class PresetPayToolInfo extends TeaModel {
    @NameInMap("amount")
    @Validation(required = true)
    public String[] amount;

    @NameInMap("assert_type_code")
    @Validation(required = true)
    public String assertTypeCode;

    public static PresetPayToolInfo build(java.util.Map<String, ?> map) throws Exception {
        PresetPayToolInfo self = new PresetPayToolInfo();
        return TeaModel.build(map, self);
    }

}
