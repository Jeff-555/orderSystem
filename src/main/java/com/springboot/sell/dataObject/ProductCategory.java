package com.springboot.sell.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: jeff
 * @Date: 2022/1/4 16:58
 * ProductCategory必须对应数据库product_category字段
 * DynamicUpdate这个注解在事务中可以控制更新时间，无需添加创建时间、更新时间的属性。
 * Data 注解省略属性get、set、toStirng等方法
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    @Id
    @GeneratedValue //属性自增
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory (String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {

    }
}
