package com.cf.ucenter.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 制作微信二维码 需要传入的参数实体
 */
public class UnlimitedForm implements Serializable {

    @ApiModelProperty(value = "最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）", required = true)
    private String scene;
    @ApiModelProperty(value = "主页 必须是已经发布的小程序存在的页面（否则报错），例如 pages/index/index, 根路径前不要填加 /,不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面", required = false)
    private String page;
    @ApiModelProperty(value = "二维码的宽度，单位 px，最小 280px，最大 1280px  默认430", required = false)
    private Integer width;
    @ApiModelProperty(value = "自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调，默认 false", required = false)
    @JsonProperty("auto_color")
    private boolean auto_color;
    @ApiModelProperty(value = "是否需要透明底色，为 true 时，生成透明底色的小程序", required = false)
    @JsonProperty("is_hyaline")
    private boolean is_hyaline;
    @ApiModelProperty(value = "小程序appid", required = false)
    private String appid;

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public boolean isAuto_color() {
        return auto_color;
    }

    public void setAuto_color(boolean auto_color) {
        this.auto_color = auto_color;
    }

    public boolean isIs_hyaline() {
        return is_hyaline;
    }

    public void setIs_hyaline(boolean is_hyaline) {
        this.is_hyaline = is_hyaline;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
