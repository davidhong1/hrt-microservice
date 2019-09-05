# create database
create database if not exists hrt_user default character set = utf8mb4;

use hrt_user;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                           `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                           `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                           `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           `deleted` tinyint(3) unsigned DEFAULT '0',
                           `product_name` varchar(64) DEFAULT NULL COMMENT '产品名',
                           `product_no` varchar(64) DEFAULT NULL COMMENT '产品编号',
                           `describes` varchar(128) DEFAULT NULL COMMENT '描述',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品表';

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                        `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                        `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        `deleted` tinyint(3) unsigned DEFAULT '0',
                        `role_name` varchar(32) NOT NULL COMMENT '角色名',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

LOCK TABLES `role` WRITE;
INSERT INTO `role` VALUES (1,'2019-09-04 09:24:15','2019-09-04 09:24:18',0,'ROLE_ADMIN'),(2,'2019-09-04 17:24:43','2019-09-04 17:24:43',0,'ROLE_BRAND'),(3,'2019-09-04 17:24:59','2019-09-04 17:24:59',0,'ROLE_PROXY'),(4,'2019-09-04 17:25:08','2019-09-04 17:25:08',0,'ROLE_MAINTAIN'),(5,'2019-09-04 17:25:15','2019-09-04 17:25:15',0,'ROLE_REPAIR'),(6,'2019-09-04 17:25:23','2019-09-04 17:25:23',0,'ROLE_USER');
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                        `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                        `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        `deleted` tinyint(3) unsigned DEFAULT '0',
                        `username` varchar(64) NOT NULL COMMENT '用户名',
                        `pw` varchar(128) NOT NULL COMMENT '密码',
                        `contact` varchar(64) NOT NULL COMMENT '手机号',
                        `address` varchar(128) DEFAULT NULL COMMENT '用户地址',
                        `more` varchar(256) DEFAULT NULL COMMENT '备注',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `user_contact_uindex` (`contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

DROP TABLE IF EXISTS `user_device`;
CREATE TABLE `user_device` (
                               `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                               `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                               `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               `deleted` tinyint(3) unsigned DEFAULT '0',
                               `product_id` bigint(20) unsigned DEFAULT NULL COMMENT '产品ID',
                               `user_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
                               `device_id` varchar(32) NOT NULL COMMENT '设备ID',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户-设备表';

DROP TABLE IF EXISTS `user_product`;
CREATE TABLE `user_product` (
                                `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                `deleted` tinyint(3) unsigned DEFAULT '0',
                                `user_id` bigint(20) unsigned DEFAULT NULL COMMENT '用户ID',
                                `product_id` bigint(20) unsigned DEFAULT NULL COMMENT '产品ID',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户-产品对应表';

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                             `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                             `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             `deleted` tinyint(3) unsigned DEFAULT '0',
                             `user_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
                             `role_id` bigint(20) unsigned NOT NULL COMMENT '角色ID',
                             `role_name` varchar(32) NOT NULL COMMENT '角色名 冗余字段',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户-角色表';

