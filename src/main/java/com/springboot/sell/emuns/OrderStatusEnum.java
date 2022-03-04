package com.springboot.sell.emuns;

import lombok.Getter;

/**
 * @Author: jeff
 * @Date: 2022/1/8 10:05
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
