package com.cf.carpark.service.vzenith.cloud.model.stp.device;

import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.model.common.ScanRequest;

public class DeviceScanRequest extends ScanRequest {

  /**
   * 设备列表
   * <p>
   * wheres允许添加以下字段:
   * sn, name, local_ip,global_ip, region, stp_version, soft_version, board_version,
   * series_name, product_name, state, addition, remark, last_online_time, last_offline_time,
   * create_time
   */
  public DeviceScanRequest() {
    super(API.DEVICE_SCAN);
  }

  public void scanByGroup(int groupId) {
    params.put("group_id", String.valueOf(groupId));
  }

}
