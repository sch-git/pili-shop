package com.sch.commodityservice.dto;

import com.sch.commoditybase.AO.UpdateCommodityAO;
import com.sch.commonbasic.util.DateUtil;
import lombok.Data;

/**
 * @Description: 修改商品DTO
 * @Author: chenghao.su
 * @Date: 2020/2/23 15:42
 */
@Data
public class UpdateCommodityDTO {
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
    /**
     * 修改时间
     */
    private String updateTime;

    public void setAO(UpdateCommodityAO AO) {
        this.id = AO.getId();
        this.categoryId = AO.getCategoryId();
        this.name = AO.getName();
        this.describe = AO.getDescribe();
        this.price = AO.getPrice();
        this.status = AO.getStatus();
        this.updateId = AO.getUpdateId();
        this.updateName = AO.getUpdateName();
        this.updateTime = DateUtil.createTime();
    }
}
