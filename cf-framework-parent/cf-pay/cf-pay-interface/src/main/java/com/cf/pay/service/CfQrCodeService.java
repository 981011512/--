package com.cf.pay.service;

import com.cf.pay.domain.CfQrCode;
import com.cf.pay.domain.CfQrCodeExample;
import com.cf.pay.domain.request.CfQrCodeQuery;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.List;

public interface CfQrCodeService {

    byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException;

    CfQrCode add(CfQrCode cfQrCode);

    CfQrCode update(CfQrCode cfQrCode);

    CfQrCode updateByPrimaryKeySelective(CfQrCode cfQrCode);

    Integer delete(String id);

    CfQrCode findById(String id);

    CfQrCode findById(String id, boolean expectEmpty);

    CfQrCodeExample getExampleByQuery(CfQrCodeQuery cfQrCodeQuery);

    List<CfQrCode> getListByQuery(CfQrCodeQuery cfQrCodeQuery);

    Integer countByQuery(CfQrCodeQuery cfQrCodeQuery);

    /**
     * 员工创建领取优惠券二维码
     * @param cfQrCode
     * @return
     */
    CfQrCode staffCreateCouponQrCode(CfQrCode cfQrCode) throws Exception;

}
