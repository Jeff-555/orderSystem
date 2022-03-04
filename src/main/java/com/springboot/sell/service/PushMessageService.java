package com.springboot.sell.service;

import com.springboot.sell.DTO.OrderDTO;

/**
 * 推送消息
 * @Author: jeff
 * @Date: 28/2/2022 下午 4:45
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
