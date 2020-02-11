package com.sch.commonbasic.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 七牛云图片上传 TODO 异常处理
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
     * 要上传的存储空间
     */
    private static final String BUCKET_NAME = "pili-shop";
    /**
     * 外链域名
     */
    private static final String DOMAIN = "http://pili-shop.schblog.cn/";
    /**
     * 密钥
     */
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    /**
     * 自定义的图片样式:png/jpg
     */
    private static final String style = "自定义的图片样式";
    private static final Logger LOGGER = LoggerFactory.getLogger(QiNiuCloudUtil.class);
    /**
     * 自定义返回的JSON格式的内容
     */
    private static StringMap putPolicy = new StringMap().put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
    private static long expireSeconds = 3600;
    private static String upToken = auth.uploadToken(BUCKET_NAME, null, expireSeconds, putPolicy);
    /**
     * 构造一个带指定Region对象的配置类:region0为华东
     */
    private static Configuration cfg = new Configuration(Region.region0());
    private static UploadManager uploadManager = new UploadManager(cfg);

    public static String uploadImg(MultipartFile file) {
        try {
            byte[] uploadBytes = file.getBytes();

            try {
                Response response = uploadManager.put(uploadBytes, null, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return DOMAIN + putRet.hash;
            } catch (QiniuException ex) {
                Response r = ex.response;
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
