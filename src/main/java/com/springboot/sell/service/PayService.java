package com.springboot.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.springboot.sell.DTO.OrderDTO;

/**
 * @Author: jeff
 * @Date: 15/2/2022 下午 4:23
 */

public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);

}
