// This file is auto-generated, don't edit it. Thanks.
package com.cf.pay.service.alipay.util.aes;

import com.aliyun.tea.*;

import com.cf.pay.service.alipay.kernel.BaseClient;

public class Client extends BaseClient {
    public Client(Config config) throws Exception {
        super(TeaModel.buildMap(config));
    }


    public String decrypt(String cipherText) throws Exception {
        return _aesDecrypt(cipherText, _getConfig("encryptKey"));
    }

    public String encrypt(String plainText) throws Exception {
        return _aesEncrypt(plainText, _getConfig("encryptKey"));
    }
}
