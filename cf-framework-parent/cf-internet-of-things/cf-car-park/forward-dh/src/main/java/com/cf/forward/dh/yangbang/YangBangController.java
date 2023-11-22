package com.cf.forward.dh.yangbang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.*;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author 武汉才风智慧科技有限公司-Wuhan Caifeng Smart Technology Co., Ltd
 * @Linker +86 18086495676 Mr Wang 18086495676@163.com
 * @date 2022-12-06
 * @Version cfzh Smarter Cities V3.0
 */
public class YangBangController {

    /**
     * 显示文字
     * @param contents
     */
    public static void showText(String ip, Integer port, List<String> contents) throws Exception{
        List<BxArea> areas = new ArrayList<BxArea>();
        byte id = 0x00;
        short x = 0;
        short y = 0;
        short w = 64;
        short h = 16;
        int index = 0;
        String voiceText = "";
        for(int i=contents.size()-1; i>0; i--){
            x = 0/8;
            y = (new Integer(index*16)).byteValue();
            w = 64/8;
            h = 16;
            byte[] data;
            try {
                data = contents.get(index).getBytes("gb2312");
                //五代K卡最后一个参数给true、非5代的给false
                BxAreaDynamic area = new BxAreaDynamic((new Integer(i)).byteValue(), x, y, w, h, data, false);
                voiceText += ","+contents.get(index);
                if(index==(contents.size()-2)){
                    byte[] soundData = voiceText.substring(1).getBytes("gb2312");

                    //
                    // 语音模式
                    area.setSoundMode((byte) 0x02);
                    // 人声模式
                    area.setSoundPerson((byte) 0x00);
                    // 重复次数
                    area.setSoundRepeat((byte) 0x03);
                    // 发音速度
                    area.setSoundSpeed((byte) 0x02);
                    // 音量
                    area.setSoundVolume((byte) 10);
                    // 要发声的文字，仅在 soundMode = 0x02时有效
                    area.setSoundData(soundData);
                }



                // 显示方式，其定义如下：
                // 0x01——静止显示
                // 0x02——快速打出
                // 0x03——向左移动
                // 0x04——向右移动
                // 0x05——向上移动
                // 0x06——向下移动
                // 设置显示方式为 0x03 - 向左移动
                area.setDispMode((byte) 0x03);
                area.setSpeed((byte) 0x23);
                // 设置停留时间
                area.setHoldTime((byte) 2);
                areas.add(area);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            index++;
        }

        // 创建一个发送动态区命令
        BxCmd cmd = new BxCmdSendDynamicArea(areas);

        // 对命令进行封装
        BxDataPack dataPack = new BxDataPack(cmd);

        // 生成命令序列
        byte[] seq = dataPack.pack();


        //
        // 创建 Socket
        Socket client = new Socket();

        //
        // 创建 socket 地址
        SocketAddress address = new InetSocketAddress(ip, port);


        try {
            //
            // 建立 TCP 连接
            client.connect(address, 3000);
            //
            // 设置读超时时间
            client.setSoTimeout(3000);

            //
            // 创建输出流
            OutputStream out = client.getOutputStream();

            //
            // 创建输入流
            InputStream in = client.getInputStream();

            // 写入数据
            out.write(seq);

            //
            // 回读返回帧
            byte[] resp = new byte[1024];
            int len = in.read(resp);

            //
            // parse
            BxResp bxResp = BxResp.parse(resp, len);

            //
            // 判断命令是否被正确执行
            if(bxResp.isAck()) {
//                System.out.println("Well done!!");
            }
            else {
//                System.out.println("I am sorry!");
            }

            //
            // 关机
            BxCmd cmdTurnOff = new BxCmdTurnOnOff(false);
            BxDataPack packTurnOff = new BxDataPack(cmdTurnOff);
            byte[] seqTurnOff = packTurnOff.pack();
            out.write(seqTurnOff);
            len = in.read(resp);
            bxResp = BxResp.parse(resp, len);
            if(bxResp.isAck()) {
//                System.out.println("turn off, ok");
            }
            else {
//                System.out.println("turn off, failed");
            }

            //
            // 开机
            BxCmd cmdTurnOn = new BxCmdTurnOnOff(true);
            BxDataPack packTurnOn = new BxDataPack(cmdTurnOn);
            byte[] seqTurnOn = packTurnOn.pack();
            out.write(seqTurnOn);
            len = in.read(resp);
            bxResp = BxResp.parse(resp, len);
            if(bxResp.isAck()) {
//                System.out.println("turn on, ok");
            }
            else {
//                System.out.println("turn on, failed");
            }

            //校时
            BxCmd systime = new BxCmdSystemClockCorrect(new Date());
            BxDataPack timePack = new BxDataPack(systime);
            byte[] seqtime = timePack.pack();
            out.write(seqtime);
            len = in.read(resp);
            bxResp = BxResp.parse(resp, len);
            if(bxResp.isAck()) {
//                System.out.println("system clock correct, ok");
            }
            else {
//                System.out.println("system clock correct, failed");
            }

            /*
            //
            // 生成节目
            String str = "1234";
            BxArea area1 = new BxAreaDynamic((byte)0, (short)0, (short)0, (short)64, (short)32, str.getBytes("gb2312"));
            List<BxArea> pareas = new ArrayList<BxArea>();
            pareas.add(area1);

            // 节目文件
            BxFileProgram program = new BxFileProgram(0, pareas);
            byte[] pfile = program.build();
            */

            //
            // 清屏
            BxCmd cmdClearScreen = new BxCmdClearScreen();
            BxDataPack packClearScreen = new BxDataPack(cmdClearScreen);
            byte[] seqClearScreen = packClearScreen.pack();

            out.write(seqClearScreen);
            len = in.read(resp);
            bxResp = BxResp.parse(resp, len);
            if(bxResp.isAck()) {
//                System.out.println("clear screen, ok");
            }
            else {
//                System.out.println("clear screen, failed");
            }


            //
            out.close();
            in.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
