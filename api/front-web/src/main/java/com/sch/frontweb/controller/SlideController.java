package com.sch.frontweb.controller;

import com.sch.commonbasic.VO.Result;
import com.sch.frontweb.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 首页轮播图管理
 * @Author: chenghao.su
 * @Date: 2020/3/19 21:05
 */
@RestController
@RequestMapping("/slide")
public class SlideController {
    /**
     * 轮播图在redis缓存中的key
     */
    private static final String SLIDE_KEY = "slide";
    /**
     * 轮播图位于redis缓存中数据库的位置
     */
    private static final Integer INDEX_DB = 0;
    @Autowired
    RedisUtil redisUtil;

    /**
     * 查询轮播图片
     *
     * @return 轮播图列表
     */
    @GetMapping("/list")
    public Result findSlideImageList() {
        List<String> slideImageList = redisUtil.lrange(SLIDE_KEY, 0, -1, INDEX_DB);
        return Result.success(slideImageList);
    }
}
