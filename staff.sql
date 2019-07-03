/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17 : Database - staff
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`staff` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `staff`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(255) DEFAULT NULL,
  `apassword` varchar(255) DEFAULT NULL,
  `asex` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`aid`,`aname`,`apassword`,`asex`) values (1,'cenhan','123456',1);

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号[pk、成绩表fk]',
  `cname` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `tid` int(11) NOT NULL COMMENT '授课教师编号[fk、教师表pk]',
  `cbook` varchar(255) DEFAULT NULL COMMENT '培训教材',
  `scid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK_course_teacher` (`tid`),
  KEY `FK2f5ifu88rgih750sojly57p82` (`scid`),
  CONSTRAINT `FK2f5ifu88rgih750sojly57p82` FOREIGN KEY (`scid`) REFERENCES `score` (`scid`),
  CONSTRAINT `FK_course_teacher` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`cid`,`cname`,`tid`,`cbook`,`scid`) values (1,'公司文化',1001,'公司手册',NULL),(4,'财务管理相关制度',1003,'财务管理相关制度PPT',NULL),(6,'行政管理相关制度',1003,'行政管理相关制度PPT',NULL),(9,'办公规范管理',1011,'办公规范管理PPT',NULL),(10,'商务礼仪',1011,'商务礼仪PPT',NULL),(22,'薪酬福利制度',1003,'薪酬福利制度PPT',NULL),(29,'财务',1011,'财务制度',NULL),(30,'财务',1013,'财务制度',NULL),(31,'财务',1014,'财务制度',NULL),(32,'财务',1015,'财务制度',NULL),(33,'财务',1016,'财务制度',NULL);

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `depid` varchar(255) NOT NULL COMMENT '部门id（pk、员工表fk）',
  `depname` varchar(255) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`depid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`depid`,`depname`) values ('A','HR'),('B','产品'),('C','项目'),('D','财务'),('E','技术');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (1);

/*Table structure for table `plan` */

DROP TABLE IF EXISTS `plan`;

CREATE TABLE `plan` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '培训计划id[pk]',
  `cname` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `tname` varchar(255) DEFAULT NULL COMMENT '培训教师',
  `sname` varchar(255) DEFAULT NULL COMMENT '参加员工',
  `depname` varchar(255) DEFAULT NULL COMMENT '参加员工所属部门',
  `cstate` int(11) DEFAULT NULL COMMENT '课程培训状态[0|1]',
  `cbook` varchar(255) DEFAULT NULL COMMENT '培训教材',
  `scode` varchar(255) DEFAULT NULL COMMENT '参加员工工号',
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

/*Data for the table `plan` */

insert  into `plan`(`pid`,`cname`,`tname`,`sname`,`depname`,`cstate`,`cbook`,`scode`,`score`) values (1,'公司文化','纪晓岚','cenhan','技术',1,'公司手册','E65535',76),(2,'行业背景','和珅','cenhan','技术',1,'行业背景PPT','E65535',NULL),(3,'行政管理相关制度','tom','cenhan','技术',1,'行政管理相关制度PPT','E65535',76),(4,'薪酬福利制度','tom','cenhan','技术',1,'薪酬福利制度PPT','E65535',99),(5,'商务礼仪','jerry','cenhan','技术',1,'商务礼仪PPT','E65535',NULL),(6,'办公规范管理','jerry','cenhan','技术',NULL,'办公规范管理PPT','E65535',85),(7,'法定休假管理准则','和珅','cenhan','技术',NULL,'法定休假管理准则PPT','E65535',85),(8,'财务管理相关制度','tom','cenhan','技术',0,'财务管理相关制度PPT','E65535',NULL),(9,'公司文化','纪晓岚','cenhan','技术',1,'公司手册','E65535',120),(10,'公司文化','纪晓岚','cenhan','技术',1,'公司手册','E65535',60),(11,'法定休假管理准则','和珅','cenhan','技术',NULL,'法定休假管理准则PPT','E65535',85),(13,'公司文化','纪晓岚','cenhan','技术',0,'公司手册','E65535',NULL),(14,'商务礼仪','jerry','cenhan','技术',0,'商务礼仪PPT','E65535',NULL),(15,'公司文化','纪晓岚','张三','项目',1,'公司手册','C65537',95),(16,'商务礼仪','jerry','张三','项目',1,'商务礼仪PPT','C65537',NULL),(17,'公司文化','纪晓岚','cenhan','技术',1,'公司手册','E65535',77),(18,'财务管理相关制度','tom','张三','项目',1,'财务管理相关制度PPT','C65537',78),(19,'行政管理相关制度','tom','张三','项目',1,'行政管理相关制度PPT','C65537',65),(20,'薪酬福利制度','tom','张三','项目',1,'薪酬福利制度PPT','C65537',76),(21,'财务管理相关制度','tom','李四','产品',0,'财务管理相关制度PPT','B65538',NULL),(22,'行政管理相关制度','tom','李四','产品',1,'行政管理相关制度PPT','B65538',60),(23,'薪酬福利制度','tom','李四','产品',1,'薪酬福利制度PPT','B65538',78),(24,'行政管理相关制度','tom','王五','财务',1,'行政管理相关制度PPT','D65539',95),(25,'薪酬福利制度','tom','王五','财务',1,'薪酬福利制度PPT','D65539',95),(26,'薪酬福利制度','tom','赵六','HR',1,'薪酬福利制度PPT','A65540',60),(27,'财务管理相关制度','tom','谭七','产品',1,'财务管理相关制度PPT','B65541',60),(28,'行政管理相关制度','tom','谭七','产品',1,'行政管理相关制度PPT','B65541',95),(29,'商务礼仪','jerry','赵六','HR',0,'商务礼仪PPT','A65540',NULL),(30,'办公规范管理','jerry','赵六','HR',0,'办公规范管理PPT','A65540',NULL),(32,'财务管理相关制度','tom','赵六','HR',0,'财务管理相关制度PPT','A65540',NULL),(33,'薪酬福利制度','tom','赵六','HR',0,'薪酬福利制度PPT','A65540',NULL),(34,'财务管理相关制度','tom','李四','产品',0,'财务管理相关制度PPT','B65538',NULL),(35,'薪酬福利制度','tom','李四','产品',0,'薪酬福利制度PPT','B65538',NULL),(36,'行政管理相关制度','tom','王五','财务',0,'行政管理相关制度PPT','D65539',NULL),(37,'法定休假管理准则','和珅','cenhan','技术',1,'法定休假管理准则PPT','E65535',NULL),(38,'薪酬福利制度','tom','cenhan','技术',1,'薪酬福利制度PPT','E65535',66),(39,'财务','和珅','blue','技术',0,'财务制度','E65535',NULL),(40,'财务','和珅','谭七','产品',0,'财务制度','B65541',NULL),(41,'财务','和珅','谭七','产品',0,'财务制度','B65541',NULL),(42,'财务','和珅','爱国','HR',1,'财务制度','A65552',99),(43,'行业背景','和珅','李四','产品',0,'行业背景PPT','B65538',NULL),(44,'公司文化','纪晓岚','李四','产品',0,'公司手册','B65538',NULL),(45,'财务管理相关制度','tom','李四','产品',1,'财务管理相关制度PPT','B65538',99),(46,'办公规范管理','jerry','李四','产品',1,'办公规范管理PPT','B65538',60),(47,'财务','jerry','李四','产品',1,'财务制度','B65538',85),(48,'公司文化','纪晓岚','李四','产品',1,'公司手册','B65538',78),(49,'财务管理相关制度','tom','秦琴','财务',1,'财务管理相关制度PPT','D65555',NULL),(50,'财务','孟欣','秦琴','财务',1,'财务制度','D65555',95),(51,'财务','刘欣','李文丽','HR',1,'财务制度','A65556',99),(52,'财务','杨伊琳','王丹妮','HR',1,'财务制度','A65557',78),(53,'财务','黄横波','廖玉','HR',1,'财务制度','A65558',76);

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `sid` int(11) NOT NULL COMMENT '员工编号[fk、员工表pk]',
  `cid` int(11) DEFAULT NULL COMMENT '课程编号[fk、课程表pk]',
  `score` double DEFAULT NULL COMMENT '课程分数',
  `scid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cstate` int(11) DEFAULT NULL,
  PRIMARY KEY (`scid`),
  KEY `FK_score_staff` (`sid`),
  KEY `FK_score_course` (`cid`),
  CONSTRAINT `FK_score_course` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`),
  CONSTRAINT `FK_score_staff` FOREIGN KEY (`sid`) REFERENCES `staff` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `score` */

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工自增编号(pk、成绩表fk)',
  `scode` varchar(255) DEFAULT NULL COMMENT '工号(sid+depid)',
  `sname` varchar(255) DEFAULT NULL COMMENT '姓名',
  `spassword` varchar(255) DEFAULT NULL COMMENT '密码',
  `sex` int(2) DEFAULT NULL COMMENT '性别?0:‘男’|1:‘女’',
  `sage` int(11) DEFAULT NULL COMMENT '年龄',
  `stel` varchar(255) DEFAULT NULL COMMENT '电话',
  `depid` varchar(1) DEFAULT NULL COMMENT '部门类别编号(fk、部门表pk)',
  PRIMARY KEY (`sid`),
  KEY `FK_staff_dept` (`depid`),
  CONSTRAINT `FK_staff_dept` FOREIGN KEY (`depid`) REFERENCES `dept` (`depid`)
) ENGINE=InnoDB AUTO_INCREMENT=65559 DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`sid`,`scode`,`sname`,`spassword`,`sex`,`sage`,`stel`,`depid`) values (65537,'B65537','张三','123456',1,28,'16452522525','B'),(65538,'B65538','李四','123456',1,22,'155519199191','B'),(65539,'D65539','王五','123456',0,23,'16645455454','D'),(65540,'A65540','赵六','123456',1,32,'','A'),(65541,'B65541','谭七','123456',1,18,'13213133131','B'),(65544,'A65544','伍仈','123456',1,22,'','A'),(65546,'E65545','伍仈','123456',0,18,'','E'),(65547,'B65547','white','123456',1,28,'17889899898','B'),(65548,'D65548','black','123456',0,22,'17889899898','D'),(65549,'E65549','blue','123456',1,28,'','E'),(65550,'E65550','blue','123456',1,28,'','E'),(65551,'A65551','谭七','123456',1,NULL,'','A'),(65552,'A65552','爱国','123456',0,NULL,'','A'),(65553,'E65553','blue','123456',1,NULL,'','E'),(65554,'A65554','blue','123456',0,NULL,'','A'),(65555,'D65555','秦琴','123456',1,28,'','D'),(65556,'A65556','李文丽','123456',1,20,'','A'),(65557,'A65557','王丹妮','123456',1,NULL,'','A'),(65558,'A65558','廖玉','123456',1,23,'1234567890','A');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师自增编号(pk)',
  `tname` varchar(255) DEFAULT NULL COMMENT '姓名',
  `tpassword` varchar(255) DEFAULT NULL COMMENT '密码',
  `tsex` int(2) DEFAULT NULL COMMENT '性别?0:''男''|1:''女''',
  `tage` int(11) DEFAULT NULL COMMENT '年龄',
  `tel` varchar(255) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=1017 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`tid`,`tname`,`tpassword`,`tsex`,`tage`,`tel`) values (1001,'纪晓岚','123456',0,45,'15546466464'),(1003,'tom','123456',0,22,'17889899898'),(1005,'jack','123456',0,45,'18594944646'),(1011,'jerry','123456',NULL,39,''),(1012,'阿奎那立法','123456',1,NULL,''),(1013,'孟欣','123456',1,30,''),(1014,'刘欣','123456',1,40,''),(1015,'杨伊琳','123456',0,30,''),(1016,'黄横波','123456',0,30,'17889899898');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
