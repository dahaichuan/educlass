package com.haoyi.educlass.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 微信配置
 */
@Configuration
@PropertySource(value = "classpath:wechat.properties")
public class WeChatConfig {
    @Value("${wxpay.appId}")
    private String appid;

    @Value("${wxpay.secret}")
    private String secret;

    @Value("${wxopen.appid}")
    private String openAppid;

    /**
     * 开放平台部分
     */
    @Value("${wxopen.appsecret}")
    private String openAppsecret;

    @Value("${wxopen.redirect_url}")
    private String openRedirecturl;

    private final static String OPEN_QRCODE_URL= "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";

    private final static String OPEN_ACCESS_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    public static String getOpenAccessTokenUrl() {
        return OPEN_ACCESS_TOKEN_URL;
    }

    public String getOpenRedirecturl() {
        return openRedirecturl;
    }

    public void setOpenRedirecturl(String openRedirecturl) {
        this.openRedirecturl = openRedirecturl;
    }


    public static String getOpenQrcodeUrl() {
        return OPEN_QRCODE_URL;
    }

    public String getOpenAppid() {
        return openAppid;
    }

    public void setOpenAppid(String openAppid) {
        this.openAppid = openAppid;
    }

    public String getOpenAppsecret() {
        return openAppsecret;
    }

    public void setOpenAppsecret(String openAppsecret) {
        this.openAppsecret = openAppsecret;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
