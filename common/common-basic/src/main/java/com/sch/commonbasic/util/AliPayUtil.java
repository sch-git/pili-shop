package com.sch.commonbasic.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Description: 支付宝接口;
 * 设置帐户有关信息及返回路径;
 * @Author: chenghao.su
 * @Date: 2020/3/26 13:12
 */
public class AliPayUtil {
    // 商户私钥，您的PKCS8格式RSA2私钥
    @Value("${alipay.private.key}")
    public static String merchant_private_key = "";
    // 支付宝公钥
    @Value("${alipay.public.key}")
    public static String alipay_public_key = "";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // APPID，收款账号既是您的APPID对应支付宝账号
    @Value("${alipay.appid}")
    public String app_id;
}
