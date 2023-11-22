package com.cf.forward.hk.task;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.cf.forward.hk.config.HkForwardProperties;
import com.cf.forward.hk.hardware.HkHelper;
import com.cf.forward.hk.hardware.HkHelperInterface;
import com.cf.forward.hk.utils.SpringContextUtil;
import com.cf.forward.hk.web.domain.CarParkSpaceInfo;
import com.cf.forward.hk.web.domain.StopCarInfo;
import com.cf.framework.domain.response.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author why
 */
@Slf4j
@Service
public class SpaceNumAsyncTask {

    private Map<String, Long> timeMap = new HashMap<>();

    /**
     * 停车场信息
     */
    public static final CarParkSpaceInfo carParkSpaceInfo = new CarParkSpaceInfo();

    /**
     * 扫到当前车牌信息
     */
    public static final  StopCarInfo stopCarInfo = new StopCarInfo();


    @Autowired
    private HkForwardProperties properties;
}
