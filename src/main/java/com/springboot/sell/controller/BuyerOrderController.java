package com.springboot.sell.controller;

import com.springboot.sell.DTO.OrderDTO;
import com.springboot.sell.Exception.SellException;
import com.springboot.sell.VO.ResultVO;
import com.springboot.sell.converter.OrderForm2OrderDTOConverter;
import com.springboot.sell.emuns.ResultEnum;
import com.springboot.sell.form.OrderForm;
import com.springboot.sell.service.BuyerService;
import com.springboot.sell.service.OrderService;
import com.springboot.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: jeff
 * @Date: 14/1/2022 4:50 PM
 * PostMapping 用于提交和更新  RequestMapping 用于查询
 * Valid 用于定位校验表单，BindingResult则通过Valid调用表单里面的具体属性并做出判断
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private final OrderService orderService;

    public BuyerOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //创建订单 success
    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确,orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {

        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

//        PageRequest request = new PageRequest(page, size);
        PageRequest request = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    //查询订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam(value = "openid",defaultValue = "") String openid,
                                     @RequestParam(value = "orderId",defaultValue = "") String orderId) {
        if (openid.equals("") || orderId.equals("")) {
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
        /**
         * 会出现越权访问
         * OrderDTO orderDTO = orderService.findOne(orderId);
         *         return ResultVOUtil.success(orderDTO);
         */
    }

    //取消订单
    @Transactional
    @PostMapping("cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
        /**
         * 会出现越权访问
         *         OrderDTO orderDTO = orderService.findOne(orderId);
         *         orderService.cancel(orderDTO);
         * */
    }
}
