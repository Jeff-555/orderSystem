package com.springboot.sell.Constant;

/**
 * @Author: jeff
 * @Date: 27/2/2022 下午 1:56
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    /**
     * 生命周期：两个小时
     */
    Integer EXPIRE = 7200;
}
