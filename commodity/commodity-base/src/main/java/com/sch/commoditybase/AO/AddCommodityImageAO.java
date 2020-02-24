package com.sch.commoditybase.AO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 添加商品图片AO
 * @Author: chenghao.su
 * @Date: 2020/2/20 14:43
 */
@Data
public class AddCommodityImageAO implements Serializable {

    /**
     * 商品id
     */
    @NotNull
    private Long commodityId;

    /**
     * 商品图片地址
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
