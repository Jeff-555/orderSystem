package com.springboot.sell.service.impl;

import com.springboot.sell.dataObject.SellerInfo;
import com.springboot.sell.repository.SellerInfoRepository;
import com.springboot.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: jeff
 * @Date: 26/2/2022 上午 10:31
 */
@Service
public class SellerServiceImpl implements SellerService {


    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
