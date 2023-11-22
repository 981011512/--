package com.cf.logistics.service.task;

import com.cf.logistics.service.CfLogisticsVehicleService;
import com.cf.ucenter.service.CfUserDriverLicenseService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version 1.0
 **/
@Component
public class CfLogisticsVehicleTask {
    @Autowired
    private CfLogisticsVehicleService cfLogisticsVehicleService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserDriverLicenseService cfUserDriverLicenseService;

    /**
     * 例子：
     * 0/3 * * * * * 每隔3秒执行
     * 0 0/5 * * * * 每隔5分钟执行
     * 0 0 0 * * * 表示每天0点执行
     * 0 0 12 ? * WEN 每周三12点执行
     * 0 15 10 ? * MON-FRI 每月的周一到周五10点 15分执行
     */
//    @Scheduled(cron="0 0/120 * * * *")
    @Scheduled(cron="0/5 * * * * *")
    public void handleLogisticsVehicleTask() throws Exception{
        cfLogisticsVehicleService.synchronizeTmsVehicle();
    }

    @Scheduled(cron="0 0/5 * * * *")
    public void handleCfUserDriverLicenseTask() throws Exception{
        cfUserDriverLicenseService.synchronizeTmsDriver();
    }
}
