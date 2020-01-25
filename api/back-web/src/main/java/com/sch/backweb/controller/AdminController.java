package com.sch.backweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 管理员接口
 * @Author: chenghao.su
 * @Date: 2020/1/13 19:40
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }
}
