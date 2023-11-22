package com.cf.forward.hk.hardware.handle;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.cf.carpark.device.camera.ZhenShi.SeriaDataUtils;
import com.cf.carpark.device.camera.hk.HkRequestParam;
import com.cf.carpark.device.camera.hk.HkResponse;
import com.cf.carpark.device.camera.hk.HkResult;
import com.cf.carpark.device.led.PlayRule;
import com.cf.carpark.device.led.ShowContent;
import com.cf.carpark.device.led.TextPlay;
import com.cf.carpark.device.led.VoicePlay;
import com.cf.carpark.domain.type.DeviceBrand;
import com.cf.forward.hk.config.HkForwardProperties;
import com.cf.forward.hk.hardware.HkHelper;
import com.cf.forward.hk.hardware.HkHelperInterface;
import com.cf.forward.hk.task.CheckOrderTask;
import com.cf.forward.hk.task.SpaceNumAsyncTask;
import com.cf.forward.hk.utils.SpringContextUtil;
import com.cf.forward.hk.web.domain.CarParkSpaceInfo;
import com.cf.forward.hk.web.service.FileUploadService;
import com.cf.framework.domain.file.response.FileSystemCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.BeanUtils;
import com.cf.framework.utils.IdWorker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author why
 * <p>
 * 摄像机 消息处理
 */
@Slf4j
@Service
public class DvrMessageHandleImpl {

    private static final String URL = "/carparklog/add?deviceBrand=hk";

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Autowired
    private HkForwardProperties properties;

    @Autowired
    private SpaceNumAsyncTask spaceNumAsyncTask;

    static HkRequestParam hkRequestParamMoniter;

    static boolean openHeartbeatMinitor = false;    //是否已经开启了心跳监听

    @Autowired
    private IdWorker idWorker;

    @Async
    public void carInAndOut(String isIn,HkRequestParam hkRequestParam, String deviceIp, String serialNo, byte[] smallByte, byte[] bigByte){
        heartBeatMonitor(hkRequestParam);
        threadPoolTaskScheduler.execute(()->{
//            hkRequestParam.setSmallImage(Base64.getEncoder().enco deToString(FileUtil.readBytes(smallImagePath)));
//            hkRequestParam.setBigImage(Base64.getEncoder().encodeToString(FileUtil.readBytes(bigImagePath)));
            sendOutData("in", hkRequestParam, deviceIp, serialNo, smallByte, bigByte);
        });
    }

    /**
     * 心跳监听
     */
    public void heartBeatMonitor(HkRequestParam hkRequestParam){

        //将序列号空格去掉
        hkRequestParam.setSerialNo(hkRequestParam.getSerialNo().replace(" ","")); ;

        if(!DvrMessageHandleImpl.openHeartbeatMinitor){
            DvrMessageHandleImpl.openHeartbeatMinitor = true;
            hkRequestParamMoniter = hkRequestParam;
            hkRequestParamMoniter.setDeviceBrand(DeviceBrand.HK);
            log.info("海康执行心跳包请求");
            //开启死循环发心跳包
            while (true){
                try{
                    ObjectMapper mapper = new ObjectMapper();
                    String body = null;
                    HkHelperInterface hkHelper = SpringContextUtil.getBean(HkHelperInterface.class);
                    Thread.sleep(1000); //延时1秒
                    body = mapper.writeValueAsString(hkRequestParamMoniter);
                    String res = HttpUtil.post(properties.getBaseUrl() + "/carparklog/pollingMonitoring?deviceBrand="+hkRequestParamMoniter.getDeviceBrand(), body);
                    if(StringUtils.isEmpty(res)){
                        continue;
                    }
                    HkResponse hkResponse = mapper.readValue(res, HkResponse.class);
                    //控制开关闸
                    if(hkResponse.getOpenDoor().equals("on")){
                        hkHelper.openAndClose(true);
                    }else{
                        hkHelper.openAndClose(false);
                    }

                    //控制显示屏显示
                    if(hkResponse.getPlayRule()!=null){
                        handleShowAndPaly(hkResponse.getPlayRule().getApproach(), hkHelper);
                        handleShowAndPaly(hkResponse.getPlayRule().getPayOut(), hkHelper);
                        handleShowAndPaly(hkResponse.getPlayRule().getAbnormalOut(), hkHelper);
                        handleShowAndPaly(hkResponse.getPlayRule().getFreeOut(), hkHelper);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
    }

    private String aliOssUpload(byte[] bytes, String filename) throws Exception{

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build("请输入否则无法正常图片", "请输入否则无法正常图片", "请输入否则无法正常图片");

        //上传文件的输入流
        InputStream inputStream = new ByteArrayInputStream(bytes);

        // 创建PutObjectRequest对象。
        //第一个参数 Bucket名称
        //第二个参数 上传到oss文件路径和文件名称
        //第三个参数 上传文件输入流



        PutObjectRequest putObjectRequest = new PutObjectRequest("请输入否则无法正常图片", filename, inputStream);

        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);

        // 上传文件。
        PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
        return filename;
    }

    /**
     * 发送数据
     */
    @Async
    public void sendOutData(
            String directionType,
            HkRequestParam hkRequestParam,
            String deviceIp,
            String serialNo,
            byte[] samllImagebytes,
            byte[] bigImagebytes
    ) {
//        hkRequestParam.setBigImagePath(idWorker.nextId()+".jpg");
//        hkRequestParam.setSmallImagePath(idWorker.nextId()+".jpg");

//        byte[] bigImagebytes = Base64.getEncoder().encodeToString(FileUtil.readBytes(bigImagePath)).getBytes();
//        byte[] samllImagebytes = Base64.getEncoder().encodeToString(FileUtil.readBytes(smallImagePath)).getBytes();
        hkRequestParam.setBigImage("");
        hkRequestParam.setSmallImage("");
        hkRequestParam.setBigImagePath(idWorker.nextId()+".jpg");
        hkRequestParam.setSmallImagePath(idWorker.nextId()+".jpg");
        final String smallFileNameFinal = hkRequestParam.getSmallImagePath();
        final String bigFileNameFinal = hkRequestParam.getBigImagePath();

        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                //异步上传文件到oss
                try {
                    aliOssUpload(bigImagebytes,bigFileNameFinal);
                    aliOssUpload(samllImagebytes,smallFileNameFinal);
                } catch (Exception e) {

                }
            }
        });
        thread.start();

        hkRequestParam.setSerialNo(serialNo);
        ObjectMapper mapper = new ObjectMapper();
        String body = null;
        HkHelperInterface hkHelper = SpringContextUtil.getBean(HkHelperInterface.class);
        try {
            body = mapper.writeValueAsString(hkRequestParam);
        } catch (JsonProcessingException e) {
            log.info("参赛序列化失败");
        }
        try {
            String res = HttpUtil.post(properties.getBaseUrl() + URL, body);
            HkResponse hkResponse = mapper.readValue(res, HkResponse.class);
            //控制开关闸
            if(hkResponse.getOpenDoor().equals("on")){
                hkHelper.openAndClose(true);
            }else{
                hkHelper.openAndClose(false);
            }

            //控制显示屏显示
            if(hkResponse.getPlayRule()!=null){
                handleShowAndPaly(hkResponse.getPlayRule().getApproach(), hkHelper);
                handleShowAndPaly(hkResponse.getPlayRule().getPayOut(), hkHelper);
                handleShowAndPaly(hkResponse.getPlayRule().getAbnormalOut(), hkHelper);
                handleShowAndPaly(hkResponse.getPlayRule().getFreeOut(), hkHelper);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleShowAndPaly(ShowContent showContent, HkHelperInterface hkHelper) throws Exception{
        //文本
        Map<String, TextPlay> textPlayList = showContent.getTextPlay();
        String showContents = "";
        for (Map.Entry<String, TextPlay> item: textPlayList.entrySet()){
            TextPlay textPlay = null;
            if(!(item.getValue() instanceof TextPlay)){
                textPlay = BeanUtils.deepMapToBean(TextPlay.class.newInstance().getClass(), (Map) item.getValue());
            }else{
                textPlay = item.getValue();
            }
            Integer serialChannel = 0;
            if(!(textPlay.getSerialChannel() instanceof Integer)){
                serialChannel = Integer.parseInt(textPlay.getSerialChannel()+"");
            }

            Integer row = 1;
            row = Integer.parseInt(item.getKey()+"");

            if(textPlay.getStatus()==1 && org.apache.commons.lang3.StringUtils.isNotEmpty(textPlay.getValue())){
                //先直接显示，暂时不管其它参数
                showContents += showContents.equals("")? textPlay.getValue(): " "+textPlay.getValue();
            }
        }
        if(StringUtils.isNotEmpty(showContents)){
            //执行显示
            hkHelper.controlLED(showContents, 60);
        }

        //语音
        Map<Integer, VoicePlay> voicePlayList = showContent.getVoicePlay();
        String playContents = "";
        for (Map.Entry<Integer, VoicePlay> item: voicePlayList.entrySet()){
            VoicePlay voicePlay = null;
            if(!(item.getValue() instanceof VoicePlay)){
                voicePlay = BeanUtils.deepMapToBean(VoicePlay.class.newInstance().getClass(), (Map) item.getValue());
            }else{
                voicePlay = item.getValue();
            }
            Integer serialChannel = 0;
            if(!(voicePlay.getSerialChannel() instanceof Integer)){
                serialChannel = Integer.parseInt(voicePlay.getSerialChannel()+"");
            }

            Integer row = 1;
            if(!(item.getKey() instanceof Integer)){
                row = Integer.parseInt(item.getKey()+"");
            }
            if(voicePlay.getStatus()==1 && StringUtils.isNotEmpty(voicePlay.getValue())){
                //先播报示，暂时不管其它参数
                playContents += playContents.equals("")? voicePlay.getValue(): " "+voicePlay.getValue();
            }
        }
        if(StringUtils.isNotEmpty(playContents)) {
            //执行播报
            hkHelper.controlVoice(playContents);
        }
    }


}
