package com.sch.commoditybase.AO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 修改商品状态AO
 * @Author: chenghao.su
 * @Date: 2020/2/22 11:21
 */
@Data
public class UpdateCommodityStatusAO implements Serializable {
    /**
     * 商品id
     */
    @NotNull
    private Long id;
    /**
     * 商品状态
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
