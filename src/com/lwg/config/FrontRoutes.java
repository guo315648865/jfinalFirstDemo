package com.lwg.config;

import com.jfinal.config.Routes;
import com.lwg.examples.controller.EmployeeController;

public class FrontRoutes extends Routes{

	@Override
	public void config() {
		this.setBaseViewPath("/front/examples");
		add("/employee",EmployeeController.class);
	}

}
