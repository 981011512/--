package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 通行模式
 * @date 2021/2/7
 */
public enum EM_PASS_MODE {
  /** 未知 */
  EM_PASS_MODE_UNKNOWN(-1, "未知"),
  /** 进授权出授权 */
  EM_PASS_MODE_IN_AUTHORIZATION_OUT_AUTHORIZATION(0, "进授权出授权"),
  /** 进授权出自由 */
  EM_PASS_MODE_IN_AUTHORIZATION_OUT_FREE(1, "进授权出自由"),
  /** 进授权出禁止 */
  EM_PASS_MODE_IN_AUTHORIZATION_OUT_FORBID(2, "进授权出禁止"),
  /** 进自由出授权 */
  EM_PASS_MODE_IN_FREE_OUT_AUTHORIZATION(3, "进自由出授权"),
  /** 进自由出自由 */
  EM_PASS_MODE_IN_FREE_OUT_FREE(4, "进自由出自由"),
  /** 进自由出禁止 */
  EM_PASS_MODE_IN_FREE_OUT_FORBID(5, "进自由出禁止"),
  /** 进禁止出授权 */
  EM_PASS_MODE_IN_FORBID_OUT_AUTHORIZATION(6, "进禁止出授权"),
  /** 进禁止出自由 */
  EM_PASS_MODE_IN_FORBID_OUT_FREE(7, "进禁止出自由"),
  /** 进禁止出禁止 */
  EM_PASS_MODE_IN_FORBID_OUT_FORBID(8, "进禁止出禁止");

  private int mode;
  private String desc;
  EM_PASS_MODE(int mode, String desc) {
    this.mode = mode;
    this.desc = desc;
  }
}
