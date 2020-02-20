package com.sch.commodityservice.dto;

import com.sch.commoditybase.AO.AddCommodityImageAO;
import com.sch.commonbasic.util.DateUtil;
import lombok.Data;

/**
 * @Description: 添加商品图片DTO
 * @Author: chenghao.su
 * @Date: 2020/2/20 14:43
 */
@Data
public class AddCommodityImageDTO {

    /**
     * 商品id
     */
    private Long commodityId;

    /**
     * 商品图片地址
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

    public AddCommodityImageDTO() {

    }

    public AddCommodityImageDTO(Long commodityId, String url, Long createId, String createName) {
        this.commodityId = commodityId;
        this.url = url;
        this.createId = createId;
        this.createName = createName;
        this.createTime = DateUtil.createTime();
    }

    public void setAO(AddCommodityImageAO AO) {
        this.commodityId = AO.getCommodityId();
        this.url = AO.getUrl();
        this.createName = AO.getCreateName();
        this.createId = AO.getCreateId();
        this.createTime = DateUtil.createTime();
    }
}
