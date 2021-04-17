/*
 Navicat Premium Data Transfer

 Source Server         : MySQL Server
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : studentorm

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 17/04/2021 15:47:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_table
-- ----------------------------
DROP TABLE IF EXISTS `class_table`;
CREATE TABLE `class_table`  (
  `classNo` varchar(5) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `className` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  PRIMARY KEY (`classNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_table
-- ----------------------------
INSERT INTO `class_table` VALUES ('1001', '软件1班');
INSERT INTO `class_table` VALUES ('1002', '软件2班');
INSERT INTO `class_table` VALUES ('1003', '软件3班');
INSERT INTO `class_table` VALUES ('1004', '网络1班');

-- ----------------------------
-- Table structure for course_table
-- ----------------------------
DROP TABLE IF EXISTS `course_table`;
CREATE TABLE `course_table`  (
  `courseNo` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `courseName` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `courseTime` int(11) NOT NULL,
  `courseCredit` int(11) NOT NULL,
  PRIMARY KEY (`courseNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_table
-- ----------------------------
INSERT INTO `course_table` VALUES ('C1101', '中间件', 48, 3);
INSERT INTO `course_table` VALUES ('C1102', 'Oracle数据库', 22, 2);
INSERT INTO `course_table` VALUES ('C1103', '数据结构', 40, 3);
INSERT INTO `course_table` VALUES ('C1104', '设计模式', 40, 3);

-- ----------------------------
-- Table structure for score_table
-- ----------------------------
DROP TABLE IF EXISTS `score_table`;
CREATE TABLE `score_table`  (
  `studentID` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `courseNo` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `score` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`studentID`, `courseNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score_table
-- ----------------------------
INSERT INTO `score_table` VALUES ('201401001', 'C1101', 60);
INSERT INTO `score_table` VALUES ('201401001', 'C1104', 75);
INSERT INTO `score_table` VALUES ('201402003', 'C1101', 90);
INSERT INTO `score_table` VALUES ('201420005', 'C1101', 85);
INSERT INTO `score_table` VALUES ('201420005', 'C1103', 90);
INSERT INTO `score_table` VALUES ('201420005', 'C1104', 88);

-- ----------------------------
-- Table structure for student_table
-- ----------------------------
DROP TABLE IF EXISTS `student_table`;
CREATE TABLE `student_table`  (
  `studentID` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `studentName` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `gender` varchar(6) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `birthday` date NOT NULL,
  `classNo` varchar(5) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  PRIMARY KEY (`studentID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_table
-- ----------------------------
INSERT INTO `student_table` VALUES ('201401001', '令狐冲', '男', '1987-04-15', '1001');
INSERT INTO `student_table` VALUES ('201402003', '林平之', '女', '1989-05-20', '1001');
INSERT INTO `student_table` VALUES ('201405026', '任盈盈', '女', '1988-10-29', '1002');
INSERT INTO `student_table` VALUES ('201420005', '风清扬', '男', '1986-07-13', '1004');

SET FOREIGN_KEY_CHECKS = 1;
