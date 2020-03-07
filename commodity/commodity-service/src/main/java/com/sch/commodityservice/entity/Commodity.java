package com.sch.commodityservice.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 商品
 * @Author: chenghao.su
 * @Date: 2020/2/6 21:43
 */
@Data
public class Commodity {
    /**
     * id
     */
    private Long id;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品描述
     */
    private String describe;

    /**
     * 商品状态：是否上架
     * 0：否;1：是
     */
    private Boolean status;

    /**
     * 商品默认图片地址
     */
    private String url;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人id
     */
    private Long updateId;

    /**
     * 修改人名称
     */
    private String updateName;

    /**
     * 修改时间
     */
    private Date updateTime;
}