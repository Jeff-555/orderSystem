package com.springboot.sell.service.impl;

import com.springboot.sell.dataObject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: jeff
 * @Date: 26/2/2022 上午 10:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private final String openid = "88888";

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo result = sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid, result.getOpenid());
    }
}