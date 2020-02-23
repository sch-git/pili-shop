package com.sch.commoditybase.AO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 修改商品AO
 * @Author: chenghao.su
 * @Date: 2020/2/23 15:38
 */
@Data
public class UpdateCommodityAO implements Serializable {
    /**
     * 商品id
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
     * 修改人id
     */
    private Long updateId;
    /**
     * 修改人名称
     */
    private String updateName;
}
