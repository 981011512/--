package com.cf.carpark.service.vzenith.cloud.model.stp.video;

import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;

public class VideoVurlRequest extends BaseRequest {

  public enum StreamType {
    FLV,
    RTSP,
  }

  public enum Channel {
    MAIN, // 主码流，效果较好，带宽占用较大
    SUB, // 子码流，效果一般，带宽占用较小
  }

  /**
   * @param sn   目标设备的SN
   * @param type 流类型
   */
  public VideoVurlRequest(String sn, StreamType type) {
    super(HttpMethod.GET, API.VIDEO_VURL);
    addParam("sn", sn);

    switch (type) {
      case FLV:
        addParam("type", "flv");
        break;
      case RTSP:
        addParam("type", "rtsp");
        break;
    }
  }

  /**
   * 设置通道，当 StreamType 为 rtsp 时才有效
   *
   * @param channel 通道
   */
  public void setChannel(Channel channel) {
    switch (channel) {
      case MAIN:
        addParam("channel", "main");
        break;
      case SUB:
        addParam("channel", "sub");
        break;
    }
  }
}
