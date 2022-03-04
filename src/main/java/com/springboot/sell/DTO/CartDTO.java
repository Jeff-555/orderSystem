package com.springboot.sell.DTO;

import lombok.Data;

/**
 * @Author: jeff
 * @Date: 2022/1/8 17:31
 * 购物车对应API文档的items字段
 */
@Data
public class CartDTO {

    /*商品ID.*/
    private String productId;

    /*数量.*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
