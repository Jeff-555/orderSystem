package com.springboot.sell.service;

/**
 * @Author: jeff
 * @Date: 2/3/2022 下午 8:00
 * ab测试（商品秒杀）
 */
public interface SecKillService {

    /**
     * 查询秒杀活动价商品的信息
     *
     * @param productId
     * @return
     */
    String querySecKillProductInfo(String productId);


    /**
     * 模拟不同用户秒杀同一商品的请求
     *
     * @param productId
     */
    void orderProductMockDiffUser(String productId);
}
