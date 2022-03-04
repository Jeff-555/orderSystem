package com.springboot.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.springboot.sell.DTO.OrderDTO;
import com.springboot.sell.Exception.SellException;
import com.springboot.sell.emuns.ResultEnum;
import com.springboot.sell.service.OrderService;
import com.springboot.sell.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * * DispatcherServlet 前端控制器
 * * ModelAndView(freeMarker模板引擎)
 * * {程序返回的待解析的模型和视图
 * * 通过DispatcherServlet。视图可以采用String的形式
 * * 视图名，需要由ViewResolver对象解析;
 * * 也可以直接指定View对象。该模型
 * * 是一个Map，允许使用多个对象的名称键。}
 * Decode是解码和Encode编码，参考java8文档
 *
 * @Author: jeff
 * @Date: 15/2/2022 下午 4:22
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;


    //前端支付界面触发
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) throws UnsupportedEncodingException {
        //1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2. 发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
//        returnUrl = URLDecoder.decode(returnUrl, "UTF-8");

        map.put("returnUrl", returnUrl.startsWith("http://") ? returnUrl : URLDecoder.decode(returnUrl, "utf-8"));
        System.out.println(map.get("returnUrl"));
//        map.put("returnUrl", returnUrl);
        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信异步通知
     * https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7&index=8
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        return new ModelAndView("pay/success");
    }
}
