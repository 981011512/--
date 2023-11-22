package com.cf.carpark.service.vzenith.cloud.model.stp.image;

import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;

public class ImageDownloadRequest extends BaseRequest {

  public ImageDownloadRequest(String sn, String date, String filename) {
    super(HttpMethod.GET, API.IMAGE_DOWNLOAD, sn, date, filename);
  }

  public ImageDownloadRequest(String path) {
    super(HttpMethod.GET, API.IMAGE_DOWNLOAD);

    String[] parts = path.split("/");
    super.path = formatPathVar(super.path, parts[1], parts[2], parts[3]);
  }

}
