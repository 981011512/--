package com.cf.framework.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ZenithUtils {
    /**
     * 控制设备开闸
     * 不播放语音
     */
    public static void open(HttpServletResponse response) throws IOException {
        // 回复命令，控制设备开闸
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        out.println("{\"Response_AlarmInfoPlate\":{\"info\":\"ok\",\"content\":\"...\",\"is_pay\":\"true\"}}");
        out.flush();
        out.close();
    }


    /**
     * 给显示屏发送文本显示和语音播报功能实现
     * @param response
     * @param plateCodes
     * @param isOpen
     * @throws IOException
     */
    public static void send(HttpServletResponse response, List<PlateCode> plateCodes, Boolean isOpen) throws IOException{
        JsonObject resp=(JsonObject) new JsonParser().parse("{}");
        JsonObject json=(JsonObject)new JsonParser().parse("{}");
        JsonArray jsar=(JsonArray)new JsonParser().parse("[]");
        for (PlateCode plateCode: plateCodes) {
            if(plateCode.getType() == 1){
                //文本
                JsonObject json3=getSerialData(plateCode.getData(),0x02,plateCode.getColor(),plateCode.getRow());
                jsar.add(json3.getAsJsonObject());
            }else if(plateCode.getType() == 2){
                //语音
                JsonObject json4=getSerialReadData(plateCode.getData(),0);
                jsar.add(json4.getAsJsonObject());
            }else{
                continue;
            }
        }

        json.add("serialData", jsar.getAsJsonArray());
        if(isOpen){
            json.addProperty("info", "ok"); //回复开闸端口号，若无，则默认为0
        }
        resp.add("Response_AlarmInfoPlate", json.getAsJsonObject());
//        System.out.println("组合数据:" + resp.toString());

        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
//        System.out.println(resp.toString());
        out.println(resp.toString());
        out.flush();
        out.close();
    }

    /**
     * 给威视设备发送文本信息
     * @param response
     * @param a   单行文本
     * @param b   颜色
     * @param c   第几行
     *
     *  int a=0x02; //0x12 单行文本   0x10 多行文本	 0x52
     *  02010000
     * int b=0x00;  // 颜色
     * int c=0x04;  // 第几行
     */
    public static void sendText(HttpServletResponse response, String content, int a, int b, int c) throws IOException{
        JsonObject json3=getSerialData(content,a,b,c);

//        System.out.println(json3.toString());

        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        String ss="{\"Response_AlarmInfoPlate\": { \"serialData\": ["+json3.toString()+"]}}";
//        System.out.println(ss);
        out.println(ss);
        out.flush();
        out.close();
    }

    public static JsonObject getSerialData(String plate, int a, int b, int c){
        byte[] databb= get485Data(plate, a, b,c);
        byte[] data1= Base64.encodeBase64(databb);
        String data2=new String(data1);
//        System.out.println(data2);
        JsonObject json1=(JsonObject)new JsonParser().parse("{}");

        json1.addProperty("serialChannel", 0);
        json1.addProperty("data",data2 );
        json1.addProperty("dataLen", data2.length());
        return json1;
    }


    /**
     *  给威视发送语音
     * @param response
     * @param voice   语音类容
     * @param b       立即播放 0   顺序播放 1
     * @throws IOException
     */
    public static void sendVoice(HttpServletResponse response, String voice, int b) throws IOException{
        JsonObject json3=getSerialReadData(voice,b);

//        System.out.println(json3.toString());

        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        String ss="{\"Response_AlarmInfoPlate\": { \"serialData\": ["+json3.toString()+"]}}";
//        System.out.println(ss);
        out.println(ss);
        out.flush();
        out.close();
    }

    public static JsonObject getSerialReadData(String voice, int b){
        byte[] databb= get485ReadData(voice,b);
        byte[] data1= Base64.encodeBase64(databb);
        String data2=new String(data1);
//        System.out.println(data2);
        JsonObject json1=(JsonObject)new JsonParser().parse("{}");

        json1.addProperty("serialChannel", 0);
        json1.addProperty("data",data2 );
        json1.addProperty("dataLen", data2.length());
        return json1;
    }


    public static byte[] get485ReadData(String voice,int b){
        byte[] bb=null;
        try {
            bb = voice.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] data=null;
        ByteBuffer buf=ByteBuffer.allocate(1024);
        //AA A5 1D 00 FF FF 00 00 B0 A1 00 07 00 00 00 00 0F 00 5B 76 36 5D 57 4A CF E6 32 36 36 31 42 0D 0A 00 00 5A 55
        //包头标记,根据实际情况处理
        return null;
    }

    //文本指令
    public static byte[] get485Data(String plate, int a,int b,int c){
        //注意，请根据你对应的led厂商对接协议！否则led显示屏可能出现异常
        return null;
    }

    //文本指令
    public static byte[] getAiPai485Data(String plate, int a,int b,int c){
        //注意，请根据你对应的led厂商对接协议！否则语音播报可能出现异常
        return null;
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
     * 出口处设备收费播报
     * @param response
     */
    public static void openDoor( HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData("一路顺风");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        send(response, plateCodeList, true);
    }

    /**
     * 出口处设备收费播报
     * @param license
     * @param response
     */
    public static void openChargeDoor(String license, BigDecimal money, long time, HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData(license + "请缴纳停车费" + money + "元");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        PlateCode plateCode0= new PlateCode();
        plateCode0.setData(license);
        plateCode0.setType(1);
        plateCode0.setRow(1);
        plateCode0.setColor(2);
        plateCodeList.add(plateCode0);

        PlateCode plateCode3= new PlateCode();
        plateCode3.setData("缴费" + money + "元");
        plateCode3.setType(1);
        plateCode3.setRow(2);
        plateCode3.setColor(1);
        plateCodeList.add(plateCode3);

        PlateCode plateCode2 = new PlateCode();
        plateCode2.setData("停车" + time + "分");
        plateCode2.setType(1);
        plateCode2.setRow(3);
        plateCode2.setColor(1);
        plateCodeList.add(plateCode2);

        PlateCode plateCode1 = new PlateCode();
        plateCode1.setData("停车缴费");
        plateCode1.setType(1);
        plateCode1.setRow(4);
        plateCode1.setColor(2);
        plateCodeList.add(plateCode1);

        send(response, plateCodeList, false);
    }

    /**
     * 出口处设备开闸
     * @param license
     * @param response
     */
    public static void openExitDoor(String license, HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData(license + " 祝您一路顺风");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        PlateCode plateCode0= new PlateCode();
        plateCode0.setData(license);
        plateCode0.setType(1);
        plateCode0.setRow(1);
        plateCode0.setColor(2);
        plateCodeList.add(plateCode0);

        PlateCode plateCode1 = new PlateCode();
        plateCode1.setData("一路顺风");
        plateCode1.setType(1);
        plateCode1.setRow(2);
        plateCode1.setColor(2);
        plateCodeList.add(plateCode1);

        PlateCode plateCode2 = new PlateCode();
        plateCode2.setData("自动识别");
        plateCode2.setType(1);
        plateCode2.setRow(3);
        plateCode2.setColor(1);
        plateCodeList.add(plateCode2);

        PlateCode plateCode3= new PlateCode();
        plateCode3.setData("减速慢行");
        plateCode3.setType(1);
        plateCode3.setRow(4);
        plateCode3.setColor(1);
        plateCodeList.add(plateCode3);

        send(response, plateCodeList, true);
    }



    /**
     * 入口处设备开闸
     * @param license
     * @param response
     */
    public static void openEntranceFeeDoor(String license,int num, HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData("外来车辆, 临时停车");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        PlateCode plateCode0= new PlateCode();
        plateCode0.setData(license);
        plateCode0.setType(1);
        plateCode0.setRow(1);
        plateCode0.setColor(2);
        plateCodeList.add(plateCode0);

        PlateCode plateCode1 = new PlateCode();
        plateCode1.setData("车位" + num);
        plateCode1.setType(1);
        plateCode1.setRow(2);
        plateCode1.setColor(2);
        plateCodeList.add(plateCode1);

        PlateCode plateCode2 = new PlateCode();
        plateCode2.setData("自动识别");
        plateCode2.setType(1);
        plateCode2.setRow(3);
        plateCode2.setColor(1);
        plateCodeList.add(plateCode2);

        PlateCode plateCode3= new PlateCode();
        plateCode3.setData("减速慢行");
        plateCode3.setType(1);
        plateCode3.setRow(4);
        plateCode3.setColor(1);
        plateCodeList.add(plateCode3);

        send(response, plateCodeList, true);
    }


    /**
     * 入口处设备开闸
     * @param license
     * @param response
     */
    public static void openEntranceDoor(String license,int num, HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData(license + "欢迎回家");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        PlateCode plateCode0= new PlateCode();
        plateCode0.setData(license);
        plateCode0.setType(1);
        plateCode0.setRow(1);
        plateCode0.setColor(2);
        plateCodeList.add(plateCode0);

        PlateCode plateCode1 = new PlateCode();
        plateCode1.setData("车位" + num);
        plateCode1.setType(1);
        plateCode1.setRow(2);
        plateCode1.setColor(2);
        plateCodeList.add(plateCode1);

        PlateCode plateCode2 = new PlateCode();
        plateCode2.setData("自动识别");
        plateCode2.setType(1);
        plateCode2.setRow(3);
        plateCode2.setColor(1);
        plateCodeList.add(plateCode2);

        PlateCode plateCode3= new PlateCode();
        plateCode3.setData("减速慢行");
        plateCode3.setType(1);
        plateCode3.setRow(4);
        plateCode3.setColor(1);
        plateCodeList.add(plateCode3);

        send(response, plateCodeList, true);
    }


    /**
     * 入口处设备开闸  -- 车位已满 禁止入内
     * @param license
     * @param response
     */
    public static void isFull(String license, HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData(license + "车位已满 禁止入内");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        PlateCode plateCode0= new PlateCode();
        plateCode0.setData(license);
        plateCode0.setType(1);
        plateCode0.setRow(1);
        plateCode0.setColor(2);
        plateCodeList.add(plateCode0);

        PlateCode plateCode1 = new PlateCode();
        plateCode1.setData("车位已满");
        plateCode1.setType(1);
        plateCode1.setRow(2);
        plateCode1.setColor(2);
        plateCodeList.add(plateCode1);

        PlateCode plateCode2 = new PlateCode();
        plateCode2.setData("自动识别");
        plateCode2.setType(1);
        plateCode2.setRow(3);
        plateCode2.setColor(1);
        plateCodeList.add(plateCode2);

        PlateCode plateCode3= new PlateCode();
        plateCode3.setData("减速慢行");
        plateCode3.setType(1);
        plateCode3.setRow(4);
        plateCode3.setColor(1);
        plateCodeList.add(plateCode3);

        send(response, plateCodeList, true);
    }


    /**
     * 入口处设备禁止进入语音  -- 车位达到上线
     * @param license
     * @param response
     */
    public static void openForbidCarNum(String license, HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData(license + "禁止入内 车位数量已满");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        PlateCode plateCode0= new PlateCode();
        plateCode0.setData(license);
        plateCode0.setType(1);
        plateCode0.setRow(1);
        plateCode0.setColor(2);
        plateCodeList.add(plateCode0);

        PlateCode plateCode1 = new PlateCode();
        plateCode1.setData("车位已满");
        plateCode1.setType(1);
        plateCode1.setRow(2);
        plateCode1.setColor(1);
        plateCodeList.add(plateCode1);

        PlateCode plateCode2 = new PlateCode();
        plateCode2.setData("自动识别");
        plateCode2.setType(1);
        plateCode2.setRow(3);
        plateCode2.setColor(2);
        plateCodeList.add(plateCode2);

        PlateCode plateCode3= new PlateCode();
        plateCode3.setData("减速慢行");
        plateCode3.setType(1);
        plateCode3.setRow(4);
        plateCode3.setColor(1);
        plateCodeList.add(plateCode3);

        send(response, plateCodeList, false);
    }


    /**
     * 入口处设备禁止进入语音  -- 封闭模式
     * @param license
     * @param response
     */
    public static void openForbidModel(String license, HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData(license + "车辆禁止入内");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        PlateCode plateCode0= new PlateCode();
        plateCode0.setData(license);
        plateCode0.setType(1);
        plateCode0.setRow(1);
        plateCode0.setColor(2);
        plateCodeList.add(plateCode0);

        PlateCode plateCode1 = new PlateCode();
        plateCode1.setData("禁止入内");
        plateCode1.setType(1);
        plateCode1.setRow(2);
        plateCode1.setColor(1);
        plateCodeList.add(plateCode1);

        PlateCode plateCode2 = new PlateCode();
        plateCode2.setData("自动识别");
        plateCode2.setType(1);
        plateCode2.setRow(3);
        plateCode2.setColor(2);
        plateCodeList.add(plateCode2);

        PlateCode plateCode3= new PlateCode();
        plateCode3.setData("减速慢行");
        plateCode3.setType(1);
        plateCode3.setRow(4);
        plateCode3.setColor(1);
        plateCodeList.add(plateCode3);

        send(response, plateCodeList, false);
    }

    /**
     * 入口处设备过期语音
     * @param license
     * @param response
     */
    public static void openExpire(String license, HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData(license + "您的车牌时间已过期,请去物业办公室处理");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        PlateCode plateCode0= new PlateCode();
        plateCode0.setData(license);
        plateCode0.setType(1);
        plateCode0.setRow(1);
        plateCode0.setColor(2);
        plateCodeList.add(plateCode0);

        PlateCode plateCode1 = new PlateCode();
        plateCode1.setData("车牌过期");
        plateCode1.setType(1);
        plateCode1.setRow(2);
        plateCode1.setColor(1);
        plateCodeList.add(plateCode1);

        PlateCode plateCode2 = new PlateCode();
        plateCode2.setData("自动识别");
        plateCode2.setType(1);
        plateCode2.setRow(3);
        plateCode2.setColor(2);
        plateCodeList.add(plateCode2);

        PlateCode plateCode3= new PlateCode();
        plateCode3.setData("减速慢行");
        plateCode3.setType(1);
        plateCode3.setRow(4);
        plateCode3.setColor(1);
        plateCodeList.add(plateCode3);

        send(response, plateCodeList, false);
    }

    /**
     * 入口处设备禁止进入语音
     * @param license
     * @param response
     */
    public static void openForbid(String license, HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData(license + "外来车辆禁止入内");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        PlateCode plateCode0= new PlateCode();
        plateCode0.setData(license);
        plateCode0.setType(1);
        plateCode0.setRow(1);
        plateCode0.setColor(2);
        plateCodeList.add(plateCode0);

        PlateCode plateCode1 = new PlateCode();
        plateCode1.setData("禁止入内");
        plateCode1.setType(1);
        plateCode1.setRow(2);
        plateCode1.setColor(1);
        plateCodeList.add(plateCode1);

        PlateCode plateCode2 = new PlateCode();
        plateCode2.setData("自动识别");
        plateCode2.setType(1);
        plateCode2.setRow(3);
        plateCode2.setColor(2);
        plateCodeList.add(plateCode2);

        PlateCode plateCode3= new PlateCode();
        plateCode3.setData("减速慢行");
        plateCode3.setType(1);
        plateCode3.setRow(4);
        plateCode3.setColor(1);
        plateCodeList.add(plateCode3);

        send(response, plateCodeList, false);
    }

    /**
     * 特种车牌欢迎入内
     * @param license
     * @param response
     */
    public static void openSpecial(String license, HttpServletResponse response) throws  IOException{
        // 语音播报 -- 开闸
        List<PlateCode> plateCodeList = new ArrayList<>();
        PlateCode plateCode = new PlateCode();
        plateCode.setData(license + "特种车牌自主通行");
        plateCode.setType(2);
        plateCode.setRow(0);
        plateCodeList.add(plateCode);

        PlateCode plateCode0= new PlateCode();
        plateCode0.setData(license);
        plateCode0.setType(1);
        plateCode0.setRow(1);
        plateCode0.setColor(2);
        plateCodeList.add(plateCode0);

        PlateCode plateCode1 = new PlateCode();
        plateCode1.setData("特种车牌");
        plateCode1.setType(1);
        plateCode1.setRow(2);
        plateCode1.setColor(1);
        plateCodeList.add(plateCode1);

        PlateCode plateCode2 = new PlateCode();
        plateCode2.setData("自动识别");
        plateCode2.setType(1);
        plateCode2.setRow(3);
        plateCode2.setColor(0);
        plateCodeList.add(plateCode2);

        PlateCode plateCode3= new PlateCode();
        plateCode3.setData("减速慢行");
        plateCode3.setType(1);
        plateCode3.setRow(4);
        plateCode3.setColor(1);
        plateCodeList.add(plateCode3);

        send(response, plateCodeList, true);
    }
}
