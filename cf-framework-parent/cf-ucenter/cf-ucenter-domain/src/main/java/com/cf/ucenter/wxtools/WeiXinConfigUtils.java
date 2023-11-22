package com.cf.ucenter.wxtools;

import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.ucenter.domain.CfWeixinConfig;

import java.util.List;

public class WeiXinConfigUtils {

    public static String getWeiXinConfigragtionByEnName(String enName, List<CfWeixinConfig> cfWeixinConfigs)
    {
        String value = null;
        for(CfWeixinConfig cfWeixinConfig: cfWeixinConfigs){
            if(cfWeixinConfig.getEnName().equals(enName)){
                value = cfWeixinConfig.getValue();
                break;
            }
        }
        if(value==null){
            ExceptionCast.cast(UcenterCode.WECHAT_CONFIGURATION_DOES_NOT_EXIST, "miss configragtion: "+enName);
        }
        return value;
    }

}
