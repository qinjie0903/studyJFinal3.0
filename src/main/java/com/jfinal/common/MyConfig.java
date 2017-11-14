package com.jfinal.common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.route.AdminRoute;
import com.jfinal.route.FrontRoute;
import com.jfinal.template.Engine;

/**
* <p>Title: MyConfig</p>
* <p>Description: Jfinal配置文件</p>
* <p>Company: Talk is cheap.Show me code.</p> 
* @author qinjie
* @date Oct 29, 2017 10:21:57 PM
*/
public class MyConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);//开发模式
	}

	@Override
	public void configEngine(Engine me) {
		//模板引擎配置 Jfinal3.0新增
	}

	@Override
	public void configHandler(Handlers me) {
		
	}

	@Override
	public void configInterceptor(Interceptors me) {
		
	}

	@Override
	public void configPlugin(Plugins me) {
		
	}

	@Override
	public void configRoute(Routes me) {
		
		//4.Route的基本使用
		//me.add("/",IndexController.class);
		
		//5.Route路由的分包技法
		//me.add("/", IndexController.class, "/abc");
		//me.add("/blog", BlogController.class, "/blog");
		//me.add("/user", UserController.class, "/user");
		
		me.add(new FrontRoute());
		me.add(new AdminRoute());
		
		
		
	}
	
	public static void main(String[] me) {
		JFinal.start("src/main/webapp",80,"/",5);
	}

	@Override
	public void afterJFinalStart() {
		System.out.println("---afterJFinalStart---");
	}

	@Override
	public void beforeJFinalStop() {
		System.out.println("---beforeJFinalStop---");
	}
	
}