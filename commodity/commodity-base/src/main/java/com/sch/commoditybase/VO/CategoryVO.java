package com.sch.commoditybase.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 商品分类VO
 * @Author: chenghao.su
 * @Date: 2020/2/15 21:49
 */
@Data
public class CategoryVO implements Serializable {
    /**
     * 分类id
     */
    private Long id;
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

    /**
     * 前端判断是否双击
     */
    private Boolean enabled;

    public CategoryVO() {
        this.enabled = true;
    }
}