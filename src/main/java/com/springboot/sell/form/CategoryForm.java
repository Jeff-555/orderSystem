package com.springboot.sell.form;

import lombok.Data;

/**
 * @Author: jeff
 * @Date: 23/2/2022 下午 6:02
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;
}
