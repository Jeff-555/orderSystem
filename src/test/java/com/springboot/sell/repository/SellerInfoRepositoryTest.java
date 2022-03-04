package com.springboot.sell.repository;

import com.springboot.sell.dataObject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: jeff
 * @Date: 26/2/2022 上午 10:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {


    private final String openid = "wasd";


    @Autowired
    private SellerInfoRepository repository;


    @Test
    @Transactional
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId("555");
        sellerInfo.setUsername("test");
        sellerInfo.setPassword("test");
        sellerInfo.setOpenid("88888");
        repository.save(sellerInfo);
    }


    @Test
    public void findByOpenid() {
        SellerInfo result = repository.findByOpenid(openid);
        Assert.assertEquals(openid, result.getOpenid());
    }
}