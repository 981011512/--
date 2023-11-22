package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 诊断结果状态
 * @date 2021/2/22
 */
public enum EM_COLLECTIVITY_STATE {
  /** 成功 */
  EM_COLLECTIVITY_STATE_SUCCESSED,
  /** 失败 */
  EM_COLLECTIVITY_STATE_FAILED;

  /**
   * 默认返回failed
   * @param state
   * @return
   */
  public EM_COLLECTIVITY_STATE getCollectivityState(int state) {
    for (EM_COLLECTIVITY_STATE collectivityState : EM_COLLECTIVITY_STATE.values()) {
      if (collectivityState.ordinal() == state) {
        return collectivityState;
      }
    }
    return EM_COLLECTIVITY_STATE_FAILED;
  }
}
