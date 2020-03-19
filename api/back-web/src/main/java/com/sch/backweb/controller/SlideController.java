package com.sch.backweb.controller;

import com.sch.backweb.config.RedisUtil;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

/**
 * @Description: 后台轮播图片管理
 * @Author: chenghao.su
 * @Date: 2020/3/19 16:33
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

    /**
     * 添加轮播图片
     *
     * @param map {'url','url'} 图片地址
     * @return
     */
    @PostMapping("/item")
    public Result addSlideImage(@RequestBody Map<String, String> map) {
        redisUtil.rpush(SLIDE_KEY, map.get("url"));
        return Result.success();
    }

    /**
     * 删除指定轮播图片
     *
     * @param url {'url','url'} 图片地址
     * @return
     */
    @DeleteMapping("/delete")
    public Result deleteSlideImage(@RequestParam String url) {
        redisUtil.lrem(SLIDE_KEY, 1, URLDecoder.decode(url));
        return new Result(ResultEnum.DELETE_SUCCESS);
    }
}
