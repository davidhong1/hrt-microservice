# create database
create database if not exists hrt_device default character set = utf8mb4;

use hrt_device;

DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
                          `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                          `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                          `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          `deleted` tinyint(3) unsigned DEFAULT '0',
                          `product_id` bigint(20) unsigned DEFAULT NULL COMMENT '产品ID',
                          `device_id` varchar(32) NOT NULL COMMENT '设备ID',
                          `dev_name` varchar(128) DEFAULT NULL COMMENT '设备名字',
                          `chan_max` tinyint(3) unsigned DEFAULT '0' COMMENT '通道货品最大个数',
                          `chan_num` int(10) unsigned NOT NULL COMMENT '通道个数',
                          `dev_status` varchar(64) DEFAULT 'unknown' COMMENT '设备状态 online outline unknown',
                          `lock_dev` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0 设备不锁 1 设备锁定',
                          `descriptions` varchar(255) DEFAULT NULL COMMENT '描述',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备表';

DROP TABLE IF EXISTS `device_goods`;
CREATE TABLE `device_goods` (
                                `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                `deleted` tinyint(3) unsigned DEFAULT '0',
                                `product_id` bigint(20) unsigned DEFAULT NULL COMMENT '产品ID',
                                `device_id` varchar(32) DEFAULT NULL COMMENT '设备ID',
                                `good_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
                                `quantity` int(11) DEFAULT NULL COMMENT '库存数量',
                                `chan` int(10) unsigned NOT NULL COMMENT '所在通道',
                                `disabled` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '通道是否锁定',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备-商品表';

DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
                        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                        `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                        `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        `deleted` tinyint(3) unsigned DEFAULT '0',
                        `product_id` bigint(20) unsigned DEFAULT NULL COMMENT '产品ID',
                        `good_no` varchar(32) DEFAULT NULL COMMENT '商品编号',
                        `good_name` varchar(64) DEFAULT NULL COMMENT '商品名',
                        `good_price` int(10) unsigned DEFAULT NULL COMMENT '商品价格',
                        `feature` varchar(256) DEFAULT NULL COMMENT '商品特征',
                        `img_url` varchar(1024) DEFAULT NULL COMMENT '图片URL',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';
