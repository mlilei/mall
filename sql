
-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `nickname` varchar(10) NOT NULL DEFAULT '' COMMENT '昵称',
  `birthday` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '生日',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号码',
  `mail` varchar(40) NOT NULL DEFAULT '' COMMENT '邮箱',
  `introduction` varchar(255) NOT NULL DEFAULT '' COMMENT '介绍',
  `gender` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '性别(1:男,2:女)',
  `create_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`) USING BTREE,
  KEY `idx_phone` (`phone`),
  KEY `idx_mail` (`mail`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户表';


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '角色名称',
  `type` varchar(10) NOT NULL DEFAULT '' COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '角色表';

-- ----------------------------
--  Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `role_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户角色对应表';