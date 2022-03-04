package com.springboot.sell.service;

import com.springboot.sell.dataObject.SellerInfo;

/**
 * @Author: jeff
 * @Date: 26/2/2022 上午 10:30
 */

public interface SellerService {


    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
