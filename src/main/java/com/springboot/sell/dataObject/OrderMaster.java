package com.springboot.sell.dataObject;

import com.springboot.sell.emuns.OrderStatusEnum;
import com.springboot.sell.emuns.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: jeff
 * @Date: 2022/1/8 9:48
 * TODO：可以搜索一些辅助工具，直接实现数据库表字段的映射，无需手动敲打
 */
@Entity //数据库表的映射
@Data // 省略Get Set toString等法
@DynamicUpdate //字段更新，数据表自动更新时间
public class OrderMaster {

    /*订单id。*/
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /*支付状态，默认0未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;

//    @Transient  //Transient注解不会把当前字段传入数据库
//    private List<OrderDetail> orderDetailList;
}
