package com.springboot.sell.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.springboot.sell.DTO.OrderDTO;
import com.springboot.sell.Exception.SellException;
import com.springboot.sell.dataObject.OrderDetail;
import com.springboot.sell.emuns.ResultEnum;
import com.springboot.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author: jeff
 * @Date: 14/1/2022 5:33 PM
 * Gson用于将字符转成json格式，返回前端
 * TypeToken<T> 后面记得要加{}才能生成对象
 */
@Slf4j
public class OrderForm2OrderDTOConverter {


    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());


        List<OrderDetail> orderDetailList;
        try {
//            把Item(string)转成List<OrderDetail>
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            log.error("【对象转换】错误,string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }


}
