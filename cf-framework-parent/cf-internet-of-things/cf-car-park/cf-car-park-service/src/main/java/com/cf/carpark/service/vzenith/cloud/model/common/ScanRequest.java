package com.cf.carpark.service.vzenith.cloud.model.common;

import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ScanRequest extends BaseRequest {
  private JSONArray               wheres = null;
  private HashMap<String, String> orders = null;

  public enum Order {
    ASC,
    DESC
  }

  public enum Oper {
    EQ,
    NE,
    LT,
    LTE,
    GT,
    GTE,
    LIKE,
    IN,
    NI,
  }

  /**
   * 针对 Scan 类接口优化封装的基础类
   *
   * @param path API path
   */
  public ScanRequest(String path) {
    super(HttpMethod.GET, path);
    wheres = new JSONArray();
    orders = new HashMap<>();
    params.put("page", "1");
    params.put("size", "10");
  }

  public void setPage(int page) {
    super.addParam("page", String.valueOf(page));
  }

  public void setPageSize(int pageSize) {
    super.addParam("size", String.valueOf(pageSize));
  }

  public void addOrder(String key, Order order) {
    switch (order) {
      case ASC:
        orders.put(key, "ASC");
        break;
      case DESC:
        orders.put(key, "DESC");
        break;
    }
  }

  public void addWhere(String key, Oper oper, Object value) {
    final String operationString;
    switch (oper) {
      case EQ:
        operationString = "eq";
        break;
      case NE:
        operationString = "ne";
        break;
      case LT:
        operationString = "lt";
        break;
      case LTE:
        operationString = "lte";
        break;
      case GT:
        operationString = "gt";
        break;
      case GTE:
        operationString = "gte";
        break;
      case LIKE:
        if (!(value instanceof CharSequence)) {
          throw new UnsupportedOperationException("value must be a string");
        }
        operationString = "like";
        break;
      case IN:
        if (!(value instanceof Object[])) {
          throw new UnsupportedOperationException("value must be a array");
        }
        operationString = "in";
        break;
      case NI:
        if (!(value instanceof Object[])) {
          throw new UnsupportedOperationException("value must be a array");
        }
        operationString = "ni";
        break;
      default:
        return;
    }

    wheres.put(new JSONObject() {{
      put("k", key);
      put("o", operationString);
      put("v", value);
    }});
  }

  private void insertWheres() {
    if (wheres.length() > 0) {
      String wheresString = wheres.toString();
      String encodedWheresString = new String(Base64.getEncoder().encode(wheresString.getBytes(StandardCharsets.UTF_8)));
      params.put("wheres", encodedWheresString);
    } else {
      params.remove("wheres");
    }
  }

  private void insertOrders() {
    if (orders.size() > 0) {
      JSONArray array = new JSONArray();
      for (Map.Entry<String, String> e : orders.entrySet()) {
        array.put(new JSONObject() {{
          put("k", e.getKey());
          put("o", e.getValue());
        }});
      }
      String ordersStr = array.toString();
      String encodedOrdersStr = new String(Base64.getEncoder().encode(ordersStr.getBytes(StandardCharsets.UTF_8)));
      params.put("orders", encodedOrdersStr);
    } else {
      params.remove("orders");
    }
  }

  @Override
  public HashMap<String, String> getParams() {
    insertWheres();
    insertOrders();
    System.out.println(params.toString());
    return super.getParams();
  }

  @Override
  public String encodeParams() {
    insertWheres();
    insertOrders();
    System.out.println(params.toString());
    return super.encodeParams();
  }
}
