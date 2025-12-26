-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: inventoryx00baf6t
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `inventoryx00baf6t`
--

/*!40000 DROP DATABASE IF EXISTS `inventoryx00baf6t`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `inventoryx00baf6t` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `inventoryx00baf6t`;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(200) DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  `type` int(11) DEFAULT NULL COMMENT '参数Type',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg',NULL,1),(2,'picture2','upload/picture2.jpg',NULL,1),(3,'picture3','upload/picture3.jpg',NULL,1),(11,'baidu','{\"appId\":\"49214550\",\"apiKey\":\"7Otjpv2kn0ljQk45qXOXh5MO\",\"secretKey\":\"BMfbXRbTIVaB4C3SbRTtGqDv1wHDvyXS\"}',NULL,2),(21,'bLoginBackgroundImg','',NULL,3),(22,'bRegisterBackgroundImg','',NULL,3),(23,'bIndexBackgroundImg','',NULL,3),(24,'bTopLogo','',NULL,3),(25,'bHomeLogo','',NULL,3);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guihaishebei`
--

DROP TABLE IF EXISTS `guihaishebei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guihaishebei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shebeibianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Num',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Name',
  `shebeifenlei` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Type',
  `shebeifengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT 'E-Cover',
  `jiechushuliang` int(11) DEFAULT NULL COMMENT 'Loan-Num',
  `keyongshuliang` int(11) DEFAULT NULL COMMENT 'BackNum',
  `zhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Account',
  `xingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Name',
  `leixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Type',
  `guihaishijian` date DEFAULT NULL COMMENT 'Backtime',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Return equipment';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guihaishebei`
--

LOCK TABLES `guihaishebei` WRITE;
/*!40000 ALTER TABLE `guihaishebei` DISABLE KEYS */;
INSERT INTO `guihaishebei` VALUES (1,'2025-11-28 08:57:57','E-Num1','激光打印机','办公设备','upload/guihaishebei_TE0061.jpg,upload/guihaishebei_TE0062.jpg,upload/guihaishebei_TE0063.jpg',1,1,'101','刘洋','Student','2025-11-28'),(2,'2025-11-28 08:57:57','E-Num2','语音室终端','语言教学设备','upload/guihaishebei_TE0171.jpg,upload/guihaishebei_TE0172.jpg,upload/guihaishebei_TE0173.jpg',2,2,'107','刘强','Teacher','2025-11-28'),(3,'2025-11-28 08:57:57','E-Num3','电子白板软件','教学辅助软件','upload/guihaishebei_TE0191.jpg,upload/guihaishebei_TE0192.jpg,upload/guihaishebei_TE0193.jpg',3,3,'103','王磊','Teacher','2025-11-28'),(4,'2025-11-28 08:57:57','E-Num4','绘图仪','工程设备','upload/guihaishebei_TE0161.jpg,upload/guihaishebei_TE0162.jpg,upload/guihaishebei_TE0163.jpg',4,4,'105','陈明','Teacher','2025-11-28'),(5,'2025-11-28 08:57:57','E-Num5','恒温培养箱','生物实验设备','upload/guihaishebei_TE0151.jpg,upload/guihaishebei_TE0152.jpg,upload/guihaishebei_TE0153.jpg',5,5,'108','王明','Teacher','2025-11-28'),(6,'2025-11-28 08:57:57','E-Num6','虚拟现实头盔','虚拟现实设备','upload/guihaishebei_TE0131.jpg,upload/guihaishebei_TE0132.jpg,upload/guihaishebei_TE0133.jpg',6,6,'104','李静','Student','2025-11-28'),(7,'2025-11-28 08:57:57','E-Num7','3D打印机','智能制造设备','upload/guihaishebei_TE0071.jpg,upload/guihaishebei_TE0072.jpg,upload/guihaishebei_TE0073.jpg',7,7,'102','王静','Teacher','2025-11-28'),(8,'2025-11-28 08:57:57','E-Num8','光谱仪','分析仪器','upload/guihaishebei_TE0101.jpg,upload/guihaishebei_TE0102.jpg,upload/guihaishebei_TE0103.jpg',8,8,'106','孙俪','Student','2025-11-28'),(9,'2025-11-28 09:05:51','1764320484962','投影仪','影像设备','upload/1764320507378_385.jpg',5,5,'11','张静','Student','2025-11-29');
/*!40000 ALTER TABLE `guihaishebei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiechushebei`
--

DROP TABLE IF EXISTS `jiechushebei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiechushebei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shebeibianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Num',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Name',
  `shebeifenlei` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Type',
  `shebeifengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT 'E-Cover',
  `jiechushuliang` int(11) DEFAULT NULL COMMENT 'Loan-Num',
  `keyongshuliang` int(11) DEFAULT NULL COMMENT 'LoanNum',
  `jieyongshijian` date DEFAULT NULL COMMENT 'Loantime',
  `guihaishijian` date DEFAULT NULL COMMENT 'Backtime',
  `zhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Account',
  `xingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Name',
  `leixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Type',
  `zhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Status',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT 'Pending review' COMMENT 'SUREReview',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT 'Reply',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Lend equipment';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiechushebei`
--

LOCK TABLES `jiechushebei` WRITE;
/*!40000 ALTER TABLE `jiechushebei` DISABLE KEYS */;
INSERT INTO `jiechushebei` VALUES (1,'2025-11-28 08:57:57','E-Num1','激光打印机','办公设备','upload/jiechushebei_TE0061.jpg,upload/jiechushebei_TE0062.jpg,upload/jiechushebei_TE0063.jpg',1,1,'2025-11-28','2025-11-28','101','刘洋','Student','Returned','是',''),(2,'2025-11-28 08:57:57','E-Num2','语音室终端','语言教学设备','upload/jiechushebei_TE0171.jpg,upload/jiechushebei_TE0172.jpg,upload/jiechushebei_TE0173.jpg',2,2,'2025-11-28','2025-11-28','107','刘强','Teacher','Returned','是',''),(3,'2025-11-28 08:57:57','E-Num3','电子白板软件','教学辅助软件','upload/jiechushebei_TE0191.jpg,upload/jiechushebei_TE0192.jpg,upload/jiechushebei_TE0193.jpg',3,3,'2025-11-28','2025-11-28','103','王磊','Teacher','Returned','是',''),(4,'2025-11-28 08:57:57','E-Num4','绘图仪','工程设备','upload/jiechushebei_TE0161.jpg,upload/jiechushebei_TE0162.jpg,upload/jiechushebei_TE0163.jpg',4,4,'2025-11-28','2025-11-28','105','陈明','Teacher','Returned','是',''),(5,'2025-11-28 08:57:57','E-Num5','恒温培养箱','生物实验设备','upload/jiechushebei_TE0151.jpg,upload/jiechushebei_TE0152.jpg,upload/jiechushebei_TE0153.jpg',5,5,'2025-11-28','2025-11-28','108','王明','Teacher','Returned','是',''),(6,'2025-11-28 08:57:57','E-Num6','虚拟现实头盔','虚拟现实设备','upload/jiechushebei_TE0131.jpg,upload/jiechushebei_TE0132.jpg,upload/jiechushebei_TE0133.jpg',6,6,'2025-11-28','2025-11-28','104','李静','Student','Returned','是',''),(7,'2025-11-28 08:57:57','E-Num7','3D打印机','智能制造设备','upload/jiechushebei_TE0071.jpg,upload/jiechushebei_TE0072.jpg,upload/jiechushebei_TE0073.jpg',7,7,'2025-11-28','2025-11-28','102','王静','Teacher','Returned','是',''),(8,'2025-11-28 08:57:57','E-Num8','光谱仪','分析仪器','upload/jiechushebei_TE0101.jpg,upload/jiechushebei_TE0102.jpg,upload/jiechushebei_TE0103.jpg',8,8,'2025-11-28','2025-11-28','106','孙俪','Student','Returned','是',''),(9,'2025-11-28 09:03:09','1764320484962','投影仪','影像设备','upload/1764320507378_385.jpg',5,5,'2025-11-28','2025-11-29','11','张静','Student','Returned','是','可以的');
/*!40000 ALTER TABLE `jiechushebei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `renyuan`
--

DROP TABLE IF EXISTS `renyuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `renyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Account',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Password',
  `xingming` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name',
  `xingbie` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Gender',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT 'Profile picture',
  `leixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Type',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Contact details',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhanghao` (`zhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1764320410944 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Student/Teacher';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renyuan`
--

LOCK TABLES `renyuan` WRITE;
/*!40000 ALTER TABLE `renyuan` DISABLE KEYS */;
INSERT INTO `renyuan` VALUES (11,'2025-11-28 08:57:57','101','123456','刘洋','Female','upload/renyuan_touxiang1.jpg','Student','13512345678'),(12,'2025-11-28 08:57:57','107','123456','刘强','Female','upload/renyuan_touxiang2.jpg','Teacher','13423456789'),(13,'2025-11-28 08:57:57','103','123456','王磊','Female','upload/renyuan_touxiang3.jpg','Teacher','13578901234'),(15,'2025-11-28 08:57:57','108','123456','王明','Male','upload/renyuan_touxiang5.jpg','Teacher','13456789012'),(16,'2025-11-28 08:57:57','104','123456','李静','Female','upload/renyuan_touxiang6.jpg','Student','13590123456'),(17,'2025-11-28 08:57:57','102','123456','王静','Female','upload/renyuan_touxiang7.jpg','Teacher','13478901234'),(18,'2025-11-28 08:57:57','106','123456','孙俪','Male','upload/renyuan_touxiang8.jpg','Student','13534567890'),(1764320391299,'2025-11-28 08:59:51','11','11','张静','Female','upload/1764320386617_803.jpg','Student','13333366521'),(1764320410943,'2025-11-28 09:00:10','22','22','张毅','Male','upload/1764320406343_982.jpg','Teacher','13332254785');
/*!40000 ALTER TABLE `renyuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shebeifenlei`
--

DROP TABLE IF EXISTS `shebeifenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shebeifenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shebeifenlei` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Type',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='E-Type';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shebeifenlei`
--

LOCK TABLES `shebeifenlei` WRITE;
/*!40000 ALTER TABLE `shebeifenlei` DISABLE KEYS */;
INSERT INTO `shebeifenlei` VALUES (1,'2025-11-28 08:57:57','办公设备'),(2,'2025-11-28 08:57:57','语言教学设备'),(3,'2025-11-28 08:57:57','教学辅助软件'),(4,'2025-11-28 08:57:57','工程设备'),(5,'2025-11-28 08:57:57','生物实验设备'),(6,'2025-11-28 08:57:57','虚拟现实设备'),(7,'2025-11-28 08:57:57','智能制造设备'),(8,'2025-11-28 08:57:57','分析仪器'),(9,'2025-11-28 09:01:17','影像设备');
/*!40000 ALTER TABLE `shebeifenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shebeixinxi`
--

DROP TABLE IF EXISTS `shebeixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shebeixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shebeibianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Num',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Name',
  `shebeifenlei` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Type',
  `shebeifengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT 'E-Cover',
  `shebeixinghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Model',
  `shebeipinpai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Brand',
  `shebeiguige` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Specifications',
  `shebeizongshu` int(11) DEFAULT NULL COMMENT 'E-Total',
  `jiechushuliang` int(11) DEFAULT NULL COMMENT 'Loan-Num',
  `keyongshuliang` int(11) DEFAULT NULL COMMENT 'Available',
  `zhuyishixiang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Notes',
  `shebeixiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT 'Equipment Details',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shebeibianhao` (`shebeibianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Equip Information';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shebeixinxi`
--

LOCK TABLES `shebeixinxi` WRITE;
/*!40000 ALTER TABLE `shebeixinxi` DISABLE KEYS */;
INSERT INTO `shebeixinxi` VALUES (1,'2025-11-28 08:57:57','1111111111','激光打印机','办公设备','upload/shebeixinxi_TE0061.jpg,upload/shebeixinxi_TE0062.jpg,upload/shebeixinxi_TE0063.jpg','HPLaserJetProMFPM126nw','惠普','黑白打印，打印速度20ppm',39,1,1,'定期更换硒鼓，保持打印环境清洁','体积小巧，节省空间，适合办公教学文档处理'),(2,'2025-11-28 08:57:57','2222222222','语音室终端','语言教学设备','upload/shebeixinxi_TE0171.jpg,upload/shebeixinxi_TE0172.jpg,upload/shebeixinxi_TE0173.jpg','TopclassTD-200','东方正龙','包含耳机、麦克风、控制面板',64,2,2,'保持耳机清洁，避免麦克风受潮','具备单独听音、分组讨论等功能，提升语言教学效果'),(3,'2025-11-28 08:57:57','3333333333','电子白板软件','教学辅助软件','upload/shebeixinxi_TE0191.jpg,upload/shebeixinxi_TE0192.jpg,upload/shebeixinxi_TE0193.jpg','鸿合π','鸿合','支持手写识别、多媒体资源整合',53,3,3,'定期更新软件版本，避免误OperationDelete资源','提供多种教学工具，如聚光灯、放大镜等，增强教学表现力'),(4,'2025-11-28 08:57:57','4444444444','绘图仪','工程设备','upload/shebeixinxi_TE0161.jpg,upload/shebeixinxi_TE0162.jpg,upload/shebeixinxi_TE0163.jpg','HPDesignJetT520','惠普','A1幅面，打印速度30秒/页（A1）',36,4,4,'使用专用绘图介质，定期维护喷头','支持网络打印，色彩还原准确，满足建筑教学绘图需求'),(5,'2025-11-28 08:57:57','5555555555','恒温培养箱','生物实验设备','upload/shebeixinxi_TE0151.jpg,upload/shebeixinxi_TE0152.jpg,upload/shebeixinxi_TE0153.jpg','DH-6000B','一恒','控温范围室温+5℃-65℃，容积160L',52,5,5,'定期清洁箱内，保持温度均匀，避免频繁开门','具有超温报警功能，确保实验样品安全'),(6,'2025-11-28 08:57:57','6666666666','虚拟现实头盔','虚拟现实设备','upload/shebeixinxi_TE0131.jpg,upload/shebeixinxi_TE0132.jpg,upload/shebeixinxi_TE0133.jpg','OculusQuest2','Meta','分辨率2160×1200，刷新率90Hz',32,6,6,'使用前调整头带松紧，保持镜片清洁','内置多款教育应用，支持多人互动，增强教学体验'),(7,'2025-11-28 08:57:57','7777777777','3D打印机','智能制造设备','upload/shebeixinxi_TE0071.jpg,upload/shebeixinxi_TE0072.jpg,upload/shebeixinxi_TE0073.jpg','Ender-3V2','创想三维','打印尺寸220×220×250mm',25,7,7,'Operation时佩戴防护眼镜，避免触摸高温喷头','支持多种耗材，打印精度可达0.1mm，适合创新教学'),(8,'2025-11-28 08:57:57','8888888888','光谱仪','分析仪器','upload/shebeixinxi_TE0101.jpg,upload/shebeixinxi_TE0102.jpg,upload/shebeixinxi_TE0103.jpg','722N','上分','波长范围330-800nm，光谱带宽4nm',23,8,8,'样品池需清洁无划痕，测量前预热仪器','数字显示测量结果，可连接电脑进行数据处理'),(9,'2025-11-28 09:02:41','1764320484962','投影仪','影像设备','upload/1764320507378_385.jpg','CB-X40','爱普生','3500流明，1080P',50,2,48,'使用时保持通风良好，避免长时间连续工作','<p>具备自动梯形校正和快速开机功能，灯泡寿命长达10000小时</p>');
/*!40000 ALTER TABLE `shebeixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syslog`
--

DROP TABLE IF EXISTS `syslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name',
  `operation` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'User Operation',
  `method` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Request method',
  `params` longtext COLLATE utf8mb4_unicode_ci COMMENT 'Request parameters',
  `time` bigint(20) DEFAULT NULL COMMENT 'Request duration (milliseconds)(毫秒)',
  `ip` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'IP address',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT=' System log';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syslog`
--

LOCK TABLES `syslog` WRITE;
/*!40000 ALTER TABLE `syslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `syslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT 'Name',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(255) NOT NULL COMMENT 'Password',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Add时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1764320391299,'11','renyuan','人员','27e0mjojtrx1l37bpohwca15wvjm3qwx','2025-11-28 08:59:55','2025-11-28 10:04:50'),(2,1764320410943,'22','renyuan','人员','4os3fx3yjzbtc1v4du1lout9brt3v3iy','2025-11-28 09:00:15','2025-11-28 10:00:15'),(3,1,'admin','users','admin','jiiduhvbkrsnrilk7faq1hu5p7oov26l','2025-11-28 09:00:20','2025-11-28 10:06:42');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Password',
  `role` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT 'admin' COMMENT '角色',
  `image` longtext COLLATE utf8mb4_unicode_ci COMMENT 'Profile picture',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='admin';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2025-11-28 08:57:57','admin','admin','admin','upload/image1.jpg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuqitixing`
--

DROP TABLE IF EXISTS `yuqitixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuqitixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shebeibianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Num',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Name',
  `shebeifenlei` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'E-Type',
  `shebeifengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT 'E-Cover',
  `jiechushuliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Loan-Num',
  `keyongshuliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'LoanNum',
  `zhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Account',
  `xingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Name',
  `leixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Type',
  `tixingshijian` date DEFAULT NULL COMMENT 'Tiptime',
  `yuqitixing` longtext COLLATE utf8mb4_unicode_ci COMMENT 'Overdue Reminder',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Overdue Reminder';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuqitixing`
--

LOCK TABLES `yuqitixing` WRITE;
/*!40000 ALTER TABLE `yuqitixing` DISABLE KEYS */;
INSERT INTO `yuqitixing` VALUES (1,'2025-11-28 08:57:57','E-Num1','激光打印机','办公设备','upload/yuqitixing_TE0061.jpg,upload/yuqitixing_TE0062.jpg,upload/yuqitixing_TE0063.jpg','Loan-Num1','LoanNum1','101','刘洋','Student','2025-11-28','此处文本编辑框是Content详细的Operation，您可以对框内现有的文字进行任意Modify，无论是Modify具体Content、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有Operation都进行保存。​',1,1),(2,'2025-11-28 08:57:57','E-Num2','语音室终端','语言教学设备','upload/yuqitixing_TE0171.jpg,upload/yuqitixing_TE0172.jpg,upload/yuqitixing_TE0173.jpg','Loan-Num2','LoanNum2','107','刘强','Teacher','2025-11-28','编辑框中的默认tip允许您进行文字ModifyOperation，像更正错别字、调整文字Content等都能轻松完成；插入图片的话，点击工具栏中的图片按钮，选择图片后即可在编辑框中展示，所有Modify实时可见且支持随时编辑。​\n',2,2),(3,'2025-11-28 08:57:57','E-Num3','电子白板软件','教学辅助软件','upload/yuqitixing_TE0191.jpg,upload/yuqitixing_TE0192.jpg,upload/yuqitixing_TE0193.jpg','Loan-Num3','LoanNum3','103','王磊','Teacher','2025-11-28','此编辑框内已详情的Content，您可以直接对现有文字进行Modify，无论是调整文字Content、更正表述还是增减文字数量都能实现；若需插入图片，只需点击上方工具栏的图片图标，选择本地文件或输入图片链接即可插入展示，所有Operation完成后提交后 System 会保存您的Modify。​',3,3),(4,'2025-11-28 08:57:57','E-Num4','绘图仪','工程设备','upload/yuqitixing_TE0161.jpg,upload/yuqitixing_TE0162.jpg,upload/yuqitixing_TE0163.jpg','Loan-Num4','LoanNum4','105','陈明','Teacher','2025-11-28','编辑框中展示的默认Content仅为示例，您可任意Modify其中的文字表述，比如更换词语、调整语句顺序等；当需要插入图片时，点击编辑框上方的 “插入图片” 按钮，上传图片后即可直接在编辑框中展示。',4,4),(5,'2025-11-28 08:57:57','E-Num5','恒温培养箱','生物实验设备','upload/yuqitixing_TE0151.jpg,upload/yuqitixing_TE0152.jpg,upload/yuqitixing_TE0153.jpg','Loan-Num5','LoanNum5','108','王明','Teacher','2025-11-28','此处文本编辑框是Content详细的Operationtip，您可对文字进行各类Modify，比如调整语句先后顺序、更换文字Content等；插入图片时，支持同时上传多张图片，上传完成后图片会直接在编辑框中展示，不需要的图片可以一键Delete。',5,5),(6,'2025-11-28 08:57:57','E-Num6','虚拟现实头盔','虚拟现实设备','upload/yuqitixing_TE0131.jpg,upload/yuqitixing_TE0132.jpg,upload/yuqitixing_TE0133.jpg','Loan-Num6','LoanNum6','104','李静','Student','2025-11-28','此处文本编辑框是Content详细的Operationtip，您能轻松对框内文字进行Modify，像更正错误文字、调整文字Content等都能实现；插入图片的话，点击工具栏上的图片按钮，选择要插入的图片，图片就会在编辑框中展示，支持随时再次编辑。',6,6),(7,'2025-11-28 08:57:57','E-Num7','3D打印机','智能制造设备','upload/yuqitixing_TE0071.jpg,upload/yuqitixing_TE0072.jpg,upload/yuqitixing_TE0073.jpg','Loan-Num7','LoanNum7','102','王静','Teacher','2025-11-28','您看到的编辑框内默认tip可作为创作起点，支持对现有Content进行全面Modify，包括Delete冗余文字、替换表述方式等；插入图片时，既可以从本地上传，也能粘贴网络图片地址，图片插入后会直接在文本中展示，完成后点击空白处即可保存设置。​',7,7),(8,'2025-11-28 08:57:57','E-Num8','光谱仪','分析仪器','upload/yuqitixing_TE0101.jpg,upload/yuqitixing_TE0102.jpg,upload/yuqitixing_TE0103.jpg','Loan-Num8','LoanNum8','106','孙俪','Student','2025-11-28','此编辑框内的默认Content为可编辑Status，您可对文字进行Modify，比如调整语句顺序、更换文字Content等；插入图片时，支持上传图片，上传后图片会直接在编辑框中展示，也能一键Delete不需要的图片。',8,8),(9,'2025-11-28 09:04:38','1764320484962','投影仪','影像设备','upload/1764320507378_385.jpg','5','5','11','张静','Student','2025-11-28','<p>在这里可以编辑Overdue ReminderContent</p>',1,9);
/*!40000 ALTER TABLE `yuqitixing` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-02 10:03:39
