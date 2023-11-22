package com.cf.carpark.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.AcsResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.RpcAcsRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.ocr.model.v20191230.RecognizeLicensePlateRequest;
import com.aliyuncs.ocr.model.v20191230.RecognizeLicensePlateResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.service.CfCarParkOcrService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.service.CfWeixinConfigService;
import com.cf.ucenter.wxtools.WeiXinConfigUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkOcrServiceImpl implements CfCarParkOcrService {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeixinConfigService cfWeixinConfigService;

    static IAcsClient client = null;

    @Override
    public String AliNumberPlateOcr(String numberPlateImageURL) throws Exception {

        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("ali_ocr");
        String regionId = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("ocr_region_id", cfWeixinConfigs);
        String accessKeyId = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("ocr_access_key_id", cfWeixinConfigs);
        String secret = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("ocr_secret", cfWeixinConfigs);

        DefaultProfile profile = DefaultProfile.getProfile(
                regionId,             //默认  cn-shanghai
                accessKeyId,         //您的AccessKeyID
                secret);    //您的AccessKeySecret

        client = new DefaultAcsClient(profile);

        RecognizeLicensePlateRequest req = new RecognizeLicensePlateRequest();
        req.setImageURL(numberPlateImageURL);
        try{
            RecognizeLicensePlateResponse resp = getAcsResponse(req);
            return resp.getData().getPlates().get(0).getPlateNumber();
        }catch (Exception e){
            ExceptionCast.cast(CommonCode.FAIL,e.getMessage());
        }
        return null;
    }

    private static <R extends RpcAcsRequest<T>, T extends AcsResponse> T getAcsResponse(R req) throws Exception {
        try {
            return client.getAcsResponse(req);
        } catch (ServerException e) {
            // 服务端异常
            System.out.println(String.format("ServerException: errCode=%s, errMsg=%s", e.getErrCode(), e.getErrMsg()));
            throw e;
        } catch (ClientException e) {
            // 客户端错误
            System.out.println(String.format("ClientException: errCode=%s, errMsg=%s", e.getErrCode(), e.getErrMsg()));
            throw e;
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            throw e;
        }
    }

    public static void printResponse(String actionName, String requestId, AcsResponse  data) {
        System.out.println(String.format("actionName=%s, requestId=%s, data=%s", actionName, requestId,
                JSON.toJSONString(data) ));
    }

}
