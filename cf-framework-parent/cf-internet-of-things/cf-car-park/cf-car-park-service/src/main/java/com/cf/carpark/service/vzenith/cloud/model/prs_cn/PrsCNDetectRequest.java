package com.cf.carpark.service.vzenith.cloud.model.prs_cn;

import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.util.BinaryUtil;
import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.http.Headers;
import com.cf.carpark.service.vzenith.cloud.http.HttpContentType;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class PrsCNDetectRequest extends BaseRequest {
  private String                             imageBase64 = "";
  private int                                maxCount    = 10;
  private ArrayList<HashMap<String, Object>> rectList    = null;

  public PrsCNDetectRequest(String appId) {
    super(HttpMethod.POST, API.PRS_CN_DETECT, appId);
    super.addHeader(Headers.CONTENT_TYPE, HttpContentType.JSON_DATA);
    rectList = new ArrayList<>();
  }

  @Override
  @Deprecated
  public void setBody(String body) {
  }

  public void setImage(String path) throws IOException {
    InputStream inputStream = new FileInputStream(path);
    byte[] data = new byte[inputStream.available()];
    inputStream.read(data);
    inputStream.close();
    setImage(data);
  }

  public void setImage(byte[] binaryImage) {
    imageBase64 = BinaryUtil.toBase64String(binaryImage);
  }

  public void setMaxCount(int maxCount) {
    this.maxCount = maxCount;
  }

  public void addRectArea(String id, int top, int left, int width, int height) {
    rectList.add(new HashMap<String, Object>() {{
      put("id", id);
      put("top", top);
      put("left", left);
      put("width", width);
      put("height", height);
    }});
  }

  @Override
  public String getBody() {
    JSONObject body = new JSONObject();
    body.put("image", imageBase64);
    body.put("image_type", "BASE64");

    if (maxCount > 0) {
      body.put("max_count", maxCount);
    }

    if (!rectList.isEmpty()) {
      body.put("rect_list", rectList);
    }
    return body.toString();
  }
}
