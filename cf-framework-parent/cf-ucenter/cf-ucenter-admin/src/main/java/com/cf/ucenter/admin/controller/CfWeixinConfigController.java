package com.cf.ucenter.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.admin.swagger.CfWeixinConfigSwagger;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.request.CfWeixinConfigForm;
import com.cf.ucenter.request.CfWeixinConfigQuery;
import com.cf.ucenter.request.UnlimitedForm;
import com.cf.ucenter.service.CfWeixinConfigService;
import com.cf.ucenter.wxtools.WeiXinConfigUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("weixinConfigAdmin/")
@Validated
public class CfWeixinConfigController implements CfWeixinConfigSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfWeixinConfigService cfWeixinConfigService;

    @PreAuthorize("hasAuthority('ucenter-CfWeixinConfigController-list')")
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseResult list(CfWeixinConfigQuery cfWeixinConfigQuery) {
        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getListByQuery(cfWeixinConfigQuery);
        if(cfWeixinConfigs!=null && cfWeixinConfigs.size()>0){
            for (CfWeixinConfig cfWeixinConfig: cfWeixinConfigs){
                cfWeixinConfig.setValue(null);
            }
        }
        return cfWeixinConfigs!=null && cfWeixinConfigs.size()>0?new ResponseResult(CommonCode.SUCCESS, cfWeixinConfigs):new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('ucenter-CfWeixinConfigController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfWeixinConfigForm cfWeixinConfigForm) {
        CfWeixinConfig cfWeixinConfig = new CfWeixinConfig();
        BeanUtils.copyProperties(cfWeixinConfigForm, cfWeixinConfig);
        CfWeixinConfig weixinConfig = cfWeixinConfigService.add(cfWeixinConfig);
        return new ResponseResult(CommonCode.SUCCESS, weixinConfig);
    }

    @PreAuthorize("hasAuthority('ucenter-CfWeixinConfigController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfWeixinConfigForm cfWeixinConfigForm) {
        CfWeixinConfig cfWeixinConfig = new CfWeixinConfig();
        BeanUtils.copyProperties(cfWeixinConfigForm, cfWeixinConfig);
        CfWeixinConfig weixinConfig = cfWeixinConfigService.update(cfWeixinConfig);
        return new ResponseResult(CommonCode.SUCCESS, weixinConfig);
    }

    @PreAuthorize("hasAuthority('ucenter-CfWeixinConfigController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfWeixinConfigService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS):new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('ucenter-CfWeixinConfigController-getUnlimited')")
    @Override
    @RequestMapping(value = "getUnlimited", method = RequestMethod.GET)
    public Object getUnlimited(@Validated UnlimitedForm unlimitedForm) throws Exception {
        byte[] unlimited = (byte[]) cfWeixinConfigService.getUnlimited(unlimitedForm);
        return Base64.getEncoder().encodeToString(unlimited);
    }

    @PreAuthorize("hasAuthority('ucenter-CfWeixinConfigController-createSelfDefinedQrCode')")
    @Override
    @RequestMapping(value = "createSelfDefinedQrCode", method = RequestMethod.GET)
    public Object createSelfDefinedQrCode(String path, Integer width, Integer height) throws Exception {
        byte[] qrCodeUrlImage = getQRCodeImage(path, width, height);
        return Base64.getEncoder().encodeToString(qrCodeUrlImage);
    }

    private byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 1);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

    @PreAuthorize("hasAuthority('ucenter-CfWeixinConfigController-getHKAccessToken')")
    @Override
    @RequestMapping(value = "getHKAccessToken", method = RequestMethod.GET)
    public ResponseResult getHKAccessToken() throws Exception {
        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("hk_access");
        String hkAppKey = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("hk_app_key", cfWeixinConfigs);
        String hkAppSecret = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("hk_app_secret", cfWeixinConfigs);

        String hk = cfWeixinConfigService.getHKAccessToken("hk", hkAppKey, hkAppSecret);
        return new ResponseResult(CommonCode.SUCCESS, hk);
    }
}
