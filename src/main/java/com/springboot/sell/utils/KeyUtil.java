package com.springboot.sell.utils;

import java.util.Random;

/**
 * @Author: jeff
 * @Date: 2022/1/8 16:51
 * 用于生成主键
 * 涉及到时间必须加synchronized同步，防止多线程进行时出现重复
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     */
    public synchronized static String genUniqueKey() {
        Random random = new Random();
        /*限制生成6位 最小从100000开始不超过1000000（900000+100000）*/
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
