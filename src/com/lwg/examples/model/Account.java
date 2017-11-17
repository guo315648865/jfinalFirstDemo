package com.lwg.examples.model;

import com.jfinal.plugin.activerecord.Model;
/**
 * CREATE TABLE `security_account` (
  `id` varchar(100) CHARACTER SET gbk NOT NULL,
  `name` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `login_name` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `password` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL COMMENT '盐值',
  `last_login_time` datetime DEFAULT NULL,
  `employee_id` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `status` varchar(10) CHARACTER SET gbk DEFAULT NULL,
  `is_system` varchar(10) CHARACTER SET gbk DEFAULT NULL,
  `type` varchar(10) CHARACTER SET gbk DEFAULT NULL,
  `enabled` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `order_no` decimal(11,0) DEFAULT NULL,
  `email` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `mobile` varchar(50) CHARACTER SET gbk DEFAULT NULL,
  `nick_name` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `recorder` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `record_date` datetime DEFAULT NULL,
  `modifier` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `sdsd` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `parent` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET gbk DEFAULT NULL,
  `data_source` varchar(10) CHARACTER SET gbk DEFAULT NULL,
  `is_master` varchar(10) CHARACTER SET gbk DEFAULT NULL,
*`is_secgroup` varchar(10) CHARACTER SET gbk DEFAULT '0',
* `cas_id` varchar(100) DEFAULT NULL,
*  `pwd` varchar(100) DEFAULT NULL,
*  PRIMARY KEY (`id`)
*) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * 用户表
 * @author LWG
 *
 */
public class Account extends Model<Account>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1032568972646937183L;
	
	public static final Account dao=new Account();
}
