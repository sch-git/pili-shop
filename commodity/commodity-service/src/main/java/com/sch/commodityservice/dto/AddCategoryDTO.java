package com.sch.commodityservice.dto;

import com.sch.commoditybase.AO.AddCategoryAO;
import com.sch.commonbasic.util.DateUtil;
import lombok.Data;

/**
 * @Description: 新增DTO
 * @Author: chenghao.su
 * @Date: 2020/2/15 22:04
 */
@Data
public class AddCategoryDTO {
    /**
     * 分类名称
     */
    private String name;
    /**
     * 是否可用（0：否；1：是）
     */
    private Boolean status;
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

    public void setAO(AddCategoryAO AO) {
        this.name = AO.getName();
        this.status = AO.getStatus();
        this.createName = AO.getCreateName();
        this.updateName = AO.getCreateName();
        this.createTime = DateUtil.createTime();
        this.updateTime = DateUtil.createTime();
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
        this.updateId = createId;
    }
}
