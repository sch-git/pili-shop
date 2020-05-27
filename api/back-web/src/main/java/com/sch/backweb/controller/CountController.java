package com.sch.backweb.controller;

import com.sch.backweb.aop.Count;
import com.sch.backweb.config.RedisUtil;
import com.sch.commonbasic.VO.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Title: 统计中心
 * @Author: chenghao.su
 * @Date: 2020/5/26 18:58
 */
@RestController
@RequestMapping("/count")
public class CountController {
    /**
     * 统计中心在 redis 缓存中的 key
     */
    private static final String COUNT_KEY = "count";
    /**
     * 统计中心位于redis缓存中数据库的位置
     */
    private static final Integer INDEX_DB = 1;
    @Autowired
    RedisUtil redisUtil;

    /**
     * 查询统计中心数据
     *
     * @return 统计中心数据
     */
    @GetMapping("/data")
    public Result findData() {
        Set<String> fields = redisUtil.hkeys(COUNT_KEY);
        Count count = new Count();
        count.setUserNum(Integer.parseInt(redisUtil.hget(COUNT_KEY, "userNum")));
        count.setGoodNum(Integer.parseInt(redisUtil.hget(COUNT_KEY, "goodNum")));
        count.setOrderNum(Integer.parseInt(redisUtil.hget(COUNT_KEY, "orderNum")));
        return Result.success(count);
    }
}
