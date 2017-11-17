package com.lwg.examples.interceptor;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class AccountValidator extends Validator{
	/**
	 * 在校验失败是调用
	 */
	@Override
	protected void handleError(Controller con) {
		// TODO Auto-generated method stub
		con.keepPara("account.name");//将值再传回页面，保证原先输入的值
		con.keepPara("account.email");
		con.render("../../examples/add.html");
	}

	@Override
	protected void validate(Controller arg0) {
		// TODO Auto-generated method stub
		validateRequiredString("account.name"/*验证表单域的name*/, "accName"/*返回信息key*/, "请输入姓名"/*返回信息value*/);
		validateRequiredString("account.email"/*验证表单域的name*/, "accEmail"/*返回信息key*/, "请输入邮箱"/*返回信息value*/);
	}

}
