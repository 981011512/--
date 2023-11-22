package com.cf.carpark.service.vzenith.cloud.model.stp.firmware;

import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.model.common.ScanRequest;

public class FirmwareScanRequest extends ScanRequest {


  /**
   * 固件列表
   * <p>
   * wheres允许添加以下字段:
   * id, version, filepath, custom, remark, create_time
   */

  public FirmwareScanRequest() {
    super(API.FIRMWARE_SCAN);
  }

}
