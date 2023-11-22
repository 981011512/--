package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 操作错误码
 * @date 2021/3/31
 */
public enum NET_EM_FAILCODE {
  NET_EM_FAILCODE_NOERROR(0, "没有错误"),
  NET_EM_FAILCODE_UNKNOWN(1, "未知错误"),
  NET_EM_FAILCODE_INVALID_PARAM(2, "参数错误"),
  NET_EM_FAILCODE_INVALID_PASSWORD(3, "无效密码"),
  NET_EM_FAILCODE_INVALID_FP(4, "无效指纹数据"),
  NET_EM_FAILCODE_INVALID_FACE(5, "无效人脸数据"),
  NET_EM_FAILCODE_INVALID_CARD(6, "无效卡数据"),
  NET_EM_FAILCODE_INVALID_USER(7, "无效人数据"),
  NET_EM_FAILCODE_FAILED_GET_SUBSERVICE(8, "能力集子服务获取失败"),
  NET_EM_FAILCODE_FAILED_GET_METHOD(9, "获取组件的方法集失败"),
  NET_EM_FAILCODE_FAILED_GET_SUBCAPS(10, "获取资源实体能力集失败"),
  NET_EM_FAILCODE_ERROR_INSERT_LIMIT(11, "已达插入上限"),
  NET_EM_FAILCODE_ERROR_MAX_INSERT_RATE(12, "已达最大插入速度"),
  NET_EM_FAILCODE_FAILED_ERASE_FP(13, "清除指纹数据失败"),
  NET_EM_FAILCODE_FAILED_ERASE_FACE(14, "清除人脸数据失败"),
  NET_EM_FAILCODE_FAILED_ERASE_CARD(15, "清除卡数据失败"),
  NET_EM_FAILCODE_NO_RECORD(16, "没有记录"),
  NET_EM_FAILCODE_NOMORE_RECORD(17, "查找到最后，没有更多记录"),
  NET_EM_FAILCODE_RECORD_ALREADY_EXISTS(18, "下发卡或指纹时，数据重复"),
  NET_EM_FAILCODE_MAX_FP_PERUSER(19, "超过个人最大指纹记录数"),
  NET_EM_FAILCODE_MAX_CARD_PERUSER(20, "超过个人最大卡片记录数"),
  NET_EM_FAILCODE_EXCEED_MAX_PHOTOSIZE(21, "超出最大照片大小"),
  NET_EM_FAILCODE_INVALID_USERID(22, "用户ID无效（未找到客户）"),
  NET_EM_FAILCODE_EXTRACTFEATURE_FAIL(23, "提取人脸特征失败"),
  NET_EM_FAILCODE_PHOTO_EXIST(24, "人脸照片已存在"),
  NET_EM_FAILCODE_PHOTO_OVERFLOW(25, "超出最大人脸照片数"),
  NET_EM_FAILCODE_INVALID_PHOTO_FORMAT(26, "照片格式无效"),
  NET_EM_FAILCODE_EXCEED_ADMINISTRATOR_LIMIT(27, "超出管理员人数限制");
  /** 错误码 */
  private int failCode;
  /** 对应错误信息 */
  private String desc;

  NET_EM_FAILCODE(int failCode, String desc) {
    this.failCode = failCode;
    this.desc = desc;
  }

  public static NET_EM_FAILCODE FailCode(int failCode) {
    for (NET_EM_FAILCODE code : NET_EM_FAILCODE.values()) {
      if (failCode == code.getFailCode()) {
        return code;
      }
    }
    return NET_EM_FAILCODE_UNKNOWN;
  }

  public static String FailCodeMessage(int failCode) {
    return FailCode(failCode).getDesc();
  }

  public int getFailCode() {
    return failCode;
  }

  public void setFailCode(int failCode) {
    this.failCode = failCode;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
