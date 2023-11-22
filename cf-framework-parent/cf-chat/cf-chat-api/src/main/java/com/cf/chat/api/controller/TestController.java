package com.cf.chat.api.controller;

import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.service.CfUserMessageService;
import com.cf.chat.service.CfWeiXinSubscribeToNotificationsService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.service.CfLogisticsStorehousePlatformService;
import com.cf.logistics.service.CfLogisticsTaskLogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("chat/")
public class TestController {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserMessageService cfUserMessageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeiXinSubscribeToNotificationsService cfWeiXinSubscribeToNotificationsService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsTaskLogService cfLogisticsTaskLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsStorehousePlatformService cfLogisticsStorehousePlatformService;

    @RequestMapping(value = "testSendMessage", method = RequestMethod.GET)
    public ResponseResult testSendMessage(String value)throws Exception{
//        CfUserMessage cfUserMessage = new CfUserMessage();
//        cfUserMessage.setFromUid("0");
//        cfUserMessage.setToUid("123456789");
//        cfUserMessage.setType(1);
//        cfUserMessage.setContents("测试消息222");
//        cfUserMessage.setClient("");
//        cfUserMessage.setGroupId("");
//        cfUserMessage.setIp("");
//        CfUserMessage cfUserMessage1 = cfUserMessageService.addMessageToMongondb(cfUserMessage);
//        List<CfUserMessage> cfUserMessageList = cfUserMessageService.selectMessageListByToUidAndType("0", 7, 1, 10);
//        cfUserMessageService.batchUpdateStatusByIds(cfUserMessageList);
//        return new ResponseResult(CommonCode.SUCCESS, cfUserMessage1);
//        Map<String, String> contents = new HashMap<>();
//        contents.put("goods_name","停车缴费[鄂A88888]");
//        contents.put("amount","98.00元");
//        contents.put("pay_time","2021-04-08 11:23:09");
//        contents.put("goods_counts","1件");
//        contents.put("order_id","1378267099614171136");
//        JSONObject jsonObject = cfWeiXinSubscribeToNotificationsService.sendMessage("1370969464494657536", SubscribeMessageType.PAY_SUCCESSFUL, contents);
//
//        contents = new HashMap<>();
//        contents.put("number_plate","鄂A88888");
//        contents.put("car_park_name","大数据智慧大厦立体智能停车场");
//        contents.put("end_time","2021-04-08 11:23:09");
//        contents.put("notice","您的停车套餐即将到期请及时续费便于出行");
//        jsonObject = cfWeiXinSubscribeToNotificationsService.sendMessage("1370969464494657536", SubscribeMessageType.MONTHLY_CARD_EXPIRATION_NOTICE, contents);
//
//        contents = new HashMap<>();
//        contents.put("shop_name","大数据智慧停车场");
//        contents.put("amount","1000元");
//        contents.put("how_to_use","自动抵扣或手动缴费部分减免");
//        contents.put("start_time","2021-04-08 11:23:09");
//        contents.put("end_time","2021-04-09 11:23:09");
//        jsonObject = cfWeiXinSubscribeToNotificationsService.sendMessage("1370969464494657536", SubscribeMessageType.COUPON_NOTIFICATION, contents);
//        String encode = new BCryptPasswordEncoder().encode(password);
//        List<String> strings = Arrays.asList("京","津","沪","渝","宁","新","藏","桂","蒙","辽","吉","黑","冀","晋","苏","浙","皖",
//                "闽","赣","鲁","豫","鄂","湘","粤","琼","川","贵","云","陕","甘","青",
//                "A","B","C","D","E","F","G","H","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
//                "0","1","2","3","4","5","6","7","8","9");
//        for (String chinese: chineses){
//            String temp = "";
//            for (String abc: abcs){
//                temp = "";
////                for(int i=3; i<=6; i++){
//                    List<String> permutation = permutation(strings, 2);
//                    for (String s: permutation){
//                        temp += chinese+abc+s+"\r\n";
//                    }
//                    writeFile(temp,"E:/test.log");
////                }
//            }
//        }
//        CfLogisticsTaskLog cfLogisticsTaskLog = cfLogisticsTaskLogService.findById(1548914943163846656l, false);
//        CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform = cfLogisticsStorehousePlatformService.findById(cfLogisticsTaskLog.getLogisticsPlatformId(), false);
//        Map<String,String> contents = new HashMap<>();
//        contents.put("queueIndex",cfLogisticsTaskLog.getQueueIndex()+"");
//        contents.put("cfLogisticsStorehousePlatformName",cfLogisticsStorehousePlatform.getPlatformName());
//        cfWeiXinSubscribeToNotificationsService.sendMessage("1482720659499106304", CfWeiXinSubscribeToNotificationsType.LOGISTICS_LOADING_AND_UNLOADING,
//                contents,"wx440ab62a02fc51bc");

        return new ResponseResult(CommonCode.SUCCESS,new BCryptPasswordEncoder().encode(value));
    }

    public static List<String> permutation(List<String> list, int length) {
        Stream<String> stream = list.stream();
        for (int n = 1; n < length; n++) {
            stream = stream.flatMap(str -> list.stream().map(str::concat));
        }
        return stream.collect(Collectors.toList());
    }

    public void writeFile(String content, String fileName){
        File file =new File(fileName);
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try{
            if(!file.exists()){
                boolean hasFile = file.createNewFile();
                if(hasFile){
                    System.out.println("file not exists, create new file");
                }
                fos =new FileOutputStream(file);
            }else{
                fos =new FileOutputStream(file,true);
            }
            osw =new OutputStreamWriter(fos,"utf-8");
            osw.write(content);
            osw.write("\r\n");
        }catch(Exception e){
            System.out.println("写⼊⽂件发⽣异常");
        }finally{
            try{
                if(osw != null){
                    osw.close();
                }
                if(fos != null){
                    fos.close();
                }
            }catch(IOException e){
                System.out.println("关闭流异常");
            }
        }
    }

}
