package com.cf.forward.hk.task;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.cf.forward.hk.hardware.HkHelper;
import com.cf.forward.hk.hardware.handle.DvrMessageHandleImpl;
import com.cf.forward.hk.utils.SpringContextUtil;
import com.cf.framework.domain.response.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @author why
 */
@Slf4j
public class CheckOrderTask {

    /**
     * 当前语音播报对象
     */
    private static Map<String, JSONObject> radioObj = new ConcurrentHashMap<>();

    private static Map<String, ScheduledFuture<?>> futureMap = new ConcurrentHashMap<>();

    public static void startCron(String carLogId, String deviceIP, String baseUrl) {
        ThreadPoolTaskScheduler scheduler = SpringContextUtil.getBean(ThreadPoolTaskScheduler.class);
        ScheduledFuture<?> future = futureMap.get(carLogId);
        if (Objects.isNull(future)) {
            // 注： 应该清空前一辆车记录,
//            if (futureMap.size() > 0) {
//                for (String key : futureMap.keySet()) {
//                    if(!key.equals(carLogId)){
//                        stopCron(key);
//                    }
//                }
//            }
            // =========
            future = scheduler.schedule(new Runnable() {
                private int retryCount = 0;

                @Override
                public void run() {
                    if (retryCount < 600) {
                        retryCount++;
                        checkOrder(carLogId, deviceIP, baseUrl);
                    } else {
                        stopCron(carLogId);
                    }
                }
            }, new CronTrigger("0/5 * * * * *"));
            log.info("开始检查订单是否支付");
            futureMap.put(carLogId, future);
        }
    }

    public static void stopCron(String carLogId) {
        ScheduledFuture<?> future = futureMap.get(carLogId);
        if (Objects.nonNull(future)) {
            future.cancel(true);
            futureMap.remove(carLogId);
        }
        log.info("已重试600次，停止检查");
    }

    /**
     * 检查订单是否支付
     *
     * @param carLogId 记录ID
     * @param deviceIP 设备IP
     */
    private static void checkOrder(String carLogId, String deviceIP, String baseUrl) {
        String url = baseUrl + "/carparkorder/check_order_is_pay?id=" + carLogId;
        String result = HttpUtil.createGet(url).execute().body();
        ObjectMapper mapper = new ObjectMapper();
        ResponseResult responseResult = null;
        try {
            responseResult = mapper.readValue(result, ResponseResult.class);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        if (Objects.nonNull(responseResult) && responseResult.isSuccess() && responseResult.getCode() == 10002 && Objects.nonNull(responseResult.getData())) {
            HkHelper hkHelper = SpringContextUtil.getBean(HkHelper.class);
            JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(responseResult.getData()));
            String carNo = json.getString("effectObject");
            BigDecimal money = BigDecimal.ZERO;
            BigDecimal amountActuallyPaid = json.getBigDecimal("amountActuallyPaid");
            if (null != amountActuallyPaid) {
                money = amountActuallyPaid;
            }
            Integer status = json.getInteger("status");
            if (null != status && status == 1) {
                // 判断是否有欠费订单
                String effectObject = json.getString("effectObject");
                JSONObject currencyMap = json.getJSONObject("currencyMap");
                if (null != currencyMap && null != currencyMap.getJSONArray("arrearsOrder") && currencyMap.getJSONArray("arrearsOrder").size() > 0) {
                    JSONObject obj = CheckOrderTask.radioObj.get("carLogId");
                    if (null == obj) {
                        int size = currencyMap.getJSONArray("arrearsOrder").size();
                        String info = effectObject + " 还有" + size + "个 订单未支付 请先完成支付";
                        hkHelper.controlVoice(info);
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("ceateTime", new Date());
                        jsonObject.put("numberPlate", effectObject);
                        CheckOrderTask.radioObj.put("carLogId", jsonObject);

                        SpaceNumAsyncTask.stopCarInfo.setCreateTime(new Date());
                        SpaceNumAsyncTask.stopCarInfo.setShowTxt(info);
                        SpaceNumAsyncTask.stopCarInfo.setNumberPlate(carNo);
                    } else {

                    }
                } else {
                    stopCron(carLogId);
                    CheckOrderTask.radioObj.remove(carLogId);
                    log.info(String.format("ip：%s， 车牌号：%s，停车记录ID：%s，已支付：%s，尝试开闸", deviceIP, carNo, carLogId, money.toPlainString()));
                    hkHelper.openAndClose(true);
                    hkHelper.controlVoice("一路顺风");
                    DvrMessageHandleImpl dvrMessageHandle = SpringContextUtil.getBean(DvrMessageHandleImpl.class);
                }
            } else {
                // 判断是否有欠费订单
                String effectObject = json.getString("effectObject");
                JSONObject currencyMap = json.getJSONObject("currencyMap");
                if (null != currencyMap && null != currencyMap.getJSONArray("arrearsOrder") && currencyMap.getJSONArray("arrearsOrder").size() > 0) {
                    JSONObject obj = CheckOrderTask.radioObj.get("carLogId");
                    if (null == obj) {
                        int size = currencyMap.getJSONArray("arrearsOrder").size();
                        String info = effectObject + " 还有" + size + "个 订单未支付 请先完成支付";
                        hkHelper.controlVoice(info);
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("ceateTime", new Date());
                        jsonObject.put("numberPlate", effectObject);
                        CheckOrderTask.radioObj.put("carLogId", jsonObject);
                        SpaceNumAsyncTask.stopCarInfo.setCreateTime(new Date());
                        SpaceNumAsyncTask.stopCarInfo.setShowTxt(info);
                        SpaceNumAsyncTask.stopCarInfo.setNumberPlate(carNo);
                    }
                }
            }
        } else {
            log.info(String.format("ip：%s，停车记录ID：%s，未支付", deviceIP, carLogId));
        }
    }

}
