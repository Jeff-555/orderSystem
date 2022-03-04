package com.springboot.sell.repository;

import com.springboot.sell.dataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: jeff
 * @Date: 2022/1/4 17:08
 * java可以接口继承接口
 * JpaRepository<泛型（实体）,泛型的ID类型>
 * findByCategoryTypeIn是JPA监听数据库得到的提示
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

//    查询类型列表
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
