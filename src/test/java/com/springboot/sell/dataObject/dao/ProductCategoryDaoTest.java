package com.springboot.sell.dataObject.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jeff
 * @Date: 2/3/2022 下午 4:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryName", "经典榜");
        map.put("categoryType,", "105");
        int result = productCategoryDao.insertByMap(map);
        Assert.assertEquals(1, result);
    }
}