package com.sch.commoditybase.AO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 修改分类AO
 * @Author: chenghao.su
 * @Date: 2020/2/16 13:09
 */
@Data
public class UpdateCategoryAO implements Serializable {
    /**
     * 分类id
     */
    @NotNull
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
    @NotBlank
    private String updateName;
}
