package com.sch.backweb.aop;

import lombok.Data;

import java.io.Serializable;

/**
 * @Title: 统计数据
 * @Author: chenghao.su
 * @Date: 2020/5/26 19:10
 */
@Data
public class Count implements Serializable {
    /**
     * 用户量
     */
    private Integer userNum;

    /**
     * 商品量
     */
    private Integer goodNum;

    /**
     * 订单成交量
     */
    private Integer orderNum;
}
