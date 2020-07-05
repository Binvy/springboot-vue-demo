--数据库配置：
--url: jdbc:mysql://localhost:3306/binvi?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC
--user: root
--password: binvi

/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50557
 Source Host           : localhost:3306
 Source Schema         : binvi

 Target Server Type    : MySQL
 Target Server Version : 50557
 File Encoding         : 65001

 Date: 15/06/2019 21:06:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for anime
-- ----------------------------
DROP TABLE IF EXISTS `anime`;
CREATE TABLE `anime`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(19, 2) NULL DEFAULT NULL,
  `publish_date` datetime NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `star` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of anime
-- ----------------------------
INSERT INTO `anime` VALUES (1, 'one', '虎鬼龙神', '一拳超人', 20.00, '2002-10-03 08:00:00', 'recommand to watch', '琦玉');
INSERT INTO `anime` VALUES (2, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:28', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (3, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:29', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (4, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:30', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (5, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:31', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (6, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:31', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (7, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:32', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (8, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:33', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (9, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:33', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (10, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:34', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (11, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:35', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (12, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:35', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (13, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:36', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (14, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:37', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (15, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:37', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (16, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:38', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (17, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:39', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (18, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:42', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (19, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-11 19:58:43', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (20, '岸本齐史', '忍者村', '火影忍者', 0.00, '2002-10-03 08:00:00', 'recommand to watch', '火影');
INSERT INTO `anime` VALUES (21, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-13 22:34:13', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (22, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-13 22:36:54', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (23, 'one', '平热系最强英雄传说', 'One Punch Man', 22.55, '2019-06-13 23:02:07', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (25, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-13 22:59:19', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (26, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-13 23:00:15', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (27, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-13 23:01:29', 'any one,just one punch', '琦玉');
INSERT INTO `anime` VALUES (28, 'one', '平热系最强英雄传说', 'One Punch Man', 0.00, '2019-06-13 23:02:07', 'any one,just one punch', '琦玉');

-- ----------------------------
-- Table structure for customer_order
-- ----------------------------
DROP TABLE IF EXISTS `customer_order`;
CREATE TABLE `customer_order`  (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of customer_order
-- ----------------------------
INSERT INTO `customer_order` VALUES (36, 'electronic product', 1);
INSERT INTO `customer_order` VALUES (37, 'life using product', 2);
INSERT INTO `customer_order` VALUES (38, 'papers', 0);
INSERT INTO `customer_order` VALUES (41, 'electronic product', 0);
INSERT INTO `customer_order` VALUES (42, 'life using product', 0);
INSERT INTO `customer_order` VALUES (45, 'electronic product', 0);
INSERT INTO `customer_order` VALUES (46, 'life using product', 0);
INSERT INTO `customer_order` VALUES (49, 'electronic product', 0);
INSERT INTO `customer_order` VALUES (50, 'life using product', 0);
INSERT INTO `customer_order` VALUES (53, 'electronic product', 0);
INSERT INTO `customer_order` VALUES (54, 'life using product', 0);
INSERT INTO `customer_order` VALUES (57, 'electronic product', 0);
INSERT INTO `customer_order` VALUES (58, 'life using product', 0);
INSERT INTO `customer_order` VALUES (60, '下单人：jessy，下单时间：2019-05-13，收货地址：tianjin', 0);
INSERT INTO `customer_order` VALUES (63, 'electronic product', 0);
INSERT INTO `customer_order` VALUES (64, 'life using product', 0);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (17, 'Bilbo Baggins', 'burglar', NULL, NULL);
INSERT INTO `employee` VALUES (18, 'Frodo Baggins', 'thief', NULL, NULL);
INSERT INTO `employee` VALUES (19, 'Bilbo Baggins', 'burglar', NULL, NULL);
INSERT INTO `employee` VALUES (23, 'Bilbo Baggins', 'burglar', NULL, NULL);
INSERT INTO `employee` VALUES (24, 'Frodo Baggins', 'thief', NULL, NULL);
INSERT INTO `employee` VALUES (25, 'Bilbo Baggins', 'burglar', NULL, NULL);
INSERT INTO `employee` VALUES (26, 'Frodo Baggins', 'thief', NULL, NULL);
INSERT INTO `employee` VALUES (27, 'binvi', 'coder', NULL, NULL);
INSERT INTO `employee` VALUES (28, 'binvi', 'coder', NULL, NULL);
INSERT INTO `employee` VALUES (29, 'Samwise Gamgee', 'ring bearer', NULL, NULL);
INSERT INTO `employee` VALUES (30, 'Bilbo Baggins', 'burglar', NULL, NULL);
INSERT INTO `employee` VALUES (31, 'Frodo Baggins', 'thief', NULL, NULL);
INSERT INTO `employee` VALUES (32, NULL, 'burglar', 'Bilbo', 'Baggins');
INSERT INTO `employee` VALUES (33, NULL, 'thief', 'Frodo', 'Baggins');
INSERT INTO `employee` VALUES (34, NULL, 'burglar', 'Bilbo', 'Baggins');
INSERT INTO `employee` VALUES (35, NULL, 'thief', 'Frodo', 'Baggins');
INSERT INTO `employee` VALUES (39, NULL, 'burglar', 'Bilbo', 'Baggins');
INSERT INTO `employee` VALUES (40, NULL, 'thief', 'Frodo', 'Baggins');
INSERT INTO `employee` VALUES (43, NULL, 'burglar', 'Bilbo', 'Baggins');
INSERT INTO `employee` VALUES (44, NULL, 'thief', 'Frodo', 'Baggins');
INSERT INTO `employee` VALUES (47, NULL, 'burglar', 'Bilbo', 'Baggins');
INSERT INTO `employee` VALUES (48, NULL, 'thief', 'Frodo', 'Baggins');
INSERT INTO `employee` VALUES (51, NULL, 'burglar', 'Bilbo', 'Baggins');
INSERT INTO `employee` VALUES (52, NULL, 'thief', 'Frodo', 'Baggins');
INSERT INTO `employee` VALUES (55, NULL, 'burglar', 'Bilbo', 'Baggins');
INSERT INTO `employee` VALUES (56, NULL, 'thief', 'Frodo', 'Baggins');
INSERT INTO `employee` VALUES (61, NULL, 'burglar', 'Bilbo', 'Baggins');
INSERT INTO `employee` VALUES (62, NULL, 'thief', 'Frodo', 'Baggins');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (67);

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '书名',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '作者',
  `publish_date` datetime NULL DEFAULT NULL COMMENT '出版日期',
  `price` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '单价',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '说明',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES (4, 'Iron Man I', 'Marvel', '2019-06-09 12:17:49', 50.00, 'I am iron man', 'first movie in marvel world');
INSERT INTO `movie` VALUES (5, 'Iron Man I', 'Marvel', '2019-06-09 12:17:51', 50.00, 'I am iron man', 'first movie in marvel world');
INSERT INTO `movie` VALUES (6, 'Iron Man I', 'Marvel', '2019-06-09 12:17:52', 50.00, 'I am iron man', 'first movie in marvel world');
INSERT INTO `movie` VALUES (7, 'Iron Man I', 'Marvel', '2019-06-09 12:17:53', 50.00, 'I am iron man', 'first movie in marvel world');
INSERT INTO `movie` VALUES (8, 'Iron Man I', 'Marvel', '2019-06-09 12:17:53', 50.00, 'I am iron man', 'first movie in marvel world');
INSERT INTO `movie` VALUES (9, 'Iron Man I', 'Marvel', '2019-06-09 12:17:54', 50.00, 'I am iron man', 'first movie in marvel world');
INSERT INTO `movie` VALUES (10, 'Iron Man I', 'Marvel', '2019-06-09 12:17:54', 50.00, 'I am iron man', 'first movie in marvel world');
INSERT INTO `movie` VALUES (11, 'Iron Man I', 'Marvel', '2019-06-11 10:03:41', 50.00, 'I am iron man', 'first movie in marvel world');
INSERT INTO `movie` VALUES (12, 'Iron Man I', 'Marvel', '2019-06-11 10:07:39', 50.00, 'I am iron man', 'first movie in marvel world');
INSERT INTO `movie` VALUES (13, 'Iron Man I', 'Marvel', '2019-06-11 10:10:28', 50.00, 'I am iron man', 'first movie in marvel world');
INSERT INTO `movie` VALUES (14, 'Iron Man I', 'Marvel', '2019-06-11 18:34:29', 50.00, 'I am iron man', 'first movie in marvel world');

-- ----------------------------
-- Table structure for password
-- ----------------------------
DROP TABLE IF EXISTS `password`;
CREATE TABLE `password`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id for table password',
  `web_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'web name',
  `web_alias` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'web alias',
  `web_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'web address',
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'login name for this web',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'login email for this web',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'login phone for this web',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'login password for this web',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'remark for this password',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of password
-- ----------------------------
INSERT INTO `password` VALUES (1, 'docker hub', 'docker', 'https://id.docker.com/', 'binvi', 'hbw4425625@163.com', NULL, 'ditto', NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色名称',
  `name_zh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色中文名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_dba', '数据库管理员');
INSERT INTO `role` VALUES ('2', 'ROLE_admin', '系统管理员');
INSERT INTO `role` VALUES ('3', 'ROLE_user', '普通用户');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(3) NOT NULL,
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` int(11) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_lqjrcobrh9jc8wpcar64q1bfh`(`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (14, 'ShanXi', 28, 'lol', 0, 'binvi');
INSERT INTO `user` VALUES (15, 'BeiJing', 27, 'purchase', 1, 'lxl');
INSERT INTO `user` VALUES (16, 'TianJin', 29, 'Dota', 0, 'brand');
INSERT INTO `user` VALUES (59, 'tian jin', 1000000, 'do program', 0, 'jessy');

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户编号',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户密码',
  `enable` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否可用: 0-不可用 1-可用',
  `locked` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否锁定: 0-未锁定 1-已锁定',
  `account_expired` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '账户是否过期: 0-未过期 1-已过期',
  `credentials_expired` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码是否过期: 0-未过期 1-已过期',
  `logon_time` datetime NULL DEFAULT NULL COMMENT '注册时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '上次登陆时间',
  `last_login_ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '上次登陆IP',
  `login_error_times` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码输入错误次数',
  `logon_way` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '注册方式: 1-手机 2-邮箱 3-身份证',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '邮箱号码',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES ('1', 'root', 'root', '1', '0', '0', '0', '2019-06-15 19:50:05', NULL, '2019-06-15 19:50:08', NULL, NULL, '1', '98765432100', '98765432100@qq.com', NULL);
INSERT INTO `user_login` VALUES ('2', 'admin', '$2a$10$blchBa/QrzI8RLYStHCwAucY0Oc/ZeNvUdlY/QW8SFp9xsvN3Oz76', '1', '0', '0', '0', '2019-06-15 19:49:04', NULL, '2019-06-15 19:49:07', NULL, NULL, '1', '12345678901', '12345678901@hotmail.com', NULL);
INSERT INTO `user_login` VALUES ('3', 'binvi', '$2a$10$jlzI.D3qy1e8ZMTpAmr1eeo9QQB73cCdPw7MScYVB3uhLvF5yzj4.', '1', '0', '0', '0', '2019-06-15 19:47:03', NULL, '2019-06-15 19:47:10', NULL, NULL, '1', '13752330376', '13752330376@163.com', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '编号',
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户编号',
  `role_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '1', '2');
INSERT INTO `user_role` VALUES ('3', '1', '3');
INSERT INTO `user_role` VALUES ('4', '2', '2');
INSERT INTO `user_role` VALUES ('5', '2', '3');
INSERT INTO `user_role` VALUES ('6', '3', '3');

SET FOREIGN_KEY_CHECKS = 1;
