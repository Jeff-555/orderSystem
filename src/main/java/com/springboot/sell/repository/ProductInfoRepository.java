package com.springboot.sell.repository;

import com.springboot.sell.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: jeff
 * @Date: 2022/1/6 10:30
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    //查找商品的名称与新增商品名称是否冲突
//    Boolean checkoutProductName(String productName);
}
