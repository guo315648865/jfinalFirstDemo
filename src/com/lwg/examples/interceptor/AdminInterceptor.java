package com.lwg.examples.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AdminInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		System.out.println("=============调用后台方法开始============");
		inv.invoke();
		System.out.println("=============调用后台方法结束============");
	}

}
