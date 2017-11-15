package com.jfinal.route;

import com.jfinal.config.Routes;
import com.jfinal.controller.IndexController;
import com.jfinal.interceptor.FrontRouteInterceptor;

/**
* <p>Title: FrontRoute</p>
* <p>Description: 前台路由配置</p>
* <p>Company: Talk is cheap.Show me code.</p> 
* @author qinjie
* @date Oct 29, 2017 10:22:24 PM
*/

public class FrontRoute extends Routes {

	@Override
	public void config() {
		setBaseViewPath("/front");//前端的页面放在/front路径下
		addInterceptor(new FrontRouteInterceptor());
		add("/", IndexController.class);
	}

}
