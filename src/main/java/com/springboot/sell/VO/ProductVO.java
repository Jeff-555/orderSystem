package com.springboot.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类目
 *
 * @Author: jeff
 * @Date: 2022/1/7 9:51
 * JsonProperty用于返回给前端的代替名
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -6735050411898152327L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
