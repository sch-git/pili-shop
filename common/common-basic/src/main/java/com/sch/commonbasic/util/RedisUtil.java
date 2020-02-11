package com.sch.commonbasic.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Description: redis封装
 * @Author: chenghao.su
 * @Date: 2020/2/11 16:13
 */
public class RedisUtil {

    public static ValueOperations getOpsForValue(RedisTemplate redisTemplate) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations ops = redisTemplate.opsForValue();
        return ops;
    }

}
