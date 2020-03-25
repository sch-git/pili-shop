package com.sch.userbase.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 新增地址返回新地址id+默认地址id
 * @Author: chenghao.su
 * @Date: 2020/3/25 16:22
 */
@Data
public class InsertAddressVO implements Serializable {
    /**
     * 新id
     */
    private Long id;
    /**
     * 默认地址id
     */
    private Long defaultId;
}
