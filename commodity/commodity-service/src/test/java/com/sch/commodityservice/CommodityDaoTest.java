package com.sch.commodityservice;

import com.sch.commoditybase.AO.AddCommodityAO;
import com.sch.commoditybase.AO.SearchCommodityAO;
import com.sch.commodityservice.dao.CommodityDao;
import com.sch.commodityservice.dto.AddCommodityDTO;
import com.sch.commodityservice.dto.UpdateCommodityDTO;
import com.sch.commodityservice.dto.UpdateCommodityStatusDTO;
import com.sch.commodityservice.entity.Commodity;
import com.sch.commonbasic.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 商品DAO测试
 * @Author: chenghao.su
 * @Date: 2020/2/14 18:49
 */
@SpringBootTest
public class CommodityDaoTest {
    @Autowired
    CommodityDao commodityDao;

    /**
     * 添加商品
     */
    @Test
    public void addCommodity() {
        AddCommodityAO addCommodityAO = new AddCommodityAO();
        addCommodityAO.setCategoryId(1L);
        addCommodityAO.setName("测试商品001");
        addCommodityAO.setStatus(true);
        addCommodityAO.setUrl("root");
        addCommodityAO.setCreateName("root");
        addCommodityAO.setDescribe("测试描述001");
        addCommodityAO.setPrice(new BigDecimal("99.00"));
        AddCommodityDTO addCommodityDTO = new AddCommodityDTO();
        addCommodityDTO.setAO(addCommodityAO);
        addCommodityDTO.setCreateId(1L);
        commodityDao.addCommodity(addCommodityDTO);
        System.out.println(addCommodityDTO.getId());
    }

    /**
     * 查询商品
     */
    @Test
    public void findAll() {
        SearchCommodityAO searchCommodityAO = new SearchCommodityAO();
        searchCommodityAO.setCategoryId(null);
        searchCommodityAO.setName("");
        searchCommodityAO.setPageNum(1);
        searchCommodityAO.setPageSize(3);
        searchCommodityAO.setStatus(true);
        System.out.println(commodityDao.findAll(searchCommodityAO));
    }

    /**
     * 修改商品状态
     */
    @Test
    public void updateCommodityStatus() {
        UpdateCommodityStatusDTO updateCommodityStatusDTO = new UpdateCommodityStatusDTO();
        updateCommodityStatusDTO.setId(1L);
        updateCommodityStatusDTO.setStatus(true);
        updateCommodityStatusDTO.setUpdateId(1L);
        updateCommodityStatusDTO.setUpdateName("root");
        updateCommodityStatusDTO.setUpdateTime(DateUtil.createTime());
        commodityDao.updateCommodityStatus(updateCommodityStatusDTO);
    }

    /**
     * 修改商品信息
     */
    @Test
    public void updateCommodity() {
        UpdateCommodityDTO updateCommodityDTO = new UpdateCommodityDTO();
        updateCommodityDTO.setId(1L);
        updateCommodityDTO.setCategoryId(2L);
        updateCommodityDTO.setName("测试商品001");
        updateCommodityDTO.setPrice(new BigDecimal("99.00"));
        updateCommodityDTO.setDescribe("测试描述001");
        updateCommodityDTO.setStatus(false);
        updateCommodityDTO.setUpdateId(1L);
        updateCommodityDTO.setUpdateName("root");
        updateCommodityDTO.setUpdateTime(DateUtil.createTime());
        commodityDao.updateCommodity(updateCommodityDTO);
    }

    /**
     * 查询商品详情
     */
    @Test
    public void findById() {
        System.out.println(commodityDao.findById(1L));
    }

    @Test
    public void findByIds() {
        Set<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        List<Commodity> commodities = commodityDao.findByIds(strings);
        for (Commodity commodity : commodities) {
            System.out.println(commodity.getName());
        }
    }
}
