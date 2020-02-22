package com.sch.commodityservice.dto;

import com.sch.commoditybase.AO.UpdateCommodityStatusAO;
import com.sch.commonbasic.util.DateUtil;
import lombok.Data;

/**
 * @Description: 修改商品状态DTO
 * @Author: chenghao.su
 * @Date: 2020/2/22 11:36
 */
@Data
public class UpdateCommodityStatusDTO {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品状态
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

    public void setAO(UpdateCommodityStatusAO AO) {
        this.id = AO.getId();
        this.status = AO.getStatus();
        this.updateId = AO.getUpdateId();
        this.updateName = AO.getUpdateName();
        this.updateTime = DateUtil.createTime();
    }
}
