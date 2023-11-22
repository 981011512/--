
package com.cf.forward.dh.listener;

import com.cf.forward.dh.config.CameraConfig;
import com.cf.forward.dh.config.DhForwardProperties;
import com.cf.forward.dh.entity.CameraInfo;
import com.cf.forward.dh.entity.LedConfig;
import com.cf.forward.dh.yangbang.YangBangController;
import org.apache.commons.io.output.TeeOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.util.List;

@Service
public class ListenerStarter implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ApplicationArguments applicationArguments;
    @Autowired
    private DhForwardProperties properties;

    public static DhForwardProperties propertiesCache;

    public static String coding = "UTF-8";

    @Override
    public void onApplicationEvent(ContextRefreshedEvent evt) {
        try {
            List<CameraInfo> cameraInfoes = properties.getCameraInfoes();
            propertiesCache = properties;
            ListenerStarter.coding = properties.getCoding();
            if(cameraInfoes!=null && cameraInfoes.size()>0){
                //创建大华连接
                for(CameraInfo cameraInfo: cameraInfoes){
                    String path = "E:/java/cf/cf-internet-of-things/cf-car-park/forward-dh/libs/";
                    CameraConfig.setDllPath(path);
                    cameraInfo.setPort(37777);
                    //3、获取进程pid，并更新到数据库
                    Integer pid = Integer.parseInt(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
                    cameraInfo.setPid(pid);
                    start(cameraInfo);
                    Thread.sleep(3000); //延时3秒
                }
            }else{
                System.out.println("没有可接入的设备");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void start(CameraInfo cameraInfo){
        Runnable runnable = () -> {
            try {
                new AlarmListener().start(cameraInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable).start();
    }

    public static void systemOutLog(File file){
        try {
            FileOutputStream fos = new FileOutputStream(file);//f:生成的文件路径
            //we will want to print in standard "System.out" and in "file"
            TeeOutputStream myOut=new TeeOutputStream(System.out, fos);
            PrintStream ps = new PrintStream(myOut, true); //true - auto-flush after println
            System.setOut(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
