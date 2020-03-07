package com.sch.commodityservice.dto;

import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commonbasic.util.DateUtil;
import com.sch.commonbasic.util.QiNiuCloudUtil;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: 添加商品DTO
 * @Author: chenghao.su
 * @Date: 2020/2/6 21:43
 */
@Data
public class AddCommodityDTO {
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
    private String createTime;

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

    public void setAO(AddCommodityAO AO) {
        this.categoryId = AO.getCategoryId();
        this.name = AO.getName();
        this.price = AO.getPrice();
        this.describe = AO.getDescribe();
        this.status = AO.getStatus();
        this.url = AO.getUrl().split(QiNiuCloudUtil.getDOMAIN())[1];
        this.createId = AO.getCreateId();
        this.updateId = AO.getCreateId();
        this.createName = AO.getCreateName();
        this.updateName = AO.getCreateName();
        this.createTime = DateUtil.createTime();
        this.updateTime = DateUtil.createTime();
    }
}