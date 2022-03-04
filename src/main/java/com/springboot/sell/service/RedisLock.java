package com.springboot.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: jeff
 * @Date: 3/3/2022 下午 5:13
 * setIfAbsent是redis和springboot整合的方法，如同SETNX(SET IF NOT EXIST)操作，
 * 如果redis没key则set返回1，如果redis有key则返回0
 * getAndSet 获得和设置key，value
 * <p>
 * 实现分布式锁（加锁和解锁操作）
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁（互斥）
     * 多个线程携带值同时访问，只能其中一个拿到锁（true）。
     * 例如:参数<Key,value>（<A,B>,<A,B>,<B,C>,<B,D>,<A,D>,<A,B> ......)
     *
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        // 不存在的键值占用则直接设置，返回
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            System.out.println("加锁成功01！");
            return true;
        }

        /**
         * 如：已存在的键值<A,B>,通过get(Key A)得到value B（currentValue）,
         * 当并发量大时候后面线程<?,?>也有可能同时进入(?可以是A、B等键或值），
         * 当前项目键属于锁定key为productId，所以只需要判断value（<A,?>）
         * 后续通过 @link来判断
         */
        //FIXME 只能单个线程访问这行代码
        String currentValue = redisTemplate.opsForValue().get(key);

        //如果锁过期
        if (!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue) < System.currentTimeMillis()) {

            /**
             * FIXME 多个线程访问以下代码时，并发线程携带参数<A,?>。假设经过currentValue的线程顺利到newValue线程，两个值，都一样则判断返回true。如果currentValue和newValue不是同一个线程但拿到的值相等，相当于重叠作用也则返回true。
             */
            String newValue = redisTemplate.opsForValue().getAndSet(key, value);
            //@link
            if (!StringUtils.isEmpty(newValue) && newValue.equals(currentValue)) {
                System.out.println("加锁成功02！");
                return true;
            }
        }
        //如果锁没过期，或者currentValue和oldValue不相同
        return false;
    }


    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
                System.out.println("解锁成功！");
            }
        } catch (Exception e) {
            log.error("【redis分布式锁】解锁异常, {}", e);
        }
    }
}

