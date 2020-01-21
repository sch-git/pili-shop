package com.sch.backweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 跨域配置
 * @Author: chenghao.su
 * @Date: 2020/1/20 19:27
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //对那种格式进行跨域处理
        registry.addMapping("/**")
                // 允许的请求域
                .allowedOrigins("http://localhost:10080")
                // 允许的请求方法
                .allowedMethods("POST", "GET", "OPTION", "PUT", "DELETE")
                // 允许的请求头
                .allowedHeaders("*")
                // 允许cookie
                .allowCredentials(true)
                //探测请求的有效期
                .maxAge(168000);
    }
}
