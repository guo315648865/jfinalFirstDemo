package com.lwg.examples.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * CREATE TABLE `security_employee` (
  `id` varchar(40) CHARACTER SET gbk NOT NULL,
  `name` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `code` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `comp_id` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `dept_id` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `station_names` varchar(500) CHARACTER SET gbk DEFAULT NULL,
  `account_id` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `pinyin` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `description` varchar(4000) CHARACTER SET gbk DEFAULT NULL,
  `is_system` char(1) CHARACTER SET gbk DEFAULT NULL,
  `order_no` decimal(11,0) DEFAULT NULL,
  `enabled` char(1) CHARACTER SET gbk DEFAULT NULL,
  `work_card` varchar(50) CHARACTER SET gbk DEFAULT NULL,
  `sex` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `office_phone` varchar(50) CHARACTER SET gbk DEFAULT NULL,
  `ploitical` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `education` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `email` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `mobile` varchar(50) CHARACTER SET gbk DEFAULT NULL,
  `recorder` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `record_date` date DEFAULT NULL,
  `modifier` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `modify_date` date DEFAULT NULL,
  `parent_employee_id` varchar(40) CHARACTER SET gbk DEFAULT NULL,
  `data_source` varchar(10) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`id`)
)
 * 员工表
 * @author LWG
 *
 */
public class Employee extends Model<Employee>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7150006930819798693L;
	
	public static final Employee dao=new Employee();
	
	/**
	 * 根据 员工表中的用户ID 获取用户信息
	 * @return
	 */
	public Account getAccount(){
		return Account.dao.findById(this.get("account_id"));
	}
	
}
