package com.sch.orderbase.AO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: 用户支付订单
 * @Author: chenghao.su
 * @Date: 2020/4/10 21:40
 */
@Data
public class PayOrderAO implements Serializable {
    /**
     * 订单编号
     */
    @NotBlank
    private String code;
    /**
     * 总价
     */
    @NotNull
    private BigDecimal total;
    /**
     * 收货人
     */
    @NotBlank
    private String receiveName;
}
