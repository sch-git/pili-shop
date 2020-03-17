package com.sch.frontweb;

import com.sch.frontweb.config.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FrontWebApplicationTests {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {

    }

}
