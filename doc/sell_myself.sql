-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 192.168.8.117    Database: sell
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `detail_id` varchar(32) CHARACTER SET latin1 NOT NULL,
  `order_id` varchar(32) NOT NULL COMMENT '订单id',
  `product_id` varchar(32) CHARACTER SET latin1 NOT NULL COMMENT '商品id',
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '商品价格',
  `product_quantity` int(11) NOT NULL COMMENT '购买的商品数量',
  `product_icon` varchar(512) DEFAULT NULL COMMENT '商品小图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES ('1641698453183199217','1641698453147717663','345678','茶叶蛋',2.00,2,'http://test.jpg','2022-01-09 03:20:52','2022-01-09 03:20:52'),('1641698703507123086','1641698703472465158','345678','茶叶蛋',2.00,1,'http://test.jpg','2022-01-09 03:25:02','2022-01-09 03:25:02'),('1641698703518119139','1641698703472465158','56789','油条',3.50,3,'http://test.jpg','2022-01-09 03:25:02','2022-01-09 03:25:02'),('1642240070699516379','1642240070687940470','345678','茶叶蛋',2.00,2,'http://test.jpg','2022-01-15 09:47:50','2022-01-15 09:47:50'),('1642240367528239681','1642240367521135973','56789','油条',3.50,2,'http://test.jpg','2022-01-15 09:52:47','2022-01-15 09:52:47'),('1642240455886533095','1642240455852979537','56789','油条',3.50,2,'http://test.jpg','2022-01-15 09:54:15','2022-01-15 09:54:15'),('1642240499426173974','1642240499387996285','56789','油条',3.50,2,'http://test.jpg','2022-01-15 09:54:59','2022-01-15 09:54:59'),('1642240602228988315','1642240602189831143','56789','油条',3.50,2,'http://test.jpg','2022-01-15 09:56:41','2022-01-15 09:56:41'),('1642386389359915858','1642386389345742603','56789','油条',3.50,2,'http://test.jpg','2022-01-15 13:30:26','2022-01-15 13:30:26'),('1642388540952820438','1642388540917939103','56789','油条',3.50,2,'http://test.jpg','2022-01-15 14:09:17','2022-01-15 14:09:17'),('1644218703948910598','1644218703940621964','345678','茶叶蛋',2.00,2,'http://test.jpg','2022-02-06 14:47:12','2022-02-06 14:47:12'),('1644562539513807332','1644562539500504926','345678','米饭',2.00,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-11 06:55:39','2022-02-11 06:55:39'),('1644562539537657393','1644562539500504926','123456','皮蛋粥',3.50,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-11 06:55:39','2022-02-11 06:55:39'),('1644562539547318407','1644562539500504926','56789','鸡翅',3.50,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-11 06:55:39','2022-02-11 06:55:39'),('1644562540736585043','1645109696204418448','345678','米饭',2.00,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-11 06:55:40','2022-02-17 12:13:08'),('1645110792641447332','1645110792634777770','345678','米饭',2.00,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-17 12:28:13','2022-02-17 12:28:13'),('1645112089697639961','1645112089684929359','345678','米饭',2.00,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-17 12:51:38','2022-02-17 12:51:38'),('1645149075710738794','1645149075671751859','345678','米饭',2.00,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-18 01:51:15','2022-02-18 01:51:15'),('1645150890501418221','1645150890467343339','345678','米饭',2.00,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-18 02:21:29','2022-02-18 02:21:29'),('1645152962728723271','1645152962692218440','345678','米饭',2.00,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-18 02:56:02','2022-02-18 02:56:02'),('1645152968308649206','1645152968303504973','345678','米饭',2.00,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-18 02:56:07','2022-02-18 02:56:07'),('1646122205228667341','1646122205219787230','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 22:10:52','2022-02-27 22:10:52'),('1646122474368573751','1646122474331743480','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 22:15:43','2022-02-27 22:15:43'),('1646124203816576044','1646124203804577055','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 22:46:57','2022-02-27 22:46:57'),('1646125761460502772','1646125761445591103','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:15:04','2022-02-27 23:15:04'),('1646125838084523558','1646125838070733360','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:16:27','2022-02-27 23:16:27'),('1646125908820374002','1646125908808892905','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:17:44','2022-02-27 23:17:44'),('1646125925250314864','1646125925245652166','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:18:01','2022-02-27 23:18:01'),('1646126088828834859','1646126088817787708','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:20:59','2022-02-27 23:20:59'),('1646126156633459592','1646126156619181757','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:22:12','2022-02-27 23:22:12'),('1646126207385685807','1646126207371146940','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:23:07','2022-02-27 23:23:07'),('1646126264127564439','1646126264121950619','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:24:09','2022-02-27 23:24:09'),('1646126273130959349','1646126273125830342','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:24:18','2022-02-27 23:24:18'),('1646126336891312719','1646126336877497417','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:25:27','2022-02-27 23:25:27'),('1646126357547197295','1646126357539566612','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:25:50','2022-02-27 23:25:50'),('1646126946110409507','1646126946099425219','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-27 23:36:27','2022-02-27 23:36:27'),('1646128783917284001','1646128783881531848','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-28 00:09:38','2022-02-28 00:09:38'),('1646128785091404727','1646128785086368526','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-28 00:09:40','2022-02-28 00:09:40'),('1646128788475830192','1646128788467895111','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-28 00:09:43','2022-02-28 00:09:43'),('1646128801963976360','1646128801958366427','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-28 00:09:58','2022-02-28 00:09:58'),('1646128820115421835','1646128820110516403','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-02-28 00:10:18','2022-02-28 00:10:18'),('1646208074961175639','1646208074948556795','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-03-02 08:01:13','2022-03-02 08:01:13'),('1646208323586282785','1646208323573248359','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-03-02 08:05:22','2022-03-02 08:05:22'),('1646208464016644369','1646208464003470128','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-03-02 08:07:42','2022-03-02 08:07:42'),('1646208485130886704','1646208485124578868','345678','米饭',0.01,2,'http://img.springboot.cn/5dc3891e0001049611251125.jpg','2022-03-02 08:08:04','2022-03-02 08:08:04'),('333333','123456','345678','甜糕',2.00,5,'http:xxx.jpg','2022-01-08 03:33:10','2022-01-08 04:31:19'),('3333332','123456','345678','茶叶蛋',2.00,4,'http:xxx.jpg','2022-01-08 03:36:48','2022-01-08 04:31:19'),('59998777','1234562','345678','茶叶蛋',2.00,4,'http:xxx.jpg','2022-01-08 03:36:48','2022-01-08 04:31:19');
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_master`
--

DROP TABLE IF EXISTS `order_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_master` (
  `order_id` varchar(32) CHARACTER SET latin1 NOT NULL,
  `buyer_name` varchar(32) NOT NULL COMMENT '买家姓名',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) CHARACTER SET latin1 NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态,默认0新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态,默认0未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_master`
--

LOCK TABLES `order_master` WRITE;
/*!40000 ALTER TABLE `order_master` DISABLE KEYS */;
INSERT INTO `order_master` VALUES ('123456','小智','1111111','北京','123321',100.00,0,0,'2022-01-08 03:19:56','2022-02-18 17:15:02'),('1234562','小智','1111111','北京','123321',100.00,1,0,'2022-01-08 03:20:35','2022-02-22 03:53:38'),('1641698453147717663','tester','test_phone','test_address','110110110',4.00,0,0,'2022-01-09 03:20:52','2022-02-20 07:51:08'),('1641698703472465158','tester','test_phone','test_address','110110110',12.50,1,0,'2022-01-09 03:25:02','2022-02-27 16:52:17'),('1642240070687940470',' 张三',' 18868822111',' 慕课网总部',' ew3euwhd7sjw9diwkq',4.00,0,0,'2022-01-15 09:47:50','2022-02-20 07:51:08'),('1642240367521135973',' 张三',' 18868822111',' 慕课网总部',' ew3euwhd7sjw9diwkq',7.00,0,0,'2022-01-15 09:52:47','2022-02-20 07:51:08'),('1642240602189831143',' 张三',' 18868822111',' 慕课网总部',' ew3euwhd7sjw9diwkq',7.00,0,0,'2022-01-15 09:56:59','2022-02-18 17:28:38'),('1642386389345742603',' 张三',' 18868822111',' 慕课网总部',' ew3euwhd7sjw9diwkq',7.00,0,0,'2022-01-15 13:30:26','2022-02-20 07:51:08'),('1642388540917939103',' 张三',' 18868822111',' 慕课网总部',' ew3euwhd7sjw9diwkq',7.00,0,0,'2022-01-15 14:09:17','2022-02-20 07:51:08'),('1644218703940621964',' 张三',' 18868822111',' 慕课网总部','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-06 14:47:12','2022-02-20 07:51:08'),('1644562539500504926','test','test','test。','oTo5D6N2uTfC3Qi52O6TRhAg_mk4',0.01,0,0,'2022-02-11 06:55:39','2022-02-20 07:51:08'),('1645109696204418448','test',' test','test','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.01,0,0,'2022-02-17 12:08:25','2022-02-20 07:51:08'),('1645110792634777770',' 张三','test','test','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-17 12:28:13','2022-02-20 07:51:08'),('1645112089684929359','test','test','test','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.01,0,0,'2022-02-17 12:51:38','2022-02-20 07:51:08'),('1645149075671751859','test','test','test','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.01,0,0,'2022-02-18 01:51:15','2022-02-20 07:51:08'),('1645150890467343339','test','test','test','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.01,0,0,'2022-02-18 02:21:29','2022-02-20 08:04:09'),('1645152962692218440','test','test','test','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.01,0,0,'2022-02-18 02:56:02','2022-02-20 08:04:09'),('1645152968303504973','test','test','test','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.01,2,0,'2022-02-18 02:56:07','2022-02-22 03:53:47'),('1646122205219787230','test33','test33','test33','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 22:10:52','2022-02-27 22:10:52'),('1646122474331743480','test33','test33','test33','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 22:15:43','2022-02-27 22:15:43'),('1646124203804577055','test33','test33','test33','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 22:46:57','2022-02-27 22:46:57'),('1646125761445591103','test44','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:15:04','2022-02-27 23:15:04'),('1646125838070733360','test44','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:16:27','2022-02-27 23:16:27'),('1646125908808892905','test44','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:17:44','2022-02-27 23:17:44'),('1646125925245652166','test44','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:18:01','2022-02-27 23:18:01'),('1646126088817787708','test44','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:20:59','2022-02-27 23:20:59'),('1646126156619181757','test44','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:22:12','2022-02-27 23:22:12'),('1646126207371146940','test44','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:23:07','2022-02-27 23:23:07'),('1646126264121950619','test445','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:24:09','2022-02-27 23:24:09'),('1646126273125830342','test445','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:24:18','2022-02-27 23:24:18'),('1646126336877497417','test445','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:25:27','2022-02-27 23:25:27'),('1646126357539566612','test445','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:25:50','2022-02-27 23:25:50'),('1646126946099425219','test445','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-27 23:36:27','2022-02-27 23:36:27'),('1646128783881531848','test445','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-28 00:09:38','2022-02-28 00:09:38'),('1646128785086368526','test445','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-28 00:09:40','2022-02-28 00:09:40'),('1646128788467895111','test445','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-28 00:09:43','2022-02-28 00:09:43'),('1646128801958366427','test445','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-28 00:09:58','2022-02-28 00:09:58'),('1646128820110516403','test445','test44','test44','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-02-28 00:10:18','2022-02-28 00:10:18'),('1646208074948556795','test77','test77','test77','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-03-02 08:01:13','2022-03-02 08:01:13'),('1646208323573248359','test77','test77','test77','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-03-02 08:05:22','2022-03-02 08:05:22'),('1646208464003470128','test77','test77','test77','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-03-02 08:07:43','2022-03-02 08:07:43'),('1646208485124578868','test77','test77','test77','oTgZpwQWA7ip6eEge1OJ_P_-bGu0',0.02,0,0,'2022-03-02 08:08:04','2022-03-02 08:08:04');
/*!40000 ALTER TABLE `order_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `uqe_category_type` (`category_type`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='类目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,'热销榜',22,'2022-01-04 09:27:38','2022-02-23 10:11:17'),(2,'最近7天',4,'2022-01-04 11:38:31','2022-01-04 11:51:01'),(4,'最近一个月',3,'2022-01-04 11:41:43','2022-01-04 11:41:43'),(9,'最近半年',110,'2022-01-04 11:38:31','2022-02-23 10:11:26'),(11,'最近一年',5,'2022-01-04 11:59:43','2022-01-04 11:59:43'),(12,'新星榜',6,'2022-01-04 12:14:33','2022-01-04 12:14:33'),(13,'会员尊享',51,'2022-02-23 10:11:54','2022-02-23 10:12:04'),(16,'test',55,'2022-02-27 06:27:29','2022-02-27 06:27:29'),(17,'经典榜',105,'2022-03-02 08:38:39','2022-03-02 08:38:39'),(18,'经典榜',106,'2022-03-02 08:40:18','2022-03-02 08:40:18');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_info`
--

DROP TABLE IF EXISTS `product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_info` (
  `product_id` varchar(32) CHARACTER SET latin1 NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_icon` varchar(512) CHARACTER SET latin1 NOT NULL COMMENT '小图',
  `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
  `product_description` varchar(64) DEFAULT NULL COMMENT '商品描述',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_info`
--

LOCK TABLES `product_info` WRITE;
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` VALUES ('123456','皮蛋粥',2.00,700,'http://img.springboot.cn/5dc3891e0001049611251125.jpg',0,'很好喝的粥',6,'2022-01-06 02:57:43','2022-03-04 10:20:53'),('1645509691774846149','烧鸭米粉',5.00,500,'http://img.springboot.cn/5dc3891e0001049611251125.jpg',0,'很好吃的烧鸭',6,'2022-02-22 06:01:31','2022-03-04 10:21:10'),('1645509767322534591','烧鸭米粉',0.03,500,'http://img.springboot.cn/5dc3891e0001049611251125.jpg',0,'很好吃的烧鸭',2,'2022-02-22 06:02:46','2022-03-04 10:20:19'),('345678','米饭',0.01,500,'http://img.springboot.cn/5dc3891e0001049611251125.jpg',1,'很好吃的米饭',1,'2022-01-06 04:49:14','2022-03-04 10:20:19'),('56789','鸡翅',0.01,500,'http://img.springboot.cn/5dc3891e0001049611251125.jpg',0,'很好吃的鸡翅',6,'2022-01-06 04:53:57','2022-03-04 10:20:19');
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller_info`
--

DROP TABLE IF EXISTS `seller_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller_info` (
  `seller_id` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `openid` varchar(64) NOT NULL COMMENT '微信openid',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='卖家信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller_info`
--

LOCK TABLES `seller_info` WRITE;
/*!40000 ALTER TABLE `seller_info` DISABLE KEYS */;
INSERT INTO `seller_info` VALUES ('1','test','test','wasd','2022-02-26 02:16:15','2022-02-26 02:16:15'),('2354','test','test','oTgZpwQWA7ip6eEge1OJ_P_-bGu0','2022-02-27 13:11:31','2022-02-27 13:11:31'),('334','test','test','456789','2022-02-27 13:17:44','2022-02-27 13:21:18'),('555','test','test','88888','2022-02-26 02:26:49','2022-02-26 02:26:49'),('666','test','test','071mmDkl20T0J84DkUml2VtUXh2mmDkA','2022-02-27 13:31:00','2022-02-27 13:31:00');
/*!40000 ALTER TABLE `seller_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-05  1:00:27
