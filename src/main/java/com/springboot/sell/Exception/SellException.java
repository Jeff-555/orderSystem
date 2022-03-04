package com.springboot.sell.Exception;

import com.springboot.sell.emuns.ResultEnum;
import lombok.Getter;

/**
 * @Author: jeff
 * @Date: 2022/1/8 16:36
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);

        this.code = code;
    }
}
