package com.springboot.sell.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: jeff
 * @Date: 2022/1/8 10:14
 */
@Entity
@Data
@DynamicInsert
public class OrderDetail {

    /*订单详情id*/
    @Id
    private String detailId;

    /*订单id*/
    private String orderId;

    /*商品id*/
    private String productId;

    /*商品名称*/
    private String productName;

    /*商品价格*/
    private BigDecimal productPrice;

    /*商品库存*/
    private Integer productQuantity;

    /*商品小图*/
    private String productIcon;

//    /*创建时间*/
//    private Date createTime;
//
//    /*更新时间*/
//    private Date updateTime;
}
