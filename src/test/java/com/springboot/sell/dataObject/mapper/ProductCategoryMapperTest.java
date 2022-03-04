package com.springboot.sell.dataObject.mapper;

import com.springboot.sell.dataObject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jeff
 * @Date: 2/3/2022 下午 4:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryName", "经典榜");
        map.put("categoryType", 108);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
    }

    @Test
    public void findByCategoryType() {
        ProductCategory productCategory = mapper.findByCategoryType(106);
        Assert.assertEquals(new Integer(106), productCategory.getCategoryType());
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> list = mapper.findByCategoryName("经典榜");
        Assert.assertNotNull(list.size());
    }

    @Test
    public void updateByCategoryType() {
    }

    @Test
    public void updateByObject() {
    }

    @Test
    public void deleteByCategoryType() {
        int result = mapper.deleteByCategoryType(108);
        Assert.assertEquals(1, result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory productCategory = mapper.selectByCategoryType(6);
        Assert.assertNotNull(productCategory);
    }
}