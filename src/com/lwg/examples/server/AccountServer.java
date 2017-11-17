package com.lwg.examples.server;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.lwg.examples.model.Account;

public class AccountServer {
	//配置事物拦截
	@Before(Tx.class)
	public void saveAccount(Account acc) throws Exception{
		acc.save();
		throw new Exception();
	}
	
	public void testAcc(){
		Account.dao.deleteById(23);//删除id为23的数据
		Account acc=Account.dao.findByIdLoadColumns(23, "name,age");//查询ID为23 的数据 取 name,age字段
		Account.dao.paginate(1, 10, "select *", "from user where age>?", 18);//分页查询
		
		//Db+record模式
		Db.deleteById("user", 22);//删除user表中22的数据
		Record accdb=Db.findById("account", 22).set("name", "123");
		Db.update("account", accdb);//查询account中的22的数据,并修改
		accdb=new Record().set("name", "111").set("age", 123);
		Db.save("account", accdb);//为表 account添加数据
	}
}
