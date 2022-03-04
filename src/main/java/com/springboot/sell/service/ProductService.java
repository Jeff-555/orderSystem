package com.springboot.sell.service;

import com.springboot.sell.DTO.CartDTO;
import com.springboot.sell.dataObject.ProductInfo;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: jeff
 * @Date: 2022/1/6 11:27
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);


    //校验商品
//    ProductInfo findOne(String productName);
}
