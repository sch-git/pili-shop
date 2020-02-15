package com.sch.commoditybase.AO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 添加分类AO
 * @Author: chenghao.su
 * @Date: 2020/2/15 21:59
 */
@Data
public class AddCategoryAO implements Serializable {
    /**
     * 分类名称
     */
    private String name;
    /**
     * 是否可用（0：否；1：是）
     */
    private Boolean status;
    /**
     * 创建人名称
     */
    private String createName;
}
