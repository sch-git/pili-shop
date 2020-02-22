package com.sch.commoditybase.AO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 查询商品AO
 * @Author: chenghao.su
 * @Date: 2020/2/22 10:11
 */
@Data
public class SearchCommodityAO implements Serializable {
    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品分类
     */
    private Long categoryId;

    /**
     * 是否上架
     */
    private Boolean status;
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
