package com.sch.commodityservice.dto;

import com.sch.commoditybase.AO.UpdateCategoryAO;
import com.sch.commonbasic.util.DateUtil;
import lombok.Data;

/**
 * @Description: 修改分类DTO
 * @Author: chenghao.su
 * @Date: 2020/2/20 13:22
 */
@Data
public class UpdateCategoryDTO {
    /**
     * 分类id
     */
    private Long id;
    /**
     * 状态 是否启用
     */
    private Boolean status;
    /**
     * 分类名
     */
    private String name;
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

    public void setAO(UpdateCategoryAO AO) {
        this.id = AO.getId();
        this.name = AO.getName();
        this.status = AO.getStatus();
        this.updateId = AO.getUpdateId();
        this.updateName = AO.getUpdateName();
        this.updateTime = DateUtil.createTime();
    }
}
