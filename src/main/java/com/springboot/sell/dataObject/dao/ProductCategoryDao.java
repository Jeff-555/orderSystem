package com.springboot.sell.dataObject.dao;

import com.springboot.sell.dataObject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author: jeff
 * @Date: 2/3/2022 下午 3:35
 */
public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    public Integer insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }


}
