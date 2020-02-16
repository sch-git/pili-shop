package com.sch.commoditybase.AO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 修改分类AO
 * @Author: chenghao.su
 * @Date: 2020/2/16 13:09
 */
@Data
public class UpdateCategoryAO implements Serializable {
    /**
     * id
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
}
