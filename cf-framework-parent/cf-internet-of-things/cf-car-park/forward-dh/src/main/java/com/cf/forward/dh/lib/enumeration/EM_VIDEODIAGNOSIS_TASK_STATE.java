package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 任务运行状态
 * @date 2021/2/22
 */
public enum EM_VIDEODIAGNOSIS_TASK_STATE {
  /** 未知 */
  EM_VIDEODIAGNOSIS_TASK_STATE_UNKNOWN(-1, "未知"),
  /** 未开始 */
  EM_VIDEODIAGNOSIS_TASK_STATE_NOT_STARTED(0, "未开始"),
  /** 运行中 */
  EM_VIDEODIAGNOSIS_TASK_STATE_ONGOING(1, "运行中"),
  /** 未完成 */
  EM_VIDEODIAGNOSIS_TASK_STATE_INCOMPLETE(2, "未完成"),
  /** 已完成 */
  EM_VIDEODIAGNOSIS_TASK_STATE_COMPLETED(3, "已完成");

  EM_VIDEODIAGNOSIS_TASK_STATE(int state, String desc) {
    this.state = state;
    this.desc = desc;
  }

  private int state;
  private String desc;

  public int getState() {
    return state;
  }

  public String getDesc() {
    return desc;
  }

  public EM_VIDEODIAGNOSIS_TASK_STATE getTaskState(int state) {
    for (EM_VIDEODIAGNOSIS_TASK_STATE taskState : EM_VIDEODIAGNOSIS_TASK_STATE.values()) {
      if (taskState.state == state) {
        return taskState;
      }
    }
    return EM_VIDEODIAGNOSIS_TASK_STATE_UNKNOWN;
  }
}
