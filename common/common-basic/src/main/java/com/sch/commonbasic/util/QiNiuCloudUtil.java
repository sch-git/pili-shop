package com.sch.commonbasic.util;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @Description: 七牛云图片上传 TODO
 * @Author: chenghao.su
 * @Date: 2020/2/6 21:56
 */
public class QiNiuCloudUtil {
    /**
     * 设置需要操作的账号的AK和SK
     */
    private static final String ACCESS_KEY = "ikA1yGWtl7aWl7WOqr-p1D7L39fmYC2AfPslMmJ3";
    private static final String SECRET_KEY = "MeOLdFZmIMtimlR0aVLXdYjwi1sb8fsF1MlVlTyf";
    /**
     * 要上传的空间
     */
    private static final String BUCKET_NAME = "pili-shop";
    /**
     * 密钥
     */
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    /**
     * 图片上传路径
     */
    private static final String UPLOAD_URL = "url";
    /**
     * 自定义的图片样式:png/jpg
     */
    private static final String style = "自定义的图片样式";

    /**
     * 自定义返回的JSON格式的内容
     */
    StringMap putPolicy = new StringMap().put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
    long expireSeconds = 3600;
    String upToken = auth.uploadToken(BUCKET_NAME, null, expireSeconds, putPolicy);
}
