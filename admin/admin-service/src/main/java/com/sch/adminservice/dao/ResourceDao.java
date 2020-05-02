package com.sch.adminservice.dao;

import com.sch.adminservice.entity.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceDao {
    /**
     * 查询权限
     *
     * @return 权限列表
     */
    List<Resource> findAll();
}