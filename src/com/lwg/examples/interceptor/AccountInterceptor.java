package com.lwg.examples.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AccountInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		System.out.println("Before action invoking");
		inv.invoke();
		System.out.println("After action invoking");
	}

}
