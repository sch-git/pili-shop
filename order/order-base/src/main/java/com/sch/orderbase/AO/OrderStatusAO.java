package com.sch.orderbase.AO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 订单状态
 * @Author: chenghao.su
 * @Date: 2020/4/8 16:10
 */
@Data
public class OrderStatusAO implements Serializable {
    /**
     * 订单id
     */
    @NotNull
    private Long id;
    /**
     * 订单编号
     */
    private String code;
    /**
     * 订单状态
     */
    @NotNull
    private Byte status;
}
