package com.springboot.sell.repository;

import com.springboot.sell.dataObject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: jeff
 * @Date: 2022/1/8 10:29
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /*利用分页查询*/
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
