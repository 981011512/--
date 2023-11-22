package com.cf.carpark.device.camera.ZhenShi;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.device.camera.HuaXia.HuaXiaResponse;
import com.cf.carpark.device.camera.HuaXia.Rs485Data;
import com.cf.carpark.device.camera.ZhenShiResponse911202002050;
import com.cf.carpark.device.led.PlayRule;
import com.cf.carpark.device.led.ShowContent;
import com.cf.carpark.device.led.TextPlay;
import com.cf.carpark.device.led.VoicePlay;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.BeanUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * 臻识相机系列工具
 */
public class SeriaDataUtils {

    public static final String APPROACH = "approach";//正常入场
    public static final String FREEOUT = "freeOut";//免费出场
    public static final String PAYOUT = "payOut";//支付出场
    public static final String ABNORMALOUT = "abnormalOut";//异常出场
    public static final String VALIDITYPERIOD_TEMPORARY = "temporary";//内容有效期-临时
    public static final String VALIDITYPERIOD_PERMANENT = "permanent";//内容有效期-永久


    public static PlayRule setSerialDataZhenshiMultiple(String playRuleString , String scenes, String value, String dataType, String valueType) throws Exception{
        Map playRuleMap = (JSONObject.parseObject(playRuleString));
        PlayRule playRule = BeanUtils.deepMapToBean(PlayRule.class.newInstance().getClass(), playRuleMap);
        ShowContent showContent = null;
        switch (scenes){
            case "approach":
                showContent = playRule.getApproach();
                SeriaDataUtils.handleShowContent(dataType, value, showContent, valueType);
                break;
            case "freeOut":
                showContent = playRule.getFreeOut();
                SeriaDataUtils.handleShowContent(dataType, value, showContent, valueType);
                break;
            case "payOut":
                showContent = playRule.getPayOut();
                SeriaDataUtils.handleShowContent(dataType, value, showContent, valueType);
                break;
            case "abnormalOut":
                showContent = playRule.getAbnormalOut();
                SeriaDataUtils.handleShowContent(dataType, value, showContent, valueType);
                break;
            default:
                ExceptionCast.cast(CommonCode.INVALID_PARAM,"传入的场景类型暂不支持");
        }
        return playRule;
    }

    public static void handleShowContent(String dataType, String value, ShowContent showContent, String valueType) throws Exception{
        String textPlayValue = null;
        switch (dataType){
            case "text":
                Map<String, TextPlay> textPlayList = showContent.getTextPlay();
                for (Map.Entry<String, TextPlay> item: textPlayList.entrySet()){
                    if(textPlayValue!=null){
                        continue;
                    }
                    TextPlay textPlay = null;
                    if(!(item.getValue() instanceof TextPlay)){
                        textPlay = BeanUtils.deepMapToBean(TextPlay.class.newInstance().getClass(), (Map) item.getValue());
                    }else{
                        textPlay = item.getValue();
                    }

                    if(textPlay.getStatus()== 0 && valueType.equals(textPlay.getType())){
                        switch (textPlay.getType()){
                            case "plaintext":
                                textPlayValue = textPlay.getValue();
                                textPlay.setValue(value);
                                break;
                            case "fee":
                                textPlayValue = textPlay.getValue();
                                String fee = textPlayValue.replace("{$fee}", value);
                                textPlay.setValue(fee);
                                break;
                            case "duration":
                                textPlayValue = textPlay.getValue();
                                String duration = textPlayValue.replace("{$duration}", value);
                                textPlay.setValue(duration);
                                break;
                            case "date":
                                textPlayValue = textPlay.getValue();
                                String date = textPlayValue.replace("{$date}", value);
                                textPlay.setValue(date);
                                break;
                            default:
                                ExceptionCast.cast(CommonCode.INVALID_PARAM,"传入的dataType类型暂不支持");
                        }
                        textPlay.setStatus(1);
                    }
                    textPlayList.put(item.getKey(), textPlay);
                }
                break;
            case "voice":
                Map<Integer, VoicePlay> voicePlayList = showContent.getVoicePlay();
                for (Map.Entry<Integer, VoicePlay> item: voicePlayList.entrySet()){
                    if(textPlayValue!=null){
                        continue;
                    }
                    VoicePlay voicePlay = null;
                    if(!(item.getValue() instanceof VoicePlay)){
                        voicePlay = BeanUtils.deepMapToBean(VoicePlay.class.newInstance().getClass(), (Map) item.getValue());
                    }else{
                        voicePlay = item.getValue();
                    }
                    if(voicePlay.getStatus()== 0 && valueType.equals(voicePlay.getType())){
                        switch (valueType){
                            case "plaintext":
                                textPlayValue = voicePlay.getValue();
                                voicePlay.setValue(value);
                                break;
                            case "fee":
                                textPlayValue = voicePlay.getValue();
                                String fee = textPlayValue.replace("{$fee}", value);
                                voicePlay.setValue(fee);
                                break;
                            case "duration":
                                textPlayValue = voicePlay.getValue();
                                String duration = textPlayValue.replace("{$duration}", value);
                                voicePlay.setValue(duration);
                                break;
                            case "date":
                                textPlayValue = voicePlay.getValue();
                                String date = textPlayValue.replace("{$date}", value);
                                voicePlay.setValue(date);
                                break;
                            default:
                                ExceptionCast.cast(CommonCode.INVALID_PARAM,"传入的valueType类型暂不支持");
                        }
                        voicePlay.setStatus(1);
                    }
                    voicePlayList.put(item.getKey(), voicePlay);
                }
                break;
            default:
                ExceptionCast.cast(CommonCode.INVALID_PARAM,"传入的dataType类型暂不支持");
        }
    }

    /**
     * 根据播放规则进行制作 显示和播报 指令
     * @param zhenShiResponse911202002050
     * @param playRule
     * @param scenes
     * @param validityPeriod 下发的内容有效期 默认为"临时-temporary"，permanent-永久
     * @throws Exception
     */
    public static ZhenShiResponse911202002050 setSerialDataZhenshiByPlayRule(ZhenShiResponse911202002050 zhenShiResponse911202002050, PlayRule playRule, String scenes, String validityPeriod)throws Exception{

        if(StringUtils.isEmpty(validityPeriod)){
            validityPeriod = SeriaDataUtils.VALIDITYPERIOD_TEMPORARY;
        }

        switch (scenes){
            case "approach":
                //入场
                ShowContent approach = playRule.getApproach();
                SeriaDataUtils.setSerialDataZhenshiByShowContent(zhenShiResponse911202002050, approach, validityPeriod);
                break;
            case "payOut":
                //缴费出场
                ShowContent payOut = playRule.getPayOut();
                SeriaDataUtils.setSerialDataZhenshiByShowContent(zhenShiResponse911202002050, payOut, validityPeriod);
                break;
            case "freeOut":
                //免停出场
                ShowContent freeOut = playRule.getFreeOut();
                SeriaDataUtils.setSerialDataZhenshiByShowContent(zhenShiResponse911202002050, freeOut, validityPeriod);
                break;
            case "abnormalOut":
                //异常出场
                ShowContent abnormalOut = playRule.getAbnormalOut();
                SeriaDataUtils.setSerialDataZhenshiByShowContent(zhenShiResponse911202002050, abnormalOut, validityPeriod);
                break;
            default:
                ExceptionCast.cast(CommonCode.INVALID_PARAM,"传入的命令场景不支持:"+scenes);
        }
        return zhenShiResponse911202002050;
    }

    /**
     * 根据播放规则进行制作 显示和播报 指令
     * @param   huaXiaResponse
     * @param playRule
     * @param scenes
     * @param validityPeriod
     * @throws Exception
     */
    public static void setSerialDataHuaXiaByPlayRule(HuaXiaResponse huaXiaResponse, PlayRule playRule, String scenes, String validityPeriod)throws Exception{

        switch (scenes){
            case "approach":
                //入场
                ShowContent approach = playRule.getApproach();
                SeriaDataUtils.setSerialDataHuaXiaByShowContent(huaXiaResponse, approach, validityPeriod);
                break;
            case "payOut":
                //缴费出场
                ShowContent payOut = playRule.getPayOut();
                SeriaDataUtils.setSerialDataHuaXiaByShowContent(huaXiaResponse, payOut, validityPeriod);
                break;
            case "freeOut":
                //免停出场
                ShowContent freeOut = playRule.getFreeOut();
                SeriaDataUtils.setSerialDataHuaXiaByShowContent(huaXiaResponse, freeOut, validityPeriod);
                break;
            case "abnormalOut":
                //异常出场
                ShowContent abnormalOut = playRule.getAbnormalOut();
                SeriaDataUtils.setSerialDataHuaXiaByShowContent(huaXiaResponse, abnormalOut, validityPeriod);
                break;
            default:
                ExceptionCast.cast(CommonCode.INVALID_PARAM,"传入的命令场景不支持:"+scenes);
        }
    }

    public static void setSerialDataZhenshiByShowContent(ZhenShiResponse911202002050 zhenShiResponse911202002050, ShowContent showContent, String validityPeriod) throws Exception{
        //文本
        Map<String,TextPlay> textPlayList = showContent.getTextPlay();

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

                row = new Integer(item.getKey());

            if(textPlay.getStatus()==1 && StringUtils.isNotEmpty(textPlay.getValue())){
                SeriaDataUtils.setSerialDataZhenshi(zhenShiResponse911202002050,textPlay.getValue(),serialChannel,row.byteValue(),textPlay.getColor(),textPlay.getInMode(),textPlay.getOutMode(),showContent.getDeviceModel(),"text","", validityPeriod);
            }
        }
        //语音
        Map<Integer, VoicePlay> voicePlayList = showContent.getVoicePlay();
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
                SeriaDataUtils.setSerialDataZhenshi(zhenShiResponse911202002050,voicePlay.getValue(),serialChannel,row.byteValue(),"","","",showContent.getDeviceModel(),"voice",voicePlay.getPlayMode(), validityPeriod);
            }
        }
    }

    public static void setSerialDataHuaXiaByShowContent(HuaXiaResponse huaXiaResponse, ShowContent showContent, String validityPeriod) throws Exception{
        //文本
        Map<String,TextPlay> textPlayList = showContent.getTextPlay();

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

            if(textPlay.getStatus()==1 && StringUtils.isNotEmpty(textPlay.getValue())){
                SeriaDataUtils.setSerialDataHuaXia(huaXiaResponse,textPlay.getValue(),serialChannel,row.byteValue(),textPlay.getColor(),textPlay.getInMode(),textPlay.getOutMode(),showContent.getDeviceModel(),"text","", validityPeriod);
            }
        }
        //语音
        Map<Integer, VoicePlay> voicePlayList = showContent.getVoicePlay();
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
                SeriaDataUtils.setSerialDataHuaXia(huaXiaResponse,voicePlay.getValue(),serialChannel,row.byteValue(),"","","",showContent.getDeviceModel(),"voice",voicePlay.getPlayMode(),validityPeriod);
            }
        }
    }


    /**
     * 设置臻识SerialData 文本数据
     * @param zhenShiResponse911202002050 臻识相机响应实体
     * @param content 要显示的内容
     * @param serialChannel 通道号
     * @param row 行号
     * @param color 颜色
     * @param inMode 文本内容进入模式
     * @param outMode 文本内容退出模式
     * @param deviceModel 显示屏控制主板型号
     * @param dataType 数据类型
     * @param voicePlayMode 语音播放模式
     * @return
     */
    public static ZhenShiResponse911202002050 setSerialDataZhenshi(ZhenShiResponse911202002050 zhenShiResponse911202002050, String content, Integer serialChannel, byte row, String color, String inMode, String outMode, String deviceModel, String dataType, String voicePlayMode, String validityPeriod) throws Exception{
        byte[] data1 = SeriaDataUtils.setSerialData(content, serialChannel, row, color, inMode, outMode, deviceModel, dataType, voicePlayMode, validityPeriod);
        SerialData serialData = new SerialData();
        String data2=new String(data1);

        serialData.setSerialChannel(serialChannel);
        serialData.setData(data2);
        serialData.setDataLen(data2.length());
        if(zhenShiResponse911202002050.getResponse_AlarmInfoPlate()==null){
            zhenShiResponse911202002050.setResponse_AlarmInfoPlate(new Response_AlarmInfoPlate());
        }
        if(zhenShiResponse911202002050.getResponse_AlarmInfoPlate().getSerialData()==null){
            ArrayList<SerialData> serialDatas = new ArrayList<>();
            zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setSerialData(serialDatas);
        }
        zhenShiResponse911202002050.getResponse_AlarmInfoPlate().getSerialData().add(serialData);
        return zhenShiResponse911202002050;
    }

    /**
     * 设置臻识SerialData 文本数据
     * @param huaXiaResponse 华夏相机响应实体
     * @param content 要显示的内容
     * @param serialChannel 通道号
     * @param row 行号
     * @param color 颜色
     * @param inMode 文本内容进入模式
     * @param outMode 文本内容退出模式
     * @param deviceModel 显示屏控制主板型号
     * @param dataType 数据类型
     * @param voicePlayMode 语音播放模式
     * @return
     */
    public static HuaXiaResponse setSerialDataHuaXia(HuaXiaResponse huaXiaResponse, String content, Integer serialChannel, byte row, String color, String inMode, String outMode, String deviceModel, String dataType, String voicePlayMode, String validityPeriod) throws Exception{
        byte[] data1 = SeriaDataUtils.setSerialData(content, serialChannel, row, color, inMode, outMode, deviceModel, dataType, voicePlayMode, validityPeriod);
        SerialData serialData = new SerialData();
        String data2=new String(data1);

        if(huaXiaResponse.getRs485_data()==null){
            ArrayList<Rs485Data> serialDatas = new ArrayList<>();
            huaXiaResponse.setRs485_data(serialDatas);
        }
        Rs485Data rs485Data = new Rs485Data();
        rs485Data.setData(data2);
        rs485Data.setEncodetype("base64");  //可选值  hex2string 和 base64
        huaXiaResponse.getRs485_data().add(rs485Data);
        return huaXiaResponse;
    }

    public static byte[] setSerialData(String content, Integer serialChannel, byte row, String color, String inMode, String outMode, String deviceModel, String dataType, String voicePlayMode, String validityPeriod) throws Exception{
        byte[] data= null;
        switch (deviceModel){
            case "VXXX-P50H-X":
                if(dataType.equals("text")){
                    //颜色
                    String colorString = null;
                    switch (color){
                        case "red":
                            colorString = "20";
                            break;
                        default:
                            throw new Exception("color code not support");
                    }
                    //进出模式 立即退出20  从右向左移入(出)21  向下向上移入(出)25
                    String inModeString = null;
                    switch (inMode){
                        case "in_quit":
                            inModeString = "20";
                            break;
                        case "in_right_to_left":
                            inModeString = "21";
                            break;
                        case "in_buttom_to_top":
                            inModeString = "25";
                            break;
                        default:
                            throw new Exception("color code not support");
                    }
                    String outModeString = null;
                    switch (outMode){
                        case "out_quit":
                            outModeString = "20";
                            break;
                        case "out_right_to_left":
                            outModeString = "21";
                            break;
                        case "out_buttom_to_top":
                            outModeString = "25";
                            break;
                        default:
                            throw new Exception("color code not support");
                    }
                    data = getVXXXP50HX485Data(content, "2"+row, "2"+(row-(byte)1), colorString,inModeString, outModeString);
                }else if(dataType.equals("voice")){
                    data = getVXXXP50HX485VoiceData(content);
                }else if(dataType.equals("voice_setting")){
                    data = getVXXXP50HX485VoiceSettingData("");
                }
                break;
            case "miu_new":
                if(dataType.equals("text")){
                    //行号 00 第3行 01第4行  02第1行  03第2行
                    String rowStr = null;
                    switch (row){
                        case (byte)1:
                            rowStr = "00";
                            break;
                        case (byte)2:
                            rowStr = "01";
                            break;
                        case (byte)3:
                            rowStr = "02";
                            break;
                        case (byte)4:
                            rowStr = "03";
                            break;
                        case (byte)5:
                            rowStr = "04";
                            break;
                        case (byte)6:
                            rowStr = "05";
                            break;
                        case (byte)7:
                            rowStr = "06";
                            break;
                        case (byte)8:
                            rowStr = "07";
                            break;
                        case (byte)9:
                            rowStr = "08";
                            break;
                        case (byte)10:
                            rowStr = "09";
                            break;
                        case (byte)11:
                            rowStr = "0A";
                            break;
                        case (byte)12:
                            rowStr = "0B";
                            break;
                        case (byte)13:
                            rowStr = "0C";
                            break;
                        case (byte)14:
                            rowStr = "0D";
                            break;
                        case (byte)15:
                            rowStr = "0E";
                            break;
                        case (byte)16:
                            rowStr = "0F";
                            break;
                        case (byte)17:
                            rowStr = "10";
                            break;
                    }
                    data = getMIUNEW485Data(content, rowStr, color, inMode, outMode, validityPeriod);
                }else if(dataType.equals("voice")){
                    String voicePlayModeStr = null;
                    switch (voicePlayMode){
                        case "only_add":    //只是添加不播放
                            voicePlayModeStr = "00";
                            break;
                        case "add_and_play":    //添加并播放
                            voicePlayModeStr = "01";
                            break;
                        case "clean_and_add_play":  //先清除，然后添加，播放
                            voicePlayModeStr = "02";
                            break;
                    }
                    data = getMIUNEW485VoiceData(content, voicePlayModeStr, validityPeriod);
                }else if(dataType.equals("voice_setting")){
                    data = getVXXXP50HX485VoiceSettingData("");
                }
                break;
            default:
                throw new Exception("deviceModel not support!");
        }
        return Base64.encodeBase64(data);
    }

    /**
     * 获取VXXX-P50H-X显示屏485文字内容
     * @param content   显示内容
     * @param row   行号
     * @param sector   扇区
     * @param color 颜色
     * @param inMode   文字显示进入模式
     * @param outMode   文字显示退出模式
     * @return
     */
    public static byte[] getVXXXP50HX485Data(String content, String row, String sector,String color,String inMode, String outMode){
        byte[] bb=null;
        try {
            bb = content.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] data=null;
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //AB 19 02 02 20 25 FC 0C 21 20 2E 21 28 BB B6 D3 AD B9 E2 C1 D9 03 22 23 21 20 03

//        buf.put((byte)0xAB);buf.put((byte)0x19);buf.put((byte)0x02);buf.put((byte)0x02);buf.put((byte)0x20);
//        buf.put((byte)0x25);buf.put((byte)0xFC);buf.put((byte)0x0C);buf.put((byte)0x21);buf.put((byte)0x20);
//        buf.put((byte)0x2E);buf.put((byte)0x21);buf.put((byte)0x28);buf.put((byte)0xBB);buf.put((byte)0xB6);
//        buf.put((byte)0xD3);buf.put((byte)0xAD);buf.put((byte)0xB9);buf.put((byte)0xE2);buf.put((byte)0xC1);
//        buf.put((byte)0xD9);buf.put((byte)0x03);buf.put((byte)0x23);buf.put((byte)0x23);buf.put((byte)0x21);
//        buf.put((byte)0x20);
//        String yihuo = yihuo("0323232120");
//        buf.put(hexStringToByteArray(yihuo));//从异或前一字节算起5字节异或校验。



        //485标准包头
        buf.put((byte)0xAB);
        buf.put((byte)0x19);
        buf.put((byte)0x02);
        buf.put((byte)0x02);

        buf.put((byte)0x20);//机器地址
        buf.put((byte)0x25);//命令  文本25
        buf.put(hexStringToByteArray(sector));//扇区 0x20—0x23表示将内容下载到第0—3扇区，第一行内容保存在第0扇区，第二行内容保存在第1扇区，第三行内容保存在第2扇区，第四行内容保存在第3扇区
        buf.put((byte)0x0C);//预留 暂时固定0C
        buf.put(hexStringToByteArray(inMode));//进入模式 立即退出20  从右向左移入21  向下向上移入25
        buf.put((byte)0x20);//保留时间H
        buf.put((byte)0x2E);//保留时间L
        buf.put(hexStringToByteArray(outMode));//退出模式 立即退出20 从右向左移出21  向下向上移出25
        //数据长度
        String bc = Integer.toHexString(bb.length+32);
        buf.put(hexStringToByteArray(bc));
        //发送内容
        buf.put(bb);
        //包尾标记
        buf.put((byte)0x03);//帧尾
        buf.put(hexStringToByteArray(row));//行号  显示屏行号表示(0x21~0x24)
        buf.put((byte)0x23);//表示第一屏显示内容停留时间。0x20~0xFF代表 0~223秒
        buf.put((byte)0x21);//表示内容移动速度。（0x20-0x27八级速度调节，数值越小速度越快）。
        buf.put(hexStringToByteArray(color));//表示当前一条信息显示的颜色，从0x20开始。
        //异或校验
        String yihuo = yihuo("03"+row+"2321"+color);
        buf.put(hexStringToByteArray(yihuo));//从异或前一字节算起5字节异或校验。

        buf.flip();
        int len=buf.remaining();
        data=new byte[len];
        System.arraycopy(buf.array(), 0, data, 0, len);
        return data;
    }

    /**
     * 获取缪总新主板显示屏485文字内容
     * @param content   显示内容
     * @param row   行号
     * @param color 颜色
     * @param inMode   文字显示进入模式
     * @param outMode   文字显示退出模式
     * @return
     */
    public static byte[] getMIUNEW485Data(String content, String row,String color,String inMode, String outMode, String validityPeriod) throws Exception{
        byte[] bb=null;
        try {
            bb = content.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] data=null;
        byte[] check= new byte[100];
        ByteBuffer buf=ByteBuffer.allocate(1024);
        // 00 64 FF FF 62 25 00 15 01 00 02 15 01 03 00 FF 00 00 00 00 00 00 00 12 00 BB B6 D3 AD
        //B9 E2 C1 D9 C7 EB C8 EB B3 A1 CD A3 B3 B5 F4 F5

        //485标准包头
        buf.put((byte)0x00);check[0] = (byte)0x00;
        buf.put((byte)0x64);check[1] = (byte)0x64;
        buf.put((byte)0xFF);check[2] = (byte)0xFF;
        buf.put((byte)0xFF);check[3] = (byte)0xFF;
        if(validityPeriod.equals("temporary")){
            //临时内容
            buf.put((byte)0x62);check[4] = (byte)0x62;
        }else if(validityPeriod.equals("permanent")){
            //永久内容
            buf.put((byte)0x67);check[4] = (byte)0x67;
        }


        String bc = Integer.toHexString(bb.length+19); //数据长度  19个字节+文本长度
        byte[] bytes0 = hexStringToByteArray(bc);
        buf.put(hexStringToByteArray(bc));
        int index = 4;
        for(byte byteItem: bytes0){
            index++;
            check[index] = byteItem;
        }

        index++;
        buf.put(hexStringToByteArray(row));check[index] = hexStringToByteArray(row)[0];    //行号

        if(validityPeriod.equals("permanent")){
            index++;
            buf.put((byte)0x00);check[index] = (byte)0x00;    //为文件的 ID，用于指定操作的文本文件。取值范围为 0~1。
            index++;
            buf.put((byte)0x0C);check[index] = (byte)0x0C;    //为文本文件的属性标志位。目前没有用到，固定取值为 0X0C。
        }
        /**
         * 0x00 立即显示
         * 0x01 从右向左移动
         * 0x02 从左向右移动
         * 0x03 从下向上移动
         * 0x04 从上向下移动
         * 0x05 向下拉窗
         * 0x06 向上拉窗
         * 0x07 向左拉窗
         * 0x08 向右拉窗
         * 0x0D 逐字显示
         * 0x15 连续左移
         */
        String inModeStr = null;
        switch (inMode){
            case "show_now":
                inModeStr = "00";
                break;
            case "right_to_left":
                inModeStr = "01";
                break;
            case "left_to_right":
                inModeStr = "02";
                break;
            case "buttom_to_top":
                inModeStr = "03";
                break;
            case "top_to_buttom":
                inModeStr = "04";
                break;
            case "to_buttom":
                inModeStr = "05";
                break;
            case "to_top":
                inModeStr = "06";
                break;
            case "to_left":
                inModeStr = "07";
                break;
            case "to_right":
                inModeStr = "08";
                break;
            case "one_by_one":
                inModeStr = "0D";
                break;
            case "continuous_to_left":
                inModeStr = "15";
                break;
            default:
                throw new Exception("direction code not support");
        }
        String outModeStr = null;
        switch (outMode){
            case "show_now":
                outModeStr = "00";
                break;
            case "right_to_left":
                outModeStr = "01";
                break;
            case "left_to_right":
                outModeStr = "02";
                break;
            case "buttom_to_top":
                outModeStr = "03";
                break;
            case "top_to_buttom":
                outModeStr = "04";
                break;
            case "to_buttom":
                outModeStr = "05";
                break;
            case "to_top":
                outModeStr = "06";
                break;
            case "to_left":
                outModeStr = "07";
                break;
            case "to_right":
                outModeStr = "08";
                break;
            case "one_by_one":
                outModeStr = "0D";
                break;
            case "continuous_to_left":
                outModeStr = "15";
                break;
            default:
                throw new Exception("direction code not support");
        }
        index++;
        buf.put(hexStringToByteArray(inModeStr));check[index] = hexStringToByteArray(inModeStr)[0];    //文字进入窗口的方式
        index++;
        buf.put((byte)0x01);check[index] = (byte)0x01;    //文字进入速度  1~32
        index++;
        buf.put((byte)0x00);check[index] = (byte)0x00;    //为文字停留的方式。目前作为保留值固定为 0。
        index++;
        buf.put((byte)0x02);check[index] = (byte)0x02;    //为文字停留的时间。取值范围为 0 ~255
        index++;
        buf.put(hexStringToByteArray(outModeStr));check[index] = hexStringToByteArray(outModeStr)[0];   //文字退出窗口的方式(取值参考 文字进入窗口的方式)
        index++;
        buf.put((byte)0x01);check[index] = (byte)0x01;    //文字退出速度  1~32
        index++;
        buf.put((byte)0x03);check[index] = (byte)0x03;   //为文字的字体索引值,目前作为保留值固定为 3
        if(validityPeriod.equals("temporary")){
            //临时内容
            index++;
            buf.put((byte)0x0A);check[index] = (byte)0x0A;   //为显示的次数。取值范围为 0~255,当为 0 的时，表示无限循环显示
        }

        //为文字的颜色值。存储结构为 R G B A 三基色，各占 8 位，R 表示红色分量，G 表示
        //绿色分量,B 表示蓝色分量，A 目前没用使用，作为保留字。各取值范围为 0~255
        switch (color){
            case "red":
                index++;
                buf.put((byte)0xFF);check[index] = (byte)0xFF;
                index++;
                buf.put((byte)0x00);check[index] = (byte)0x00;
                index++;
                buf.put((byte)0x00);check[index] = (byte)0x00;
                index++;
                buf.put((byte)0x00);check[index] = (byte)0x00;
                break;
            case "green":
                index++;
                buf.put((byte)0x00);check[index] = (byte)0x00;
                index++;
                buf.put((byte)0xFF);check[index] = (byte)0xFF;
                index++;
                buf.put((byte)0x00);check[index] = (byte)0x00;
                index++;
                buf.put((byte)0x00);check[index] = (byte)0x00;
                break;
            case "yellow":
                index++;
                buf.put((byte)0xFF);check[index] = (byte)0xFF;
                index++;
                buf.put((byte)0xFF);check[index] = (byte)0xFF;
                index++;
                buf.put((byte)0x00);check[index] = (byte)0x00;
                index++;
                buf.put((byte)0x00);check[index] = (byte)0x00;
                break;
            default:
                throw new Exception("color code not support");
        }

        //为背景的颜色值。存储结构为 R G B A 三基色，各占 8 位，R 表示红色分量，G 表
        //示绿色分量,B 表示蓝色分量，A 目前没用使用，作为保留字。各取值范围为 0~255
        index++;
        buf.put((byte)0x00);check[index] = (byte)0x00;
        index++;
        buf.put((byte)0x00);check[index] = (byte)0x00;
        index++;
        buf.put((byte)0x00);check[index] = (byte)0x00;
        index++;
        buf.put((byte)0x00);check[index] = (byte)0x00;

        //文本长度
        String bc2 = lowHigh(bb.length);
        index++;
        buf.put(hexStringToByteArray(bc2.substring(0,2)));check[index] = hexStringToByteArray(bc2.substring(0,2))[0];
        index++;
        buf.put(hexStringToByteArray(bc2.substring(2,4)));check[index] = hexStringToByteArray(bc2.substring(2,4))[0];

        //发送内容
        buf.put(bb);
        for(byte byteItem2: bb){
            index++;
            check[index] = byteItem2;
        }
        byte[] check2 = new byte[index+1];
        for(int i=0; i<=index; i++){
            check2[i] = check[i];
        }
        //数据校验
        String crc = getCRC3(check2);
        buf.put(hexStringToByteArray(crc.substring(0,2)));
        buf.put(hexStringToByteArray(crc.substring(2,4)));

        buf.flip();
        int len=buf.remaining();
        data=new byte[len];
        System.arraycopy(buf.array(), 0, data, 0, len);
        return data;
    }

    /**
     * 显示臻识相机led广告
     * @param row 行号
     * @param fileId 文件id
     */
    public static ZhenShiResponse911202002050 showZhenShiAd(ZhenShiResponse911202002050 zhenShiResponse911202002050,String row, String fileId){
        byte[] check= new byte[100];
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //485标准包头
        buf.put((byte)0x00);check[0] = (byte)0x00;
        buf.put((byte)0x64);check[1] = (byte)0x64;
        buf.put((byte)0xFF);check[2] = (byte)0xFF;
        buf.put((byte)0xFF);check[3] = (byte)0xFF;
        buf.put((byte)0x68);check[4] = (byte)0x68;
        buf.put((byte)0x02);check[5] = (byte)0x02;
        buf.put(hexStringToByteArray(row));check[6] = hexStringToByteArray(row)[0];    //行号
        buf.put(hexStringToByteArray(row));check[7] = hexStringToByteArray(fileId)[0];    //文件id

        byte[] check2 = new byte[8];
        for(int i=0; i<=7; i++){
            check2[i] = check[i];
        }
        //数据校验
        String crc = getCRC3(check2);
        buf.put(hexStringToByteArray(crc.substring(0,2)));
        buf.put(hexStringToByteArray(crc.substring(2,4)));

        buf.flip();
        int len=buf.remaining();
        byte[] data = new byte[len];
        System.arraycopy(buf.array(), 0, data, 0, len);

        SerialData serialData = new SerialData();

        String data2=new String(data,StandardCharsets.ISO_8859_1);;

        serialData.setSerialChannel(0);
        serialData.setData(data2);
        serialData.setDataLen(data2.length());
        if(zhenShiResponse911202002050.getResponse_AlarmInfoPlate()==null){
            zhenShiResponse911202002050.setResponse_AlarmInfoPlate(new Response_AlarmInfoPlate());
        }
        if(zhenShiResponse911202002050.getResponse_AlarmInfoPlate().getSerialData()==null){
            ArrayList<SerialData> serialDatas = new ArrayList<>();
            zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setSerialData(serialDatas);
        }
        zhenShiResponse911202002050.getResponse_AlarmInfoPlate().getSerialData().add(serialData);
        return zhenShiResponse911202002050;
    }

    /**
     * 获取缪总新主板显示屏485语音内容
     * @param content   播报内容
     * @param palyMode   播放模式
     * @param validityPeriod   下发的内容有效期 默认为"临时-temporary"，permanent-永久
     * @return
     */
    public static byte[] getMIUNEW485VoiceData(String content, String palyMode, String validityPeriod){
        byte[] bb=null;
        try {
            bb = content.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] data=null;
        byte[] check= new byte[100];
        ByteBuffer buf=ByteBuffer.allocate(1024);
        // 00 64 FF FF 62 25 00 15 01 00 02 15 01 03 00 FF 00 00 00 00 00 00 00 12 00 BB B6 D3 AD
        //B9 E2 C1 D9 C7 EB C8 EB B3 A1 CD A3 B3 B5 F4 F5

        //485标准包头
        buf.put((byte)0x00);check[0] = (byte)0x00;
        //判断内容有效期
        if(validityPeriod.equals(SeriaDataUtils.VALIDITYPERIOD_PERMANENT)){
            buf.put((byte)0x67);check[1] = (byte)0x67;
        }else{
            buf.put((byte)0x64);check[1] = (byte)0x64;
        }

        buf.put((byte)0xFF);check[2] = (byte)0xFF;
        buf.put((byte)0xFF);check[3] = (byte)0xFF;
        buf.put((byte)0x30);check[4] = (byte)0x30;

        String bc = Integer.toHexString(bb.length+1); //数据长度  1个字节+文本长度
        bc = bc.length()==1?"0"+bc:bc;
        byte[] bytes0 = hexStringToByteArray(bc);
        buf.put(hexStringToByteArray(bc));
        int index = 4;
            for(byte byteItem: bytes0){
            index++;
            check[index] = byteItem;
        }

        /**
         * 0x00 添加到语音队列但是不开始播放
         * 0x01 添加到语音队列并且开始播放
         * 0x02 先清除队列，再添加新语音到队列，然后开始播放
         */
        index++;
        buf.put(hexStringToByteArray(palyMode));check[index] = hexStringToByteArray(palyMode)[0];

        //发送内容
        buf.put(bb);
        for(byte byteItem2: bb){
            index++;
            check[index] = byteItem2;
        }
        byte[] check2 = new byte[index+1];
        for(int i=0; i<=index; i++){
            check2[i] = check[i];
        }
        //数据校验
        String crc = getCRC3(check2);
        buf.put(hexStringToByteArray(crc.substring(0,2)));
        buf.put(hexStringToByteArray(crc.substring(2,4)));

        buf.flip();
        int len=buf.remaining();
        data=new byte[len];
        System.arraycopy(buf.array(), 0, data, 0, len);
        return data;
    }

    /**
     * 获取VXXX-P50H-X显示屏485语音内容
     * @param content   播报内容
     * @return
     */
    public static byte[] getVXXXP50HX485VoiceData(String content){

        //AB 10 BB 42 42 FA FA

        byte[] bb=null;
        try {
            bb = content.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] data=null;
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //485标准包头
        buf.put((byte)0xAB);
        buf.put((byte)0x10);
        buf.put((byte)0xBB);
        buf.put((byte)0x42);
        buf.put((byte)0x42);
        buf.put((byte)0xFA);
        buf.put((byte)0xFA);
        buf.put((byte)0x00);

        //数据长度
        String bc = Integer.toHexString(bb.length+32);
        buf.put(hexStringToByteArray(bc));
        //发送内容
        buf.put(bb);

        buf.flip();
        int len=buf.remaining();
        data=new byte[len];
        System.arraycopy(buf.array(), 0, data, 0, len);
        return data;
    }

    /**
     * 获取VXXX-P50H-X显示屏485语音设置内容
     * @param content   播报内容
     * @return
     */
    public static byte[] getVXXXP50HX485VoiceSettingData(String content){

        //AB 0B BB 42 42 88 88 05 0A 01 E8 04 B0

        byte[] bb=null;
        byte[] data=null;
        ByteBuffer buf=ByteBuffer.allocate(1024);
        buf.put((byte)0xAB);
        buf.put((byte)0x0B);
        buf.put((byte)0xBB);
        buf.put((byte)0x42);
        buf.put((byte)0x42);
        buf.put((byte)0x88);
        buf.put((byte)0x88);
        buf.put((byte)0x05);
        buf.put((byte)0x0A);
        buf.put((byte)0x01);
        buf.put((byte)0xE8);
        buf.put((byte)0x04);
        buf.put((byte)0xB0);
        buf.flip();
        int len=buf.remaining();
        data=new byte[len];
        System.arraycopy(buf.array(), 0, data, 0, len);
        return data;
    }

    /**
     * 10进制转16进制 高低转换 高前 低后   并且转2字节
     * @param var0
     * @return
     */
    public static String lowHigh(int var0) {
        int var1 = 1;
        int var2 = var0 >> 8;
        int var3 = var0 & 255;
        String var4 = Integer.toHexString(var2);
        String var5 = Integer.toHexString(var3);
        if(var4.length() > 2) {
            do {
                if(var1 > 1) {
                    var2 >>= 8;
                }
                var4 = Integer.toHexString(var2 >> 8);
                var5 = var5 + Integer.toHexString(var2 & 255);
                ++var1;
            } while(var4.length() > 2);
        }
        if(var4.length() < 2) {
            var4 = "0" + var4;
        }
        if(var5.length() < 2) {
            var5 = "0" + var5;
        }
        return var5 + var4;
    }

    //16进制字符异或
    public static String yihuo(String content) {
        content = change(content);
        String[] b = content.split(" ");
        int a = 0;
        for (int i = 0; i < b.length; i++) {
            a = a ^ Integer.parseInt(b[i], 16);
        }
        if(a<10){
            StringBuffer sb = new StringBuffer();
            sb.append("0");
            sb.append(a);
            return sb.toString();
        }
        return Integer.toHexString(a);
    }

    public static String change(String content) {
        String str = "";
        for (int i = 0; i < content.length(); i++) {
            if (i % 2 == 0) {
                str += " " + content.substring(i, i + 1);
            } else {
                str += content.substring(i, i + 1);
            }
        }
        return str.trim();
    }

    /**
     * 16进制字符串转换byte[]
     * @param s
     * @return
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] b = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
                    .digit(s.charAt(i + 1), 16));
        }
        return b;
    }

    /**
     * 计算CRC16校验码
     *
     * @param bytes
     * @return
     */
    public static String getCRC(byte[] bytes) {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;

        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= ((int) bytes[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        return Integer.toHexString(CRC);
    }

    public static String getCRC2(byte[] bytes) {
//        ModBus 通信协议的 CRC ( 冗余循环校验码含2个字节, 即 16 位二进制数。
//        CRC 码由发送设备计算, 放置于所发送信息帧的尾部。
//        接收信息设备再重新计算所接收信息 (除 CRC 之外的部分）的 CRC,
//        比较计算得到的 CRC 是否与接收到CRC相符, 如果两者不相符, 则认为数据出错。
//
//        1) 预置 1 个 16 位的寄存器为十六进制FFFF(即全为 1) , 称此寄存器为 CRC寄存器。
//        2) 把第一个 8 位二进制数据 (通信信息帧的第一个字节) 与 16 位的 CRC寄存器的低 8 位相异或, 把结果放于 CRC寄存器。
//        3) 把 CRC 寄存器的内容右移一位( 朝低位)用 0 填补最高位, 并检查右移后的移出位。
//        4) 如果移出位为 0, 重复第 3 步 ( 再次右移一位); 如果移出位为 1, CRC 寄存器与多项式A001 ( 1010 0000 0000 0001) 进行异或。
//        5) 重复步骤 3 和步骤 4, 直到右移 8 次,这样整个8位数据全部进行了处理。
//        6) 重复步骤 2 到步骤 5, 进行通信信息帧下一个字节的处理。
//        7) 将该通信信息帧所有字节按上述步骤计算完成后,得到的16位CRC寄存器的高、低字节进行交换。
//        8) 最后得到的 CRC寄存器内容即为 CRC码。

        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;

        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= (int) bytes[i];
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) == 1) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        //高低位转换，看情况使用（譬如本人这次对led彩屏的通讯开发就规定校验码高位在前低位在后，也就不需要转换高低位)
        //CRC = ( (CRC & 0x0000FF00) >> 8) | ( (CRC & 0x000000FF ) << 8);
        return Integer.toHexString(CRC);
    }


    /**
     * 查表法计算CRC16校验
     *
     * @param data 需要计算的字节数组
     */
    public static String getCRC3(byte[] data) {
        byte[] crc16_h = {
                (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
                (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
                (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40
        };

        byte[] crc16_l = {
                (byte) 0x00, (byte) 0xC0, (byte) 0xC1, (byte) 0x01, (byte) 0xC3, (byte) 0x03, (byte) 0x02, (byte) 0xC2, (byte) 0xC6, (byte) 0x06, (byte) 0x07, (byte) 0xC7, (byte) 0x05, (byte) 0xC5, (byte) 0xC4, (byte) 0x04,
                (byte) 0xCC, (byte) 0x0C, (byte) 0x0D, (byte) 0xCD, (byte) 0x0F, (byte) 0xCF, (byte) 0xCE, (byte) 0x0E, (byte) 0x0A, (byte) 0xCA, (byte) 0xCB, (byte) 0x0B, (byte) 0xC9, (byte) 0x09, (byte) 0x08, (byte) 0xC8,
                (byte) 0xD8, (byte) 0x18, (byte) 0x19, (byte) 0xD9, (byte) 0x1B, (byte) 0xDB, (byte) 0xDA, (byte) 0x1A, (byte) 0x1E, (byte) 0xDE, (byte) 0xDF, (byte) 0x1F, (byte) 0xDD, (byte) 0x1D, (byte) 0x1C, (byte) 0xDC,
                (byte) 0x14, (byte) 0xD4, (byte) 0xD5, (byte) 0x15, (byte) 0xD7, (byte) 0x17, (byte) 0x16, (byte) 0xD6, (byte) 0xD2, (byte) 0x12, (byte) 0x13, (byte) 0xD3, (byte) 0x11, (byte) 0xD1, (byte) 0xD0, (byte) 0x10,
                (byte) 0xF0, (byte) 0x30, (byte) 0x31, (byte) 0xF1, (byte) 0x33, (byte) 0xF3, (byte) 0xF2, (byte) 0x32, (byte) 0x36, (byte) 0xF6, (byte) 0xF7, (byte) 0x37, (byte) 0xF5, (byte) 0x35, (byte) 0x34, (byte) 0xF4,
                (byte) 0x3C, (byte) 0xFC, (byte) 0xFD, (byte) 0x3D, (byte) 0xFF, (byte) 0x3F, (byte) 0x3E, (byte) 0xFE, (byte) 0xFA, (byte) 0x3A, (byte) 0x3B, (byte) 0xFB, (byte) 0x39, (byte) 0xF9, (byte) 0xF8, (byte) 0x38,
                (byte) 0x28, (byte) 0xE8, (byte) 0xE9, (byte) 0x29, (byte) 0xEB, (byte) 0x2B, (byte) 0x2A, (byte) 0xEA, (byte) 0xEE, (byte) 0x2E, (byte) 0x2F, (byte) 0xEF, (byte) 0x2D, (byte) 0xED, (byte) 0xEC, (byte) 0x2C,
                (byte) 0xE4, (byte) 0x24, (byte) 0x25, (byte) 0xE5, (byte) 0x27, (byte) 0xE7, (byte) 0xE6, (byte) 0x26, (byte) 0x22, (byte) 0xE2, (byte) 0xE3, (byte) 0x23, (byte) 0xE1, (byte) 0x21, (byte) 0x20, (byte) 0xE0,
                (byte) 0xA0, (byte) 0x60, (byte) 0x61, (byte) 0xA1, (byte) 0x63, (byte) 0xA3, (byte) 0xA2, (byte) 0x62, (byte) 0x66, (byte) 0xA6, (byte) 0xA7, (byte) 0x67, (byte) 0xA5, (byte) 0x65, (byte) 0x64, (byte) 0xA4,
                (byte) 0x6C, (byte) 0xAC, (byte) 0xAD, (byte) 0x6D, (byte) 0xAF, (byte) 0x6F, (byte) 0x6E, (byte) 0xAE, (byte) 0xAA, (byte) 0x6A, (byte) 0x6B, (byte) 0xAB, (byte) 0x69, (byte) 0xA9, (byte) 0xA8, (byte) 0x68,
                (byte) 0x78, (byte) 0xB8, (byte) 0xB9, (byte) 0x79, (byte) 0xBB, (byte) 0x7B, (byte) 0x7A, (byte) 0xBA, (byte) 0xBE, (byte) 0x7E, (byte) 0x7F, (byte) 0xBF, (byte) 0x7D, (byte) 0xBD, (byte) 0xBC, (byte) 0x7C,
                (byte) 0xB4, (byte) 0x74, (byte) 0x75, (byte) 0xB5, (byte) 0x77, (byte) 0xB7, (byte) 0xB6, (byte) 0x76, (byte) 0x72, (byte) 0xB2, (byte) 0xB3, (byte) 0x73, (byte) 0xB1, (byte) 0x71, (byte) 0x70, (byte) 0xB0,
                (byte) 0x50, (byte) 0x90, (byte) 0x91, (byte) 0x51, (byte) 0x93, (byte) 0x53, (byte) 0x52, (byte) 0x92, (byte) 0x96, (byte) 0x56, (byte) 0x57, (byte) 0x97, (byte) 0x55, (byte) 0x95, (byte) 0x94, (byte) 0x54,
                (byte) 0x9C, (byte) 0x5C, (byte) 0x5D, (byte) 0x9D, (byte) 0x5F, (byte) 0x9F, (byte) 0x9E, (byte) 0x5E, (byte) 0x5A, (byte) 0x9A, (byte) 0x9B, (byte) 0x5B, (byte) 0x99, (byte) 0x59, (byte) 0x58, (byte) 0x98,
                (byte) 0x88, (byte) 0x48, (byte) 0x49, (byte) 0x89, (byte) 0x4B, (byte) 0x8B, (byte) 0x8A, (byte) 0x4A, (byte) 0x4E, (byte) 0x8E, (byte) 0x8F, (byte) 0x4F, (byte) 0x8D, (byte) 0x4D, (byte) 0x4C, (byte) 0x8C,
                (byte) 0x44, (byte) 0x84, (byte) 0x85, (byte) 0x45, (byte) 0x87, (byte) 0x47, (byte) 0x46, (byte) 0x86, (byte) 0x82, (byte) 0x42, (byte) 0x43, (byte) 0x83, (byte) 0x41, (byte) 0x81, (byte) 0x80, (byte) 0x40
        };

        int crc = 0x0000ffff;
        int ucCRCHi = 0x00ff;
        int ucCRCLo = 0x00ff;
        int iIndex;
        for (int i = 0; i < data.length; ++i) {
            iIndex = (ucCRCLo ^ data[i]) & 0x00ff;
            ucCRCLo = ucCRCHi ^ crc16_h[iIndex];
            ucCRCHi = crc16_l[iIndex];
        }

        crc = ((ucCRCHi & 0x00ff) << 8) | (ucCRCLo & 0x00ff) & 0xffff;
        //高低位互换，输出符合相关工具对Modbus CRC16的运算
        crc = ( (crc & 0xFF00) >> 8) | ( (crc & 0x00FF ) << 8);
        return String.format("%04X", crc);
    }


    /**
     * 汉字转化成区位码
     *
     * @param str
     * @return
     * @throws Exception
     */
    private static int[] getQuweiMa(String str) {
        byte[] b = new byte[0];
        try {
            b = str.getBytes("gb2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int[] quwei = new int[b.length / 2];
        for (int i = 0, k = b.length / 2; i < k; i++) {
            quwei[i] = (((b[2 * i] - 0xA0) & 0xff) * 100) + ((b[2 * i + 1] - 0xA0) & 0xff);
        }
        return quwei;
    }


    /**
     * 转换成机内码
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static String string2JiNeiMa(String str) {
        int[] quwei = getQuweiMa(str);
        String s = "";
        for (int i : quwei) {
            s += i + ",";
        }

        String[] stringArray = s.split(",");

        StringBuffer jineima = new StringBuffer();
        for (String ss : stringArray) {

            String hex1 = Integer.toHexString(Integer.parseInt(ss.substring(0, 2)));
            String NewHex1 = hex1.length() > 1 ? hex1 : "0" + hex1;

            String hex2 = Integer.toHexString(Integer.parseInt(ss.substring(2, 4)));
            String NewHex2 = hex2.length() > 1 ? hex2 : "0" + hex2;

            long x1 = Long.parseLong(NewHex1, 16);
            long x2 = Long.parseLong(NewHex2, 16);
            long y = Long.parseLong("A0", 16);

            jineima.append((Long.toHexString(x1 + y).toUpperCase()) + (Long.toHexString(x2 + y).toUpperCase())).append(",");
        }
        return jineima.substring(0, jineima.length() - 1).toString();
    }


}
