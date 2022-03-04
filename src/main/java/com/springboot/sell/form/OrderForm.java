package com.springboot.sell.form;

import lombok.Data;
//import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotEmpty;
/**
 * @Author: jeff
 * @Date: 14/1/2022 4:56 PM
 * 用于controller的表单验证
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "电话不能为空")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址不能为空")
    private String address;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "用户的微信openid不能为空")
    private String openid;

    /**
     * 买家购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
