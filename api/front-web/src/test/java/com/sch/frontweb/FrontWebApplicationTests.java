package com.sch.frontweb;

import com.sch.commonbasic.util.SnowUtil;
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
        redisUtil.setnx("12", "12");
        System.out.println(redisUtil.get("12", 0));
        redisUtil.del("12");
        redisUtil.setnx("12", "13");
        System.out.println(redisUtil.get("12", 0));
        System.out.println(SnowUtil.nextId());
    }

}
