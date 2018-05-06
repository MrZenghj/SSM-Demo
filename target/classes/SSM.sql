SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_user
-- 系统用户表
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
 `id` varchar(50) NOT NULL COMMENT '用户Id',
 `name` varchar(50) NOT NULL COMMENT '名字',
 `password` varchar(50) NOT NULL COMMENT '密码',
 `user_number` varchar(20) DEFAULT NULL COMMENT '员工编号',
 `dept` varchar(100) DEFAULT NULL COMMENT '所属部门',
 `position` varchar(100) DEFAULT NULL COMMENT '职位',
 `phone_number` varchar(11) DEFAULT NULL COMMENT '手机号',
 `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
 `sex` int(11) DEFAULT NULL COMMENT '性别(0:代表男 1:代表女)',
 `birthday` datetime DEFAULT NULL COMMENT '生日',
 `address` varchar(255) DEFAULT NULL COMMENT '居住地址',
 `status` int(11) DEFAULT NULL COMMENT '人员状态：1.已激活、2.未激活、3.已禁用、4.未分配部门、5.离职、',
 `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 `modifyer` varchar(50) DEFAULT NULL COMMENT '修改人',
 `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

SET FOREIGN_KEY_CHECKS=0;

-- -----------------------------
-- Table structure for sys_role
-- 系统角色表（类似组 一个角色为一个组 即角色组）
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
 `role_id` varchar(50) NOT NULL COMMENT '角色主键id',
 `role_name` varchar(150) DEFAULT NULL COMMENT '角色名称',
 `descript` varchar(128) DEFAULT NULL COMMENT '描述',
 `creater_id` varchar(50) DEFAULT NULL COMMENT '创建者id',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 `modifyer` varchar(50) DEFAULT NULL COMMENT '修改者id',
 `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
 PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- 系统权限表
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
 `permission_id` varchar(50) NOT NULL COMMENT '权限主键id',
 `parent_id` varchar(50) DEFAULT NULL,
 `url` varchar(150) DEFAULT NULL,
 `descritp` varchar(128) DEFAULT NULL COMMENT '权限描述',
 `status` int(11) DEFAULT NULL COMMENT '有效：1；无效：0',
 `creater_id` varchar(50) DEFAULT NULL COMMENT '创建者id',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 `modifyer_id` varchar(50) DEFAULT NULL COMMENT '修改者id',
 `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
 PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_role_permission
-- 系统角色权限表
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
 `id` varchar(50) NOT NULL COMMENT '主键',
 `role_id` varchar(50) DEFAULT NULL COMMENT '角色主键ID',
 `permission_id` varchar(50) DEFAULT NULL COMMENT '权限主键ID',
 `creater_id` varchar(50) DEFAULT NULL COMMENT '创建者id',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 `modifyer_id` varchar(50) DEFAULT NULL COMMENT '修改者id',
 `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user_role
-- 用户角色表
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
 `id` varchar(50) NOT NULL COMMENT '主键',
 `creater_id` varchar(50) DEFAULT NULL COMMENT '创建者id',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 `modifyer_id` varchar(50) DEFAULT NULL COMMENT '修改者id',
 `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
 `user_id` varchar(50) DEFAULT NULL COMMENT '用户的主键ID',
 `role_id` varchar(50) DEFAULT NULL COMMENT '所属角色主键ID',
 `name`  varchar(50) DEFAULT NULL COMMENT '管理员名称',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

