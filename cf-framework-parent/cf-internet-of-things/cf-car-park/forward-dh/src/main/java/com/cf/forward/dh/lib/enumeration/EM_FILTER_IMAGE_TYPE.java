package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 返回的图片类型
 * @date 2021/2/20
 */
public enum EM_FILTER_IMAGE_TYPE {
  /** 未知 */
  EM_FILTER_IMAGE_UNKNOWN,
  /** 上报目标抠图 */
  EM_FILTER_IMAGE_OBJECT,
  /** 上报场景大图 */
  EM_FILTER_IMAGE_SCENE;

  public static EM_FILTER_IMAGE_TYPE getFilterImageType(int type) {
    for (EM_FILTER_IMAGE_TYPE imageType : EM_FILTER_IMAGE_TYPE.values()) {
      if (imageType.ordinal() == type) {
        return imageType;
      }
    }
    return EM_FILTER_IMAGE_UNKNOWN;
  }
}
