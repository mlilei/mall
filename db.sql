/*
Navicat MySQL Data Transfer

Source Server         : yun
Source Server Version : 50717
Source Host           : 120.24.68.200:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-29 16:45:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url` varchar(256) NOT NULL DEFAULT '' COMMENT 'url地址',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT 'url描述',
  `create_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='许可表';

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(100) NOT NULL DEFAULT '' COMMENT '角色名称',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '角色id',
  `permission_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '许可id',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色对应表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `nickname` varchar(10) NOT NULL DEFAULT '' COMMENT '昵称',
  `birthday` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '生日',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号码',
  `mail` varchar(40) NOT NULL DEFAULT '' COMMENT '邮箱',
  `introduction` varchar(255) NOT NULL DEFAULT '' COMMENT '介绍',
  `gender` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '性别 1:男 2:女',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '状态 0：正常 1：未激活 2：禁用',
  `create_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`) USING BTREE,
  UNIQUE KEY `uk_mail` (`mail`) USING BTREE,
  KEY `idx_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lei.li', '123', '李磊', '1993-03-23 00:00:00', '17191097607', 'leilee.life@gmail.com', '哈哈哈哈!', '1', '0', '2017-04-29 00:00:00', '2017-04-29 15:39:29');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `role_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色对应表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;