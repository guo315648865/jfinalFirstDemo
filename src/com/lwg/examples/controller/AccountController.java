package com.lwg.examples.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Duang;
import com.jfinal.aop.Enhancer;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.lwg.examples.interceptor.AccountInterceptor;
import com.lwg.examples.interceptor.AccountValidator;
import com.lwg.examples.model.Account;
import com.lwg.examples.server.AccountServer;

public class AccountController extends Controller{
	@Clear//清除自身以上拦截
	@Before(AccountInterceptor.class)
	public void index(){
		List<Account> list=Account.dao.find("select * from security_account");
		setAttr("accountList",list);
		System.out.println(list.size()+"-----------"+getParaToInt());
		render("/examples/index.html");
	}
	public void index2(){
		setAttr("template", "template:你好");
		render("/examples/template.html");
	}
	public void add(){
		render("add.html");
	}
	public void delete(){
		String id=getPara("id");//获取id,  或者  getParaToInt获取第一个参数
		Account.dao.deleteById(id);//删除
		forwardAction("/examples/account");
	}
	
	public void update(){
		Account acc=getModel(Account.class);//把表单封装成对象
		acc.update();
		forwardAction("/examples/account");
	}
	
	public void get(){
		System.out.println("--------------");
		Account acc=Account.dao.findById(getPara("id"));
		setAttr("account", acc);
		render("/examples/index2.html");
	}
	@Before(AccountValidator.class)
	public void save(){
		//注意页面的表单 name属性account.name 中的account必须与类名一样 首字母小写；如果不一样 如使用otheName.name,则使用 getModel(Account.class,"otheName")
		//如果希望account.name中的account 省略  可以 getModel(Blog.class, ""); 
		Account acc=getModel(Account.class);//把表单封装成对象
		acc.set("id", 2);//oracle设置序列  acc.set("id", "mysequence.nextval").
		//acc.save();
		AccountServer accServer=enhance(AccountServer.class);
		//或者下面 功能效果一样
		//AccountServer accServer=Duang.duang(AccountServer.class);
		//AccountServer accServer=Enhancer.enhance(AccountServer.class);
		//AccountServer accServer=Enhancer.enhance(AccountServer.class,Tx.class);//此时AccountServer中方法可以不用@Before(TX.class)
		try {
			accServer.saveAccount(acc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		forwardAction("/examples/account");
	}
}
