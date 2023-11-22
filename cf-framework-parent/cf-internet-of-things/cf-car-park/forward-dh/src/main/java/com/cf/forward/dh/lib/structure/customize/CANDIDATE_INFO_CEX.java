package com.cf.forward.dh.lib.structure.customize;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.Utils;
import com.cf.forward.dh.lib.structure.NET_TIME;

import java.nio.charset.Charset;

/**
 * @author 47081
 * @version 1.0
 * @description 候选人信息拓展结构体(定制)
 * @date 2021/3/17
 */
public class CANDIDATE_INFO_CEX extends NetSDKLib.SdkStructure {
  /** 姓名 */
  public byte[] szPersonName = new byte[64];
  /** 人员唯一标示(身份证号码,工号,或其他编号) */
  public byte[] szID = new byte[32];
  /** 和查询图片的相似度,百分比表示,1~100 */
  public byte bySimilarity;
  /** 人员所属数据库范围,详见EM_FACE_DB_TYPE */
  public byte byRange;
  /** 当byRange为历史数据库时有效,表示查询人员出现的时间 */
  public NET_TIME stTime;
  /** 当byRange为历史数据库时有效,表示查询人员出现的地点 */
  public byte[] szAddress = new byte[260];
  /** 是否有识别结果,指这个检测出的人脸在库中有没有比对结果 */
  public boolean bIsHit;
  /** 通道号 */
  public int nChannelID;

  public String getPersonName() {
    return new String(szPersonName, Charset.forName(Utils.getPlatformEncode())).trim();
  }

  public String getID() {
    return new String(szID, Charset.forName(Utils.getPlatformEncode())).trim();
  }

  public String getAddress() {
    return new String(szAddress, Charset.forName(Utils.getPlatformEncode())).trim();
  }

  @Override
  public String toString() {
    return "CANDIDATE_INFO_CEX{"
        + "szPersonName="
        + getPersonName()
        + ", szID="
        + getID()
        + ", bySimilarity="
        + bySimilarity
        + ", byRange="
        + byRange
        + ", stTime="
        + stTime
        + ", szAddress="
        + getAddress()
        + ", bIsHit="
        + bIsHit
        + ", nChannelID="
        + nChannelID
        + '}';
  }
}
