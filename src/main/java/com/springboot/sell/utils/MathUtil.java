package com.springboot.sell.utils;

/**
 * @Author: jeff
 * @Date: 17/2/2022 下午 3:55
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较2个金额是否相等，金额校验（如0.01...、0.010等）
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1, Double d2) {
        double result = Math.abs(d1 - d2);
        return result < MONEY_RANGE;
        /**
         *         Double result = Math.abs(d1 - d2);
         *         if (result < MONEY_RANGE) {
         *             return true;
         *         }else {
         *             return false;
         *         }
         */
    }
}

