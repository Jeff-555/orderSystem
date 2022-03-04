package com.springboot.sell.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.sell.dataObject.OrderDetail;
import com.springboot.sell.emuns.OrderStatusEnum;
import com.springboot.sell.emuns.PayStatusEnum;
import com.springboot.sell.utils.EnumUtil;
import com.springboot.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: jeff
 * @Date: 2022/1/8 15:51
 * 数据传输对象（DTO），到时部分拷贝到对应实体类
 * JsonIgnore不反悔前端
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /*订单id。*/
    private String orderId;

    /*买家名字。*/
    private String buyerName;

    /*买家电话。*/
    private String buyerPhone;

    /*买家地址。*/
    private String buyerAddress;

    /*买家openid。*/
    private String buyerOpenid;

    /*订单总金额。*/
    private BigDecimal orderAmount;

    /*订单状态，默认0新下单*/
    private Integer orderStatus;

    /*支付状态，默认0未支付*/
    private Integer payStatus;

    /*创建时间JsonSerialize通过using属性，添加控制规定的格式化输出的类*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /*更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList = new ArrayList<>();

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
