package com.sch.commodityservice.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 商品详情
 * @Author: chenghao.su
 * @Date: 2020/3/4 17:16
 */
@Data
public class CommodityDetailDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private Float price;

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
