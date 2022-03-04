-- drop database if exists sell ;
-- create database sell;
/** 
	微信点餐系统——数据库
	Author: Jeff
细节：
    unique添加唯一约束
	timestamp安装MySQL的时间类型,是MySQL内置参数
	current_timestamp是Mysql自动创建时间的参数
	on update current_timestamp是根据current_timestamp参数来自动更新
**/
		
use sell;
-- 商品表
create table `product_info` (
	`product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,2) not null comment '单价',
    `product_stock` int not null comment '库存',
    `product_icon` varchar(512) not null comment '小图',
    `product_description` varchar(64) comment '商品描述',
    `category_type` int not null comment '类目编号',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp 
		comment '修改时间',
	primary key (`product_id`)
) comment '商品表';

-- 类目表
create table `product_category` (
	`category_id` int not null auto_increment,
    `category_name` varchar(64) not null comment '类目名字',
    `category_type` int not null comment '类目编号',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp
comment '修改时间',
	primary key (`category_id`),
    unique key uqe_category_type (`category_type`)
) comment '类目表';

-- 订单表
create table `order_master` (
	`order_id` varchar(32) not null,
    `buyer_name` varchar(32) not null comment '买家姓名',
    `buyer_phone` varchar(32) not null comment '买家电话',
    `buyer_address` varchar(128) not null comment '买家地址',
    `buyer_openid` varchar(64) not null comment '买家微信openid',
    `order_amount` decimal(8,2) not null comment '订单总金额',
    `order_status` tinyint(3) not null default '0' comment '订单状态,默认0新下单',
    `pay_status` tinyint(3) not null default '0' comment '支付状态,默认0未支付',
    `create_time` timestamp default current_timestamp comment '创建时间',
    `update_time` timestamp default current_timestamp on update current_timestamp
		comment '修改时间',
	primary key (`order_id`),
    key `idx_buyer_openid` (`buyer_openid`)
) comment '订单表';

-- 订单详情表  这里可以加一个order_amount但也可以同业务层取出详情里商品价格,通过封装生成总价再返回前端
create table `order_detail` (
	`detail_id` varchar(32) not null,
    `order_id` varchar(32) not null comment '订单id',
    `product_id` varchar(32) not null comment '商品id',
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,4) not null comment '商品价格',
    `product_quantity` int not null comment '商品数量',
    `product_icon` varchar(512) comment '商品小图',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp
		comment '修改时间',
	primary key (`detail_id`),
    key `idx_order_id` (`order_id`)
) comment '订单详情表';


-- 卖家信息表
create table `seller_info` (
    `seller_id`  VARCHAR(32) NOT NULL,
    `username`   VARCHAR(32) NOT NULL,
    `password`   VARCHAR(32) NOT NULL,
    `openid`    VARCHAR(64) NOT NULL COMMENT '微信openid',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    PRIMARY KEY (seller_id)
) comment '卖家信息表';

