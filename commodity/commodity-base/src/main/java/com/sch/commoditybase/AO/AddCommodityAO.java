package com.sch.commoditybase.AO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 添加商品AO
 * @Author: chenghao.su
 * @Date: 2020/2/6 21:43
 */
@Data
public class AddCommodityAO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 分类id
     */
    @NotNull
    private Long categoryId;

    /**
     * 商品名称
     */
    @NotBlank
    private String name;

    /**
     * 商品价格
     */
    @NotNull
    private Float price;

    /**
     * 商品描述
     */
    @NotBlank
    private String describe;

    /**
     * 商品状态：是否上架
     * 0：否;1：是
     */
    @NotNull
    private Boolean status;

    /**
     * 商品默认图片地址
     */
    @NotBlank
    private String url;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建人名称
     */
    @NotBlank
    private String createName;
}