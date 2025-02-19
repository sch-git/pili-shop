package com.sch.frontweb;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author sch
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubbo
public class FrontWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontWebApplication.class, args);
    }

}
