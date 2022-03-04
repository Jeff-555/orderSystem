package com.springboot.sell.repository;

import com.springboot.sell.dataObject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: jeff
 * @Date: 26/2/2022 上午 10:09
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
