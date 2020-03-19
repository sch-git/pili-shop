package com.sch.backweb;

import com.sch.backweb.config.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@SpringBootTest
class BackWebApplicationTests {

    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }

    @Test
    void RedisContext() {
        redisUtil.lrange("slide", 0, -1, 0);
        System.out.println(redisUtil.lrange("slide", 0, -1, 0));
    }

    @Test
    void decodeContext() throws UnsupportedEncodingException {
        String url = URLDecoder.decode("http:%2F%2Fpili-shop.schblog.cn%2FFkcGx2bLMOP4szHZoCLx6D0fM_1w%3Fimageslim", "UTF-8");
        System.out.println(url);
    }
}
