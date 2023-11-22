package com.cf.carpark.service.vzenith.cloud.model.stp.route;

import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;
import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.util.RandomUtil;

public class RouteClientRequest extends BaseRequest {

  public enum ConnectionType {
    TCP,
    TLS,
    WS,
    WSS,
  }

  /**
   * @param sid 由用户自定义的client标识，可以为任何数字和字母的组合。一般在同一个用户下唯一。
   *            如果同一用户下使用相同标识，会导致mqtt连接反复断开重连。
   */
  public RouteClientRequest(String sid) {
    super(HttpMethod.GET, API.ROUTE_CLIENT);
    addParam("sid", sid);
  }

  /**
   * @deprecated 随机生成字符串存在出现两个相同的sid的风险
   */
  @Deprecated
  public RouteClientRequest() {
    super(HttpMethod.GET, "/openapi/v1/stp/clients/route");
    addParam("sid", RandomUtil.GetString(12));
  }

  /**
   * 设置返回的连接信息中按照哪种连接方式生成
   *
   * @param type 连接类型，默认为 TCP
   */

  public void setConnectionType(ConnectionType type) {
    switch (type) {
      case TCP:
        addParam("type", "tcp");
        break;
      case TLS:
        addParam("type", "tls");
        break;
      case WS:
        addParam("type", "ws");
        break;
      case WSS:
        addParam("type", "wss");
        break;
    }
  }
}
