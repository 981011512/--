/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cf.pay.service.alipay.factory;

import com.cf.pay.service.alipay.kernel.BaseClient;
import com.cf.pay.service.alipay.payment.page.Client;
import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户端工厂，用于快速配置和访问各种场景下的API Client
 *
 * @author zhongyu
 * @version $Id: Factory.java, v 0.1 2020年01月18日 11:26 AM zhongyu Exp $
 */
public class Factory {
    private static final Map<String, BaseClient> clients = new HashMap<>();

    /**
     * 设置客户端参数，只需设置一次，即可反复使用各种场景下的API Client
     *
     * @param options 客户端参数对象
     */
    public static void setOptions(BaseClient.Config options) {
        try {
            registerClient(new com.cf.pay.service.alipay.base.image.Client(options));
            registerClient(new com.cf.pay.service.alipay.base.video.Client(options));
            registerClient(new com.cf.pay.service.alipay.base.oauth.Client(options));
            registerClient(new com.cf.pay.service.alipay.base.qrcode.Client(options));
            registerClient(new com.cf.pay.service.alipay.marketing.openlife.Client(options));
            registerClient(new com.cf.pay.service.alipay.marketing.pass.Client(options));
            registerClient(new com.cf.pay.service.alipay.marketing.templatemessage.Client(options));
            registerClient(new com.cf.pay.service.alipay.member.identification.Client(options));
            registerClient(new com.cf.pay.service.alipay.payment.common.Client(options));
            registerClient(new com.cf.pay.service.alipay.payment.huabei.Client(options));
            registerClient(new com.cf.pay.service.alipay.payment.facetoface.Client(options));
            registerClient(new com.cf.pay.service.alipay.payment.page.Client(options));
            registerClient(new com.cf.pay.service.alipay.payment.wap.Client(options));
            registerClient(new com.cf.pay.service.alipay.payment.app.Client(options));
            registerClient(new com.cf.pay.service.alipay.security.textrisk.Client(options));
            registerClient(new com.cf.pay.service.alipay.util.generic.Client(options));
            registerClient(new com.cf.pay.service.alipay.util.aes.Client(options));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static void registerClient(BaseClient client) {
        clients.put(client.getClass().getCanonicalName(), client);
    }

    @SuppressWarnings("unchecked")
    private static <T> T getClient(Class<T> clazz) {
        BaseClient baseClient = clients.get(clazz.getCanonicalName());
        Preconditions.checkNotNull(baseClient, "尚未注册" + clazz.getCanonicalName() + "，请先调用Factory.setOptions方法。");
        return (T) baseClient;
    }

    /**
     * 支付能力相关
     */
    public static class Payment {
        /**
         * 获取支付通用API Client
         *
         * @return 支付通用API Client
         */
        public static com.cf.pay.service.alipay.payment.common.Client Common() {
            return getClient(com.cf.pay.service.alipay.payment.common.Client.class);
        }

        /**
         * 获取花呗相关API Client
         *
         * @return 花呗相关API Client
         */
        public static com.cf.pay.service.alipay.payment.huabei.Client Huabei() {
            return getClient(com.cf.pay.service.alipay.payment.huabei.Client.class);
        }

        /**
         * 获取当面付相关API Client
         *
         * @return 当面付相关API Client
         */
        public static com.cf.pay.service.alipay.payment.facetoface.Client FaceToFace() {
            return getClient(com.cf.pay.service.alipay.payment.facetoface.Client.class);
        }

        /**
         * 获取电脑网站支付相关API Client
         *
         * @return 电脑网站支付相关API Client
         */
        public static com.cf.pay.service.alipay.payment.page.Client Page() {
            return getClient(com.cf.pay.service.alipay.payment.page.Client.class);
        }

        /**
         * 获取手机网站支付相关API Client
         *
         * @return 手机网站支付相关API Client
         */
        public static com.cf.pay.service.alipay.payment.wap.Client Wap() {
            return getClient(com.cf.pay.service.alipay.payment.wap.Client.class);
        }

        /**
         * 获取手机APP支付相关API Client
         *
         * @return 手机APP支付相关API Client
         */
        public static com.cf.pay.service.alipay.payment.app.Client App() {
            return getClient(com.cf.pay.service.alipay.payment.app.Client.class);
        }
    }

    /**
     * 基础能力相关
     */
    public static class Base {
        /**
         * 获取图片相关API Client
         *
         * @return 图片相关API Client
         */
        public static com.cf.pay.service.alipay.base.image.Client Image() {
            return getClient(com.cf.pay.service.alipay.base.image.Client.class);
        }

        /**
         * 获取视频相关API Client
         *
         * @return 视频相关API Client
         */
        public static com.cf.pay.service.alipay.base.video.Client Video() {
            return getClient(com.cf.pay.service.alipay.base.video.Client.class);
        }

        /**
         * 获取OAuth认证相关API Client
         *
         * @return OAuth认证相关API Client
         */
        public static com.cf.pay.service.alipay.base.oauth.Client OAuth() {
            return getClient(com.cf.pay.service.alipay.base.oauth.Client.class);
        }

        /**
         * 获取小程序二维码相关API Client
         *
         * @return 小程序二维码相关API Client
         */
        public static com.cf.pay.service.alipay.base.qrcode.Client Qrcode() {
            return getClient(com.cf.pay.service.alipay.base.qrcode.Client.class);
        }
    }

    /**
     * 营销能力相关
     */
    public static class Marketing {
        /**
         * 获取生活号相关API Client
         *
         * @return 生活号相关API Client
         */
        public static com.cf.pay.service.alipay.marketing.openlife.Client OpenLife() {
            return getClient(com.cf.pay.service.alipay.marketing.openlife.Client.class);
        }

        /**
         * 获取支付宝卡包相关API Client
         *
         * @return 支付宝卡包相关API Client
         */
        public static com.cf.pay.service.alipay.marketing.pass.Client Pass() {
            return getClient(com.cf.pay.service.alipay.marketing.pass.Client.class);
        }

        /**
         * 获取小程序模板消息相关API Client
         *
         * @return 小程序模板消息相关API Client
         */
        public static com.cf.pay.service.alipay.marketing.templatemessage.Client TemplateMessage() {
            return getClient(com.cf.pay.service.alipay.marketing.templatemessage.Client.class);
        }
    }

    /**
     * 会员能力相关
     */
    public static class Member {
        /**
         * 获取支付宝身份认证相关API Client
         *
         * @return 支付宝身份认证相关API Client
         */
        public static com.cf.pay.service.alipay.member.identification.Client Identification() {
            return getClient(com.cf.pay.service.alipay.member.identification.Client.class);
        }
    }

    /**
     * 安全能力相关
     */
    public static class Security {
        /**
         * 获取文本风险识别相关API Client
         *
         * @return 文本风险识别相关API Client
         */
        public static com.cf.pay.service.alipay.security.textrisk.Client TextRisk() {
            return getClient(com.cf.pay.service.alipay.security.textrisk.Client.class);
        }
    }

    /**
     * 辅助工具
     */
    public static class Util {
        /**
         * 获取OpenAPI通用接口，可通过自行拼装参数，调用几乎所有OpenAPI
         *
         * @return OpenAPI通用接口
         */
        public static com.cf.pay.service.alipay.util.generic.Client Generic() {
            return getClient(com.cf.pay.service.alipay.util.generic.Client.class);
        }

        /**
         * 获取AES128加解密相关API Client，常用于会员手机号的解密
         *
         * @return AES128加解密相关API Client
         */
        public static com.cf.pay.service.alipay.util.aes.Client AES() {
            return getClient(com.cf.pay.service.alipay.util.aes.Client.class);
        }
    }
}