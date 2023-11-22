package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
import com.cf.forward.dh.lib.enumeration.EM_CUSTOM_DEV_PROTOCOL_TYPE;

/**
 * CLIENT_AsyncAddCustomDevice 接口输入参数
 *
 * @author 119178
 */
public class NET_IN_ASYNC_ADD_CUSTOM_DEVICE extends SdkStructure {

  public int dwSize;
  /** 端口号 */
  public int nPort;
  /** 设备地址或者域名 */
  public byte[] szAddress = new byte[128];
  /** 用户名 */
  public byte[] szUserName = new byte[128];
  /** 密码 */
  public byte[] szPassword = new byte[128];
  /** 接入设备协议类型,对应枚举{@link EM_CUSTOM_DEV_PROTOCOL_TYPE} */
  public int emProtocolType;
  /** 上述列表实际填写的有效通道数 */
  public int nRemoteChannelNum;
  /** 远程通道号数组，如果是IPC就数组大小为1 */
  public int[] nRemoteChannels = new int[512];
  /** 是否设置逻辑起始通道,FALSE代表随机通道作为起始通道 */
  public int bSetLogicChannelStart;
  /** 逻辑通道起始通道,设置bSetLogicChannelStart为TRUE时生效 */
  public int nLogicChannelStart;
  /** 视频输入信息 */
  public NET_CUSTOM_DEV_VIDEO_INPUTS stuVideoInput;

  public NET_IN_ASYNC_ADD_CUSTOM_DEVICE() {
    this.dwSize = this.size();
  }
}
