package com.springboot.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品信息表（根据业务进行筛选，给前端）
 *
 * @Author: jeff
 * @Date: 2022/1/7 9:53
 * JsonProperty返回给前端的替名
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = -1113296869361554902L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
