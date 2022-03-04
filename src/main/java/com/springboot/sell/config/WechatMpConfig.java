package com.springboot.sell.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: jeff
 * @Date: 9/2/2022 下午 1:34
 * Bean注解是让IOC容器来识别并注册该组件到容器中，把创建的权限交给spring（代理），通过AutoWired来注入和创建
 * WxMpInMemoryConfigStorage 基于内存的微信配置provider，在实际生产环境中应该将这些配置持久化
 * WxMpService是微信API的MpService，主要用于被赋值AppId等数据（setWxMpConfigStorage(微信客户端的存储配置))
 */
@Component
public class WechatMpConfig {


    @Autowired
    private WechatAccountConfig accountConfig;


    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(this.wxMpConfigStorage());
        return wxMpService;
    }

    @Autowired
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpInMemoryConfigStorage.setAppId(accountConfig.getMpAppId());
        wxMpInMemoryConfigStorage.setSecret(accountConfig.getMpAppSecret());
        return wxMpInMemoryConfigStorage;
    }

}
