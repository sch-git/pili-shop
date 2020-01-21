package com.sch.commonbasic.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Description: TODO
 * @Author: chenghao.su
 * @Date: 2020/1/13 21:19
 */
@Aspect
public class log {
    @Before("execution(public * com.sch.*.*..*.*(..))")
    public void before() {
        System.out.println("before");
    }
}
