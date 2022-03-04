package com.springboot.sell.repository;

import com.springboot.sell.dataObject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: jeff
 * @Date: 2022/1/8 10:33
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /*通过订单id查询，显示多条订单商品详情*/
    List<OrderDetail> findByOrderId(String orderId);
}
