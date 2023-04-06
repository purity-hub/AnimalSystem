/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : animalmanage

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 07/05/2022 23:56:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `departmentId` int NOT NULL,
  `Header` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `introduction` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order` int NULL DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deptname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`departmentId`) USING BTREE,
  UNIQUE INDEX `department_deptname_uindex`(`deptname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '颜炳园', '颜炳园', 1, '17354922160', '工会');
INSERT INTO `department` VALUES (2, '段贝麒', '段贝麒', 2, '13128249876', '办公室');
INSERT INTO `department` VALUES (3, '韩贞雪', '韩贞雪', 3, '13449555740', '财务室');
INSERT INTO `department` VALUES (4, '王丹蔷', '王丹蔷', 4, '13111023571', '饲养科');
INSERT INTO `department` VALUES (5, '薄萍冉', '薄萍冉', 5, '18785708047', '保卫科');
INSERT INTO `department` VALUES (6, '戚泽蔚', '戚泽蔚', 6, '15282376592', '后勤科');
INSERT INTO `department` VALUES (7, '乔倩桐', '乔倩桐', 7, '17272604861', '票务科');
INSERT INTO `department` VALUES (8, '瞿贞泓', '瞿贞泓', 8, '18011401724', '科技科');
INSERT INTO `department` VALUES (9, '宣倩嫣', '宣倩嫣', 9, '17790365526', '花卉科');
INSERT INTO `department` VALUES (10, '顾垣煊', '顾垣煊', 10, '13256239108', '绿化科');
INSERT INTO `department` VALUES (11, '滕素咪', '滕素咪', 11, '13105009914', '野生动物救护中心');

-- ----------------------------
-- Table structure for department_menu
-- ----------------------------
DROP TABLE IF EXISTS `department_menu`;
CREATE TABLE `department_menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `departmentid` int NULL DEFAULT NULL,
  `menuid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department_menu
-- ----------------------------
INSERT INTO `department_menu` VALUES (61, 1, 9);
INSERT INTO `department_menu` VALUES (62, 1, 10);
INSERT INTO `department_menu` VALUES (63, 1, 11);
INSERT INTO `department_menu` VALUES (64, 1, 12);
INSERT INTO `department_menu` VALUES (65, 1, 13);
INSERT INTO `department_menu` VALUES (66, 1, 14);
INSERT INTO `department_menu` VALUES (67, 1, 15);
INSERT INTO `department_menu` VALUES (68, 1, 16);
INSERT INTO `department_menu` VALUES (69, 1, 17);
INSERT INTO `department_menu` VALUES (70, 1, 18);
INSERT INTO `department_menu` VALUES (71, 1, 4);
INSERT INTO `department_menu` VALUES (72, 1, 5);
INSERT INTO `department_menu` VALUES (73, 1, 6);
INSERT INTO `department_menu` VALUES (74, 1, 7);
INSERT INTO `department_menu` VALUES (75, 1, 8);
INSERT INTO `department_menu` VALUES (76, 2, 9);
INSERT INTO `department_menu` VALUES (77, 2, 10);
INSERT INTO `department_menu` VALUES (78, 2, 11);
INSERT INTO `department_menu` VALUES (79, 2, 12);
INSERT INTO `department_menu` VALUES (80, 2, 13);
INSERT INTO `department_menu` VALUES (81, 2, 14);
INSERT INTO `department_menu` VALUES (82, 2, 15);
INSERT INTO `department_menu` VALUES (83, 2, 16);
INSERT INTO `department_menu` VALUES (84, 2, 17);
INSERT INTO `department_menu` VALUES (85, 2, 18);
INSERT INTO `department_menu` VALUES (86, 2, 4);
INSERT INTO `department_menu` VALUES (87, 2, 5);
INSERT INTO `department_menu` VALUES (88, 2, 6);
INSERT INTO `department_menu` VALUES (89, 2, 7);
INSERT INTO `department_menu` VALUES (90, 2, 8);
INSERT INTO `department_menu` VALUES (91, 3, 14);
INSERT INTO `department_menu` VALUES (92, 3, 15);
INSERT INTO `department_menu` VALUES (93, 3, 16);
INSERT INTO `department_menu` VALUES (94, 3, 17);
INSERT INTO `department_menu` VALUES (95, 3, 18);
INSERT INTO `department_menu` VALUES (96, 3, 4);
INSERT INTO `department_menu` VALUES (97, 3, 5);
INSERT INTO `department_menu` VALUES (98, 3, 6);
INSERT INTO `department_menu` VALUES (99, 3, 7);
INSERT INTO `department_menu` VALUES (100, 3, 8);
INSERT INTO `department_menu` VALUES (101, 4, 4);
INSERT INTO `department_menu` VALUES (102, 4, 5);
INSERT INTO `department_menu` VALUES (103, 4, 6);
INSERT INTO `department_menu` VALUES (104, 4, 7);
INSERT INTO `department_menu` VALUES (105, 5, 4);
INSERT INTO `department_menu` VALUES (106, 5, 6);
INSERT INTO `department_menu` VALUES (107, 5, 8);
INSERT INTO `department_menu` VALUES (108, 6, 14);
INSERT INTO `department_menu` VALUES (109, 6, 15);
INSERT INTO `department_menu` VALUES (110, 6, 16);
INSERT INTO `department_menu` VALUES (111, 6, 17);
INSERT INTO `department_menu` VALUES (112, 6, 18);
INSERT INTO `department_menu` VALUES (113, 7, 6);
INSERT INTO `department_menu` VALUES (114, 7, 8);
INSERT INTO `department_menu` VALUES (115, 8, 14);
INSERT INTO `department_menu` VALUES (116, 8, 15);
INSERT INTO `department_menu` VALUES (117, 8, 16);
INSERT INTO `department_menu` VALUES (118, 8, 17);
INSERT INTO `department_menu` VALUES (119, 8, 18);
INSERT INTO `department_menu` VALUES (120, 8, 5);
INSERT INTO `department_menu` VALUES (121, 9, 4);
INSERT INTO `department_menu` VALUES (122, 9, 6);
INSERT INTO `department_menu` VALUES (123, 10, 14);
INSERT INTO `department_menu` VALUES (124, 10, 15);
INSERT INTO `department_menu` VALUES (125, 10, 16);
INSERT INTO `department_menu` VALUES (126, 10, 5);
INSERT INTO `department_menu` VALUES (127, 10, 6);
INSERT INTO `department_menu` VALUES (128, 11, 9);
INSERT INTO `department_menu` VALUES (129, 11, 10);
INSERT INTO `department_menu` VALUES (130, 11, 11);
INSERT INTO `department_menu` VALUES (131, 11, 12);
INSERT INTO `department_menu` VALUES (132, 11, 13);
INSERT INTO `department_menu` VALUES (133, 11, 14);
INSERT INTO `department_menu` VALUES (134, 11, 15);
INSERT INTO `department_menu` VALUES (135, 11, 16);
INSERT INTO `department_menu` VALUES (136, 11, 17);
INSERT INTO `department_menu` VALUES (137, 11, 18);
INSERT INTO `department_menu` VALUES (138, 11, 4);
INSERT INTO `department_menu` VALUES (139, 11, 5);
INSERT INTO `department_menu` VALUES (140, 11, 6);
INSERT INTO `department_menu` VALUES (141, 11, 7);
INSERT INTO `department_menu` VALUES (142, 11, 8);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menuid` int NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ismenu` bit(1) NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pid` int NULL DEFAULT NULL,
  `parentid` int NULL DEFAULT NULL,
  `order` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '系统基础信息管理', NULL, b'1', '系统基础信息管理', 0, 0, 1);
INSERT INTO `menu` VALUES (2, '救助信息管理', NULL, b'1', '救助信息管理', 0, 0, 2);
INSERT INTO `menu` VALUES (3, '收容救治管理', NULL, b'1', '收容救治管理', 0, 0, 3);
INSERT INTO `menu` VALUES (4, '档案管理', NULL, b'1', '档案管理', 0, 0, 4);
INSERT INTO `menu` VALUES (5, '放生管理', NULL, b'1', '放生管理', 0, 0, 5);
INSERT INTO `menu` VALUES (6, '展示管理', NULL, b'1', '展示管理', 0, 0, 6);
INSERT INTO `menu` VALUES (7, '救治对象管理', NULL, b'1', '救治对象管理', 0, 0, 7);
INSERT INTO `menu` VALUES (8, '查询统计与智能台账', NULL, b'1', '查询统计与智能台账', 0, 0, 8);
INSERT INTO `menu` VALUES (9, '基础字典管理', NULL, b'1', '基础字典管理', 1, 1, 1);
INSERT INTO `menu` VALUES (10, '部门信息管理', '/dict/department', b'1', '部门信息管理', 1, 1, 2);
INSERT INTO `menu` VALUES (11, '人员信息管理', '/dict/peopleinfo', b'1', '人员信息管理', 1, 1, 3);
INSERT INTO `menu` VALUES (12, '授权平台', '/dict/authorization', b'1', '授权平台', 1, 1, 4);
INSERT INTO `menu` VALUES (13, '日志管理', '/dict/syslog', b'1', '日志管理', 1, 1, 5);
INSERT INTO `menu` VALUES (14, '救助请求管理', NULL, b'1', '救助请求管理', 1, 2, 1);
INSERT INTO `menu` VALUES (15, '救助信息单管理', NULL, b'1', '救助信息单管理', 1, 2, 2);
INSERT INTO `menu` VALUES (16, '救助指派管理', NULL, b'1', '救助指派管理', 1, 2, 3);
INSERT INTO `menu` VALUES (17, '待救治任务管理', NULL, b'1', '待救治任务管理', 1, 3, 1);
INSERT INTO `menu` VALUES (18, '待处理任务管理', NULL, b'1', '待处理任务管理', 1, 3, 2);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `rolemenuid` int NULL DEFAULT NULL,
  `roleid` int NULL DEFAULT NULL,
  `menuid` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `roleid` int NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `info` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` bit(1) NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, '超级管理员', '超级管理员', b'1', '超级管理员');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` int NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `message` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_sex
-- ----------------------------
DROP TABLE IF EXISTS sys_dict_value;
CREATE TABLE `sys_dict_sex`  (
  `sexid` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sexlabel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典编码',
  `sexvalue` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '编码',
  `sexorder` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `sexstatus` int NULL DEFAULT NULL,
  `sexremark` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`sexid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_sex
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logs
-- ----------------------------
DROP TABLE IF EXISTS `sys_logs`;
CREATE TABLE `sys_logs`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `createdDate` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_logs
-- ----------------------------
INSERT INTO `sys_logs` VALUES (1, 'purity', '修改人员信息', 'edit', '[\"超级管理员\",\"purity\",\"123456\",\"男\",\"360731255444122145\",\"2022-05-10\",\"工会\",\"主管\",\"教授\",0,\"计算机\",\"工会\",\"2022-05-02\",\"总经理\",\"11111111111\",\"11254212563\",\"158057524@qq.com\",\"是\",\"博士\"]', '10.23.28.143', '2022-05-07 23:36:58');
INSERT INTO `sys_logs` VALUES (2, 'purity', '修改人员信息', 'edit', '[\"超级管理员\",\"purity\",\"123456\",\"男\",\"360731255444122145\",\"2022-05-10\",\"党员\",\"主管\",\"教授\",0,\"计算机\",\"工会\",\"2022-05-02\",\"总经理\",\"11111111111\",\"11254212563\",\"158057524@qq.com\",\"是\",\"博士\"]', '10.23.28.143', '2022-05-07 23:47:37');
INSERT INTO `sys_logs` VALUES (3, 'purity', '修改人员信息', 'edit', '[\"超级管理员\",\"purity\",\"123456\",\"男\",\"360731255444122145\",\"2022-05-10\",\"党员\",\"主管\",\"教授\",0,\"计算机\",\"工会\",\"2022-05-02\",\"总经理\",\"11111111111\",\"11254212563\",\"158057524@qq.com\",\"是\",\"博士\"]', '10.23.28.143', '2022-05-07 23:50:13');
INSERT INTO `sys_logs` VALUES (4, 'purity', '修改人员信息', 'edit', '[\"程嫱翠\",\"程嫱翠\",\"4LhulG\",\"女\",\"360102199003073717\",\"2022-05-10\",\"工会\",\"\",\"\",12,\"\",\"工会\",\"2022-05-03\",\"\",\"\",\"\",\"\",\"是\",\"\"]', '10.23.28.143', '2022-05-07 23:50:57');
INSERT INTO `sys_logs` VALUES (5, 'purity', '批量删除人员信息', 'delAll', '[\"[\\\"翁轶绚\\\"]\"]', '10.23.28.143', '2022-05-07 23:55:06');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  `politicalface` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Idnumber` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `jobtitle` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `worknumber` int NULL DEFAULT NULL,
  `office` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `departname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `worktime` date NULL DEFAULT NULL,
  `profession` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `officephone` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `residentialphone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `post` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `attribute` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `degee` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `users_username_uindex`(`username`) USING BTREE,
  INDEX `users_department_deptname_fk`(`departname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '超级管理员', '123456', '男', 'purity', '2022-05-10', '党员', '360731255444122145', '教授', 0, '主管', '工会', '2022-05-02', '计算机', '11111111111', '11254212563', '总经理', '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (3, '卓茹格', 'A2fJ!u', '男', '卓茹格', '2022-05-10', '党员', '360102199003076010', '教授', 2, '主管', '办公室', '2022-05-02', '计算机', '19972536719', '18780159037', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (4, '管余闻', '###DLH', '男', '管余闻', '2022-05-10', '党员', '36010219900307199X', '教授', 3, '主管', '财务室', '2022-05-02', '计算机', '15954948443', '15656925105', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (5, '经垣为', '2vRprJ', '男', '经垣为', '2022-05-10', '党员', '360102199003073477', '教授', 4, '主管', '饲养科', '2022-05-02', '计算机', '13243349127', '15211807368', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (6, '方霞元', 'b1O4mh', '男', '方霞元', '2022-05-10', '党员', '36010219900307957X', '教授', 5, '主管', '保卫科', '2022-05-02', '计算机', '16630545802', '19835433886', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (7, '武然镇', 'mx(@&X', '男', '武然镇', '2022-05-10', '党员', '360102199003070217', '教授', 6, '主管', '后勤科', '2022-05-02', '计算机', '16632563251', '17102225014', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (8, '单骅俊', 'f&YED&', '男', '单骅俊', '2022-05-10', '党员', '360102199003071412', '教授', 7, '主管', '票务科', '2022-05-02', '计算机', '18671783505', '15593088749', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (9, '郎斐彬', 'm!Xdb+', '男', '郎斐彬', '2022-05-10', '党员', '360102199003072757', '教授', 8, '主管', '科技科', '2022-05-02', '计算机', '17364283202', '13446754068', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (10, '嵇芝可', '!Z(oM0', '女', '嵇芝可', '2022-05-10', '党员', '360102199003079270', '教授', 9, '主管', '花卉科', '2022-05-02', '计算机', '15772818132', '18221052243', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (11, '严武杉', 'ZzU@7+', '女', '严武杉', '2022-05-10', '党员', '360102199003074058', '教授', 10, '主管', '绿化科', '2022-05-02', '计算机', '13369816752', '13671143841', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (12, '范苹莉', '3Y^p@P', '女', '范苹莉', '2022-05-10', '党员', '360102199003074875', '教授', 11, '主管', '野生动物救护中心', '2022-05-02', '计算机', '13241814072', '14505914077', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (13, '程嫱翠', '4LhulG', '女', '程嫱翠', '2022-05-10', '党员', '360102199003073717', '教授', 12, '主管', '工会', '2022-05-02', '计算机', '17612489553', '15514329407', '', '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (14, '贺毓洋', '9K%EEh', '女', '贺毓洋', '2022-05-10', '党员', '110101199003070476', '教授', 13, '主管', '办公室', '2022-05-02', '计算机', '18936905386', '15340914051', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (15, '盛泰勉', '_nBPGk', '女', '盛泰勉', '2022-05-10', '党员', '11010119900307571X', '教授', 14, '主管', '财务室', '2022-05-02', '计算机', '17364254937', '18683269981', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (16, '郭鹰欣', 'namxgO', '女', '郭鹰欣', '2022-05-10', '党员', '110101199003070070', '教授', 15, '主管', '饲养科', '2022-05-02', '计算机', '17728305451', '15946049231', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (17, '咎若野', 'na!1IX', '女', '咎若野', '2022-05-10', '党员', '110101199003073036', '教授', 16, '主管', '保卫科', '2022-05-02', '计算机', '16533495738', '13113561124', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (18, '汤桢麒', 'XC&f_9', '女', '汤桢麒', '2022-05-10', '党员', '11010119900307547X', '教授', 17, '主管', '后勤科', '2022-05-02', '计算机', '13000201177', '13046039898', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (19, '郑珩闻', '5h9LXV', '女', '郑珩闻', '2022-05-10', '党员', '110101199003074493', '教授', 18, '主管', '票务科', '2022-05-02', '计算机', '15007314596', '15346935177', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (20, '俞行同', 'kD@Xns', '女', '俞行同', '2022-05-10', '党员', '110101199003070310', '教授', 19, '主管', '科技科', '2022-05-02', '计算机', '18400835532', '17178498903', NULL, '是', '博士', '158057524@qq.com');
INSERT INTO `users` VALUES (21, '周广赛', '7@mU5J', '女', '周广赛', '2022-05-10', '党员', '110101199003075277', '教授', 20, '主管', '花卉科', '2022-05-02', '计算机', '18050271467', '15978513238', NULL, '是', '博士', '158057524@qq.com');

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles`  (
  `usersrolesid` int NOT NULL AUTO_INCREMENT,
  `userid` int NULL DEFAULT NULL,
  `roleid` int NULL DEFAULT NULL,
  PRIMARY KEY (`usersrolesid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_roles
-- ----------------------------
INSERT INTO `users_roles` VALUES (1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
