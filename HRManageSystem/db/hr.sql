/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.0.22-community-nt : Database - hr
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hr` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hr`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `id` decimal(4,0) NOT NULL,
  `name` varchar(20) default NULL,
  `address` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`id`,`name`,`address`) values (1001,'财务部','大连1'),(1002,'后勤部','大连2'),(1003,'市场部','大连3');

/*Table structure for table `duty` */

DROP TABLE IF EXISTS `duty`;

CREATE TABLE `duty` (
  `id` decimal(4,0) NOT NULL,
  `name` varchar(20) default NULL,
  `minSalary` varchar(10) default NULL,
  `maxSalary` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `duty` */

insert  into `duty`(`id`,`name`,`minSalary`,`maxSalary`) values (1001,'销售','4000','6000'),(1002,'运维','3500','5500'),(1003,'经理','6000','8000');

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` decimal(4,0) NOT NULL,
  `name` varchar(20) default NULL,
  `sex` varchar(20) default NULL,
  `salary` varchar(20) default NULL,
  `tel` varchar(20) default NULL,
  `dept` varchar(20) default NULL,
  `duty` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`id`,`name`,`sex`,`salary`,`tel`,`dept`,`duty`) values (1001,'张三','男','5500','13412345678','市场部','销售'),(1002,'李四','男','3500','13412345679','后勤部','运维'),(1003,'马五','男','6000','15912345678','财务部','经理');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` decimal(4,0) NOT NULL,
  `username` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1001,'zhangsan','123456'),(1002,'wangwu','111111'),(1003,'lisi','100000'),(1004,'lisi','222222'),(1005,'zhangming','333333'),(1006,'qiqi','233333'),(1007,'bobo','555555'),(1008,'林俊杰','666666'),(1009,'yoyo','777777'),(1010,'coco','888888');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
