package com.sch.commonbasic.VO;

import lombok.Data;

/**
 * @Description: 订单状态
 * @Author: chenghao.su
 * @Date: 2020/3/26 18:34
 */
@Data
public class OrderStatus {
    /**
     * 创建未支付
     */
    private static final Integer CREATE = 0;
    /**
     * 支付未发货
     */
    private static final Integer PAY = 1;
    /**
     * 发货未完成
     */
    private static final Integer SEND = 2;
    /**
     * 完成
     */
    private static final Integer SUCCESS = 3;
    /**
     * 取消
     */
    private static final Integer CANCEL = 4;
}
