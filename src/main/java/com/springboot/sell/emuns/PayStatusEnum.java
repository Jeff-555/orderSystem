package com.springboot.sell.emuns;

import lombok.Getter;

/**
 * @Author: jeff
 * @Date: 2022/1/8 10:10
 */
@Getter
public enum PayStatusEnum implements CodeEnum{
    WAIT(0, "未支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
