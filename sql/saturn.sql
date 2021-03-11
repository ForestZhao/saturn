/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : saturn

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 11/03/2021 18:13:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '菜单名',
  `path` varchar(255) NOT NULL COMMENT '地址',
  `parent_id` bigint DEFAULT NULL COMMENT '父菜单',
  `priority` int DEFAULT '0' COMMENT '优先级',
  `level` tinyint DEFAULT NULL COMMENT '菜单层级',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `status` char(1) NOT NULL COMMENT '状态',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(64) NOT NULL COMMENT '修改者',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL COMMENT '是否删除 Y-是 N-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint NOT NULL COMMENT '主键',
  `code` varchar(64) NOT NULL COMMENT '角色代码',
  `name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` char(2) NOT NULL COMMENT '状态',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(64) NOT NULL COMMENT '修改者',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL COMMENT '是否删除 Y-是 N-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint NOT NULL COMMENT '主键',
  `role_id` bigint NOT NULL COMMENT 'saturn_role主键',
  `menu_id` bigint NOT NULL COMMENT 'saturn_menu主键',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(64) NOT NULL COMMENT '修改者',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL COMMENT '是否删除 Y-是 N-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

-- ----------------------------
-- Table structure for saturn_user
-- ----------------------------
DROP TABLE IF EXISTS `saturn_user`;
CREATE TABLE `saturn_user` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `status` char(2) NOT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(64) NOT NULL COMMENT '修改者',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL COMMENT '是否删除 Y-是 N-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_auths
-- ----------------------------
DROP TABLE IF EXISTS `user_auths`;
CREATE TABLE `user_auths` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT 'saturn_user主键',
  `login_name` varchar(64) DEFAULT NULL COMMENT '登录名',
  `login_type` varchar(64) DEFAULT NULL COMMENT '登录类型',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `status` char(2) NOT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `login_ip` varchar(64) DEFAULT NULL COMMENT '登录IP',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(64) NOT NULL COMMENT '修改者',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL COMMENT '是否删除 Y-是 N-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT 'saturn_user主键',
  `role_id` bigint NOT NULL COMMENT 'saturn_role主键',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(64) NOT NULL COMMENT '修改者',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL COMMENT '是否删除 Y-是 N-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

SET FOREIGN_KEY_CHECKS = 1;
