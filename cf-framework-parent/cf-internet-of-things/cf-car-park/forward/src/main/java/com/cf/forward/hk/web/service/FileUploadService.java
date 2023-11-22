package com.cf.forward.hk.web.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.cf.forward.hk.config.HkForwardProperties;
import com.cf.framework.domain.response.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class FileUploadService {

    @Autowired
    private HkForwardProperties properties;


    /**
     * 上传图片
     */
    @Async
    public void uploadImage(String carLogId, String smallImagePath, String bigImagePath, String direction) {
        String url = properties.getBaseUrl()+"/carparklog/update";
        byte[] bytes1 = FileUtil.readBytes(smallImagePath);
        byte[] bytes2 = FileUtil.readBytes(bigImagePath);
        String smallImageBase64 = Base64Utils.encodeToString(bytes1);
        String bigImageBase64 = Base64Utils.encodeToString(bytes2);
        Map<String, String> map = new HashMap<>();
        map.put("carLogId", carLogId);
        map.put("smallImage", smallImageBase64);
        map.put("bigImage", bigImageBase64);
        map.put("direction", direction);
        String body = JSONUtil.toJsonStr(map);
        String res = HttpUtil.post(url, body);
        ObjectMapper mapper = new ObjectMapper();
        try {
            ResponseResult result = mapper.readValue(res, ResponseResult.class);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
}
