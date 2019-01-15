/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : cpmpany

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-01-10 18:31:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `emp_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('5', '人事部', '15');
INSERT INTO `department` VALUES ('9', '开发部', '4');
INSERT INTO `department` VALUES ('10', '测试部', '3');
INSERT INTO `department` VALUES ('11', '市场部', null);
INSERT INTO `department` VALUES ('17', 'abc', '1');
INSERT INTO `department` VALUES ('18', 'dsaf', '1');
INSERT INTO `department` VALUES ('19', 'A部门', null);
INSERT INTO `department` VALUES ('21', 'A部门', '2');
INSERT INTO `department` VALUES ('22', 'A部门', '2');
INSERT INTO `department` VALUES ('23', 'A部门', null);
INSERT INTO `department` VALUES ('24', 'A部门', '2');
INSERT INTO `department` VALUES ('26', 'c部门', null);
INSERT INTO `department` VALUES ('27', 'c部门', null);

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `aa` (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('2', '小红', '男', '22', '5', null);
INSERT INTO `employee` VALUES ('8', '李静', '女', '26', '9', null);
INSERT INTO `employee` VALUES ('9', '王五', '女', '40', '5', null);
INSERT INTO `employee` VALUES ('14', ' 刘邦', '男', '26', '5', null);
INSERT INTO `employee` VALUES ('19', '李白', '男', '20', '4', null);
INSERT INTO `employee` VALUES ('22', '关羽', '男', '26', null, null);
INSERT INTO `employee` VALUES ('35', '李静', '女', '22', null, null);
INSERT INTO `employee` VALUES ('36', '小明', '男', '21', null, null);
INSERT INTO `employee` VALUES ('37', '张三', '男', '12', null, null);
INSERT INTO `employee` VALUES ('38', 'abc', '男', '21', null, null);
INSERT INTO `employee` VALUES ('39', '234', '男', '21', null, null);
INSERT INTO `employee` VALUES ('40', 'a', '男', '1', null, null);
INSERT INTO `employee` VALUES ('41', 'abc', '男', '21', null, null);
INSERT INTO `employee` VALUES ('42', '小明', '男', '21', null, null);
INSERT INTO `employee` VALUES ('43', '小明', '男', '21', '5', null);
INSERT INTO `employee` VALUES ('44', '张三', '女', '12', '9', null);
INSERT INTO `employee` VALUES ('45', '张三', '男', '21', '5', null);
INSERT INTO `employee` VALUES ('46', '小明', '男', '21', '5', null);
INSERT INTO `employee` VALUES ('47', '小明', '男', '23', null, null);
INSERT INTO `employee` VALUES ('48', '张三', '男', '12', null, null);
INSERT INTO `employee` VALUES ('49', '小明', '男', '21', '5', '8b0b8486-04c7-404f-8d24-eb6599845450.jpg');
INSERT INTO `employee` VALUES ('50', '张三', '男', '12', '9', '1.jpg');
INSERT INTO `employee` VALUES ('51', '张三', '男', '21', '5', 'a.jpg');
INSERT INTO `employee` VALUES ('52', 'abc', '男', '21', '5', 'b.jpg');
INSERT INTO `employee` VALUES ('53', 'abc', '男', '21', '10', '1c7015ff-3d6b-400b-94a5-5f813d315f53.jpg');
INSERT INTO `employee` VALUES ('54', 'abc', '男', '21', '5', 'e297ad6a-0541-4a4c-a425-d88bdae6cf0f.jpg');
INSERT INTO `employee` VALUES ('55', '张三', '女', '1', '10', '');
INSERT INTO `employee` VALUES ('58', '张三', '男', '24', '5', '20210c8f-e57d-40e1-ab2f-fb0770920777.jpg');
INSERT INTO `employee` VALUES ('60', '小', '男', '1', null, null);
INSERT INTO `employee` VALUES ('62', 'f', 'f', '4', null, null);
INSERT INTO `employee` VALUES ('63', '小张', '男', '20', null, null);
INSERT INTO `employee` VALUES ('64', '小张', '男', '20', null, null);
INSERT INTO `employee` VALUES ('65', '小张', '男', '20', '2', null);
INSERT INTO `employee` VALUES ('66', 'abc', '男', '21', null, '');
INSERT INTO `employee` VALUES ('67', '小明', '男', '21', null, '');
INSERT INTO `employee` VALUES ('68', 'abc', '男', '21', '17', '');
INSERT INTO `employee` VALUES ('69', 'abc', '男', '21', '5', '');
INSERT INTO `employee` VALUES ('70', 'abc', '男', '12', '9', '');
INSERT INTO `employee` VALUES ('73', '小明', null, '0', null, null);
INSERT INTO `employee` VALUES ('74', '小明', null, '0', null, null);
INSERT INTO `employee` VALUES ('75', '小明', '男', '20', null, null);
INSERT INTO `employee` VALUES ('76', '小明', '男', '20', null, null);
INSERT INTO `employee` VALUES ('77', '小明', '男', '20', null, null);
INSERT INTO `employee` VALUES ('78', '小明', '男', '20', null, null);
INSERT INTO `employee` VALUES ('80', '小明', '男', '20', '5', null);
INSERT INTO `employee` VALUES ('81', '小明', '男', '20', '5', null);
INSERT INTO `employee` VALUES ('82', '小明', '男', '20', '6', null);
INSERT INTO `employee` VALUES ('83', '小明', '男', '20', '5', null);
INSERT INTO `employee` VALUES ('85', '小明', '男', '20', '18', null);
INSERT INTO `employee` VALUES ('86', '小明a', '男', '20', '21', null);
INSERT INTO `employee` VALUES ('87', '小明b', '男', '20', '21', null);
INSERT INTO `employee` VALUES ('88', '小明a', '男', '20', '22', null);
INSERT INTO `employee` VALUES ('89', '小明b', '男', '20', '22', null);
INSERT INTO `employee` VALUES ('90', '小明a', '男', '20', null, null);
INSERT INTO `employee` VALUES ('91', '小明b', '男', '20', null, null);
INSERT INTO `employee` VALUES ('92', '小明a', '男', '20', '24', null);
INSERT INTO `employee` VALUES ('93', '小明b', '男', '20', '24', null);
INSERT INTO `employee` VALUES ('94', 're', '男', '23', '10', null);

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '海尔OA系统');
INSERT INTO `project` VALUES ('2', '中石油人资系统');
INSERT INTO `project` VALUES ('3', '医院HIS系统');
INSERT INTO `project` VALUES ('4', '教务管理系统');
INSERT INTO `project` VALUES ('5', '网上书城系统');
INSERT INTO `project` VALUES ('6', '中石化ERP投标项目');
INSERT INTO `project` VALUES ('7', '集成化测试项目');
INSERT INTO `project` VALUES ('9', 'null');
INSERT INTO `project` VALUES ('10', 'null');
INSERT INTO `project` VALUES ('11', '333');
INSERT INTO `project` VALUES ('12', 'a项目');
INSERT INTO `project` VALUES ('13', 'b项目');
INSERT INTO `project` VALUES ('14', 'a项目');
INSERT INTO `project` VALUES ('15', 'b项目');

-- ----------------------------
-- Table structure for `r_dep_pro`
-- ----------------------------
DROP TABLE IF EXISTS `r_dep_pro`;
CREATE TABLE `r_dep_pro` (
  `d_id` int(11) NOT NULL DEFAULT '0',
  `p_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`d_id`,`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_dep_pro
-- ----------------------------
INSERT INTO `r_dep_pro` VALUES ('1', '1');
INSERT INTO `r_dep_pro` VALUES ('1', '2');
INSERT INTO `r_dep_pro` VALUES ('1', '3');
INSERT INTO `r_dep_pro` VALUES ('1', '4');
INSERT INTO `r_dep_pro` VALUES ('1', '5');
INSERT INTO `r_dep_pro` VALUES ('2', '1');
INSERT INTO `r_dep_pro` VALUES ('2', '2');
INSERT INTO `r_dep_pro` VALUES ('2', '3');
INSERT INTO `r_dep_pro` VALUES ('2', '4');
INSERT INTO `r_dep_pro` VALUES ('2', '5');
INSERT INTO `r_dep_pro` VALUES ('2', '7');
INSERT INTO `r_dep_pro` VALUES ('3', '1');
INSERT INTO `r_dep_pro` VALUES ('3', '2');
INSERT INTO `r_dep_pro` VALUES ('3', '3');
INSERT INTO `r_dep_pro` VALUES ('3', '4');
INSERT INTO `r_dep_pro` VALUES ('3', '5');
INSERT INTO `r_dep_pro` VALUES ('4', '6');
INSERT INTO `r_dep_pro` VALUES ('5', '1');
INSERT INTO `r_dep_pro` VALUES ('5', '2');
INSERT INTO `r_dep_pro` VALUES ('5', '3');
INSERT INTO `r_dep_pro` VALUES ('5', '4');
INSERT INTO `r_dep_pro` VALUES ('5', '5');
INSERT INTO `r_dep_pro` VALUES ('5', '6');
INSERT INTO `r_dep_pro` VALUES ('5', '7');
INSERT INTO `r_dep_pro` VALUES ('5', '9');
INSERT INTO `r_dep_pro` VALUES ('5', '10');
INSERT INTO `r_dep_pro` VALUES ('9', '1');
INSERT INTO `r_dep_pro` VALUES ('9', '4');
INSERT INTO `r_dep_pro` VALUES ('9', '5');
INSERT INTO `r_dep_pro` VALUES ('9', '6');
INSERT INTO `r_dep_pro` VALUES ('9', '9');
INSERT INTO `r_dep_pro` VALUES ('10', '1');
INSERT INTO `r_dep_pro` VALUES ('10', '2');
INSERT INTO `r_dep_pro` VALUES ('10', '3');
INSERT INTO `r_dep_pro` VALUES ('10', '4');
INSERT INTO `r_dep_pro` VALUES ('10', '5');
INSERT INTO `r_dep_pro` VALUES ('10', '6');
INSERT INTO `r_dep_pro` VALUES ('10', '7');
INSERT INTO `r_dep_pro` VALUES ('10', '9');
INSERT INTO `r_dep_pro` VALUES ('10', '10');
INSERT INTO `r_dep_pro` VALUES ('26', '12');
INSERT INTO `r_dep_pro` VALUES ('26', '13');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `e_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `grade` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('10', '8', '6', '75', '一般');
INSERT INTO `score` VALUES ('14', '8', '1', '90', '优秀');
INSERT INTO `score` VALUES ('15', '8', '2', '70', '一般');
INSERT INTO `score` VALUES ('16', '8', '3', '60', '及格');
INSERT INTO `score` VALUES ('17', '8', '4', '65', '及格');
INSERT INTO `score` VALUES ('18', '9', '1', '90', '优秀');
INSERT INTO `score` VALUES ('19', '9', '3', '90', '优秀');
INSERT INTO `score` VALUES ('20', '9', '2', '80', '良好');
INSERT INTO `score` VALUES ('21', '2', '1', '92', '优秀');
INSERT INTO `score` VALUES ('28', '2', '2', '88', '良好');
INSERT INTO `score` VALUES ('29', '2', '2', '87', '良好');
INSERT INTO `score` VALUES ('31', '2', '3', '90', '优秀');
INSERT INTO `score` VALUES ('32', '2', '4', '90', '优秀');
INSERT INTO `score` VALUES ('33', '2', '5', '90', '优秀');
INSERT INTO `score` VALUES ('34', '2', '6', '90', '优秀');
INSERT INTO `score` VALUES ('35', '2', '7', '90', '优秀');
INSERT INTO `score` VALUES ('36', '2', '9', '80', '良好');
INSERT INTO `score` VALUES ('37', '2', '10', '80', '良好');
INSERT INTO `score` VALUES ('38', '2', '9', '80', '良好');
INSERT INTO `score` VALUES ('39', '2', '10', '80', '良好');
INSERT INTO `score` VALUES ('40', '2', '10', '80', '良好');
INSERT INTO `score` VALUES ('41', '6', '0', '90', '优秀');
INSERT INTO `score` VALUES ('42', '6', '0', '90', '优秀');
INSERT INTO `score` VALUES ('43', '8', '5', '90', '优秀');
INSERT INTO `score` VALUES ('44', '8', '7', '90', '优秀');
INSERT INTO `score` VALUES ('45', '8', '9', '90', '优秀');
INSERT INTO `score` VALUES ('46', '48', '0', '80', '良好');
INSERT INTO `score` VALUES ('47', '46', '9', '90', '优秀');
INSERT INTO `score` VALUES ('48', '46', '7', '89', '良好');
INSERT INTO `score` VALUES ('49', '46', '10', '90', '优秀');
INSERT INTO `score` VALUES ('50', '46', '5', '79', '一般');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'abc', '123');
INSERT INTO `user` VALUES ('2', 'admin', '111111');
INSERT INTO `user` VALUES ('3', 'tom', '111');
INSERT INTO `user` VALUES ('4', 'aaa', '111');
INSERT INTO `user` VALUES ('5', 'zzz', '698d51a19d8a121ce581499d7b701668');
INSERT INTO `user` VALUES ('6', 'zzz', '698d51a19d8a121ce581499d7b701668');
INSERT INTO `user` VALUES ('7', 'abc', '202cb962ac59075b964b07152d234b70');

-- ----------------------------
-- View structure for `v_dep_pro`
-- ----------------------------
DROP VIEW IF EXISTS `v_dep_pro`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_dep_pro` AS select `r`.`d_id` AS `d_id`,`d`.`name` AS `d_name`,`r`.`p_id` AS `p_id`,`p`.`name` AS `p_name` from ((`department` `d` left join `r_dep_pro` `r` on((`d`.`id` = `r`.`d_id`))) left join `project` `p` on((`r`.`p_id` = `p`.`id`))) ;

-- ----------------------------
-- View structure for `v_emp_sc`
-- ----------------------------
DROP VIEW IF EXISTS `v_emp_sc`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_emp_sc` AS select `e`.`id` AS `e_id`,`e`.`name` AS `e_name`,`d`.`id` AS `d_id`,`d`.`name` AS `d_name`,`p`.`id` AS `p_id`,`p`.`name` AS `p_name`,`sc`.`id` AS `sc_id`,`sc`.`value` AS `value`,`sc`.`grade` AS `grade` from ((((`employee` `e` left join `department` `d` on((`e`.`d_id` = `d`.`id`))) left join `r_dep_pro` `r` on((`d`.`id` = `r`.`d_id`))) left join `project` `p` on((`r`.`p_id` = `p`.`id`))) left join `score` `sc` on(((`e`.`id` = `sc`.`e_id`) and (`p`.`id` = `sc`.`p_id`)))) ;

-- ----------------------------
-- Procedure structure for `clearGrade`
-- ----------------------------
DROP PROCEDURE IF EXISTS `clearGrade`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `clearGrade`()
BEGIN
	
update score set grade =null;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `setEmpCount`
-- ----------------------------
DROP PROCEDURE IF EXISTS `setEmpCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `setEmpCount`()
BEGIN
DECLARE tId int;
DECLARE tCount int;
DECLARE isLoop int DEFAULT 1;
DECLARE cur cursor for select d.id,count(e.id) from department as d 
left join employee as e  on e.d_id=d.id
GROUP BY d.id;
DECLARE  continue handler  for not found set isLoop=0;
open cur;
while isLoop>0
DO
fetch  cur into tId,tCount;

update department set emp_count=tCount where id=tId;

end while;
close cur;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `setGrade`
-- ----------------------------
DROP PROCEDURE IF EXISTS `setGrade`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `setGrade`()
BEGIN
DECLARE  tGrade VARCHAR(50);
DECLARE  tId int;
DECLARE  tValue int;
DECLARE  isLoop int DEFAULT 1; 
DECLARE  cur cursor for select id,value from score;
DECLARE  continue HANDLER  for not found set isLoop=0;

open cur;

while isLoop>0
do
fetch cur into tId,tValue;
if tValue>=90
then 
set tGrade='优秀';  
elseif tValue>=80
then 
set tGrade='良好';
elseif tValue>=70
then 
set tGrade='一般';
elseif tValue>=60
then 
set tGrade='及格';
else 
set tGrade='不及格';
end if;
update score set grade=tGrade where id=tid;

end while;

close cur;

END
;;
DELIMITER ;
