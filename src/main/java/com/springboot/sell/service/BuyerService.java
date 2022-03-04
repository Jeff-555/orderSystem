package com.springboot.sell.service;

import com.springboot.sell.DTO.OrderDTO;

/**
 * @Author: jeff
 * @Date: 18/1/2022 4:51 PM
 * 用于限制买家的越权行为的service
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    void cancelOrder(String openid, String orderId);
}
