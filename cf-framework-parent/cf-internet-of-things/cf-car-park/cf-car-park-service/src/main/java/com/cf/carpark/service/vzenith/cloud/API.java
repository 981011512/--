package com.cf.carpark.service.vzenith.cloud;

public class API {
  final public static String OPENAPI_PREFIX = "/openapi/v1";

  /**
   * 臻云极致 AI 接口
   */
  // 车牌识别（国内）接口
  final public static String PRS_CN_DETECT = OPENAPI_PREFIX + "/prs_cn/user/apps/:app_id/plates/detect";

  /**
   * 臻云极致运维/管理（stp）接口
   */
  // 设备基本接口
  final public static String DEVICE_SCAN                  = OPENAPI_PREFIX + "/stp/user/devices";
  final public static String DEVICE_BIND                  = OPENAPI_PREFIX + "/stp/user/devices";
  final public static String DEVICE_UNBIND                = OPENAPI_PREFIX + "/stp/user/devices";
  // 固件基本接口
  final public static String FIRMWARE_SCAN                = OPENAPI_PREFIX + "/stp/firmwares";
  final public static String FIRMWARE_GET                 = OPENAPI_PREFIX + "/stp/firmwares/:version";
  final public static String FIRMWARE_DOWNLOAD            = OPENAPI_PREFIX + "/stp/firmwares/:version/file";
  // 图片下载接口
  final public static String IMAGE_DOWNLOAD               = OPENAPI_PREFIX + "/imgs/:sn/:date/:filename";
  // 云存接口
  final public static String CLOUDSTORAGE_SEARCH          = OPENAPI_PREFIX + "/stp/user/devices/cloudstorage/search";
  final public static String CLOUDSTORAGE_SEARCH_BY_MONTH = OPENAPI_PREFIX + "/stp/user/devices/cloudstorage/search_mouth";
  final public static String CLOUDSTORAGE_DOWNLOAD        = OPENAPI_PREFIX + "/stp/user/devices/cloudstorage/download";
  final public static String CLOUDSTORAGE_PLAY            = OPENAPI_PREFIX + "/stp/user/devices/cloudstorage/play";
  final public static String CLOUDSTORAGE_PLAY_INFO       = OPENAPI_PREFIX + "/stp/user/devices/cloudstorage/play/info";
  // MQTT 操作接口
  final public static String MQTT_DP_MESSAGE              = OPENAPI_PREFIX + "/stp/user/devices/dp/message";
  final public static String MQTT_DP_REQUEST              = OPENAPI_PREFIX + "/stp/user/devices/dp/request";
  // 远程访问接口
  final public static String PDNS_TELNET                  = OPENAPI_PREFIX + "/stp/user/devices/pdns/telnet";
  final public static String PDNS_WEB                     = OPENAPI_PREFIX + "/stp/user/devices/pdns/web";
  // MQTT 路由接口
  final public static String ROUTE_CLIENT                 = OPENAPI_PREFIX + "/stp/clients/route";
  // 设备升级接口
  final public static String UPGRADE_CREATE               = OPENAPI_PREFIX + "/stp/user/devices/upgrades";
  final public static String UPGRADE_LATEST               = OPENAPI_PREFIX + "/stp/user/devices/:sn/upgrades/latest";
  final public static String UPGRADE_DOWNLOAD             = OPENAPI_PREFIX + "/stp/user/devices/:sn/upgrades/:upgrade_id/file";
  final public static String UPGRADE_CANCEL               = OPENAPI_PREFIX + "/stp/user/devices/:sn/upgrades/:upgrade_id";
  // 视频取流接口
  final public static String VIDEO_VURL                   = OPENAPI_PREFIX + "/stp/user/devices/vurl";
}
