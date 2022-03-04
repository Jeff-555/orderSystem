package com.springboot.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: jeff
 * @Date: 22/2/2022 下午 1:42
 */
@Data
public class ProductForm {


    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}
