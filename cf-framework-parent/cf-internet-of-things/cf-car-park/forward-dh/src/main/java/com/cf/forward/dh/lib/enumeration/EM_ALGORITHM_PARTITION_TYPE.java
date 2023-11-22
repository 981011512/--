package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 分区类型
 * @date 2021/2/20
 */
public enum EM_ALGORITHM_PARTITION_TYPE {
  /** 未知 */
  EM_ALGORITHM_PARTITION_UNKNOWN,
  /** ext4分区 */
  EM_ALGORITHM_PARTITION_EXT4,
  /** suqshfs分区 */
  EM_ALGORITHM_PARTITION_SUQSHFS,
  /** ubifs分区 */
  EM_ALGORITHM_PARTITION_UBIFS;

  public static EM_ALGORITHM_PARTITION_TYPE getAlgorithmPartitionType(int type) {
    for (EM_ALGORITHM_PARTITION_TYPE partitionType : EM_ALGORITHM_PARTITION_TYPE.values()) {
      if (partitionType.ordinal() == type) {
        return partitionType;
      }
    }
    return EM_ALGORITHM_PARTITION_UNKNOWN;
  }
}
