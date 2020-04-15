package com.sch.adminbase.AO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 页面
 * @Author: chenghao.su
 * @Date: 2020/4/15 19:27
 */
@Data
public class PageAO implements Serializable {
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
