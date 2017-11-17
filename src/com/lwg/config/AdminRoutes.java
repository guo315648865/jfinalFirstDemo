package com.lwg.config;

import com.jfinal.config.Routes;
import com.lwg.examples.controller.AccountController;
import com.lwg.examples.interceptor.AdminInterceptor;

public class AdminRoutes extends Routes{
	
	@Override
	public void config() {
		this.setBaseViewPath("/examples");//设计controller返回时页面基本路劲，并不是controller的基本访问路劲；下面的add()方法第三个参数必须设计"/"，且controller返回时不带/才有效
		addInterceptor(new AdminInterceptor());
		add("/examples/account", AccountController.class,"/");
		System.out.println("-----aaa-6666666666-bbbbb-");
	}

}
