package com.cf.carpark.service.vzenith.cloud.model.stp.pdns;

import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;
import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.util.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PdnsWebRequest extends BaseRequest {

  private static final Logger logger = LoggerFactory.getLogger(PdnsWebRequest.class);

  public enum ResultType {
    JSON, // 返回 JSON 形式的结果，包含 URL 和其他更多信息
    TEXT, // 返回字符串形式的 URL ，推荐
    URL, // 直接重定向，在 Java SDK 中不推荐
  }

  /**
   * @param sn 目标设备SN
   */
  public PdnsWebRequest(String sn) {
    super(HttpMethod.GET, API.PDNS_WEB);
    addParam("sn", sn);
  }

  /**
   * 设置服务器返回的结果的样式
   *
   * @param type 结果样式，默认 TEXT
   */
  public void setResultType(ResultType type) {
    switch (type) {
      case URL:
        addParam("type", "text");
        break;
      case JSON:
        addParam("type", "json");
        break;
      case TEXT:
        addParam("type", "url");
        break;
    }
  }

  /**
   * 设置设备登录信息
   *
   * @param deviceUsername  设备登录用户名
   * @param devicePassword  设备登录密码
   * @param accesskeySecret accesskeySecret, 请使用和 client 中的 accesskeySecret
   */
  public void setUserInfo(String deviceUsername, String devicePassword, String accesskeySecret) {
    String userInfo = EncryptUtil.encryptUserInfo(deviceUsername, devicePassword, accesskeySecret);
    if (userInfo == null) {
      logger.warn("Encrypt userInfo \"{}:{}\" failed, accesskeySecret: {}",
        deviceUsername,
        devicePassword,
        accesskeySecret);
      return;
    }
    addParam("userinfo", userInfo);
  }
}
