package com.sch.orderbase.AO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 订单查询条件
 * @Author: chenghao.su
 * @Date: 2020/4/8 13:46
 */
@Data
public class SearchOrderAO implements Serializable {
    /**
     * 状态
     */
    private Byte status;
    /**
     * 省份
     */
    private String province;
    /**
     * 当前页
     */
    @NotNull
    private Integer pageNum;

    /**
     * 每页记录数
     */
    @NotNull
    private Integer pageSize;
}
