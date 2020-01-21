package com.sch.backweb;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sch
 */
@SpringBootApplication
@EnableDubbo
public class BackWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackWebApplication.class, args);
    }

}
