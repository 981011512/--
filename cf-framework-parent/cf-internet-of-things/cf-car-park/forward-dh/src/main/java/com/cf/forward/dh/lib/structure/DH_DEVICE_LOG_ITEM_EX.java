package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import java.nio.charset.Charset;

/**
 * 新日志信息结构,对应接口CLIENT_QueryDeviceLog接口
 * @author 47081
 */
public class DH_DEVICE_LOG_ITEM_EX extends NetSDKLib.SdkStructure {
    /**
     * 日志类型
     */
    public int                 nLogType;
    /**
     * 日期
     */
    public DHDEVTIME           stuOperateTime;
    /**
     * 操作者
     */
    public byte[]              szOperator=new byte[16];
    public byte[]              bReserved=new byte[3];
    /**
     *  union结构类型对应结构体NET_STU_LOG,
     * 0:stuLog.szLogContext；
     * 1:stuLog.stuOldLog。
     */
    public byte                bUnionType;
    /**
     * 具体的操作内容
     *//*
    public NET_STU_LOG         stuLog;*/
    public byte[]              szLogContext=new byte[64];
    public byte[]              szOperation=new byte[32];
    /**
     * 详细日志信息描述
     */
    public byte[]              szDetailContext=new byte[4*1024];

    /**
     * 操作者,默认编码集UTF-8
     * @return 操作者名称
     */
    public String getOperator(){return getOperator(Charset.forName("UTF_8"));}
    public String getOperator(Charset charset){
        return new String(szOperation,charset);
    }

    /**
     * 操作日期
     * @return
     */
    public String getDate(){
        return stuOperateTime.getDate();
    }

    /**
     * 操作
     * @return
     */
    public String getOperation(){ return getOperation(Charset.forName("UTF_8"));}
    public String getOperation(Charset charset){return new String(szOperation,charset);}
    /**
     * 具体操作内容
     * @return
     */
    public String getLog(){return getLog(Charset.forName("UTF_8"));}
    public String getLog(Charset charset){
        return new String(szLogContext,charset);
    }

    /**
     * 详细日志信息描述
     * @return
     */
    public String getDetailLog(){return getDetailLog(Charset.forName("UTF_8"));}
    public String getDetailLog(Charset charset){
        return new String(szDetailContext,charset);
    }
}
