package com.sch.commoditybase.AO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

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
    @NotNull
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
    private BigDecimal price;
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
     * 修改人id
     */
    private Long updateId;
    /**
     * 修改人名称
     */
    @NotBlank
    private String updateName;
}
