package com.sch.commoditybase.AO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 查询分类AO
 * @Author: chenghao.su
 * @Date: 2020/2/16 11:01
 */
@Data
public class SearchCategoryAO implements Serializable {

    /**
     * 状态 是否启用
     */
    private Boolean status;

    /**
     * 分类名
     */
    private String name;

    /**
     * 当前页
     */
    @NotNull
    private Integer pageNum;

    /**
     * 每页记录数
     */
    @NotNull
    private Integer pageSize;
}
