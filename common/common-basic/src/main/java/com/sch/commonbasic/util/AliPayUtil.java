package com.sch.commonbasic.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * @Description: 支付宝接口;
 * 设置帐户有关信息及返回路径;
 * @Author: chenghao.su
 * @Date: 2020/3/26 13:12
 */
@Configuration
public class AliPayUtil {
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String app_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCvl3KhUfNAnJQg5oE9Ogn7Hk6gMHcYR8UyXx5Gf4OfGw/iLk3y9yEe5U9dnK4YX3NUtNJYbOItdgmKNDCWmal5zaHtjVHItX5/BRMGhrB7xjMokcgPf8LR1ll70VKo7YX0ajeSrfJV91kltcM57UGKfhmRGqBM+vLN8i3slZPO6n3MHkiXShoE/1LB6zp9KmHrd+F2a4BU5uPKYCZjcn3dFEazHuVtIB77fwGe6HhgmEZHcGLaZLwh70uARiVQ4RKLBbuRjbvRELmcsNTfG1MU64r0sJzNPiLZiNiQv7gBgAgC+KCjpANJWtMzXy3Hkn9QUrY7dvC/qJr3Z+VWQifJAgMBAAECggEAIr1N2ojCHZhc3h18mEZxTxNx7tNn3I/mfc6/yKbVvZa3D8KlfVpTXS91AkpLT1sjEDEuJHx2SxQ9UvB8ZG9GTmjWjo8VDSaLPkoct3/STsqpuG8PK7HVM3q6/XouZmmHxRF2qThs54EmTAWn+D/uZZ4JJOIlsNU9UG2HlHULZzY9gPtMI0Bt70FO7QdNtl5K6+xy+6p4jXVn7QAf/7N8YhUj2ZAmnHKu0p5KZjexAfeKf2/H83NnCAEYaxFo+ISLITAFIhEOUCN2LV9lYQxBTYtPuRmiKkgFBZokCGi2aRPEa3JmQpsvQii0W4LLoQh67hK9tk+2D7lgu1oJET95mQKBgQDX4UK1p6jt+81Wq0T9WgqwJ2zVwuUhtvZ1Y6T3MFPOHjPyQU7q77ZP3Q5rp1z494y3uZK/VeLAMh9mq1RBLRURzw6+LEcv5UKAqvamrmrgK6YbYPsO2c5d1yuR4BFowcTQwesCNqdoT940fCYUB5/tv8ph/1I6ev3FbadcMfc7AwKBgQDQOWw8Se1cN6Xgy7Ji7v/rsLTdf4e1Nx0Qke4QhWIhUkEnzzOGJZETDUeyHJ9L4qgyNlDMKnLZypyrc+MVGzK3xBOcuj/x0Nb7hiuxeonw9eUtyDOJDl0bBXYAtO5NolQ9yP5r+taUybUJuUDvqLn7snWJe7r0v804FeEk+aKSQwKBgQCIAooO/OS3m29RbXJ31GTrestdGf9WcHlymCb0/eOu9uRveqoH5qMMSg+tz7IJwZ1Mm4RTO/8ya+HQw5y/u3GM2NFHC4qGKIDvo8bmWPlI5vcuRLmoL52PDeOLcopFX99qTuKLcHekhr1Of/FVqUAfgDg36a6a3aZI3r8UnP5QlQKBgFGVjjD5DkVJkHbJmPVmi2N/cv4uT6/TDlJFuy9B87b2kYzVhGyVH4iFdYf16vxCrIAwA+xa3XE0D7qlx12nsHGMI9sOpqtKllEqusfpKU7+KXOMs5SJyjUiKKASRCSq67Lho74PJDBb79EFgsnkJCrYO3FIx3HKDNBi0jo4jVgdAoGAeKNbifdnS+0rudAtHfA2C/3HOQ95alQb9NDHdqREfZvYoMosXtuLVKv99LE29wSZV1Ee/FzdecIipHbZmEJp5muVNViReM3sBAt1gdSWGNbt1Czwo0foI7WhH0/zpKsK6jS5bH7awq3pXvS7GNAG3G8lntkWvRVKYTZV4fbOYZE=";
    // 支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhQ3pr207UyJ+E/oOJGS1jnufNAwr4TbjxUmm1d6N1gTT07s0qGK0X+DhYq/cPxDxvs2YmSaM0MAGtCAhoFNJXRPZs5ZUeie25Eb8GLilMDEiZrIziElA4QiqUeo0P2tKsgJ6gw0qpg6B7xTp0B4+PPXCAxMwujD6oHxd7s9EFOAzQq4EHX3ta2zM6GtrilZUiG6e5SnXWhzk1PYhEW90lyV/29cJuyDvx3sD2OHt3zniS5VmZhXMhyFy/TMKA44YdiKFPz5RfZDMtAbO1uJvzpL//K7r569cHUU3ZoJ+W7vdmbtNr3eU8BOAB6uaao7JZk9NZgPueTib86HwAEhZowIDAQAB";
    // APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101800715292";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8099/order/success";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8099/order/success";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    public static String ResponseForm(String code, BigDecimal total, String name) {
        // 初始化
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, app_id, app_private_key, "json", charset, alipay_public_key, sign_type);

        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + code + "\","
                + "\"total_amount\":\"" + total + "\","
                + "\"subject\":\"" + name + "\","
                + "\"body\":\"" + "" + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        // 请求
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }
}