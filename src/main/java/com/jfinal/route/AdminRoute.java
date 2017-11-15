package com.jfinal.route;

import com.jfinal.config.Routes;
import com.jfinal.controller.AdminController;
import com.jfinal.interceptor.AdminRouteInterceptor;

/**
* <p>Title: AdminRoute</p>
* <p>Description: 后台路由配置</p>
* <p>Company: Talk is cheap.Show me code.</p> 
* @author qinjie
* @date Oct 29, 2017 10:22:05 PM
*/
public class AdminRoute extends Routes{

	@Override
	public void config() {
		setBaseViewPath("/WEB-INF");
		addInterceptor(new AdminRouteInterceptor());
		add("/admin", AdminController.class);
	}

}
