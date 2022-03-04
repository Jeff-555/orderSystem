package com.springboot.sell.service;

import com.springboot.sell.dataObject.ProductCategory;

import java.util.List;

/**
 * @Author: jeff
 * @Date: 2022/1/5 11:17
 */
public interface CategoryService{

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
